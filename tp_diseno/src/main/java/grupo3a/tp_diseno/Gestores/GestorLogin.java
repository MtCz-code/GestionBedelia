package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Exceptions.Exceptions.BedelDeshabilitadoException;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class GestorLogin {
    
    private static GestorLogin instance;
    private Integer idUsuarioLogueado;

    public static GestorLogin getInstance() {
        if (GestorLogin.instance == null) {
            GestorLogin.instance = new GestorLogin();
        }
        return GestorLogin.instance;
    }

    private GestorLogin() {
    }

    private UsuarioDAO usuarioDAO = UsuarioSqlDAO.getInstance();
    
    private GestorBedel gestorBedel = GestorBedel.getInstance();
    
    
    public Boolean validarLogin(UsuarioDTO udto) throws DAOException, ValueException, BedelDeshabilitadoException{
        
        // SI ES BEDEL RETORNA FALSO, si es admin retorna true
        
        String idLogin = udto.getIdLogin();
        String contrasena = udto.getContrasena();
        
        
        if(usuarioDAO.validarIdLogin(idLogin)){
            Usuario u = usuarioDAO.buscarPorIdLogin(idLogin);
            
            if (BCrypt.checkpw(contrasena, u.getContrasena())){
                
                try{
                    
                    BedelDTO b = gestorBedel.buscarPorID(u.getIdUsuario()); // si no existe bedel con ese id, pasa a la clausula catch.
                    
                    
                    if(b.isHabilitado()){ 
                        
                        idUsuarioLogueado = u.getIdUsuario();
                        return false; // si existe y esta habilitado, retorna false (indica que el usuario es bedel)
                    } 
                    else {
                        
                        throw new BedelDeshabilitadoException("El usuario bedel ingresado no está habilitado"); // si existe y no esta habilitado, throwea una nueva excepcion
                    }
                    
                } catch(ValueException e){
                    
                    idUsuarioLogueado = u.getIdUsuario();
                    return true;
                }
                
            } 
            else throw new ValueException("<html>Usuario o contraseña incorrectos</html>");
        }
        else throw new ValueException("<html>Usuario o contraseña incorrectos</html>");
        
    }

    public Integer getIdUsuarioLogueado() {
        return idUsuarioLogueado;
    }
    
    public void cerrarSesion(){
        idUsuarioLogueado = null;
    }
    
    
}
