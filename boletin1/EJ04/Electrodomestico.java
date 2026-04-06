package EJ04;

public class Electrodomestico {

    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = "blanco";
        this.consumoEnergetico = 'F';
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        }
        return 'F';
    }

    private String comprobarColor(String color) {
        if (color == null) {
            return "blanco";
        }

        switch (color.toLowerCase()) {
            case "blanco":
            case "negro":
            case "rojo":
            case "azul":
            case "gris":
                return color.toLowerCase();
            default:
                return "blanco";
        }
    }

    public double precioFinal() {
        double precio = precioBase;

        switch (consumoEnergetico) {
            case 'A': precio += 100; break;
            case 'B': precio += 80; break;
            case 'C': precio += 60; break;
            case 'D': precio += 50; break;
            case 'E': precio += 30; break;
            case 'F': precio += 10; break;
        }

        if (peso >= 0 && peso <= 19) {
            precio += 10;
        } else if (peso >= 20 && peso <= 49) {
            precio += 50;
        } else if (peso >= 50 && peso <= 79) {
            precio += 80;
        } else if (peso >= 80) {
            precio += 100;
        }

        return precio;
    }
}