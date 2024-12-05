/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaDAO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import java.util.List;

/**
 *
 * @author exero
 */
public class AulaSqlDAO implements AulaDAO{

    public AulaSqlDAO() {
    }
    //singleton
    private static AulaSqlDAO instance;
    public static AulaSqlDAO getInstance(){
        if(AulaSqlDAO.instance == null)AulaSqlDAO.instance =  new AulaSqlDAO();
        return AulaSqlDAO.instance;
    }

    @Override
    public List<AulaGeneral> getByTipoYCapacidad(TipoAula tipo, Integer capacidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
    
    
    
}
