public class Carro {

    private boolean ligado;
    private int velocidade;
    private int marcha;

    private static final int VELOCIDADE_MAX = 120;
    private static final int VELOCIDADE_MIN = 0;

    private static final int MARCHA_MIN = 0;
    private static final int MARCHA_MAX = 6;

    public void ligar(){

        if (ligado) {
            System.out.println("O carro já está ligado.");
            return;
        }
        ligado = true;

        System.out.println("Carro ligado com sucesso.");
    }

    public void desligar(){

        if (!ligado) {
            System.out.println("O carro já está desligado");
            return;
        }

        if (velocidade != VELOCIDADE_MIN || marcha != MARCHA_MIN) {
            System.out.println("O carro deve estar parado e em ponto morto para ser desligado.");
            return;
        }

        ligado = false;

        System.out.println("Carro desligado com sucesso.");
    }

    public void acelerar() {

        if (!ligado) {
            System.out.println("Você deve ligar o carro primeiro.");
            return;
        }

        if (marcha == MARCHA_MIN) {
            System.out.println("O carro está em ponto morto");
            return;
        }

        if (velocidade > velocidadeMaxDaMarcha(marcha + 1)) {
            System.out.println("troque de marcha.");
            return;
        }

        if (velocidade == VELOCIDADE_MAX) {
            System.out.println("Velocidade máxima atingida.");
            return;
        }

        velocidade++;
    }

    public void reduzirVelocidade() {

        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade == VELOCIDADE_MIN) {
            System.out.println("O carro está parado.");
            return;
        }

        velocidade --;
    }

    public void trocarMarcha(boolean aumentar) {

        if (aumentar) {
            subirMarcha();
        } else {
            reduzirMarcha();
        }
    }

    public void virarEsquerda() {

        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade < 1) {
            System.out.println("O carro está parado.");
            return;
        }

        if (velocidade > 40) {
            System.out.println("Reduza a velocidade para virar.");
            return;
        }

        System.out.println("Virando para a esquerda...");
    }

    public void virarDireita() {

        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade < 1) {
            System.out.println("O carro está parado.");
            return;
        }

        if (velocidade > 40) {
            System.out.println("Reduza a velocidade para virar.");
            return;
        }

        System.out.println("Virando para a direita...");
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public boolean isLigado() {
        return ligado;
    }

    public String getStatus() {
        return String.format("""
                ===|STATUS DO CARRO|===
                Ligado: %s
                Marcha: %d
                Velocidade: %d km/h""", ligado ? "Sim" : "Não",
                marcha,
                velocidade);
    }

    private void subirMarcha() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (marcha == MARCHA_MAX) {
            System.out.println("O carro está na última marcha");
            return;
        }

        if (velocidade < velocidadeMinDaMarcha(marcha + 1)) {
            System.out.println("Aumente a velocidade antes de subir a marcha.");
            return;
        }

        marcha ++;
    }

    private void reduzirMarcha() {

        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (marcha == MARCHA_MIN) {
            System.out.println("O carro está em ponto morto.");
            return;
        }

        if (velocidade > velocidadeMaxDaMarcha(marcha - 1)) {
            System.out.println("Reduza a velocidade antes de diminuir de marcha.");
            return;
        }

        marcha --;
    }

    private int velocidadeMinDaMarcha(int marcha) {
        if (marcha <= 1) {
            return 0;
        }

        return ((marcha - 1) * 20) + 1;
    }

    private int velocidadeMaxDaMarcha(int marcha) {
        return marcha * 20;
    }
}
