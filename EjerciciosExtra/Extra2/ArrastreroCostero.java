package Extra2;

public class ArrastreroCostero extends BarcoArrastrero {

    public ArrastreroCostero(String matricula, String nombre, double carga, double combustible, 
                            String zona, int tripulantes, int dias, double horas, double potencia) {
        super(matricula, nombre, carga, combustible, zona, tripulantes, dias, horas, potencia);
        // Costero: ajusta parámetros específicos si quieres
        setHorasArrastre(Math.min(horas, 10)); // Máx 10h costero
    }

    @Override
    public double calcularCapturaMaximaDiaria() {
        // COASTERO: -20% vs arrastrero genérico
        return super.calcularCapturaMaximaDiaria() * 0.8;
    }

    @Override
    public double calcularConsumoEstimado() {
        // COASTERO: menor potencia/menos consumo
        return super.calcularConsumoEstimado() * 0.75;
    }

    @Override
    public String mostrarFicha() {
        return String.format("""
            ╔═════════════════════════════════════════════════════
            ║           FICHA ARRASTRERO COSTERO                   
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
            ╠═════════════════════════════════════════════════════
            ║ Captura máx:   %.1f toneladas/día (costero)        
            ║ Consumo estim: %.0f litros/día                     
            ║ Eficiencia:    %.3f T/litro                        
            ╚═════════════════════════════════════════════════════
            """, getMatricula(), getNombre(), getCapacidadCargaToneladas(),
            getCombustibleDisponible(), getZonaOperacion(), getTripulantes(),
            getDiasMaxAutonomia(), getPotencia(), getHorasArrastre(),
            calcularCapturaMaximaDiaria(), calcularConsumoEstimado(),
            eficiencia());
    }
}