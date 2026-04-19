package domotica;

/**
 * Interfaz que representa una capacidad.
 *
 * ¿Para qué sirve una interfaz?
 * - Para definir comportamientos comunes entre clases distintas.
 * - No guarda estado; define operaciones que otras clases deben implementar.
 * - Es útil cuando varias clases comparten "lo que hacen", aunque no sean iguales.
 *
 * Aquí representa la capacidad de subir o bajar un nivel.
 */
public interface Ajustable {

    /**
     * Método abstracto de la interfaz.
     *
     * void:
     * - El método realiza una acción y no devuelve ningún valor.
     *
     * throws DispositivoApagadoException:
     * - Indica que el método puede lanzar esa excepción.
     * - Obliga al programador a tratar el posible error.
     * - Es una forma de dejar claro en la firma del método
     *   que la operación depende del estado del objeto.
     *
     * En general:
     * - subir() puede representar subir volumen, brillo, velocidad,
     *   temperatura, nivel de potencia, etc.
     */
    void subir() throws DispositivoApagadoException;

    /**
     * Igual que subir(), pero para disminuir un nivel.
     */
    void bajar() throws DispositivoApagadoException;
}