package EJ04;

public class Lavadora extends Electrodomestico {

	private double carga = 5; 
	
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	@Override
	public double precioFinal () {
		double precioLavadora = 0; 
		if (this.carga > 30) precioLavadora += 50;
		return super.precioFinal()+precioLavadora;
	}

}
