import clases.Articulo;
import clases.Proveedor;
import clases.ViewConsole;
import clases.Servicio;
import clases.Paquete;
import enums.TipoProducto;
import clases.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        ViewConsole view = new ViewConsole();


        System.out.println("Sistema de Gestión de Compras ERP");


        int opcion;
        while (true) {
            view.mostrarMenu();
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    String[] registroP = view.registroProvedor();
                    Proveedor proveedor = new Proveedor(registroP[0],registroP[1],registroP[2],registroP[3]);
                    proveedores.add(proveedor); // Guardar proveedor
                    view.mostrarMensaje("Proveedor registrado correctamente...");

                    break;
                case 2:
                    int tipoProducto = view.tipoProducto();
                    if (tipoProducto == 1){
                        Articulo articulo = view.registrarArticulo();
                        productos.add(articulo); // Agrega el articulo a la lista de prodcutos
                        view.mostrarMensaje("Articulo registrado correctamente.");

                    }

                    if (tipoProducto == 2){
                        Paquete paquete = view.registrarPaquete();
                        productos.add(paquete); // Guardar proveedor
                        view.mostrarMensaje("Paquete registrado correctamente.");

                    }
                    if (tipoProducto == 3 ){
                        view.mostrarMensaje("Ingrese el codigo del Servicio proporcionado: ");
                        String codigoS = leer.next();
                        view.mostrarMensaje("Ingrese el nombre del Servicio Proporcionado: ");
                        String nombreS = leer.next();
                        view.mostrarMensaje("Ingrese el precio de la hora por el servicio:");
                        float precioServicio = leer.nextFloat();
                        view.mostrarMensaje("Ingrese cuanto tiempo se otorgo el servicio:");
                        int tiempoHoras = leer.nextInt();
                        Servicio servicio = new Servicio(codigoS, nombreS, precioServicio, TipoProducto.Limpieza, tiempoHoras);
                        productos.add(servicio); // Guardar proveedor
                        view.mostrarMensaje("Proveedor registrado correctamente.");}

                    break;
                case 3:
                    System.out.println("Registrar solicitud de compra");
                    break;
                case 4:
                    System.out.println("Listar Proveedores");
                    for (int i = 0; i < proveedores.size(); i++){
                        view.mostrarMensaje(proveedores.get(i).toString());
                    }
                    break;
                case 5:
                    System.out.println("Listar Productos");
                    for (int i = 0; i < productos.size(); i++){
                        view.mostrarMensaje(productos.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("Listar solicitudes de compras: ");
                    break;
                case 7:
                    System.out.println("Buscar proveedor por Cedula ");
                    view.mostrarMensaje("Ingrese la cedula del proveedor a buscar: ");
                    String cedulaBuscar = leer.next();
                    Proveedor proveedorEncontrado = buscarProveedorPorCedula(proveedores, cedulaBuscar);
                    if (proveedorEncontrado != null) {
                        view.mostrarMensaje("Proveedor encontrado:");
                        view.mostrarMensaje(proveedorEncontrado.toString());
                    } else {
                        view.mostrarMensaje("Proveedor no encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Buscar producto por nombre");
                    view.mostrarMensaje("Ingrese el nombre del producto a buscar: ");
                    String nombreEnc = leer.next();
                    Producto encontrarProdcuto = buscarProductoPorNombre(productos, nombreEnc);
                    if (encontrarProdcuto != null) {
                        view.mostrarMensaje("Producto encontrado:");
                        view.mostrarMensaje(encontrarProdcuto.toString());
                    } else {
                        view.mostrarMensaje("Producto no encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("Buscar solicitud por número");
                    break;
                case 10:
                    System.out.println("Aprobar / Rechazar solicitud de compra");
                    break;
                case 11:
                    System.out.println("Calcular total de una solicitud");
                    break;
                case 12:
                    System.out.println("Salir");
                    return;
                default:
                    System.out.println("Opción no válida");
            }




        }

    }

    public static Proveedor buscarProveedorPorCedula(ArrayList<Proveedor> lista, String cedula) {
        for (Proveedor p : lista) {
            if (p.getCedula().equalsIgnoreCase(cedula)) {
                return p;
            }
        }
        return null;
    }

    public static Producto buscarProductoPorNombre(ArrayList<Producto> lista, String nombre) {
        for (Producto p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
