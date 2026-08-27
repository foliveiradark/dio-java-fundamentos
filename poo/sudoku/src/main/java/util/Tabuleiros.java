package util;

public class Tabuleiros {

    private static final Integer[][] TABULEIRO_INICIAL = {

            {9, 5, 8, null, null, null, null, 2, null},
            {null, null, null, 2, 5, 6, null, 4, null},
            {null, null, 6, null, null, null, 5, 1, 7},
            {6, null, null, 3, 7, 8, null, null, null},
            {7, 8, 4, null, null, null, 9, 3, 2},
            {null, null, null, 4, 2, 9, null, null, 8},
            {4, 9, 2, null, null, null, 1, null, null},
            {null, 6, null, 5, 8, 1, null, null, null},
            {null, 1, null, null, null, null, 7, 6, 3}

    };


    public static Integer[][] obterTabuleiroInicial() {


        return TABULEIRO_INICIAL;
    }


}
