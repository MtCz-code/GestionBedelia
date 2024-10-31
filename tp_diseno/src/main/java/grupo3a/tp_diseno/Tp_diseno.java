/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DAOs.Clases_sql.ReservaSqlDAO;
import grupo3a.tp_diseno.DAOs.Clases_sql.UsuarioSqlDAO;
import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Interfaces.*;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.Modelos.Reserva;
import grupo3a.tp_diseno.Modelos.Usuario;
import java.awt.CardLayout;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author gabic
 */
public class Tp_diseno {

    public static void main(String[] args) {

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                RegistrarAula registrar = new RegistrarAula();
//                
//                registrar.setVisible(true);
//                
//
//            }
//        });
        RegistrarAula registrarAula = new RegistrarAula();
        RegistrarAulaAnualDias registrarAulaAnualDias = new RegistrarAulaAnualDias();
        RegistrarAulaAnualAula registrarAulaAnualAula = new RegistrarAulaAnualAula();
        RegistrarAulaAnualHorarios registrarAulaAnualHorarios = new RegistrarAulaAnualHorarios();
        RegistrarAulaEsporadicaDias registrarAulaEsporadicaDias = new RegistrarAulaEsporadicaDias();
        
        
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(registrarAula, "registrarAula");
        mainPanel.add(registrarAulaAnualDias, "registrarAulaAnualDias");
        mainPanel.add(registrarAulaAnualAula, "registrarAulaAnualAula");
        mainPanel.add(registrarAulaAnualHorarios, "registrarAulaAnualHorarios");
        mainPanel.add(registrarAulaEsporadicaDias, "registrarAulaEsporadicaDias");
        
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        
//        boolean[] b = new boolean[]{true, false, false, true, true};
//        registrarAulaAnualHorarios.setDiasHabilitados(b);
//        cardLayout.show(mainPanel, "registrarAulaAnualHorarios");

        cardLayout.show(mainPanel, "registrarAulaAnualAula");
        
        String[][] elem = new String[][]{
                {"Aula Multimedios 3", "50 alumnos", "12 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
                {"Aula Multimedios 1", "30 alumnos", "10 Computadoras"}
        };
        registrarAulaAnualAula.setTable(elem);
//        cardLayout.show(mainPanel, "registrarAula");
        
        
        registrarAula.setListener(() -> {
            if(registrarAula.getSelected() == RegistrarAula.TIPO_RESERVA.ESPORADICA) {
                cardLayout.show(mainPanel, "registrarAulaEsporadicaDias");
            }
            else {
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            }
        });
        
        registrarAulaAnualDias.setListener(new RegistrarAulaAnualDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAula");
            }

            @Override
            public void next() {
                cardLayout.show(mainPanel, "registrarAulaAnualHorarios");
                registrarAulaAnualHorarios.setDiasHabilitados(registrarAulaAnualDias.getDiasSeleccionados());
                System.out.print("dias seleccionados: ");
                if(registrarAulaAnualDias.getDiasSeleccionados()[0])
                    System.out.print("lunes ");
                if(registrarAulaAnualDias.getDiasSeleccionados()[1])
                    System.out.print("martes ");
                if(registrarAulaAnualDias.getDiasSeleccionados()[2])
                    System.out.print("miercoles ");
                if(registrarAulaAnualDias.getDiasSeleccionados()[3])
                    System.out.print("jueves ");
                if(registrarAulaAnualDias.getDiasSeleccionados()[4])
                    System.out.print("viernes ");
                System.out.println();

            }
            
        });
        
        registrarAulaAnualHorarios.setListener(new RegistrarAulaAnualHorarios.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            }

            @Override
            public void next() {
                System.err.println("lunes:" + registrarAulaAnualHorarios.getHorariosSeleccionados()[0] + " " + 
                registrarAulaAnualHorarios.getDuracionesSeleccionadas()[0]);

                System.err.println("martes:" + registrarAulaAnualHorarios.getHorariosSeleccionados()[1] + " " +
                registrarAulaAnualHorarios.getDuracionesSeleccionadas()[1]);

                System.err.println("miercoles:" + registrarAulaAnualHorarios.getHorariosSeleccionados()[2] + " " +
                registrarAulaAnualHorarios.getDuracionesSeleccionadas()[2]);

                System.err.println("jueves:" + registrarAulaAnualHorarios.getHorariosSeleccionados()[3] + " " +
                registrarAulaAnualHorarios.getDuracionesSeleccionadas()[3]);

                System.err.println("viernes:" + registrarAulaAnualHorarios.getHorariosSeleccionados()[4] + " " +
                registrarAulaAnualHorarios.getDuracionesSeleccionadas()[4]);
                
                cardLayout.show(mainPanel, "registrarAulaAnualAula");
                
            }
        });
        
        registrarAulaAnualAula.setListener(new RegistrarAulaAnualAula.Listener(){
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAulaAnualHorarios");
            }

            @Override
            public void next() {
                String[] elementoSeleccionado = registrarAulaAnualAula.getSelectedElement();
                System.err.println("elemento seleccionado[" + 
                registrarAulaAnualAula.getSelectedElementIndex() +
                "]: " + elementoSeleccionado[0] + ", " + 
                elementoSeleccionado[1] + ", " + elementoSeleccionado[2]);

            }
        });
        
        
        
        final GestorReserva gestorReserva = new GestorReserva();

        TipoReservaPeriodica tipor = TipoReservaPeriodica.ANUAL;
        ArrayList<DiaSemana> dias = new ArrayList<>();

        dias.add(DiaSemana.MIERCOLES);
        dias.add(DiaSemana.MARTES);

        ReservaDTO reservaDTO = new ReservaDTO(0, "Carlos", 6, "Alcaraz", "a@a.com", 4, "Algoritmos", LocalDateTime.now(), 1, tipor, dias, false, 5, 6);

        ArrayList<DetalleReservaDTO> detalles = new ArrayList<>();

        LocalTime horaEspecifica = LocalTime.of(17, 0);
        Time tiempo = Time.valueOf(horaEspecifica);

        detalles.add(new DetalleReservaDTO(1, tiempo, 2, LocalDate.of(2024, 04, 07), "Miercoles", 0));

        LocalTime horaEspecifica1 = LocalTime.of(13, 0);
        Time tiempo1 = Time.valueOf(horaEspecifica1);

        detalles.add(new DetalleReservaDTO(1, tiempo1, 4, LocalDate.of(2024, 11, 06), "Martes", 0));

        AulaDTO aula = new AulaDTO(1);

        gestorReserva.aulaSeleccionada(reservaDTO, detalles, aula);

    }
}
