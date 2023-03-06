
package segundo.m;

import java.io.Serializable;
import java.util.Date;

public class Publicaciones implements Serializable{
    protected Integer id;
    protected Boolean visible;
    protected String texto;
    protected String hora;
    protected Date fecha;
    
    public Publicaciones() {}
    
    public Publicaciones(Boolean visible, String texto, String hora, Date fecha) {
        this.visible = visible;
        this.texto = texto;
        this.hora = hora;
        this.fecha = fecha;
    }
    
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
