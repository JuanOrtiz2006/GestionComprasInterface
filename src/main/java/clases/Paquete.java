package clases;

import enums.TipoProducto;

public class Paquete extends Producto{
    private float peso;

    public Paquete(String codigo, String nombre, float precioU, TipoProducto tipoProducto, float peso){
        super(codigo, nombre, precioU, tipoProducto);
        this.peso = peso;
    }

    public float getPeso(){
        return peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }

    @Override
    float calcularCosto(){
        float costo = this.peso*getPrecioU();
        return costo;
    }
    @Override
    public String toString(){
        return super.toString() +
                "\nPeso: " + peso + " Kg" +
                "\nCosto total: $" + calcularCosto();
    }
}
