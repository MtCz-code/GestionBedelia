package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DAOs.UsuarioDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Administrador;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Exceptions;
import grupo3a.tp_diseno.Modelos.Usuario;
import static grupo3a.tp_diseno.Tp_diseno.contains;
import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;

public class GestorBedel {

    //singleton
    private static GestorBedel instance;

    public static GestorBedel getInstance() {
        if (GestorBedel.instance == null) {
            GestorBedel.instance = new GestorBedel();
        }
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

    public void crear(BedelDTO bedelDTO) throws Exceptions.ValueException {

        String nombre = bedelDTO.getNombre();
        String apellido = bedelDTO.getApellido();
        String idLogin = bedelDTO.getIdLogin();
        TurnoBedel turno = bedelDTO.getTurno();
        String contraseña = bedelDTO.getContrasena();

        // verificar el nombre
        // borrar espacios al final(si hay)
        nombre = nombre.trim();

        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(nombre).matches()) {
            throw new Exceptions.ValueException("Introduzca un nombre válido.");
        }

        // apellido
        apellido = apellido.trim();
        if (!pattern.matcher(apellido).matches()) {
            throw new Exceptions.ValueException("Introduzca un apellido válido.");
        }

        // contraseña
        if (contraseña.length() == 0) {
            throw new Exceptions.ValueException("Introduzca una contraseña.");
        }

        // o Longitud mínima de la contraseña
        int largoMin = 8;
        if (contraseña.length() < largoMin) {
            throw new Exceptions.ValueException("<html>La contraseña debe contener al menos <br>" + largoMin + " caracteres.</html>");
        }

        // o Si la contraseña debe contener signos especiales (@#$%&*)
        if (!(contraseña.contains("@") || contraseña.contains("#")
                || contraseña.contains("$") || contraseña.contains("%")
                || contraseña.contains("*"))) {
            throw new Exceptions.ValueException("<html>La contraseña debe contener <br> caracteres especiales (@#$%&*)</html>");
        }

        // o Si la contraseña debe contener al menos una letra mayúscula.
        if (!contains(contraseña, 'A', 'Z')) {
            throw new Exceptions.ValueException("<html>La contraseña debe contener <br> al menos una letra mayúscula</html>");
        }

        // o Si la contraseña debe contener al menos un dígito.
        if (!contains(contraseña, '0', '9')) {
            throw new Exceptions.ValueException("<html>La contraseña debe contener <br>al menos un dígito</html>");
        }

        // o Si la contraseña puede ser igual a una contraseña anterior del usuario.
        // TODO:
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
