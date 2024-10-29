
package grupo3a.tp_diseno.Modelos;

public class Usuario {
    private int idUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;

    Usuario(String contrasena,String nombre, String apellido){
        this.contrasena=contrasena;
        this.nombre=nombre;
        this.apellido=apellido;
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
