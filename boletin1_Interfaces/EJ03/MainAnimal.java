package EJ03;

public class MainAnimal {
    public static void main(String[] args) {
        Perro perro = new Perro("Toby", "Labrador", 25.5, "marrón");
        Gato gato = new Gato("Misi", "Europeo", 4.2, "gris");

        perro.hacerRuido();
        perro.comer();
        perro.dormir();
        perro.sacarPaseo();
        System.out.println("¿Hace caso? " + perro.hacerCaso());

        gato.hacerRuido();
        gato.comer();
        gato.dormir();
        gato.toserBolaPelo();
        System.out.println("¿Hace caso? " + gato.hacerCaso());
    }
}
