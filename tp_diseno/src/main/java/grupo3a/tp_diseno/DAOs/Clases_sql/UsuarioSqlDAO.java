/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.BedelDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Modelos.Administrador;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;


/**
 *
 * @author exero
 */
public class UsuarioSqlDAO implements UsuarioDAO{

//    private BedelDAO DAO = BedelSqlDAO.getInstance();

    
    public UsuarioSqlDAO() {
    }
    
     //singleton
    private static UsuarioSqlDAO instance;
    public static UsuarioSqlDAO getInstance(){
        if(UsuarioSqlDAO.instance == null)UsuarioSqlDAO.instance =  new UsuarioSqlDAO();
        return UsuarioSqlDAO.instance;
    }
    
    
    
    @Override
    public Integer crear(Usuario usuario) throws DAOException {
        String query = "INSERT INTO usuario (id_login, contrasena, nombre, apellido) VALUES (?, ?, ?, ?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getIdLogin());
            stmt.setString(2, usuario.getContraseña());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getApellido());
        
            stmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idUsuario = generatedKeys.getInt(1);
                    
                   return idUsuario;
                    
                } else {
                    System.out.println("No se pudo obtener el ID del usuario.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            throw new DAOException("Error al agregar usuario: " + e.getMessage());
        }
        
        return null;
    }

    @Override
    public boolean validarIdLogin(String idLogin) throws DAOException {
        
        String query = "SELECT id_login FROM usuario where id_login = ?;";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1,idLogin);
        
            try(ResultSet rs = stmt.executeQuery()){
                
                return rs.next();
                
            }
        } catch (SQLException e) {
            System.out.println("Error con la consulta." + e.getMessage());
            throw new DAOException("Error con la consulta." + e.getMessage());
        }
    }
    
  
    
    
    
}

