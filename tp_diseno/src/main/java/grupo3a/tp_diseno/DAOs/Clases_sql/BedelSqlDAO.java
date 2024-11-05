/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.BedelDAO;

/**
 *
 * @author exero
 */
public class BedelSqlDAO implements BedelDAO{

    public BedelSqlDAO() {
    }
    
    //singleton
    private static BedelSqlDAO instance;
    public static BedelSqlDAO getInstance(){
        if(BedelSqlDAO.instance == null)BedelSqlDAO.instance =  new BedelSqlDAO();
        return BedelSqlDAO.instance;
    }
    
}
