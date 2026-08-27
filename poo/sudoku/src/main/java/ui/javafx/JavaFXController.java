package ui.javafx;

import enums.TipoJogada;
import service.Jogada;
import service.JogoSudoku;

public class JavaFXController {

    private final JogoSudoku jogo;

    private int linhaSelecionada = -1;
    private int colunaSelecionada = -1;

    public JavaFXController(JogoSudoku jogo) {
        this.jogo = jogo;
    }

    public void selecionarCasa(int linha, int coluna) {

        linhaSelecionada = linha;
        colunaSelecionada = coluna;

        System.out.println(
                "Casa selecionada: [" +
                        linha + "," + coluna + "]"
        );
    }

    public void informarNumero(int numero) {

        if (linhaSelecionada == -1 || colunaSelecionada == -1) {

            System.out.println("Nenhuma casa selecionada.");

            return;
        }

        Jogada jogada = new Jogada(
                numero,
                TipoJogada.DEFINITIVA
        );

        jogo.executarJogada(
                linhaSelecionada,
                colunaSelecionada,
                jogada
        );
    }
}
