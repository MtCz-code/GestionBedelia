
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaMultimediosDAO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import java.util.List;

public class AulaMultimediosSqlDAO implements AulaMultimediosDAO{

    public AulaMultimediosSqlDAO() {
    }
    
    //singleton
    private static AulaMultimediosSqlDAO instance;
    public static AulaMultimediosSqlDAO getInstance(){
        if(AulaMultimediosSqlDAO.instance == null)AulaMultimediosSqlDAO.instance =  new AulaMultimediosSqlDAO();
        return AulaMultimediosSqlDAO.instance;
    }

    @Override
    public List<AulaMultimedios> getByTipoYCapacidad(TipoAula tipo, Integer capacidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
