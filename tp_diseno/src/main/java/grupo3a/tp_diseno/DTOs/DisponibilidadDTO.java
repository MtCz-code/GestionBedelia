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
    private List<AulaDTO> aulasDisponibles; // el integer representa la cantidad de solapamiento en modulos. si nno tiene es 0 
    private Boolean solapamiento;
    private List<ReservaDTO> reservasSolapadas;
    
    //private List<Integer> modulosSolapamiento;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(List<AulaDTO> aulasDisponibles, Boolean solapamiento) {
        this.aulasDisponibles = aulasDisponibles;
        this.solapamiento = solapamiento;
    }

    public DisponibilidadDTO(Boolean solapamiento, List<ReservaDTO> reservasSolapadas) {
        this.solapamiento = solapamiento;
        this.reservasSolapadas = reservasSolapadas;
    }

    public List<AulaDTO> getAulasDisponibles() {
        return aulasDisponibles;
    }

    public void setAulasDisponibles(List<AulaDTO> aulasDisponibles) {
        this.aulasDisponibles = aulasDisponibles;
    }

    public Boolean getSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(Boolean solapamiento) {
        this.solapamiento = solapamiento;
    }

    public List<ReservaDTO> getReservasSolapadas() {
        return reservasSolapadas;
    }

    public void setReservasSolapadas(List<ReservaDTO> reservasSolapadas) {
        this.reservasSolapadas = reservasSolapadas;
    }
    
    
    
    
}
