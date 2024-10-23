/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDate;

/**
 *
 * @author gabic
 */
public class Cuatrimestre {
    private int idCuatrimestre;
    private LocalDate fechaInicioCuatrimestre;
    private LocalDate fechaFinCuatrimestre;

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
