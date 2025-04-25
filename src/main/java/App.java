import clases.*;
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
                    view.mostrarMensaje("Registrar proveedor");
                    view.mostrarMensaje("Ingrese la Empresa");
                    String empresa = leer.next();
                    view.mostrarMensaje("Ingrese el nombre del proveedor: ");
                    String nombre = leer.next();
                    view.mostrarMensaje("Ingrese el correo del proveedor:");
                    String correo = leer.next();
                    view.mostrarMensaje("Ingrese la cedula del proveedor:");
                    String cedula = leer.next();
                    Proveedor proveedor = new Proveedor(empresa, nombre, correo, cedula);
                    proveedores.add(proveedor); // Guardar proveedor
                    view.mostrarMensaje("Proveedor registrado correctamente...");

                    break;
                case 2:
                        System.out.println("Registrar producto");
                        view.mostrarMensaje("Que tipo de producto desea registrar?: "+"1. Articulos , 2. Paquete, 3. Servicios");
                        int tipoProducto = leer.nextInt();
                        if (tipoProducto == 1){
                            view.mostrarMensaje("Ingrese el codigo del Articulo: ");
                            String codigoA = leer.next();
                            view.mostrarMensaje("Ingrese el nombre del Articulo: ");
                            String nombreA = leer.next();
                            view.mostrarMensaje("Ingrese el precio unitario del Articulo:");
                            float precioU = leer.nextFloat();
                            view.mostrarMensaje("Ingrese el IVA del Producto:");
                            float IVA = leer.nextFloat();
                            Articulo articulo = new Articulo(codigoA, nombreA, precioU, TipoProducto.Limpieza, IVA);
                            productos.add(articulo); // Guardar proveedor
                            view.mostrarMensaje("Articulo registrado correctamente.");

                        }
                        if (tipoProducto == 2){
                            view.mostrarMensaje("Ingrese el codigo del Paquete: ");
                            String codigoP= leer.next();
                            view.mostrarMensaje("Ingrese el nombre del Paquete: ");
                            String nombreP = leer.next();
                            view.mostrarMensaje("Ingrese el precio del Paquete:");
                            float precioU = leer.nextFloat();
                            view.mostrarMensaje("Ingrese el peso del Paquete:");
                            float peso = leer.nextInt();
                            Paquete paquete = new Paquete(codigoP, nombreP, precioU, TipoProducto.Limpieza, peso);
                            productos.add(paquete); // Guardar proveedor
                            view.mostrarMensaje("Proveedor registrado correctamente.");

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
                        view.mostrarMensaje("Proveedor registrado correctamente.");

                    }

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
                    System.out.println("Listar solicitudes de compra");
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
