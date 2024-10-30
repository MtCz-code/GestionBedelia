
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDateTime;


public class ReservaEsporadica extends Reserva{
    public ReservaEsporadica(){
    }
    public ReservaEsporadica(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra,LocalDateTime fechaRegistro){
        
        super(nombreDocente,idDocente,apellidoDocente,emailDocente,
            idCatedra,nombreCatedra,fechaRegistro);
    }
}
