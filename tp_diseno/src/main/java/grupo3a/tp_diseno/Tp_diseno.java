/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.ReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Interfaces.RegistrarAulaEsporadicaDias;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Modelos.Usuario;
import java.time.LocalDateTime;
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
      
      
      ReservaDTO reservaDTO = new ReservaDTO(0, "Carlos", 6, "Alcaraz", "a@a.com", 4, "Algoritmos", LocalDateTime.now(), 1, null, null, true, 0, 0);
      
      gestorReserva.aulaSeleccionada(reservaDTO, null, null);
    }
}
