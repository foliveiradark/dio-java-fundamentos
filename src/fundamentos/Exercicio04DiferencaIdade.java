package fundamentos;

import java.util.Scanner;

public class Exercicio04DiferencaIdade {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();

        System.out.print("Idade da primeira pessoa: ");
        int idade1 = scanner.nextInt();
        scanner.nextLine(); //limpar buffer

        System.out.print("Nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        System.out.print("Idade da segunda pessoa: ");
        int idade2 = scanner.nextInt();

        int diferenca = Math.abs(idade1 - idade2); // calcula a diferença absoluta entre as idades

        System.out.printf("A diferença de idade entre %s e %s é de %d anos%n", nome1, nome2, diferenca);

        scanner.close();
    }
}
