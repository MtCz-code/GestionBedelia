/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.Cuatrimestre;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author exero
 */
public interface CuatrimestreDAO {
    public Cuatrimestre buscarPorId(int id);
    public List<Cuatrimestre> getCuatrimestresActuales() throws DAOException;
    public List<Year> recuperarAñosCuatrimestres() throws DAOException;
    public List<Cuatrimestre> recuperarCuatrimestresPorAño(Year año) throws DAOException;
}
