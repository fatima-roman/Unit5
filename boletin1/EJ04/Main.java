package EJ04;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Electrodomestico> lista = new ArrayList<>();

        lista.add(new Electrodomestico(200, "negro", 'B', 12));
        lista.add(new Lavadora(300, "rojo", 'A', 40, 35));
        lista.add(new Lavadora(150, "azul", 'E', 25, 20));
        lista.add(new Television(500, "gris", 'C', 10, 50, true));
        lista.add(new Television(250, "blanco", 'F', 8, 32, false));

        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisiones = 0;

        for (Electrodomestico e : lista) {
            double precioFinal = e.precioFinal();
            totalElectrodomesticos += precioFinal;

            if (e instanceof Lavadora) {
                totalLavadoras += precioFinal;
            } else if (e instanceof Television) {
                totalTelevisiones += precioFinal;
            }
        }

        System.out.println("Total electrodomésticos: " + totalElectrodomesticos + " €");
        System.out.println("Total lavadoras: " + totalLavadoras + " €");
        System.out.println("Total televisiones: " + totalTelevisiones + " €");
    }
}