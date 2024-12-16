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
import grupo3a.tp_diseno.DAOs.DetalleReservaDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.NoExisteAulaException;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import java.util.HashMap;
import java.util.Map;
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
        
        

        // Obtener las reservas existentes que se solapan con los horarios y fechas de la nueva reserva
        List<List<DetalleReserva>> listaDRSolapados = new ArrayList<>();
        for (DetalleReservaDTO dr : reserva.getDetallesReserva()) {
            listaDRSolapados.add(detalleReservaDAO.getByDiaYHorario(dr.getFecha(), dr.getHorarioInicio(), dr.getCantModulos()));
        }

        
        // Filtrar por criterio (aulas sin solapamiento o con menor solapamiento)
        return filtrarPorCriterio(listaAulas, reserva.getDetallesReserva(), listaDRSolapados);
    }
    
    public DisponibilidadDTO filtrarPorCriterio(List<AulaDTO> listaAulas, List<DetalleReservaDTO> detallesReserva, List<List<DetalleReserva>> reservasSolapadas) throws NoExisteAulaException {
        DisponibilidadDTO disponibilidad = new DisponibilidadDTO();

        HashMap<AulaDTO, Integer> aulasConSolapamiento = inicializarHashMap(listaAulas);

        // Crear un mapa para buscar aulas rápidamente por ID
        Map<Integer, AulaDTO> mapAulas = listaAulas.stream()
                .collect(Collectors.toMap(AulaDTO::getIdAula, Function.identity()));

        // Calcular el total de módulos de la nueva reserva
        int totalModulosReserva = detallesReserva.stream()
                .mapToInt(DetalleReservaDTO::getCantModulos)
                .sum();
        /*for(DetalleReservaDTO dr : detallesReserva){
            totalModulosReserva += dr.getCantModulos();
        }*/

        // Calcular solapamiento para cada aula
        for (int i = 0; i < detallesReserva.size(); i++) {
            DetalleReservaDTO nuevaReserva = detallesReserva.get(i);
            List<DetalleReserva> solapadas = reservasSolapadas.get(i);

            for (DetalleReserva reservaExistente : solapadas) {

                AulaDTO aula = mapAulas.get(reservaExistente.getIdAula());

                if (aula != null) {
                    int solapamientoActual = aulasConSolapamiento.get(aula);
                    aulasConSolapamiento.put(aula, solapamientoActual + calcularSolapamiento(nuevaReserva, reservaExistente));
                }
            }
        }

        // Filtrar aulas sin solapamiento
        List<AulaDTO> aulasSinSolapamiento = aulasConSolapamiento.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .toList();

        if (!aulasSinSolapamiento.isEmpty()) {
            disponibilidad.setAulasDisponibles(inicializarHashMap(aulasSinSolapamiento));
            disponibilidad.setCantidadModulosTotales(totalModulosReserva);
            disponibilidad.setSolapamiento(false);
            return disponibilidad;
        }

        // Filtrar aulas cuyo solapamiento no exceda el 50% del total de módulos
        Map<AulaDTO, Integer> aulasFiltradas = aulasConSolapamiento.entrySet()
                .stream()
                .filter(entry -> entry.getValue() <= totalModulosReserva * 0.5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        if (aulasFiltradas.isEmpty()) {
            throw new NoExisteAulaException("<html>No existen aulas del tipo <br> requerido disponibles");
        }

        // Encontrar las 3 aulas con menor solapamiento
        List<AulaDTO> aulasMenorSolapamiento = aulasFiltradas.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        HashMap<AulaDTO, Integer> resultado = new HashMap<>();
        for (AulaDTO aula : aulasMenorSolapamiento) {
            resultado.put(aula, aulasConSolapamiento.get(aula));
        }
        disponibilidad.setAulasDisponibles(resultado);
        disponibilidad.setCantidadModulosTotales(totalModulosReserva);
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




    
    public static HashMap<AulaDTO, Integer> inicializarHashMap(List<AulaDTO> listaAulas) {
        HashMap<AulaDTO, Integer> mapaAulas = new HashMap<>();
        for (AulaDTO aula : listaAulas) {
            mapaAulas.put(aula, 0); // Inicializar cada clave con valor 0
        }
        return mapaAulas;
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
