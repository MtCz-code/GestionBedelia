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

        // cortar espacios
        bedelDTO.setIdLogin(bedelDTO.getIdLogin().trim());
        
        
        // validar
        try {
            validar(bedelDTO);
        } catch(ValueException e){
            throw new ValueException(e.getMessage());
        }
        
        // encriptar contraseña
        bedelDTO.setContrasena(BCrypt.hashpw(bedelDTO.getContrasena(), BCrypt.gensalt()));
        
        Bedel bedel = convertirAModelo(bedelDTO);
        //Bedel bedel = new Bedel(idLogin, BCrypt.hashpw(contraseña, BCrypt.gensalt()), nombre, apellido, turno, true);

        try {
            DAO.crear(bedel);
        } catch (Exceptions.DAOException ex) {
            throw new ValueException("Ocurrio un error interno al intentar guardar" + ex.getMessage());
        }

    }
    
    public Integer modificar(BedelDTO bedelDTO) throws Exceptions.ValueException {
        bedelDTO.setIdLogin(bedelDTO.getIdLogin().trim());
        
        try {
            validar(bedelDTO);
        } catch(ValueException e){
            throw new ValueException(e.getMessage());
        }
        
        bedelDTO.setContrasena(BCrypt.hashpw(bedelDTO.getContrasena(), BCrypt.gensalt()));

        Bedel bedel = convertirAModelo(bedelDTO);

        try {
            DAO.modificar(bedel);
        } catch (DAOException ex) {
            throw new ValueException("Ocurrio un error interno al intentar guardar" + ex.getMessage());
        }
        
        return bedel.getIdUsuario();
    }
    
    public void validar(BedelDTO bedelDTO) throws Exceptions.ValueException {
        String nombre = bedelDTO.getNombre();
        String apellido = bedelDTO.getApellido();
        String idLogin = bedelDTO.getIdLogin();
        //TurnoBedel turno = bedelDTO.getTurno();
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
    }
    
    public void eliminar(int id) throws DAOException{
        try{
           Bedel b = DAO.buscarPorID(id);
           b.setHabilitado(false);
           DAO.modificar(b);
        } catch(DAOException e){
            throw new DAOException(e.getMessage());
        }
    }
    
    public BedelDTO buscarPorID(Integer id) throws DAOException {
        
        try{
            Bedel b = DAO.buscarPorID(id);
            return convertirADTO(b);
        } catch(DAOException e){
            throw new DAOException(e.getMessage());
        }
        
    }

    public List<BedelDTO> buscar(String apellido) throws Exceptions.ValueException, DAOException {
        List<BedelDTO> bedeles = new ArrayList<>();
        List<Bedel> bedelesAux;

        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);

        apellido = apellido.trim();
        if (!pattern.matcher(apellido).matches()) {
            throw new ValueException("Introduzca un apellido válido.");
        }
        
        bedelesAux = DAO.buscar(apellido);
        
        for(Bedel bedel : bedelesAux){
            /*BedelDTO BedelDTOaux = new BedelDTO(bedel.getIdUsuario(), bedel.getNombre(), bedel.getApellido(), bedel.getTurno(), bedel.isHabilitado());
            bedeles.add(BedelDTOaux);*/
            bedeles.add(convertirADTO(bedel));
        }
        return bedeles;
    }
             
    
    public List<BedelDTO> buscar(TurnoBedel turno) throws Exceptions.ValueException, DAOException {
        
        List<BedelDTO> bedeles = new ArrayList<>();
        List<Bedel> bedelesAux;
        
        bedelesAux = DAO.buscar(turno);
        
        for(Bedel bedel : bedelesAux){
            /*BedelDTO BedelDTOaux = new BedelDTO(bedel.getIdUsuario(), bedel.getNombre(), bedel.getApellido(), bedel.getTurno(), bedel.isHabilitado());
            bedeles.add(BedelDTOaux);*/
            bedeles.add(convertirADTO(bedel));
        }
        return bedeles;
    }
    
    public Bedel convertirAModelo(BedelDTO bdto){
        int id = bdto.getIdUsuario();
        String nombre = bdto.getNombre();
        String apellido = bdto.getApellido();
        String idLogin = bdto.getIdLogin();
        TurnoBedel turno = bdto.getTurno();
        String contraseña = bdto.getContrasena();
        boolean habilitado = bdto.isHabilitado();
        
        Bedel b = new Bedel(id, idLogin, contraseña, nombre, apellido, turno, habilitado);
        
        return b;
    }
    
    public BedelDTO convertirADTO(Bedel b){
        int id = b.getIdUsuario();
        String nombre = b.getNombre();
        String apellido = b.getApellido();
        String idLogin = b.getIdLogin();
        TurnoBedel turno = b.getTurno();
        String contraseña = b.getContrasena();
        boolean habilitado = b.isHabilitado();
        
        BedelDTO bdto = new BedelDTO(id, idLogin, contraseña, nombre, apellido, turno, habilitado);
        
        return bdto;
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
