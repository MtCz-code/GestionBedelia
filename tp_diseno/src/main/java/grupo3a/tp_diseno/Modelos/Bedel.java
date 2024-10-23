/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;
import grupo3a.tp_diseno.Enumerations.*;
/**
 *
 * @author gabic
 */
public class Bedel extends Usuario{
    private String idBedel;
    private TurnoBedel turno; // Enum: MAÑANA, TARDE, NOCHE
    private boolean habilitado;

    public String getIdBedel() {
        return idBedel;
    }

    public void setIdBedel(String idBedel) {
        this.idBedel = idBedel;
    }

    public TurnoBedel getTurno() {
        return turno;
    }

    public void setTurno(TurnoBedel turno) {
        this.turno = turno;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
