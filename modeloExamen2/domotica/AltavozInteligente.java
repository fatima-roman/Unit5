package domotica;

/**
 * Subclase concreta del modelo.
 *
 * ¿Para qué sirve una subclase?
 * - Para especializar una superclase.
 * - Hereda lo común y añade lo específico.
 *
 * Además implementa Ajustable:
 * - esto obliga a definir subir() y bajar().
 */
public class AltavozInteligente extends Dispositivo implements Ajustable {

    /**
     * Atributos específicos del altavoz.
     */
    protected String asistente;
    protected int volumen;

    /**
     * super(...) llama al constructor de la superclase.
     *
     * ¿Para qué sirve?
     * - Para inicializar la parte heredada del objeto.
     * - Evita repetir código de la clase base.
     */
    public AltavozInteligente(String nombreComercial, String marca, double precio, String asistente) {
        super(nombreComercial, marca, precio);
        this.asistente = asistente;
        this.volumen = 30;
    }

    public String getAsistente() {
        return asistente;
    }

    public int getVolumen() {
        return volumen;
    }

    /**
     * Implementación concreta del método definido en la interfaz.
     *
     * Una interfaz dice "qué debe existir".
     * La clase decide "cómo se hace".
     *
     * Aquí se valida primero el estado del objeto y luego se modifica el nivel.
     */
    @Override
    public void subir() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        volumen += 5;

        /**
         * Esta limitación evita valores fuera de rango.
         * Es una validación típica del estado interno del objeto.
         */
        if (volumen > 100) {
            volumen = 100;
        }
    }

    @Override
    public void bajar() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        volumen -= 5;

        if (volumen < 0) {
            volumen = 0;
        }
    }

    /**
     * super.toString() reutiliza la representación común
     * y luego añade lo específico de la subclase.
     */
    @Override
    public String toString() {
        return "AltavozInteligente{"
                + super.toString()
                + ", asistente=" + asistente
                + ", volumen=" + volumen
                + "}";
    }
}