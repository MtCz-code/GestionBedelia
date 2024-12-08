package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;
import grupo3a.tp_diseno.DAOs.AulaMultimediosDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaLaboratorioSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaMultimediosSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaGeneralSqlDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import java.util.ArrayList;
import java.util.List;
import grupo3a.tp_diseno.DAOs.AulaGeneralDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;

public class GestorAula {
    
    private static GestorAula gestorAulaInstance;
    
        public static GestorAula getInstance() {
        if(gestorAulaInstance == null)
            gestorAulaInstance = new GestorAula();
        
        return gestorAulaInstance;
    }
    
    private GestorAula() {
        
    }
    
    
    private final AulaGeneralDAO aulaGeneralDAO = AulaGeneralSqlDAO.getInstance();
    private final AulaLaboratorioDAO aulaLaboratorioDAO = AulaLaboratorioSqlDAO.getInstance();
    private final AulaMultimediosDAO aulaMultimediosDAO = AulaMultimediosSqlDAO.getInstance();
    
    
    public DisponibilidadDTO obtenerDisponibilidadAulas(ReservaDTO reserva, TipoAula tipoAula, int capacidad) throws DAOException{
        List<AulaDTO> aulas = new ArrayList();
        DisponibilidadDTO d = new DisponibilidadDTO(aulas, false);
        
        
        Object listaAulas;
       
        if(tipoAula == TipoAula.GENERAL){
            listaAulas = aulaGeneralDAO.getByCapacidad(capacidad);
       } else if(tipoAula == TipoAula.LABORATORIO){
           listaAulas = aulaLaboratorioDAO.getByCapacidad(capacidad);
       } else if(tipoAula == TipoAula.MULTIMEDIOS){
           listaAulas = aulaMultimediosDAO.getByCapacidad(capacidad);
       }
       
        
        return null;
    }
    
    private AulaDTO convertirADTO(AulaGeneral a){
        int idAula = a.getIdAula();
        
        return null;
    }
}
