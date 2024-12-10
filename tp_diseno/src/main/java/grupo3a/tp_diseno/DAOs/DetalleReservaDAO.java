/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author exero
 */
public interface DetalleReservaDAO {
    
    public void crear(DetalleReserva detalleReserva, Connection conn) throws DAOException;
    public List<DetalleReserva> getByDiaYHorario(LocalDate fecha, Time horarioInicio, int cantModulos) throws DAOException;
}
