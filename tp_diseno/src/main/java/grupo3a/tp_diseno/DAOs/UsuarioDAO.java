/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Modelos.Administrador;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.Usuario;

/**
 *
 * @author gabic
 */
public interface UsuarioDAO {
    
    
    Integer crear(Bedel bedel) throws DAOException;
   
    //No es necesario codearlo
    //void crear(Administrador admin) throws DAOException;
}
