
package segundo.DAO;

import java.util.ArrayList;
import org.hibernate.Session;

public interface DataAccess <T> {
    //crear actualizar
    public Boolean guardar(T t);
    public Integer nuevoId(Session s);
    //leer
    public ArrayList<T> buscar();
    public T obtener(Integer id);
    //borrar
    public Boolean borrar(Integer id);
        
}
