package clases;

import enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudDeCompra {
    private int idSolicitud;
    private EstadoSolicitud estadoSolicitud;
    private GregorianCalendar fechaSolicitud;
    private Empleado solicitante;
    private List<DetalleCompra> detalleCompras;

    public SolicitudDeCompra() {
        this.detalleCompras = new ArrayList<>();
    }

    public SolicitudDeCompra(int idSolicitud, EstadoSolicitud estadoSolicitud, GregorianCalendar fechaSolicitud, Empleado solicitante, List<DetalleCompra> detalleCompras) {
        this.idSolicitud = idSolicitud;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.solicitante = solicitante;
        this.detalleCompras = detalleCompras;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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


    @Override

    public String toString(){
        return "";
    }
}
