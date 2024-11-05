/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;

/**
 *
 * @author exero
 */
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
