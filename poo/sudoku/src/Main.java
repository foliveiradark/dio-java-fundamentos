import model.Casa;
import model.Tabuleiro;
import ui.ConsolePrinter;

public class Main {

    private static final String SEPARADOR =
            "=================================";

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();

        ConsolePrinter printer = new ConsolePrinter();

        printer.imprimir(tabuleiro);

    }

}