package ingresso;

public class IngressoFamilia extends Ingresso{

    @Override
    public String getTipoIngresso() {
        return "Família";
    }

    private final int quantidadePessoas;

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public IngressoFamilia(
            double valorBase,
            String nomeFilme,
            TipoAudio tipoAudio,
            int quantidadePessoas) {
        super(valorBase, nomeFilme, tipoAudio);

        if (quantidadePessoas < 1) {
            throw new IllegalArgumentException(
                    "A quantidade de pessoas deve ser maior que zero."
            );
        }

        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public double calcularValor () {

        double valorTotal =
                getValorBase() * getQuantidadePessoas();

        if (getQuantidadePessoas() > 3) {

            return valorTotal - (valorTotal * 0.05);

        }

        return valorTotal;
    }

}
