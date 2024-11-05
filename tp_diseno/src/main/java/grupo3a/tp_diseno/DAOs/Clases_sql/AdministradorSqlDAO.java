
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AdministradorDAO;

/**
 *
 * @author exero
 */
public class AdministradorSqlDAO implements AdministradorDAO{

    public AdministradorSqlDAO() {
    }
    
    //singleton
    private static AdministradorSqlDAO instance;
    public static AdministradorSqlDAO getInstance(){
        if(AdministradorSqlDAO.instance == null)AdministradorSqlDAO.instance =  new AdministradorSqlDAO();
        return AdministradorSqlDAO.instance;
    }
    
}
