package EJ01;

import java.util.Arrays;

public class Socio implements Comparable<Socio> {
    private int id;
    private String nombre;
    private int edad;

    public Socio(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Socio{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
    }

    @Override
    public int compareTo(Socio otro) {
        return Integer.compare(this.id, otro.id);
    }
}