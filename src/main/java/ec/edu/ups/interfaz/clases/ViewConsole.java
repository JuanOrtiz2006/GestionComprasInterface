package ec.edu.ups.interfaz.clases;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ec.edu.ups.interfaz.enums.TipoProducto;
import ec.edu.ups.interfaz.enums.TipoDepartamento;

public class ViewConsole {
    private Scanner leer;

    public ViewConsole() {
        leer = new Scanner(System.in);  // Inicializamos el Scanner en el constructor
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMenu() {
        mostrarMensaje("\n" +
                //"1. Registrar proveedor\n" +
                //"2. Registrar producto\n" +
                "3. Registrar solicitud de compra\n" +
                //"4. Listar proveedores\n" +
                //"5. Listar productos\n" +
                "6. Listar solicitudes de compra\n" +
                //"7. Buscar proveedor por ID\n" +
                //"8. Buscar producto por nombre\n" +
                "9. Buscar solicitud por número\n" +
                "10. Aprobar / Rechazar solicitud de compra\n" +
                "11. Calcular total de una solicitud\n" +
                //"12. Ingresar un empleado\n" +
                "13. Salir\n" +
                "Seleccione una opción: ");
    }

    public String[] registroProvedor() {
        mostrarMensaje("\nRegistrar proveedor");
        mostrarMensaje("Ingrese la Empresa:");
        String empresa = leer.nextLine();  // Leer la línea completa para permitir nombres con espacios
        mostrarMensaje("Ingrese el nombre del proveedor: ");
        String nombre = leer.nextLine();  // Usamos nextLine() para capturar nombres completos
        mostrarMensaje("Ingrese el correo del proveedor:");
        String correo = leer.next();
        mostrarMensaje("Ingrese la cédula del proveedor:");
        String cedula = leer.next();


        leer.nextLine();

        String[] respuestas = {empresa, nombre, correo, cedula};
        mostrarMensaje("Proveedor registrado correctamente...");
        return respuestas;
    }

    public Producto tipoProducto() {
        mostrarMensaje("\nRegistrar producto");
        mostrarMensaje("¿Qué tipo de producto desea registrar?: \n1. Artículos\n2. Paquete\n3. Servicios");
        int respuesta = leer.nextInt();
        leer.nextLine();  // Limpiar el buffer de entrada

        if (respuesta < 1 || respuesta > 3) {
            mostrarMensaje("Opción fuera de rango. Intente nuevamente.");
            return tipoProducto();  // Recursión para repetir la selección si es incorrecta
        }

        mostrarMensaje("\nIngrese el código del producto: ");
        String codigo = leer.nextLine();  // Captura la línea completa
        mostrarMensaje("Ingrese el nombre del producto: ");
        String nombre = leer.nextLine();
        mostrarMensaje("Ingrese el precio unitario del producto:");
        float precioU = leer.nextFloat();

        mostrarMensaje("Seleccione el tipo de producto:");
        TipoProducto[] tipos = TipoProducto.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        int opcion = leer.nextInt();
        leer.nextLine();  // Limpiar el buffer de entrada

        while (opcion < 1 || opcion > tipos.length) {
            mostrarMensaje("Opción inválida. Intente nuevamente:");
            opcion = leer.nextInt();
            leer.nextLine();  // Limpiar el buffer de entrada
        }

        TipoProducto tipoSeleccionado = tipos[opcion - 1];

        switch (respuesta) {
            case 1:
                return registrarArticulo(codigo, nombre, precioU, tipoSeleccionado);
            case 2:
                return registrarPaquete(codigo, nombre, precioU, tipoSeleccionado);
            case 3:
                return registrarServicio(codigo, nombre, precioU, tipoSeleccionado);
            default:
                mostrarMensaje("Opción inválida.");
                return null;
        }

    }

    public Articulo registrarArticulo(String codigo, String nombre, float precio, TipoProducto tipoProducto) {
        mostrarMensaje("Ingrese el IVA del artículo:");
        float IVA = leer.nextFloat();
        return new Articulo(codigo, nombre, precio, tipoProducto, IVA);
    }

    public Paquete registrarPaquete(String codigo, String nombre, float precio, TipoProducto tipoProducto) {
        mostrarMensaje("Ingrese el peso del paquete:");
        float peso = leer.nextFloat();
        leer.nextLine();
        return new Paquete(codigo, nombre, precio, tipoProducto, peso);
    }

    public Servicio registrarServicio(String codigo, String nombre, float precio, TipoProducto tipoProducto) {
        mostrarMensaje("Ingrese el tiempo estimado de servicio (en horas):");
        int tiempoHoras = leer.nextInt();
        leer.nextLine();
        return new Servicio(codigo, nombre, precio, tipoProducto, tiempoHoras);
    }


    public GregorianCalendar fechaSolicitud() {

        mostrarMensaje("\nFecha de Solicitud----- ");
        mostrarMensaje("Ingrese el día de la fecha de la solicitud: ");
        int dia = leer.nextInt();
        leer.nextLine();
        mostrarMensaje("Ingrese el mes de la fecha de la solicitud: (1-12) ");
        int mes = leer.nextInt() - 1;  // Meses en GregorianCalendar son 0-indexed
        leer.nextLine();
        mostrarMensaje("Ingrese el año de la fecha de la solicitud: ");
        int anio = leer.nextInt();
        leer.nextLine();


        return new GregorianCalendar(anio, mes, dia);

    }

    public ArrayList<DetalleCompra> detalleCompra(ArrayList<Producto> productos) {
        ArrayList<DetalleCompra> detallesCompra = new ArrayList<>();
        mostrarMensaje("\nDetalles de compra");

        String continuar = "Si";
        while (continuar.equalsIgnoreCase("Si")) {
            mostrarMensaje("Ingrese el código del producto a agregar:");
            String codigoAComparar = leer.next();

            Producto productoEncontrado = null;
            for (Producto p : productos) {
                if (p.getCodigo().equalsIgnoreCase(codigoAComparar)) {
                    productoEncontrado = p;
                    break;
                }
            }
            if (productoEncontrado != null) {
                mostrarMensaje("\nProducto encontrado: " + productoEncontrado.getNombre());
                mostrarMensaje("Cantidad:");
                int cantidad = leer.nextInt();
                leer.nextLine(); // Limpiar buffer
                mostrarMensaje("Descripción: ");
                String descripcion = leer.nextLine(); // nextLine para leer toda la línea

                DetalleCompra detalleCompra = new DetalleCompra(cantidad, productoEncontrado, descripcion);
                detallesCompra.add(detalleCompra);

                mostrarMensaje("Producto agregado al detalle de compra.");
            } else {
                mostrarMensaje("Producto no encontrado. Intente de nuevo.");
            }

            mostrarMensaje("¿Desea agregar otro producto? (Si/No)");
            continuar = leer.next();
        }

        return detallesCompra;
    }


    public Empleado registrarEmpleado() {
        mostrarMensaje("Ingresar un empleado con su respectivo departamento: ");
        mostrarMensaje("Ingrese el nombre del Empleado: ");
        String nombreE = leer.nextLine();
        mostrarMensaje("Ingrese el correo del Empleado: ");
        String correoE = leer.nextLine();
        mostrarMensaje("Ingrese la cedula del Empleado: :");
        String cedulaE = leer.nextLine();
        mostrarMensaje("Ingrese el tipo de Departamento del Empleado:");
        TipoDepartamento[] departamentos = TipoDepartamento.values();
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println((i + 1) + ". " + departamentos[i]);
        }
        int opcion = leer.nextInt();
        leer.nextLine();  // Limpiar el buffer de entrada - Esta línea es correcta

        while (opcion < 1 || opcion > departamentos.length) {
            mostrarMensaje("Opción inválida. Intente nuevamente:");
            opcion = leer.nextInt();
            leer.nextLine();  // Limpiar el buffer de entrada - Esta línea es correcta
        }

        TipoDepartamento tipoSeleccionado = departamentos[opcion - 1];

        int idDepartamento = tipoSeleccionado.ordinal() + 1;
        Departamento departamento = new Departamento(idDepartamento, tipoSeleccionado.name());
        Empleado empleado = new Empleado(nombreE, correoE, cedulaE, departamento);
        return empleado;
    }
}
