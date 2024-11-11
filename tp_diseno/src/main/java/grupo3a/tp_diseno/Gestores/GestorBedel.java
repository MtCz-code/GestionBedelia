
package grupo3a.tp_diseno.Gestores;
import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Administrador;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class GestorBedel {
    //singleton
    private static GestorBedel instance;
    public static GestorBedel getInstance(){
        if(GestorBedel.instance == null)GestorBedel.instance =  new GestorBedel();
        return GestorBedel.instance;
    }

    public GestorBedel() {
    }
    /*
    BCrypt.gensalt(): Genera un "sal" aleatorio, que se añade a la contraseña antes de hashearla. Esto previene ataques de diccionario y hace que el hash sea único incluso para contraseñas iguales.
    BCrypt.hashpw(password, BCrypt.gensalt()): Aplica el algoritmo bcrypt a la contraseña junto con el "sal".
    BCrypt.checkpw(password, hashedPassword): Compara la contraseña proporcionada con el hash almacenado.
    */
    private UsuarioDAO DAO = UsuarioSqlDAO.getInstance();

    public void crear(BedelDTO bedelDTO){
       
        Bedel bedel = new Bedel(bedelDTO.getIdLogin(), BCrypt.hashpw(bedelDTO.getContrasena(), BCrypt.gensalt()), bedelDTO.getNombre(), bedelDTO.getApellido(), bedelDTO.getTurno(), bedelDTO.isHabilitado());
        DAO.crear(bedel);
        
    }
    
//    public void registrarBedel(bedelDTO usuario) {
//        Bedel bedel = new Bedel(usuario.getContrasena(), 
//                usuario.getNombre(), 
//                usuario.getApellido(), 
//                usuario.getTurno(), 
//                true);
    
    
    
    
    
    
    
    
}
