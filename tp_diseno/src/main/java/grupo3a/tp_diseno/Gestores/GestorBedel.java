package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.BedelDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.BedelSqlDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
//import static grupo3a.tp_diseno.Tp_diseno.contains;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static javax.management.Query.value;
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

    private BedelDAO DAO = BedelSqlDAO.getInstance();

    public void crear(BedelDTO bedelDTO) throws Exceptions.ValueException {

        String nombre = bedelDTO.getNombre();
        String apellido = bedelDTO.getApellido();
        String idLogin = bedelDTO.getIdLogin();
        TurnoBedel turno = bedelDTO.getTurno();
        String contraseña = bedelDTO.getContrasena();

        idLogin = idLogin.trim();

        try {
            if (DAO.validarIdLogin(idLogin)) {
                throw new ValueException("<html>Nombre de usuario en uso, <br>introduzca uno diferente.</html>");
            }
        } catch (DAOException e) {
            throw new ValueException("Error con la consulta." + e.getMessage());
        }

        String patronIdLogin = "^[a-zA-Z0-9_]+$";

        Pattern patternIdLogin = Pattern.compile(patronIdLogin);
        if (!patternIdLogin.matcher(idLogin).matches()) {
            throw new ValueException("<html>Introduzca un nombre de usuario válido. Se<br>permiten letras, números y _, sin espacios.</html>");
        }

        nombre = nombre.trim();

        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(nombre).matches()) {
            throw new ValueException("Introduzca un nombre válido.");
        }

        // apellido
        apellido = apellido.trim();
        if (!pattern.matcher(apellido).matches()) {
            throw new ValueException("Introduzca un apellido válido.");
        }

        // contraseña
        if (contraseña.length() == 0) {
            throw new ValueException("Introduzca una contraseña.");
        }

        // o Longitud mínima de la contraseña
        int largoMin = 8;
        if (contraseña.length() < largoMin) {
            throw new ValueException("<html>La contraseña debe contener al menos <br>" + largoMin + " caracteres.</html>");
        }

        // o Si la contraseña debe contener signos especiales (@#$%&*)
        if (!(contraseña.contains("@") || contraseña.contains("#")
                || contraseña.contains("$") || contraseña.contains("%")
                || contraseña.contains("*"))) {
            throw new ValueException("<html>La contraseña debe contener <br> caracteres especiales (@#$%&*)</html>");
        }

        // o Si la contraseña debe contener al menos una letra mayúscula.
        if (!contains(contraseña, 'A', 'Z')) {
            throw new ValueException("<html>La contraseña debe contener <br> al menos una letra mayúscula</html>");
        }

        // o Si la contraseña debe contener al menos un dígito.
        if (!contains(contraseña, '0', '9')) {
            throw new ValueException("<html>La contraseña debe contener <br>al menos un dígito</html>");
        }

        // TODO:
        Bedel bedel = new Bedel(idLogin, BCrypt.hashpw(contraseña, BCrypt.gensalt()), nombre, apellido, turno, true);

        try {
            DAO.crear(bedel);
        } catch (Exceptions.DAOException ex) {
            throw new ValueException("Ocurrio un error interno al intentar guardar");
        }

    }

    public List<BedelDTO> buscarBedel(String datoCriterio) throws Exceptions.ValueException, DAOException {
        List<BedelDTO> bedeles = new ArrayList<>();
        List<Bedel> bedelesAux = new ArrayList<>();

        if(datoCriterio instanceof String){
                    String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        String apellido=(String) datoCriterio;
        
        apellido = apellido.trim();
            if (!pattern.matcher(apellido).matches()) {
                throw new ValueException("Introduzca un apellido válido.");
            }
        }
        bedelesAux = DAO.buscarBedel(datoCriterio);
        
        for(Bedel bedel : bedelesAux){
            BedelDTO BedelDTOaux = new BedelDTO(bedel.getIdUsuario(), bedel.getNombre(), bedel.getApellido(), bedel.getTurno(), bedel.isHabilitado());
            bedeles.add(BedelDTOaux);
        }
        return bedeles;
    }
             
    
    public List<BedelDTO> buscarBedel(TurnoBedel datoCriterio) throws Exceptions.ValueException, DAOException {
        
        List<BedelDTO> bedeles = new ArrayList<>();
        List<Bedel> bedelesAux = new ArrayList<>();
        
       bedelesAux = DAO.buscarBedel(datoCriterio);
        
        for(Bedel bedel : bedelesAux){
            BedelDTO BedelDTOaux = new BedelDTO(bedel.getIdUsuario(), bedel.getNombre(), bedel.getApellido(), bedel.getTurno(), bedel.isHabilitado());
            bedeles.add(BedelDTOaux);
        }
        return bedeles;
    }
    
    public List<BedelDTO> buscarBedel(Object value) throws Exceptions.ValueException {

        if (value instanceof String) {
            String regex = "([a-zA-Z])+";
            Pattern pattern = Pattern.compile(regex);
            String apellido = (String) value;

            apellido = apellido.trim();
            if (!pattern.matcher(apellido).matches()) {
                throw new ValueException("Introduzca un apellido válido.");
            }

        }
        return null;
    }
    
    // utilidades
    public static boolean contains(String s, char a, char b) {
        for (int i = a; i <= b; i++) {
            char e = (char) i;
            if (s.contains(String.valueOf(e))) {
                return true;
            }
        }
        return false;
    }
}
