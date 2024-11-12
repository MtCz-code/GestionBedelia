/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Modelos.Exceptions;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabic
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorBedel gestorBedel = GestorBedel.getInstance();
    
//            gestorBedel.crear(new BedelDTO("Bedelaso123","bedel_1", "bedel_1", "bedel", TurnoBedel.NOCHE, true));
            
        UsuarioSqlDAO dao = UsuarioSqlDAO.getInstance();
        
        try {
            if(dao.validarIdLogin("Admin")){
                System.out.println("ya existe");
            }else{
                System.out.println("no existe god");
            }
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
