package ec.edu.ups.interfaz.view;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ec.edu.ups.interfaz.clases.DetalleCompra;
import ec.edu.ups.interfaz.clases.Producto;
import ec.edu.ups.interfaz.clases.Proveedor;
import ec.edu.ups.interfaz.clases.SolicitudDeCompra;
import ec.edu.ups.interfaz.enums.EstadoSolicitud;

import javax.swing.*;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class VentanaRegistroSolicitud extends Frame {
    private List<Producto> listaProductosExternos;
    private List<DetalleCompra> listaDetalleCompras;
    private List<SolicitudDeCompra> listaSolicitudes;

    private Panel panelGeneral;
    private Panel panelNorte;
    private Panel panelCentral;
    private Panel panelSur;
    private Panel panelOpciones;
    private Panel panelInformacion;
    private Panel panelDetalleCompra;
    private Panel panelCodigo;


    private float precioU;

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
    private TextField textFecha;

    private TextField textRegistroId;

    private Checkbox checkAprovado;
    private Checkbox checkDesaprovado;
    private Checkbox checkPendiente;
    private Checkbox checkSolicitado;

    private Button botonRegistrar;
    private Button botonAdd;
    private Button botonBuscar;
    private Button botonCalcularTotal;

    private Choice choiceProducto;
    private Choice choiceEstado;




    public VentanaRegistroSolicitud(List<Producto> listaProductosExternos) {


        listaDetalleCompras = new java.util.ArrayList<>();  // Inicializa atributo correctamente
        listaSolicitudes = new java.util.ArrayList<>();
        this.listaProductosExternos = listaProductosExternos;

        if (listaProductosExternos == null) {
            this.listaProductosExternos = new java.util.ArrayList<>();
        } else {
            this.listaProductosExternos = listaProductosExternos;
        }

        System.out.println("Productos recibidos en solicitud: " + listaProductosExternos.size());
        for (Producto p : listaProductosExternos) {
        System.out.println("Producto: " + p.getCodigo() + " - " + p.getNombre());
        }


setTitle("Registro de Solicitudes");
setSize(800, 400);
setLocationRelativeTo(null);

panelGeneral = new Panel(new BorderLayout(4, 1));

panelNorte = new Panel();
panelSur = new Panel(new GridLayout(1,5));
labelTitulo = new Label("Registro de Solicitud");
        panelNorte.add(labelTitulo);

panelCentral = new Panel(new BorderLayout(3, 1));
panelOpciones = new Panel(new BorderLayout(3, 1));

panelInformacion = new Panel(new GridLayout(4, 1));
labelRegistroFecha = new Label("Fecha:");
LocalDate fechaActual = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String fechaFormateada = fechaActual.format(formatter);
textFecha = new TextField();
        textFecha.setText(fechaFormateada);
        textFecha.setEditable(false);
panelCodigo = new Panel(new GridLayout(1, 2));

labelRegistroId = new Label("Codigo:");
textRegistroId = new TextField();
        panelCodigo.add(labelRegistroId);
        panelCodigo.add(textRegistroId);


        panelInformacion.add(labelRegistroFecha);
        panelInformacion.add(textFecha);
        panelInformacion.add(panelCodigo);

panelDetalleCompra = new Panel(new GridLayout(3, 8));  // Ajusté filas para incluir choice

labelCodigo = new Label("Cod. Producto");
labelCantidad = new Label("Cantidad");
botonCalcularTotal = new Button("Calcular Total");
labelDescripcion = new Label("Descripcion");
labelPrecioU = new Label("Precio U");
labelPrecioT = new Label("Precio T");

choiceProducto = new Choice();
        for (Producto prod : listaProductosExternos) {
        choiceProducto.add(prod.getCodigo() + " - " + prod.getNombre() + " - $" + prod.getPrecioU());
        }

textCantidad = new TextField();
textADescripcion = new TextArea();
textPrecioU = new TextField();
        textPrecioU.setEditable(false);
textPrecioT = new TextField();
        textPrecioT.setEditable(false);

botonAdd = new Button("Añadir");

checkAprovado = new Checkbox("Aprobar");
checkDesaprovado = new Checkbox("Rechazar");
checkPendiente = new Checkbox("Pendiente");
checkSolicitado= new Checkbox("Solicitado");

        checkAprovado.addItemListener(e -> validarCheckBox(checkAprovado));
        checkDesaprovado.addItemListener(e -> validarCheckBox(checkDesaprovado));
        checkPendiente.addItemListener(e -> validarCheckBox(checkPendiente));
        checkSolicitado.addItemListener(e -> validarCheckBox(checkSolicitado));

botonRegistrar = new Button("Registrar");


// Agregar componentes al panelDetalleCompra
        panelDetalleCompra.add(labelCodigo);
        panelDetalleCompra.add(choiceProducto);
        panelDetalleCompra.add(labelCantidad);
        panelDetalleCompra.add(textCantidad);
        panelDetalleCompra.add(labelDescripcion);
        panelDetalleCompra.add(textADescripcion);
        panelDetalleCompra.add(labelPrecioU);
        panelDetalleCompra.add(textPrecioU);
        panelDetalleCompra.add(labelPrecioT);
        panelDetalleCompra.add(textPrecioT);
        panelDetalleCompra.add(botonAdd);
        panelSur.add(checkAprovado);
        panelSur.add(checkDesaprovado);
        panelSur.add(checkPendiente);
        panelSur.add(checkSolicitado);
        panelSur.add(botonRegistrar);

        panelOpciones.add(panelInformacion, BorderLayout.NORTH);
        panelOpciones.add(panelDetalleCompra, BorderLayout.CENTER);
        panelOpciones.add(panelSur, BorderLayout.SOUTH);
        panelCentral.add(panelOpciones);

        panelGeneral.add(panelNorte, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
add(panelGeneral);

setVisible(true);

addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
        dispose();
    }
});


        botonAdd.addActionListener(new java.awt.event.ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        añadirDetalle();


    }
});
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        registrarSolicitud();
    }
});

        choiceProducto.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Hola mundo");
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int index = choiceProducto.getSelectedIndex();
            Producto productoSeleccionado = listaProductosExternos.get(index);
            textADescripcion.setText(productoSeleccionado.getNombre());
            textPrecioU.setText(String.valueOf(productoSeleccionado.getPrecioU()));

            // Opcional: limpiar cantidad y total cuando cambias producto
            textCantidad.setText("");
            textPrecioT.setText("");
        }
    }
});

        textCantidad.addTextListener(new java.awt.event.TextListener() {
    public void textValueChanged(java.awt.event.TextEvent e) {
        try {
            int cantidad = Integer.parseInt(textCantidad.getText());
            double precioUnitario = Double.parseDouble(textPrecioU.getText());
            double precioTotal = cantidad * precioUnitario;
            textPrecioT.setText(String.format("%.2f", precioTotal));
        } catch (NumberFormatException ex) {
            textPrecioT.setText("");
        }
    }
});
        }

