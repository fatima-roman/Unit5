package domotica;

/**
 * Otra subclase que implementa la misma interfaz Alertable.
 *
 * Esto demuestra que distintas clases pueden compartir una capacidad
 * aunque cada una tenga su propia lógica interna.
 */
public class CamaraSeguridad extends Dispositivo implements Alertable {

    protected String resolucion;
    protected boolean grabando;
    protected boolean alertaActiva;
    protected String mensajeAlerta;

    public CamaraSeguridad(String nombreComercial, String marca, double precio, String resolucion) {
        super(nombreComercial, marca, precio);
        this.resolucion = resolucion;
        this.grabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    public String getResolucion() {
        return resolucion;
    }

    public boolean isGrabando() {
        return grabando;
    }

    /**
     * Método específico de esta subclase.
     *
     * No viene de ninguna interfaz, sino de la propia lógica del tipo.
     */
    public void iniciarGrabacion() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        grabando = true;
    }

    public void detenerGrabacion() {
        grabando = false;
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
        return "CamaraSeguridad{"
                + super.toString()
                + ", resolucion=" + resolucion
                + ", grabando=" + grabando
                + ", alertaActiva=" + alertaActiva
                + ", mensajeAlerta=" + mensajeAlerta
                + "}";
    }
}