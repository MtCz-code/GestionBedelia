
package grupo3a.tp_diseno.Gestores;


import java.util.*;
import grupo3a.tp_diseno.Modelos.ReservaEsporadica;
import grupo3a.tp_diseno.Modelos.ReservaPeriodica;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;


import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;


import grupo3a.tp_diseno.DAOs.ReservaEsporadicaDAO;
import grupo3a.tp_diseno.DAOs.ReservaPeriodicaDAO;
import grupo3a.tp_diseno.DAOs.AulaGeneralDAO;


import grupo3a.tp_diseno.DAOs.Clases_sql.ReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaGeneralSqlDAO;

public class GestorReserva {

     private ReservaEsporadicaDAO reservaEsporadicaDAO = new ReservaEsporadicaSqlDAO();
     private ReservaPeriodicaDAO reservaPeriodicaDAO = new ReservaPeriodicaSqlDAO();
     private AulaGeneralDAO aulaGeneralDAO = new AulaGeneralSqlDAO();
     

    public boolean validarDias(List<DetalleReservaDTO> diasReserva) {
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
            Reserva reserva = crearReserva(reservaDTO);
            reservaDAO.agregarReserva(reserva); // Guardar en la base de datos
            return reserva;
        } catch (Exception e) {
            System.out.println("Error al validar datos de la reserva: " + e.getMessage());
            return null;
        }
    }

    private boolean validarDatos(ReservaDTO reservaDTO) {
        // Implementación de la validación específica de los datos de la reserva
        return reservaDTO.getDocente() != null && !reservaDTO.getDocente().isEmpty()
                && reservaDTO.getAsignatura() != null && !reservaDTO.getAsignatura().isEmpty();
    }

    private Reserva crearReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        
        // Setear datos en la reserva
        reserva.setDocente(reservaDTO.getDocente());
        reserva.setAsignatura(reservaDTO.getAsignatura());
        reserva.setCapacidad(reservaDTO.getCapacidad());
        reserva.setFecha(reservaDTO.getFecha());
        
        return reserva;
    }
    
    public Reserva aulaSeleccionada(int idAula) {
        // Obtener el aula seleccionada y asociarla a la reserva
        AulaGeneral aula = AulaDAO.buscarAulaPorId(idAula);
        if (aula != null) {
            Reserva reserva = new Reserva();
            reserva.setAula(aula);
            reservaDAO.agregarReserva(reserva);
            return reserva;
        }
        return null;
    }
    
    
}
    
    
}
