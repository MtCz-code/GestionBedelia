package grupo3a.tp_diseno.Gestores;

import java.util.*;
import grupo3a.tp_diseno.Modelos.*;
import grupo3a.tp_diseno.DAOs.*;
import grupo3a.tp_diseno.DTOs.*;
import grupo3a.tp_diseno.DAOs.Clases_sql.*;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.NoExisteAulaException;
import grupo3a.tp_diseno.Gestores.*;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.SeleccionTipoReserva.TIPO_RESERVA;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Pattern;

public class GestorReserva {

    /*public static final int RESERVA_ANUAL = 0;
    public final static int RESERVA_PRIMER_CUATRIMESTRE = 1;
    public final static int RESERVA_SEGUNDO_CUATRIMESTRE = 2;
    public final static int RESERVA_ESPORADICA = 3;*/

   /* private int reservaTipoReserva = -1;
    private List<DiaSemana> reservaDiasSeleccionadosSemana;
    private List<DetalleReservaDTO> reservaDetalleReservas;
    private String reservaNombreDocente;
    private String reservaApellidoDocente;
    private String reservaNombreCatedra;
    private String reservaCorreo;
    private int reservaCantidadAlumnos;
    private TipoAula reservaTipoAula;
    private AulaGeneral[] reservaAulasDisponibles; //
    private AulaGeneral reservaAulaSeleccionada; // TODO: estas se pueden simplificar
    private int reservaAulaSeleccionadaIdx; //*/
    
    
    private final ReservaPeriodicaDAO reservaPeriodicaDAO = ReservaPeriodicaSqlDAO.getInstance();
    private final ReservaEsporadicaDAO reservaEsporadicaDAO = ReservaEsporadicaSqlDAO.getInstance();
    
    private final DetalleReservaDAO detalleReservaDAO = DetalleReservaSqlDAO.getInstance();
    
    private final CuatrimestreDAO cuatrimestreDAO = CuatrimestreSqlDAO.getInstance();
    
    private final GestorAula gestorAula = GestorAula.getInstance();
    private final GestorLogin gestorLogin = GestorLogin.getInstance();
    
    private static GestorReserva gestorReservaInstance;
    
    public static GestorReserva getInstance() {
        if(gestorReservaInstance == null)
            gestorReservaInstance = new GestorReserva();
        
        return gestorReservaInstance;
    }
    
    private GestorReserva() {
        
    }
    
    public List<Year> recuperarAñosDisponibles() throws DAOException{
        
        return cuatrimestreDAO.recuperarAñosCuatrimestres();
    }
    
    public List<CuatrimestreDTO> recuperarCuatrimestresPorAño(Year año) throws DAOException{
        List<CuatrimestreDTO> cdto = new ArrayList();
        List<Cuatrimestre> cuatrimestres = cuatrimestreDAO.recuperarCuatrimestresPorAño(año);
        
        for(Cuatrimestre c : cuatrimestres){
           cdto.add(convertirCuatrimestreADTO(c));
           
            /*System.out.println("cuatrimestre:" + c.getIdCuatrimestre() 
                    + "\ninicio: " + c.getFechaInicio().toString() 
                    + "\nfin: " + c.getFechaFin());*/
        }
        
        return cdto;
    }
    
    
    // solo se usa para reserva esporadica
    public boolean validarDias(List<DetalleReservaDTO> diasReserva, List<CuatrimestreDTO> cuatrimestres) throws ValueException {
        // Validar si los días de las reservas están dentro de algún cuatrimestre
        for (DetalleReservaDTO detalle : diasReserva) {
            boolean dentroDeCuatrimestre = false;
            for (CuatrimestreDTO cuatrimestre : cuatrimestres) {
                if (!detalle.getFecha().isBefore(cuatrimestre.getFechaInicio())
                        && !detalle.getFecha().isAfter(cuatrimestre.getFechaFin())) {
                    dentroDeCuatrimestre = true;
                    break;
                }
            }
            if (!dentroDeCuatrimestre) {
                throw new ValueException("La fecha " + detalle.getFecha() + " no está dentro de ningún cuatrimestre.");
            }
        }

        // Validar si hay días repetidos
        if (!validarDias(diasReserva)) {
            throw new ValueException("Se ha ingresado un día más de una vez.");
        }

        return true;
    }

        // solo se usa para reserva esporadica
    private boolean validarDias(List<DetalleReservaDTO> diasReserva) {
        HashSet<LocalDate> fechasUnicas = new HashSet<>();
        
        for (DetalleReservaDTO detalle : diasReserva) {
            if (!fechasUnicas.add(detalle.getFecha())) {
                // Si no se puede agregar al conjunto, significa que está repetido
                return false;
            }
        }
        return true;
    }
    
