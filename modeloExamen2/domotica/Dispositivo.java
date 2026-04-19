package domotica;

/**
 * Clase base abstracta del modelo.
 *
 * ¿Para qué sirve una clase abstracta?
 * - Sirve para agrupar lo común de varias clases relacionadas.
 * - Permite reutilizar atributos y métodos sin repetir código.
 * - No se instancia directamente; se usa como plantilla general.
 *
 * ¿Por qué implementa Comparable?
 * - Porque queremos definir un criterio de ordenación natural.
 * - Si una clase implementa Comparable, Arrays.sort() puede ordenar
 *   automáticamente objetos de esa clase.
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {

    /**
     * protected:
     * - Se usa cuando las subclases necesitan acceder a los atributos heredados.
     * - No se hace public para no exponer innecesariamente el estado del objeto.
     */
    protected String nombreComercial;
    protected String marca;
    protected double precio;
    protected boolean encendido;

    /**
     * Constructor de la superclase.
     *
     * ¿Para qué sirve?
     * - Inicializa la parte común del objeto.
     * - Evita repetir la misma inicialización en todas las subclases.
     */
    public Dispositivo(String nombreComercial, String marca, double precio) {
        this.nombreComercial = nombreComercial;
        this.marca = marca;
        this.precio = precio;
        this.encendido = false;
    }

    /**
     * Los getters permiten acceso controlado a la información
     * sin exponer directamente los atributos.
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Métodos que modifican el estado del objeto.
     *
     * Encender/apagar es un comportamiento general que comparten
     * todos los objetos derivados de esta superclase.
     */
    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    /**
     * compareTo define el orden natural del objeto.
     *
     * ¿Para qué sirve?
     * - Para comparar dos objetos y decidir cuál va antes o después.
     * - Muy útil para ordenar arrays o colecciones.
     *
     * Reglas:
     * - negativo -> this va antes
     * - positivo -> this va después
     * - 0 -> equivalentes para ordenar
     */
    @Override
    public int compareTo(Dispositivo otro) {
        return Double.compare(this.precio, otro.precio);
    }

    /**
     * equals redefine la igualdad lógica del objeto.
     *
     * ¿Para qué sirve?
     * - En Java, == compara referencias de memoria.
     * - equals permite comparar si dos objetos representan la misma entidad.
     *
     * Siempre recibe Object porque así está definido en la clase Object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Dispositivo)) {
            return false;
        }

        Dispositivo otro = (Dispositivo) obj;
        return this.nombreComercial.equals(otro.nombreComercial)
                && this.marca.equals(otro.marca);
    }

    /**
     * toString convierte el objeto en una cadena legible.
     *
     * ¿Para qué sirve?
     * - Para imprimir el objeto de forma clara.
     * - Para depurar.
     * - Para mostrar información en consola.
     */
    @Override
    public String toString() {
        return "nombreComercial=" + nombreComercial
                + ", marca=" + marca
                + ", precio=" + precio
                + ", encendido=" + encendido;
    }
}