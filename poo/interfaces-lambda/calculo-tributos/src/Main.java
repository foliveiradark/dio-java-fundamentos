import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SEPARADOR =
            "=================================";
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Alimentacao("Arroz",25.15));
        produtos.add(new SaudeBemEstar("Plano de Saúde",520));
        produtos.add(new Vestuario("Camiseta", 80));
        produtos.add(new Cultura("Cinema", 25));

        exibirProdutos(produtos);

    }

    private static void exibirProdutos(List<Produto> produtos) {
        for (Produto produto : produtos) {
            System.out.println(SEPARADOR);
            System.out.printf("Produto   : %s%n", produto.getNome());
            System.out.printf("Categoria : %s%n", produto.getClass().getSimpleName());
            System.out.printf("Preço     : R$ %.2f%n", produto.getPreco());
            System.out.printf("Tributo   : R$ %.2f%n", produto.calcularTributo());

        }
    }

}