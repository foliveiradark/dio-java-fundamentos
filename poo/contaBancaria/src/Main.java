import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static ContaBancaria conta;

    public static void main(String[] args) {

        System.out.println("===|CRIAÇÃO DA CONTA|===");
        System.out.print("Informe o depósito inicial: ");
        double depositoInicial = scanner.nextDouble();

        conta = new ContaBancaria(depositoInicial);

        int opcao;

        do {
            System.out.println("\n===|MENU CONTA BANCÁRIA|===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> consultarSaldo();
                case 2 -> consultarChequeEspecial();
                case 3 -> depositar();
                case 4 -> sacar();
                case 5 -> pagarBoleto();
                case 6 -> verificarChequeEspecial();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void consultarSaldo() {
        System.out.println("Saldo atual: R$" + conta.consultarSaldo());
    }

    private static void consultarChequeEspecial() {
        System.out.println("Limite Cheque Especial: R$" + conta.consultarChequeEspecial());
    }

    private static void depositar(){
        System.out.println("Informe o valor do depósito: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
    }

    private static void sacar(){
        System.out.println("Valor do saque: ");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
    }

    private static void pagarBoleto(){
        System.out.print("Valor do boleto: ");
        double valor = scanner.nextDouble();
        conta.pagarBoleto(valor);
    }

    private static void verificarChequeEspecial(){
        if(conta.estaUsandoChequeEspecial()) {
            System.out.println("A conta está usando cheque especial.");
        } else {
            System.out.println("A conta NÃO está usando cheque especial.");
        }
    }
}