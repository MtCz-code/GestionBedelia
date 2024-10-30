
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
     
     
     
    public boolean validarDias(ArrayList<DetalleReservaDTO> diasReserva) {
        // Validar que no haya días duplicados en la reserva
        Set<DetalleReservaDTO> diasUnicos = new HashSet<>(diasReserva);
        return diasUnicos.size() == diasReserva.size();
    }
    
    public Reserva validarDatosReserva(ReservaDTO reservaDTO) {
        try {
            // Validar datos como nombre de docente, asignatura, etc.
            if (!validarDatos(reservaDTO)) {
                System.out.println("Error en los datos de la reserva");
                return null;
            }
            
            // Crear la reserva si los datos son válidos
            Reserva reserva = this.crearReserva(reservaDTO);
            
            try {
                reservaDAO.agregarReserva(reserva); // Guardar en la base de datos
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            
            
            return reserva;
        } catch (Exception e) {
            System.out.println("Error al validar datos de la reserva: " + e.getMessage());
            return null;
        }
    }

    private boolean validarDatos(ReservaDTO reservaDTO) {
        // Implementación de la validación específica de los datos de la reserva
        return reservaDTO.getNombreDocente() != null && !reservaDTO.getNombreDocente().isEmpty()
                && reservaDTO.getNombreCatedra() != null && !reservaDTO.getNombreCatedra().isEmpty();
    }

    private Reserva crearReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva(reservaDTO.);
       
        return reserva;
    }
    
    public void aulaSeleccionada(ReservaDTO reservaDTO, ArrayList<DetalleReservaDTO> detallesReservaDTO, AulaDTO aulaDTO) {
        // Obtener el aula seleccionada y asociarla a la reserva
        Reserva reserva = new Reserva();
  
        reservaDAO.agregarReserva(reserva);
        
         ArrayList<DetalleReserva> detallesReserva = new ArrayList<>(detallesReservaDTO.size());
        for(DetalleReservaDTO i : detallesReservaDTO){
            
            DetalleReserva detalleReserva = new DetalleReserva();
            
            detalleReservaDAO.crear(detalleReserva);
        }
        
    }
    
    
}
