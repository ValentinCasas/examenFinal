package usuario.example.tpanexoa.Models;

import java.io.Serializable;
import java.util.Date;

public class Actividad implements Serializable {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String hora;
    private String lugar;

    public Actividad(String nombre, String descripcion, Date fecha, String hora, String lugar) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getLugar() {
        return lugar;
    }
}