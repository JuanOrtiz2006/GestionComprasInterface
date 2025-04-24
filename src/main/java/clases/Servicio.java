package clases;

import enums.TipoProducto;

public class Servicio extends Producto {
    private int tiempoHoras;

    public Servicio(String codigo, String nombre, float precioU, TipoProducto tipoProducto, int tiempoHoras) {
        super(codigo, nombre, precioU, tipoProducto);
        this.tiempoHoras = tiempoHoras;
    }

    public int getTiempoHoras() {
        return tiempoHoras;
    }
    public void setTiempoHoras(int tiempoHoras) {
        this.tiempoHoras = tiempoHoras;
    }
    @Override
    public float calcularCosto() {
            float costo=this.tiempoHoras*getPrecioU();
            return costo;
    }
    @Override
    public String toString(){
        return super.toString() +
                "\nTiempo de Servicio: " + tiempoHoras + " h" +
                "\nCosto total: $" + calcularCosto();
    }
}
