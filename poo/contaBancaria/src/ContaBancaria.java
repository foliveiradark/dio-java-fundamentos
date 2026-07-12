public class ContaBancaria {

    private double saldo;
    private final double limiteChequeEspecial;
    private double valorUsadoChequeEspecial;

    private static final double CHEQUE_ESPECIAL_FIXO = 50.0;
    private static final double PERCENT_CHEQUE_ESPECIAL = 0.5;
    private static final double TAXA_CHEQUE_ESPECIAL = 0.20;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;

        if (depositoInicial <= 500) {
            limiteChequeEspecial = CHEQUE_ESPECIAL_FIXO;
        } else {
            limiteChequeEspecial = depositoInicial * PERCENT_CHEQUE_ESPECIAL;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return limiteChequeEspecial;
    }

    public boolean estaUsandoChequeEspecial() {
        return saldo < 0;
    }

    private boolean debitar(double valor) {

        double limiteDisponivel = saldo + limiteChequeEspecial;

        if (valor > limiteDisponivel) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        saldo -= valor;

        if (saldo < 0) {
            valorUsadoChequeEspecial = Math.max(
                    valorUsadoChequeEspecial,
                    Math.abs(saldo)
            );
        }

        return true;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
            return;
        }

        if (debitar(valor)) {
            System.out.println("Saque realizado com sucesso.");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser maior que zero.");
            return;
        }

        saldo += valor;

        System.out.println("Depósito realizado com sucesso.");

        if (saldo >= 0 && valorUsadoChequeEspecial > 0) {

            double taxa = valorUsadoChequeEspecial * TAXA_CHEQUE_ESPECIAL;

            if (saldo >= taxa) {
                saldo -= taxa;
                valorUsadoChequeEspecial = 0;

                System.out.println("Taxa do Cheque Especial cobrada: R$" + taxa);
            }
        }
    }

    public void pagarBoleto(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do boleto deve ser maior que zero.");
            return;
        }

        if (debitar(valor)) {
            System.out.println("Boleto pago com sucesso.");
        }
    }
}
