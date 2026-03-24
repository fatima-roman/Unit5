package EJ01;

public class Main {
    public static void main(String[] args) {
        // Prueba Hora básica
        Hora h = new Hora(25, 70);  // Valores inválidos → 00:00
        System.out.println("Hora inválida: " + h.getHora() + ":" + h.getMinuto());

        h.setHora(14);
        h.setMinuto(30);
        System.out.println("Hora válida: " + h.getHora() + ":" + h.getMinuto());

        // Incrementos en Hora (minutos)
        for (int i = 0; i < 5; i++) {
            h.inc();
            System.out.print(h.getHora() + ":" + h.getMinuto() + " ");
        }
        System.out.println();  // 14:35

        // Prueba HoraExacta (herencia)
        HoraExacta he = new HoraExacta(23, 59, 58);
        System.out.println("HoraExacta: " + he.getHora() + ":" + he.getMinuto() + ":" + he.getSegundos());

        // Incrementos en HoraExacta (segundos → minutos → horas)
        he.inc();  // 23:59:59
        System.out.println("Tras 1 inc: " + he.getHora() + ":" + he.getMinuto() + ":" + he.getSegundos());
        he.inc();  // 00:00:00 (reinicio)
        System.out.println("Tras 2 inc: " + he.getHora() + ":" + he.getMinuto() + ":" + he.getSegundos());
    }
}
