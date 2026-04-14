package controle;

import java.util.Scanner;

public class Desafio02Idade {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if(idade < 0){
            System.out.println("Idade inválida");
        }else if(idade <= 12){
            System.out.println("Classificação: Criança");
        }else if(idade <= 17){
            System.out.println("Classificação: Adolescente");
        }else if(idade <= 59){
            System.out.println("Classificação: Adulto");
        }else {
            System.out.println("Classificação: Idoso");
        }
        System.out.println("\nFim da execução");
        scanner.close();
    }
}
