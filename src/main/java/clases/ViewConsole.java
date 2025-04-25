package clases;
import java.util.Scanner;
public class ViewConsole {
    private Scanner leer;
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarMenu(){
        mostrarMensaje("\n" +
                "1. Registrar proveedor\n" +
                "2. Registrar producto\n" +
                "3. Registrar solicitud de compra\n" +
                "4. Listar proveedores\n" +
                "5. Listar productos\n" +
                "6. Listar solicitudes de compra\n" +
                "7. Buscar proveedor por ID\n" +
                "8. Buscar producto por nombre\n" +
                "9. Buscar solicitud por número\n" +
                "10. Aprobar / Rechazar solicitud de compra\n" +
                "11. Calcular total de una solicitud\n" +
                "12. Salir\n" +
                "Seleccione una opción:");
    }

    public  String[] registroProvedor(){
        mostrarMensaje("Registrar proveedor");
        mostrarMensaje("Ingrese la Empresa");
        String empresa = leer.next();
        mostrarMensaje("Ingrese el nombre del proveedor: ");
        String nombre = leer.next();
        mostrarMensaje("Ingrese el correo del proveedor:");
        String correo = leer.next();
        mostrarMensaje("Ingrese la cedula del proveedor:");
        String cedula = leer.next();
        String respuestas[] = {empresa,nombre,correo,cedula};
        return respuestas;
    }

    public int registrarProducto(){
        mostrarMensaje("Registrar producto");
        mostrarMensaje("Que tipo de producto desea registrar?: "+"\n1. Articulos , 2. Paquete, 3. Servicios");
        int respuesta = leer.nextInt();
        if (respuesta<1 || respuesta>3 ){
            mostrarMensaje("Opcion fuera de rango");
            registrarProducto();
        }

        return respuesta;
    }


}
