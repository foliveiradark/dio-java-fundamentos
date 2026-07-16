package relogio;

public abstract class Relogio {

    private int hora;
    private int minuto;
    private int segundo;

    public Relogio(int hora,
                   int minuto,
                   int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (!validarHora(hora)) {
            throw new IllegalArgumentException(
                    "Hora inválida."
            );
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException(
                    "Minuto inválido."
            );
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException(
                    "Segundo inválido."
            );
        }
        this.segundo = segundo;
    }

    protected abstract boolean validarHora (int hora);

    public abstract void alterarHorario (Relogio relogio);

    public abstract int getHora24();

    @Override
    public String toString() {

        return String.format(
                "%02d:%02d:%02d",
                hora,
                minuto,
                segundo
        );
    }
}
