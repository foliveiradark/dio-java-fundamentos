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

    public String lerCoordenada() {

        while (true) {

            String coordenada = scanner.nextLine().trim().toUpperCase();

            if (coordenada.isBlank()) {

                consolePrinter.imprimirCampoVazio();
                continue;
            }

            if (coordenada.length() != 2) {

                consolePrinter.imprimirEntradaInvalida();
                continue;
            }

            char letra = coordenada.charAt(0);
            char numero = coordenada.charAt(1);

            if ((letra < 'A' || letra > 'I') ||
                    (numero < '1' || numero > '9')) {

                consolePrinter.imprimirEntradaInvalida();
                continue;
            }

            return coordenada;

        }
    }

    public boolean lerConfirmacao() {

        while (true) {

            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.isBlank()) {

                consolePrinter.imprimirConfirmacaoInvalida();
                continue;
            }

            if (resposta.equals("S")) {
                return true;
            }

            if (resposta.equals("N")) {
                return false;
            }

            consolePrinter.imprimirConfirmacaoInvalida();
        }
    }

    public int lerOpcaoMenu() {

        while (true) {

            String opcao = scanner.nextLine().trim();

            if (opcao.isBlank()) {

                consolePrinter.imprimirOpcaoMenuInvalida();
                continue;
            }

            try {

                int opcaoMenu = Integer.parseInt(opcao);

                if (opcaoMenu >= 0 && opcaoMenu <= 2) {

                    return opcaoMenu;
                }

                consolePrinter.imprimirOpcaoMenuInvalida();

            } catch (NumberFormatException e) {

                consolePrinter.imprimirOpcaoMenuInvalida();

            }
        }
    }

}
