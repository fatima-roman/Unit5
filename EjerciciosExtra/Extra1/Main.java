package Extra1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<EquipoHosteleria> equipos = new ArrayList<>();

    public static void main(String[] args) {
        ejecutarAplicacion();
        sc.close();
    }

    private static void ejecutarAplicacion() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> altaEquipo();
                case 2 -> listarEquipos();
                case 3 -> mostrarInformeEconomico();
                case 4 -> mostrarInstalables();
                case 5 -> modificarHorasUso();
                case 0 -> System.out.println("\nSaliendo del sistema...");
                default -> mostrarError("Opción no válida.");
            }

            if (opcion != 0) {
                pausar();
            }

        } while (opcion != 0);
    }

    private static void mostrarMenuPrincipal() {
        limpiarVista();
        System.out.println("");
        System.out.println("SISTEMA DE GESTIÓN DE HOSTELERÍA");
        System.out.println(" 1. Dar de alta equipo");
        System.out.println(" 2. Listar equipos");
        System.out.println(" 3. Mostrar informe económico");
        System.out.println(" 4. Mostrar equipos instalables");
        System.out.println(" 5. Modificar horas encendido/día");
        System.out.println(" 0. Salir");
        System.out.println("");
    }

    private static void altaEquipo() {
        mostrarTitulo("ALTA DE NUEVO EQUIPO");

        int tipo = pedirTipoEquipo();

        String id = leerTexto("ID: ");
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        double precioBase = leerDouble("Precio base (€): ");
        double consumoHora = leerDouble("Consumo por hora (constante) (kWh): ");
        int aniosGarantia = leerEntero("Años de garantía: ");
        double horasEncendidoDia = leerDouble("Horas encendido al día: ");

        EquipoHosteleria equipo = crearEquipo(tipo, id, marca, modelo, precioBase,
                consumoHora, aniosGarantia, horasEncendidoDia);

        if (equipo != null) {
            equipos.add(equipo);
            mostrarOk("Equipo añadido correctamente.");
        }
    }

    private static int pedirTipoEquipo() {
        System.out.println("Tipos de equipo:");
        System.out.println("1. LavadoraIndustrial");
        System.out.println("2. LavavajillasIndustrial");
        System.out.println("3. CamaraFrigorifica");
        System.out.println("4. ArconCongelador");
        System.out.println("5. HornoIndustrial");
        System.out.println("6. PlanchaIndustrial");
        return leerEntero("Seleccione tipo: ");
    }

    private static EquipoHosteleria crearEquipo(int tipo, String id, String marca, String modelo,
                                                double precioBase, double consumoHora,
                                                int aniosGarantia, double horasEncendidoDia) {
        return switch (tipo) {
            case 1 -> {
                boolean usoIntensivo = leerBoolean("¿Uso intensivo? (s/n): ");
                yield new LavadoraIndustrial(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, usoIntensivo);
            }
            case 2 -> {
                boolean usoIntensivo = leerBoolean("¿Uso intensivo? (s/n): ");
                yield new LavavajillasIndustrial(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, usoIntensivo);
            }
            case 3 -> {
                double potencia = leerDouble("Potencia: ");
                yield new CamaraFrigorifica(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, potencia);
            }
            case 4 -> {
                double potencia = leerDouble("Potencia: ");
                yield new ArconCongelador(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, potencia);
            }
            case 5 -> {
                boolean altaProduccion = leerBoolean("¿Alta producción? (s/n): ");
                yield new HornoIndustrial(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, altaProduccion);
            }
            case 6 -> {
                boolean altaProduccion = leerBoolean("¿Alta producción? (s/n): ");
                yield new PanchaIndustrial(id, marca, modelo, precioBase, consumoHora,
                        aniosGarantia, horasEncendidoDia, altaProduccion);
            }
            default -> {
                mostrarError("Tipo no válido.");
                yield null;
            }
        };
    }

    private static void listarEquipos() {
        mostrarTitulo("LISTADO DE EQUIPOS");

        if (equipos.isEmpty()) {
            mostrarError("No hay equipos registrados.");
            return;
        }

        for (EquipoHosteleria eq : equipos) {
            System.out.println("┌──────────────────────────────────────────────────────────────┐");
            System.out.printf ("│ Tipo: %-55s│%n", eq.getClass().getSimpleName());
            System.out.printf ("│ ID: %-57s│%n", eq.getId());
            System.out.printf ("│ Marca: %-54s│%n", eq.getMarca());
            System.out.printf ("│ Modelo: %-53s│%n", eq.getModelo());
            System.out.printf ("│ Precio base: %-48.2f│%n", eq.getPrecioBase());
            System.out.printf ("│ Consumo/hora: %-47.2f│%n", eq.getConsumoHora());
            System.out.printf ("│ Horas encendido/día: %-41.2f│%n", eq.getHorasEncendidoDia());
            System.out.printf ("│ Consumo anual: %-46.2f│%n", eq.calcularConsumoAnual());
            System.out.println("└──────────────────────────────────────────────────────────────┘");
            System.out.println();
        }
    }

    private static void mostrarInformeEconomico() {
        mostrarTitulo("INFORME ECONÓMICO");

        if (equipos.isEmpty()) {
            mostrarError("No hay equipos registrados.");
            return;
        }

        double sumaInstalacion = 0;

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-22s %-10s %12s %16s %16s %16s%n",
                "TIPO", "ID", "P. FINAL", "MANTENIMIENTO", "CONS. ANUAL", "INSTALACIÓN");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        for (EquipoHosteleria eq : equipos) {
            double costeInstalacion = 0;

            if (eq instanceof Instalable instalable) {
                costeInstalacion = instalable.calcularCosteInstalacion();
                sumaInstalacion += costeInstalacion;
            }

            System.out.printf("%-22s %-10s %12.2f € %14.2f € %14.2f %14.2f €%n",
                    eq.getClass().getSimpleName(),
                    eq.getId(),
                    eq.calcularPrecioFinal(),
                    eq.calcularCosteMantenimientoAnual(),
                    eq.calcularConsumoAnual(),
                    costeInstalacion);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-70s %16.2f €%n", "TOTAL INSTALACIÓN", sumaInstalacion);
    }

    private static void mostrarInstalables() {
        mostrarTitulo("EQUIPOS INSTALABLES");

        if (equipos.isEmpty()) {
            mostrarError("No hay equipos registrados.");
            return;
        }

        boolean encontrado = false;

        for (EquipoHosteleria eq : equipos) {
            if (eq instanceof Instalable instalable) {
                encontrado = true;
                System.out.println("--------------------------------------------------");
                System.out.println("Equipo: " + eq.getClass().getSimpleName());
                System.out.println("ID: " + eq.getId());
                System.out.printf("Coste instalación: %.2f €%n", instalable.calcularCosteInstalacion());
                System.out.println("Técnico especializado: " +
                        (instalable.requiereTecnicoEspecializado() ? "Sí" : "No"));
            }
        }

        if (!encontrado) {
            mostrarError("No hay equipos instalables.");
        }
    }

    private static void modificarHorasUso() {
        mostrarTitulo("MODIFICAR HORAS DE USO");

        if (equipos.isEmpty()) {
            mostrarError("No hay equipos registrados.");
            return;
        }

        String idBuscado = leerTexto("Introduzca el ID del equipo: ");
        EquipoHosteleria equipo = buscarPorId(idBuscado);

        if (equipo == null) {
            mostrarError("No existe ningún equipo con ese ID.");
            return;
        }

        System.out.printf("Horas actuales: %.2f%n", equipo.getHorasEncendidoDia());
        double nuevasHoras = leerDouble("Nuevas horas encendido/día: ");
        equipo.setHorasEncendidoDia(nuevasHoras);

        mostrarOk("Horas actualizadas correctamente.");
    }

    private static EquipoHosteleria buscarPorId(String id) {
        for (EquipoHosteleria eq : equipos) {
            if (eq.getId().equalsIgnoreCase(id)) {
                return eq;
            }
        }
        return null;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                mostrarError("Debe introducir un entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                mostrarError("Debe introducir un número decimal válido.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                mostrarError("El texto no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static boolean leerBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String resp = sc.nextLine().trim().toLowerCase();
            if (resp.equals("s")) return true;
            if (resp.equals("n")) return false;
            mostrarError("Responda con 's' o 'n'.");
        }
    }

    private static void mostrarTitulo(String titulo) {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println(" " + titulo);
        System.out.println("==============================================================");
    }

    private static void mostrarOk(String mensaje) {
        System.out.println("[OK] " + mensaje);
    }

    private static void mostrarError(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    private static void pausar() {
        System.out.print("\nPulse ENTER para continuar...");
        sc.nextLine();
    }

    private static void limpiarVista() {
        System.out.println("\n\n");
    }
}