public void actualizarListaProductos(List<Producto> productos) {
    this.listaProductosExternos = productos;
    choiceProducto.removeAll();
    for (Producto prod : productos) {
        choiceProducto.add(prod.getCodigo() + " - " + prod.getNombre() + " - $" + prod.getPrecioU());
        textPrecioU.setText(String.valueOf(prod.getPrecioU()));
    }

}

public void registrarPrecio() {

}


public void añadirDetalle() {

    int index = choiceProducto.getSelectedIndex();
    Producto productoSeleccionado = listaProductosExternos.get(index);

    int cantidad = Integer.parseInt(textCantidad.getText().trim());
    String descripcion = textADescripcion.getText().trim();

    if (cantidad <= 0 || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida y una descripción.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DetalleCompra detalle = new DetalleCompra(cantidad, productoSeleccionado, descripcion);
    listaDetalleCompras.add(detalle);

    JOptionPane.showMessageDialog(this, "Producto añadido al detalle:\n" + detalle.toString(), "Añadido", JOptionPane.INFORMATION_MESSAGE);


    textCantidad.setText("");
    textADescripcion.setText("");
    textPrecioU.setText("");
    textPrecioT.setText("");
}

public void registrarSolicitud() {
    String codigo = textRegistroId.getText().trim();

    if (codigo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese un código de solicitud.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (listaDetalleCompras.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se han añadido productos a la solicitud.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    EstadoSolicitud estado = null;
    if (checkAprovado.getState()) {
        estado = EstadoSolicitud.APROBADA;
    } else if (checkDesaprovado.getState()) {
        estado = EstadoSolicitud.RECHAZADA;
    } else if (checkPendiente.getState()) {
        estado = EstadoSolicitud.EN_REVISION;
    } else if (checkSolicitado.getState()) {
        estado = EstadoSolicitud.SOLICITADA;
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un estado para la solicitud.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear fecha
    GregorianCalendar fecha = new GregorianCalendar();

    // Crear la solicitud
    SolicitudDeCompra solicitud = new SolicitudDeCompra();
    solicitud.setIdSolicitud(codigo);
    solicitud.setFechaSolicitud(fecha);
    solicitud.setEstadoSolicitud(estado);
    solicitud.getDetalleCompras().addAll(listaDetalleCompras);

    // Si tienes solicitante (empleado) puedes setearlo aquí
    // solicitud.setSolicitante(empleadoActual);

    listaSolicitudes.add(solicitud); // Guardar en la lista general (si se desea)

    JOptionPane.showMessageDialog(this, "Solicitud registrada:\n" + solicitud.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Limpiar campos
    textRegistroId.setText("");
    listaDetalleCompras.clear();
    textCantidad.setText("");
    textADescripcion.setText("");
    textPrecioU.setText("");
    textPrecioT.setText("");
    checkAprovado.setState(false);
    checkDesaprovado.setState(false);
    checkPendiente.setState(false);
    checkSolicitado.setState(false);

    for (Producto prod : listaProductosExternos) {
        choiceProducto.add(prod.getCodigo() + " - " + prod.getNombre() + " - $" + prod.getPrecioU());
        textPrecioU.setText(String.valueOf(prod.getPrecioU()));
    }

}



public void validarCheckBox(Checkbox checkbox){
    if (checkAprovado.getState() == true && checkbox.getLabel().equals("APROBADA") ){
        checkDesaprovado.setState(false);
        checkPendiente.setState(false);
        checkSolicitado.setState(false);
    }
    if (checkDesaprovado.getState() == true && checkbox.getLabel().equals("RECHAZADA") ){
        checkAprovado.setState(false);
        checkPendiente.setState(false);
        checkSolicitado.setState(false);
    }
    if (checkPendiente.getState() == true && checkbox.getLabel().equals("EN_REVISION") ){
        checkAprovado.setState(false);
        checkDesaprovado.setState(false);
        checkSolicitado.setState(false);
    }
    if (checkSolicitado.getState() == true && checkbox.getLabel().equals("SOLICITADA") ){
        checkAprovado.setState(false);
        checkPendiente.setState(false);
        checkPendiente.setState(false);
    }
}

public void validarCheckBoxXD(Checkbox seleccionado) {
    if (seleccionado == checkAprovado) {
        checkDesaprovado.setState(false);
        checkPendiente.setState(false);
        checkSolicitado.setState(false);
    } else if (seleccionado == checkDesaprovado) {
        checkAprovado.setState(false);
        checkPendiente.setState(false);
        checkSolicitado.setState(false);
    } else if (seleccionado == checkPendiente) {
        checkAprovado.setState(false);
        checkDesaprovado.setState(false);
        checkSolicitado.setState(false);
    } else if (seleccionado == checkSolicitado) {
        checkAprovado.setState(false);
        checkDesaprovado.setState(false);
        checkPendiente.setState(false);
    }
}



}



