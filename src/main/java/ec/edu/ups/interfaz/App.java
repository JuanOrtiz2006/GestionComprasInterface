package ec.edu.ups.interfaz;

import ec.edu.ups.interfaz.clases.*;
import ec.edu.ups.interfaz.enums.EstadoSolicitud;
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
                    Producto producto = view.tipoProducto(); // Asigna directamente el Producto devuelto
                    if (producto != null) {
                        productos.add(producto);
                        view.mostrarMensaje("Producto registrado correctamente.");
                    }
                    break;
                case 3:
                    view.mostrarMensaje("Registrar solicitud de compra");
                    view.mostrarMensaje("Ingrese el coidgo identificador de la solicitud a ingresar: ");
                    String codigoSC = leer.next();
                    EstadoSolicitud[] estados = EstadoSolicitud.values();
                    for (int i = 0; i < estados.length; i++) {
                        System.out.println((i + 1) + ". " + estados[i]);
                    }

                    int respuesta = leer.nextInt();
                    leer.nextLine();

                    while (respuesta < 1 || opcion > estados.length) {
                        view.mostrarMensaje("Opción inválida. Intente nuevamente:");
                        respuesta = leer.nextInt();
                        leer.nextLine();
                    }

                    EstadoSolicitud estadoSolicitud = estados[respuesta - 1];

                    GregorianCalendar calendario = view.fechaSolicitud();

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

                    ArrayList<DetalleCompra> detalleCompras = view.detalleCompra(productos);
                    SolicitudDeCompra solicitudDeCompra = new SolicitudDeCompra(codigoSC, estadoSolicitud, calendario,empleadoEncontrado, detalleCompras );
                    solicitudes.add(solicitudDeCompra);
                    view.mostrarMensaje("Solicitud de compra registrada correctamente:");
                    break;
                case 4:
                    view.mostrarMensaje("Listar Proveedores");
                    for (int i = 0; i < proveedores.size(); i++){
                        view.mostrarMensaje(proveedores.get(i).toString());
                        view.mostrarMensaje("---------------------------------------");
                    }
                    break;
                case 5:
                    view.mostrarMensaje("Listar Productos");
                    for (int i = 0; i < productos.size(); i++){
                        view.mostrarMensaje(productos.get(i).toString());
                        view.mostrarMensaje("---------------------------------------");
                    }
                    break;
                case 6:
                    view.mostrarMensaje("Listar solicitudes de compras: ");
                    for (int i = 0; i < solicitudes.size(); i++){
                        view.mostrarMensaje(solicitudes.get(i).toString());
                        view.mostrarMensaje("---------------------------------------");
                    }
                    break;
                case 7:
                    view.mostrarMensaje("Buscar proveedor por Cedula ");
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
                    view.mostrarMensaje("Buscar producto por nombre");
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
                    view.mostrarMensaje("Buscar solicitud por ID");
                    view.mostrarMensaje("Ingrese el codigo identificador de la solicitud: ");
                    String idA = leer.next();
                    SolicitudDeCompra solicitudEncontradaA = buscarSolicitudPorID(solicitudes, idA);
                    if (solicitudEncontradaA != null) {
                        view.mostrarMensaje("Solicitud encontrada:");
                        view.mostrarMensaje(solicitudEncontradaA.toString());
                    } else {
                        view.mostrarMensaje("Solicitud no encontrada.");
                    }
                    break;

                case 10:
                    view.mostrarMensaje("Aprobar / Rechazar solicitud de compra");
                    view.mostrarMensaje("Ingrese el código identificador de la solicitud: ");
                    String id = leer.next();
                    SolicitudDeCompra solicitudEncontrada = buscarSolicitudPorID(solicitudes, id);
                    if (solicitudEncontrada != null) {
                        view.mostrarMensaje("Solicitud encontrada:");
                        view.mostrarMensaje("Ingrese el nuevo estado de la solicitud: \n" +
                                "   (SOLICITADA,\n" +
                                "    EN_REVISION,\n" +
                                "    APROBADA,\n" +
                                "    RECHAZADA)");
                        EstadoSolicitud[] estado = EstadoSolicitud.values();
                        for (int i = 0; i < estado.length; i++) {
                            System.out.println((i + 1) + ". " + estado[i]);
                        }

                        int respuestaNV = leer.nextInt();
                        leer.nextLine();

                        while (respuestaNV < 1 || respuestaNV > estado.length) {
                            view.mostrarMensaje("Opción inválida. Intente nuevamente:");
                            respuestaNV = leer.nextInt();
                            leer.nextLine();
                        }

                        solicitudEncontrada.setEstadoSolicitud(estado[respuestaNV - 1]);

                        view.mostrarMensaje("Estado actualizado correctamente.");
                        view.mostrarMensaje(solicitudEncontrada.toString());

                    } else {
                        view.mostrarMensaje("Solicitud no encontrada.");
                    }
                    break;

                case 11:
                    view.mostrarMensaje("Calcular total de una solicitud");
                    view.mostrarMensaje("Ingrese el código identificador de la solicitud: ");
                    String idCalcular = leer.next();
                    SolicitudDeCompra solicitudEncontradaCalcular = buscarSolicitudPorID(solicitudes, idCalcular);
                    if (solicitudEncontradaCalcular != null) {
                        float total = solicitudEncontradaCalcular.calcularTotalSolicitud();
                        view.mostrarMensaje(solicitudEncontradaCalcular.toString());
                        view.mostrarMensaje("El total de la solicitud es: $" + total);
                    } else {
                        view.mostrarMensaje("Solicitud no encontrada.");
                    }
                    break;


                case 12:
                    Empleado empleado = view.registrarEmpleado();
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

    public static SolicitudDeCompra buscarSolicitudPorID(ArrayList<SolicitudDeCompra> lista, String id) {
        for (SolicitudDeCompra s : lista) {
            if (s.getIdSolicitud().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

}
