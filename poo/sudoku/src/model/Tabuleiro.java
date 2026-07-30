package model;

import util.Tabuleiros;

import java.util.ArrayList;
import java.util.List;


public class Tabuleiro {

    private static final int TAMANHO = 9;

    private static final int LIMITE_MINIMO = 0;

    private final Casa[][] casas;

    public Tabuleiro() {

        casas = new Casa[TAMANHO][TAMANHO];

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {
            for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {
                casas[linha][coluna] = criarCasaVazia(linha, coluna);
            }
        }
        carregarTabuleiroInicial();
    }

    private Casa criarCasaVazia(int linha,
                                int coluna) {

        return new Casa(linha, coluna, null, false);
    }

    private  Casa criarCasaFixa(int linha,
                                int coluna,
                                Integer numero) {

        return new Casa(linha, coluna, numero, true);
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

    }

    private void validarColuna(int coluna){

        if (coluna < LIMITE_MINIMO || coluna >= TAMANHO) {
            throw new IllegalArgumentException("Coluna inválida.");
        }

    }

    private void carregarTabuleiroInicial() {

        Integer[][] dados = Tabuleiros.obterTabuleiroInicial();

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {
            for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {

                Integer valor = dados[linha][coluna];

                if (valor == null) {

                    casas[linha][coluna] = criarCasaVazia(linha, coluna);

                } else {

                    casas[linha][coluna] = criarCasaFixa(linha,coluna,valor);

                }
            }
        }

    }

    public boolean possuiCasasVazias() {

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {

            for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {

                Casa casa = getCasa(linha, coluna);

                if (casa.estaVazia())
                    return true;
            }
        }
        return false;
    }

    private boolean possuiErroNaLinha(int linha) {

        List<Integer> numerosDaLinha = new ArrayList<>();

        for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {

            Casa casa = getCasa(linha, coluna);

            if (casa.estaVazia()) {

                continue;

            }

            Integer numero = casa.getNumero();

            if (numerosDaLinha.contains(numero)) {

                return true;
            }

            numerosDaLinha.add(numero);

        }

        return false;
    }

    public boolean possuiErrosNasLinhas() {

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {

            if (possuiErroNaLinha(linha)) {
                return true;
            }
        }

        return false;
    }

    private boolean possuiErroNaColuna(int coluna) {

        List<Integer> numerosDaColuna = new ArrayList<>();

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha++) {

            Casa casa = getCasa(linha, coluna);

            if (casa.estaVazia()) {

                continue;

            }

            Integer numero = casa.getNumero();

            if (numerosDaColuna.contains(numero)) {

                return true;
            }

            numerosDaColuna.add(numero);

        }

        return false;
    }

    public boolean possuiErrosNasColunas() {

        for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna++) {

            if (possuiErroNaColuna(coluna)) {
                return true;
            }
        }

        return false;
    }

    private boolean possuiErrosNosBlocos(int linhaInicial,
                                         int colunaInicial) {

        List<Integer>numerosDoBloco = new ArrayList<>();

        for (int linha = linhaInicial; linha < linhaInicial + 3; linha++) {
            for ( int coluna = colunaInicial; coluna < colunaInicial + 3; coluna++) {



                Casa casa = getCasa(linha, coluna);

                if (casa.estaVazia()) {

                    continue;

                }

                Integer numero = casa.getNumero();

                if (numerosDoBloco.contains(numero)) {

                    return true;
                }

                numerosDoBloco.add(numero);
            }

        }
        return false;
    }

    public boolean possuiErrosNosBlocos() {

        for (int linha = LIMITE_MINIMO; linha < TAMANHO; linha += 3) {

            for (int coluna = LIMITE_MINIMO; coluna < TAMANHO; coluna += 3) {

                if (possuiErrosNosBlocos(linha, coluna)) {

                    return true;
                }
            }
        }

        return false;
    }

}
