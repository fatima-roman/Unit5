package domotica;

/**
 * Excepción personalizada.
 *
 * ¿Para qué sirve crear una excepción propia?
 * - Para representar errores específicos del dominio del problema.
 * - Hace el código más claro que usar una Exception genérica.
 * - Permite expresar mejor qué ha fallado.
 *
 * En este caso indica que se intenta ejecutar una operación
 * que solo tiene sentido cuando el dispositivo está encendido.
 */
public class DispositivoApagadoException extends Exception {

    /**
     * toString se sobrescribe para mostrar un mensaje claro
     * cuando se imprima la excepción.
     */
    @Override
    public String toString() {
        return "Error: el dispositivo está apagado";
    }
}