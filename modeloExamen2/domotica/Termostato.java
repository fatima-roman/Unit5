package domotica;

/**
 * Subclase que implementa Alertable.
 *
 * Muestra cómo una clase puede heredar de una superclase
 * y además implementar una interfaz.
 */
public class Termostato extends Dispositivo implements Alertable {

    protected double temperaturaObjetivo;
    protected ModoTermostato modo;
    protected boolean alertaActiva;
    protected String mensajeAlerta;

    public Termostato(String nombreComercial, String marca, double precio,
                      double temperaturaObjetivo, ModoTermostato modo) {
        super(nombreComercial, marca, precio);
        this.temperaturaObjetivo = temperaturaObjetivo;
        this.modo = modo;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    public double getTemperaturaObjetivo() {
        return temperaturaObjetivo;
    }

    public void setTemperaturaObjetivo(double temperaturaObjetivo) {
        this.temperaturaObjetivo = temperaturaObjetivo;
    }

    public ModoTermostato getModo() {
        return modo;
    }

    /**
     * Método de negocio propio.
     *
     * Este patrón es muy común:
     * un método encapsula una transición de estado
     * sin que el exterior tenga que conocer los detalles.
     */
    public void cambiarModo() {
        if (modo == ModoTermostato.CALEFACCION) {
            modo = ModoTermostato.REFRIGERACION;
        } else {
            modo = ModoTermostato.CALEFACCION;
        }
    }

    @Override
    public void activarAlerta(String mensaje) throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        alertaActiva = true;
        mensajeAlerta = mensaje;
    }

    @Override
    public void desactivarAlerta() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        alertaActiva = false;
        mensajeAlerta = "";
    }

    @Override
    public boolean hayAlertaActiva() {
        return alertaActiva;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    @Override
    public String toString() {
        return "Termostato{"
                + super.toString()
                + ", temperaturaObjetivo=" + temperaturaObjetivo
                + ", modo=" + modo
                + ", alertaActiva=" + alertaActiva
                + ", mensajeAlerta=" + mensajeAlerta
                + "}";
    }
}