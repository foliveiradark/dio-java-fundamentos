package ingresso;

public abstract class Ingresso {

    private final double valorBase;

    private final String nomeFilme;

    private final TipoAudio tipoAudio;

    public abstract String getTipoIngresso();

    public Ingresso(double valorBase,
                    String nomeFilme,
                    TipoAudio tipoAudio) {
        this.valorBase = valorBase;
        this.nomeFilme = nomeFilme;
        this.tipoAudio = tipoAudio;
    }

    public double getValorBase() {
        return valorBase;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public TipoAudio getTipoAudio() {
        return tipoAudio;
    }

    public abstract double calcularValor();
}
