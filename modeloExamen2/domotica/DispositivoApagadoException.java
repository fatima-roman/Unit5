package domotica;

/**
 * Excepción para operaciones con dispositivo apagado.
 */
public class DispositivoApagadoException extends Exception {
    
    @Override
    public String toString() {
        return "Error: el dispositivo está apagado";
    }
}