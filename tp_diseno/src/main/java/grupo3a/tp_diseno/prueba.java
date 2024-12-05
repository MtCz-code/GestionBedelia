
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prueba {

    public static void main(String[] args) {
        GestorBedel gestorBedel = GestorBedel.getInstance();
    
//            gestorBedel.crear(new BedelDTO("Bedelaso123","bedel_1", "bedel_1", "bedel", TurnoBedel.NOCHE, true));
            
        /*UsuarioSqlDAO dao = UsuarioSqlDAO.getInstance();
        
        try {
            if(dao.validarIdLogin("Admin")){
                System.out.println("ya existe");
            }else{
                System.out.println("no existe god");
            }
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        // PRUEBA MODIFICAR, CREAR, ELIMINAR Y BUSCAR BEDEL
        BedelDTO bedelBuscar = new BedelDTO(1, "PedroFacha123", "1234", "Pedro", "Sanchez", TurnoBedel.NOCHE, true);
        BedelDTO bedelEliminar = new BedelDTO(2, "PerrenSanti", "4321", "Santiago", "Perren", TurnoBedel.MAÑANA, true);
        BedelDTO bedel1 = new BedelDTO("bedel_prueba", "Bedel_prueba1$", "prueba", "prueba", TurnoBedel.TARDE, true);     
        BedelDTO bedel2 = new BedelDTO("bedel_prueba", "Bedel_prueba1$", "prueba", "prueba", TurnoBedel.TARDE, true);   
    
        /*
        // NO VOY A PROBAR VALIDACIONES DE FORMATO
        // crear - caso exitoso
        try {
            gestorBedel.crear(bedel1);
            System.out.println("bedel1 creado exitosamente");
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        // CREAR - deberia fallar por nombre de usuario repetido
        try {
            gestorBedel.crear(bedel2);
            System.out.println("bedel2 creado exitosamente");
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        bedel2.setIdLogin("bedel_prueba2");
        
        // ahora deberia ser exitoso
        try {
            gestorBedel.crear(bedel2);
            System.out.println("bedel2 creado exitosamente");
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }*/
        
        // MODIFICAR
        bedel1.setContrasena("Bedel_prueba2$");
        bedel1.setIdLogin("bedel_prueba1");
        bedel1.setTurno(TurnoBedel.NOCHE);
        
        try {
            gestorBedel.modificar(bedel1);
            System.out.println("bedel1 modificado exitosamente");
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex.getMessage());
        }
        
        // ELIMINAR
        try {
            gestorBedel.eliminar(bedelEliminar.getIdUsuario());
            System.out.println("bedelEliminar eliminado exitosamente");
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        
        // BUSCAR
            
        // buscar por ID
        try {
           BedelDTO bedelBuscarID = gestorBedel.buscarPorID(bedelBuscar.getIdUsuario());
            System.out.println("bedel buscado por ID: id = " + bedelBuscarID.getIdUsuario() + 
                    " - idLogin = " + bedelBuscarID.getIdLogin());
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
         // buscar por apellido
        try {
           List<BedelDTO> bedelesBuscarApellido = gestorBedel.buscar(bedelBuscar.getApellido());
            System.out.println("Bedeles buscados por Apellido ( " + bedelBuscar.getApellido() + "):");
           for(BedelDTO b : bedelesBuscarApellido){
               System.out.println("id = " + b.getIdUsuario() + 
                    " - idLogin = " + b.getIdLogin() + " - Apellido = " + b.getApellido());
           }
            
        } catch (Exceptions.DAOException | Exceptions.ValueException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        try {
            List<BedelDTO> bedelesBuscarTurno = gestorBedel.buscar(TurnoBedel.TARDE);
            System.out.println("Bedeles buscados por TURNO (TARDE):");
            for(BedelDTO b : bedelesBuscarTurno){
               System.out.println("id = " + b.getIdUsuario() + 
                    " - idLogin = " + b.getIdLogin() + " - Turno = " + b.getTurno());
           }
        } catch (Exceptions.ValueException | Exceptions.DAOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
        
 }
   
