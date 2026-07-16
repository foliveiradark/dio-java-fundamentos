package usuario;

public class Gerente extends Usuario {

    public Gerente(String nome,
                   String email,
                   String senha) {
        super(nome, email, senha);
    }

    @Override
    public boolean isAdministrador() {
        return true;
    }

    public void gerarRelatorioFinanceiro() {

        System.out.println("===|Relatório Financeiro|===");

    }

    public void consultarVendas() {

        System.out.println("===|Relatório de Vendas|===");

    }
}
