/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.CuatrimestreDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabic
 */
public class PruebaFlujoReserva {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorReserva gestorReserva = GestorReserva.getInstance();
        List<CuatrimestreDTO> cuatrimestresActuales = null;
        
        try {
            cuatrimestresActuales = gestorReserva.recuperarCuatrimestres();
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<DiaSemana> diasSemana = Arrays.asList(DiaSemana.LUNES, DiaSemana.MARTES);
        List<Time> horariosInicio = Arrays.asList(Time.valueOf("09:00:00"), Time.valueOf("09:00:00"));
        List<Integer> cantModulos = Arrays.asList(2, 3);
        
        List<DetalleReservaDTO> dr = gestorReserva.generarDetallesReserva(cuatrimestresActuales, diasSemana, horariosInicio, cantModulos);
        
        for(DetalleReservaDTO d : dr){
            System.out.println("Fecha: " + d.getFecha() + " - Horario Inicio: " + d.getHorarioInicio() + " - CANT MODULOS: " + d.getCantModulos() + " Dia Semana: " + d.getDiaReserva());
        }
        
        try {
            gestorReserva.validarDias(dr, cuatrimestresActuales);
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pruebaRecuperarCuatrimestreValidarDiasYGenerarDR(){
        
        GestorReserva gestorReserva = GestorReserva.getInstance();
        List<CuatrimestreDTO> cuatrimestresActuales = null;
        
        try {
            cuatrimestresActuales = gestorReserva.recuperarCuatrimestres();
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<DiaSemana> diasSemana = Arrays.asList(DiaSemana.LUNES, DiaSemana.MARTES);
        List<Time> horariosInicio = Arrays.asList(Time.valueOf("09:00:00"), Time.valueOf("09:00:00"));
        List<Integer> cantModulos = Arrays.asList(2, 3);
        
        List<DetalleReservaDTO> dr = gestorReserva.generarDetallesReserva(cuatrimestresActuales, diasSemana, horariosInicio, cantModulos);
        
        for(DetalleReservaDTO d : dr){
            System.out.println("Fecha: " + d.getFecha() + " - Horario Inicio: " + d.getHorarioInicio() + " - CANT MODULOS: " + d.getCantModulos() + " Dia Semana: " + d.getDiaReserva());
        }
        
        try {
            gestorReserva.validarDias(dr, cuatrimestresActuales);
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
    }    
    
    public void pruebaObtenerAulasDisponibles(){

        GestorReserva gestorReserva = GestorReserva.getInstance();
    List<DetalleReservaDTO> dr = Arrays.asList(
            new DetalleReservaDTO(0,
                    Time.valueOf("09:00:00"), // Horario de inicio
                    6,
                    LocalDate.of(2024, 1, 10), // Fecha de la reserva// Cantidad de módulos (1 módulo = 30 minutos)
                    DiaSemana.LUNES, // Día de la semana
                    0 // ID del aula (será determinado por disponibilidad)
            )
    );

    // nueva reserva esporadica
    ReservaDTO nuevaReserva = new ReservaDTO(0, "Exe", 103, "Sandriarda", "kuka@kuk-12.com", 1, "intro al lol",
            null, 20, 1, dr, true);

// Llamar al método para obtener las aulas disponibles
    TipoAula tipoAula = TipoAula.GENERAL; // Aulas generales
    
    
    DisponibilidadDTO disponibilidad = null;
        try {
            disponibilidad = gestorReserva.validarDatosYObtenerAulas(nuevaReserva, tipoAula);
        } catch (Exceptions.ValueException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exceptions.NoExisteAulaException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(disponibilidad == null){
            System.out.println("disponibilidad es nulo");
            return;
        }
        
        System.out.println(disponibilidad.getAulasDisponibles().size());
        
        if (!disponibilidad.getSolapamiento()) {
            for (Map.Entry<AulaDTO, Integer> entry : disponibilidad.getAulasDisponibles().entrySet()) {
                AulaDTO aulaDisponible = entry.getKey();

                System.out.println("Aula disponible: " + aulaDisponible.getUbicacion());
            }
        } else {
            for (Map.Entry<AulaDTO, Integer> entry : disponibilidad.getAulasDisponibles()
                    .entrySet()) {
                AulaDTO aulaDisponible = entry.getKey();
                Integer solapamiento = entry.getValue();
                System.out.println("Aula disponible con solapamiento: " + aulaDisponible.getUbicacion() + ", Solapamiento: " + solapamiento);
            }
        }
        
        
        for(DetalleReservaDTO dr1 : nuevaReserva.getDetallesReserva()){
            dr1.setIdAula(1);
        }
        
        int reservaCreada = 0;
        try {
            reservaCreada = gestorReserva.crearReserva(nuevaReserva);
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("reserva creada con id = " + reservaCreada);
    }
    
    public void pruebaCrearReserva(){

        GestorReserva gestorReserva = GestorReserva.getInstance();
    List<DetalleReservaDTO> dr = Arrays.asList(
            new DetalleReservaDTO(0,
                    Time.valueOf("09:00:00"), // Horario de inicio
                    6,
                    LocalDate.of(2024, 1, 10), // Fecha de la reserva// Cantidad de módulos (1 módulo = 30 minutos)
                    DiaSemana.LUNES, // Día de la semana
                    0 // ID del aula (será determinado por disponibilidad)
            )
    );

    // nueva reserva esporadica
    ReservaDTO nuevaReserva = new ReservaDTO(0, "Exe", 103, "Sandriarda", "kuka@kuk-12.com", 1, "intro al lol",
            null, 20, 1, dr, true);

 
        for(DetalleReservaDTO dr1 : nuevaReserva.getDetallesReserva()){
            dr1.setIdAula(1); // un aula cualquiera, solo para probar
        }
        
        int reservaCreada = 0;
        try {
            reservaCreada = gestorReserva.crearReserva(nuevaReserva);
        } catch (Exceptions.DAOException ex) {
            Logger.getLogger(PruebaFlujoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("reserva creada con id = " + reservaCreada);
    }
}
