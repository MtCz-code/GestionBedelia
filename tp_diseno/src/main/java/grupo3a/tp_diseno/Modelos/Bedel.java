
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;


public class Bedel extends Usuario{
    private TurnoBedel turno; // Enum: MAÑANA, TARDE, NOCHE
    private boolean habilitado;

    public Bedel(){}
    public Bedel(String idLogin, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado){
        super(idLogin, contrasena,nombre,apellido);
        this.turno=turno;
        this.habilitado=habilitado;
    }
    
    public Bedel(int id, String nombre, String apellido, TurnoBedel turno, boolean habilitado){
        super(id,nombre,apellido);
        this.turno=turno;
        this.habilitado=habilitado;
    }
    
    public Bedel(int id,String id_login, String nombre, String apellido, TurnoBedel turno, boolean habilitado){
        super(id,id_login,nombre,apellido);
        this.turno=turno;
        this.habilitado=habilitado;
    }

    public Bedel(int idUsuario, String idLogin, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
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
