package ui;

import model.Casa;
import model.Tabuleiro;

public class ConsolePrinter {

    public void imprimir(Tabuleiro tabuleiro) {

        imprimirCabecalho();

        imprimirSeparadorHorizontal();

        imprimirTabuleiro(tabuleiro);

    }

    private void imprimirCabecalho() {

        System.out.println("  | 1 2 3 | 4 5 6 | 7 8 9");
    }

    private void imprimirLinha(Tabuleiro tabuleiro, int linha) {

        System.out.print(obterIdentificadorLinha(linha) + " ");

        imprimirSeparadorVertical();

        for (int coluna = 0; coluna < 9; coluna++) {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            System.out.print(formatarValor(casa) + " ");

            if (coluna == 2 || coluna == 5) {
                imprimirSeparadorVertical();
            }

        }

        System.out.println();
    }

    private char obterIdentificadorLinha(int linha){

        return (char) ('A' + linha);
    }

    private void imprimirSeparadorVertical() {

        System.out.print("| ");

    }

    private void imprimirSeparadorHorizontal() {

        System.out.println("--+-------+-------+------");

    }

    private void imprimirTabuleiro(Tabuleiro tabuleiro) {

        for (int linha = 0; linha < 9; linha++) {

            imprimirLinha(tabuleiro, linha);

            if (linha == 2 || linha == 5) {
                imprimirSeparadorHorizontal();
            }
        }

        imprimirSeparadorHorizontal();
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

    public void imprimirSolicitacaoLinha() {

        System.out.print("Informe a linha: ");
    }

    public void imprimirSolicitacaoColuna() {

        System.out.print("Informe a coluna: ");
    }

    public void imprimirSolicitacaoNumero() {

        System.out.print("Informe o número: ");
    }

    public void imprimirErro(String mensagem) {

        System.out.println(mensagem);
    }

    public void imprimirSolicitacaoRemocao() {

        System.out.print("Deseja remover o número? (S/N): ");
    }
}
