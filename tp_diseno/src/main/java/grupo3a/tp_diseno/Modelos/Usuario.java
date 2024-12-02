/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

/**
 *
 * @author gabic
 */
public class Usuario {
    private int idUsuario;
    private String idLogin;
    private String contrasena;
    private String nombre;
    private String apellido;


    public Usuario(){}
    public Usuario(String idLogin, String contrasena,String nombre, String apellido){
        this.idLogin=idLogin;
        this.contrasena=contrasena;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public Usuario(Integer id,String nombre, String apellido){
        this.idUsuario=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
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
