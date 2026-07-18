public class Quadrado implements CalcularArea{

    private double lado;

    public Quadrado(double lado) {
        setLado(lado);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException(
                    "O lado deve ser maior que zero."
            );
        }

        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
