/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.BedelDAO;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Exceptions.DAOException;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author exero
 */
public class BedelSqlDAO implements BedelDAO {

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

}
