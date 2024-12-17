/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gabic
 */
public class DisponibilidadDTO {
    private HashMap<Integer, AulaDTO> aulasDisponibles;
    private Boolean solapamiento;
    private List<DetalleReservaDTO> drSolapados;
    private HashMap<Integer, ReservaDTO> reservasSolapadas;
    
    //private List<Integer> modulosSolapamiento;

    public DisponibilidadDTO() {
    }
    
    public HashMap<Integer, AulaDTO> getAulasDisponibles() {
        return aulasDisponibles;
    }

    public void setAulasDisponibles(HashMap<Integer, AulaDTO> aulasDisponibles) {
        this.aulasDisponibles = aulasDisponibles;
    }

    public Boolean getSolapamiento() {
        return solapamiento;
    }

    public void setSolapamiento(Boolean solapamiento) {
        this.solapamiento = solapamiento;
    }

    public List<DetalleReservaDTO> getDrSolapados() {
        return drSolapados;
    }

    public void setDrSolapados(List<DetalleReservaDTO> drSolapados) {
        this.drSolapados = drSolapados;
    }

    public HashMap<Integer, ReservaDTO> getReservasSolapadas() {
        return reservasSolapadas;
    }

    public void setReservasSolapadas(HashMap<Integer, ReservaDTO> reservasSolapadas) {
        this.reservasSolapadas = reservasSolapadas;
    }

  
    
    
    
}
