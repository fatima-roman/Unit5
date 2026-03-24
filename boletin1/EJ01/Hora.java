package EJ01;

public class Hora {
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        setHora(hora);
        setMinuto(minuto);
    }

    // Get y Set
    public int getHora() {
        return hora;
    }

    public boolean setHora(int hora) {
        if (hora > 23 || hora < 0) {
            System.out.println("Hora no válida. Hora por defecto 00");
            this.hora = 0;
            return false;
        } else {
            this.hora = hora; 
            return true; 
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public boolean setMinuto(int minuto) {
        if (minuto > 59 || minuto < 0) {
            System.out.println("Minuto no válida. Minuto por defecto 00");
            this.minuto = 0;
            return false;
        } else {
            this.minuto = minuto; 
            return true; 
        }
    }

    public void inc() {
        this.minuto++;
        if (this.minuto > 59) {
            setMinuto(0);
            this.hora++;
            if (this.hora > 23) {
                setHora(0);
            }
        }
    }

	@Override
	public String toString() {
		return hora +":"+minuto;
	}
    
    
}
