
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDate;

public class Cuatrimestre {
    private int idCuatrimestre;
    private LocalDate fechaInicioCuatrimestre;
    private LocalDate fechaFinCuatrimestre;

    Cuatrimestre(){}
    Cuatrimestre(LocalDate fechaInicioCuatrimestre,LocalDate fechaFinCuatrimestre){
        this.fechaInicioCuatrimestre=fechaInicioCuatrimestre;
        this.fechaFinCuatrimestre=fechaFinCuatrimestre;
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

    public LocalDate getFechaInicioCuatrimestre() {
        return fechaInicioCuatrimestre;
    }

    public void setFechaInicioCuatrimestre(LocalDate fechaInicioCuatrimestre) {
        this.fechaInicioCuatrimestre = fechaInicioCuatrimestre;
    }

    public LocalDate getFechaFinCuatrimestre() {
        return fechaFinCuatrimestre;
    }

    public void setFechaFinCuatrimestre(LocalDate fechaFinCuatrimestre) {
        this.fechaFinCuatrimestre = fechaFinCuatrimestre;
    }
    
}
