package Extra1;

public abstract class RefrigeracionIndustrial extends EquipoHosteleria {
    private double potencia;

    public RefrigeracionIndustrial(String id, String marca, String modelo,
                                   double precioBase, double consumoHora,
                                   int aniosGarantia, double horasEncendidoDia,
                                   double potencia) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    protected double ajustarPorPotencia(double precio) {
        return precio + potencia * 15;
    }
}