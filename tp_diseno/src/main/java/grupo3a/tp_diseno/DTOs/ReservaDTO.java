/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author gabic
 */
public class ReservaDTO {
    private int idReserva;
    private String nombreDocente;
    private int idDocente;
    private String apellidoDocente;
    private String emailDocente;
    private int idCatedra;
    private String nombreCatedra;
    private LocalDateTime fechaRegistro;
    private int cantidadAlumnos;
    private int idBedel;
    private List<DetalleReservaDTO> detallesReserva;
    private boolean esEsporadica; // FALSO = PERIODICA, VERDADERO = ESPORADICA
    
    // atributos de periodica
    private TipoReservaPeriodica tipo; // Enum: CUATRIMESTRAL, ANUAL
    private List<DiaSemana> diasSemana; // Enum: LUNES, MARTES, etc.
    private int idCuatrimestre1; private int idCuatrimestre2;
    
    

    /*public ReservaDTO(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente,
            int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, int cantidadAlumnos, int idBedel, TipoReservaPeriodica tipo,
            List<DiaSemana> diasSemana, boolean esEsporadica, int idCuatrimestre1, int idCuatrimestre2) {
        this.idReserva = idReserva;
        this.nombreDocente = nombreDocente;
        this.idDocente = idDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.idCatedra = idCatedra;
        this.nombreCatedra = nombreCatedra;
        this.fechaRegistro = fechaRegistro;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idBedel = idBedel;
        this.tipo = tipo;
        this.diasSemana = diasSemana;
        this.esEsporadica = esEsporadica; // 0 == periodica / 1 == esporadica
        this.idCuatrimestre1 = idCuatrimestre1;
        this.idCuatrimestre2 = idCuatrimestre2;
    }*/
    
    

    //CONSTRUCTOR PERIODICA
    public ReservaDTO(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, 
                    String emailDocente, int idCatedra, String nombreCatedra, 
                    LocalDateTime fechaRegistro, int cantidadAlumnos, int idBedel, 
                    TipoReservaPeriodica tipo, List<DiaSemana> diasSemana, 
                    boolean esEsporadica, int idCuatrimestre1, int idCuatrimestre2, 
                    List<DetalleReservaDTO> detallesReserva) {
        this.idReserva = idReserva;
        this.nombreDocente = nombreDocente;
        this.idDocente = idDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.idCatedra = idCatedra;
        this.nombreCatedra = nombreCatedra;
        this.fechaRegistro = fechaRegistro;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idBedel = idBedel;
        this.tipo = tipo;
        this.diasSemana = diasSemana;
        this.esEsporadica = esEsporadica;
        this.idCuatrimestre1 = idCuatrimestre1;
        this.idCuatrimestre2 = idCuatrimestre2;
        this.detallesReserva = detallesReserva;
    }

    // CONSTRUCTOR ESPORADICA
    public ReservaDTO(int idReserva, String nombreDocente, int idDocente, String apellidoDocente, String emailDocente, int idCatedra, String nombreCatedra, LocalDateTime fechaRegistro, int cantidadAlumnos, int idBedel, List<DetalleReservaDTO> detallesReserva, boolean esEsporadica) {
        this.idReserva = idReserva;
        this.nombreDocente = nombreDocente;
        this.idDocente = idDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.idCatedra = idCatedra;
        this.nombreCatedra = nombreCatedra;
        this.fechaRegistro = fechaRegistro;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idBedel = idBedel;
        this.detallesReserva = detallesReserva;
        this.esEsporadica = esEsporadica;
    }
    
    


    public List<DetalleReservaDTO> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<DetalleReservaDTO> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    
    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    public void setDiasSemana(List<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public List<DiaSemana> getDiasSemana() {
        return diasSemana;
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

    public int getIdBedel() {
        return idBedel;
    }

    public void setIdBedel(int idBedel) {
        this.idBedel = idBedel;
    }

    public TipoReservaPeriodica getTipo() {
        return tipo;
    }

    public void setTipo(TipoReservaPeriodica tipo) {
        this.tipo = tipo;
    }

    public boolean isEsEsporadica() {
        return esEsporadica;
    }

    public void setEsEsporadica(boolean esEsporadica) {
        this.esEsporadica = esEsporadica;
    }

    public int getIdCuatrimestre1() {
        return idCuatrimestre1;
    }

    public void setIdCuatrimestre1(int idCuatrimestre1) {
        this.idCuatrimestre1 = idCuatrimestre1;
    }

    public int getIdCuatrimestre2() {
        return idCuatrimestre2;
    }

    public void setIdCuatrimestre2(int idCuatrimestre2) {
        this.idCuatrimestre2 = idCuatrimestre2;
    }
    
    
    
}
