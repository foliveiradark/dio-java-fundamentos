public class Cultura extends Produto {

    public Cultura(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularTributo() {

        return getPreco() * 0.04;
    }
}
