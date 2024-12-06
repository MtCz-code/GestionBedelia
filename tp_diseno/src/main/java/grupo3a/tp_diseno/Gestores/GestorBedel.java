package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.BedelDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.BedelSqlDAO;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Modelos.Administrador;
//import static grupo3a.tp_diseno.Tp_diseno.contains;
import java.util.ArrayList;
import java.util.List;
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

    private GestorBedel() {
    }


    private BedelDAO DAO = BedelSqlDAO.getInstance();

    
    public void crear(BedelDTO bedelDTO) throws Exceptions.ValueException {

        // cortar espacios
        bedelDTO.setIdLogin(bedelDTO.getIdLogin().trim());
        String idLogin = bedelDTO.getIdLogin();
        
        
        // validar
        try {
            validarCampos(bedelDTO);
            validarIdLogin(idLogin);
        } catch(ValueException e){
            throw new ValueException(e.getMessage());

        }
    }

    /*public void crear(UsuarioDTO usuarioDTO){
       
        if(usuarioDTO.getTurno() != null){ // crear BEDEL
           Bedel b = new Bedel( BCrypt.hashpw(usuarioDTO.getContrasena(), BCrypt.gensalt()), usuarioDTO.getNombre(), usuarioDTO.getApellido(),
                   usuarioDTO.getTurno(), usuarioDTO.isHabilitado()); //habilitado true
           DAO.crear(b);
       }
       /*else { // crear admin
           Administrador a = new Administrador(BCrypt.hashpw(usuarioDTO.getContrasena(), BCrypt.gensalt()),
                   usuarioDTO.getNombre(), usuarioDTO.getApellido() );
           DAO.crear(a);
>>>>>>> 099c40b28cecd8b5ca673f40b47a621ae070a8dd
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
    */
    public Integer modificar(BedelDTO bedelDTO) throws Exceptions.ValueException {
        bedelDTO.setIdLogin(bedelDTO.getIdLogin().trim());
        
        try {
            validarCampos(bedelDTO);
            validarIdLogin(bedelDTO);
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
    
    public void validarIdLogin(BedelDTO b) throws Exceptions.ValueException {
       try {
            if (DAO.validarIdLogin(b.getIdLogin(), b.getIdUsuario())) {
                throw new ValueException("<html>Nombre de usuario en uso, <br>introduzca uno diferente.</html>");
            }
        } catch (DAOException e) {
            throw new ValueException("Error con la consulta." + e.getMessage());
        }
    }
    
    public void validarIdLogin(String idLogin) throws Exceptions.ValueException {
       try {
            if (DAO.validarIdLogin(idLogin)) {
                throw new ValueException("<html>Nombre de usuario en uso, <br>introduzca uno diferente.</html>");
            }
        } catch (DAOException e) {
            throw new ValueException("Error con la consulta." + e.getMessage());
        }
    }
    
    public void validarCampos(BedelDTO bedelDTO) throws Exceptions.ValueException {
        String nombre = bedelDTO.getNombre();
        String apellido = bedelDTO.getApellido();
        String idLogin = bedelDTO.getIdLogin();
        //TurnoBedel turno = bedelDTO.getTurno();
        String contraseña = bedelDTO.getContrasena();

        idLogin = idLogin.trim();
        nombre = nombre.trim();

       

        // longitud maxima del id_login
        int largoMaxIdLogin = 30;
        if (nombre.length() >= largoMaxIdLogin) {
            throw new ValueException("<html>El nombre de usuario debe contener menos de <br>" + largoMaxIdLogin + " caracteres.</html>");
        }

        // id login
        String patronIdLogin = "^[a-zA-Z0-9_]+$";
        Pattern patternIdLogin = Pattern.compile(patronIdLogin);
        if (!patternIdLogin.matcher(idLogin).matches()) {
            throw new ValueException("<html>Introduzca un nombre de usuario válido. Se<br>permiten letras, números y _, sin espacios.</html>");
        }

        // longitud maxima del nombre
        int largoMaxNombre = 50;
        if (nombre.length() >= largoMaxNombre) {
            throw new ValueException("<html>El nombre debe contener menos de <br>" + largoMaxNombre + " caracteres.</html>");
        }

        // longitud maxima del apellido
        int largoMaxApellido = 50;
        if (apellido.length() >= largoMaxApellido) {
            throw new ValueException("<html>El apellido debe contener menos de <br>" + largoMaxApellido + " caracteres.</html>");
        }

        // longitud mínima de la contraseña
        int largoMinContrasena = 8;
        if (contraseña.length() < largoMinContrasena) {
            throw new ValueException("<html>La contraseña debe contener al menos <br>" + largoMinContrasena + " caracteres.</html>");
        }

        // longitud maxima de la contrasena
        int largoMaxContrasena = 60;
        if (contraseña.length() >= largoMaxContrasena) {
            throw new ValueException("<html>La contrasena debe contener menos de <br>" + largoMaxContrasena + " caracteres.</html>");
        }

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

        // si la contraseña debe contener signos especiales (@#$%&*)
        if (!(contraseña.contains("@") || contraseña.contains("#")
                || contraseña.contains("$") || contraseña.contains("%")
                || contraseña.contains("*"))) {
            throw new ValueException("<html>La contraseña debe contener <br> caracteres especiales (@#$%&*)</html>");
        }

        // si la contraseña debe contener al menos una letra mayúscula.
        if (!contains(contraseña, 'A', 'Z')) {
            throw new ValueException("<html>La contraseña debe contener <br> al menos una letra mayúscula</html>");
        }

        // si la contraseña debe contener al menos un dígito.
        if (!contains(contraseña, '0', '9')) {
            throw new ValueException("<html>La contraseña debe contener <br>al menos un dígito</html>");
        }
    }
    
    public void eliminar(int id) throws DAOException{
        try{
           Bedel b = DAO.buscarPorId(id);
           b.setHabilitado(false);
           DAO.modificar(b);
        } catch(DAOException e){
            throw new DAOException(e.getMessage());
        }
    }
    
    public BedelDTO buscarPorID(Integer id) throws DAOException, ValueException {
        
        try{
            Bedel b = DAO.buscarPorId(id);
            if(b == null) throw new ValueException("No existe bedel con ese ID");
            
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
        
        if(bedelesAux == null) throw new ValueException("No se encontraron bedeles con ese criterio");
        
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
//        BedelDTO bdtoTmp = new BedelDTO("nomap", "contr", "nom", "ap", TurnoBedel.MAÑANA, true);
//        bedeles.add(bdtoTmp);
        
        
        bedelesAux = DAO.buscar(turno);
        
        if(bedelesAux == null) throw new ValueException("No se encontraron bedeles con ese criterio");
        
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
    
    public boolean esBedel(int id) throws DAOException{
        if(DAO.buscarPorId(id) != null) return true;
        
        return false;
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
