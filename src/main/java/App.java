import clases.Articulo;
import clases.Proveedor;
import clases.ViewConsole;
import enums.TipoProducto;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        ViewConsole view = new ViewConsole();
        Articulo articulo = new Articulo("123456789", "Banana", 1000, TipoProducto.Alimento, 10);
        System.out.println(articulo);

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
                    view.mostrarMensaje("Proveedor registrado correctamente.");

                    break;
                case 2:
                    System.out.println("Registrar producto");
                    break;
                case 3:
                    System.out.println("Registrar solicitud de compra");
                    break;
                case 4:
                    System.out.println("Listar Proveedores");
                    break;
                case 5:
                    System.out.println("Listar Productos");
                    break;
                case 6:
                    System.out.println("Listar solicitudes de compra");
                    break;
                case 7:
                    System.out.println("Buscar proveedor por ID");
                    break;
                case 8:
                    System.out.println("Buscar producto por nombre");
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
}
