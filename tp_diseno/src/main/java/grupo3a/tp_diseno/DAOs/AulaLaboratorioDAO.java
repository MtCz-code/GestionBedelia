/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import java.util.List;

/**
 *
 * @author exero
 */
public interface AulaLaboratorioDAO {
    
        List<AulaLaboratorio> getByCapacidad(Integer capacidad) throws DAOException;

    
}
