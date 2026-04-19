package domotica;

/**
 * Otra subclase concreta.
 *
 * Este ejemplo muestra cómo dos clases distintas
 * pueden implementar la misma interfaz con comportamientos diferentes.
 */
public class LuzInteligente extends Dispositivo implements Ajustable {

    protected String color;
    protected int brillo;

    public LuzInteligente(String nombreComercial, String marca, double precio, String color) {
        super(nombreComercial, marca, precio);
        this.color = color;
        this.brillo = 50;
    }

    public String getColor() {
        return color;
    }

    /**
     * Un setter permite modificar un atributo de forma controlada.
     *
     * Los setters suelen usarse cuando el objeto necesita cambiar
     * algunos datos después de crearse.
     */
    public void setColor(String color) {
        this.color = color;
    }

    public int getBrillo() {
        return brillo;
    }

    @Override
    public void subir() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        brillo += 10;

        if (brillo > 100) {
            brillo = 100;
        }
    }

    @Override
    public void bajar() throws DispositivoApagadoException {
        if (!encendido) {
            throw new DispositivoApagadoException();
        }

        brillo -= 10;

        if (brillo < 0) {
            brillo = 0;
        }
    }

    @Override
    public String toString() {
        return "LuzInteligente{"
                + super.toString()
                + ", color=" + color
                + ", brillo=" + brillo
                + "}";
    }
}