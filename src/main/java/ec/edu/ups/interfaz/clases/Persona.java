package ec.edu.ups.interfaz.clases;

public class Persona {
    private String nombre;
    private String email;
    private String cedula;

    public Persona(String nombre, String email, String cedula) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String toString(){
        return "Persona: \n" +
                " Nombre: "+nombre+
                "\n Cedula: "+cedula+
                "\n Email: "+email;
    }
}
