package Extra1;

abstract class EquipoHosteleria {
	protected int id; 
	protected String marca; 
	protected String modelo; 
	protected double precioBase; 
	protected double consumoHora; 
	protected int aniosGarantia;
	private boolean usoIntensivo;
	private double potencia;
	
	
	// Getters
	public int getId() { return id; }
	public String getMarca() { return marca; }
	public String getModelo() { return modelo; }
	public double getPrecioBase() { return precioBase; }
	public double getConsumoHora() { return consumoHora; }
	public int getAniosGarantia() { return aniosGarantia; }
	public boolean isUsoIntensivo() { return usoIntensivo; }
	public double getPotencia() { return potencia; }

	// Setters con validación
	public void setId(int id) {
	    if (id >=0) {
	        this.id = id;
	    }
	}

	public void setMarca(String marca) {
	    if (marca != null && !marca.trim().isEmpty()) {
	        this.marca = marca.trim();
	    }
	}

	public void setModelo(String modelo) {
	    if (modelo != null && !modelo.trim().isEmpty()) {
	        this.modelo = modelo.trim();
	    }
	}

	public void setPrecioBase(double precioBase) {
	    if (precioBase > 0) {
	        this.precioBase = precioBase;
	    }
	}

	public void setConsumoHora(double consumoHora) {
	    if (consumoHora >= 0) {
	        this.consumoHora = consumoHora;
	    }
	}

	public void setAniosGarantia(int aniosGarantia) {
	    if (aniosGarantia >= 0) {
	        this.aniosGarantia = aniosGarantia;
	    }
	}

	public void setUsoIntensivo(boolean usoIntensivo) {
	    this.usoIntensivo = usoIntensivo;
	}

	public void setPotencia(double potencia) {
	    if (potencia > 0) {
	        this.potencia = potencia;
	    }
	}
	
	
	abstract double calcularCosteMantenimientoAnual() {
		
	}
	
}
