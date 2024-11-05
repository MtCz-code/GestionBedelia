/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaPeriodicaDAO;

/**
 *
 * @author exero
 */
public class ReservaPeriodicaSqlDAO implements ReservaPeriodicaDAO{

    public ReservaPeriodicaSqlDAO() {
    }
    
    //singleton
    private static ReservaPeriodicaSqlDAO instance;
    public static ReservaPeriodicaSqlDAO getInstance(){
        if(ReservaPeriodicaSqlDAO.instance == null)ReservaPeriodicaSqlDAO.instance =  new ReservaPeriodicaSqlDAO();
        return ReservaPeriodicaSqlDAO.instance;
    }
    
}
