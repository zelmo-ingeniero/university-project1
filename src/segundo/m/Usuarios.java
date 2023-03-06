
package segundo.m;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuarios implements Serializable{
    public Integer id;
    public Integer edad;    
    public String nombre;
    public String sexo;
    public String email;
    public String contraseña;
    public ArrayList<Publicaciones> publicaciones = new ArrayList<>();
    
    public Usuarios(){}
    
    public Usuarios(Integer id, Integer edad, String nombre, String sexo, String email, String contraseña) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
        this.email = email;
        this.contraseña = contraseña;
    }    
    
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Publicaciones> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
