
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaPeriodica extends Reserva{
    private TipoReservaPeriodica tipo; // Enum: CUATRIMESTRAL, ANUAL
    private final List<DiaSemana> diasSemana; // Enum: LUNES, MARTES, etc.

    public ReservaPeriodica(){
    this.diasSemana= new ArrayList<>();}
    public ReservaPeriodica(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra,LocalDateTime fechaRegistro,TipoReservaPeriodica tipo,List<DiaSemana> diasSemana){
            super(nombreDocente,idDocente,apellidoDocente,emailDocente,idCatedra,nombreCatedra,fechaRegistro); 
            this.tipo=tipo;
            this.diasSemana=diasSemana;
    }
    
    public TipoReservaPeriodica getTipo() {
        return tipo;
    }

    public void setTipo(TipoReservaPeriodica tipo) {
        this.tipo = tipo;
    }
    
    

    public List<DiaSemana> getDiasSemana() {
        return new ArrayList<>(diasSemana);
    }

}
