package service;

import enums.StatusPartida;
import enums.TipoJogada;
import model.Casa;
import model.Tabuleiro;
import persistence.PartidaRepository;
import persistence.TabuleiroRepository;
import ui.Menu;
import ui.MenuPartida;
import ui.InterfaceUsuario;
import ui.InterfaceApresentacao;

import java.sql.SQLException;

public class JogoSudoku {

    private Tabuleiro tabuleiro;
    private Long tabuleiroId;
    private Long partidaId;
    private boolean partidaSalva;
    private final Menu menu;
    private final MenuPartida menuPartida;
    private final InterfaceApresentacao interfaceApresentacao;
    private final InterfaceUsuario interfaceUsuario;
    private final TabuleiroRepository tabuleiroRepository = new TabuleiroRepository();
    private final PartidaRepository partidaRepository = new PartidaRepository();

    public JogoSudoku(InterfaceUsuario interfaceUsuario,
                      InterfaceApresentacao interfaceApresentacao) {

        this.tabuleiro = new Tabuleiro();
        this.menu = new Menu();
        this.menuPartida = new MenuPartida();

        this.interfaceUsuario = interfaceUsuario;
        this.interfaceApresentacao = interfaceApresentacao;

    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    // Fluxo principal
    public void iniciar() {
        executarMenuPrincipal();

    }

    // Menus
    private void executarMenuPrincipal() {

        boolean executando = true;

        while (executando) {

            menu.exibir();

            int opcao = interfaceUsuario.lerOpcaoMenu();

            switch (opcao) {

                case 0 -> {
                    executando = false;
                    interfaceApresentacao.exibirEncerramento();
                }

                case 1 -> iniciarNovaPartida();

                case 2 -> {

                    try {

                        partidaId = partidaRepository.buscarUltimaPartida();

                        if (partidaId == null) {

                            interfaceApresentacao.exibirErro("Não existe uma partida salva.");

                        } else {

                            tabuleiroId = partidaRepository.buscarTabuleiroId(partidaId);

                            tabuleiro = partidaRepository.carregarPartida(partidaId);

                            partidaSalva = true;

                            interfaceApresentacao.exibirTabuleiro(tabuleiro);

                            executarMenuPartida();
                        }

                    } catch (SQLException e) {

                        interfaceApresentacao.exibirErro("Erro ao carregar partida.");
                    }
                }
            }
        }
    }

    private void executarMenuPartida() {

        boolean executando = true;

        while (executando) {

            menuPartida.exibir();

            int opcao = interfaceUsuario.lerOpcaoMenuPartida();

            switch (opcao) {

                case 1 -> executarPartida();

                case 2 -> salvarPartida();

                case 3 -> {
                    interfaceApresentacao.exibirSolicitacaoRemocao();
                    boolean remover = interfaceUsuario.lerConfirmacao();

                    if (remover) {
                        interfaceApresentacao.exibirSolicitacaoCoordenada();

                        String coordenada = interfaceUsuario.lerCoordenada();

                        int[] posicao = converterCoordenada(coordenada);
                        int linha = posicao[0]; int coluna = posicao[1];

                        removerJogada(linha, coluna);

                        interfaceApresentacao.exibirJogadaRemovida();
                    }
                }

                case 4 -> {

                    interfaceApresentacao.exibirSolicitacaoLimparJogadas();

                    boolean desejaLimparJogadas = interfaceUsuario.lerConfirmacao();

                    if (desejaLimparJogadas) {

                        interfaceApresentacao.exibirConfirmacaoLimparJogadas();

                        boolean confirmarLimpeza = interfaceUsuario.lerConfirmacao();

                        if (confirmarLimpeza) {

                            limparJogadas();

                            interfaceApresentacao.exibirJogadasRemovidas();
                        }
                    }
                }

                case 5 -> interfaceApresentacao.exibirStatusPartida(verificarStatusPartida());

                case 0 -> executando = false;
            }
        }
    }

    // Fluxo da partida
    private void iniciarNovaPartida() {

        try {

            tabuleiroId = tabuleiroRepository.salvar(tabuleiro);

            partidaId = partidaRepository.salvar(
                    tabuleiroId,
                    tabuleiro
            );

            partidaSalva = false;

            interfaceApresentacao.exibirTabuleiro(tabuleiro);

            executarMenuPartida();

        } catch (SQLException e) {

            interfaceApresentacao.exibirErro(
                    "Não foi possível iniciar a partida."
            );
        }
    }

    private void executarPartida() {

        interfaceApresentacao.exibirSolicitacaoCoordenada();

        String coordenada = interfaceUsuario.lerCoordenada();

        int[] posicao = converterCoordenada(coordenada);

        int linha = posicao[0];
        int coluna = posicao[1];

        interfaceApresentacao.exibirSolicitacaoNumero();

        Jogada jogada = interfaceUsuario.lerJogada();

        executarJogada(linha,coluna,jogada);

        StatusPartida status = verificarStatusPartida();

        if (status == StatusPartida.COMPLETA_VALIDA) {

            interfaceApresentacao.exibirStatusPartida(status);
        }
    }

    private void salvarPartida() {

        try {

            if (partidaId == null) {

                interfaceApresentacao.exibirErro("Não existe uma partida para salvar.");

                return;
            }

            if (partidaSalva) {

                interfaceApresentacao.exibirSolicitacaoSobrescrita();

                boolean confirmarSobrescrita = interfaceUsuario.lerConfirmacao();

                if (!confirmarSobrescrita) {

                    return;
                }
            }

            partidaRepository.sobrescrever(
                    partidaId,
                    tabuleiroId,
                    tabuleiro
            );

            interfaceApresentacao.exibirPartidaSalva();

            partidaSalva = true;

        } catch (SQLException e) {

            interfaceApresentacao.exibirErro( "Não foi possível salvar a partida.");
        }
    }

    public void executarJogada (int linha,
                                 int coluna,
                                 Jogada jogada) {

        try {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            if (jogada.tipo() == TipoJogada.DEFINITIVA) {

                casa.preencher(jogada.numero());

            } else {

                boolean resultado = casa.alternarCandidato(jogada.numero());

                if (resultado) {

                    interfaceApresentacao.exibirCandidatoAdicionado(jogada.numero());

                } else {

                    interfaceApresentacao.exibirCandidatoRemovido(jogada.numero());
                }

            }

            interfaceApresentacao.exibirTabuleiro(tabuleiro);

        } catch (IllegalArgumentException e) {

            interfaceApresentacao.exibirErro(e.getMessage());
        }

    }

    private void removerJogada(int linha,
                               int coluna) {

        try {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            casa.removerNumero();

            interfaceApresentacao.exibirTabuleiro(tabuleiro);

        } catch (IllegalArgumentException e) {

            interfaceApresentacao.exibirErro(e.getMessage());

        }

    }

    private void limparJogadas() {

        tabuleiro.limparJogadas();

        interfaceApresentacao.exibirTabuleiro(tabuleiro);

    }

    private StatusPartida verificarStatusPartida() {
        
        if (tabuleiro.possuiCasasVazias()) {

            return StatusPartida.INCOMPLETA;

        }

        if (tabuleiro.possuiErrosNasLinhas()
                || tabuleiro.possuiErrosNasColunas()
                || tabuleiro.possuiErrosNosBlocos()) {

            return StatusPartida.COMPLETA_INVALIDA;

        }

        return StatusPartida.COMPLETA_VALIDA;

    }

    private int[] converterCoordenada(String coordenada) {

        char letra = coordenada.charAt(0);
        char numero = coordenada.charAt(1);

        int coluna = Integer.parseInt(String.valueOf(numero)) - 1;

        int linha = letra - 'A';

        return new int[]{linha, coluna};

    }

}
