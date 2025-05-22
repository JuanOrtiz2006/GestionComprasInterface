import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Producto {
    private String codigo;
    private String nombre;
    private double precioU;

    public Producto(String codigo, String nombre, double precioU) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioU = precioU;
    }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioU() { return precioU; }
}

public class TestChoiceProductos extends Frame {
    private Choice choiceProducto;

    public TestChoiceProductos() {
        setSize(400, 200);
        setLayout(new FlowLayout());

        choiceProducto = new Choice();

        // Lista de prueba con productos
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("P001", "Manzana", 0.50));
        listaProductos.add(new Producto("P002", "Banana", 0.30));
        listaProductos.add(new Producto("P003", "Cereza", 1.20));

        // Agregar productos al Choice
        for (Producto prod : listaProductos) {
            choiceProducto.add(prod.getCodigo() + " - " + prod.getNombre() + " - $" + prod.getPrecioU());
        }

        add(choiceProducto);

        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new TestChoiceProductos();
    }
}
