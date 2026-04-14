package controle;

import java.util.Scanner;

public class Desafio06ForSomaAcumulada {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int total = 0;

        for(int i = 1; i <= 5; i++ ){
            System.out.print("Digite o " + i + "º número: ");
            int numero = scanner.nextInt();

            total += numero;
        }
        System.out.println("\n===|Resultado Final|===");
        System.out.printf("Total: %d%n", total);

        scanner.close();
    }
}
