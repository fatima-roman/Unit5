package Extra2;

public class BarcoArrastrero extends EmbarcacionPesquera{
	
	private final double FACTOR = 0.05; // Toneladas/potencia-hora (ajusta según datos reales)
	private double horasArrastre;
	private double potencia;
	private int horasArraste;

    public BarcoArrastrero(String matricula, String nombre, double carga, double combustible, String zona, int tripulantes, int dias, double horas, double potencia) {
        super(matricula, nombre, carga, combustible, zona, tripulantes, dias);
        setHorasArrastre(horas);
        setPotencia(potencia);
    }

	public BarcoArrastrero(String matricula, double carga, String nombre, double horas, double potencia) {
		super(matricula, carga, nombre);
		setHorasArrastre(horas);
		setPotencia(potencia);
	}

	public double getHorasArrastre() {
		return horasArrastre;
	}

	public void setHorasArrastre(double horasArrastre) {
		if (horasArrastre < 0) { 
            throw new IllegalArgumentException("Horas de arrastre >= 0");
        }
        this.horasArrastre = horasArrastre;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	@Override
	public double calcularCapturaMaximaDiaria() {
	    return potencia * horasArrastre * FACTOR;
	}
	
	@Override
    public double calcularConsumoEstimado() {
        double consumoEspecifico = 0.22;
        double factorCarga = Math.min(1.2, 0.8 + (capacidadCargaToneladas / 1000));
        return potencia * horasArraste * consumoEspecifico * factorCarga;
    }

	@Override
	public String mostrarFicha() {
	    return String.format("""
	        ╔═════════════════════════════════════════════════════
	        ║              FICHA BARCO ARRASTRERO                 
	        ╠═════════════════════════════════════════════════════
	        ║ Matrícula:     %s                                   
	        ║ Nombre:        %s                                   
	        ║ Cap. Carga:    %.1f toneladas                      
	        ║ Combustible:   %.0f litros                         
	        ║ Zona:          %s                                   
	        ║ Tripulantes:   %d                                   
	        ║ Autonomía:     %d días                              
	        ║ Potencia:      %.0f CV                              
	        ║ Horas arrastre:%.1f h/día                          
	        ╠════════════════════════════════════════════════════
	        ║ Captura máx:   %.1f toneladas/día                  
	        ║ Consumo estim: %.0f litros/día                     
	        ╚════════════════════════════════════════════════════
	        """, matricula, nombre, capacidadCargaToneladas,
	        combustibleDisponible, zonaOperacion, tripulantes,
	        diasMaxAutonomia, potencia, horasArraste,
	        calcularCapturaMaximaDiaria(), calcularConsumoEstimado()); 
	}
	
    protected double eficiencia() {
        return calcularConsumoEstimado() > 0 ? 
               calcularCapturaMaximaDiaria() / calcularConsumoEstimado() : 0;
    }
	
}
