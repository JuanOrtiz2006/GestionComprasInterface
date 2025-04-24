package clases;
import java.util.ArrayList;
import java.util.List;
public class Departamento {

    private int idDepartamento;
    private String nombreDepartamento;
    private List<Empleado> empleados;

    public Departamento(int idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        empleados = new ArrayList<>();
    }

    public Departamento(){
        empleados = new ArrayList<>();
    }


    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
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
