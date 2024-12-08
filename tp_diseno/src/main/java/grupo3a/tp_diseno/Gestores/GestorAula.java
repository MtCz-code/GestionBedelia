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
    
    
    public DisponibilidadDTO obtenerDisponibilidadAulas(ReservaDTO reserva, TipoAula tipoAula) throws DAOException, NoExisteAulaException{
        //List<AulaDTO> aulas = new ArrayList();
        //DisponibilidadDTO d = new DisponibilidadDTO(aulas, false);
        int capacidad = reserva.getCantidadAlumnos();
        
        // CONSEGUIR AULAS ELEGIBLES
        List<AulaDTO> listaAulas = new ArrayList();
       
        if(tipoAula == TipoAula.GENERAL){
            List<AulaGeneral> aulas = aulaGeneralDAO.getByCapacidad(capacidad);
            for(AulaGeneral a : aulas){
               listaAulas.add(convertirADTO(a));
           }
            
       } else if(tipoAula == TipoAula.LABORATORIO){
           List<AulaLaboratorio> aulas = aulaLaboratorioDAO.getByCapacidad(capacidad);
           for(AulaLaboratorio a : aulas){
               listaAulas.add(convertirADTO(a));
           }
           
       } else if(tipoAula == TipoAula.MULTIMEDIOS){
           List<AulaMultimedios> aulas = aulaMultimediosDAO.getByCapacidad(capacidad);
           for(AulaMultimedios a : aulas){
               listaAulas.add(convertirADTO(a));
           }
       } else return null;
        
        if(listaAulas.isEmpty()) throw new NoExisteAulaException("No existen aulas con la capacidad de alumnos requerida");
       
       
        // conseguir reservas existentes en los dias y horarios de la nueva reserva
        List<List<DetalleReserva>> listaDR = new ArrayList();
        
        for(DetalleReservaDTO dr : reserva.getDetallesReserva()){
            
            listaDR.add(detalleReservaDAO.getByDiaYHorario(dr.getFecha(), dr.getHorarioInicio(), dr.getCantModulos()));
        }
        
        
        DisponibilidadDTO d = filtrarPorCriterio(listaAulas, reserva.getDetallesReserva(), listaDR);
        
        return d;
    }
    
    public DisponibilidadDTO filtrarPorCriterio(List<AulaDTO> listaAulas, List<DetalleReservaDTO> DR, List<List<DetalleReserva>> DRsolapados){
        DisponibilidadDTO d = new DisponibilidadDTO();
        
        List<AulaDTO> aulasSinSolapamiento = new ArrayList(listaAulas);
        
        for(AulaDTO a : listaAulas){
            
            // RECORER DRsolapados para cada aula, si se encuentra ese aula en un dr de esa lista, significa que tiene solapamiento;
            
        }
        
        
        if(! aulasSinSolapamiento.isEmpty()){
            d.setAulasDisponibles(aulasSinSolapamiento);
            d.setSolapamiento(false);
        }
        else {
            // LOGICA PARA ENCONTRAR AULAS CON MENOR SOLAPAMIENTO
        }
        
        
        return null;
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
