package ec.edu.ups.interfaz.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaPrincipal extends Frame {

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
    private Button botonRegistrar;

    private Label labelRegistrar;

    public VentanaPrincipal() {
        panelGeneral = new Panel(new BorderLayout(3, 1));

        panelNorte = new Panel();
        titulo = new Label("Bienvenido");
        panelNorte.add(titulo);

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

        // Panel de impresión
        panelSur = new Panel(new GridLayout(2, 1));
        labelRegistrar = new Label("Imprimir listado de informacion");
        botonRegistrar = new Button("Imprimir");
        panelSur.add(labelRegistrar);
        panelSur.add(botonRegistrar);

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
                abrirVentanaRegistroEmpleado();
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

    //Metodo para abrir la ventana de registro de empleados
    private void abrirVentanaRegistroEmpleado() {
        new VentanaRegistroEmpleado();
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
