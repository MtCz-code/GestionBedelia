
package grupo3a.tp_diseno.Gestores;


import java.util.*;
import grupo3a.tp_diseno.Modelos.*;
import grupo3a.tp_diseno.DAOs.*;
import grupo3a.tp_diseno.DTOs.*;
import grupo3a.tp_diseno.DAOs.Clases_sql.*;
import grupo3a.tp_diseno.Gestores.*;


public class GestorReserva {

     private final AulaDAO aulaDAO = new AulaSqlDAO();
     private final ReservaDAO reservaDAO = new ReservaSqlDAO();
     private final DetalleReservaDAO detalleReservaDAO = new DetalleReservaSqlDAO();
     
     
    // solo se usa para reserva esporadica
    public boolean validarDias(ArrayList<DetalleReservaDTO> diasReserva) {
       return true;
    }
    
    
    // NO ES NECESARIO VALIDAR NADA EN EL GESTOR, SE PUEDEN VALIDAR EN LA INTERFAZ
    public Reserva validarDatosReserva(ReservaDTO reservaDTO) {
        
        return null;
    }

    
    public void aulaSeleccionada(ReservaDTO reservaDTO, ArrayList<DetalleReservaDTO> detallesReservaDTO, AulaDTO aulaDTO) {
        // Obtener el aula seleccionada y asociarla a la reserva
        
        
        Reserva reserva = new Reserva(reservaDTO.getNombreCatedra(), reservaDTO.getIdDocente(),
                reservaDTO.getApellidoDocente(), reservaDTO.getEmailDocente(), reservaDTO.getIdCatedra(), 
                reservaDTO.getNombreCatedra(), reservaDTO.getFechaRegistro());
        
        if(reservaDTO.isEsEsporadica()){
            reserva.setIdReserva(reservaDAO.crear((ReservaEsporadica)reserva));
        }
        else {
            ReservaPeriodica reservaAux = (ReservaPeriodica)reserva;
            reservaAux.setTipo(reservaDTO.getTipo());
            reservaAux.getDiasSemana().addAll(reservaDTO.getDiasSemana());
            
            reserva.setIdReserva(reservaDAO.crear(reservaAux));
        }
        
        
        
        for(DetalleReservaDTO i : detallesReservaDTO){
            
            DetalleReserva detalleReserva = new DetalleReserva(reserva.getIdReserva(), 
                    i.getHorarioInicio(), i.getCantModulos(), i.getFecha(), i.getDiaReserva(), aulaDTO.getIdAula());
            
            detalleReservaDAO.crear(detalleReserva);
        }
        
        reservaDAO.asociarCuatrimestre(reserva.getIdReserva(), reservaDTO.getIdCuatrimestre1(), reservaDTO.getIdCuatrimestre2());
        
    }
    
    
}
