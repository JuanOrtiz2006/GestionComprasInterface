package clases;

public class Empleado extends Persona {
    private Departamento departamento;

    public Empleado(String nombre, String email, String cedula, Departamento departamento){
        super(nombre, email, cedula);
        this.departamento = departamento;


    }
    public Empleado(){}

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override

    public String toString(){
        return super.toString();
    }
}
