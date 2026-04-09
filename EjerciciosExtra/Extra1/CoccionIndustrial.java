package Extra1;

public abstract class CoccionIndustrial extends EquipoHosteleria {
    private boolean altaProduccion;

    public CoccionIndustrial(String id, String marca, String modelo,
                             double precioBase, double consumoHora,
                             int aniosGarantia, double horasEncendidoDia,
                             boolean altaProduccion) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia);
        this.altaProduccion = altaProduccion;
    }

    public boolean isAltaProduccion() {
        return altaProduccion;
    }

    public void setAltaProduccion(boolean altaProduccion) {
        this.altaProduccion = altaProduccion;
    }

    protected double ajustarPorProduccion(double precio) {
        return altaProduccion ? precio * 1.25 : precio;
    }
}