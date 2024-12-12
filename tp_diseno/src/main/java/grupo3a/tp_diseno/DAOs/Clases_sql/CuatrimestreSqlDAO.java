
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.CuatrimestreDAO;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.Cuatrimestre;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.postgresql.jdbc.EscapedFunctions;


public class CuatrimestreSqlDAO implements CuatrimestreDAO{

    public CuatrimestreSqlDAO() {
    }
    
    //singleton
    private static CuatrimestreSqlDAO instance;
    public static CuatrimestreSqlDAO getInstance(){
        if(CuatrimestreSqlDAO.instance == null)CuatrimestreSqlDAO.instance =  new CuatrimestreSqlDAO();
        return CuatrimestreSqlDAO.instance;
    }
    
    
    @Override
    public Cuatrimestre buscarPorId(int id){
        
        
        return null;
    }
    
    @Override
    public List<Cuatrimestre> getCuatrimestresActuales() throws DAOException{
        String query = "SELECT id_cuatrimestre, fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre FROM cuatrimestre "+
                "WHERE EXTRACT(YEAR FROM fecha_inicio_cuatrimestre) = EXTRACT(YEAR FROM CURRENT_DATE) " +
                "OR EXTRACT(YEAR FROM fecha_fin_cuatrimestre) = EXTRACT(YEAR FROM CURRENT_DATE);";
        List<Cuatrimestre> cuatrimestres = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                int id = rs.getInt("id_cuatrimestre");
                Date fechaIni = rs.getDate("fecha_inicio_cuatrimestre");
                Date fechaF = rs.getDate("fecha_fin_cuatrimestre");
                
                LocalDate fechaInicio = fechaIni.toLocalDate();
                LocalDate fechaFin = fechaF.toLocalDate();
                
                Cuatrimestre cuat = new Cuatrimestre(id,fechaInicio,fechaFin);
                cuatrimestres.add(cuat);
            }            
            
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        }
        
        return cuatrimestres;
    }

    @Override
    public List<Year> recuperarAñosCuatrimestres() throws DAOException {
        
        String query = "SELECT id_cuatrimestre, fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre FROM cuatrimestre; ";
                
        Set<Year> anios = new HashSet<>();
        try(Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                
                Date fechaF = rs.getDate("fecha_fin_cuatrimestre");
                
                LocalDate fechaFin = fechaF.toLocalDate();
                LocalDate anioActual = LocalDate.now();
                Year anio = Year.of(fechaFin.getYear()); 
                if(fechaFin.getYear()>=anioActual.getYear()){
                    
                    anios.add(anio);
                }
            }            
            
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        }
        
        return new ArrayList<>(anios);
        


    }
    
    public List<Cuatrimestre> recuperarCuatrimestresPorAño(Year año) throws DAOException{
        String query = "SELECT id_cuatrimestre, fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre FROM cuatrimestre "+
                "WHERE EXTRACT(YEAR FROM fecha_inicio_cuatrimestre) = EXTRACT(YEAR FROM CAST(? AS DATE)) " +
                "OR EXTRACT(YEAR FROM fecha_fin_cuatrimestre) = EXTRACT(YEAR FROM CAST(? AS DATE));";
        List<Cuatrimestre> cuatrimestres = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            LocalDate anio = año.atDay(1);
            Date anioAux = Date.valueOf(anio);
            stmt.setDate(1, anioAux);
            stmt.setDate(2, anioAux);
            
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_cuatrimestre");
                Date fechaIni = rs.getDate("fecha_inicio_cuatrimestre");
                Date fechaF = rs.getDate("fecha_fin_cuatrimestre");
                
                LocalDate fechaInicio = fechaIni.toLocalDate();
                LocalDate fechaFin = fechaF.toLocalDate();
                
                Cuatrimestre cuat = new Cuatrimestre(id,fechaInicio,fechaFin);
                cuatrimestres.add(cuat);
            }            
            
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        }
        
        return cuatrimestres;
    }
}
