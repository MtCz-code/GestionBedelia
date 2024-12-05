
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import java.util.List;


public class AulaLaboratorioSqlDAO implements AulaLaboratorioDAO{

    public AulaLaboratorioSqlDAO() {
    }
    
    //singleton
    private static AulaLaboratorioSqlDAO instance;
    public static AulaLaboratorioSqlDAO getInstance(){
        if(AulaLaboratorioSqlDAO.instance == null)AulaLaboratorioSqlDAO.instance =  new AulaLaboratorioSqlDAO();
        return AulaLaboratorioSqlDAO.instance;
    }

    @Override
    public List<AulaLaboratorio> getByTipoYCapacidad(TipoAula tipo, Integer capacidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
