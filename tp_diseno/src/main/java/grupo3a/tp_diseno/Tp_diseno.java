/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.ReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Interfaces.RegistrarAulaEsporadicaDias;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Modelos.Usuario;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author gabic
 */
public class Tp_diseno {

    public static void main(String[] args) {
        
        
      /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistrarAulaEsporadicaDias reg = new RegistrarAulaEsporadicaDias();
                
                reg.setVisible(true);

            }
        });*/
        
      final GestorReserva gestorReserva = new GestorReserva();
      
      TipoReservaPeriodica tipor = TipoReservaPeriodica.ANUAL;
      ArrayList<DiaSemana> dias = new ArrayList<>();
      
      dias.add(DiaSemana.MIERCOLES);
      dias.add(DiaSemana.MARTES);
      
      ReservaDTO reservaDTO = new ReservaDTO(0, "Carlos", 6, "Alcaraz", "a@a.com", 4, "Algoritmos", LocalDateTime.now(), 1, tipor, dias, false, 5, 6);
      
      ArrayList<DetalleReservaDTO> detalles = new ArrayList<>();
      
      LocalTime horaEspecifica = LocalTime.of(17, 0);
      Time tiempo = Time.valueOf(horaEspecifica);
      
      detalles.add(new DetalleReservaDTO(1, tiempo, 2, LocalDate.of(2024,04,07) , "Miercoles" , 0));
      
      LocalTime horaEspecifica1 = LocalTime.of(13, 0);
      Time tiempo1 = Time.valueOf(horaEspecifica1);

      detalles.add(new DetalleReservaDTO(1,tiempo1, 4, LocalDate.of(2024,11,06), "Martes", 0));
      
      AulaDTO aula = new AulaDTO(1);
      
      gestorReserva.aulaSeleccionada(reservaDTO,detalles,aula);
    
    }
}
