
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
    public List buscar(String datoCriterio) throws DAOException {
        String query = "SELECT B.id_usuario,U.nombre,U.apellido,B.turno,B.habilitado FROM"
                + " usuario U LEFT JOIN bedel B ON U.id_usuario=B.id_usuario WHERE apellido ILIKE ?;";
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
            throw new DAOException("Error al buscar el bedel: " + e.getMessage());
        }        
    }

    @Override
    public List buscar(TurnoBedel datoCriterio) throws DAOException {

        String query = "SELECT B.id_usuario,U.nombre,U.apellido,B.turno,B.habilitado " +
"FROM usuario U LEFT JOIN bedel B ON U.id_usuario=B.id_usuario WHERE B.turno = ?;";
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
            throw new DAOException("Error al buscar el bedel: " + e.getMessage());
        }  
    }
    
    @Override
    public void eliminar(Bedel bedel) throws DAOException {
        
        String query = "SELECT B.id_usuario,U.contrasena,U.id_login,U.nombre,U.apellido,B.turno " +
            "FROM usuario U LEFT JOIN bedel B ON U.id_usuario=B.id_usuario WHERE B.id_usuario = ?;";
        
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(query)){
            stmtBed.setInt(1, bedel.getIdUsuario());
            ResultSet rs = stmtBed.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id_usuario");
                String id_login = rs.getString("id_login");
                String contraseña = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                TurnoBedel turno = TurnoBedel.valueOf(rs.getString("turno"));
                Bedel bedelElim = new Bedel(id,id_login, contraseña,nombre,apellido,turno,false);
                
                this.modificar(bedelElim);
                
            }
            
        } catch (SQLException e) {
            throw new DAOException("Error al recuperar el bedel: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Bedel bedel) throws DAOException {
        
        String queryU = "UPDATE TABLE usuario (nombre,apellido,id_login,contrasena) VALUES(?,?,?,?);";
        String queryB = "UPDATE TABLE bedel (turno,habilitado) VALUES (?,?);";
        try(Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmtU = conn.prepareStatement(queryU);
                PreparedStatement stmtB = conn.prepareStatement(queryB)){
            conn.setAutoCommit(false);
            stmtU.setString(1, bedel.getNombre());
            stmtU.setString(2, bedel.getApellido());
            stmtU.setString(3, bedel.getIdLogin());
            stmtU.setString(4, bedel.getContrasena());
            stmtU.executeUpdate();
            
            stmtB.setString(1,bedel.getTurno().toString());
            stmtB.setBoolean(2,bedel.isHabilitado());
            stmtB.executeUpdate();
            
            conn.commit();
            
            
        }catch(SQLException e){
            throw new DAOException("Error al modificar el bedel: " + e.getMessage());
        }
        
    }

    
    
    @Override
    public Bedel buscarPorId(Integer id) throws DAOException {

        String query = "SELECT B.id_usuario,U.id_login,U.nombre,U.apellido,B.turno " +
            "FROM usuario U LEFT JOIN bedel B ON U.id_usuario=B.id_usuario WHERE B.id_usuario = ?;";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(query)){
            stmtBed.setInt(1, id);
            ResultSet rs = stmtBed.executeQuery();
            if (rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String id_login = rs.getString("id_login");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                TurnoBedel turno = TurnoBedel.valueOf(rs.getString("turno"));
                Bedel bedel = new Bedel(id_usuario,id_login,nombre,apellido,turno,false);
                
                return bedel;
                
            }
            
        } catch (SQLException e) {
            throw new DAOException("Error al recuperar el bedel: " + e.getMessage());
        }
        return null;
    }

}
