/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import grupo3a.tp_diseno.database.DataBaseConnection;


/**
 *
 * @author exero
 */
public class UsuarioSqlDAO implements UsuarioDAO{
    
    
    @Override
    public void agregarUsuario(Usuario usuario){
        String query = "INSERT INTO usuario (contrasena, nombre, apellido) VALUES (?, ?, ?)";
    
 
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getContraseña());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
        
            stmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
    }
    
}

