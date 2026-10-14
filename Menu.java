public class Menu {
    public static void main(String[] args) {
        Metodos m = new Metodos();
        int opcion;

        do {
            System.out.println("\n===== VETERINARIA =====");
            System.out.println("1. Registrar llegada de mascota");
            System.out.println("2. Atender siguiente mascota");
            System.out.println("3. Cancelar un turno");
            System.out.println("4. Deshacer última atención");
            System.out.println("5. Ver sala de espera");
            System.out.println("6. Ver historial del día");
            System.out.println("7. Salir");

            opcion = m.leerEntero("Seleccione una opción: ");
            while (opcion < 1 || opcion > 7) {
                System.out.println("Opción no válida. Debe estar entre 1 y 7.");
                opcion = m.leerEntero("Seleccione una opción: ");
            }

            switch (opcion) {
                case 1:
                    Mascota registrada = m.registrarLlegada();
                    System.out.println();
                    System.out.println(
                            registrada.getNombre() + " quedó registrad@ con el turno " + registrada.getTurno() + ".");
                    break;

                case 2:
                    Mascota atendida = m.atenderSiguiente();
                    if (atendida == null) {
                        System.out.println();
                        System.out.println("No hay mascotas esperando.");
                    } else {
                        System.out.println();
                        System.out.println("Atendiendo a " + atendida.getNombre()
                                + " (turno " + atendida.getTurno() + ").");
                    }
                    break;

                case 3:
                    Mascota cancelada = m.cancelarTurno();
                    if (cancelada == null) {
                        System.out.println();
                        System.out.println("No hay ninguna mascota con ese turno en la sala.");
                    } else {
                        System.out.println();
                        System.out.println(cancelada.getNombre() + " Turno: " + cancelada.getTurno());
                    }
                    break;

                case 4:
                    Mascota deshecha = m.corregirAtencion();
                    if (deshecha == null) {
                        System.out.println();
                        System.out.println("No hay atenciones para deshacer.");
                    } else {
                        System.out.println();
                        System.out.println("Se eliminó del historial la atención de "
                                + deshecha.getNombre() + " (turno " + deshecha.getTurno() + ").");
                    }
                    break;

                case 5:
                    System.out.println();
                    System.out.println("\n--- SALA DE ESPERA ---");
                    System.out.println(m.verSala());
                    break;

                case 6:
                    System.out.println();
                    System.out.println("\n--- HISTORIAL DEL DÍA DESDE EL MÁS RECIENTE ---");
                    System.out.println(m.verHistorial());
                    break;

                case 7:
                    System.out.println();
                    System.out.println("La veterinaria cierra por hoy. ¡Hasta mañana!");
                    break;
            }
        } while (opcion != 7);
    }
}