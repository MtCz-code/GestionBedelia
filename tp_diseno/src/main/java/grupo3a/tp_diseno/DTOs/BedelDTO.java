
package grupo3a.tp_diseno.DTOs;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;

public class BedelDTO extends UsuarioDTO{
    
    private TurnoBedel turno; // Enum: MAÑANA, TARDE, NOCHE
    private boolean habilitado;
    
    public BedelDTO(String idLogin, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
        super(idLogin, contrasena, nombre, apellido);
        this.turno = turno;
        this.habilitado = habilitado;
    }

    public BedelDTO(int idUsuario, String idLogin, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
        super(idUsuario, idLogin, contrasena, nombre, apellido);
        this.turno = turno;
        this.habilitado = habilitado;
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
