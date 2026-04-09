package EJ02;

public class Futbolista implements Comparable<Futbolista> {
    private int numeroCamiseta;
    private String nombre;
    private int edad;
    private int goles;

    public Futbolista(int numeroCamiseta, String nombre, int edad, int goles) {
        this.numeroCamiseta = numeroCamiseta;
        this.nombre = nombre;
        this.edad = edad;
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "Futbolista{camiseta=" + numeroCamiseta + ", nombre='" + nombre +
               "', edad=" + edad + ", goles=" + goles + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Futbolista)) return false;
        Futbolista otro = (Futbolista) obj;
        return this.numeroCamiseta == otro.numeroCamiseta &&
               this.nombre.equals(otro.nombre);
    }

    @Override
    public int compareTo(Futbolista otro) {
        int cmp = Integer.compare(this.numeroCamiseta, otro.numeroCamiseta);
        if (cmp != 0) return cmp;
        return this.nombre.compareTo(otro.nombre);
    }
}