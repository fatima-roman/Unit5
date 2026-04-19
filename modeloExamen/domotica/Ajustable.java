package domotica;

public interface Ajustable {

    void subir() throws DispositivoApagadoException;

    void bajar() throws DispositivoApagadoException;
}