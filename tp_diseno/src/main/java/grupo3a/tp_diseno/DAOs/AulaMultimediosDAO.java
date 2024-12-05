/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import java.util.List;

/**
 *
 * @author exero
 */
public interface AulaMultimediosDAO {
    
        List<AulaMultimedios> getByTipoYCapacidad(TipoAula tipo, Integer capacidad);

    
}
