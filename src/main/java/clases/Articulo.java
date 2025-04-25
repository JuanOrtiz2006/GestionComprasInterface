package clases;

import enums.TipoProducto;

public class Articulo extends Producto {
    private float IVA;

    public Articulo(String codigo, String nombre, float precioU, TipoProducto tipoProductoA, float IVA) {
        super(codigo, nombre, precioU, tipoProductoA);
        this.IVA = IVA;
    }

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    @Override
    public float calcularCosto() {
        return this.getPrecioU() *  IVA;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nIVA: " + IVA + "%" +
                "\nCosto total: $" + calcularCosto();
    }
}
