/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author gabic
 */
public class DisponibilidadDTO {
    private HashMap<AulaDTO, Integer> aulasDisponibles; // el integer representa la cantidad de solapamiento en modulos. si nno tiene es 0 
    private Boolean solapamiento;
    private Integer cantidadModulosTotales;
    //private List<Integer> modulosSolapamiento;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(HashMap<AulaDTO, Integer> aulasDisponibles, Boolean solapamiento) {
        this.aulasDisponibles = aulasDisponibles;
        this.solapamiento = solapamiento;
    }

    public Integer getCantidadModulosTotales() {
        return cantidadModulosTotales;
    }

    public void setCantidadModulosTotales(Integer cantidadModulosTotales) {
        this.cantidadModulosTotales = cantidadModulosTotales;
    }
    
    public Boolean getSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(Boolean solapamiento) {
        this.solapamiento = solapamiento;
    }

    
    
    public HashMap<AulaDTO, Integer> getAulasDisponibles() {
        return aulasDisponibles;
    }

    public void setAulasDisponibles(HashMap<AulaDTO, Integer> aulasDisponibles) {
        this.aulasDisponibles = aulasDisponibles;
    }

    public boolean isSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(boolean solapamiento) {
        this.solapamiento = solapamiento;
    }
    
    
}
