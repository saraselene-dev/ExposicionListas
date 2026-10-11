public class Menu {
    public static void main(String[] args) {
        
        Metodos m = new Metodos();
        int opcion;

        do {
            System.out.println();
            System.out.println("\n===== VETERINARIA =====");
            System.out.println();
            System.out.println("1. Registrar llegada de mascota");
            System.out.println("2. Atender siguiente mascota");
            System.out.println("3. Ver sala de espera");
            System.out.println("4. Ver historial del día");
            System.out.println("5. Salir");
            opcion = m.leerEntero("Seleccione una opción: ");
    
            while (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Debe estar entre 1 y 5.");
                opcion = m.leerEntero("Seleccione una opción: ");
            }

            switch (opcion) {
                case 1:
                    if (m.registrarLlegada()) {
                        System.out.println("Mascota registrada en la sala de espera.");
                    } else {
                        System.out.println("No se pudo registrar la mascota.");
                    }
                    break;

                case 2:
                    Mascota atendida = m.atenderSiguiente();
                    if (atendida == null) {
                        System.out.println("No hay mascotas esperando.");
                    } else {
                        System.out.println("Atendiendo a " + atendida.getNombre()
                                + " (turno " + atendida.getTurno() + ").");
                    }
                    break;

                case 3:
                    System.out.println("\n--- SALA DE ESPERA (primero en llegar, primero en salir) ---");
                    System.out.println(m.verSala());
                    break;

                case 4:
                    System.out.println("\n--- HISTORIAL DEL DÍA (último atendido arriba) ---");
                    System.out.println(m.verHistorial());
                    break;

                case 5:
                    System.out.println("La veterinaria cierra por hoy. ¡Hasta mañana!");
                    break;
            }
        } while (opcion != 5);
    }
}