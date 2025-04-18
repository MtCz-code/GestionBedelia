
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import java.util.List;


public interface BedelDAO extends UsuarioDAO {
    void crear(Bedel bedel) throws DAOException;
    List buscar(String datoCriterio) throws DAOException;
    List buscar(TurnoBedel datoCriterio) throws DAOException;
    void eliminar(Bedel bedel) throws DAOException;
    void modificar(Bedel vedel) throws DAOException;
    Bedel buscarPorId(Integer id) throws DAOException;
    
}
