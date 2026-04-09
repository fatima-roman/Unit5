package Extra1;

public class ArconCongelador extends RefrigeracionIndustrial {

    public ArconCongelador(String id, String marca, String modelo,
                           double precioBase, double consumoHora,
                           int aniosGarantia, double horasEncendidoDia,
                           double potencia) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, potencia);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorPotencia(calcularPrecioBaseAjustado()) * 1.09;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.06 + getPotencia() * 6;
    }
}