package service;

import enums.StatusPartida;
import model.Casa;
import model.Tabuleiro;
import ui.ConsoleInput;
import ui.Menu;
import ui.ConsolePrinter;

public class JogoSudoku {

    private final Tabuleiro tabuleiro;
    private final Menu menu;
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleInput consoleInput = new ConsoleInput(consolePrinter);

    public JogoSudoku() {

        this.tabuleiro = new Tabuleiro();
        this.menu = new Menu();

    }

    // Fluxo principal
    public void iniciar() {
        executarMenuPrincipal();

    }

    // Menu principal
    private void executarMenuPrincipal() {

        boolean executando = true;

        while (executando) {

            menu.exibir();

            int opcao = consoleInput.lerInteiro();

            if (opcao == 0) {
                executando = false;
                consolePrinter.imprimirEncerramento();
            } else if (opcao == 1) {
                iniciarNovaPartida();
            }
        }

    }

    // Fluxo da partida
    private void iniciarNovaPartida() {
        consolePrinter.imprimir(tabuleiro);

        executarPartida();

    }

    private void executarPartida() {

        boolean partidaEmAndamento = true;

        while (partidaEmAndamento) {
            consolePrinter.imprimirSolicitacaoCoordenada();

            String coordenada = consoleInput.lerCoordenada();

            int[] posicao = converterCoordenada(coordenada);

            int linha = posicao[0];
            int coluna = posicao[1];

            consolePrinter.imprimirSolicitacaoRemocao();
            boolean remover = consoleInput.lerConfirmacao();

            if (remover) {

                removerJogada(linha, coluna);

            } else {

                consolePrinter.imprimirSolicitacaoNumero();
                int numero = consoleInput.lerInteiro();

                executarJogada(linha,coluna,numero);

                StatusPartida status = verificarStatusPartida();

                if (status == StatusPartida.COMPLETA_VALIDA) {

                    consolePrinter.imprimirStatusPartida(status);

                    partidaEmAndamento = false;

                    continue;

                }

                consolePrinter.imprimirSolicitacaoLimparJogadas();
                boolean desejaLimparJogadas = consoleInput.lerConfirmacao();

                if (desejaLimparJogadas) {

                    consolePrinter.imprimirConfirmacaoLimparJogadas();
                    boolean confirmarLimpeza = consoleInput.lerConfirmacao();

                    if (confirmarLimpeza) {

                        limparJogadas();
                    }
                }

                consolePrinter.imprimirSolicitacaoStatusPartida();
                boolean confirmarConsulta = consoleInput.lerConfirmacao();

                if (confirmarConsulta) {

                    consolePrinter.imprimirStatusPartida(verificarStatusPartida());

                }

            }

        }

    }

    private void executarJogada (int linha,
                                 int coluna,
                                 int numero) {

        try {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            casa.preencher(numero);

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

        consolePrinter.imprimirJogadasRemovidas();

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
