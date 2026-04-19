package domotica;

/**
 * Superclase para todos los dispositivos domóticos.
 * Atributos protegidos para herencia.
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {
    
    // Atributos protegidos (heredables)
    protected String nombreComercial;
    protected String marca;
    protected double precio;
    protected boolean encendido;
    
    // Constantes estáticas
    protected static final boolean ENCENDIDO_DEFAULT = false;
    
    /**
     * Constructor principal.
     */
    public Dispositivo(String nombreComercial, String marca, double precio) {
        this.nombreComercial = nombreComercial;
        this.marca = marca;
        this.precio = precio;
        this.encendido = ENCENDIDO_DEFAULT;
    }
    
    public void encender() {
        encendido = true;
    }
    
    public void apagar() {
        encendido = false;
    }
    
    // Getters
    public String getNombreComercial() { return nombreComercial; }
    public String getMarca() { return marca; }
    public double getPrecio() { return precio; }
    public boolean isEncendido() { return encendido; }
    
    @Override
    public int compareTo(Dispositivo o) {
        return Double.compare(this.precio, o.precio);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dispositivo)) return false;
        Dispositivo other = (Dispositivo) obj;
        return nombreComercial.equals(other.nombreComercial) &&
               marca.equals(other.marca);
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + 
               "{nombreComercial='" + nombreComercial + "', marca='" + marca + 
               "', precio=" + precio + ", encendido=" + encendido + "}";
    }
}