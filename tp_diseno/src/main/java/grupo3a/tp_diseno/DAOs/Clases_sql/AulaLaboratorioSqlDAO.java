
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AulaLaboratorioSqlDAO implements AulaLaboratorioDAO{

    public AulaLaboratorioSqlDAO() {
    }
    
    //singleton
    private static AulaLaboratorioSqlDAO instance;
    public static AulaLaboratorioSqlDAO getInstance(){
        if(AulaLaboratorioSqlDAO.instance == null)AulaLaboratorioSqlDAO.instance =  new AulaLaboratorioSqlDAO();
        return AulaLaboratorioSqlDAO.instance;
    }

    @Override
    public List<AulaLaboratorio> getByCapacidad(Integer capacidad) throws DAOException{

        String query = "SELECT g.id_aula, g.tipo, g.ubicacion, g.estado, g.capacidad, g.piso, g.tipo_pizarron, g.ventiladores, g.aire_acondicionado, g.habilitado, l.cantidad_pc"

                + " FROM aula_general g RIGHT JOIN aula_laboratorio l ON g.id_aula = l.id_aula WHERE g.capacidad >= ?  AND g.habilitado = true";

        List<AulaLaboratorio> aulas = new ArrayList<>();
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
                Integer cantidadPcs = rs.getInt("cantidad_pc");
                
                AulaLaboratorio aula = new AulaLaboratorio(id,tipo_aula,ubicacion,estado,capacidadAula,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado,cantidadPcs);
                aulas.add(aula);
            }
            return aulas;
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exceptions.DAOException("Error al buscar aulas laboratorio: " + e.getMessage());
        }        
    }
        

}
    
