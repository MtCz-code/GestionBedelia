
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class DetalleReservaSqlDAO implements DetalleReservaDAO{

    public DetalleReservaSqlDAO() {
    }
    
    
    //singleton
    private static DetalleReservaSqlDAO instance;
    public static DetalleReservaSqlDAO getInstance(){
        if(DetalleReservaSqlDAO.instance == null)DetalleReservaSqlDAO.instance =  new DetalleReservaSqlDAO();
        return DetalleReservaSqlDAO.instance;
    }
    
    
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

    @Override
    // OBTENER TODOS LOS DETALLE RESERVA DE EL DIA ESPECIFICADO, QUE TENGAN AL MENOS UN MODULO EN EL HORARIO PASADO COMO PARAMETRO (HORARIO INNICIO * CANT MODULOS) 
    public List<DetalleReserva> getByDiaYHorario(LocalDate fecha, Time horarioInicio, int cantModulos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
