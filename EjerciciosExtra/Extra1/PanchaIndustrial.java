package Extra1;

public class PanchaIndustrial extends CoccionIndustrial {

    public PanchaIndustrial(String id, String marca, String modelo,
                             double precioBase, double consumoHora,
                             int aniosGarantia, double horasEncendidoDia,
                             boolean altaProduccion) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, altaProduccion);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorProduccion(calcularPrecioBaseAjustado()) * 1.07;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.05 + (isAltaProduccion() ? 90 : 40);
    }
}