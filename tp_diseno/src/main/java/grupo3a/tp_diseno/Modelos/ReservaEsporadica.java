
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDateTime;
import java.util.List;


public class ReservaEsporadica extends Reserva{
    public ReservaEsporadica(){
    }
    
    public ReservaEsporadica(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra,int idBedel,LocalDateTime fechaRegistro){
        
        super(nombreDocente,idDocente,apellidoDocente,emailDocente,
            idCatedra,nombreCatedra,idBedel,fechaRegistro);
    }

    public ReservaEsporadica(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente, int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, int idBedel, List<DetalleReserva> detallesReserva) {
        super(idReserva, nombreDocente, idDocente, apellidoDocente, emailDocente, idCatedra, nombreCatedra, fechaRegistro, idBedel, detallesReserva);
    }
    
    
    
}
