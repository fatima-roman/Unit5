package EJ03;

import java.util.Random;

public class Gato extends AnimalDomestico {
    private static final Random RANDOM = new Random();

    public Gato(String nombre, String raza, double peso, String color) {
        super(nombre, raza, peso, color);
    }

    @Override
    public void hacerRuido() {
        System.out.println(nombre + " dice: miau!");
    }

    @Override
    public boolean hacerCaso() {
        return RANDOM.nextInt(100) < 5; // 5%
    }

    public void toserBolaPelo() {
        System.out.println(nombre + " tose una bola de pelo.");
    }
}
