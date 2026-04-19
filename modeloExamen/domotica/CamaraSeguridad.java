package domotica;

/**
 * Cámara de seguridad que extiende Dispositivo.
 */
public class CamaraSeguridad extends Dispositivo {
    
    private String resolucion;
    private boolean grabando;
    private boolean alertaActiva;
    private String mensajeAlerta;
    
    public CamaraSeguridad(String nombreComercial, String marca, double precio, String resolucion) {
        super(nombreComercial, marca, precio);
        this.resolucion = resolucion;
        this.grabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
    
    public void iniciarGrabacion() throws DispositivoApagadoException {
        comprobarEncendido();
        grabando = true;
    }
    
    public void detenerGrabacion() {
        grabando = false;
    }
    
    public void activarAlerta(String mensaje) throws DispositivoApagadoException {
        comprobarEncendido();
        alertaActiva = true;
        mensajeAlerta = mensaje;
    }
    
    public void desactivarAlerta() throws DispositivoApagadoException {
        comprobarEncendido();
        alertaActiva = false;
        mensajeAlerta = "";
    }
    
    public boolean hayAlertaActiva() {
        return alertaActiva;
    }
    
    private void comprobarEncendido() throws DispositivoApagadoException {
        if (!isEncendido()) {
            throw new DispositivoApagadoException();
        }
    }
    
    // Getters
    public String getResolucion() { return resolucion; }
    public boolean isGrabando() { return grabando; }
    public String getMensajeAlerta() { return mensajeAlerta; }
    
    @Override
    public String toString() {
        return super.toString() + ", resolucion='" + resolucion + 
               "', grabando=" + grabando + ", alerta=" + alertaActiva + 
               ", msg='" + mensajeAlerta + "'";
    }
}