    public List<DetalleReservaDTO> generarDetallesReserva(List<CuatrimestreDTO> cuatrimestres, List<DiaSemana> diasSemana, List<Time> horariosInicio, List<Integer> cantModulos) {
        List<DetalleReservaDTO> detallesReserva = new ArrayList<>();
        LocalDate hoy = LocalDate.now(); // Obtener la fecha actual

        for (CuatrimestreDTO cuatrimestre : cuatrimestres) {
            LocalDate inicio = cuatrimestre.getFechaInicio();
            LocalDate fin = cuatrimestre.getFechaFin();

            for (int i = 0; i < diasSemana.size(); i++) {
                DiaSemana diaSeleccionado = diasSemana.get(i);
                Time horarioInicio = horariosInicio.get(i);
                int modulos = cantModulos.get(i);

                LocalDate primeraFecha = obtenerPrimeraFecha(inicio, diaSeleccionado);

                while (primeraFecha.isBefore(hoy)) {
                    primeraFecha = primeraFecha.plusWeeks(1);
                }

                for (LocalDate fecha = primeraFecha;
                        !fecha.isAfter(fin);
                        fecha = fecha.plusWeeks(1)) {

                    DetalleReservaDTO detalle = new DetalleReservaDTO(0, horarioInicio, modulos, fecha, diaSeleccionado, 0);
                    detallesReserva.add(detalle);
                }
            }
        }
        
        for(DetalleReservaDTO d : detallesReserva){
            System.out.println("Fecha: " + d.getFecha() + " - Horario Inicio: " + d.getHorarioInicio() + " - CANT MODULOS: " + d.getCantModulos() + " Dia Semana: " + d.getDiaReserva());
        }

        return detallesReserva;
    }

    private LocalDate obtenerPrimeraFecha(LocalDate inicio, DiaSemana diaSeleccionado) {
        DayOfWeek diaJava = convertirDiaSemana(diaSeleccionado);
        return inicio.with(TemporalAdjusters.nextOrSame(diaJava));
    }

    private DayOfWeek convertirDiaSemana(DiaSemana diaSemana) {
        switch (diaSemana) {
            case LUNES: return DayOfWeek.MONDAY;
            case MARTES: return DayOfWeek.TUESDAY;
            case MIERCOLES: return DayOfWeek.WEDNESDAY;
            case JUEVES: return DayOfWeek.THURSDAY;
            case VIERNES: return DayOfWeek.FRIDAY;
            default: return  null;
        }
    }

    
    public DisponibilidadDTO validarDatosYObtenerAulas(ReservaDTO reservaDTO, TipoAula tipoAula) throws ValueException, DAOException, NoExisteAulaException {
        
        validarDatosReserva(reservaDTO);
        
        DisponibilidadDTO d = gestorAula.obtenerDisponibilidadAulas(reservaDTO, tipoAula);
        
        System.out.println("Solapamiento: " + d.getSolapamiento());
        System.out.println("Aulas Disponibles:");
        for(AulaDTO a : d.getAulasDisponibles().keySet()){
            System.out.println("Aula: " + a.getUbicacion() + " - Solapamiento: " + d.getAulasDisponibles().get(a));
        }
        
        return d;
    }
    
    
    public void validarDatosReserva(ReservaDTO r) throws ValueException{
        String nombreDocente = r.getNombreDocente();
        String apellidoDocente = r.getApellidoDocente();
        String emailDocente = r.getEmailDocente();
        String nombreCatedra = r.getNombreCatedra();
        
        
        if(r.getCantidadAlumnos() <= 0) throw new ValueException("La cantidad de alumnos debe ser mayor a 0");;
        
        int largoMaxNombre = 50;
        if (nombreDocente.length() >= largoMaxNombre
                || apellidoDocente.length() >= largoMaxNombre
                || emailDocente.length() >= largoMaxNombre
                || nombreCatedra.length() >= largoMaxNombre) {
            throw new ValueException("<html>Los nombres deben tener menos de <br>" + largoMaxNombre + " caracteres.</html>");
        }

        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        
        nombreDocente = nombreDocente.trim();
        if (!pattern.matcher(nombreDocente).matches()) {
            throw new ValueException("Nombre de docente inválido.");
        }

        
        apellidoDocente = apellidoDocente.trim();
        if (!pattern.matcher(apellidoDocente).matches()) {
            throw new ValueException("Apellido de docente inválido.");
        }
        
        if (!pattern.matcher(nombreCatedra).matches()) {
            throw new ValueException("Nombre de cátedra inválido.");
        }
        
       regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
       pattern = Pattern.compile(regex);
       if (!pattern.matcher(emailDocente).matches()) {
            throw new ValueException("Email del docente inválido.");
        }
    }
    
    
    
