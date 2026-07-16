package relogio;

public class RelogioBrasileiro extends Relogio {

    public RelogioBrasileiro(int hora,
                             int minuto,
                             int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    protected boolean validarHora(int hora) {

        return hora >= 0 && hora <= 23;
    }

    @Override
    public void alterarHorario(Relogio relogio) {

        setHora(relogio.getHora24());
        setMinuto(relogio.getMinuto());
        setSegundo(relogio.getSegundo());

    }

    @Override
    public int getHora24() {
        return getHora();
    }

}
