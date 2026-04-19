package domotica;

/**
 * Interfaz para objetos que pueden activar y desactivar alertas.
 *
 * Este patrón es reutilizable para muchos dominios:
 * alarmas, sensores, vigilancia, incidencias, estados críticos, etc.
 */
public interface Alertable {

    /**
     * Activa una alerta.
     *
     * El parámetro mensaje permite asociar información concreta
     * sobre el motivo o contenido de la alerta.
     */
    void activarAlerta(String mensaje) throws DispositivoApagadoException;

    /**
     * Desactiva una alerta existente.
     */
    void desactivarAlerta() throws DispositivoApagadoException;

    /**
     * Devuelve si el objeto tiene una alerta activa.
     *
     * Este tipo de método suele ser de consulta:
     * - no modifica estado
     * - solo informa
     */
    boolean hayAlertaActiva();
}