
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaMultimediosDAO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaMultimediosSqlDAO implements AulaMultimediosDAO{

    public AulaMultimediosSqlDAO() {
    }
    
    //singleton
    private static AulaMultimediosSqlDAO instance;
    public static AulaMultimediosSqlDAO getInstance(){
        if(AulaMultimediosSqlDAO.instance == null)AulaMultimediosSqlDAO.instance =  new AulaMultimediosSqlDAO();
        return AulaMultimediosSqlDAO.instance;
    }

    @Override
    public List<AulaMultimedios> getByCapacidad(Integer capacidad) throws DAOException{
            
        String query = "SELECT g.id_aula, g.tipo, g.ubicacion, g.estado, g.capacidad, g.piso, g.tipo_pizarron, g.ventiladores, g.aire_acondicionado, g.habilitado, m.televisor, m.canon, m.computadora"

                + "FROM aula_general g RIGHT JOIN aula_multimedio m ON g.id_aula = m.id_aula WHERE g.capacidad >= ?  AND g.habilitado = true";

        List<AulaMultimedios> aulas = new ArrayList<>();
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
                Boolean televisor = rs.getBoolean("televisor");
                Boolean canon = rs.getBoolean("canon");
                Boolean computadora = rs.getBoolean("computadora");
                
                AulaMultimedios aula = new AulaMultimedios(id,tipo_aula,ubicacion,estado,capacidadAula,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado,televisor,canon,computadora);
                aulas.add(aula);
            }
            return aulas;
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exceptions.DAOException("Error al buscar aulas laboratorio: " + e.getMessage());
        }
        
    }

    
}
