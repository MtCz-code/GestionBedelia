/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import java.util.List;
import grupo3a.tp_diseno.DAOs.AulaGeneralDAO;

/**
 *
 * @author exero
 */
public class AulaGeneralSqlDAO implements AulaGeneralDAO{

    public AulaGeneralSqlDAO() {
    }
    //singleton
    private static AulaGeneralSqlDAO instance;
    public static AulaGeneralSqlDAO getInstance(){
        if(AulaGeneralSqlDAO.instance == null)AulaGeneralSqlDAO.instance =  new AulaGeneralSqlDAO();
        return AulaGeneralSqlDAO.instance;
    }

    @Override
    public List<AulaGeneral> getByTipoYCapacidad(TipoAula tipo, Integer capacidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
    
    
    
}
