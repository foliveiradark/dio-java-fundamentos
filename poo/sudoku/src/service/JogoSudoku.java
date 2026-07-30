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
    private final ConsoleInput consoleInput;
    private final ConsolePrinter consolePrinter;

    public JogoSudoku() {
        this.tabuleiro = new Tabuleiro();
        this.menu = new Menu();
        this.consoleInput = new ConsoleInput();
        this.consolePrinter = new ConsolePrinter();
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
            consolePrinter.imprimirSolicitacaoLinha();
            int linha = consoleInput.lerInteiro();

            consolePrinter.imprimirSolicitacaoColuna();
            int coluna = consoleInput.lerInteiro();

            consolePrinter.imprimirSolicitacaoRemocao();
            boolean remover = consoleInput.lerConfirmacao();

            if (remover) {

                removerJogada(linha, coluna);

            } else {

                consolePrinter.imprimirSolicitacaoNumero();
                int numero = consoleInput.lerInteiro();

                executarJogada(linha,coluna,numero);

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

}
