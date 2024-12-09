/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import grupo3a.tp_diseno.DAOs.AulaGeneralDAO;

/**
 *
 * @author exero
 */
public class AulaGeneralSqlDAO implements AulaGeneralDAO{

    public AulaGeneralSqlDAO() {
    }
    //singleton
    private static AulaGeneralSqlDAO instance;
    public static AulaGeneralSqlDAO getInstance(){
        if(AulaGeneralSqlDAO.instance == null)AulaGeneralSqlDAO.instance =  new AulaGeneralSqlDAO();
        return AulaGeneralSqlDAO.instance;
    }

    @Override
    public List<AulaGeneral> getByCapacidad(Integer capacidad) throws DAOException {        
        String query = "SELECT id_aula, tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado "
                + "FROM aula_general WHERE capacidad >= ?";
        List<AulaGeneral> aulas = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmtBed = conn.prepareStatement(query)){
            stmtBed.setInt(1,capacidad);
            ResultSet rs = stmtBed.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_aula");
                TipoAula tipo_aula = TipoAula.valueOf(rs.getString("tipo"));
                String ubicacion = rs.getString("ubicacion");
                Boolean estado = rs.getBoolean("estado");
                Integer capacidadAula = rs.getInt("capacidad");
                Integer piso = rs.getInt("piso");
                TipoPizarron tipo_pizarron= TipoPizarron.valueOf(rs.getString("tipo_pizarron"));
                Boolean ventiladores = rs.getBoolean("ventiladores");
                Boolean aire_acondicionado = rs.getBoolean("aire_acondicionado");
                Boolean habilitado = rs.getBoolean("habilitado");
                
                
                AulaGeneral aula = new AulaGeneral(id,tipo_aula,ubicacion,estado,capacidadAula,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado);
                aulas.add(aula);
            }
            return aulas;
            
            
        } catch (SQLException e) {
            throw new Exceptions.DAOException("Error al buscar aulas: " + e.getMessage());
        }        
    }
}
