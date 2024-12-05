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
    private String idLogin;
    private String contrasena;
    private String nombre;
    private String apellido;
    

    public UsuarioDTO(String idLogin, String contrasena, String nombre, String apellido) {
        this.idUsuario = 0;
        this.idLogin = idLogin;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public UsuarioDTO(int idUsuario, String idLogin, String contrasena, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.idLogin = idLogin;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public UsuarioDTO(int id, String nombre, String apellido){
        this.idUsuario=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    
}
