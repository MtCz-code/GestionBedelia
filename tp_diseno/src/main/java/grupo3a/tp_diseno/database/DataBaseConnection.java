/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author exero
 */
public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/tp_diseno";
    private static final String USER = "postgres";
    private static final String PASSWORD = "M1gu3lc4";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}

