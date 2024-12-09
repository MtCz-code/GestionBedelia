
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
    private int idReserva;
    private String nombreDocente;
    private int idDocente;
    private String apellidoDocente;
    private String emailDocente;
    private int idCatedra;
    private String nombreCatedra;
    private LocalDateTime fechaRegistro;
    private int idBedel;
    private List<DetalleReserva> detallesReserva;
    
    public Reserva(){
    
    }
    
    public Reserva(String nombreDocente,int idDocente,String apellidoDocente,String emailDocente,
            int idCatedra,String nombreCatedra, int idBedel ,LocalDateTime fechaRegistro){
        this.nombreDocente=nombreDocente;
        this.idDocente=idDocente;
        this.apellidoDocente=apellidoDocente;
        this.emailDocente=emailDocente;
        this.idCatedra=idCatedra;
        this.nombreCatedra=nombreCatedra;
        this.idBedel = idBedel;
        this.fechaRegistro=fechaRegistro;
    }

    public Reserva(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente, int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, int idBedel, List<DetalleReserva> detallesReserva) {
        this.idReserva = idReserva;
        this.nombreDocente = nombreDocente;
        this.idDocente = idDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.idCatedra = idCatedra;
        this.nombreCatedra = nombreCatedra;
        this.fechaRegistro = fechaRegistro;
        this.idBedel = idBedel;
        this.detallesReserva = detallesReserva;
    }
    
    

    public List<DetalleReserva> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<DetalleReserva> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdBedel() {
        return idBedel;
    }

    public void setIdBedel(int idBedel) {
        this.idBedel = idBedel;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getEmailDocente() {
        return emailDocente;
    }

    public void setEmailDocente(String emailDocente) {
        this.emailDocente = emailDocente;
    }

    public int getIdCatedra() {
        return idCatedra;
    }

    public void setIdCatedra(int idCatedra) {
        this.idCatedra = idCatedra;
    }

    public String getNombreCatedra() {
        return nombreCatedra;
    }

    public void setNombreCatedra(String nombreCatedra) {
        this.nombreCatedra = nombreCatedra;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
