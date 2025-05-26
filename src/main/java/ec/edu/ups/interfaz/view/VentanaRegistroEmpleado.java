
    package ec.edu.ups.interfaz.view;

    import ec.edu.ups.interfaz.clases.Empleado;
    import ec.edu.ups.interfaz.clases.Departamento;
    import ec.edu.ups.interfaz.enums.TipoDepartamento;

    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.ItemEvent;
    import java.awt.event.ItemListener;
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

        private TipoDepartamento departamentoSeleccionado;


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
            choiceDepartamento.add("Ingrese una opcion:");
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

            choiceDepartamento.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String seleccion = choiceDepartamento.getSelectedItem();
                        departamentoSeleccionado = TipoDepartamento.valueOf(seleccion);
                    }
                }
            });

            addWindowListener( new java.awt.event.WindowAdapter(){
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dispose(); // Cierra solo esta ventana
                }
            });

        }

        private void registrarEmpleado() {
            String nombre = textRegistroNombre.getText().trim();
            String correo = textRegistroCorreo.getText().trim();
            String cedula = textRegistroCedula.getText().trim();
            String departamentoStr = choiceDepartamento.getSelectedItem();

            // Validación de campos vacíos
            if (nombre.isEmpty() || correo.isEmpty() || cedula.isEmpty() || departamentoStr.equals("Ingrese una opcion:")) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y seleccione un departamento válido.", "Error", JOptionPane.ERROR_MESSAGE);
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
            Empleado empleado = new Empleado();
            empleado.setNombre(nombre);
            empleado.setEmail(correo);
            empleado.setCedula(cedula);
            Departamento departamento = new Departamento(departamentoSeleccionado.ordinal() + 1, departamentoSeleccionado.name());
            empleado.setDepartamento(departamento);

            // Guardar en la lista
            listaEmpleados.add(empleado);

            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente:\n" +
                            "Nombre: " + empleado.getNombre() + "\n" +
                            "Correo: " + empleado.getEmail() + "\n" +
                            "Cédula: " + empleado.getCedula() + "\n" +
                            "Departamento: " + empleado.getDepartamento().getNombreDepartamento(),
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
                                "Departamento: " + encontrado.getDepartamento().getNombreDepartamento(),
                        "Empleado Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
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


        public List<Empleado> getListaEmpleados() {
            return listaEmpleados;
        }
    }
