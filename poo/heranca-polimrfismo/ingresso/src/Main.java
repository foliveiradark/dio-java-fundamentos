import ingresso.Ingresso;
import ingresso.IngressoFamilia;
import ingresso.MeiaEntrada;
import ingresso.TipoAudio;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String SEPARADOR =
            "=================================";

    public static void main(String[] args) {

        List<Ingresso> ingressos = new ArrayList<>();

        ingressos.add(
                new MeiaEntrada(
                        40,
                        "Superman",
                        TipoAudio.DUBLADO
                )
        );

        ingressos.add(
                new IngressoFamilia(
                        40,
                        "Jurassic World",
                        TipoAudio.LEGENDADO,
                        5
                )
        );

        ingressos.add(
                new MeiaEntrada(
                        60,
                        "Avatar",
                        TipoAudio.LEGENDADO
                )
        );

        ingressos.add(
                new IngressoFamilia(
                        35,
                        "Lilo & Stitch",
                        TipoAudio.DUBLADO,
                        2
                )
        );

        for (Ingresso ingresso : ingressos){
            System.out.println(SEPARADOR);
            System.out.println("Tipo: " + ingresso.getTipoIngresso());
            System.out.println("Filme: " + ingresso.getNomeFilme());
            System.out.println("Áudio: " + ingresso.getTipoAudio());

            if (ingresso instanceof IngressoFamilia familia) {
                System.out.println("Pessoas: "
                        + familia.getQuantidadePessoas());
            }

            System.out.printf("Valor: R$ %.2f%n", ingresso.calcularValor());
            System.out.println(SEPARADOR);
        }

    }
}