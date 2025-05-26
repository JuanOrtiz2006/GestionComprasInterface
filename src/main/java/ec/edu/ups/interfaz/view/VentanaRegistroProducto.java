package ec.edu.ups.interfaz.view;

import ec.edu.ups.interfaz.clases.*;
import ec.edu.ups.interfaz.enums.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistroProducto extends Frame{
    private List<Producto> listaProductos = new ArrayList<>();

    private Articulo articulo;
    private Paquete paquete;
    private Servicio servicio;

    private Panel panelGeneral;
    private Panel panelNorte;
    private Panel panelCentral;
    private Panel panelOpciones;
    private Panel panelSur;
    private Panel panelOpcionesBusqueda;

    private Label labelTitulo;
    private Label labelTipo;
    private Label labelCodigo;
    private Label labelNombre;
    private Label labelPrecio;
    private Label labelClase;
    private Label labelBusqueda;
    private Label labelAdicion;


    private TextField textCodigo;
    private TextField textNombre;
    private TextField textPrecio;
    private TextField textAdicional;
    private TextField textBCodigo;

    private Button botonRegistrar;
    private Button botonBuscar;

    private Choice choiceTipo;
    private Choice choiceClase;

    private TipoProducto claseProducto;
    private String tipo;

    public VentanaRegistroProducto (){

        setTitle("Registro de Productos");
        setSize(500,700);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout(3,1));

        panelNorte = new Panel();
        labelTitulo = new Label("Regostro de producto");
        panelNorte.add(labelTitulo);

        panelCentral = new Panel();
        panelOpciones = new Panel(new GridLayout(13,1));
        labelTipo = new Label("Ingrese el tipo de producto");
        choiceTipo = new Choice();
        choiceTipo.add("Seleccione el tipo de producto: ");
        choiceTipo.add("ARTICULO");
        choiceTipo.add("PAQUETE");
        choiceTipo.add("SERVICIO");
        labelCodigo = new Label("Ingrese el codigo del producto");
        textCodigo = new TextField();
        labelNombre = new Label("Ingrese el nombre del producto");
        textNombre = new TextField();
        labelPrecio = new Label("Ingrese el precio del producto");
        textPrecio = new TextField();
        labelClase = new Label("Eliga la clase de producto");
        choiceClase = new Choice();
        choiceClase.add("Seleccione el tipo: ");
        choiceClase.add("LIMPIEZA");
        choiceClase.add("ALIMENTO");
        choiceClase.add("MASCOTAS");
        choiceClase.add("CASA");
        choiceClase.add("OTROS");
        labelAdicion = new Label("Ingrese el IVA: ");
        textAdicional = new TextField();
        botonRegistrar = new Button("Registrar");

        panelOpciones.add(labelTipo);
        panelOpciones.add(choiceTipo);
        panelOpciones.add(labelCodigo);
        panelOpciones.add(textCodigo);
        panelOpciones.add(labelNombre);
        panelOpciones.add(textNombre);
        panelOpciones.add(labelPrecio);
        panelOpciones.add(textPrecio);
        panelOpciones.add(labelClase);
        panelOpciones.add(choiceClase);
        panelOpciones.add(labelAdicion);
        panelOpciones.add(textAdicional);
        panelOpciones.add(botonRegistrar);
        panelCentral.add(panelOpciones);

        panelSur = new Panel();
        panelOpcionesBusqueda = new Panel(new GridLayout(3,1));
        labelBusqueda = new Label("Ingrese el codigo del producto");
        textBCodigo = new TextField();
        botonBuscar = new Button("Buscar");
        panelOpcionesBusqueda.add(labelBusqueda);
        panelOpcionesBusqueda.add(textBCodigo);
        panelOpcionesBusqueda.add(botonBuscar);
        panelSur.add(panelOpcionesBusqueda);

        panelGeneral.add(panelNorte, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        panelGeneral.add(panelSur, BorderLayout.SOUTH);

        add(panelGeneral);
        setVisible(true);

        choiceTipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    tipo = choiceTipo.getSelectedItem();

                    if (tipo == "ARTICULO"){
                        labelAdicion.setText("Ingrese el IVA: ");
                        textCodigo.setText("A-1");
                    }
                    if (tipo == "PAQUETE"){
                        labelAdicion.setText("Ingrese el peso en kg");
                        textCodigo.setText("P-1");
                    }
                    if (tipo == "SERVICIO"){
                        labelAdicion.setText("Ingrese las horas del servicio");
                        textCodigo.setText("S-1");
                    }
                }
            }
        });

        choiceClase.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String clase = choiceClase.getSelectedItem();
                    claseProducto = TipoProducto.valueOf(clase);
                }
            }
        });

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        addWindowListener( new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose(); // Cierra solo esta ventana
            }
        });

    }

    public void registrarProducto(){
        String codigo = textCodigo.getText();
        String nombre = textNombre.getText();
        float precio = Float.parseFloat(textPrecio.getText());
        float iva;
        float peso;
        int horas;

        if (nombre.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarCodigo(codigo)) {
            JOptionPane.showMessageDialog(this, "El codigo es Incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ("ARTICULO".equals(tipo)){
            iva= Float.parseFloat(textAdicional.getText());
            articulo = new Articulo(codigo,nombre,precio,claseProducto, iva);
            listaProductos.add(articulo);
            JOptionPane.showMessageDialog(this, "Articulo registrado correctamente:\n" +
                            "Codigo: " + articulo.getCodigo() + "\n" +
                            "Nombre: " + articulo.getNombre() + "\n" +
                            "Precio: " + articulo.getPrecioU() + "\n" +
                            "Tipo: " + articulo.getTipoProducto() + "\n" +
                            "IVA: " + articulo.getIVA(),
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
        if ("PAQUETE".equals(tipo)){
            peso = Float.parseFloat(textAdicional.getText());
            paquete = new Paquete(codigo,nombre,precio,claseProducto, peso);
            listaProductos.add(paquete);
            JOptionPane.showMessageDialog(this, "Paquete registrado correctamente:\n" +
                            "Codigo: " + paquete.getCodigo() + "\n" +
                            "Nombre: " + paquete.getNombre() + "\n" +
                            "Precio: " + paquete.getPrecioU() + "\n" +
                            "Tipo: " + paquete.getTipoProducto() + "\n" +
                            "Peso: " + paquete.getPeso(),
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
        if ("SERVICIO".equals(tipo)){
            horas = Integer.parseInt(textAdicional.getText());
            servicio = new Servicio(codigo,nombre,precio,claseProducto,horas);
            listaProductos.add(servicio);
            JOptionPane.showMessageDialog(this, "Servicio registrado correctamente:\n" +
                            "Codigo: " + servicio.getCodigo() + "\n" +
                            "Nombre: " + servicio.getNombre() + "\n" +
                            "Precio: " + servicio.getPrecioU() + "\n" +
                            "Tipo: " + servicio.getTipoProducto() + "\n" +
                            "Horas: " + servicio.getTiempoHoras(),
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }

        // Limpiar campos
        textCodigo.setText("");
        textNombre.setText("");
        textPrecio.setText("");
        textAdicional.setText("");
        choiceTipo.select(0);
        choiceClase.select(0);
    }

    private void buscarProducto(){
        String codigo = textBCodigo.getText();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el codigo para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar en la lista
        Producto encontrado = null;
        for (Producto prod : listaProductos) {
            if (prod.getCodigo().equals(codigo)) {
                encontrado = prod;
                break;
            }
        }

        if (encontrado != null) {
            JOptionPane.showMessageDialog(this, "Producto encontrado:\n" +
                            "Codigo: " + encontrado.getCodigo() + "\n" +
                            "Nombre: " + encontrado.getNombre() + "\n" +
                            "Precio: " + encontrado.getPrecioU() + "\n" +
                            "Tipo: " + encontrado.getTipoProducto() + "\n",
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Limpiar campo de búsqueda
        textBCodigo.setText("");
    }

    public boolean validarCodigo(String codigo) {
        if (codigo.length() < 3) {
            return false;
        }

        // Verificar que comienza con un prefijo válido
        String prefijo = codigo.substring(0, 2);
        if (!prefijo.equals("A-") && !prefijo.equals("P-") && !prefijo.equals("S-")) {
            return false;
        }

        // Obtener la parte numérica después del prefijo
        String numeroTexto = codigo.substring(2);
        int numero;

        try {
            numero = Integer.parseInt(numeroTexto);
        } catch (NumberFormatException e) {
            return false; // No es un número válido
        }

        // Validar que el número sea mayor o igual a 0
        return numero >= 0;
    }

    public List<Producto> getListaProductos(){
        return listaProductos;
    }
}