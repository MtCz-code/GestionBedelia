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
    private boolean solapamiento;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(List<AulaDTO> aulasDisponibles, boolean solapamiento) {
        this.aulasDisponibles = aulasDisponibles;
        this.solapamiento = solapamiento;
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
