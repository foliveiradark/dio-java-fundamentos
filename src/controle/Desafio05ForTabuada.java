package controle;

import java.util.Scanner;

public class Desafio05ForTabuada {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Digite um número de 1 à 10: ");
        int multiplicador = scanner.nextInt();

        if(multiplicador < 1 || multiplicador > 10){
            System.out.println("Número inválido");
            scanner.close();
            return;
        }

        System.out.printf("===|Tabuada do %d|===%n", multiplicador);

        for(int i = 1; i <= 10; i++){
            int resultado = i * multiplicador;
            System.out.printf("%d x %d = %d%n", multiplicador, i, resultado);
        }
        scanner.close();
    }
}
