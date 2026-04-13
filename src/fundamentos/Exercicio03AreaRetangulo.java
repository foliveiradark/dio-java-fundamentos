import java.util.Locale;
import java.util.Scanner;

public class Exercicio03_Retangulo {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite o comprimento do retângulo: ");
        double comprimento = scanner.nextDouble();

        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();

        double area = comprimento * altura;

        System.out.printf("Área do retângulo: %.2f%n", area);

        scanner.close();
    }
}
