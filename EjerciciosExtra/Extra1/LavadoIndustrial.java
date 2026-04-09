package Extra1;

public abstract class LavadoIndustrial extends EquipoHosteleria {
    private boolean usoIntensivo;

    public LavadoIndustrial(String id, String marca, String modelo,
                            double precioBase, double consumoHora,
                            int aniosGarantia, double horasEncendidoDia,
                            boolean usoIntensivo) {
        super(id, marca, modelo, precioBase, consumoHora, aniosGarantia, horasEncendidoDia);
        this.usoIntensivo = usoIntensivo;
    }

    public boolean isUsoIntensivo() {
        return usoIntensivo;
    }

    public void setUsoIntensivo(boolean usoIntensivo) {
        this.usoIntensivo = usoIntensivo;
    }

    protected double ajustarPorUsoIntensivo(double precio) {
        return usoIntensivo ? precio * 1.20 : precio;
    }
}