    public int crearReserva(ReservaDTO rdto) throws DAOException, ValueException{
        
        rdto.setIdBedel(gestorLogin.getIdUsuarioLogueado());
        Reserva r = convertirAModelo(rdto);
        
        int id = 0;
        
        if(r instanceof ReservaEsporadica){
            id = reservaEsporadicaDAO.crear((ReservaEsporadica) r);
        }
        else {
            id = reservaPeriodicaDAO.crear((ReservaPeriodica) r);
        }
        
        return id;
    }
    
    

    
    
    
    public Reserva convertirAModelo(ReservaDTO r) throws DAOException, ValueException{
        
        int id = r.getIdReserva();
        String nombreDocente = r.getNombreDocente();
        String apellidoDocente = r.getApellidoDocente();
        int idDocente = r.getIdDocente();
        String emailDocente = r.getEmailDocente();
        int idCatedra = r.getIdCatedra();
        String nombreCatedra = r.getNombreCatedra();
        LocalDateTime fechaRegistro = r.getFechaRegistro();
        
        Bedel bedel = GestorBedel.getInstance().convertirAModelo( GestorBedel.getInstance().buscarPorID(r.getIdBedel() ));
        
        List<DetalleReserva> detallesReserva = convertirListaDetallesAModelo(r.getDetallesReserva());
        
        Reserva rm;
        
        
        // Variables especificas
        if(r.isEsEsporadica()){
            rm = (Reserva) new ReservaEsporadica(id, nombreDocente, idDocente, apellidoDocente, emailDocente,
                                                    idCatedra, nombreCatedra, fechaRegistro, bedel, detallesReserva);
            
        }
        else{
            TipoReservaPeriodica tipo = r.getTipo();
            List<DiaSemana> diasSemana = r.getDiasSemana();
            Cuatrimestre cuatrimestre1 = (r.getIdCuatrimestre1() == 0)?  null : cuatrimestreDAO.buscarPorId(r.getIdCuatrimestre1());
            Cuatrimestre cuatrimestre2 = (r.getIdCuatrimestre2() == 0)? null : cuatrimestreDAO.buscarPorId(r.getIdCuatrimestre2());
            
            rm = (Reserva) new ReservaPeriodica(id, nombreDocente, idDocente, apellidoDocente, emailDocente,
                                                    idCatedra, nombreCatedra, fechaRegistro, bedel, detallesReserva,
                                                    tipo, diasSemana, cuatrimestre1, cuatrimestre2);
            
        }
        
        
        return rm;
    }
    
    public ReservaDTO convertirADTO(Reserva r){
        
        int id = r.getIdReserva();
        String nombreDocente = r.getNombreDocente();
        String apellidoDocente = r.getApellidoDocente();
        int idDocente = r.getIdDocente();
        String emailDocente = r.getEmailDocente();
        int idCatedra = r.getIdCatedra();
        String nombreCatedra = r.getNombreCatedra();
        LocalDateTime fechaRegistro = r.getFechaRegistro();
        int idBedel = r.getBedel().getIdUsuario();
        List<DetalleReservaDTO> detallesReserva = convertirListaDetallesADTO(r.getDetallesReserva());
        
        
        ReservaDTO rdto = new ReservaDTO(id,nombreDocente, idDocente, apellidoDocente,
                                emailDocente, idCatedra, nombreCatedra, fechaRegistro, 0, idBedel,
                                null, null, false, 0, 0, // datos especificos de reservaPeriodica
                                detallesReserva);
        
        // Variables especificas
        if(r instanceof ReservaEsporadica){
            rdto.setEsEsporadica(true);
        }
        else{
            rdto.setEsEsporadica(false);
            
            ReservaPeriodica rp = (ReservaPeriodica) r;
            
            rdto.setTipo(rp.getTipo());
            rdto.setDiasSemana(rp.getDiasSemana());
            rdto.setIdCuatrimestre1(rp.getCuatrimestre1().getIdCuatrimestre());
            rdto.setIdCuatrimestre2(rp.getCuatrimestre2().getIdCuatrimestre());
        }
        
        
        return rdto;
    }
    
