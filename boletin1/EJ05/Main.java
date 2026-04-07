package EJ05;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
private static Scanner reader = new Scanner(System.in);
private static ArrayList<Poligono> poligonos = new ArrayList<>();
	    
	public static void main(String[] args) {
		
	    
		System.out.println("1. Introducir triángulo.\r\n"
				+ "2. Introducir rectángulo.\r\n"
				+ "3. Mostrar polígonos.\r\n"
				+ "");
		int opc = reader.nextInt();

		switch (opc) {
		case 1 -> pedirTriangulo();
		case 2 -> pedirRectangulo();
		case 3 -> mostrarDatos();
		}
		
	}
	
	private static double pedirLado ( Scanner reader, int i) {
		System.out.println("Introduce el lado " + i);
		return reader.nextDouble();
	}

	private static void pedirRectangulo() {
		System.out.println("Introducir un rectángulo");
		double lado1= pedirLado(reader, 1);
		double lado2= pedirLado(reader, 2);
				
		poligonos.add(new Rectangulo(lado1, lado2));
	}
	
	private static void pedirTriangulo() {
		System.out.println("Introducir un triángulo");
		double lado1= pedirLado(reader, 1);
		double lado2= pedirLado(reader, 2);
		double lado3= pedirLado(reader, 3);

		poligonos.add(new Triangulo(lado1,lado2,lado3));
	}
	
	private static void mostrarDatos() {
		System.out.println("Mostrar datos");
        if (poligonos.isEmpty()) {
            System.out.println("No hay polígonos almacenados.");
            return;
        }

        for (int i = 0; i < poligonos.size(); i++) {
            Poligono p = poligonos.get(i);
            System.out.println("\nPolígono " + (i + 1) + ":");
            System.out.println(p);
            System.out.println("Área: " + p.area());
        }
	}

}
