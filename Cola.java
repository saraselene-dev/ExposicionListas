 
public class Cola {

    private Nodo Frente;
    private Nodo Fin;

    public Cola() {
        Frente = null;
        Fin = null;
    }

    public boolean estaVacia() {
        return Frente == null;
    }

    public boolean encolar(Mascota paciente) {
        if (paciente == null) {
            return false;
        }
        Nodo nuevo = new Nodo(paciente);
        if (estaVacia()) {
            Frente = nuevo;
            Fin = nuevo;
        } else {
            Fin.setSiguiente(nuevo);
            Fin = nuevo;
        }
        return true;
    }

    public Mascota desencolar() {

        if (estaVacia()) {
            return null;
        }
        Mascota atendida = Frente.getPaciente();
        Frente = Frente.getSiguiente();
        if (Frente == null) {
            Fin = null;
        }
        return atendida;
    }

        public Mascota cancelar(int turno) {
        if (estaVacia()) {
            return null;
        }
        
        if (Frente.getPaciente().getTurno() == turno) {
            return desencolar();
        }
        
        Nodo anterior = Frente;
        Nodo actual = Frente.getSiguiente();
        
        while (actual != null && actual.getPaciente().getTurno() != turno) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            return null;
        }
        anterior.setSiguiente(actual.getSiguiente());
        if (actual == Fin) {
            Fin = anterior;
        }
        return actual.getPaciente();
    }

        public boolean regresarAlFrente(Mascota paciente) {
        if (paciente == null) {
            return false;
        }
        Nodo nuevo = new Nodo(paciente);
        nuevo.setSiguiente(Frente);
        Frente = nuevo;
        if (Fin == null) {
            Fin = nuevo;
        }
        return true;
    }

    public String mostrar() {
        String texto = "";
        Nodo actual = Frente;
        while (actual != null) {
            Mascota m = actual.getPaciente();
            texto += "Turno " + m.getTurno() + " | " + m.getNombre() + " | " + m.getEspecie()
                    + " | " + m.getEdad() + " años | " + m.getPeso() + " kg | Dueño: " + m.getDueno() + "\n";
            actual = actual.getSiguiente();
        }
        return texto;
    }
}

