package desafios.validaComandosCriticos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();

        if (comando.equals("START") || comando.equals("STOP") || comando.equals("RESTART")) {
            System.out.println("Command accepted");
        } else {
            System.out.println("Command rejected");
        }

        scanner.close();
    }
}
