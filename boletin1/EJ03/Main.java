package EJ03;

public class Main {
    public static void main(String[] args) {
        Producto gen = new Producto("Genérico", 10.0);
        System.out.println("Genérico: " + gen);
        System.out.println("Calcular 5: " + gen.calcular(5));  // 50.0
        
        Perecedero leche1 = new Perecedero("Leche", 2.0, 1);
        System.out.println("Leche (1 día): " + leche1);
        System.out.println("Calcular 10: " + leche1.calcular(10));  // 5.0 (/4)
        
        Perecedero fruta = new Perecedero("Fruta", 4.0, 2);
        System.out.println("Fruta (2 días): " + fruta);
        System.out.println("Calcular 5: " + fruta.calcular(5));    // 6.666 (/3)
        
        Perecedero pan = new Perecedero("Pan", 1.5, 3);
        System.out.println("Pan (3 días): " + pan);
        System.out.println("Calcular 8: " + pan.calcular(8));      // 6.0 (/2)
        
        Perecedero leche2 = new Perecedero("Leche fresca", 2.5, 5);  // >3 días
        System.out.println("Leche fresca (>3 días): " + leche2);
        System.out.println("Calcular 4: " + leche2.calcular(4));    // 10.0 (sin descuento)
        
        NoPerecedero lata = new NoPerecedero("Atún", 3.5, "Conserva");
        System.out.println("Atún: " + lata);
        System.out.println("Calcular 6: " + lata.calcular(6));     // 21.0
        
        // Pruebas setters (modifican calcular)
        leche1.setPrecio(3.0);
        leche1.setDiasCaducar(0);  // Edge case: sin descuento extra
        System.out.println("Leche modificada (precio=3, días=0): " + leche1.calcular(2));  // 6.0
        
        lata.setTipo("En aceite");
        lata.setPrecio(4.0);
        System.out.println("Atún modificado: " + lata);
        
        
        // Getters independientes
        System.out.println("\n=== Getters ===");
        System.out.println("Nombre lata: " + lata.getNombre());
        System.out.println("Días leche1: " + leche1.getDiasCaducar());
        System.out.println("Tipo lata: " + lata.getTipo());
    }
}
