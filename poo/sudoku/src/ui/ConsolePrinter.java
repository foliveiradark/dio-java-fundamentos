package ui;

import model.Casa;
import model.Tabuleiro;

public class ConsolePrinter {

    public void imprimir(Tabuleiro tabuleiro) {

        for (int linha = 0; linha < 9; linha++) {

            imprimirLinha(tabuleiro, linha);

            if (linha == 2 || linha == 5) {
                imprimirSeparadorHorizontal();
            }
        }

    }

    private void imprimirLinha(Tabuleiro tabuleiro, int linha) {

        for (int coluna = 0; coluna < 9; coluna++) {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            System.out.print(formatarValor(casa) + " ");

            if (coluna == 2 || coluna == 5) {
                imprimirSeparadorVertical();
            }

        }

        System.out.println();
    }

    private void imprimirSeparadorVertical() {

        System.out.print("| ");

    }

    private void imprimirSeparadorHorizontal() {

        System.out.println("------+-------+------");

    }

    private String formatarValor(Casa casa) {

        if (casa.estaVazia()) {
            return ".";
        }
        return String.valueOf(casa.getNumero());
    }

    public void imprimirEncerramento() {

        System.out.println("Saindo do jogo...");
    }
}
