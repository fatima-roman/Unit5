package Extra1;

abstract class EquipoHosteleria {
	protected int id; 
	protected String marca; 
	protected String modelo; 
	protected double precioBase; 
	protected double consumoHora; 
	protected int aniosGarantia;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id <0) {
			this.id = 000; 
		}
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public double getConsumoHora() {
		return consumoHora;
	}
	public void setConsumoHora(double consumoHora) {
		this.consumoHora = consumoHora;
	}
	public int getAniosGarantia() {
		return aniosGarantia;
	}
	public void setAniosGarantia(int aniosGarantia) {
		this.aniosGarantia = aniosGarantia;
	} 
	
	
}
