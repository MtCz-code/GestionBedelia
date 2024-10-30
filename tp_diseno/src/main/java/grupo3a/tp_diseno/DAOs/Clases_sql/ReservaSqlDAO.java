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
   
    @Override
    public Integer crear(ReservaPeriodica reserva) {
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
                    String queryE = "INSERT INTO reserva_periodica (id_reserva,tipo,dias_semana) VALUES (?,?,?)";
                    try(PreparedStatement stmtPer = conn.prepareStatement(queryE)){
                        stmtPer.setInt(1,idReserva);
                        stmtPer.setString(2, reserva.getTipo().toString());

                        JSONArray diasSemanaJson = new JSONArray();
                        for (DiaSemana dia : reserva.getDiasSemana()) {
                            diasSemanaJson.put(dia.name()); 
                        }
                        stmtPer.setString(3, diasSemanaJson.toString());
                        stmtPer.executeUpdate();

                    } catch(SQLException e){
                        System.out.println("Error al agregar la reserva periodica");
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
    
    @Override
    public void asociarCuatrimestre(int idReserva, int cuat1, int cuat2){
        
        
        
        String queryCuat = "INSERT INTO periodo_asignado (id_cuatrimestre,id_reserva_periodica) VALUES (?,?)";
        try(Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmtCuat = conn.prepareStatement(queryCuat)){
            stmtCuat.setInt(1, cuat1);
            stmtCuat.setInt(2, idReserva);
            stmtCuat.executeUpdate();
            if(cuat2!=0){
                String queryCuat2 = "INSERT INTO periodo_asignado (id_cuatrimestre,id_reserva_periodica) VALUES (?,?)";
                try(PreparedStatement stmtCuat2 = conn.prepareStatement(queryCuat2)){
                    stmtCuat.setInt(1, cuat2);
                    stmtCuat.setInt(2, idReserva);
                    stmtCuat2.executeUpdate();
                } catch(SQLException e){
                    System.out.println("Error al asignar el segundo periodo");
                }
            }

        }catch(SQLException e){
            System.out.println("Error al asignar el periodo a la reserva.");

        }
        
    }
    
    
}
