/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Modelos.ReservaPeriodica;

/**
 *
 * @author exero
 */
public interface ReservaPeriodicaDAO {
    
    Integer crear(ReservaPeriodica reserva);
    void asociarCuatrimestre(int idReserva, int cuat1, int cuat2);
    void asociarCuatrimestre(int idReserva, int cuat);
}
