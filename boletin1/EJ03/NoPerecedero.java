package EJ03;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Getter y setter
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantidad) {
        return super.calcular(cantidad);  // Igual que Producto
    }

    @Override
    public String toString() {
        return "NoPerecedero{" + super.toString() + ", tipo='" + tipo + "'}";
    }
}
