package ec.edu.ups.interfaz.view;

import ec.edu.ups.interfaz.clases.Empleado;
import ec.edu.ups.interfaz.clases.Producto;
import ec.edu.ups.interfaz.clases.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class VentanaPrincipal extends Frame {
    private VentanaRegistroEmpleado ventanaRegistroEmpleado;
    private VentanaRegistroProvedor ventanaRegistroProvedor;
    private VentanaRegistroProducto ventanaRegistroProducto;

    private java.util.List<Empleado> listaEmpleados = new ArrayList<>();
    private java.util.List<Proveedor> listaProvedores = new ArrayList<>();
    private java.util.List<Producto> listaProductos = new ArrayList<>();

    private Panel panelGeneral;
    private Panel panelNorte;
    private Label titulo;
    private Panel panelCentral;
    private Panel panelEmpleados;
    private Panel panelProvedores;
    private Panel panelProductos;
    private Panel panelSolicitudes;
    private Panel panelSur;

    private Button botonOpcionesEmpleado;
    private Button botonOpcionesProvedor;
    private Button botonOpcionesProducto;
    private Button botonOpcionesSolicitud;
    private Button botonImprimirInformacion;

    private Label labelInformacion;

    public VentanaPrincipal() {
        panelGeneral = new Panel(new BorderLayout(3, 1));

        //Panel Superior
        panelNorte = new Panel();
        titulo = new Label("Bienvenido");
        panelNorte.add(titulo);

        //Panel Central
        panelCentral = new Panel();
        // Panel de Empleados
        panelEmpleados = new Panel(new BorderLayout(2, 1));
        panelEmpleados.add(crearPanelConImagen("Empleados", "src/main/java/ec/edu/ups/interfaz/imagenes/imagenEmpleados.png"), BorderLayout.NORTH);
        botonOpcionesEmpleado = new Button("Opciones");
        panelEmpleados.add(botonOpcionesEmpleado);
        panelCentral.add(panelEmpleados);
        // Panel de Proveedores
        panelProvedores = new Panel(new BorderLayout(2, 1));
        panelProvedores.add(crearPanelConImagen("Proveedores", "src/main/java/ec/edu/ups/interfaz/imagenes/imagenProvedores.png"), BorderLayout.NORTH);
        botonOpcionesProvedor = new Button("Opciones");
        panelProvedores.add(botonOpcionesProvedor);
        panelCentral.add(panelProvedores);
        // Panel de Productos
        panelProductos = new Panel(new BorderLayout(2, 1));
        panelProductos.add(crearPanelConImagen("Productos", "src/main/java/ec/edu/ups/interfaz/imagenes/imagenProducto.png"), BorderLayout.NORTH);
        botonOpcionesProducto = new Button("Opciones");
        panelProductos.add(botonOpcionesProducto);
        panelCentral.add(panelProductos);
        // Panel de Solicitudes
        panelSolicitudes = new Panel(new BorderLayout(2, 1));
        panelSolicitudes.add(crearPanelConImagen("Solicitudes", "src/main/java/ec/edu/ups/interfaz/imagenes/imagenSolicitud.png"), BorderLayout.NORTH);
        botonOpcionesSolicitud = new Button("Opciones");
        panelSolicitudes.add(botonOpcionesSolicitud);
        panelCentral.add(panelSolicitudes);

        // Panel Inferior
        panelSur = new Panel(new GridLayout(2, 1));
        labelInformacion = new Label("Imprimir listado de informacion");
        botonImprimirInformacion = new Button("Imprimir");
        panelSur.add(labelInformacion);
        panelSur.add(botonImprimirInformacion);

        //Agregacion de Paneles al Panel General y al Frame
        panelGeneral.add(panelNorte, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        panelGeneral.add(panelSur, BorderLayout.SOUTH);
        add(panelGeneral);
        setSize(500, 500);
        setVisible(true);
        // Evento para el botón de empleados
        botonOpcionesEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaRegistroEmpleado == null) {
                    ventanaRegistroEmpleado = new VentanaRegistroEmpleado();
                } else {
                    ventanaRegistroEmpleado.setVisible(true);
                }
            }
        });
        // Evento para el botón de proveedores
        botonOpcionesProvedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaRegistroProvedor == null) {
                    ventanaRegistroProvedor = new VentanaRegistroProvedor();
                } else {
                    ventanaRegistroProvedor.setVisible(true);
                }
            }
        });
        //Evento para el boton de productos
        botonOpcionesProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaRegistroProducto == null) {
                    ventanaRegistroProducto = new VentanaRegistroProducto();
                } else {
                    ventanaRegistroProducto.setVisible(true);
                }
            }
        });
        //Evento para el boton de Imprimir Informacion
        botonImprimirInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirInformacion();
            }
        });

        addWindowListener( new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose(); // Cierra solo esta ventana
            }
        });


    }

    private static Panel crearPanelConImagen(String titulo, String rutaImagen) {
        Panel panel = new Panel(new GridLayout(2, 1));
        Label tituloLabel = new Label(titulo, Label.CENTER);
        panel.add(tituloLabel);

        // Verifica si el archivo de imagen existe
        File archivoImagen = new File(rutaImagen);
        if (archivoImagen.exists()) {
            Image imagen = Toolkit.getDefaultToolkit().getImage(rutaImagen);
            Canvas lienzoImagen = new Canvas() {
                @Override
                public void paint(Graphics g) {
                    g.drawImage(imagen, 0, 0, 100, 100, this);
                }

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            panel.add(lienzoImagen);
        } else {
            Label sinImagen = new Label("Imagen no encontrada", Label.CENTER);
            panel.add(sinImagen);
        }

        return panel;
    }

    private void imprimirInformacion() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Lista de Empleados:\n");

        // Verificamos si la ventana de empleados existe
        if (ventanaRegistroEmpleado == null) {
            informacion.append("No hay empleados registrados.\n");
        } else {
            listaEmpleados = ventanaRegistroEmpleado.getListaEmpleados();
            if (listaEmpleados.isEmpty()) {
                informacion.append("No hay empleados registrados.\n");
            } else {
                for (Empleado emp : listaEmpleados) {
                    informacion.append(emp.getNombre())
                            .append(" Ced: ").append(emp.getCedula())
                            .append(" Dep: ").append(emp.getDepartamento().getNombreDepartamento())
                            .append(" @: ").append(emp.getEmail()).append("\n");
                }
            }
        }

        informacion.append("\nLista de Proveedores:\n");

        // Verificamos si la ventana de proveedores existe
        if (ventanaRegistroProvedor == null) {
            informacion.append("No hay proveedores registrados.\n");
        } else {
            listaProvedores = ventanaRegistroProvedor.getListaProvedores();
            if (listaProvedores.isEmpty()) {
                informacion.append("No hay proveedores registrados.\n");
            } else {
                for (Proveedor prov : listaProvedores) {
                    informacion.append("\n").append(prov.getNombre())
                            .append(" Ced: ").append(prov.getCedula())
                            .append(" Emp: ").append(prov.getEmpresa())
                            .append(" @: ").append(prov.getEmail()).append("\n");
                }
            }
        }

        informacion.append("\nLista de Productos:\n");

        // Verificamos si la ventana de productos existe
        if (ventanaRegistroProducto == null) {
            informacion.append("No hay productos registrados.\n");
        } else {
            listaProductos = ventanaRegistroProducto.getListaProductos();
            if (listaProductos.isEmpty()) {
                informacion.append("No hay productos registrados.\n");
            } else {
                for (Producto prod : listaProductos) {
                    informacion.append("\n").append(prod.getNombre())
                            .append(" Cod: ").append(prod.getCodigo())
                            .append(" $: ").append(prod.getPrecioU())
                            .append(" Tipo: ").append(prod.getTipoProducto()).append("\n");
                }
            }
        }


        // Mostrar la información en un JOptionPane
        JOptionPane.showMessageDialog(this, informacion.toString(), "Información General", JOptionPane.INFORMATION_MESSAGE);
    }



    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
