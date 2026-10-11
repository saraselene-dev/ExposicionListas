public class Mascota {
    private String Dueno;
    private String Nombre;
    private String Especie;
    private int Edad;
    private double Peso;
    private int Turno;
    
    public Mascota() {
    }

    public Mascota(String dueno, String nombre, String especie, int edad, double peso, int turno) {
        Dueno = dueno;
        Nombre = nombre;
        Especie = especie;
        Edad = edad;
        Peso = peso;
        Turno = turno;
    }

    public String getDueno() {
        return Dueno;
    }

    public void setDueno(String dueno) {
        Dueno = dueno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

    
    

}