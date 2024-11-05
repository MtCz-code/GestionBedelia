/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
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
    
    
    @Override
    public void crear(Usuario usuario){
        String query = "INSERT INTO usuario (contrasena, nombre, apellido) VALUES (?, ?, ?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getContraseña());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
        
            stmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idBedel = generatedKeys.getInt(1);
                    String queryB = "INSERT INTO bedel (id_bedel,turno,habilitado) VALUES (?,?,?)";
                    try(PreparedStatement stmtBed = conn.prepareStatement(queryB)){
                        stmtBed.setInt(1, idBedel);
                        stmtBed.setString(2, usuario.getTurno());
                        stmtBed.setBoolean(3, usuario.getHabilitado());
                       
                        System.out.println("Bedel ingresado con exito.");
                    } catch(SQLException e){
                        System.out.println("Error al agregar el bedel: "+ e.getMessage());
                    } 
                } else {
                    System.out.println("No se pudo obtener el ID del usuario.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
        
        
        
    }
    
}

