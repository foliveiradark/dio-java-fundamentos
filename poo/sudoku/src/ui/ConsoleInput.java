package ui;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    private final ConsolePrinter consolePrinter;

    public ConsoleInput(ConsolePrinter consolePrinter) {

        this.scanner = new Scanner(System.in);
        this.consolePrinter = consolePrinter;

    }

    public int lerInteiro() {

        while (true) {

            String entrada = scanner.nextLine();

            if (entrada.isBlank()) {

                consolePrinter.imprimirCampoVazio();
                continue;
            }
            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                consolePrinter.imprimirEntradaInvalida();
            }

        }

    }

    public boolean lerConfirmacao() {

        String resposta = scanner.nextLine();

        return resposta.trim().equalsIgnoreCase("S");

    }

}
