/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaEsporadicaDAO;
import grupo3a.tp_diseno.Modelos.ReservaEsporadica;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author exero
 */
public class ReservaEsporadicaSqlDAO implements ReservaEsporadicaDAO{
    //singleton
    private static ReservaEsporadicaSqlDAO instance;
    public static ReservaEsporadicaSqlDAO getInstance(){
        if(ReservaEsporadicaSqlDAO.instance == null)ReservaEsporadicaSqlDAO.instance =  new ReservaEsporadicaSqlDAO();
        return ReservaEsporadicaSqlDAO.instance;
    }

    
    @Override
    public Integer crear(ReservaEsporadica reserva) {
        String query = "INSERT INTO reserva (id_docente, nombre_docente, apellido_docente, email_docente, id_catedra, nombre_catedra, fecha_registro, id_bedel) VALUES (?, ?, ?,?,?,?,?,?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            
            
            stmt.setInt(1, reserva.getIdDocente());
            stmt.setString(2, reserva.getNombreDocente());
            stmt.setString(3, reserva.getApellidoDocente());
            stmt.setString(4, reserva.getEmailDocente());
            stmt.setInt(5, reserva.getIdCatedra());
            stmt.setString(6, reserva.getNombreCatedra());
            Timestamp timestamp = Timestamp.valueOf(reserva.getFechaRegistro());
            stmt.setTimestamp(7, timestamp);
            stmt.setInt(8, reserva.getIdBedel());
            
        
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idReserva = generatedKeys.getInt(1);
                    String queryE = "INSERT INTO reserva_esporadica (id_reserva) VALUES (?)";
                    try(PreparedStatement stmtEsp = conn.prepareStatement(queryE)){
                        stmtEsp.setInt(1,idReserva);
                        stmtEsp.executeUpdate();
                        System.out.println("Reserva insertada exitosamente.");
                    } catch(SQLException e){
                        System.out.println("Error al agregar la reserva esporadica");
                    }
                    
                return idReserva;
                } else {
                    System.out.println("No se pudo obtener el ID de la reserva.");
                }
            }
        
            
            
            
            
        } catch (SQLException e) {
            System.out.println("Error al agregar la reserva: " + e.getMessage());
            return 0;
        }    
        return null;
    }
}
