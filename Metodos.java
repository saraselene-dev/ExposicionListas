import java.util.Scanner;

public class Metodos {
    private Cola Sala;
    private Pila Historial;
    private int ContadorTurno;
    private Scanner sc = new Scanner(System.in);

    public Metodos() {
    
        Sala = new Cola();
        Historial = new Pila();
        ContadorTurno = 1;
    }

    // VALIDACIONES

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Debe ingresar un número entero.");
            System.out.print(mensaje);
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.println("Debe ingresar un número decimal (ejemplo: 12.5).");
            System.out.print(mensaje);
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.println("Este campo no puede quedar vacío.");
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    // RECEPCIÓN

    public boolean registrarLlegada() {
        String nombre = leerTexto("Nombre de la mascota: ");
        String especie = leerTexto("Especie: ");
        String dueno = leerTexto("Nombre del dueño: ");
        int edad = leerEntero("Edad (años): ");
        double peso = leerDecimal("Peso (kg): ");
        Mascota nueva = new Mascota(dueno, nombre, especie, edad, peso, ContadorTurno);
        if (Sala.encolar(nueva)) {
            ContadorTurno++;
            return true;
        }
        return false;
    }

    public Mascota atenderSiguiente() {
        Mascota atendida = Sala.desencolar();
        if (atendida == null) {
            return null;
        }
        Historial.apilar(atendida);
        return atendida;
    }

    // CONSULTAS

    public String verSala() {
        if (Sala.estaVacia()) {
            return "La sala de espera está vacía.";
        }
        return Sala.mostrar();
    }

    public String verHistorial() {
        if (Historial.estaVacia()) {
            return "Todavía no se ha atendido ninguna mascota.";
        }
        return Historial.mostrar();
    }
}