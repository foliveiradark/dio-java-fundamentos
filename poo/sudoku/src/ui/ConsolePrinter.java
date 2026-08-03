package ui;

import enums.StatusPartida;
import model.Casa;
import model.Tabuleiro;

public class ConsolePrinter {

    private static final int TAMANHO = 9;

    private static final int LIMITE_MINIMO = 0;

    public void imprimir(Tabuleiro tabuleiro) {

        imprimirCabecalhoColunas();

        imprimirTabuleiro(tabuleiro);

        imprimirCabecalhoColunas();

    }

    //Interface do tabuleiro
    private void imprimirCabecalhoColunas() {

        System.out.println("    1 2 3   4 5 6   7 8 9");
    }

    private void imprimirLinha(Tabuleiro tabuleiro, int linha) {

        System.out.print(obterIdentificadorLinha(linha) + " ");

        imprimirSeparadorVertical();

        for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {

            Casa casa = tabuleiro.getCasa(linha, coluna);

            System.out.print(formatarValor(casa) + " ");

            if (coluna == 2 || coluna == 5 || coluna == 8) {
                imprimirSeparadorVertical();
            }

        }

        System.out.println(obterIdentificadorLinha(linha));
    }

    private char obterIdentificadorLinha(int linha) {

        return (char) ('A' + linha);
    }

    private void imprimirSeparadorVertical() {

        System.out.print("║ ");

    }

    private void imprimirBordaSuperior() {

        System.out.println("  ╔═══════╦═══════╦═══════╗");
    }
    private void imprimirSeparadorHorizontal() {

        System.out.println("  ╠═══════╬═══════╬═══════╣");

    }

    private void imprimirBordaInferior() {

        System.out.println("  ╚═══════╩═══════╩═══════╝");
    }

    private void imprimirTabuleiro(Tabuleiro tabuleiro) {

        imprimirBordaSuperior();

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {

            imprimirLinha(tabuleiro, linha);

            if (linha == 2 || linha == 5) {
                imprimirSeparadorHorizontal();
            }
        }

        imprimirBordaInferior();
    }

    private String formatarValor(Casa casa) {

        if (casa.estaVazia()) {
            return ".";
        }
        return String.valueOf(casa.getNumero());
    }

    //Mensagens
    public void imprimirEncerramento() {

        System.out.println("Saindo do jogo...");
    }

    public void imprimirSolicitacaoCoordenada() {

        System.out.print("Informe a coordenada (A1-I9): ");

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

    public void imprimirSolicitacaoLimparJogadas() {

        System.out.print("Deseja limpar todas as jogadas? (S/N): ");
    }

    public void imprimirConfirmacaoLimparJogadas() {

        System.out.print("Tem certeza que deseja limpar todas as jogadas? (S/N): ");
    }

    public void imprimirJogadasRemovidas() {

        System.out.println("Todas as Jogadas foram removidas.");
    }

    public void imprimirSolicitacaoStatusPartida() {

        System.out.print("Deseja consultar o status da partida? (S/N): ");
    }

    public void imprimirStatusPartida(StatusPartida status) {

        switch (status) {

            case INCOMPLETA:
                System.out.println("A partida ainda está incompleta.");
                break;

            case COMPLETA_INVALIDA:
                System.out.println("O Sudoku possui erros.");
                break;

            case COMPLETA_VALIDA:
                System.out.println("Parabéns! Sudoku concluído.");
                break;
        }
    }

    public void imprimirCampoVazio() {

        System.out.print("O campo está vazio. Digite uma coordenada válida (A1-I9): ");
    }

    public void imprimirEntradaInvalida() {

        System.out.print("Entrada inválida. Informe uma coordenada válida (A1-I9): ");
    }

    public void imprimirConfirmacaoInvalida() {

        System.out.print("Confirmação inválida. Digite S ou N: ");
    }

    public void imprimirOpcaoMenuInvalida() {

        System.out.print("Opção inválida. Escolha uma opção do Menu: ");
    }

    public void imprimirFuncionalidadeIndisponivel(){

        System.out.println("Funcionalidade ainda não disponível.");
    }
}