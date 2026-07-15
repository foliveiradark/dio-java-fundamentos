package ingresso;

public class MeiaEntrada extends Ingresso {

    @Override
    public String getTipoIngresso() {
        return "Meia Entrada";
    }

    public MeiaEntrada(double valorBase,
                       String nomeFilme,
                       TipoAudio tipoAudio) {
        super(valorBase, nomeFilme, tipoAudio);
    }
    @Override
    public double calcularValor () {
        return getValorBase() / 2;
    }
}
