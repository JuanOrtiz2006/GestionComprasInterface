package ec.edu.ups.interfaz.clases;
public class DetalleCompra implements Calculable {
    private int cantidad;
    private Producto producto;
    private String descripcion;

    public DetalleCompra(int cantidad, Producto producto, String descripcion) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.descripcion = descripcion;
    }

    public DetalleCompra() {
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public double calcularCostoTotal() {
        return cantidad * producto.calcularCosto();
    }

    @Override
    public String toString() {
        return "| Producto: " + producto.getNombre() +
                " | Cantidad: " + cantidad +
                " | Descripción: " + descripcion +
                " | Precio Unitario: $" + String.format("%.2f", producto.calcularCosto()) +
                " | Precio Total: $" + String.format("%.2f", calcularCostoTotal()) +
                " |\n";
    }
    }