
package segundo.m;

import java.io.Serializable;
import java.util.ArrayList;

public class RedSocial implements Serializable{
    protected String nombre;
    protected String url;
    protected String pais;
    protected String distrito;
    protected String ciudad;
    protected String servidor;
    protected ArrayList<Usuarios> usuarios = new ArrayList<>();

    public RedSocial(String nombre, String url, String pais, String distrito, String ciudad, String servidor, ArrayList<Usuarios> usuarios) {
        this.nombre = nombre;
        this.url = url;
        this.pais = pais;
        this.distrito = distrito;
        this.ciudad = ciudad;
        this.servidor = servidor;
        this.usuarios = usuarios;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    
}
