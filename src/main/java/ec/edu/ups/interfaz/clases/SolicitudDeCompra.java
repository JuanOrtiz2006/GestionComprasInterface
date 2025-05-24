package ec.edu.ups.interfaz.clases;
import java.text.SimpleDateFormat;
import ec.edu.ups.interfaz.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudDeCompra {
    private String id;
    private EstadoSolicitud estadoSolicitud;
    private GregorianCalendar fechaSolicitud;
    private Empleado solicitante;
    private List<DetalleCompra> detalleCompras;

    public SolicitudDeCompra() {
        this.detalleCompras = new ArrayList<>();
    }

    public SolicitudDeCompra(String id, EstadoSolicitud estadoSolicitud, GregorianCalendar fechaSolicitud, Empleado solicitante, List<DetalleCompra> detalleCompras) {
        this.id = id;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.solicitante = solicitante;
        this.detalleCompras = detalleCompras;
    }

    public String getIdSolicitud() {
        return id;
    }

    public void setIdSolicitud(String id) {
        this.id = id;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public GregorianCalendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(GregorianCalendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public void addDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompras.add(detalleCompra);
    }

    public List<DetalleCompra> getDetalleCompras() {
        return detalleCompras;
    }

    public float calcularTotalSolicitud() {
        float total = 0;
        for (DetalleCompra detalle : detalleCompras) {
            total += detalle.getProducto().calcularCosto() * detalle.getCantidad();
        }
        return total;
    }
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String salida = "Código: " + id +
                " | Fecha: " + formato.format(fechaSolicitud.getTime()) +
                " | Solicitante: " + solicitante +
                " | Estado: " + estadoSolicitud +
                "\nDetalles:\n";

        for (DetalleCompra detalle : detalleCompras) {
            salida += "  - " + detalle.toString();
        }

        return salida;
    }
    }
