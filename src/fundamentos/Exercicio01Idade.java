import java.time.OffsetDateTime;
import java.util.Scanner;

public class Exercicio01_Idade {
    public static void main(String[] args) {
        var baseYear = OffsetDateTime.now().getYear();
        var scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        var name = scanner.nextLine();

        System.out.println("Informe o seu ano de nascimento: ");
        var yearBorn = scanner.nextInt();

        var age = baseYear - yearBorn;

        System.out.printf("Olá, %s você tem %s anos \n", name, age);

        scanner.close();
    }
}