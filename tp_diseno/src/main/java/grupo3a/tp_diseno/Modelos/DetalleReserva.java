
package grupo3a.tp_diseno.Modelos;

import java.sql.Time;
import java.time.LocalDate;

public class DetalleReserva {
    private int idReserva;
    private Time horarioInicio;
    private int cantModulos;
    private LocalDate fecha;
    private String diaReserva;
    private int idAula;
    
    public DetalleReserva(){}
    public DetalleReserva(int idReserva, Time horarioInicio,int cantModulos,LocalDate fecha,String diaReserva, int idAula){
        this.idReserva = idReserva;
        this.horarioInicio=horarioInicio;
        this.cantModulos=cantModulos;
        this.fecha=fecha;
        this.diaReserva=diaReserva;
        this.idAula = idAula;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getCantModulos() {
        return cantModulos;
    }

    public void setCantModulos(int cantModulos) {
        this.cantModulos = cantModulos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }
    
    
}
