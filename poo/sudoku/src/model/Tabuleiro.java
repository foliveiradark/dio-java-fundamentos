package model;

public class Tabuleiro {

    private static final int TAMANHO = 9;

    private static final int LIMITE_MINIMO = 0;

    private final Casa[][] casas;

    public Tabuleiro() {

        casas = new Casa[TAMANHO][TAMANHO];

        for (int linha = 0; linha < TAMANHO; linha++) {
            for (int coluna = 0; coluna < TAMANHO; coluna++) {
                casas[linha][coluna] = criarCasaVazia(linha, coluna);
            }
        }
    }

    private Casa criarCasaVazia(int linha, int coluna) {
        return new Casa(linha, coluna, null, false);
    }
    
    public Casa getCasa(int linha, int coluna) {

        validarLinha(linha);
        validarColuna(coluna);

        return casas[linha][coluna];
    }

    private void validarLinha(int linha){

        if (linha < LIMITE_MINIMO || linha >= TAMANHO) {
            throw new IllegalArgumentException("Linha inválida.");
        }

    };

    private void validarColuna(int coluna){

        if (coluna < LIMITE_MINIMO || coluna >= TAMANHO) {
            throw new IllegalArgumentException("Coluna inválida.");
        }

    };
}
