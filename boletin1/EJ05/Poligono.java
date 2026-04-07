package EJ05;

abstract class Poligono {
	
	protected int numeroLados; 
	
	public Poligono( int numeroLados) {
		setNumeroLados(numeroLados); 
	}

	public int getNumeroLados() {
		return numeroLados;
	}

	public void setNumeroLados(int numeroLados) {
		if (numeroLados >0 ) this.numeroLados = numeroLados; 
		else {
			System.out.println("Introduce un número positivo");
			this.numeroLados = 0; 
		}
	}

	@Override
	public String toString() {
		return "Poligono [numeroLados=" + numeroLados + "]";
	}
	
	
    public abstract double area();
	

}
