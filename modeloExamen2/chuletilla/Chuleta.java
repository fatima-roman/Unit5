package chuletilla;

import java.util.Arrays;

/**
 * ★ CHULETILLA DEFINITIVA HERENCIA + INTERFACES + EXCEPCIONES ★
 *
 * PATRÓN PARA CUALQUIER EXAMEN:
 * ¿Datos comunes?         → clase abstracta (abstract class)
 * ¿Subclases?             → extends + super(...)
 * ¿Capacidad compartida?  → interface + implements
 * ¿Ordenar?               → implements Comparable → compareTo
 * ¿Igualdad lógica?       → @Override equals (nunca ==)
 * ¿Imprimir bonito?       → @Override toString
 * ¿Error de estado?       → excepción propia extends Exception + throws
 * ¿Capturar error?        → try { } catch (MiException e) { }
 *
 * VISIBILIDAD:
 *   private   → solo la propia clase
 *   protected → propia clase + subclases + paquete  ← para herencia
 *   public    → todo el mundo
 *
 * PALABRAS CLAVE:
 *   abstract  → la clase no se instancia / el método no tiene cuerpo
 *   extends   → hereda de una clase (solo una)
 *   implements→ implementa una o varias interfaces
 *   super(...)→ llama al constructor del padre
 *   @Override → sobreescribe el método heredado
 *   throws    → declara que el método puede lanzar una excepción
 *   throw new → lanza la excepción en ese momento
 *   instanceof→ comprueba el tipo real del objeto
 *   (Tipo)    → cast: convierte la referencia al tipo concreto
 */
public class Chuleta {

    // =========================================================
    // EXCEPCIÓN PROPIA
    // extends Exception → excepción controlada (obliga a try/catch)
    // Redefinir toString para que System.out.println(e) muestre el mensaje
    // =========================================================
    public static class DispositivoApagadoException extends Exception {
        @Override
        public String toString() {
            return "Error: el dispositivo está apagado";
        }
    }

    // =========================================================
    // INTERFAZ — define CAPACIDADES, no datos
    // Las clases que la implementen DEBEN tener estos métodos
    // void = no devuelve nada | throws = puede lanzar excepción
    // =========================================================
    public interface Ajustable {
        void subir() throws DispositivoApagadoException;
        void bajar() throws DispositivoApagadoException;
    }

    public interface Alertable {
        void activarAlerta(String mensaje) throws DispositivoApagadoException;
        void desactivarAlerta() throws DispositivoApagadoException;
        boolean hayAlertaActiva();  // boolean = devuelve true/false
    }

    // =========================================================
    // ENUM — conjunto cerrado de valores constantes
    // Evita usar Strings sueltos → más seguro y legible
    // =========================================================
    public enum ModoTermostato {
        CALEFACCION, REFRIGERACION
    }

    // =========================================================
    // CLASE BASE ABSTRACTA
    // abstract = no se instancia (solo sirve de plantilla)
    // implements Comparable → permite Arrays.sort() sobre objetos
    // =========================================================
    public static abstract class Dispositivo implements Comparable<Dispositivo> {

        // protected = visible en esta clase Y en subclases
        protected String nombreComercial;
        protected String marca;
        protected double precio;
        protected boolean encendido;

        // Constructor base: inicializa lo común
        // Las subclases lo llaman con super(...)
        public Dispositivo(String nombreComercial, String marca, double precio) {
            this.nombreComercial = nombreComercial;  // this = "yo mismo"
            this.marca = marca;
            this.precio = precio;
            this.encendido = false;  // todos empiezan apagados
        }

        // Getters: acceso público controlado a datos privados/protected
        public String getNombreComercial() { return nombreComercial; }
        public String getMarca()           { return marca; }
        public double getPrecio()          { return precio; }
        public boolean isEncendido()       { return encendido; }

        public void encender() { encendido = true; }
        public void apagar()   { encendido = false; }

        // COMPARABLE: Arrays.sort() llama a este método automáticamente
        // Devuelve: negativo (this antes) | positivo (this después) | 0 (igual)
        @Override
        public int compareTo(Dispositivo otro) {
            return Double.compare(this.precio, otro.precio);  // orden ascendente
        }

        // EQUALS: igualdad lógica (NO referencias en memoria)
        // Se redefine cuando "iguales" en el problema ≠ "mismo objeto en RAM"
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;               // misma referencia → iguales
            if (!(obj instanceof Dispositivo)) return false; // tipo incorrecto → distintos
            Dispositivo otro = (Dispositivo) obj;       // cast necesario
            return nombreComercial.equals(otro.nombreComercial) && marca.equals(otro.marca);
        }

