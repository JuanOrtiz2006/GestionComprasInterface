package ec.edu.ups.interfaz.view;

import java.awt.*;

public class VentanaRegistroSolicitud extends Frame {
    private Panel panelGeneral;
    private Panel panelNorte;
    private Panel panelCentral;
    private Panel panelOpciones;
    private Panel panelInformacion;
    private Panel panelDetalleCompra;


    private Label labelTitulo;
    private Label labelRegistroFecha;
    private Label labelRegistroId;
    private Label labelCodigo;
    private Label labelCantidad;
    private Label labelDescripcion;
    private Label labelPrecioU;
    private Label labelPrecioT;

    private TextField textCodigo;
    private TextField textCantidad;
    private TextArea textADescripcion;
    private TextField textPrecioU;
    private TextField textPrecioT;

    private Checkbox checkAprovado;
    private Checkbox checkDesaprovado;
    private Checkbox checkPendiente;

    private Button botonRegistrar;
    private Button botonAdd;
    private Button botonBuscar;

    public VentanaRegistroSolicitud (){
        setTitle("Registro de Solicitudes");
        setSize(500,500);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout(3,1));

        panelNorte = new Panel();
        labelTitulo = new Label("Registro de Solicitud");
        panelNorte.add(labelTitulo);

        panelCentral = new Panel(new BorderLayout(3,1));
        panelOpciones = new Panel(new BorderLayout(3,1));

        panelInformacion = new Panel(new GridLayout(2,1));
        labelRegistroFecha = new Label("Fecha:");
        labelRegistroId = new Label("Codigo:");
        panelInformacion.add(labelRegistroFecha);
        panelInformacion.add(labelRegistroId);
        panelDetalleCompra = new Panel(new GridLayout(3,5));
        labelCodigo = new Label("Cod. Producto");
        labelCantidad = new Label("Cantidad");
        labelDescripcion = new Label("Descripcion");
        labelPrecioU = new Label("Precio U");
        labelPrecioT = new Label("Precio T");
        textCodigo = new TextField();
        textCantidad = new TextField();
        textADescripcion = new TextArea();
        textPrecioU = new TextField();
        textPrecioT = new TextField();
        checkAprovado = new Checkbox("Aprovar");
        checkDesaprovado = new Checkbox("Rechazar");
        checkPendiente = new Checkbox("Pendiente");

        botonRegistrar = new Button("Registrar");

        panelDetalleCompra.add(labelCodigo);
        panelDetalleCompra.add(labelCantidad);
        panelDetalleCompra.add(labelDescripcion);
        panelDetalleCompra.add(labelPrecioU);
        panelDetalleCompra.add(labelPrecioT);
        panelDetalleCompra.add(textCodigo);
        panelDetalleCompra.add(textCantidad);
        panelDetalleCompra.add(textADescripcion);
        panelDetalleCompra.add(textPrecioU);
        panelDetalleCompra.add(textPrecioT);
        panelDetalleCompra.add(checkAprovado);
        panelDetalleCompra.add(checkDesaprovado);
        panelDetalleCompra.add(checkPendiente);

        panelOpciones.add(panelInformacion, BorderLayout.NORTH);
        panelOpciones.add(panelDetalleCompra, BorderLayout.CENTER);
        panelOpciones.add(botonRegistrar, BorderLayout.SOUTH);
        panelCentral.add(panelOpciones);




        panelGeneral.add(panelNorte, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        add(panelGeneral);

        setVisible(true);

        addWindowListener( new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose(); // Cierra solo esta ventana
            }
        });
    }


}
