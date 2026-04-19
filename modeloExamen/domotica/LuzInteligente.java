package domotica;

/**
 * Luz inteligente que extiende Dispositivo.
 */
public class LuzInteligente extends Dispositivo {
    
    private String color;
    private int brillo;
    
    private static final int BRILLO_DEFAULT = 50;
    private static final int BRILLO_MIN = 0;
    private static final int BRILLO_MAX = 100;
    private static final int INCREMENTO = 10;
    
    public LuzInteligente(String nombreComercial, String marca, double precio, String color) {
        super(nombreComercial, marca, precio);
        this.color = color;
        this.brillo = BRILLO_DEFAULT;
    }
    
    public void subir() throws DispositivoApagadoException {
        comprobarEncendido();
        brillo = Math.min(BRILLO_MAX, brillo + INCREMENTO);
    }
    
    public void bajar() throws DispositivoApagadoException {
        comprobarEncendido();
        brillo = Math.max(BRILLO_MIN, brillo - INCREMENTO);
    }
    
    private void comprobarEncendido() throws DispositivoApagadoException {
        if (!isEncendido()) {
            throw new DispositivoApagadoException();
        }
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() { return color; }
    public int getBrillo() { return brillo; }
    
    @Override
    public String toString() {
        return super.toString() + ", color='" + color + "', brillo=" + brillo + "}";
    }
}