    private List<DetalleReservaDTO> convertirListaDetallesADTO(List<DetalleReserva> detallesReserva) {
        List<DetalleReservaDTO> listadr = new ArrayList();
        
        for(DetalleReserva d : detallesReserva){
            DetalleReservaDTO dr = new DetalleReservaDTO(d.getIdReserva(), d.getHorarioInicio(), d.getCantModulos(),
                                                        d.getFecha(), d.getDiaReserva(), d.getIdAula());
            
            listadr.add(dr);
            
        }
        
        return listadr;
    }
    
    private List<DetalleReserva> convertirListaDetallesAModelo(List<DetalleReservaDTO> detallesReserva) {
        List<DetalleReserva> listadr = new ArrayList();
        
        for(DetalleReservaDTO d : detallesReserva){
            DetalleReserva dr = new DetalleReserva(d.getIdReserva(), d.getHorarioInicio(), d.getCantModulos(),
                                                        d.getFecha(), d.getDiaReserva(), d.getIdAula());
            
            listadr.add(dr);
            
        }
        
        return listadr;
    }
    
    private CuatrimestreDTO convertirCuatrimestreADTO(Cuatrimestre c) {
        int id = c.getIdCuatrimestre();
        LocalDate fechaInicio = c.getFechaInicio();
        LocalDate fechaFin = c.getFechaFin();
        
        return new CuatrimestreDTO(id, fechaInicio, fechaFin);
    }
    
    /*private Cuatrimestre convertirCuatrimestreAModelo(CuatrimestreDTO c) {
        int id = c.getIdCuatrimestre();
        LocalDate fechaInicio = c.getFechaInicio();
        LocalDate fechaFin = c.getFechaFin();
        
        return new Cuatrimestre(id, fechaInicio, fechaFin);
    }*/
    
    
   

    // --------------------------------------------------------------------------------------------------------------------

