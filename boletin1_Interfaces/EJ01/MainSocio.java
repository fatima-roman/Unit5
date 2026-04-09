package EJ01;

import java.util.Arrays;

public class MainSocio {
    public static void main(String[] args) {
        Socio s1 = new Socio(3, "Ana", 21);
        Socio s2 = new Socio(1, "Luis", 30);

        System.out.println(s1.compareTo(s2)); // positivo

        Socio[] socios = {
            new Socio(5, "Marta", 19),
            new Socio(2, "Pedro", 24),
            new Socio(4, "Sara", 28),
            new Socio(1, "Nico", 20)
        };

        Arrays.sort(socios);
        System.out.println(Arrays.toString(socios));
    }
}
