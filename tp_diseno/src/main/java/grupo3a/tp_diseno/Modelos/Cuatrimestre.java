
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDate;

public class Cuatrimestre {
    private int idCuatrimestre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Cuatrimestre(){}
    public Cuatrimestre(LocalDate fechaInicio,LocalDate fechaFin){
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }
    public Cuatrimestre(int id, LocalDate fechaInicioCuatrimestre,LocalDate fechaFinCuatrimestre){
        this.idCuatrimestre=id;
        this.fechaInicioCuatrimestre=fechaInicioCuatrimestre;
        this.fechaFinCuatrimestre=fechaFinCuatrimestre;
    }
    
    public int getIdCuatrimestre() {
        return idCuatrimestre;
    }

    public void setIdCuatrimestre(int idCuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
