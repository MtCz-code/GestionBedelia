
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Modelos.ReservaEsporadica;
import grupo3a.tp_diseno.Modelos.ReservaPeriodica;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.json.JSONArray;

public class ReservaSqlDAO implements ReservaDAO{
    
    DetalleReservaDAO DAO = DetalleReservaSqlDAO.getInstance();
    
    
    public ReservaSqlDAO() {
    }
   
    //singleton
    private static ReservaSqlDAO instance;
    public static ReservaSqlDAO getInstance(){
        if(ReservaSqlDAO.instance == null)ReservaSqlDAO.instance =  new ReservaSqlDAO();
        return ReservaSqlDAO.instance;
    }

    @Override
    public Integer crear(Reserva reserva) throws DAOException {
        
        String query = "INSERT INTO reserva (id_docente, nombre_docente, apellido_docente, email_docente, id_catedra, nombre_catedra, fecha_registro, id_bedel) VALUES (?, ?, ?,?,?,?,NOW(),?)";

        Integer idReserva = null;

 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            //conn.setAutoCommit(false);
            
            
            stmt.setInt(1, reserva.getIdDocente());
            stmt.setString(2, reserva.getNombreDocente());
            stmt.setString(3, reserva.getApellidoDocente());
            stmt.setString(4, reserva.getEmailDocente());
            stmt.setInt(5, reserva.getIdCatedra());
            stmt.setString(6, reserva.getNombreCatedra());
            //Timestamp timestamp = Timestamp.valueOf(reserva.getFechaRegistro());
            //stmt.setTimestamp(7, timestamp);
            stmt.setInt(7, reserva.getIdBedel());
            
        
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                idReserva = generatedKeys.getInt(1);
                
                for(DetalleReserva dr : reserva.getDetallesReserva()){
                    dr.setIdReserva(idReserva);
                    DAO.crear(dr);
                }
            }
            //conn.commit();
            return idReserva;
        } catch (SQLException e) {
            System.out.println("Error al agregar la reserva: " + e.getMessage());
        }   
        
        return 0;
    }
    
}
