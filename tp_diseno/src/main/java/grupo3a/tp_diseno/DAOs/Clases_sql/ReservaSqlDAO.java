/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Modelos.ReservaEsporadica;
import grupo3a.tp_diseno.Modelos.ReservaPeriodica;
import grupo3a.tp_diseno.Modelos.Usuario;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.json.JSONArray;


/**
 *
 * @author exero
 */
public class ReservaSqlDAO implements ReservaDAO{

    public ReservaSqlDAO() {
    }
   
    //singleton
    private static ReservaSqlDAO instance;
    public static ReservaSqlDAO getInstance(){
        if(ReservaSqlDAO.instance == null)ReservaSqlDAO.instance =  new ReservaSqlDAO();
        return ReservaSqlDAO.instance;
    }

    @Override
    public Integer crear(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
