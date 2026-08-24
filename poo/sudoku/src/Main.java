import service.JogoSudoku;
import ui.ConsoleInput;
import ui.ConsolePrinter;

public class Main {

    public static void main(String[] args) {

        ConsolePrinter consolePrinter = new ConsolePrinter();
        ConsoleInput consoleInput = new ConsoleInput(consolePrinter);

        JogoSudoku jogo = new JogoSudoku(
                consoleInput,
                consolePrinter
        );

        jogo.iniciar();

    }

}
