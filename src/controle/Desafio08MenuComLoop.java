package controle;

import java.util.Scanner;

public class Desafio08MenuComLoop {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int option;
        do{
            System.out.println("====|Menu Interativo|====");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.print("Digite o primeiro número:");
                    int soma1 = scanner.nextInt();
                    System.out.print("Digite o segundo número:");
                    int soma2 = scanner.nextInt();

                    int resultSoma = soma1 + soma2;
                    System.out.println("Resultado: " + resultSoma);
                    break;
                case 2:
                    System.out.print("Digite o primeiro número:");
                    int sub1 = scanner.nextInt();
                    System.out.print("Digite o segundo número:");
                    int sub2 = scanner.nextInt();

                    int resultSub = (sub1 - sub2);
                    System.out.println("Resultado: " + resultSub);
                    break;
                case 3:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while (option != 3);
    }
}
