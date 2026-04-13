package Extra2;

public class BarcoPalangrero extends EmbarcacionPesquera {
    private int numAnzuelos;
    private double rendimientoMedio; // kg/anzuelo-día
    
    public BarcoPalangrero(String matricula, String nombre, double carga, double combustible, 
                          String zona, int tripulantes, int dias, 
                          int anzuelos, double rendimiento) {
        super(matricula, nombre, carga, combustible, zona, tripulantes, dias);
        setNumAnzuelos(anzuelos);
        setRendimientoMedio(rendimiento);
    }
    
    // GETTERS/SETTERS
    public int getNumAnzuelos() { return numAnzuelos; }
    public void setNumAnzuelos(int numAnzuelos) {
        if (numAnzuelos < 0) throw new IllegalArgumentException("Anzuelos >= 0");
        this.numAnzuelos = numAnzuelos;
    }
    
    public double getRendimientoMedio() { return rendimientoMedio; }
    public void setRendimientoMedio(double rendimientoMedio) {
        if (rendimientoMedio < 0) throw new IllegalArgumentException("Rendimiento >= 0");
        this.rendimientoMedio = rendimientoMedio;
    }
    
    @Override
    public double calcularCapturaMaximaDiaria() {
        // PALANGUREROS: anzuelos × rendimiento × factor_tiempo
        return numAnzuelos * rendimientoMedio * 0.85 / 1000.0; // Toneladas
    }
    
    @Override
    public double calcularConsumoEstimado() {
        // Bajo consumo (lentos, palangre manual)
        double consumoBase = getTripulantes() * 80;  // L/tripulante
        return Math.min(800, consumoBase); // Límite realista
    }
    
    @Override
    public String mostrarFicha() {
        return String.format("""
            ╔════════════════════════════════════════════════════
            ║             FICHA BARCO PALANGRERO                  
            ╠════════════════════════════════════════════════════
            ║ Matrícula:     %s                                  
            ║ Nombre:        %s                                  
            ║ Cap. Carga:    %.1f toneladas                     
            ║ Combustible:   %.0f litros                        
            ║ Zona:          %s                                  
            ║ Tripulantes:   %d                                   
            ║ Autonomía:     %d días                              
            ║ Anzuelos:      %d                                   
            ║ Rendimiento:   %.2f kg/anz/día                     
            ╠═════════════════════════════════════════════════════
            ║ Captura máx:   %.1f toneladas/día                 
            ║ Consumo estim: %.0f litros/día                    
            ║ Eficiencia:    %.3f T/litro                        
            ╚═════════════════════════════════════════════════════
            """, matricula, nombre, capacidadCargaToneladas,
	        combustibleDisponible, zonaOperacion, tripulantes,
	        diasMaxAutonomia, numAnzuelos, rendimientoMedio,
            calcularCapturaMaximaDiaria(), calcularConsumoEstimado(),
            eficiencia());
    }
    
    private double eficiencia() {
        return calcularConsumoEstimado() > 0 ? 
               calcularCapturaMaximaDiaria() / calcularConsumoEstimado() : 0;
    }
}