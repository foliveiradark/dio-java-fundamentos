package controle;

import java.util.Scanner;

public class Desafio11LoopComDivisao {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("===|Loop com Divisão|===");

        System.out.print("Informe um número: ");
        int numInit = scanner.nextInt();

        if(numInit <= 0){
            System.out.printf("Informe um número maior que %s%n", numInit);
            scanner.close();
            return;
        }

        if(numInit == 1){
            System.out.println("Qualquer número será divisível por 1. Encerrando...");
            scanner.close();
            return;
        }

        while(true){
            System.out.print("Informe o número para verificação: ");
            var toVerify = scanner.nextInt();

            if(toVerify < numInit){
                System.out.printf("Número deve ser maior ou igual a %s%n", numInit);
                continue;
            }

            var result = toVerify % numInit;
            System.out.printf("%s %% %s  = %s%n", toVerify, numInit, result);

            if(result != 0){
                System.out.println("Encerrando execução...");
                break;
            }
        }
        scanner.close();
    }
}
