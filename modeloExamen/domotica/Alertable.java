package domotica;

public interface Alertable {

    void activarAlerta(String mensaje) throws DispositivoApagadoException;

    void desactivarAlerta() throws DispositivoApagadoException;

    boolean hayAlertaActiva();
}