package EJ05;

class Rectangulo extends Poligono {
	
	private static final int NUM_LADOS = 0;

	private double lado1 = 1; 
	private double lado2 = 1; 
	
	public Rectangulo(double lado1, double lado2) {
		super(NUM_LADOS);
		setLado1(lado1);
		setLado2(lado2);
	}
	
	public double getLado1() {
		return lado1;
	}
	
	public void setLado1(double lado) {
		if (lado > 0 ) this.lado1 = lado; 
		else {
			System.out.println("Introduce valor positivo");
			return; 
		}
	}
	
	public double getLado2() {
		return lado2;
	}
	
	public void setLado2(double lado) {
		if (lado > 0 ) this.lado2 = lado; 
		else {
			System.out.println("Introduce valor positivo");
			return; 
		}	}


	@Override
	public double area() {
		return lado1 * lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo: Número de lados: "+ numeroLados +", Lado1=" + lado1 + ", Lado2=" + lado2;
	}
	
	

}
