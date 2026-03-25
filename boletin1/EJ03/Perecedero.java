package EJ03;

public class Perecedero extends Producto {
    private int diasCaducar;

    public Perecedero(String nombre, double precio, int diasCaducar) {
        super(nombre, precio);  // Llama constructor padre
        this.diasCaducar = diasCaducar;
    }

    // Getter y setter
    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        double precioFinal = super.calcular(cantidad);  // Precio base * cantidad
        if (diasCaducar == 1) {
            precioFinal /= 4;
        } else if (diasCaducar == 2) {
            precioFinal /= 3;
        } else if (diasCaducar == 3) {
            precioFinal /= 2;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Perecedero{" + super.toString() + ", diasCaducar=" + diasCaducar + "}";
    }
}
