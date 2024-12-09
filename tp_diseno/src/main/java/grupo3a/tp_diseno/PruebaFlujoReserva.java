/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabic
 */
public class PruebaFlujoReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorReserva gestorReserva = GestorReserva.getInstance();

    List<DetalleReservaDTO> dr = Arrays.asList(
            new DetalleReservaDTO(0,
                    Time.valueOf("08:00:00"), // Horario de inicio
                    6,
                    LocalDate.of(2024, 1, 10), // Fecha de la reserva// Cantidad de módulos (1 módulo = 30 minutos)
                    DiaSemana.LUNES, // Día de la semana
                    0 // ID del aula (será determinado por disponibilidad)
            )
    );

    // nueva reserva esporadica
    ReservaDTO nuevaReserva = new ReservaDTO(0, "Exe", 103, "Sandriarda", "kuka@kuk-12.com", 1, "intro al lol",
            null, 30, 1, dr, true);

// Llamar al método para obtener las aulas disponibles
    TipoAula tipoAula = TipoAula.GENERAL; // Aulas generales
    
    
    DisponibilidadDTO disponibilidad = null;
        try {
            disponibilidad = gestorReserva.validarDatosYObtenerAulas(nuevaReserva, tipoAula);
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exceptions.NoExisteAulaException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(disponibilidad == null){
            System.out.println("disponibilidad es nulo");
            return;
        }
        if (!disponibilidad.getSolapamiento()) {
            for (Map.Entry<AulaDTO, Integer> entry : disponibilidad.getAulasDisponibles().entrySet()) {
                AulaDTO aulaDisponible = entry.getKey();

                System.out.println("Aula disponible: " + aulaDisponible.getUbicacion());
            }
        } else {
            for (Map.Entry<AulaDTO, Integer> entry : disponibilidad.getAulasDisponibles()
                    .entrySet()) {
                AulaDTO aulaDisponible = entry.getKey();
                Integer solapamiento = entry.getValue();
                System.out.println("Aula disponible con solapamiento: " + aulaDisponible.getUbicacion() + ", Solapamiento: " + solapamiento);
            }
        }

    

    }
    
}
