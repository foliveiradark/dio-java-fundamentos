public class Alimentacao extends Produto {

    public Alimentacao(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularTributo() {
        return getPreco() * 0.01;
    }

}
