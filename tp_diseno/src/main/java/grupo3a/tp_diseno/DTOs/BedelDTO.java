/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;

/**
 *
 * @author exero
 */
public class BedelDTO extends UsuarioDTO{

    
    
    public BedelDTO(String idLogin, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
        super(idLogin, contrasena, nombre, apellido, turno, habilitado);
    }
    
}