        // TOSTRING: llamado por println(objeto) → texto legible
        // super.toString() en subclase reutiliza esta parte
        @Override
        public String toString() {
            return "nombre=" + nombreComercial + ", marca=" + marca
                    + ", precio=" + precio + ", enc=" + encendido;
        }
    }

    // =========================================================
    // SUBCLASE: extiende la base e implementa una interfaz
    // extends → hereda atributos + métodos del padre
    // implements → promete tener subir() y bajar()
    // =========================================================
    public static class AltavozInteligente extends Dispositivo implements Ajustable {

        protected String asistente;
        protected int volumen;  // rango 0–100, inicio 30

        public AltavozInteligente(String n, String m, double p, String asistente) {
            super(n, m, p);         // ← SIEMPRE llamar al constructor padre
            this.asistente = asistente;
            this.volumen = 30;
        }

        public String getAsistente() { return asistente; }
        public int getVolumen()      { return volumen; }

        // IMPLEMENTACIÓN de la interfaz Ajustable
        // Patrón: 1) validar estado  2) actuar  3) limitar rango
        @Override
        public void subir() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException(); // lanzar excepción
            volumen += 5;
            if (volumen > 100) volumen = 100;  // límite superior
        }

        @Override
        public void bajar() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            volumen -= 5;
            if (volumen < 0) volumen = 0;  // límite inferior
        }

        // super.toString() + datos propios
        @Override
        public String toString() {
            return "Altavoz{" + super.toString() + ", asistente=" + asistente + ", vol=" + volumen + "}";
        }
    }

    // PATRÓN IDÉNTICO para LuzInteligente (misma interfaz, distinto dato)
    public static class LuzInteligente extends Dispositivo implements Ajustable {

        protected String color;
        protected int brillo;  // rango 0–100, inicio 50

        public LuzInteligente(String n, String m, double p, String color) {
            super(n, m, p);
            this.color = color;
            this.brillo = 50;
        }

        public String getColor()       { return color; }
        public void setColor(String c) { this.color = c; }  // setter: permite cambiar el dato
        public int getBrillo()         { return brillo; }

        @Override
        public void subir() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            brillo += 10;
            if (brillo > 100) brillo = 100;
        }

        @Override
        public void bajar() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            brillo -= 10;
            if (brillo < 0) brillo = 0;
        }

        @Override
        public String toString() {
            return "Luz{" + super.toString() + ", color=" + color + ", brillo=" + brillo + "}";
        }
    }

    // PATRÓN CON ALERTABLE: misma idea, interfaz diferente
    public static class Termostato extends Dispositivo implements Alertable {

        protected double temperaturaObjetivo;
        protected ModoTermostato modo;
        protected boolean alertaActiva;
        protected String mensajeAlerta;

        public Termostato(String n, String m, double p, double temp, ModoTermostato modo) {
            super(n, m, p);
            this.temperaturaObjetivo = temp;
            this.modo = modo;
            this.alertaActiva = false;
            this.mensajeAlerta = "";
        }

        public double getTemperaturaObjetivo()            { return temperaturaObjetivo; }
        public void setTemperaturaObjetivo(double t)      { this.temperaturaObjetivo = t; }
        public ModoTermostato getModo()                   { return modo; }
        public String getMensajeAlerta()                  { return mensajeAlerta; }

        // Método de negocio propio: cambia estado interno
        public void cambiarModo() {
            modo = (modo == ModoTermostato.CALEFACCION)
                    ? ModoTermostato.REFRIGERACION
                    : ModoTermostato.CALEFACCION;
        }

        @Override
        public void activarAlerta(String mensaje) throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            alertaActiva = true;
            mensajeAlerta = mensaje;
        }

        @Override
        public void desactivarAlerta() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            alertaActiva = false;
            mensajeAlerta = "";
        }

        @Override
        public boolean hayAlertaActiva() { return alertaActiva; }

        @Override
        public String toString() {
            return "Termostato{" + super.toString()
                    + ", temp=" + temperaturaObjetivo + ", modo=" + modo
                    + ", alerta=" + alertaActiva + ", msg=" + mensajeAlerta + "}";
        }
    }

    public static class CamaraSeguridad extends Dispositivo implements Alertable {

        protected String resolucion;
        protected boolean grabando;
        protected boolean alertaActiva;
        protected String mensajeAlerta;

        public CamaraSeguridad(String n, String m, double p, String resolucion) {
            super(n, m, p);
            this.resolucion = resolucion;
            this.grabando = false;
            this.alertaActiva = false;
            this.mensajeAlerta = "";
        }

        public String getResolucion()   { return resolucion; }
        public boolean isGrabando()     { return grabando; }
        public String getMensajeAlerta(){ return mensajeAlerta; }

        public void iniciarGrabacion() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            grabando = true;
        }

        public void detenerGrabacion() { grabando = false; }

        @Override
        public void activarAlerta(String mensaje) throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            alertaActiva = true;
            mensajeAlerta = mensaje;
        }

        @Override
        public void desactivarAlerta() throws DispositivoApagadoException {
            if (!encendido) throw new DispositivoApagadoException();
            alertaActiva = false;
            mensajeAlerta = "";
        }

        @Override
        public boolean hayAlertaActiva() { return alertaActiva; }

        @Override
        public String toString() {
            return "Camara{" + super.toString()
                    + ", res=" + resolucion + ", grab=" + grabando
                    + ", alerta=" + alertaActiva + ", msg=" + mensajeAlerta + "}";
        }
    }

    // =========================================================
    // MAIN DE PRUEBA
    // Demuestra: creación → ordenación → polimorfismo → excepciones
    // =========================================================
    public static void main(String[] args) {

        // Crear 1 objeto de cada tipo
        AltavozInteligente altavoz = new AltavozInteligente("Echo Dot", "Amazon", 59.99, "Alexa");
        LuzInteligente luz         = new LuzInteligente("Hue White", "Philips", 24.99, "Blanco");
        Termostato termostato      = new Termostato("Nest", "Google", 199.99, 21.5, ModoTermostato.CALEFACCION);
        CamaraSeguridad camara     = new CamaraSeguridad("C200", "TP-Link", 39.99, "1080p");

        // Array polimórfico: guarda distintos tipos bajo un tipo común
        Dispositivo[] catalogo = { altavoz, luz, termostato, camara };

        // sort usa compareTo → orden por precio
        Arrays.sort(catalogo);

        System.out.println("=== ORDENADO POR PRECIO ===");
        for (Dispositivo d : catalogo) System.out.println(d);

        System.out.println("\n=== ACCIONES ===");
        for (Dispositivo d : catalogo) {
            d.encender();
            try {
                // instanceof → comprueba el tipo real
                // cast (Tipo) → accede a métodos específicos de la subclase
                if (d instanceof AltavozInteligente) {
                    AltavozInteligente a = (AltavozInteligente) d;
                    a.subir(); a.subir();
                    System.out.println(a);

                } else if (d instanceof LuzInteligente) {
                    LuzInteligente l = (LuzInteligente) d;
                    l.subir(); l.setColor("Azul");
                    System.out.println(l);

                } else if (d instanceof Termostato) {
                    Termostato t = (Termostato) d;
                    t.cambiarModo();
                    t.activarAlerta("Temp fuera de rango");
                    System.out.println(t);

                } else if (d instanceof CamaraSeguridad) {
                    CamaraSeguridad c = (CamaraSeguridad) d;
                    c.iniciarGrabacion();
                    c.activarAlerta("Movimiento detectado");
                    System.out.println(c);
                }

            } catch (DispositivoApagadoException e) {
                // catch captura el error → el programa sigue ejecutándose
                System.out.println(e);
            }
        }

        // PRUEBA ESPECÍFICA: apagar + intentar usar = excepción esperada
        System.out.println("\n=== PRUEBA ERROR ===");
        altavoz.apagar();
        try {
            altavoz.subir();  // debe lanzar excepción
        } catch (DispositivoApagadoException e) {
            System.out.println(e);  // imprime toString() de la excepción
        }
    }
}

