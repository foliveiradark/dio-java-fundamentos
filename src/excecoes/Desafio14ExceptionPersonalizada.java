package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio14ExceptionPersonalizada {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int numero = lerNumero(scanner);

        System.out.println("Número válido: " + numero);
        System.out.println("Fim da execução");
        scanner.close();
    }

    public static int lerNumero(Scanner scanner) throws NumeroInvalidoException{
        int numero;

        while (true){
            try {
                System.out.print("Digite um número: ");
                numero = scanner.nextInt();

                if(numero <= 0){
                    throw new NumeroInvalidoException("Número deve ser positivo");
                }
                return numero;
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            } catch (NumeroInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void validarNumero(int numero) throws NumeroInvalidoException{
        if (numero <= 0){
            throw new NumeroInvalidoException("Número deve ser positivo");
        }
    }
}
