package clases;
import java.util.Scanner;
import enums.TipoProducto;
public class ViewConsole {
    private Scanner leer;
    private Articulo articulo;
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

    public int tipoProducto(){
        mostrarMensaje("Registrar producto");
        mostrarMensaje("Que tipo de producto desea registrar?: "+"\n1. Articulos , 2. Paquete, 3. Servicios");
        int respuesta = leer.nextInt();
        if (respuesta<1 || respuesta>3 ){
            mostrarMensaje("Opcion fuera de rango");
            tipoProducto();
        }
        return respuesta;
    }

    public Articulo registrarArticulo(){
        mostrarMensaje("Ingrese el código del Artículo: ");
        String codigo = leer.next();
        mostrarMensaje("Ingrese el nombre del Artículo: ");
        String nombre = leer.next();
        mostrarMensaje("Ingrese el precio unitario del Artículo:");
        float precioU = leer.nextFloat();
        mostrarMensaje("Ingrese el IVA del Producto:");
        float IVA = leer.nextFloat();

        mostrarMensaje("Seleccione el tipo de producto:");
        TipoProducto[] tipos = TipoProducto.values();//Crea un vector con todos los tipos de producto
        for (int i = 0; i < tipos.length; i++) {//Muestra los tipos al usuario
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        int opcion = leer.nextInt();
        while (opcion < 1 || opcion > tipos.length) {//Verifica que la opcion ingresada es correcta
            mostrarMensaje("Opción inválida. Intente nuevamente:");
            opcion = leer.nextInt();
        }
        TipoProducto tipoSeleccionado = tipos[opcion - 1];//Registra la respuesta
        //Crea un articulo en base a lo que ingreso el usuario
        return new Articulo(codigo, nombre, precioU, tipoSeleccionado, IVA);
    }

    public Paquete registrarPaquete(){
        mostrarMensaje("Registrando Paquete");
        mostrarMensaje("Ingrese el código: ");
        String codigo = leer.next();
        mostrarMensaje("Ingrese el nombre: ");
        String nombre = leer.next();
        mostrarMensaje("Ingrese el precio unitario:");
        float precioU = leer.nextFloat();
        mostrarMensaje("Ingrese el peso:");
        float peso = leer.nextInt();

        mostrarMensaje("Seleccione el tipo:");
        TipoProducto[] tipos = TipoProducto.values();//Crea un vector con todos los tipos de producto
        for (int i = 0; i < tipos.length; i++) {//Muestra los tipos al usuario
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        int opcion = leer.nextInt();
        while (opcion < 1 || opcion > tipos.length) {//Verifica que la opcion ingresada es correcta
            mostrarMensaje("Opción inválida. Intente nuevamente:");
            opcion = leer.nextInt();
        }
        TipoProducto tipoSeleccionado = tipos[opcion - 1];//Registra la respuesta
        //Crea un articulo en base a lo que ingreso el usuario
        return new Paquete(codigo, nombre, precioU, tipoSeleccionado, peso);
    }

}
