package grupo3a.tp_diseno.Gestores;

import grupo3a.tp_diseno.DAOs.AulaLaboratorioDAO;
import grupo3a.tp_diseno.DAOs.AulaMultimediosDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaLaboratorioSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaMultimediosSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.AulaGeneralSqlDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import java.util.ArrayList;
import java.util.List;
import grupo3a.tp_diseno.DAOs.AulaGeneralDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.DetalleReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.ReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.NoExisteAulaException;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GestorAula {
    
    private static GestorAula gestorAulaInstance;
    
        public static GestorAula getInstance() {
        if(gestorAulaInstance == null)
            gestorAulaInstance = new GestorAula();
        
        return gestorAulaInstance;
    }
    
    private GestorAula() {
        
    }
    
    
    private final AulaGeneralDAO aulaGeneralDAO = AulaGeneralSqlDAO.getInstance();
    private final AulaLaboratorioDAO aulaLaboratorioDAO = AulaLaboratorioSqlDAO.getInstance();
    private final AulaMultimediosDAO aulaMultimediosDAO = AulaMultimediosSqlDAO.getInstance();
    
    private final DetalleReservaDAO detalleReservaDAO = DetalleReservaSqlDAO.getInstance();
    private final ReservaDAO reservaDAO = ReservaSqlDAO.getInstance();
    private final GestorReserva gestorReserva = GestorReserva.getInstance();
    
    
    
    public DisponibilidadDTO obtenerDisponibilidadAulas(ReservaDTO reserva, TipoAula tipoAula) throws DAOException, NoExisteAulaException {
        int capacidad = reserva.getCantidadAlumnos();
        List<AulaDTO> listaAulas = new ArrayList<>();

        if (null == tipoAula) {
            return null;
        } else // Obtener aulas elegibles según el tipo y capacidad
        switch (tipoAula) {
            case GENERAL ->                 {
                    List<AulaGeneral> aulas = aulaGeneralDAO.getByCapacidad(capacidad);
                    for (AulaGeneral a : aulas) {
                        listaAulas.add(convertirADTO(a));
                    }                      
            }
            case LABORATORIO ->                 {
                    List<AulaLaboratorio> aulas = aulaLaboratorioDAO.getByCapacidad(capacidad);
                    for (AulaLaboratorio a : aulas) {
                        listaAulas.add(convertirADTO(a));
                    }                      
            }
            case MULTIMEDIOS ->                 {
                    List<AulaMultimedios> aulas = aulaMultimediosDAO.getByCapacidad(capacidad);
                    for (AulaMultimedios a : aulas) {
                        listaAulas.add(convertirADTO(a));
                    }                      
            }
            default -> {
                return null;
            }
        }

        if (listaAulas.isEmpty()) {
            throw new NoExisteAulaException("No existen aulas con la capacidad de alumnos requerida");
        }
        
        
        Map<LocalDate, List<DetalleReserva>> solapamientosPorDia = new HashMap<>();
        for (DetalleReservaDTO dr : reserva.getDetallesReserva()) {
            solapamientosPorDia.put(dr.getFecha(),
                    detalleReservaDAO.getByDiaYHorario(dr.getFecha(), dr.getHorarioInicio(), dr.getCantModulos()));
        }

        // Filtrar por criterio (aulas sin solapamiento o con menor solapamiento)
        return filtrarPorCriterio(listaAulas, reserva.getDetallesReserva(), solapamientosPorDia); // devuelve DisponibilidadDTO
    }
    
    private DisponibilidadDTO filtrarPorCriterio(List<AulaDTO> listaAulas, List<DetalleReservaDTO> detallesReserva, Map<LocalDate, List<DetalleReserva>> solapamientosPorDia) throws NoExisteAulaException, DAOException {
        DisponibilidadDTO disponibilidad = new DisponibilidadDTO();
        HashMap<Integer, ReservaDTO> reservasMap = new HashMap<>();
        HashMap<Integer, AulaDTO> aulasDisponibles = new HashMap<>();
        List<DetalleReservaDTO> detallesSolapados = new ArrayList<>();

        // Inicializar las aulas sin solapamiento
        Set<AulaDTO> aulasSinSolapamiento = new HashSet<>(listaAulas);

        // Crear un mapa para buscar aulas rápidamente por ID
        Map<Integer, AulaDTO> mapAulas = new HashMap<>();
        for (AulaDTO aula : listaAulas) {
            mapAulas.put(aula.getIdAula(), aula);
        }

        // Procesar cada día (representado por los detalles de la nueva reserva)
        for (DetalleReservaDTO nuevoDR : detallesReserva) {
            LocalDate fecha = nuevoDR.getFecha();
            List<DetalleReserva> reservasExistentes = solapamientosPorDia.getOrDefault(fecha, Collections.emptyList());

            // Mapa para acumular solapamientos por aula
            Map<AulaDTO, Integer> solapamientoPorAula = new HashMap<>();

            for (DetalleReserva reservaExistente : reservasExistentes) {
                AulaDTO aula = mapAulas.get(reservaExistente.getIdAula());

                if (aula != null) {
                    int solapamiento = calcularSolapamiento(nuevoDR, reservaExistente);
                    if (solapamientoPorAula.containsKey(aula)) {
                        solapamientoPorAula.put(aula, solapamientoPorAula.get(aula) + solapamiento);
                    } else {
                        solapamientoPorAula.put(aula, solapamiento);
                    }
                    aulasSinSolapamiento.remove(aula); // Eliminar aulas que tienen solapamiento
                }
            }

            // Verificar si existen aulas sin solapamiento
            if (!aulasSinSolapamiento.isEmpty()) {
                for (AulaDTO aulaSinSolapamiento : aulasSinSolapamiento) {
                    aulasDisponibles.put(aulaSinSolapamiento.getIdAula(), aulaSinSolapamiento);
                }
                disponibilidad.setAulasDisponibles(aulasDisponibles);
                disponibilidad.setSolapamiento(false);
                return disponibilidad;
            }

            // Encontrar el menor solapamiento y las aulas con ese solapamiento
            int menorSolapamiento = Integer.MAX_VALUE;
            for (Integer solapamiento : solapamientoPorAula.values()) {
                if (solapamiento < menorSolapamiento) {
                    menorSolapamiento = solapamiento;
                }
            }
            for (Map.Entry<AulaDTO, Integer> entry : solapamientoPorAula.entrySet()) {
                if (entry.getValue() == menorSolapamiento) {
                    AulaDTO aulaSeleccionada = entry.getKey();
                    aulasDisponibles.put(aulaSeleccionada.getIdAula(), aulaSeleccionada);
               }
            }

            // Filtrar DetalleReserva correspondientes a las aulas seleccionadas
            for (DetalleReserva dr : reservasExistentes) {
                AulaDTO aula = mapAulas.get(dr.getIdAula());
                if (aula != null && aulasDisponibles.containsKey(aula.getIdAula())) {
                    detallesSolapados.add(gestorReserva.convertirDetalleReservaADTO(dr));

                    // Asociar la reserva completa al HashMap si aún no existe
                    if (!reservasMap.containsKey(dr.getIdReserva())) {
                            ReservaDTO reservaDTO = gestorReserva.convertirADTO(reservaDAO.buscarPorId(dr.getIdReserva()));
                            reservasMap.put(dr.getIdReserva(), reservaDTO);
                      }
                }
                
            }
        }

        // Configurar el objeto DisponibilidadDTO
        disponibilidad.setAulasDisponibles(aulasDisponibles);
        disponibilidad.setDrSolapados(detallesSolapados);
        disponibilidad.setReservasSolapadas(reservasMap);
        disponibilidad.setSolapamiento(true);

        return disponibilidad;
    }


    // Calcula el solapamiento en módulos entre los detalles de la nueva reserva y una reserva existente
    private int calcularSolapamiento(DetalleReservaDTO nuevaReserva, DetalleReserva reservaExistente) {
        
        int inicioNueva = nuevaReserva.getHorarioInicio().toLocalTime().toSecondOfDay() / 60;
        int finNueva = inicioNueva + nuevaReserva.getCantModulos() * 30;

        int inicioExistente = reservaExistente.getHorarioInicio().toLocalTime().toSecondOfDay() / 60;
        int finExistente = inicioExistente + reservaExistente.getCantModulos() * 30;

        // Si no hay intersección, devolver 0
        if (finNueva <= inicioExistente || finExistente <= inicioNueva) {
            return 0;
        }

        int inicioSolapamiento = Math.max(inicioNueva, inicioExistente);
        int finSolapamiento = Math.min(finNueva, finExistente);

        return (finSolapamiento - inicioSolapamiento) / 30; // Solapamiento en MODULOS
    }

    
    private AulaDTO convertirADTO(AulaGeneral a){
        int idAula = a.getIdAula();
        TipoAula tipo = a.getTipo();
        String ubicacion = a.getUbicacion();
        boolean estado = a.isEstado();
        int capacidad = a.getCapacidad();
        int piso = a.getPiso();
        TipoPizarron tipoDePizarron = a.getTipoDePizarron(); // Enum: TIZA, FIBRÓN
        boolean ventiladores = a.isVentiladores();
        boolean aireAcondicionado = a.isAireAcondicionado();
        boolean habilitado = a.isHabilitado();
        
        AulaDTO adto = new AulaDTO(idAula, tipo, ubicacion, estado, capacidad,
                            piso, tipoDePizarron, ventiladores, 
                               aireAcondicionado, habilitado);
        
        if(tipo == TipoAula.LABORATORIO){
            int cantidadDePCs = ((AulaLaboratorio) a).getCantidadDePCs();
            adto.setCantidadDePCs(cantidadDePCs);
        } 
        else if(tipo == TipoAula.MULTIMEDIOS){
            AulaMultimedios am = (AulaMultimedios) a;
            
            adto.setTelevisor(am.isTelevisor());
            adto.setCanon(am.isCanon());
            adto.setComputadora(am.isComputadora());
        }
        
        return adto;
    }
}
