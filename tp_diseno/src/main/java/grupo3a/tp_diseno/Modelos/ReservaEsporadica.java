
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDateTime;
import java.util.List;


public class ReservaEsporadica extends Reserva{
    public ReservaEsporadica(){
    }
    
    public ReservaEsporadica(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra,Bedel bedel,LocalDateTime fechaRegistro){
        
        super(nombreDocente,idDocente,apellidoDocente,emailDocente,
            idCatedra,nombreCatedra,bedel,fechaRegistro);
    }

    public ReservaEsporadica(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente, int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, Bedel bedel, List<DetalleReserva> detallesReserva) {
        super(idReserva, nombreDocente, idDocente, apellidoDocente, emailDocente, idCatedra, nombreCatedra, fechaRegistro, bedel, detallesReserva);
    }
    
    
    
}
