/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Modelos.Reserva;

/**
 *
 * @author exero
 */
public interface ReservaDAO {
    
    Integer crear(Reserva reserva);
    void asociarCuatrimestre(int idReserva, int cuat1, int cuat2);
    
}
