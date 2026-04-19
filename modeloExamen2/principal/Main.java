package principal;

import java.util.ArrayList;
import java.util.List;

import domotica.*;

public class Main {
    
    public static void main(String[] args) {
        
        // Crear lista polimórfica (estilo profesor: List)
        List<Dispositivo> catalogo = new ArrayList<>();
        catalogo.add(new AltavozInteligente("Echo Dot", "Amazon", 59.99, "Alexa"));
        catalogo.add(new LuzInteligente("Hue", "Philips", 24.99, "Blanco"));
        catalogo.add(new Termostato("Nest", "Google", 199.99, 21.5, ModoTermostato.CALEFACCION));
        catalogo.add(new CamaraSeguridad("TP-Link", "C200", 39.99, "1080p"));
        
        // Ordenar por precio
        catalogo.sort(null);
        
        System.out.println("=== CATÁLOGO ORDENADO POR PRECIO ===");
        for (Dispositivo d : catalogo) {
            System.out.println(d);
        }
        
        System.out.println("\n=== OPERACIONES ===");
        for (Dispositivo d : catalogo) {
            d.encender();
            
            try {
                if (d instanceof AltavozInteligente) {
                    AltavozInteligente a = (AltavozInteligente) d;
                    a.subir(); a.subir();
                    System.out.println("Asistente: " + a.getAsistente());
                } else if (d instanceof LuzInteligente) {
                    LuzInteligente l = (LuzInteligente) d;
                    l.subir();
                    l.setColor("Azul");
                } else if (d instanceof Termostato) {
                    Termostato t = (Termostato) d;
                    t.cambiarModo();
                    t.activarAlerta("Temperatura alta");
                } else if (d instanceof CamaraSeguridad) {
                    CamaraSeguridad c = (CamaraSeguridad) d;
                    c.iniciarGrabacion();
                    c.activarAlerta("Intruso");
                }
            } catch (DispositivoApagadoException e) {
                System.out.println(e);
            }
            
            System.out.println(d);
        }
        
        // Prueba error específica
        System.out.println("\n=== PRUEBA ERROR ===");
        AltavozInteligente altavoz = (AltavozInteligente) catalogo.get(0);
        altavoz.apagar();
        try {
            altavoz.subir();
        } catch (DispositivoApagadoException e) {
            System.out.println(e);
        }
    }
}