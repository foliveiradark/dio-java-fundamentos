public class SaudeBemEstar extends Produto {

    public SaudeBemEstar(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularTributo() {

        return getPreco() * 0.015;
    }
}
