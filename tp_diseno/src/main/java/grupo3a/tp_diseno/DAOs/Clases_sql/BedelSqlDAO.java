
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.BedelDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BedelSqlDAO extends UsuarioSqlDAO implements BedelDAO {

    private UsuarioDAO DAO = UsuarioSqlDAO.getInstance();
    
    public BedelSqlDAO() {
    }

    //singleton
    private static BedelSqlDAO instance;

    public static BedelSqlDAO getInstance() {
        if (BedelSqlDAO.instance == null) {
            BedelSqlDAO.instance = new BedelSqlDAO();
        }
        return BedelSqlDAO.instance;
    }

    @Override
    public void crear(Bedel bedel) throws DAOException {
        
        bedel.setIdUsuario(super.crear(bedel));
        
        String queryB = "INSERT INTO bedel (id_usuario,turno,habilitado) VALUES (?,?,?)";
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(queryB)) {
            stmtBed.setInt(1, bedel.getIdUsuario());
            stmtBed.setString(2, bedel.getTurno().toString());
            stmtBed.setBoolean(3, bedel.isHabilitado());
            stmtBed.executeUpdate();

            System.out.println("Bedel ingresado con exito.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el bedel: " + e.getMessage());
            throw new DAOException("Error al agregar el bedel: " + e.getMessage());
        }

    }

    @Override
    public List buscarBedel(String datoCriterio) throws DAOException {
        String query = "SELECT id_usuario,nombre,apellido,turno,habilitado FROM bedel WHERE apellido ILIKE ?;";
        List<Bedel> bedeles = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(query)){
            stmtBed.setString(1,"%" +query+ "%");
            ResultSet rs = stmtBed.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                TurnoBedel turno = TurnoBedel.valueOf(rs.getString("turno"));
                boolean habilitado = rs.getBoolean("habilitado");
                
                Bedel bedel = new Bedel(id,nombre,apellido,turno,habilitado);
                bedeles.add(bedel);
            }
            return bedeles;
            
            
        } catch (SQLException e) {
            System.out.println("Error al buscar el bedel: "+ e.getMessage());
            throw new DAOException("Error al buscar el bedel: " + e.getMessage());
        }        
    }

    @Override
    public List buscarBedel(TurnoBedel datoCriterio) throws DAOException {
        String query = "SELECT id_usuario,nombre,apellido,turno,habilitado FROM bedel WHERE turno is ?;";
        List<Bedel> bedeles = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(query)){
            stmtBed.setString(1,query);
            ResultSet rs = stmtBed.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                TurnoBedel turno = TurnoBedel.valueOf(rs.getString("turno"));
                boolean habilitado = rs.getBoolean("habilitado");
                
                Bedel bedel = new Bedel(id,nombre,apellido,turno,habilitado);
                bedeles.add(bedel);
            }
            return bedeles;
            
            
        } catch (SQLException e) {
            System.out.println("Error al buscar el bedel: "+ e.getMessage());
            throw new DAOException("Error al buscar el bedel: " + e.getMessage());
        }  
    }

}
