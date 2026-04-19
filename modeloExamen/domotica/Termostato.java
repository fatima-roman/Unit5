package domotica;

/**
 * Termostato que extiende Dispositivo.
 */
public class Termostato extends Dispositivo {
    
    private double temperaturaObjetivo;
    private ModoTermostato modo;
    private boolean alertaActiva;
    private String mensajeAlerta;
    
    public Termostato(String nombreComercial, String marca, double precio, 
                      double temperaturaObjetivo, ModoTermostato modo) {
        super(nombreComercial, marca, precio);
        this.temperaturaObjetivo = temperaturaObjetivo;
        this.modo = modo;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
    
    public void cambiarModo() {
        modo = (modo == ModoTermostato.CALEFACCION) ? 
               ModoTermostato.REFRIGERACION : ModoTermostato.CALEFACCION;
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
    
    // Getters/Setters
    public double getTemperaturaObjetivo() { return temperaturaObjetivo; }
    public void setTemperaturaObjetivo(double temperaturaObjetivo) { this.temperaturaObjetivo = temperaturaObjetivo; }
    public ModoTermostato getModo() { return modo; }
    public String getMensajeAlerta() { return mensajeAlerta; }
    
    @Override
    public String toString() {
        return super.toString() + ", temp=" + temperaturaObjetivo + 
               ", modo=" + modo + ", alerta=" + alertaActiva + 
               ", msg='" + mensajeAlerta + "'";
    }
}