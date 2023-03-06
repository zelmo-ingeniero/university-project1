
package segundo.DAO;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import segundo.modelos.Usuarios;
import segundo.modelos.Util;
/**
 *
 * @author zelmo
 */
public class DAOusuarios implements DataAccess<Usuarios> {

    @Override
    public Boolean guardar(Usuarios t) {
        try{
            System.out.println("abriendo sesion");
            Session ssn = Util.getSessionFactory().openSession();
            System.out.println("iniciando transaccion");            
            ssn.beginTransaction();            
            System.out.println("transaccion comenzada");
            if(t.getId() == -1){
                System.out.println("id == -1");
                t.setId(nuevoId(ssn));
                System.out.println("listo para guardar");
                ssn.save(t);
                System.out.println("Guardado.");
            }else{
                Usuarios u = new Usuarios();
                u.setId(t.getId());
                u.setNombre(t.getNombre());
                u.setEdad(t.getEdad());
                u.setEmail(t.getEmail());
                u.setContraseña(t.getContraseña());
                u.setSexo(t.getSexo());
                System.out.println("se va a actualizar");
                ssn.update(u);
                System.out.println("Actualizado.");
            }
            ssn.getTransaction().commit();
            System.out.println("transaccion cerrada ");
            ssn.close();
            System.out.println("sesion cerrada");
            return true;
        }catch(NullPointerException nllpe){
            System.out.println(nllpe);
            return false;
        }catch(HibernateException he){
            System.out.println("Error al guardar " + he);
            return false;
        }
    }

    @Override
    public Integer nuevoId(Session ssn) {
        Integer mayor = -1;        
        Criteria crtr;
        System.out.println("\nNuevo id");
        crtr = ssn.createCriteria(Usuarios.class);
        System.out.println("sesion " + ssn.toString());
        System.out.println("modelo " + Usuarios.class);
        //el criterio de consulta es el max("id")
        crtr.setProjection(Projections.max("id"));
        System.out.println("crtr max = " + crtr);
        //se obtiene el unico resultado de la consulta
        mayor = (Integer) crtr.uniqueResult();
        System.out.println("mayor = " + crtr.uniqueResult());
        if(mayor==null){
            return 1;
        }else{
            return mayor + 1;
        }
    }

    @Override
    public ArrayList<Usuarios> buscar() {
        ArrayList<Usuarios> salida = null;
        String hql = " FROM Usuarios ";
        Session ssn = Util.getSessionFactory().openSession();
        Query hconsulta = ssn.createQuery(hql);
        List<Usuarios> rhconsulta = hconsulta.list();
        ssn.close();
        rhconsulta.toArray();
        salida = (ArrayList<Usuarios>) rhconsulta;
        System.out.println("hecha la lista");
        return salida;
    }

    @Override
    public Usuarios obtener(Integer id) {
        Usuarios salida = null;
        Session ssn = Util.getSessionFactory().openSession();
        salida = (Usuarios) ssn.get(Usuarios.class, id);
        ssn.close();
        return salida;
    }

    @Override
    public Boolean borrar(Integer id) {
        Boolean salida = null;
        Usuarios u = obtener(id);
        Session ssn = Util.getSessionFactory().openSession();
        ssn.beginTransaction();        
        if(u == null){            
            System.out.println("usuario no existe");
            salida = false;
        }else{
            ssn.delete(u);
            salida = true;
        }
        ssn.getTransaction().commit();
        ssn.close();
        return salida;
    }
    
    /*
    
    METODOSBASICOS PERO CON EL MAIN
    
    @Override
    public Boolean guardar(Usuarios t) {
        if(t.getId().equals(-1)){
            t.setId(nuevoId());
            Segundo.usuarios.add(t);
            return true;
        }else{
            Usuarios v = this.obtener(t.getId());
            v.setNombre(t.getNombre());
            v.setEdad(t.getEdad());
            v.setSexo(t.getSexo());
            v.setContraseña(t.getContraseña());
            v.setEmail(t.getEmail());
            v.setPublicaciones(t.getPublicaciones());
            return true;
        }
//        Boolean existe = false;
//        Usuarios v = null;
//        for(Usuarios u: Main.usuarios){
//            if(u.getId().equals(t.getId())){                
//                v = u;
//                existe = true;
//            }
//        }        
//        System.out.println(existe.toString());
//        if(existe){
//            v.setNombre(t.getNombre());
//            v.setEdad(t.getEdad());
//            v.setSexo(t.getSexo());
//            v.setContraseña(t.getContraseña());
//            v.setEmail(t.getEmail());
//            v.setPublicaciones(t.getPublicaciones());
//            return true;
//        }else{
//            Main.usuarios.add(t);
//            System.out.println("se añadio"+ t.nombre);
//            return true;
//        }
    }

    @Override
    public Integer nuevoId() {
        Integer nid = 0;
        for(Usuarios v : Segundo.usuarios){
            if(v.getId() > nid){
                nid = v.getId();
            }
        }
        return nid + 1;
    }

    @Override
    public ArrayList buscar(String n) {
        ArrayList<Usuarios> salida = new ArrayList<>();
        for(Usuarios u: Segundo.usuarios){
            if(u.getNombre().toLowerCase().equals(n.toLowerCase())){
                salida.add(u);
            }
        }
        return salida;
    }

    @Override
    public Usuarios obtener(Integer id) {
        Usuarios salida = null;
        for(Usuarios u: Segundo.usuarios){
            if(u.getId().equals(id)){
                salida = u; //esto no estaba antes
                break;
            }
        }
        return salida;
    }

    @Override
    public Boolean borrar(Integer id) {
        Usuarios u = obtener(id);
        if(u != null){
            Segundo.usuarios.remove(u);
            System.out.println("removido");
            return true;
        }else{
            System.out.println("u no existe");
            return false;
        }
//        for(Usuarios i: Main.usuarios){
//            if(i.getId().equals(id)){
//                Main.usuarios.remove(obtener(id));
//                return true;
//            }else{
//                break;
//            }            
//        }
//        return false;
    }
    public Boolean publicar(String texto){        
        Boolean publicada = null;
        //Proximamente       
        return publicada;
    }
    */
}
