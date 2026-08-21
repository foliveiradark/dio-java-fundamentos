package model;

import java.util.HashSet;
import java.util.Set;

public class Casa {

    private final int linha;
    private final int coluna;
    private Integer numero;
    private final boolean fixa;
    private final Set<Integer> candidatos;

    private static final int NUMERO_MINIMO = 1;
    private static final int NUMERO_MAXIMO = 9;
    private static final int LIMITE_MINIMO = 0;
    private static final int LIMITE_MAXIMO = 8;

    public Casa(int linha,
                int coluna,
                Integer numero,
                boolean fixa) {

        validarLinha(linha);
        validarColuna(coluna);
        validarNumero(numero);

        this.linha = linha;
        this.coluna = coluna;
        this.numero = numero;
        this.fixa = fixa;
        this.candidatos = new HashSet<>();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public Integer getNumero() {
        return numero;
    }

    public boolean isFixa() {
        return fixa;
    }

    public boolean estaVazia() {
        return this.numero == null;
    }

    public void preencher(Integer numero) {

        if (isFixa()) {
            throw new IllegalArgumentException(
                    "Não é possível alterar uma casa fixa."
            );
        }

        if (!estaVazia()) {
            throw new IllegalArgumentException(
                    "Não é possível substituir uma jogada existente. Remova a jogada primeiro."
            );

        }

        validarNumero(numero);

        this.numero = numero;
        candidatos.clear();

    }

    public void removerNumero() {

        if(isFixa()) {

            throw new IllegalArgumentException("Não é possível alterar uma casa fixa.");
        }

        if(estaVazia()) {
            throw new IllegalArgumentException ("A casa já está vazia.");
        }

        this.numero = null;

    }

    public boolean alternarCandidato(Integer candidato) {

        if (isFixa()) {
            throw new IllegalArgumentException(
                    "Não é possível alterar uma casa fixa."
            );
        }

        if (!estaVazia()) {
            throw new IllegalArgumentException(
                    "Não é possível alterar os candidatos de uma casa preenchida."
            );
        }

        validarNumero(candidato);

        if (candidatos.contains(candidato)) {
            candidatos.remove(candidato);
            return false;
        }

        candidatos.add(candidato);
        return true;
    }

    public boolean possuiCandidato(Integer candidato) {
        return candidatos.contains(candidato);
    }

    public Set<Integer> getCandidatos() {

        return Set.copyOf(candidatos);
    }

    private void validarNumero(Integer numero){

        if (numero == null) {
            return;
        }

        if (numero < NUMERO_MINIMO || numero > NUMERO_MAXIMO) {
            throw new IllegalArgumentException(
                    "O número deve estar entre 1 e 9."
            );
        }

    }

    private void validarLinha(int linha){

        if (linha < LIMITE_MINIMO || linha > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Linha inválida.");
        }

    }

    private void validarColuna(int coluna){

        if (coluna < LIMITE_MINIMO || coluna > LIMITE_MAXIMO) {
            throw new IllegalArgumentException("Coluna inválida.");
        }

    }

    @Override
    public String toString() {
        return "Casa{" +
                "linha=" + linha +
                ", coluna=" + coluna +
                ", numero=" + numero +
                ", fixa=" + fixa +
                '}';
    }
}
