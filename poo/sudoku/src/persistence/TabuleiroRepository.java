package persistence;

import model.Casa;
import model.Tabuleiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TabuleiroRepository {

    private static final String SQL_INSERT =
            "INSERT INTO tabuleiro DEFAULT VALUES";

    private static final String SQL_INSERT_CASA =
            """
            INSERT INTO casa (
                tabuleiro_id,
                linha,
                coluna,
                numero_inicial,
                fixa
            )
            VALUES (?, ?, ?, ?, ?)
            """;

    public long salvar(Tabuleiro tabuleiro) throws SQLException {

        try (Connection conexao = ConnectionFactory.getConnection()) {

            try {

                conexao.setAutoCommit(false);

                long tabuleiroId = salvarTabuleiro(conexao);

                salvarCasas(conexao, tabuleiroId, tabuleiro);

                conexao.commit();

                return tabuleiroId;

            } catch (SQLException e) {

                conexao.rollback();

                throw e;

            } finally {

                conexao.setAutoCommit(true);
            }
        }
    }

    private long salvarTabuleiro(Connection conexao) throws SQLException {

        try (PreparedStatement statement = conexao.prepareStatement(
                SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.executeUpdate();

            try (ResultSet resultado = statement.getGeneratedKeys()) {

                if (resultado.next()) {
                    return resultado.getLong(1);
                }

                throw new SQLException(
                        "Não foi possível recuperar o ID do tabuleiro."
                );
            }
        }
    }

    private void salvarCasas(
            Connection conexao,
            long tabuleiroId,
            Tabuleiro tabuleiro
    ) throws SQLException {

        try (PreparedStatement statement =
                     conexao.prepareStatement(SQL_INSERT_CASA)) {

            for (int linha = 0; linha < 9; linha++) {
                for (int coluna = 0; coluna < 9; coluna++) {

                    Casa casa = tabuleiro.getCasa(linha, coluna);

                    statement.setLong(1, tabuleiroId);

                    statement.setInt(2, casa.getLinha() + 1);
                    statement.setInt(3, casa.getColuna() + 1);

                    statement.setObject(4, casa.getNumero());
                    statement.setBoolean(5, casa.isFixa());

                    statement.executeUpdate();
                }
            }
        }
    }
}
