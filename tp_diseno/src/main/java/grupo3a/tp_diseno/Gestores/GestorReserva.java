package grupo3a.tp_diseno.Gestores;

import java.util.*;
import grupo3a.tp_diseno.Modelos.*;
import grupo3a.tp_diseno.DAOs.*;
import grupo3a.tp_diseno.DTOs.*;
import grupo3a.tp_diseno.DAOs.Clases_sql.*;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Gestores.*;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.SeleccionTipoReserva.TIPO_RESERVA;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class GestorReserva {

    public static final int RESERVA_ANUAL = 0;
    public final static int RESERVA_PRIMER_CUATRIMESTRE = 1;
    public final static int RESERVA_SEGUNDO_CUATRIMESTRE = 2;
    public final static int RESERVA_ESPORADICA = 3;

    private final ReservaPeriodicaDAO reservaPeriodicaDAO = ReservaPeriodicaSqlDAO.getInstance();
    private final ReservaEsporadicaDAO reservaEsporadicaDAO = ReservaEsporadicaSqlDAO.getInstance();
    
    private final DetalleReservaDAO detalleReservaDAO = DetalleReservaSqlDAO.getInstance();
    
    private final CuatrimestreDAO cuatrimestreDAO = CuatrimestreSqlDAO.getInstance();
    
    private final GestorAula gestorAula = GestorAula.getInstance();

    private int reservaTipoReserva = -1;
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
    private int reservaAulaSeleccionadaIdx; //

    
    private static GestorReserva gestorReservaInstance;
    
    public static GestorReserva getInstance() {
        if(gestorReservaInstance == null)
            gestorReservaInstance = new GestorReserva();
        
        return gestorReservaInstance;
    }
    
    private GestorReserva() {
        
    }
    
    public List<CuatrimestreDTO> recuperarCuatrimestres(){
        List<CuatrimestreDTO> cdto = new ArrayList();
        List<Cuatrimestre> cuatrimestres = cuatrimestreDAO.getCuatrimestresActuales();
        for(Cuatrimestre c : cuatrimestres){
            System.out.println("cuatrimestre:" + c.getIdCuatrimestre() 
                    + "\ninicio: " + c.getFechaInicio().toString() 
                    + "\nfin: " + c.getFechaFin());
        }
        
        return cdto;
    }
    
    
    // solo se usa para reserva esporadica
    public boolean validarDias(List<DetalleReservaDTO> diasReserva, List<CuatrimestreDTO> cuatrimestres) {
        return true;
    }
    
    

    // NO ES NECESARIO VALIDAR NADA EN EL GESTOR, SE PUEDEN VALIDAR EN LA INTERFAZ
    // rta: esta en el diagrama de secuencia
//    public DisponibilidadDTO validarDatos(ReservaDTO reservaDTO) {
//        
//        validarCantidadAlumnos(reservaDTO);
//        
//        DisponibilidadDTO d = gestorAula.obtenerDisponibilidadAulas(reservaDTO);
//        
//        return null;
//    }
//    
//    public boolean validarCantidadAlumnos(ReservaDTO r){
//        return true;
//    }
    
    
    public int crearReserva(ReservaDTO reserva){
        
        return 1;
    }
    
    
    
    
    public ReservaDTO convertirADTO(Reserva r){
        
        
        ReservaDTO rdto = new ReservaDTO(0,null,0,null,null, 0, null, null, 0, 0, null, null, false, 0, 0);
        return rdto;
    }
    
    

    /*
    public void aulaSeleccionada(ReservaDTO reservaDTO, ArrayList<DetalleReservaDTO> detallesReservaDTO,
            AulaDTO aulaDTO) {
        // Obtener el aula seleccionada y asociarla a la reserva

        Reserva reserva;

        if (reservaDTO.isEsEsporadica()) {
            // Crear una instancia de ReservaEsporadica
            ReservaEsporadica reservaEsporadica = new ReservaEsporadica(
                    reservaDTO.getNombreCatedra(), reservaDTO.getIdDocente(),
                    reservaDTO.getApellidoDocente(), reservaDTO.getEmailDocente(),
                    reservaDTO.getIdCatedra(), reservaDTO.getNombreCatedra(),
                    reservaDTO.getIdBedel(), reservaDTO.getFechaRegistro());

            reservaEsporadica.setIdReserva(reservaDAO.crear(reservaEsporadica));
            reserva = reservaEsporadica; // Asignamos a reserva la instancia específica
        } else {
            // Crear una instancia de ReservaPeriodica
            ReservaPeriodica reservaPeriodica = new ReservaPeriodica(
                    reservaDTO.getNombreCatedra(), reservaDTO.getIdDocente(),
                    reservaDTO.getApellidoDocente(), reservaDTO.getEmailDocente(),
                    reservaDTO.getIdCatedra(), reservaDTO.getNombreCatedra(),
                    reservaDTO.getIdBedel(), reservaDTO.getFechaRegistro(),
                    reservaDTO.getTipo(), reservaDTO.getDiasSemana());

            reservaPeriodica.setIdReserva(reservaDAO.crear(reservaPeriodica));
            reserva = reservaPeriodica; // Asignamos a reserva la instancia específica
        }

        for (DetalleReservaDTO i : detallesReservaDTO) {

            DetalleReserva detalleReserva = new DetalleReserva(
                    reserva.getIdReserva(),
                    i.getHorarioInicio(), 
                    i.getCantModulos(), 
                    i.getFecha(), 
                    DiaSemana.JUEVES,// FIXME: i.getDiaReserva(), 
                    aulaDTO.getIdAula());
            detalleReservaDAO.crear(detalleReserva);
        }

        reservaDAO.asociarCuatrimestre(reserva.getIdReserva(), reservaDTO.getIdCuatrimestre1(),
                reservaDTO.getIdCuatrimestre2());

    }*/

    // --------------------------------------------------------------------------------------------------------------------
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
    public DisponibilidadDTO validarDatos(ReservaDTO reservaDTO, TipoAula tipoAula) throws Exceptions.ValueException {
        
        validarCantidadAlumnos(reservaDTO);
        
        DisponibilidadDTO d = gestorAula.obtenerDisponibilidadAulas(reservaDTO);
        
        return null;
    }
    
    public boolean validarCantidadAlumnos(ReservaDTO r){
        return true;
    }

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

    /*public void crearReserva() {
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
