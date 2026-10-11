
public class Nodo {
    private Mascota  Paciente;
    private Nodo Siguiente;

    public Nodo(Mascota paciente) {
        Paciente = paciente;
        Siguiente= null;
    }

    public Mascota getPaciente() {
        return Paciente;
    }

    public void setPaciente(Mascota paciente) {
        Paciente = paciente;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }
    
    
}
