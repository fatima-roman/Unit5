package principal;

import java.util.Arrays;

import domotica.AltavozInteligente;
import domotica.CamaraSeguridad;
import domotica.Dispositivo;
import domotica.DispositivoApagadoException;
import domotica.LuzInteligente;
import domotica.ModoTermostato;
import domotica.Termostato;

/**
 * Clase de prueba del programa.
 *
 * ¿Para qué sirve Main?
 * - Para comprobar que el modelo funciona.
 * - Para crear objetos.
 * - Para probar polimorfismo, ordenación y excepciones.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Se crean objetos concretos.
         * Cada variable tiene el tipo real del objeto.
         */
        AltavozInteligente altavoz =
                new AltavozInteligente("Echo Dot", "Amazon", 59.99, "Alexa");

        LuzInteligente luz =
                new LuzInteligente("Hue White", "Philips", 24.99, "Blanco");

        Termostato termostato =
                new Termostato("Nest", "Google", 199.99, 21.5, ModoTermostato.CALEFACCION);

        CamaraSeguridad camara =
                new CamaraSeguridad("C200", "TP-Link", 39.99, "1080p");

        /**
         * Array polimórfico.
         *
         * ¿Para qué sirve?
         * - Permite guardar objetos distintos bajo un tipo común.
         * - Muy útil cuando todas las clases heredan de una misma superclase.
         */
        Dispositivo[] catalogo = {altavoz, luz, termostato, camara};

        /**
         * Arrays.sort usa compareTo porque Dispositivo implementa Comparable.
         */
        Arrays.sort(catalogo);

        System.out.println("=== CATALOGO ORDENADO ===");
        for (Dispositivo d : catalogo) {
            System.out.println(d);
        }

        System.out.println("\n=== PRUEBA DE COMPORTAMIENTOS ===");

        for (Dispositivo d : catalogo) {
            d.encender();

            /**
             * instanceof sirve para comprobar el tipo real del objeto.
             *
             * El cast convierte la referencia general (Dispositivo)
             * en la referencia específica que permite acceder
             * a métodos propios de la subclase.
             */
            try {
                if (d instanceof AltavozInteligente) {
                    AltavozInteligente a = (AltavozInteligente) d;
                    a.subir();
                    a.subir();
                    System.out.println(a);

                } else if (d instanceof LuzInteligente) {
                    LuzInteligente l = (LuzInteligente) d;
                    l.subir();
                    l.setColor("Azul");
                    System.out.println(l);

                } else if (d instanceof Termostato) {
                    Termostato t = (Termostato) d;
                    t.cambiarModo();
                    t.activarAlerta("Temperatura fuera de rango");
                    System.out.println(t);

                } else if (d instanceof CamaraSeguridad) {
                    CamaraSeguridad c = (CamaraSeguridad) d;
                    c.iniciarGrabacion();
                    c.activarAlerta("Movimiento detectado");
                    System.out.println(c);
                }

            } catch (DispositivoApagadoException e) {
                /**
                 * try-catch sirve para manejar errores de forma controlada
                 * sin detener necesariamente todo el programa.
                 */
                System.out.println(e);
            }
        }

        System.out.println("\n=== PRUEBA DE EXCEPCION ===");

        altavoz.apagar();

        try {
            altavoz.subir();
        } catch (DispositivoApagadoException e) {
            System.out.println(e);
        }
    }
}