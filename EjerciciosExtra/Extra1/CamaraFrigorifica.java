package Extra1;

public class CamaraFrigorifica extends RefrigeracionIndustrial implements Instalable {

    public CamaraFrigorifica(String id, String marca, String modelo,
                             double precioBase, double consumoHora,
                             int aniosGarantia, double horasEncendidoDia,
                             double potencia) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia, potencia);
    }

    @Override
    public double calcularPrecioFinal() {
        return ajustarPorPotencia(calcularPrecioBaseAjustado()) * 1.12;
    }

    @Override
    public double calcularCosteMantenimientoAnual() {
        return getPrecioBase() * 0.09 + getPotencia() * 8;
    }

    @Override
    public double calcularCosteInstalacion() {
        return 400;
    }

    @Override
    public boolean requiereTecnicoEspecializado() {
        return true;
    }
}