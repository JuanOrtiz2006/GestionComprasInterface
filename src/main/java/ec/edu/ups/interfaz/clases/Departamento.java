package ec.edu.ups.interfaz.clases;
import java.util.ArrayList;
import java.util.List;
public class Departamento {

    private int id;
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        empleados = new ArrayList<>();
    }

    public Departamento(){
        empleados = new ArrayList<>();
    }


    public int getIdDepartamento() {
        return id;
    }

    public void setIdDepartamento(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombre;
    }

    public void setNombreDepartamento(String nombre) {
        this.nombre = nombre;
    }

    public void addEmpleados(Empleado empleado) {
        //Metodo para agregar un elemento a una lista
        this.empleados.add(empleado);
    }

    public List<Empleado> getDirecciones() {

        return empleados;
    }
    @Override

    public String toString(){
        return "";
    }
}
