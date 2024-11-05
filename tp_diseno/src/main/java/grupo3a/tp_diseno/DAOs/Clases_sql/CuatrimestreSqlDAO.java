/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.CuatrimestreDAO;
import grupo3a.tp_diseno.Modelos.Cuatrimestre;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author exero
 */
public class CuatrimestreSqlDAO implements CuatrimestreDAO{

    public CuatrimestreSqlDAO() {
    }
    
    //singleton
    private static CuatrimestreSqlDAO instance;
    public static CuatrimestreSqlDAO getInstance(){
        if(CuatrimestreSqlDAO.instance == null)CuatrimestreSqlDAO.instance =  new CuatrimestreSqlDAO();
        return CuatrimestreSqlDAO.instance;
    }
    
    @Override
    public ArrayList listar(){
        String query = "SELECT id_cuatrimestre, fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre FROM cuatrimestre";
        ArrayList<Cuatrimestre> cuatrimestres = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                int id = rs.getInt("id_cuatrimestre");
                Date fechaIni = rs.getDate("fecha_inicio_cuatrimesttre");
                Date fechaF = rs.getDate("fecha_fin_cuatrimesttre");
                
                LocalDate fechaInicio = fechaIni.toLocalDate();
                LocalDate fechaFin = fechaF.toLocalDate();
                
                Cuatrimestre cuat = new Cuatrimestre(id,fechaInicio,fechaFin);
                cuatrimestres.add(cuat);
            }            
            
        } catch (SQLException ex) {
            System.out.println("Error al listar los cuatrimestres. Se devolvera lista vacia.");
        }
        
        return cuatrimestres;
    }
}
