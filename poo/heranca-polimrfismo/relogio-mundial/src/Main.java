import relogio.Periodo;
import relogio.Relogio;
import relogio.RelogioAmericano;
import relogio.RelogioBrasileiro;

public class Main {

    private static final String SEPARADOR =
            "=================================";

    public static void main(String[] args) {

        Relogio brasileiro = new RelogioBrasileiro(
                20,
                45,
                10
        );

        Relogio americano = new RelogioAmericano(
                10,
                30,
                20,
                Periodo.AM
        );

        System.out.println("=== Horários iniciais ===");

        System.out.println("Brasil: "
                + brasileiro);

        System.out.println("EUA: "
                + americano);


        System.out.println(SEPARADOR);

        System.out.println("=== Brasil alterando EUA ===");

        americano.alterarHorario(brasileiro);

        System.out.println("Novo horário EUA: "
                + americano);


        System.out.println(SEPARADOR);

        System.out.println("=== EUA alterando Brasil ===");

        brasileiro.alterarHorario(americano);

        System.out.println("Novo horário Brasil: "
                + brasileiro);


        System.out.println(SEPARADOR);

        testarExcecoes();

        System.out.println(SEPARADOR);

        testarMeiaNoite();
    }

    private static void testarExcecoes() {

        System.out.println("=== Testando validações ===");

        try {

            System.out.println(
                    "Testando horário brasileiro: 25:30:10"
            );

            Relogio relogioInvalido =
                    new RelogioBrasileiro(
                            25,
                            30,
                            10
                    );


            System.out.println(relogioInvalido);

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro capturado: "
                            + e.getMessage()
            );
        }

        System.out.println(SEPARADOR);

        try {
            System.out.println(
                    "Testando horário americano: 15:30:10 PM"
            );
            Relogio relogioInvalido =
                    new RelogioAmericano(
                            15,
                            30,
                            10,
                            Periodo.PM
                    );

            System.out.println(relogioInvalido);

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro capturado: "
                            + e.getMessage()
            );
        }
        System.out.println(SEPARADOR);

    }

    private static void testarMeiaNoite() {

        System.out.println("=== Testando conversão de meia-noite ===");

        Relogio brasileiro =
                new RelogioBrasileiro(
                        0,
                        0,
                        0
                );

        Relogio americano =
                new RelogioAmericano(
                        12,
                        0,
                        0,
                        Periodo.AM
                );


        System.out.println("Horário brasileiro inicial: "
                + brasileiro);

        System.out.println("Horário americano inicial: "
                + americano);


        System.out.println(SEPARADOR);


        System.out.println("Brasil alterando EUA:");

        americano.alterarHorario(brasileiro);

        System.out.println("Resultado EUA: "
                + americano);


        System.out.println(SEPARADOR);


        System.out.println("EUA alterando Brasil:");

        brasileiro.alterarHorario(americano);

        System.out.println("Resultado Brasil: "
                + brasileiro);

    }
}