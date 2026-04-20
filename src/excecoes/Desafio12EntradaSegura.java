package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio12EntradaSegura {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int numero = lerNumero(scanner);

        analisarNumero(numero);

        System.out.println("Fim da Execução");
        scanner.close();
    }

    public static int lerNumero(Scanner scanner) {
        int numero;

        while (true) {
            try {
                System.out.print("Digite um número: ");
                numero = scanner.nextInt();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    public static void analisarNumero(int numero){
        System.out.println("===|Análise do Número|===");

        if(numero > 0){
            System.out.println("Número positivo");
        }else if (numero < 0){
            System.out.println("Número negativo");
        }
        else {
            System.out.println("Número é zero");
        }

        if(numero % 2 == 0){
            System.out.println("Número par");
        }else {
            System.out.println("Número ímpar");
        }
    }
}
