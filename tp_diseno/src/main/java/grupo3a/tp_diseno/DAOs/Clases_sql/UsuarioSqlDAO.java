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

    private BedelDAO DAO = BedelSqlDAO.getInstance();

    
    public UsuarioSqlDAO() {
    }
    
     //singleton
    private static UsuarioSqlDAO instance;
    public static UsuarioSqlDAO getInstance(){
        if(UsuarioSqlDAO.instance == null)UsuarioSqlDAO.instance =  new UsuarioSqlDAO();
        return UsuarioSqlDAO.instance;
    }
    
    
    
    @Override
    public void crear(Bedel bedel) throws DAOException {
        String query = "INSERT INTO usuario (id_login, contrasena, nombre, apellido) VALUES (?, ?, ?, ?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, bedel.getIdLogin());
            stmt.setString(2, bedel.getContraseña());
            stmt.setString(3, bedel.getNombre());
            stmt.setString(4, bedel.getApellido());
        
            stmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idBedel = generatedKeys.getInt(1);
                    
                    bedel.setIdUsuario(idBedel);
                    
                    DAO.crear(bedel);
                    
                } else {
                    System.out.println("No se pudo obtener el ID del usuario.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            throw new DAOException("Error al agregar usuario: " + e.getMessage());
        }
        
    }
    
    @Override //No es necesario codificar crear administrador, no tiene un gestor para eso. 
    public void crear(Administrador admin) throws DAOException {
        String query = "INSERT INTO usuario (contrasena, nombre, apellido) VALUES (?, ?, ?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, admin.getContraseña());
            stmt.setString(2, admin.getNombre());
            stmt.setString(3, admin.getApellido());
        
            stmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idAdmin = generatedKeys.getInt(1);
                    String queryB = "INSERT INTO administrador (id_usuario) VALUES (?)";
                    try(PreparedStatement stmtBed = conn.prepareStatement(queryB)){
                        stmtBed.setInt(1, idAdmin);
                        stmtBed.executeUpdate();
                       
                            System.out.println("Administrador ingresado con exito.");
                    } catch(SQLException e){
                        System.out.println("Error al agregar el administrador: "+ e.getMessage());
                    } 
                } else {
                    System.out.println("No se pudo obtener el ID del usuario.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            throw new DAOException("Error al agregar usuario: " + e.getMessage());
        }
        
        
    }
    
    
    
    
}

