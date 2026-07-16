package usuario;

public class Vendedor extends Usuario {

    private int quantidadeVendas;

    public Vendedor(String nome,
                    String email,
                    String senha) {
        super(nome, email, senha);

        this.quantidadeVendas = 0;
    }

    @Override
    public boolean isAdministrador() {
        return false;
    }

    public int getQuantidadeVendas() {

        return quantidadeVendas;

    }

    public void realizarVenda() {

        this.quantidadeVendas++;

    }

    public void consultarVendas() {

        System.out.println("Total de vendas: " + getQuantidadeVendas());

    }

}
