/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author exero
 */
public class DetalleReservaSqlDAO implements DetalleReservaDAO{

    @Override
    public void crear(DetalleReserva detalleReserva) {
        
        String query = "INSERT INTO detalle_reserva (id_reserva,horario_inicio,fecha,cant_modulos,dia_reserva,id_aula) VALUES (?,?,?,?,?,?);";
        
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)){
            
            
            
            stmt.setInt(1, detalleReserva.getIdReserva());
            stmt.setTime(2, detalleReserva.getHorarioInicio());
            LocalDate fecha = detalleReserva.getFecha();
            stmt.setDate(3, Date.valueOf(fecha));
            stmt.setInt(4, detalleReserva.getCantModulos());
            stmt.setString(5, detalleReserva.getDiaReserva().toString());
            stmt.setInt(6, detalleReserva.getIdAula());
            stmt.executeUpdate();
            
            System.out.println("Detalle de la reserva ingresado a la base de datos con exito.");
            
        } catch (SQLException e) {
            System.out.println("Error al agregar el detalle de la reserva: " + e.getMessage());
        }
    }
}
