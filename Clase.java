// Clase Clase
class Clase {
    private String nombre;
    private String horario;
    private String profesor;

    public Clase(String nombre, String horario, String profesor) {
        this.nombre = nombre;
        this.horario = horario;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return nombre + " - " + horario + " - " + profesor;
    }
}