package relogio;

public class RelogioAmericano extends Relogio {

    private Periodo periodo;

    public RelogioAmericano(int hora,
                            int minuto,
                            int segundo,
                            Periodo periodo) {
        super(hora, minuto, segundo);

        if (periodo == null) {
            throw new IllegalArgumentException(
                    "Período inválido."
            );
        }

        this.periodo = periodo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    @Override
    protected boolean validarHora(int hora) {

        return hora >= 1 && hora <= 12;
    }

    @Override
    public void alterarHorario(Relogio relogio) {

        int hora = relogio.getHora();

        if (hora >= 12) {

            periodo = Periodo.PM;

            if (hora > 12) {
                hora -= 12;
            }
        }else  {

            periodo = Periodo.AM;

            if (hora == 0) {
                hora = 12;
            }
        }

        setHora(hora);
        setMinuto(relogio.getMinuto());
        setSegundo(relogio.getSegundo());

    }

    @Override
    public int getHora24() {

        int horaAtual = getHora();

        if(periodo == Periodo.PM && horaAtual != 12){
            return horaAtual + 12;
        }

        if(periodo == Periodo.AM && horaAtual == 12){
            return 0;
        }

        return horaAtual;
    }

    @Override
    public String toString() {

        return String.format(
                "%02d:%02d:%02d %s",
                getHora(),
                getMinuto(),
                getSegundo(),
                periodo
        );
    }
}
