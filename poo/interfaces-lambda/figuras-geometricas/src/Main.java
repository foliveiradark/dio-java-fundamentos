import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String SEPARADOR =
            "=================================";

    public static void main(String[] args) {

        List<CalcularArea> areas = new ArrayList<>();

        areas.add(new Quadrado(5));
        areas.add(new Retangulo(8,4));
        areas.add(new Circulo(7));

        exibirAreas(areas);

        System.out.println(SEPARADOR);

        testarExcecoes();

    }

    private static void exibirAreas(List<CalcularArea>areas) {
        for (CalcularArea area : areas) {
            System.out.println(SEPARADOR);
            System.out.printf("Forma: %s%n", area.getClass().getSimpleName());
            System.out.printf("Área: %.2f%n", area.calcularArea());
        }
    }

    private static void testarExcecoes() {

        System.out.println(SEPARADOR);
        System.out.println("=== Testando validações ===");

        try {

            new Quadrado(0);

        } catch (IllegalArgumentException e) {

            System.out.println("Quadrado lado 0: " + e.getMessage());

        }

        try {

            new Retangulo(-5, 10);

        } catch (IllegalArgumentException e) {

            System.out.println("Retangulo base -5, altura 10: " + e.getMessage());

        }

        try {

            new Circulo(-2);

        } catch (IllegalArgumentException e) {

            System.out.println("Círculo raio -2: " + e.getMessage());

        }

    }
}