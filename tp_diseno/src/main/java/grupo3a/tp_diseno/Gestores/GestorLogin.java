package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;

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
    
    
    public Boolean validarLogin(UsuarioDTO usuarioDTO) throws DAOException{
        
        /*try{
            
        }catch(){
            
        }*/
        
        
        
        
        return true;
    }
    
    
}
