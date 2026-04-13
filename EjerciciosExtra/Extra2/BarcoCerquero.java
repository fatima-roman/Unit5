package Extra2;

public class BarcoCerquero extends EmbarcacionPesquera {

	private double capacidadRed; 
	private double volumenBanco; 
	
	public BarcoCerquero(String matricula, String nombre, double carga, double combustible, String zona,
			int tripulantes, int dias, double capacidadRed, double volumenBanco) {
		super(matricula, nombre, carga, combustible, zona, tripulantes, dias);
		setCapacidadCarga(capacidadRed);
		setVolumenBanco(volumenBanco);
	}
	
	public BarcoCerquero(String matricula, double carga, String nombre, double horas, double potencia, double capacidadRed, double volumenBanco) {
		super(matricula, carga, nombre);
		setCapacidadCarga(capacidadRed);
		setVolumenBanco(volumenBanco);
	}
	
	public double getCapacidadRed() {
	    return capacidadRed;
	}

	public double getVolumenBanco() {
	    return volumenBanco;
	}

	public void setCapacidadRed(double capacidadRed) {
	    if (capacidadRed <= 0) {
	        throw new IllegalArgumentException("Capacidad red debe ser > 0 m³");
	    }
	    if (capacidadRed > 5000) { 
	        throw new IllegalArgumentException("Capacidad red ≤ 5000 m³");
	    }
	    this.capacidadRed = capacidadRed;
	}

	public void setVolumenBanco(double volumenBanco) {
	    if (volumenBanco < 0) {
	        throw new IllegalArgumentException("Volumen banco >= 0 m³");
	    }
	    this.volumenBanco = volumenBanco;
	}

	@Override
	public double calcularCapturaMaximaDiaria() {
	    double densidadAtun = 0.75; // ton/m³ (atún típico)
	    double capturaTeorica = Math.min(capacidadRed, volumenBanco) * densidadAtun;
	    return Math.max(0, capturaTeorica); // No negativo
	}

	@Override
	public double calcularConsumoEstimado() {
	    double consumoBase = capacidadRed * 0.15;  // L/m³ red (cerco lento)
	    double consumoNaveg = getCapacidadCargaToneladas() * 0.8; // L/ton carga
	    return consumoBase + consumoNaveg; // Total día
	}

	@Override
	public String mostrarFicha() {
	    return String.format("""
	        ╔═════════════════════════════════════════════════════
	        ║              FICHA BARCO CERQUERO                 
	        ╠═════════════════════════════════════════════════════
	        ║ Matrícula:     %s                                   
	        ║ Nombre:        %s                                   
	        ║ Cap. Carga:    %.1f toneladas                      
	        ║ Combustible:   %.0f litros                         
	        ║ Zona:          %s                                   
	        ║ Tripulantes:   %d                                   
	        ║ Autonomía:     %d días                              
	        ║ Capacidad Red: %.0f                               
	        ║ Volumen banco: %.1f                         
	        ╠════════════════════════════════════════════════════
	        ║ Captura máx:   %.1f toneladas/día                  
	        ║ Consumo estim: %.0f litros/día                     
	        ╚════════════════════════════════════════════════════
	        """, matricula, nombre, capacidadCargaToneladas,
	        combustibleDisponible, zonaOperacion, tripulantes,
	        diasMaxAutonomia, capacidadRed, volumenBanco,
	        calcularCapturaMaximaDiaria(), calcularConsumoEstimado()); 
	}

}
