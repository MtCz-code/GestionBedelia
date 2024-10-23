/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

import java.time.LocalDate;

/**
 *
 * @author gabic
 */
public class DetalleReserva {
    private LocalDate horarioInicio;
    private int cantModulos;
    private LocalDate fecha;
    private String diaReserva;

    public LocalDate getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDate horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getCantModulos() {
        return cantModulos;
    }

    public void setCantModulos(int cantModulos) {
        this.cantModulos = cantModulos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }
    
    
}
