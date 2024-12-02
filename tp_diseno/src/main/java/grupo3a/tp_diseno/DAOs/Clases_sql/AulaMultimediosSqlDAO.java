
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaMultimediosDAO;

public class AulaMultimediosSqlDAO implements AulaMultimediosDAO{

    public AulaMultimediosSqlDAO() {
    }
    
    //singleton
    private static AulaMultimediosSqlDAO instance;
    public static AulaMultimediosSqlDAO getInstance(){
        if(AulaMultimediosSqlDAO.instance == null)AulaMultimediosSqlDAO.instance =  new AulaMultimediosSqlDAO();
        return AulaMultimediosSqlDAO.instance;
    }

    
}
