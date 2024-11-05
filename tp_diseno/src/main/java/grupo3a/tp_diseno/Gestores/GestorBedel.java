
package grupo3a.tp_diseno.Gestores;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;


public class GestorBedel {
    //singleton
    private static GestorBedel instance;
    public static GestorBedel getInstance(){
        if(GestorBedel.instance == null)GestorBedel.instance =  new GestorBedel();
        return GestorBedel.instance;
    }

    public void crear(UsuarioDTO usuarioDTO){
        
    }
    
    
    
    
    
}
