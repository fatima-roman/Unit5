package EJ03;

import java.util.Random;

public class Perro extends AnimalDomestico {
    private static final Random RANDOM = new Random();

    public Perro(String nombre, String raza, double peso, String color) {
        super(nombre, raza, peso, color);
    }

    @Override
    public void hacerRuido() {
        System.out.println(nombre + " dice: guau!");
    }

    @Override
    public boolean hacerCaso() {
        return RANDOM.nextInt(10) < 9; // 90%
    }

    public void sacarPaseo() {
        System.out.println(nombre + " sale a pasear.");
    }
}