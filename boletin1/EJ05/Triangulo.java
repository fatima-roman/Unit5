package EJ05;

class Triangulo extends Poligono {
	
	private static final int NUM_LADOS = 3; 

	private double lado1 = 1; 
	private double lado2 = 1; 
	private double lado3 = 1; 
	
	public Triangulo(double lado1, double lado2, double lado3 ) {
		super(NUM_LADOS);
		setLado1(lado1);
		setLado2(lado2);
		setLado3(lado3);
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
	
	
	public double getLado3() {
		return lado2;
	}
	
	public void setLado3(double lado) {
		if (lado > 0 ) this.lado3 = lado; 
		else {
			System.out.println("Introduce valor positivo");
			return; 
		}	}


	@Override
	public double area() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
	}

	@Override
	public String toString() {
		return "Rectangulo: Número de lados: "+ numeroLados +", Lado1=" + lado1 + ", Lado2=" + lado2 + ", Lado3= "+ lado3;
	}
	
	

}
