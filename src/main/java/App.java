import clases.*;
import enums.EstadoSolicitud;
import enums.TipoDepartamento;
import enums.TipoProducto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<SolicitudDeCompra> solicitudes = new ArrayList<>();
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
                    view.mostrarMensaje("Ingrese el coidgo identificador de la solicitud a ingresar: ");
                    int codigoSC = leer.nextInt();
                    view.mostrarMensaje("Ingrese el estado de la solicitud: SOlICITADA, EN_REVISION, APROBADA, RECHAZADA");
                    String nombreSC = leer.next().toUpperCase();
                    EstadoSolicitud estadoSolicitud = EstadoSolicitud.valueOf(nombreSC);

                    view.mostrarMensaje("Fecha de Solicitud----- ");
                    view.mostrarMensaje("Ingrese el dia de la fecha de la solicitud: ");
                    int dia  = leer.nextInt() ;
                    view.mostrarMensaje("Ingrese el mes de la fecha de la solicitud: (1-12) ");
                    int mes  = leer.nextInt() -  1 ;
                    view.mostrarMensaje("Ingrese el año de la fecha de la solicitud: ");
                    int ano  = leer.nextInt();
                    GregorianCalendar calendario = new GregorianCalendar(ano, mes, dia);

                    Empleado empleadoEncontrado = null;
                    while (empleadoEncontrado == null) {
                        view.mostrarMensaje("Ingrese la cédula del empleado que realizó la solicitud: ");
                        String cedulaEmpleado = leer.next();

                        empleadoEncontrado = buscarEmpleadoPorCedula(empleados, cedulaEmpleado);

                        if (empleadoEncontrado == null) {
                            view.mostrarMensaje("Empleado no encontrado. Intente de nuevo.");
                        }
                    }
                    view.mostrarMensaje("Empleado encontrado: " + empleadoEncontrado.getNombre());

                    SolicitudDeCompra solicitudDeCompra = new SolicitudDeCompra(codigoSC, estadoSolicitud, calendario,empleadoEncontrado, /*PON AQUI EL DETALLE DE COMPRAS*/ );
                    solicitudes.add(solicitudDeCompra);
                    view.mostrarMensaje("Solicitud de compra registrada correctamente:");




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
                    for (int i = 0; i < solicitudes.size(); i++){
                        view.mostrarMensaje(solicitudes.get(i).toString());
                    }
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
                    Producto encontrarProducto = buscarProductoPorNombre(productos, nombreEnc);
                    if (encontrarProducto != null) {
                        view.mostrarMensaje("Producto encontrado:");
                        view.mostrarMensaje(encontrarProducto.toString());
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
                System.out.println("Ingresar un empleado con su respectivo departamento: ");
                view.mostrarMensaje("Ingrese el nombre del Empleado: ");
                String nombreE = leer.next();
                view.mostrarMensaje("Ingrese el correo del Empleado: ");
                String correoE = leer.next();
                view.mostrarMensaje("Ingrese la cedula del Empleado: :");
                String cedulaE = leer.next();
                view.mostrarMensaje("Ingrese el tipo de Departamento del proveedor:");
                String tipoD = leer.next().toUpperCase();

                TipoDepartamento tipoDepartamento = TipoDepartamento.valueOf(tipoD);
                int idDepartamento = tipoDepartamento.ordinal() + 1;
                Departamento departamento = new Departamento(idDepartamento, tipoDepartamento.name());
                Empleado empleado = new Empleado(nombreE, correoE, cedulaE, departamento);
                empleados.add(empleado); // Guardar empleado
                view.mostrarMensaje("Empleado registrado correctamente.");

                break;
                case 13:
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

    public static Empleado buscarEmpleadoPorCedula(ArrayList<Empleado> lista, String cedula) {
        for (Empleado e : lista) {
            if (e.getCedula().equalsIgnoreCase(cedula)) {
                return e;
            }
        }
        return null;
    }
}
