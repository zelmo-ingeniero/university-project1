package segundo.modelos;

import java.io.Serializable;

public class Usuarios  implements Serializable {

     private int id;
     private Publicaciones publicaciones;
     private int edad;
     private String nombre;
     private String sexo;
     private String email;
     private String contraseña;

    public Usuarios() {
    }
	
    public Usuarios(int id, int edad, String nombre, String sexo, String email, String contraseña) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
        this.email = email;
        this.contraseña = contraseña;
    }
    public Usuarios(int id, Publicaciones publicaciones, int edad, String nombre, String sexo, String email, String contraseña) {
       this.id = id;
       this.publicaciones = publicaciones;
       this.edad = edad;
       this.nombre = nombre;
       this.sexo = sexo;
       this.email = email;
       this.contraseña = contraseña;
    }
   
    public int getId() {
        return this.id;
    }    
    public void setId(int id) {
        this.id = id;
    }
    public Publicaciones getPublicaciones() {
        return this.publicaciones;
    }    
    public void setPublicaciones(Publicaciones publicaciones) {
        this.publicaciones = publicaciones;
    }
    public int getEdad() {
        return this.edad;
    }    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return this.nombre;
    }    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSexo() {
        return this.sexo;
    }    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEmail() {
        return this.email;
    }    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseña() {
        return this.contraseña;
    }    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}


