package controle;

import java.util.Scanner;

public class Desafio10IntervaloNumeros {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("===|Intervalo de Números|===");

        System.out.print("Número Inicial: ");
        var numeroInicial = scanner.nextInt();

        System.out.print("Número Final: ");
        var numeroFinal = scanner.nextInt();

        if(numeroFinal < numeroInicial){
            System.out.printf("Informe um número maior que %s \n", numeroInicial);
            scanner.close();
            return;
        }

        System.out.print("Digite 1 para PAR ou 2 para ÍMPAR: ");
        int opcao = scanner.nextInt();

        System.out.println("\n---|Resultado|---");

        for(int i = numeroFinal; i >= numeroInicial; i--){
            if(opcao == 1 && i % 2 == 0){
                System.out.println(i);
            }else if(opcao == 2 && i % 2 != 0){
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
