package EJ02;

import java.util.Arrays;

public class MainFut {
    public static void main(String[] args) {
        Futbolista[] equipo = {
            new Futbolista(10, "Messi", 36, 800),
            new Futbolista(7, "Ronaldo", 39, 900),
            new Futbolista(10, "Álvaro", 24, 12),
            new Futbolista(4, "Pedri", 21, 15),
            new Futbolista(7, "Benzema", 37, 354)
        };

        Arrays.sort(equipo);
        System.out.println(Arrays.toString(equipo));
    }
}