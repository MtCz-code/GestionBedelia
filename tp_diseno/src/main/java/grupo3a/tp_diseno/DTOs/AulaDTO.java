/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DTOs;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;

/**
 *
 * @author gabic
 */
public class AulaDTO {

    private int idAula;
    private TipoAula tipo; // Enum: GENERAL, MULTIMEDIOS, LABORATORIO
    private String ubicacion;
    private boolean estado;     // ??
    private int capacidad;
    private int piso;
    private TipoPizarron tipoDePizarron; // Enum: TIZA, FIBRÓN
    private boolean ventiladores;
    private boolean aireAcondicionado;
    private boolean habilitado;
    private int cantidadDePCs;
    private boolean televisor;
    private boolean canon;
    private boolean computadora;

    public AulaDTO(int idAula, TipoAula tipo, String ubicacion, boolean estado, int capacidad, int piso, TipoPizarron tipoDePizarron, boolean ventiladores, boolean aireAcondicionado, boolean habilitado, int cantidadDePCs, boolean televisor, boolean canon, boolean computadora) {
        this.idAula = idAula;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.capacidad = capacidad;
        this.piso = piso;
        this.tipoDePizarron = tipoDePizarron;
        this.ventiladores = ventiladores;
        this.aireAcondicionado = aireAcondicionado;
        this.habilitado = habilitado;
        this.cantidadDePCs = cantidadDePCs;
        this.televisor = televisor;
        this.canon = canon;
        this.computadora = computadora;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public TipoAula getTipo() {
        return tipo;
    }

    public void setTipo(TipoAula tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoPizarron getTipoDePizarron() {
        return tipoDePizarron;
    }

    public void setTipoDePizarron(TipoPizarron tipoDePizarron) {
        this.tipoDePizarron = tipoDePizarron;
    }

    public boolean isVentiladores() {
        return ventiladores;
    }

    public void setVentiladores(boolean ventiladores) {
        this.ventiladores = ventiladores;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getCantidadDePCs() {
        return cantidadDePCs;
    }

    public void setCantidadDePCs(int cantidadDePCs) {
        this.cantidadDePCs = cantidadDePCs;
    }

    public boolean isTelevisor() {
        return televisor;
    }

    public void setTelevisor(boolean televisor) {
        this.televisor = televisor;
    }

    public boolean isCanon() {
        return canon;
    }

    public void setCanon(boolean canon) {
        this.canon = canon;
    }

    public boolean isComputadora() {
        return computadora;
    }

    public void setComputadora(boolean computadora) {
        this.computadora = computadora;
    }
    
    
    
}
