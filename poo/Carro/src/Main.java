import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Carro carro = new Carro();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===|MENU|===");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Reduzir velocidade");
            System.out.println("5 - Subir marcha");
            System.out.println("6 - Reduzir marcha");
            System.out.println("7 - Virar à esquerda");
            System.out.println("8 - Virar à direita");
            System.out.println("9 - Ver velocidade");
            System.out.println("0 - Sair");
            System.out.println("==========");

            System.out.println(carro.getStatus());

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1 -> carro.ligar();

                case 2 -> carro.desligar();

                case 3 -> carro.acelerar();

                case 4 -> carro.reduzirVelocidade();

                case 5 -> carro.trocarMarcha(true);

                case 6 -> carro.trocarMarcha(false);

                case 7 -> carro.virarEsquerda();

                case 8 -> carro.virarDireita();

                case 9 -> System.out.println(
                        "Velocidade atual: "
                                + carro.getVelocidade()
                                + " km/h");

                case 0 -> System.out.println("Programa encerrado.");

                default -> System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        scanner.close();
    }

}