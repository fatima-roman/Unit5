package EJ02;

class Operario extends Empleado{
	
	public Operario (String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Empleado " + getNombre() + " --> Operario";
	}

	
}
