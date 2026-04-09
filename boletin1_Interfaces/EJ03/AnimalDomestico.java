package EJ03;

public abstract class AnimalDomestico implements Vivir {
    protected String nombre;
    protected String raza;
    protected double peso;
    protected String color;

    public AnimalDomestico(String nombre, String raza, double peso, String color) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
    }

    public void vacunar() {
        System.out.println(nombre + " ha sido vacunado.");
    }

    @Override
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    public abstract boolean hacerCaso();
}