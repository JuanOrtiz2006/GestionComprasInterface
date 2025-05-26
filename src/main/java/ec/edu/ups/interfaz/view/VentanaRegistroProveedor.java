package ec.edu.ups.interfaz.view;

import ec.edu.ups.interfaz.clases.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentanaRegistroProveedor extends Frame{
    private List<Proveedor> listaProvedores = new ArrayList<>(); // Lista de empleados

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
    private Label labelRegistroEmpresa;
    private Label labelBNombre;

    private TextField textRegistroNombre;
    private TextField textRegistroCorreo;
    private TextField textRegistroCedula;
    private TextField textRegistroEmpresa;
    private TextField textBuscarEmpleado;
    private Button botonBuscar;

    private Button botonRegistrar;



    public VentanaRegistroProveedor(){

        setTitle("Registro de Provedores");
        setSize(500,500);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout(3,1));
        panelNorte = new Panel();
        titulo = new Label("Registro de Provedor");
        panelNorte.add(titulo);

        panelCentral = new Panel();
        panelOpciones = new Panel(new GridLayout(9,1));
        labelRegistroNombre = new Label("Ingrese el nombre:");
        textRegistroNombre = new TextField();
        labelRegistroCorreo = new Label("Ingrese el correo:");
        textRegistroCorreo = new TextField();
        labelRegistroCedual = new Label("Ingrese el numero de cedula:");
        textRegistroCedula = new TextField();
        labelRegistroEmpresa = new Label("Ingrese la empresa a la que pertenece:");
        textRegistroEmpresa = new TextField();
        botonRegistrar = new Button("Registrar");

        panelOpciones.add(labelRegistroNombre);
        panelOpciones.add(textRegistroNombre);
        panelOpciones.add(labelRegistroCorreo);
        panelOpciones.add(textRegistroCorreo);
        panelOpciones.add(labelRegistroCedual);
        panelOpciones.add(textRegistroCedula);
        panelOpciones.add(labelRegistroEmpresa);
        panelOpciones.add(textRegistroEmpresa);
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
                registrarProvedor();
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProvedor();
            }
        });

        addWindowListener( new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose(); // Cierra solo esta ventana
            }
        });

    }

    private void registrarProvedor() {
        String nombre = textRegistroNombre.getText().trim();
        String correo = textRegistroCorreo.getText().trim();
        String cedula = textRegistroCedula.getText().trim();
        String empresa = textRegistroEmpresa.getText().trim();

        if (nombre.isEmpty() || correo.isEmpty() || cedula.isEmpty() || empresa.isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validar nombre
        if (!validarNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre debe contener al menos un espacio (nombre y apellido).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar correo
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo válido (debe contener '@', un dominio como '.com', '.edu', '.org').", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar cédula
        if (!validarCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "Ingrese una cédula válida de 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear nuevo empleado
        Proveedor provedor = new Proveedor();
        provedor.setNombre(nombre);
        provedor.setEmail(correo);
        provedor.setCedula(cedula);
        provedor.setEmpresa(empresa);
        // Guardar en la lista
        listaProvedores.add(provedor);

        JOptionPane.showMessageDialog(this, "Provedor registrado correctamente:\n" +
                        "Nombre: " + provedor.getNombre() + "\n" +
                        "Correo: " + provedor.getEmail() + "\n" +
                        "Cédula: " + provedor.getCedula() + "\n" +
                        "Empresa: " + provedor.getEmpresa(),
                "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos
        textRegistroNombre.setText("");
        textRegistroCorreo.setText("");
        textRegistroCedula.setText("");
        textRegistroEmpresa.setText("");
    }

    private void buscarProvedor(){
        String cedula = textBuscarEmpleado.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese la cédula para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar en la lista
        Proveedor encontrado = null;
        for (Proveedor emp : listaProvedores) {
            if (emp.getCedula().equals(cedula)) {
                encontrado = emp;
                break;
            }
        }

        if (encontrado != null) {
            JOptionPane.showMessageDialog(this, "Provedor encontrado:\n" +
                            "Nombre: " + encontrado.getNombre() + "\n" +
                            "Correo: " + encontrado.getEmail() + "\n" +
                            "Cédula: " + encontrado.getCedula() + "\n" +
                            "Empresa: " + encontrado.getEmpresa(),
                    "Empleado Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Provedor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Limpiar campo de búsqueda
        textBuscarEmpleado.setText("");
    }

    public boolean validarNombre(String nombre){
        int cont=0;
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == ' ') {
                cont++;
            }
        }
        if (cont>=1){
            return true;
        }

        return false;
    }
    public boolean validarCorreo(String correo) {
        int validaciones = 0;
        String dominio = "";

        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                validaciones++;
            }

            if (correo.charAt(i) == '.') {
                validaciones++;

                // Obtener la parte después del punto
                dominio = correo.substring(i + 1);
                break;  // Salir del bucle, ya no hace falta seguir
            }
        }

        // Validar si el dominio es correcto (ejemplo: "com", "edu", "org", etc.)
        if (dominio.equals("com") || dominio.equals("edu") || dominio.equals("org")) {
            validaciones++;
        }

        // Si todas las validaciones se cumplen, devuelve true
        return validaciones == 3;
    }

    public boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }

        try {
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            int verificador = Integer.parseInt(cedula.substring(9, 10));

            // Validar provincia
            if (provincia < 1 || provincia > 24) return false;
            if (tercerDigito >= 6) return false;

            // Validar con algoritmo
            int suma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i + 1));
                if (i % 2 == 0) { // posiciones impares (0, 2, 4...)
                    digito *= 2;
                    if (digito > 9) digito -= 9;
                }
                suma += digito;
            }

            int resultado = suma % 10 == 0 ? 0 : 10 - (suma % 10);

            return resultado == verificador;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Proveedor> getListaProvedores() {
        return listaProvedores;
    }
}