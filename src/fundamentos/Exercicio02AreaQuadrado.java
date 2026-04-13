import java.util.Scanner;

public class Exercicio02_Quadrado {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o lado do quadrado: ");
        double lado = scanner.nextDouble();

        double area = lado * lado;

        System.out.printf("Área do quadrado: %.2f \n",area);

        scanner.close();
    }
}
