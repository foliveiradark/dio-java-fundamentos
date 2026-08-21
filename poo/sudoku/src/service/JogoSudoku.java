package service;

import enums.StatusPartida;
import enums.TipoJogada;
import model.Casa;
import model.Tabuleiro;
import persistence.PartidaRepository;
import persistence.TabuleiroRepository;
import ui.ConsoleInput;
import ui.Menu;
import ui.ConsolePrinter;
import ui.MenuPartida;

import java.sql.SQLException;

public class JogoSudoku {

    private Tabuleiro tabuleiro;
    private Long tabuleiroId;
    private Long partidaId;
    private boolean partidaSalva;
    private final Menu menu;
    private final MenuPartida menuPartida;
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleInput consoleInput = new ConsoleInput(consolePrinter);
    private final TabuleiroRepository tabuleiroRepository = new TabuleiroRepository();
    private final PartidaRepository partidaRepository = new PartidaRepository();

    public JogoSudoku() {

        this.tabuleiro = new Tabuleiro();
        this.menu = new Menu();
        this.menuPartida = new MenuPartida();

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

            int opcao = consoleInput.lerOpcaoMenu();

            switch (opcao) {

                case 0 -> {
                    executando = false;
                    consolePrinter.imprimirEncerramento();
                }

                case 1 -> iniciarNovaPartida();

                case 2 -> {

                    try {

                        partidaId = partidaRepository.buscarUltimaPartida();

                        if (partidaId == null) {

                            consolePrinter.imprimirErro("Não existe uma partida salva.");

                        } else {

                            tabuleiroId = partidaRepository.buscarTabuleiroId(partidaId);

                            tabuleiro = partidaRepository.carregarPartida(partidaId);

                            partidaSalva = true;

                            consolePrinter.imprimir(tabuleiro);

                            executarMenuPartida();
                        }

                    } catch (SQLException e) {

                        consolePrinter.imprimirErro("Erro ao carregar partida.");
                    }
                }
            }
        }
    }

    private void executarMenuPartida() {

        boolean executando = true;

        while (executando) {

            menuPartida.exibir();

            int opcao = consoleInput.lerOpcaoMenuPartida();

            switch (opcao) {

                case 1 -> executarPartida();

                case 2 -> salvarPartida();

                case 3 -> {
                    consolePrinter.imprimirSolicitacaoRemocao();
                    boolean remover = consoleInput.lerConfirmacao();

                    if (remover) {
                        consolePrinter.imprimirSolicitacaoCoordenada();

                        String coordenada = consoleInput.lerCoordenada();

                        int[] posicao = converterCoordenada(coordenada);
                        int linha = posicao[0]; int coluna = posicao[1];

                        removerJogada(linha, coluna);

                        consolePrinter.imprimirJogadaRemovida();
                    }
                }

                case 4 -> {

                    consolePrinter.imprimirSolicitacaoLimparJogadas();

                    boolean desejaLimparJogadas = consoleInput.lerConfirmacao();

                    if (desejaLimparJogadas) {

                        consolePrinter.imprimirConfirmacaoLimparJogadas();

                        boolean confirmarLimpeza = consoleInput.lerConfirmacao();

                        if (confirmarLimpeza) {

                            limparJogadas();

                            consolePrinter.imprimirJogadasRemovidas();
                        }
                    }
                }

                case 5 -> consolePrinter.imprimirStatusPartida(verificarStatusPartida());

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

            consolePrinter.imprimir(tabuleiro);

            executarMenuPartida();

        } catch (SQLException e) {

            consolePrinter.imprimirErro(
                    "Não foi possível iniciar a partida."
            );
        }
    }

    private void executarPartida() {

        consolePrinter.imprimirSolicitacaoCoordenada();

        String coordenada = consoleInput.lerCoordenada();

        int[] posicao = converterCoordenada(coordenada);

        int linha = posicao[0];
        int coluna = posicao[1];

        consolePrinter.imprimirSolicitacaoNumero();

        Jogada jogada = consoleInput.lerJogada();

        executarJogada(linha,coluna,jogada);

        StatusPartida status = verificarStatusPartida();

        if (status == StatusPartida.COMPLETA_VALIDA) {

            consolePrinter.imprimirStatusPartida(status);
        }
    }

    private void salvarPartida() {

        try {

            if (partidaId == null) {

                consolePrinter.imprimirErro("Não existe uma partida para salvar.");

                return;
            }

            if (partidaSalva) {

                consolePrinter.imprimirSolicitacaoSobrescrita();

                boolean confirmarSobrescrita = consoleInput.lerConfirmacao();

                if (!confirmarSobrescrita) {

                    return;
                }
            }

            partidaRepository.sobrescrever(
                    partidaId,
                    tabuleiroId,
                    tabuleiro
            );

            consolePrinter.imprimirPartidaSalva();

            partidaSalva = true;

        } catch (SQLException e) {

            consolePrinter.imprimirErro( "Não foi possível salvar a partida.");
        }
    }

    private void executarJogada (int linha,
                                 int coluna,
                                 Jogada jogada) {

        try {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            if (jogada.tipo() == TipoJogada.DEFINITIVA) {

                casa.preencher(jogada.numero());

            } else {

                boolean resultado = casa.alternarCandidato(jogada.numero());

                if (resultado) {

                    consolePrinter.imprimirCandidatoAdicionado(jogada.numero());

                } else {

                    consolePrinter.imprimirCandidatoRemovido(jogada.numero());
                }

            }

            consolePrinter.imprimir(tabuleiro);

        } catch (IllegalArgumentException e) {

            consolePrinter.imprimirErro(e.getMessage());
        }

    }

    private void removerJogada(int linha,
                               int coluna) {

        try {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            casa.removerNumero();

            consolePrinter.imprimir(tabuleiro);

        } catch (IllegalArgumentException e) {

            consolePrinter.imprimirErro(e.getMessage());

        }

    }

    private void limparJogadas() {

        tabuleiro.limparJogadas();

        consolePrinter.imprimir(tabuleiro);

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
