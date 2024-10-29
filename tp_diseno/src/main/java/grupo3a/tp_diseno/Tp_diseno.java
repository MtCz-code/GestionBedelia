/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.Modelos.Usuario;

/**
 *
 * @author gabic
 */
public class Tp_diseno {

    public static void main(String[] args) {
        
        Usuario gabig = new Usuario("123456","GaBIG","COCKnavesio");
        
        UsuarioSqlDAO nuevoUsuario = new UsuarioSqlDAO();
        
        nuevoUsuario.agregarUsuario(gabig);
        
        
        
        
        
    }
}
