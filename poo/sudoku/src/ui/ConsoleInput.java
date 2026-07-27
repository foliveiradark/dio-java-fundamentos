package ui;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int lerInteiro() {

        return Integer.parseInt(scanner.nextLine());

    }

    public boolean lerConfirmacao() {

        String resposta = scanner.nextLine();

        return resposta.trim().equalsIgnoreCase("S");

    }

}
