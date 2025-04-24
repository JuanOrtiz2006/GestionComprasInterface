package clases;

public class ViewConsole {
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


}
