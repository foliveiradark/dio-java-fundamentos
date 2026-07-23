package service;

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

    public void iniciar() {
        executarMenuPrincipal();

    }

    private void executarMenuPrincipal() {

        boolean executando = true;

        while (executando) {

            menu.exibir();

            int opcao = consoleInput.lerOpcao();

            if (opcao == 0) {
                executando = false;
                consolePrinter.imprimirEncerramento();
            }
        }

    }

}
