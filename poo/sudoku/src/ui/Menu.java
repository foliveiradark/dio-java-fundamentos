package ui;

public class Menu {

    private static final String SEPARADOR =
            "=================================";

    public void exibir() {

        System.out.println(SEPARADOR);
        System.out.println("            SUDOKU");
        System.out.println(SEPARADOR);
        System.out.println("1 - Novo jogo");
        System.out.println("2 - Continuar");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");

    }

}
