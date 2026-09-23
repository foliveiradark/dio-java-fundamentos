package ui.javafx;

import enums.TipoJogada;
import service.Jogada;
import service.JogoSudoku;

public class JavaFXController {

    private final JogoSudoku jogo;
    private final JavaFXPrinter javaFXPrinter;

    private int linhaSelecionada = -1;
    private int colunaSelecionada = -1;
    private boolean modoCandidato = false;

    public JavaFXController(JogoSudoku jogo,
                            JavaFXPrinter javaFXPrinter) {
        this.jogo = jogo;
        this.javaFXPrinter = javaFXPrinter;
    }

    public void selecionarCasa(int linha, int coluna) {

        linhaSelecionada = linha;
        colunaSelecionada = coluna;

    }

    public void alternarModoCandidato() {

        modoCandidato = !modoCandidato;

    }

    public void informarNumero(int numero) {

        if (linhaSelecionada == -1 || colunaSelecionada == -1) {

            javaFXPrinter.exibirErro("Nenhuma casa selecionada.");

            return;
        }

        TipoJogada tipoJogada;

        if (modoCandidato) {

            tipoJogada = TipoJogada.CANDIDATO;

        } else {

            tipoJogada = TipoJogada.DEFINITIVA;

        }

        Jogada jogada = new Jogada(
                numero,
                tipoJogada
        );

        jogo.executarJogada(
                linhaSelecionada,
                colunaSelecionada,
                jogada
        );
    }

    public void removerJogada() {

        if (linhaSelecionada == -1 || colunaSelecionada == -1) {

            javaFXPrinter.exibirErro("Nenhuma casa selecionada.");

            return;
        }

        jogo.removerJogada(
                linhaSelecionada,
                colunaSelecionada
        );
    }

    public void limparJogadas() {

        if (!jogo.possuiJogadasParaLimpar()) {

            javaFXPrinter.exibirInformacao("Não há jogadas definitivas para limpar.");

            return;
        }

        boolean confirmouLimpeza = javaFXPrinter.confirmarLimpezaJogadas();

        if (confirmouLimpeza) {

            jogo.limparJogadas();

            jogo.apresentarTabuleiro();
        }
    }

}
