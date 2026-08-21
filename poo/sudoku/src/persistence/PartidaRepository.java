package persistence;

import model.Casa;
import model.Tabuleiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidaRepository {

    private static final String SQL_INSERT_PARTIDA =
            """
            INSERT INTO partida (tabuleiro_id)
            VALUES (?)
            """;

    private static final String SQL_INSERT_ESTADO_CASA =
            """
            INSERT INTO estado_casa (
                tabuleiro_id,
                partida_id,
                casa_id,
                numero_jogado
            )
            VALUES (?, ?, ?, ?)
            """;

    private static final String SQL_INSERT_CANDIDATO =
            """
            INSERT INTO candidato (
                estado_casa_id,
                numero
            )
            VALUES (?, ?)
            """;

    private static final String SQL_BUSCAR_CASA_ID =
            """
            SELECT id
            FROM casa
            WHERE tabuleiro_id = ?
                AND linha = ?
                AND coluna = ?
            """;

    private static final String SQL_BUSCAR_TABULEIRO_ID =
            """
            SELECT tabuleiro_id
            FROM partida
            WHERE id = ?
            """;

    private static final String SQL_BUSCAR_CASAS =
            """
            SELECT
                id,
                linha,
                coluna,
                numero_inicial,
                fixa
            FROM casa
            WHERE tabuleiro_id = ?
            ORDER BY linha, coluna
            """;

    private static final String SQL_BUSCAR_ESTADO_CASA =
            """
            SELECT
                ec.casa_id,
                ec.numero_jogado,
                c.linha,
                c.coluna
            FROM estado_casa ec
            JOIN casa c
                ON ec.tabuleiro_id = c.tabuleiro_id
                AND ec.casa_id = c.id
            WHERE ec.partida_id = ?
              AND ec.tabuleiro_id = ?
            """;

    private static final String SQL_BUSCAR_CANDIDATOS =
            """
            SELECT
                ec.casa_id,
                c.linha,
                c.coluna,
                ca.numero
            FROM candidato ca
            JOIN estado_casa ec
                ON ca.estado_casa_id = ec.id
            JOIN casa c
                ON ec.tabuleiro_id = c.tabuleiro_id
                AND ec.casa_id = c.id
            WHERE ec.partida_id = ?
              AND ec.tabuleiro_id = ?
            ORDER BY c.linha, c.coluna, ca.numero
            """;

    private static final String SQL_BUSCAR_ULTIMA_PARTIDA =
            """
            SELECT id
            FROM partida
            ORDER BY id DESC
            LIMIT 1
            """;

    private static final String SQL_DELETE_CANDIDATOS =
            """
            DELETE FROM candidato
            WHERE estado_casa_id IN (
                SELECT id
                FROM estado_casa
                WHERE partida_id = ?
            )
            """;

    private static final String SQL_DELETE_ESTADOS_CASAS =
            """
            DELETE FROM estado_casa
            WHERE partida_id = ?
            """;

    public Long buscarTabuleiroId(long partidaId) throws SQLException {

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement =
                     conexao.prepareStatement(SQL_BUSCAR_TABULEIRO_ID)) {

            statement.setLong(1, partidaId);

            try (ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getLong("tabuleiro_id");
                }

                return null;
            }
        }
    }

    public List<Casa> buscarCasas(long tabuleiroId) throws SQLException {

        List<Casa> casas = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement =
                     conexao.prepareStatement(SQL_BUSCAR_CASAS)) {
            statement.setLong(1, tabuleiroId);

            try (ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {

                    int linha = resultado.getInt("linha");
                    int coluna = resultado.getInt("coluna");

                    Integer numeroInicial = (Integer) resultado.getObject("numero_inicial");

                    boolean fixa = resultado.getBoolean("fixa");

                    Casa casa = new Casa(
                            linha - 1,
                            coluna - 1,
                            numeroInicial,
                            fixa
                    );

                    casas.add(casa);
                }
            }
        }

        return casas;
    }

    private void restaurarEstadoCasas(
            Connection conexao,
            long partidaId,
            long tabuleiroId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (PreparedStatement statement = conexao.prepareStatement(SQL_BUSCAR_ESTADO_CASA)) {

            statement.setLong(1, partidaId);
            statement.setLong(2, tabuleiroId);

            try (ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {

                    int linha = resultado.getInt("linha");
                    int coluna = resultado.getInt("coluna");

                    Integer numeroJogado =
                            (Integer) resultado.getObject("numero_jogado");

                    if (numeroJogado != null) {

                        Casa casa =
                                tabuleiro.getCasa(linha - 1, coluna - 1);

                        casa.preencher(numeroJogado);
                    }
                }
            }
        }
    }

    private void restaurarCandidatos(
            Connection conexao,
            long partidaId,
            long tabuleiroId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (PreparedStatement statement =
                     conexao.prepareStatement(SQL_BUSCAR_CANDIDATOS)) {

            statement.setLong(1, partidaId);
            statement.setLong(2, tabuleiroId);

            try (ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {

                    int linha = resultado.getInt("linha");
                    int coluna = resultado.getInt("coluna");
                    int numero = resultado.getInt("numero");

                    Casa casa =
                            tabuleiro.getCasa(linha - 1, coluna - 1);

                    casa.alternarCandidato(numero);
                }
            }
        }
    }

    public long salvar(
            long tabuleiroId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (Connection conexao = ConnectionFactory.getConnection()) {

            try {

                conexao.setAutoCommit(false);

                long partidaId = salvarPartida(conexao, tabuleiroId);

                salvarEstadosCasas(
                        conexao,
                        tabuleiroId,
                        partidaId,
                        tabuleiro
                );

                conexao.commit();

                return partidaId;

            } catch (SQLException e) {

                conexao.rollback();

                throw e;

            } finally {

                conexao.setAutoCommit(true);
            }
        }
    }

    public void sobrescrever(
            long partidaId,
            long tabuleiroId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (Connection conexao = ConnectionFactory.getConnection()) {

            try {

                conexao.setAutoCommit(false);

                excluirCandidatos(conexao, partidaId);

                excluirEstadosCasas(conexao, partidaId);

                salvarEstadosCasas(
                        conexao,
                        tabuleiroId,
                        partidaId,
                        tabuleiro
                );

                conexao.commit();

            } catch (SQLException e) {

                conexao.rollback();

                throw e;
            } finally {

                conexao.setAutoCommit(true);
            }
        }
    }

    private void excluirCandidatos(
            Connection conexao,
            long partidaId
    ) throws SQLException {

        try (PreparedStatement statement =
                conexao.prepareStatement(SQL_DELETE_CANDIDATOS)) {

            statement.setLong(1, partidaId);

            statement.executeUpdate();

        }

    }

    private void excluirEstadosCasas(
            Connection conexao,
            long partidaId
    ) throws SQLException {

        try (PreparedStatement statement =
                conexao.prepareStatement(SQL_DELETE_ESTADOS_CASAS)) {

            statement.setLong(1, partidaId);

            statement.executeUpdate();
        }
    }

    private long salvarPartida(
            Connection conexao,
            long tabuleiroId
    ) throws SQLException {

        try (PreparedStatement statement =
                     conexao.prepareStatement(
                             SQL_INSERT_PARTIDA,
                             Statement.RETURN_GENERATED_KEYS
                     )) {

            statement.setLong(1, tabuleiroId);

            statement.executeUpdate();

            try (ResultSet resultado = statement.getGeneratedKeys()) {

                if (resultado.next()) {
                    return resultado.getLong(1);
                }

                throw new SQLException(
                        "Não foi possível recuperar o ID da partida."
                );
            }
        }
    }

    private void salvarEstadosCasas(
            Connection conexao,
            long tabuleiroId,
            long partidaId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (PreparedStatement statementEstadoCasa =
                     conexao.prepareStatement(
                             SQL_INSERT_ESTADO_CASA,
                             Statement.RETURN_GENERATED_KEYS
                     )) {

            for (int linha = 0; linha < 9; linha++) {

                for (int coluna = 0; coluna < 9; coluna++) {

                    Casa casa = tabuleiro.getCasa(linha, coluna);

                    if (casa.isFixa()) {
                        continue;
                    }

                    if (casa.estaVazia()
                            && casa.getCandidatos().isEmpty()) {
                        continue;
                    }

                    long casaId = buscarCasaId(
                            conexao,
                            tabuleiroId,
                            casa
                    );

                    statementEstadoCasa.setLong(1, tabuleiroId);
                    statementEstadoCasa.setLong(2, partidaId);
                    statementEstadoCasa.setLong(3, casaId);
                    statementEstadoCasa.setObject(
                            4,
                            casa.getNumero()
                    );

                    statementEstadoCasa.executeUpdate();

                    long estadoCasaId =
                            recuperarEstadoCasaId(statementEstadoCasa);

                    salvarCandidatos(
                            conexao,
                            estadoCasaId,
                            casa
                    );
                }
            }
        }
    }

    private long buscarCasaId(
            Connection conexao,
            long tabuleiroId,
            Casa casa
    ) throws SQLException {

        try (PreparedStatement statement =
                     conexao.prepareStatement(SQL_BUSCAR_CASA_ID)) {

            statement.setLong(1, tabuleiroId);
            statement.setInt(2, casa.getLinha() + 1);
            statement.setInt(3, casa.getColuna() + 1);

            try (ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getLong("id");
                }

                throw new SQLException(
                        "Casa não encontrada para a posição "
                                + "("
                                + casa.getLinha()
                                + ", "
                                + casa.getColuna()
                                + ")."
                );
            }
        }
    }

    private long recuperarEstadoCasaId(
            PreparedStatement statement
    ) throws SQLException {

        try (ResultSet resultado = statement.getGeneratedKeys()) {

            if (resultado.next()) {
                return resultado.getLong(1);
            }

            throw new SQLException(
                    "Não foi possível recuperar o ID do estado da casa."
            );
        }
    }

    public Tabuleiro carregarPartida(long partidaId) throws SQLException {

        Long tabuleiroId = buscarTabuleiroId(partidaId);

        if (tabuleiroId == null) {
            return null;
        }

        List<Casa> casas = buscarCasas(tabuleiroId);

        Tabuleiro tabuleiro = new Tabuleiro(casas);

        try (Connection conexao = ConnectionFactory.getConnection()) {

            restaurarEstadoCasas(
                    conexao,
                    partidaId,
                    tabuleiroId,
                    tabuleiro
            );

            restaurarCandidatos(
                    conexao,
                    partidaId,
                    tabuleiroId,
                    tabuleiro
            );
        }

        return tabuleiro;
    }

    public Long buscarUltimaPartida() throws SQLException {

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement =
                     conexao.prepareStatement(SQL_BUSCAR_ULTIMA_PARTIDA)) {

            try (ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getLong("id");
                }

                return null;
            }
        }
    }

    private void salvarCandidatos(
            Connection conexao,
            long estadoCasaId,
            Casa casa
    ) throws SQLException {

        if (casa.getCandidatos().isEmpty()) {
            return;
        }

        try (PreparedStatement statement =
                     conexao.prepareStatement(SQL_INSERT_CANDIDATO)) {

            for (Integer candidato : casa.getCandidatos()) {

                statement.setLong(1, estadoCasaId);
                statement.setInt(2, candidato);

                statement.executeUpdate();
            }
        }
    }

}
