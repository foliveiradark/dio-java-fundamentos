package controle;

import java.util.Locale;
import java.util.Scanner;

public class Desafio07ForMedia {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double total = 0;
        double media = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite o " + i + "° número: ");
            double numero = scanner.nextDouble();

            total += numero;
        }
        media = total / 5;

        System.out.println("\n===|Média Final|===");
        System.out.printf("Média: %.2f%n", media);
        scanner.close();
    }
}
