package ui;

public class MenuPartida {

    private static final String SEPARADOR =
            "=================================";

    public void exibir() {

        System.out.println(SEPARADOR);
        System.out.println("          PARTIDA");
        System.out.println(SEPARADOR);
        System.out.println("1 - Fazer jogada");
        System.out.println("2 - Salvar partida");
        System.out.println("3 - Remover jogada");
        System.out.println("4 - Limpar jogadas");
        System.out.println("5 - Consultar Status");
        System.out.println("0 - Voltar");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }
}
