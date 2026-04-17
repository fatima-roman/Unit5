package Extra2;

public abstract class EmbarcacionPesquera {
    protected String matricula; 
    protected String nombre; 
    protected double capacidadCargaToneladas; 
    protected double combustibleDisponible; 
    protected String zonaOperacion; 
    protected int tripulantes; 
    protected int diasMaxAutonomia; 

    public EmbarcacionPesquera(String matricula, String nombre, double carga, double combustible, String zona, int tripulantes, int dias) {
        setMatricula(matricula);
        setNombre(nombre);
        setCapacidadCarga(carga);
        setCombustibleDisponible(combustible);
        setZonaOperacion(zona);  
        setTripulantes(tripulantes);
        setDiasMaxAutonomia(dias);
    }

    public EmbarcacionPesquera(String matricula, double carga, String nombre) {
        this(matricula, nombre, carga, 0.0, "Sin asignar", 1, 1); 
    }

    public String getMatricula() { return matricula; }
    public String getNombre() { return nombre; }
    public double getCapacidadCargaToneladas() { return capacidadCargaToneladas; }
    public double getCombustibleDisponible() { return combustibleDisponible; }
    public String getZonaOperacion() { return zonaOperacion; }
    public int getTripulantes() { return tripulantes; }
    public int getDiasMaxAutonomia() { return diasMaxAutonomia; }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.length() != 11 ||
            !matricula.matches("[A-Z]{3}\\s\\d{4}\\s[A-Z]")) {
            throw new IllegalArgumentException("Matrícula inválida. Formato: ABC 1234 A");
        }
        this.matricula = matricula.toUpperCase(); 
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() > 100) {
            throw new IllegalArgumentException("Nombre inválido: no vacío, máx 100 chars");
        }
        this.nombre = nombre.trim();
    }

    public void setCapacidadCarga(double capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser > 0");
        }
        this.capacidadCargaToneladas = capacidad;
    }

    public void setCombustibleDisponible(double combustible) {
        if (combustible < 0) { 
            throw new IllegalArgumentException("Combustible >= 0");
        }
        this.combustibleDisponible = combustible;
    }

    public void setZonaOperacion(String zona) {
        if (zona == null || zona.trim().isEmpty() || zona.length() > 50) {
            throw new IllegalArgumentException("Zona inválida: no vacía, máx 50 chars");
        }
        this.zonaOperacion = zona.trim(); 
    }

    public void setTripulantes(int tripulantes) {
        if (tripulantes < 1) {  
            throw new IllegalArgumentException("Tripulantes >= 1");
        }
        this.tripulantes = tripulantes;
    }

    public void setDiasMaxAutonomia(int dias) {
        if (dias <= 0) { 
            throw new IllegalArgumentException("Días autonomía > 0");
        }
        this.diasMaxAutonomia = dias;
    }

    public abstract double calcularCapturaMaximaDiaria();  

    public abstract double calcularConsumoEstimado();     

    public abstract String mostrarFicha();               
}