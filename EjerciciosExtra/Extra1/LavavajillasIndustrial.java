package Extra1;

public class LavavajillasIndustrial extends LavadoIndustrial {

    public LavavajillasIndustrial(String id, String marca, String modelo,
                                  double precioBase, double consumoHora,
                                  int aniosGarantia, double horasEncendidoDia,
                                  boolean usoIntensivo) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, usoIntensivo);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorUsoIntensivo(calcularPrecioBaseAjustado()) * 1.08;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.07 + (isUsoIntensivo() ? 100 : 50);
    }
}