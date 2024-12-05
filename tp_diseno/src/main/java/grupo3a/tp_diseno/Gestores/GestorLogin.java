package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class GestorLogin {
    
    private static GestorLogin instance;

    public static GestorLogin getInstance() {
        if (GestorLogin.instance == null) {
            GestorLogin.instance = new GestorLogin();
        }
        return GestorLogin.instance;
    }

    public GestorLogin() {
    }

    private UsuarioDAO usuarioDAO = UsuarioSqlDAO.getInstance();
    
    private GestorBedel gestorBedel = GestorBedel.getInstance();
    
    
    public Boolean validarLogin(UsuarioDTO udto) throws DAOException, ValueException{
        
        // SI ES BEDEL RETORNA FALSO, si es admin retorna true
        
        String idLogin = udto.getIdLogin();
        String contrasena = udto.getContrasena();
        
        
        if(usuarioDAO.validarIdLogin(idLogin)){
            Usuario u = usuarioDAO.buscarPorIdLogin(idLogin);
            // Check that an unencrypted password matches one that has previously been hashed
            if (BCrypt.checkpw(contrasena, u.getContrasena())){
                
                if(gestorBedel.esBedel(u.getIdUsuario())){
                    return false; 
                }
                return true;
            } 
            else throw new ValueException("<html>Usuario o contraseña incorrectos</html>");
        }
        else throw new ValueException("<html>Usuario o contraseña incorrectos</html>");
        
    }
    
    
}
