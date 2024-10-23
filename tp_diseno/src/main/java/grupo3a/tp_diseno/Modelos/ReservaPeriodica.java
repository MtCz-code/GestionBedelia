/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.*;
import java.util.List;

/**
 *
 * @author gabic
 */
public class ReservaPeriodica extends Reserva{
    private TipoReservaPeriodica tipo; // Enum: CUATRIMESTRAL, ANUAL
    private List<DiaSemana> diasSemana; // Enum: LUNES, MARTES, etc.

    public TipoReservaPeriodica getTipo() {
        return tipo;
    }

    public void setTipo(TipoReservaPeriodica tipo) {
        this.tipo = tipo;
    }

    public List<DiaSemana> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }
    
}
