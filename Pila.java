public class Pila {
    private Nodo Cima;

    public Pila() {
        Cima = null;
    }

    public boolean estaVacia() {
        return Cima == null;
    }

    public boolean apilar(Mascota paciente) {
        if (paciente == null) {
            return false;
        }

        Nodo nuevo = new Nodo(paciente);
        nuevo.setSiguiente(Cima);
        Cima = nuevo;
        return true;
    }

    public Mascota desapilar() {
        if (estaVacia()) {
            return null;
        }
        Mascota ultima = Cima.getPaciente();
        Cima = Cima.getSiguiente();
        return ultima;
    }

    public String mostrar() {
        String texto = "";
        Nodo actual = Cima;
        while (actual != null) {
            Mascota m = actual.getPaciente();
            texto += "Turno " + m.getTurno() + " | " + m.getNombre() + " | " + m.getEspecie()
                    + " | " + m.getEdad() + " años | " + m.getPeso() + " kg | Dueño: " + m.getDueno() + "\n";
            actual = actual.getSiguiente();
        }
        return texto;
    }
}