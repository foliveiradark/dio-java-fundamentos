package ui;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int lerInteiro() {

        return scanner.nextInt();

    }

}
