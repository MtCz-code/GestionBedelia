
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaPeriodica extends Reserva{
    private TipoReservaPeriodica tipo; // Enum: CUATRIMESTRAL, ANUAL
    private final List<DiaSemana> diasSemana; // Enum: LUNES, MARTES, etc.
    private Cuatrimestre cuatrimestre1;
    private Cuatrimestre cuatrimestre2;
    

    public ReservaPeriodica(){
    this.diasSemana= new ArrayList<>();}
    
    public ReservaPeriodica(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra, Bedel bedel, LocalDateTime fechaRegistro,TipoReservaPeriodica tipo,List<DiaSemana> diasSemana){
            super(nombreDocente,idDocente,apellidoDocente,emailDocente,idCatedra,nombreCatedra,bedel,fechaRegistro); 
            this.tipo=tipo;
            this.diasSemana=diasSemana;
    }

    public ReservaPeriodica(String nombreDocente, int idDocente, String apellidoDocente, String emailDocente, int idCatedra,
                            String nombreCatedra, Bedel bedel, LocalDateTime fechaRegistro,
                                TipoReservaPeriodica tipo, List<DiaSemana> diasSemana, Cuatrimestre cuatrimestre1, Cuatrimestre cuatrimestre2) {
        super(nombreDocente, idDocente, apellidoDocente, emailDocente, idCatedra, nombreCatedra, bedel, fechaRegistro);
        this.tipo = tipo;
        this.diasSemana = diasSemana;
        this.cuatrimestre1 = cuatrimestre1;
        this.cuatrimestre2 = cuatrimestre2;
    }
    
    

    public ReservaPeriodica(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente,
            int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, Bedel bedel, List<DetalleReserva> detallesReserva,
            TipoReservaPeriodica tipo, List<DiaSemana> diasSemana, Cuatrimestre cuatrimestre1, Cuatrimestre cuatrimestre2) {
        super(idReserva, nombreDocente, idDocente, apellidoDocente, emailDocente, idCatedra, nombreCatedra, fechaRegistro, bedel, detallesReserva);
        this.tipo = tipo;
        this.diasSemana = diasSemana;
        this.cuatrimestre1 = cuatrimestre1;
        this.cuatrimestre2 = cuatrimestre2;
    }
    
    

    public Cuatrimestre getCuatrimestre1() {
        return cuatrimestre1;
    }

    public void setCuatrimestre1(Cuatrimestre cuatrimestre1) {
        this.cuatrimestre1 = cuatrimestre1;
    }

    public Cuatrimestre getCuatrimestre2() {
        return cuatrimestre2;
    }

    public void setCuatrimestre2(Cuatrimestre cuatrimestre2) {
        this.cuatrimestre2 = cuatrimestre2;
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
