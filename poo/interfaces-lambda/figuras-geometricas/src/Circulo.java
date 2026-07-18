public class Circulo implements CalcularArea{

    private double raio;

    public Circulo(double raio) {
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {

        if (raio <= 0) {
            throw new IllegalArgumentException(
                    "O raio deve ser maior que zero."
            );
        }

        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
