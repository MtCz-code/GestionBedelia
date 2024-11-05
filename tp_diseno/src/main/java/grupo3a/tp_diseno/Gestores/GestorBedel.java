
package grupo3a.tp_diseno.Gestores;
import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Modelos.Administrador;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Usuario;


public class GestorBedel {
    //singleton
    private static GestorBedel instance;
    public static GestorBedel getInstance(){
        if(GestorBedel.instance == null)GestorBedel.instance =  new GestorBedel();
        return GestorBedel.instance;
    }
    
    private UsuarioDAO DAO = UsuarioSqlDAO.getInstance();

    public void crear(UsuarioDTO usuarioDTO){
       Object u;
        
        if(usuarioDTO.getTurno() != null){ // crear BEDEL
           u = new Bedel(usuarioDTO.getApellido(), usuarioDTO.getNombre(), usuarioDTO.getContrasena(), usuarioDTO.getTurno(), usuarioDTO.isHabilitado());
           
       }
       else { // crear admin
           u = new Administrador(usuarioDTO.getApellido(), usuarioDTO.getNombre(), usuarioDTO.getContrasena());
       }
       
       DAO.crear(u);
       
    }
    
    
    
    
    
}
