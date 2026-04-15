package controle;

import java.util.Scanner;

public class Desafio09IMC {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("\n===|Calculadora IMC|===");
        System.out.print("Digite sua altura: ");
        double altura = scanner.nextDouble();

        System.out.print("Digite seu peso: ");
        double peso = scanner.nextDouble();

        double imc = peso / (altura * altura);
        System.out.printf("IMC: %.2f%n", imc);

        if(altura <= 0 || peso <= 0){
            System.out.println("Dados inválidos");
            scanner.close();
            return;
        }

        if(imc <= 18.5){
            System.out.println("\nAbaixo do peso");
        }else if(imc <= 24.9){
            System.out.println("\nPeso ideal");
        }else if(imc <= 29.9){
            System.out.println("\nLevemente acima do peso");
        }else if(imc <= 34.9){
            System.out.println("\nObesidade Grau I");
        }else if(imc <= 39.9){
            System.out.println("\nObesidade Grau II (Severa)");
        }else{
            System.out.println("\nObesidade Grau III (Mórbida)");
        }
        scanner.close();
    }
}
