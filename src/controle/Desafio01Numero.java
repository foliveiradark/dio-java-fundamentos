package controle;

import java.util.Scanner;

public class Desafio01Numero {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        //Verifica se  o número é positivo, negativo ou é zero
        if(numero > 0){
            System.out.println("Número positivo");
        }else if (numero < 0){
            System.out.println("Número negativo");
        }
        else {
            System.out.println("Número é zero");
        }

        //Verifica se o número é par ou impar
        if(numero % 2 == 0){
            System.out.println("Número par");
        }else {
            System.out.println("Número ímpar");
        }

        System.out.println("Fim da execução");
        scanner.close();
    }
}
