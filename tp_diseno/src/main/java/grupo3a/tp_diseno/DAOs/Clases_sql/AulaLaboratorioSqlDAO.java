
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;


public class AulaLaboratorioSqlDAO implements AulaLaboratorioDAO{

    public AulaLaboratorioSqlDAO() {
    }
    
    //singleton
    private static AulaLaboratorioSqlDAO instance;
    public static AulaLaboratorioSqlDAO getInstance(){
        if(AulaLaboratorioSqlDAO.instance == null)AulaLaboratorioSqlDAO.instance =  new AulaLaboratorioSqlDAO();
        return AulaLaboratorioSqlDAO.instance;
    }
    
}
