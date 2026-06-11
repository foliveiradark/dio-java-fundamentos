package desafios.validaCadastro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        String[] dados = entrada.split(" ");

        if (dados.length < 2) {
            System.out.println("Cadastro reprovado");
            scanner.close();
            return;
        }

        String nome = dados[0];
        int idade = Integer.parseInt(dados[1]);

        if (!nome.isEmpty() && idade >= 18) {
            System.out.println("Cadastro aprovado");
        } else {
            System.out.println("Cadastro reprovado");
        }

        scanner.close();
    }
}
