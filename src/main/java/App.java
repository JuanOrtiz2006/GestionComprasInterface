import clases.Articulo;
import clases.Proveedor;
import clases.ViewConsole;
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
                    String respuestas [] = view.registroProvedor();
                    Proveedor proveedor = new Proveedor(respuestas[0], respuestas[1],respuestas[2], respuestas[3]);
                    proveedores.add(proveedor); // Guardar proveedor
                    view.mostrarMensaje("Proveedor registrado correctamente.");
                    break;
                case 2:
                    int respuesta = view.registrarProducto();
                    if (respuesta == 1){
                        view.mostrarMensaje("Ingrese el codigo del Articulo: ");
                        String codigoA = leer.next();
                        view.mostrarMensaje("Ingrese el nombre del Articulo: ");
                        String nombreA = leer.next();
                        view.mostrarMensaje("Ingrese el precio unitario del Articulo:");
                        float precioU = leer.nextFloat();
                        view.mostrarMensaje("Ingrese el IVA del Producto:");
                        int IVA = leer.nextInt();
                        Articulo articulo = new Articulo(codigoA, nombreA, precioU, TipoProducto.Limpieza, IVA);
                        productos.add(articulo); // Guardar proveedor
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
