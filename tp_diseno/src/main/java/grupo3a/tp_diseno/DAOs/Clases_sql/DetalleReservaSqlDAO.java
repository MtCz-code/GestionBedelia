
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void crear(DetalleReserva detalleReserva) throws DAOException {
        
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
    public List<DetalleReserva> getByDiaYHorario(LocalDate fecha, Time horarioInicio, int cantModulos) throws DAOException {
    
        List<DetalleReserva> detallesConSolapamiento = new ArrayList<>();
        String query = "SELECT  id_reserva, horario_inicio, fecha, cant_modulos, dia_reserva, id_aula FROM detalle_reserva WHERE fecha = ?";
        
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)){
            
            stmt.setDate(1, Date.valueOf(fecha));
            
            ResultSet rs = stmt.executeQuery();
            Time horarioFin = new Time(horarioInicio.toLocalTime().plusMinutes(30*cantModulos).toNanoOfDay() / 1_000_000);
            while(rs.next()){
                
                Time inicioDetalles = rs.getTime("horario_inicio");
                int cantModDetalle = rs.getInt("cant_modulos");
                
                Time finalDetalle = new Time(inicioDetalles.toLocalTime().plusMinutes(cantModDetalle*30).toNanoOfDay() / 1_000_000);
                
                if(inicioDetalles.before(horarioFin) && finalDetalle.after(horarioInicio) && !finalDetalle.equals(horarioInicio)){
                    
                    
                    int idReserva = rs.getInt("id_reserva");
                    Time horaInicio = rs.getTime("horario_inicio");
                    LocalDate fechaDetalle = rs.getDate("fecha").toLocalDate();
                    int mod = rs.getInt("cant_modulos");
                    DiaSemana dias = DiaSemana.valueOf(rs.getString("dia_Reserva"));
                    int idAula = rs.getInt("id_aula");
                    
                    DetalleReserva detalle = new DetalleReserva(idReserva,horaInicio,mod,fechaDetalle,dias,idAula);
                    
                    detallesConSolapamiento.add(detalle);
                    
                }
            }
            
            
            
            System.out.println("Busqueda realizada con exito");
            for(DetalleReserva dr: detallesConSolapamiento){
                System.out.println("holaaa");
            }
            
            return detallesConSolapamiento;
            
            
            
        } catch (SQLException e) {
            System.out.println("Error al buscar solapamiento" + e.getMessage());
        }
        
      
        
        return null;
    }
}
