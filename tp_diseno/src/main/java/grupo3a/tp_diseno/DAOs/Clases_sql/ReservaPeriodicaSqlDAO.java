/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.DAOs.ReservaPeriodicaDAO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.ReservaPeriodica;
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
public class ReservaPeriodicaSqlDAO extends ReservaSqlDAO implements ReservaPeriodicaDAO{

    private ReservaDAO DAO = ReservaSqlDAO.getInstance();

    public ReservaPeriodicaSqlDAO() {
    }
    
    //singleton
    private static ReservaPeriodicaSqlDAO instance;
    public static ReservaPeriodicaSqlDAO getInstance(){
        if(ReservaPeriodicaSqlDAO.instance == null)ReservaPeriodicaSqlDAO.instance =  new ReservaPeriodicaSqlDAO();
        return ReservaPeriodicaSqlDAO.instance;
    }
    
    @Override
    public Integer crear(ReservaPeriodica reserva) throws DAOException {
        
    String query = "INSERT INTO reserva_periodica (id_reserva,tipo,dias_semana) VALUES (?,?,?)";
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            
            try{
                reserva.setIdReserva(super.crear(reserva, conn));
                


                stmt.setInt(1,reserva.getIdReserva());
                stmt.setString(2, reserva.getTipo().toString());

                JSONArray diasSemanaJson = new JSONArray();
                for (DiaSemana dia : reserva.getDiasSemana()) {
                    diasSemanaJson.put(dia.name()); 
                }
                stmt.setObject(3, diasSemanaJson.toString(), java.sql.Types.OTHER);                        

                stmt.executeUpdate();

                conn.commit();
                System.out.println("Reserva insertada exitosamente.");

                return reserva.getIdReserva();
            }catch(DAOException e){
                conn.rollback();
                throw new DAOException("Error al crear la reserva periodica"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar la reserva periodica: " + e.getMessage());
            throw new DAOException("Error al agregar la reserva periodica: " + e.getMessage());
        }    
    }
    
    @Override
    public void asociarCuatrimestre(int idReserva, int cuat1, int cuat2)  throws DAOException{
        
        
        
        String queryCuat = "INSERT INTO periodo_asignado (id_cuatrimestre,id_reserva_periodica) VALUES (?,?)";
        try(Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmtCuat = conn.prepareStatement(queryCuat)){
            stmtCuat.setInt(1, cuat1);
            stmtCuat.setInt(2, idReserva);
            stmtCuat.executeUpdate();
            System.out.println("Periodo 1 asignado con exito.");
            if(cuat2!=0){
                String queryCuat2 = "INSERT INTO periodo_asignado (id_cuatrimestre,id_reserva_periodica) VALUES (?,?)";
                try(PreparedStatement stmtCuat2 = conn.prepareStatement(queryCuat2)){
                    stmtCuat2.setInt(1, cuat2);
                    stmtCuat2.setInt(2, idReserva);
                    stmtCuat2.executeUpdate();
                    System.out.println("Periodo 2 asignado con exito.");
                } catch(SQLException e){
                    System.out.println("Error al asignar el segundo periodo: " + e.getMessage());
                    throw new DAOException("error no se pudo asignar el segundo periodo: " + e.getMessage());
                }
            }

        }catch(SQLException e){
            System.out.println("Error al asignar el periodo a la reserva: " + e.getMessage());
            throw new DAOException("Error al asignar el periodo a la reserva: " + e.getMessage());

        }
        
    }
    
    @Override
    public void asociarCuatrimestre(int idReserva, int idCuatrimestre)  throws DAOException{
        String queryCuat = "INSERT INTO periodo_asignado (id_cuatrimestre,id_reserva_periodica) VALUES (?,?)";
        try(Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmtCuat = conn.prepareStatement(queryCuat)){
            stmtCuat.setInt(1, idCuatrimestre);
            stmtCuat.setInt(2, idReserva);
            stmtCuat.executeUpdate();
            System.out.println("Periodo asignado con exito.");
        }catch(SQLException e){
            System.out.println("Error al asignar el periodo a la reserva: " + e.getMessage());
            throw new DAOException("Error al asignar el periodo a la reserva: " + e.getMessage());
        }
    }
    
    
}
