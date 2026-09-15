package ui.javafx;

import enums.TipoJogada;
import service.Jogada;
import service.JogoSudoku;
import ui.InterfaceApresentacao;

public class JavaFXController {

    private final JogoSudoku jogo;
    private final InterfaceApresentacao interfaceApresentacao;

    private int linhaSelecionada = -1;
    private int colunaSelecionada = -1;
    private boolean modoCandidato = false;

    public JavaFXController(JogoSudoku jogo,
                            InterfaceApresentacao interfaceApresentacao) {
        this.jogo = jogo;
        this.interfaceApresentacao = interfaceApresentacao;
    }

    public void selecionarCasa(int linha, int coluna) {

        linhaSelecionada = linha;
        colunaSelecionada = coluna;

        System.out.println(
                "Casa selecionada: [" +
                        linha + "," + coluna + "]"
        );
    }

    public void alternarModoCandidato() {

        modoCandidato = !modoCandidato;

    }

    public void informarNumero(int numero) {

        if (linhaSelecionada == -1 || colunaSelecionada == -1) {

            interfaceApresentacao.exibirErro("Nenhuma casa selecionada.");

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

            interfaceApresentacao.exibirErro("Nenhuma casa selecionada.");

            return;
        }

        jogo.removerJogada(
                linhaSelecionada,
                colunaSelecionada
        );
    }
}
