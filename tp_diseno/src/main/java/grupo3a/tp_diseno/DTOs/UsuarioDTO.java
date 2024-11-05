/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;

/**
 *
 * @author gabic
 */
public class UsuarioDTO {
    private int idUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private TurnoBedel turno; // Enum: MAÑANA, TARDE, NOCHE
    private boolean habilitado;

    public UsuarioDTO(int idUsuario, String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turno = turno;
        this.habilitado = habilitado;
    }
    
    public UsuarioDTO(String contrasena, String nombre, String apellido, TurnoBedel turno, boolean habilitado) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turno = turno;
        this.habilitado = habilitado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
