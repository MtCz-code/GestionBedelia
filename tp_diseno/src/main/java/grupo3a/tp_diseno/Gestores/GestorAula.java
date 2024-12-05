package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.AulaDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaSqlDAO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import java.util.List;

public class GestorAula {
    
    private static GestorAula gestorAulaInstance;
    
        public static GestorAula getInstance() {
        if(gestorAulaInstance == null)
            gestorAulaInstance = new GestorAula();
        
        return gestorAulaInstance;
    }
    
    private GestorAula() {
        
    }
    
    
    private final AulaDAO aulaDAO = AulaSqlDAO.getInstance();
    
    
    public DisponibilidadDTO obtenerDisponibilidadAulas(ReservaDTO reserva){
        
        
        
       // List<AulaGeneral> aulasElegibles = aulaDAO.GetByTipoYCapacidad(reserva.getTipo(), reserva.getCantidadAlumnos());
        
        return null;
    }
}
