package Extra1;

public class HornoIndustrial extends CoccionIndustrial implements Instalable {

    public HornoIndustrial(String id, String marca, String modelo,
                           double precioBase, double consumoHora,
                           int aniosGarantia, double horasEncendidoDia,
                           boolean altaProduccion) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, altaProduccion);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorProduccion(calcularPrecioBaseAjustado()) * 1.15;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.10 + (isAltaProduccion() ? 150 : 80);
    }

    @Override
    public double calcularCosteInstalacion() {
        return 500;
    }

    @Override
    public boolean requiereTecnicoEspecializado() {
        return true;
    }
}