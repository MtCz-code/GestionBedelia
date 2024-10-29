
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDate;

public class DetalleReserva {
    private LocalDate horarioInicio;
    private int cantModulos;
    private LocalDate fecha;
    private String diaReserva;

    DetalleReserva(LocalDate horarioInicio,int cantModulos,LocalDate fecha,String diaReserva){
        this.horarioInicio=horarioInicio;
        this.cantModulos=cantModulos;
        this.fecha=fecha;
        this.diaReserva=diaReserva;
    }
    
    public LocalDate getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDate horarioInicio) {
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
