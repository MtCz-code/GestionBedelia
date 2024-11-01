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
import grupo3a.tp_diseno.Gestores.*;
import grupo3a.tp_diseno.Interfaces.RegistrarAula.TIPO_RESERVA;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GestorReserva {

    public static final int RESERVA_ANUAL = 0;
    public final static int RESERVA_PRIMER_CUATRIMESTRE = 1;
    public final static int RESERVA_SEGUNDO_CUATRIMESTRE = 2;
    public final static int RESERVA_ESPORADICA = 3;

    private final AulaDAO aulaDAO = new AulaSqlDAO();
    private final ReservaDAO reservaDAO = new ReservaSqlDAO();
    private final DetalleReservaDAO detalleReservaDAO = new DetalleReservaSqlDAO();

    private int reservaTipoReserva = -1;
    private List<DiaSemana> reservaDiasSeleccionadosSemana;
    private List<DetalleReserva> reservaDetalleReservas;
    private String reservaNombreDocente;
    private String reservaApellidoDocente;
    private String reservaNombreCatedra;
    private String reservaCorreo;
    private int reservaCantidadAlumnos;
    private TipoAula reservaTipoAula;
    private AulaGeneral[] reservaAulasDisponibles; //
    private AulaGeneral reservaAulaSeleccionada; // TODO: estas se pueden simplificar
    private int reservaAulaSeleccionadaIdx; //

    // solo se usa para reserva esporadica
    public boolean validarDias(ArrayList<DetalleReservaDTO> diasReserva) {
        return true;
    }

    // NO ES NECESARIO VALIDAR NADA EN EL GESTOR, SE PUEDEN VALIDAR EN LA INTERFAZ
    public Reserva validarDatosReserva(ReservaDTO reservaDTO) {

        return null;
    }

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

    }

    // --------------------------------------------------------------------------------------------------------------------

    public void tipoReserva(int tipo) {
        reservaTipoReserva = tipo;
    }

    public void diasSeleccionados(List<DiaSemana> dias) {
        reservaDiasSeleccionadosSemana = dias;
    }

    public void horariosSeleccionados(List<DetalleReserva> detalles) {

        // FIXME: detalles estan incompletos
        reservaDetalleReservas = detalles;
    }

    public void validarDatos(String nombreDocente, String apellidoDocente,
            String nombreCatedra, String correo,
            int cantidadAlumnos, TipoAula tipoAula) {
        reservaNombreDocente = nombreDocente;
        reservaApellidoDocente = apellidoDocente;
        reservaNombreCatedra = nombreCatedra;
        reservaCorreo = correo;
        reservaCantidadAlumnos = cantidadAlumnos;
        reservaTipoAula = tipoAula;

        // TODO: validar datos

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
        a1.setIdAula(2);

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
        a1.setIdAula(2);

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
        LocalDateTime reservaFechaRegistro = LocalDateTime.now();

        if (reservaTipoReserva == RESERVA_ANUAL ||
                reservaTipoReserva == RESERVA_PRIMER_CUATRIMESTRE ||
                reservaTipoReserva == RESERVA_SEGUNDO_CUATRIMESTRE) {
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
        else {
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
        }

        for (int i = 0; i < reservaDetalleReservas.size(); i++) {
            DetalleReserva re = reservaDetalleReservas.get(i);
            re.setIdReserva(reserva.getIdReserva());
            re.setFecha(LocalDate.of(2024, 04, LocalDateTime.now().getDayOfMonth()));
            
            re.setIdAula(reservaAulaSeleccionada.getIdAula());

            detalleReservaDAO.crear(re); // FIXME: por que aca no devuelve id??
        }

        // FIXME: cuatrimestre o detalle reserva se tendria que manejar de otra forma
        // fecha en reserva esta al pedo, si es anual, se pueden calcular las fechas
        reservaDAO.asociarCuatrimestre(reserva.getIdReserva(), 1, 2);

    }

}