    /*
    
    List<Cuatrimestre> cuatrimestres;
    public void tipoReserva(int tipo) {
        reservaTipoReserva = tipo;
        cuatrimestres = cuatrimestreDAO.getCuatrimestresActuales();
//        if(tipo == RESERVA_ANUAL) {
//            
//        }
//        else if(tipo == RESERVA_PRIMER_CUATRIMESTRE) {
//            
//        }
//        else if(tipo == RESERVA_SEGUNDO_CUATRIMESTRE) {
//            
//        }
//        else if(tipo == RESERVA_ESPORADICA) {
//            
//        }
        
//        Date now = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(now);
//        int yearNow = cal.get(Calendar.YEAR);
//        for (int i = 0; i < c.size(); i++) {
//            LocalDate ld = c.get(i).getFechaInicio();
//            Date inicioCuatr = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
//            cal.setTime(inicioCuatr);
//            int yearCuatr = cal.get(Calendar.YEAR);
//            if(yearNow == yearCuatr);
//        }
    }
    public int getTipoReserva(){
        return reservaTipoReserva;
    }

    // periodica
    public void diasSeleccionados(List<DiaSemana> dias) {
        reservaDiasSeleccionadosSemana = dias;
    }

    // periodica
    public void horariosSeleccionados(List<DetalleReservaDTO> detalles) {
        reservaDetalleReservas = detalles;
    }
    
    // esporadica
    public void seleccionarDiasYHorarios(List<DetalleReservaDTO> detalles) throws Exceptions.ValueException{
        reservaDetalleReservas = detalles;
        if (!validarDias(detalles)){
            throw new Exceptions.ValueException("no se puden seleccionar dias repetidos");
        }
    }
    
    // solo se usa para reserva esporadica
    public boolean validarDias(List<DetalleReservaDTO> diasReserva) {
        // TODO: check
        return true;
    }
    
    public DisponibilidadDTO validarDatosYObtenerAulas(ReservaDTO reservaDTO, TipoAula tipoAula) throws Exceptions.ValueException, NoExisteAulaException {
        
        validarCantidadAlumnos(reservaDTO);
        
        DisponibilidadDTO d = gestorAula.obtenerDisponibilidadAulas(reservaDTO);
        
        if(d.getAulasDisponibles() == null) throw new NoExisteAulaException("No hay aulas con esa capacidad de alumnos");
        return d;
    }
    
    public boolean validarCantidadAlumnos(ReservaDTO r){
        return true;
    }

    // TODO: FIX
//    public void validarDatos(String nombreDocente, String apellidoDocente,
//            String nombreCatedra, String correo,
//            int cantidadAlumnos, TipoAula tipoAula) throws Exceptions.ValueException {
//        reservaNombreDocente = nombreDocente;
//        reservaApellidoDocente = apellidoDocente;
//        reservaNombreCatedra = nombreCatedra;
//        reservaCorreo = correo;
//        reservaCantidadAlumnos = cantidadAlumnos;
//        reservaTipoAula = tipoAula;
//         TODO: validar datos
//         validarAlumnos()
//    }
    // TODO: FIX
    

    public AulaGeneral[] getAulasDisponibles() {

        // TODO: obtener de la base de datos (CU5)
        AulaGeneral a1 = new AulaGeneral(
                TipoAula.GENERAL, // tipo
                "13", // ubicacion
                true, // estado
                30, // capacidad
                1, // piso
                TipoPizarron.TIZA, // tipoDePizarron
                true, // ventiladores
                true, // aireAcondicionado
                true // habilitado
        );
        a1.setIdAula(1);

        AulaLaboratorio a2 = new AulaLaboratorio(TipoAula.LABORATORIO,
                "14",
                true, 20,
                1, TipoPizarron.FIBRON,
                true,
                true,
                true,
                10);
        a2.setIdAula(2);

        AulaMultimedios a3 = new AulaMultimedios(TipoAula.MULTIMEDIOS,
                "15",
                true, 20,
                2,
                TipoPizarron.TIZA,
                true,
                true,
                true,
                true,
                true,
                true);
        a3.setIdAula(2);

        reservaAulasDisponibles = new AulaGeneral[] {
                a1,
                a2,
                a3
        };

        return reservaAulasDisponibles;
    }

    public void aulaSeleccionada(int idx) {
        reservaAulaSeleccionada = reservaAulasDisponibles[idx];
        reservaAulaSeleccionadaIdx = idx;
    }

    public void crearReserva() {
        Reserva reserva;
        int reservaIdDocente = 0;
        int reservaIdCatedra = 0;
        int reservaIdBedel = 1;
        int reservaIdAula = 1;
        
        LocalDateTime reservaFechaRegistro = LocalDateTime.now();

        if (reservaTipoReserva == RESERVA_ANUAL ||
                reservaTipoReserva == RESERVA_PRIMER_CUATRIMESTRE ||
                reservaTipoReserva == RESERVA_SEGUNDO_CUATRIMESTRE) {
            ReservaPeriodica rp = new ReservaPeriodica(
                    reservaNombreDocente,
                    reservaIdDocente,
                    reservaApellidoDocente,
                    reservaCorreo,
                    reservaIdCatedra,
                    reservaNombreCatedra,
                    reservaIdBedel,
                    reservaFechaRegistro,
                    TipoReservaPeriodica.ANUAL,
                    reservaDiasSeleccionadosSemana);
            rp.setIdReserva(reservaDAO.crear(rp));
            reserva = rp;
            // FIXME: cuatrimestre o detalle reserva se tendria que manejar de otra forma
            // fecha en reserva esta al pedo, si es anual, se pueden calcular las fechas
            if (reservaTipoReserva == RESERVA_ANUAL) {
                // asignar primer cuatrimestre
                ((ReservaPeriodicaDAO)reservaDAO).asociarCuatrimestre(reserva.getIdReserva(), 1, 2);
            }
            else if (reservaTipoReserva == RESERVA_PRIMER_CUATRIMESTRE) {
               ((ReservaPeriodicaDAO)reservaDAO).asociarCuatrimestre(reserva.getIdReserva(), 1);
            }
            else {
                ((ReservaPeriodicaDAO)reservaDAO).asociarCuatrimestre(reserva.getIdReserva(), 2);
            }
            
        } 
        else {
            ReservaEsporadica re = new ReservaEsporadica(
                    reservaNombreDocente,
                    reservaIdDocente,
                    reservaApellidoDocente,
                    reservaCorreo,
                    reservaIdCatedra,
                    reservaNombreCatedra,
                    reservaIdBedel,
                    reservaFechaRegistro);

            re.setIdReserva(reservaDAO.crear(re));
            reserva = re;
            
        }
        
        // FIXME: aca se tendria que generar una para cada dia del cuatrimestre??
        for (int i = 0; i < reservaDetalleReservas.size(); i++) {
            DetalleReserva re = reservaDetalleReservas.get(i);
            re.setIdReserva(reserva.getIdReserva());
            LocalDate d = LocalDate.of(2024, 04, 01 + i);
            re.setFecha(d);
            
            re.setIdAula(reservaAulaSeleccionada.getIdAula());

            detalleReservaDAO.crear(re); // FIXME: por que aca no devuelve id??
        }

        

    }*/

    

    

    

}
