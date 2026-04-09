package Extra1;

public class LavadoraIndustrial extends LavadoIndustrial implements Instalable {

    public LavadoraIndustrial(String id, String marca, String modelo,
                              double precioBase, double consumoHora,
                              int aniosGarantia, double horasEncendidoDia,
                              boolean usoIntensivo) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, usoIntensivo);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorUsoIntensivo(calcularPrecioBaseAjustado()) * 1.10;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.08 + (isUsoIntensivo() ? 120 : 60);
    }

    @Override
    public double calcularCosteInstalacion() {
        return 250;
    }

    @Override
    public boolean requiereTecnicoEspecializado() {
        return true;
    }
}