/*
 * ================================================================
 * ★★★ TEORÍA EXAMEN — REPASO RÁPIDO ★★★
 * ================================================================
 *
 * HERENCIA
 * ─────────────────────────────────────────────────────────────
 * abstract class Base  → plantilla común, NO se instancia
 * class Hijo extends Base → hereda atributos + métodos del padre
 * super(...)           → llama constructor del padre (1ª línea)
 * @Override            → sobreescribe un método heredado
 * protected            → visible en la clase + subclases
 *
 * INTERFACES
 * ─────────────────────────────────────────────────────────────
 * interface MiIF { void metodo(); }   → solo firma, sin cuerpo
 * class X implements MiIF { ... }     → X DEBE implementar metodo()
 * Una clase puede implementar VARIAS interfaces a la vez
 * Una interfaz NO puede tener atributos de instancia
 *
 * COMPARABLE + ORDENACIÓN
 * ─────────────────────────────────────────────────────────────
 * implements Comparable<MiClase>
 * int compareTo(MiClase otro):
 *   < 0  → this va ANTES
 *   > 0  → this va DESPUÉS
 *   = 0  → equivalentes
 * Arrays.sort(array) → usa compareTo automáticamente
 *
 * EQUALS
 * ─────────────────────────────────────────────────────────────
 * == compara REFERENCIAS (¿mismo objeto en RAM?)
 * .equals() compara CONTENIDO LÓGICO (¿representan lo mismo?)
 * Siempre recibe Object → hay que hacer cast
 *
 * TOSTRING
 * ─────────────────────────────────────────────────────────────
 * System.out.println(objeto) llama toString() automáticamente
 * super.toString() reutiliza la versión del padre
 *
 * EXCEPCIONES PROPIAS
 * ─────────────────────────────────────────────────────────────
 * class MiEx extends Exception { }     → crear excepción propia
 * void metodo() throws MiEx { ... }    → declarar que puede lanzarla
 * throw new MiEx()                     → lanzarla en ese momento
 * try { } catch (MiEx e) { }           → capturarla y seguir
 *
 * POLIMORFISMO EN MAIN
 * ─────────────────────────────────────────────────────────────
 * Tipo[] array = { subclase1, subclase2 }  → array polimórfico
 * if (obj instanceof SubTipo)              → comprobar tipo real
 * SubTipo x = (SubTipo) obj               → cast para usar métodos propios
 *
 * ================================================================
 */
