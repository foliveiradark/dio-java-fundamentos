package usuario;

public class Atendente extends Usuario {

    private double valorCaixa;

    public Atendente(String nome,
                     String email,
                     String senha) {
        super(nome, email, senha);
    }

    @Override
    public boolean isAdministrador() {
        return false;
    }

    public double getValorCaixa() {
        return valorCaixa;
    }

    public void receberPagamento(double valor) {

        valorCaixa += valor;

    }

    public void fecharCaixa() {
        System.out.printf("Valor em caixa: R$ %.2f%n", valorCaixa);
        valorCaixa = 0;
    }
}
