package EJ02;

class Tecnico extends Operario {

	public Tecnico (String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Empleado " + getNombre() + " --> Operario --> Tecnico";
	}
}
