package domotica;

/**
 * Altavoz inteligente que extiende Dispositivo.
 */
public class AltavozInteligente extends Dispositivo {
    
    // Atributos propios
    private String asistente;
    private int volumen;
    
    // Constantes
    private static final int VOL_DEFAULT = 30;
    private static final int VOL_MIN = 0;
    private static final int VOL_MAX = 100;
    private static final int INCREMENTO = 5;
    
    public AltavozInteligente(String nombreComercial, String marca, double precio, String asistente) {
        super(nombreComercial, marca, precio);
        this.asistente = asistente;
        this.volumen = VOL_DEFAULT;
    }
    
    public void subir() throws DispositivoApagadoException {
        comprobarEncendido();
        volumen = Math.min(VOL_MAX, volumen + INCREMENTO);
    }
    
    public void bajar() throws DispositivoApagadoException {
        comprobarEncendido();
        volumen = Math.max(VOL_MIN, volumen - INCREMENTO);
    }
    
    // Método privado helper (estilo profesor)
    private void comprobarEncendido() throws DispositivoApagadoException {
        if (!isEncendido()) {
            throw new DispositivoApagadoException();
        }
    }
    
    // Getters
    public String getAsistente() { return asistente; }
    public int getVolumen() { return volumen; }
    
    @Override
    public String toString() {
        return super.toString() + ", asistente='" + asistente + "', volumen=" + volumen + "}";
    }
}