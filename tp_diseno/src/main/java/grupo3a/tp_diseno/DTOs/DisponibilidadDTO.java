/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import java.util.List;

/**
 *
 * @author gabic
 */
public class DisponibilidadDTO {
    private List<AulaDTO> aulasDisponibles; 
    private Boolean solapamiento;
    private List<Integer> modulosSolapamiento;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(List<AulaDTO> aulasDisponibles, Boolean solapamiento) {
        this.aulasDisponibles = aulasDisponibles;
        this.solapamiento = solapamiento;
    }

    public DisponibilidadDTO(List<AulaDTO> aulasDisponibles, Boolean solapamiento, List<Integer> modulosSolapamiento) {
        this.aulasDisponibles = aulasDisponibles;
        this.solapamiento = solapamiento;
        this.modulosSolapamiento = modulosSolapamiento;
    }

    public Boolean getSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(Boolean solapamiento) {
        this.solapamiento = solapamiento;
    }

    public List<Integer> getModulosSolapamiento() {
        return modulosSolapamiento;
    }

    public void setModulosSolapamiento(List<Integer> modulosSolapamiento) {
        this.modulosSolapamiento = modulosSolapamiento;
    }
    
    

    
    public List<AulaDTO> getAulasDisponibles() {
        return aulasDisponibles;
    }

    public void setAulasDisponibles(List<AulaDTO> aulasDisponibles) {
        this.aulasDisponibles = aulasDisponibles;
    }

    public boolean isSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(boolean solapamiento) {
        this.solapamiento = solapamiento;
    }
    
    
}
