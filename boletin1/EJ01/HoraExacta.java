package EJ01;

class HoraExacta extends Hora {
    private int segundos;

    public HoraExacta(int hora, int minuto, int segundos) {
        super(hora, minuto);
        setSegundos(segundos);
    }

    // Get y Set para segundos
    public int getSegundos() {
        return segundos;
    }

    public boolean setSegundos(int segundos) {
        if (segundos > 59 || segundos < 0) {
            System.out.println("Segundos no válidos. Segundos por defecto 00");
            this.segundos = 0;
            return false;
        } else {
            this.segundos = segundos;
            return true;
        }
    }

    @Override
    public void inc() {
        this.segundos++;
        if (this.segundos > 59) {
            setSegundos(0);
            super.inc();  // Incrementa minuto/hora de la clase padre
        }
    }

	@Override
	public String toString() {
		return getHora()+":"+getMinuto()+":"+segundos;
	}
    
    
}
