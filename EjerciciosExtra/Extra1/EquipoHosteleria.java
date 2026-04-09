package Extra1;

public abstract class EquipoHosteleria {
    private String id;
    private String marca;
    private String modelo;
    private double precioBase;
    private final double consumoHora;
    private int aniosGarantia;
    private double horasEncendidoDia;

    public EquipoHosteleria(String id, String marca, String modelo,
                            double precioBase, double consumoHora,
                            int aniosGarantia, double horasEncendidoDia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.consumoHora = consumoHora;
        this.aniosGarantia = aniosGarantia;
        this.horasEncendidoDia = horasEncendidoDia;
    }

    public double calcularConsumoAnual() {
        return consumoHora * horasEncendidoDia * 365;
    }

    public double calcularPrecioBaseAjustado() {
        return precioBase + (consumoHora * 10) + (aniosGarantia * 25);
    }

    public abstract double calcularPrecioFinal();
    public abstract double calcularCosteMantenimientoAnual();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAniosGarantia() {
        return aniosGarantia;
    }

    public void setAniosGarantia(int aniosGarantia) {
        this.aniosGarantia = aniosGarantia;
    }

    public double getHorasEncendidoDia() {
        return horasEncendidoDia;
    }

    public void setHorasEncendidoDia(double horasEncendidoDia) {
        this.horasEncendidoDia = horasEncendidoDia;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [id=" + id +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", precioBase=" + precioBase +
                ", consumoHora=" + consumoHora +
                ", añosGarantia=" + aniosGarantia +
                ", horas/día=" + horasEncendidoDia + "]";
    }
}

/*abstract class EquipoHosteleria {
	protected int id; 
	protected String marca; 
	protected String modelo; 
	protected double precioBase; 
	protected double consumoHora; 
	protected int aniosGarantia;
	private boolean usoIntensivo;
	private double potencia;
	
	
	public EquipoHosteleria(int id, String marca, String modelo, double precioBase, double consumoHora, int aniosGarantia) {
        setAniosGarantia(aniosGarantia);
        setId(id);
        setMarca(marca);
        setModelo(modelo);
        setPrecioBase(precioBase);
        setConsumoHora(consumoHora);
    }	
	
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
	
	
	 public double calcularPrecioFinal() {
	        double incrementoGarantia = aniosGarantia * 50;
	        double incrementoConsumo = consumoHora * 10;
	        return precioBase + incrementoGarantia + incrementoConsumo;
	    }

	    public abstract double calcularCosteMantenimientoAnual();

	    @Override
	   public String toString() {
	       return "EquipoHosteleria{" +
	           "id='" + id + '\'' +
	             ", marca='" + marca + '\'' +
	             		", modelo='" + modelo + '\'' +
	                ", precioBase=" + precioBase +
	                ", consumoHora=" + consumoHora +
	                ", aniosGarantia=" + aniosGarantia +
	                '}';
	    }
	}	*/

