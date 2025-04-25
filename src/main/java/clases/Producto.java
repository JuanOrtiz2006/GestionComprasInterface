package clases;
import enums.TipoProducto;
public abstract class Producto {
    private String codigo;
    private String nombre;
    private float precioU;
    private TipoProducto tipoProductoA;

    public Producto(String coidgo, String nombre, float precioU, TipoProducto tipoProductoA){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioU = precioU;
        this.tipoProductoA = tipoProductoA;
    }

    public String getCodigo(){
        return codigo;

    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;

    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public float getPrecioU(){
        return precioU;

    }
    public void setPrecioU(float precioU){
        this.precioU = precioU;
    }

    public TipoProducto getTipoProducto(){
        return tipoProductoA;

    }
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProductoA = tipoProductoA;
    }

    abstract float calcularCosto();


    @Override
    public String toString(){

        return "Codigo: " + codigo +
                "\nProducto: " + nombre +
                "\nPrecio Unitario: " + precioU +
                "\nTipo: " + tipoProductoA;
    }
}
