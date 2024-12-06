/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import java.time.LocalDate;

/**
 *
 * @author gabic
 */
public class CuatrimestreDTO {
    private int idCuatrimestre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public CuatrimestreDTO(int idCuatrimestre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idCuatrimestre = idCuatrimestre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
