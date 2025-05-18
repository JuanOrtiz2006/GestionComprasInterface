package ec.edu.ups.interfaz.view;

import ec.edu.ups.interfaz.clases.Empleado;
import ec.edu.ups.interfaz.clases.Departamento;
import ec.edu.ups.interfaz.enums.TipoDepartamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentanaRegistroEmpleado extends Frame{

    private List<Empleado> listaEmpleados = new ArrayList<>(); // Lista de empleados

    private Panel panelGeneral;
    private Panel panelNorte;
    private Panel panelCentral;
    private Panel panelOpciones;
    private Panel panelSur;
    private Panel panelOpcionesBusqueda;

    private Label titulo;
    private Label labelRegistroNombre;
    private Label labelRegistroCorreo;
    private Label labelRegistroCedual;
    private Label labelRegistroDepartamento;
    private Label labelBNombre;

    private TextField textRegistroNombre;
    private TextField textRegistroCorreo;
    private TextField textRegistroCedula;
    private TextField textBuscarEmpleado;
    private Button botonBuscar;

    private Choice choiceDepartamento;
    private Button botonRegistrar;

    public VentanaRegistroEmpleado(){
        setTitle("Registro de Empleado");
        setSize(500,500);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout(3,1));
        panelNorte = new Panel();
        titulo = new Label("Registro de Empleado");
        panelNorte.add(titulo);

        panelCentral = new Panel();
        panelOpciones = new Panel(new GridLayout(9,1));
        labelRegistroNombre = new Label("Ingrese el nombre:");
        textRegistroNombre = new TextField();
        labelRegistroCorreo = new Label("Ingrese el correo:");
        textRegistroCorreo = new TextField();
        labelRegistroCedual = new Label("Ingrese el numero de cedula:");
        textRegistroCedula = new TextField();
        labelRegistroDepartamento = new Label("Ingrese el Departamento al que pertenece:");
        choiceDepartamento = new Choice();
        choiceDepartamento.add("SECRETARIA");
        choiceDepartamento.add("ADMINISTRACION");
        choiceDepartamento.add("EJECUTIVO");
        choiceDepartamento.add("RRHH");
        botonRegistrar = new Button("Registrar");

        panelOpciones.add(labelRegistroNombre);
        panelOpciones.add(textRegistroNombre);
        panelOpciones.add(labelRegistroCorreo);
        panelOpciones.add(textRegistroCorreo);
        panelOpciones.add(labelRegistroCedual);
        panelOpciones.add(textRegistroCedula);
        panelOpciones.add(labelRegistroDepartamento);
        panelOpciones.add(choiceDepartamento);
        panelOpciones.add(botonRegistrar);
        panelCentral.add(panelOpciones);

        panelSur = new Panel();
        panelOpcionesBusqueda = new Panel(new GridLayout(4,1));
        labelBNombre = new Label("Ingrese la cedula:");
        textBuscarEmpleado = new TextField();
        botonBuscar = new Button("Buscar Persona");
        panelOpcionesBusqueda.add(labelBNombre);
        panelOpcionesBusqueda.add(textBuscarEmpleado);
        panelOpcionesBusqueda.add(botonBuscar);
        panelSur.add(panelOpcionesBusqueda);

        panelGeneral.add(panelNorte, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        panelGeneral.add(panelSur, BorderLayout.SOUTH);
        add(panelGeneral);
        setVisible(true);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEmpleado();
            }
        });
    }

    private void registrarEmpleado() {
        String nombre = textRegistroNombre.getText().trim();
        String correo = textRegistroCorreo.getText().trim();
        String cedula = textRegistroCedula.getText().trim();
        String departamentoSeleccionado = choiceDepartamento.getSelectedItem();

        if (nombre.isEmpty() || correo.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear nuevo empleado
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setEmail(correo);
        empleado.setCedula(cedula);
        TipoDepartamento tipoDepartamento = TipoDepartamento.valueOf(departamentoSeleccionado);
        Departamento departamento = new Departamento(tipoDepartamento.ordinal() + 1, tipoDepartamento.name());
        empleado.setDepartamento(departamento);

        // Guardar en la lista
        listaEmpleados.add(empleado);

        JOptionPane.showMessageDialog(this, "Empleado registrado correctamente:\n" +
                        "Nombre: " + empleado.getNombre() + "\n" +
                        "Correo: " + empleado.getEmail() + "\n" +
                        "Cédula: " + empleado.getCedula() + "\n" +
                        "Departamento: " + empleado.getDepartamento(),
                "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos
        textRegistroNombre.setText("");
        textRegistroCorreo.setText("");
        textRegistroCedula.setText("");
        choiceDepartamento.select(0);
    }

    private void buscarEmpleado(){
        String cedula = textBuscarEmpleado.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese la cédula para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar en la lista
        Empleado encontrado = null;
        for (Empleado emp : listaEmpleados) {
            if (emp.getCedula().equals(cedula)) {
                encontrado = emp;
                break;
            }
        }

        if (encontrado != null) {
            JOptionPane.showMessageDialog(this, "Empleado encontrado:\n" +
                            "Nombre: " + encontrado.getNombre() + "\n" +
                            "Correo: " + encontrado.getEmail() + "\n" +
                            "Cédula: " + encontrado.getCedula() + "\n" +
                            "Departamento: " + encontrado.getDepartamento(),
                    "Empleado Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Limpiar campo de búsqueda
        textBuscarEmpleado.setText("");
    }
}
