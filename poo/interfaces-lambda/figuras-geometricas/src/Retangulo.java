public class Retangulo implements CalcularArea{

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {

        if (base <= 0) {
            throw new IllegalArgumentException(
                    "A base deve ser maior que zero."
            );
        }

        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {

            if (altura <= 0) {
                throw new IllegalArgumentException(
                        "A altura deve ser maior que zero."
                );
            }

            this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

}
