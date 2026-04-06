package EJ04;

class Television extends Electrodomestico {
	
	private double resolucion = 20; 
	private boolean TDT = false; 

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
    }

    public Television(double precioBase, String color, char consumoEnergetico, double peso, double resolucion, boolean tdt) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.TDT = tdt;
    }

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTDT() {
		return TDT;
	}

	public void setTDT(boolean tDT) {
		TDT = tDT;
	}
	
	@Override
	public double precioFinal() {
		double precio = super.precioFinal();
		
		if (this.resolucion >= 40) precio += (super.getPrecioBase()*0.30);
		if (this.TDT) precio += 50; 
		
		return precio; 
	}

}
