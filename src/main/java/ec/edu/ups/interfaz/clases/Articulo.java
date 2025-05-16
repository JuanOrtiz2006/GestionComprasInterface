package ec.edu.ups.interfaz.clases;

import ec.edu.ups.interfaz.enums.TipoProducto;

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

        float resIva;
        resIva = this.getPrecioU() *  IVA;
        return this.getPrecioU() - resIva;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nIVA: " + IVA + "%" +
                "\nCosto total: $" + calcularCosto();
    }
}
