/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package grupo3a.tp_diseno;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Interfaces.*;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.AulaMultimedios;
import grupo3a.tp_diseno.Modelos.DetalleReserva;

import java.awt.CardLayout;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gabic
 */
public class Tp_diseno {

    public static String[][] convertirFormatoAula(AulaGeneral[] aulas) {
        String[][] str = new String[aulas.length][];

        for (int i = 0; i < aulas.length; i++) {
            // TODO: sacar tipo (solo se debe mostrar la ubicacion creo, verificar) 

            String ubicacion = aulas[i].getTipo().toString() + " " + aulas[i].getUbicacion();
            String capacidad = aulas[i].getCapacidad() + "alumnos";
            String caracteristicas = "pizarron: " + aulas[i].getTipoDePizarron().toString();

            // TODO: agregar ventiladores y eso
            if (aulas[i].getTipo() == TipoAula.GENERAL) {
                // TODO
            } else if (aulas[i].getTipo() == TipoAula.LABORATORIO) {
                caracteristicas += " " + ((AulaLaboratorio) aulas[i]).getCantidadDePCs();
            } else if (aulas[i].getTipo() == TipoAula.MULTIMEDIOS) {
                // TODO
            }

            str[i] = new String[]{ubicacion, capacidad, caracteristicas};

        }
        return str;
    }

    public static void main(String[] args) {

        RegistrarAula registrarAula = new RegistrarAula();
        RegistrarAulaAnualDias registrarAulaAnualDias = new RegistrarAulaAnualDias();
        RegistrarAulaAnualAula registrarAulaAnualAula = new RegistrarAulaAnualAula();
        RegistrarAulaAnualHorarios registrarAulaAnualHorarios = new RegistrarAulaAnualHorarios();
        RegistrarAulaEsporadicaDias registrarAulaEsporadicaDias = new RegistrarAulaEsporadicaDias();
        RegistrarAulaInformacion registrarAulaInformacion = new RegistrarAulaInformacion();

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(registrarAula, "registrarAula");
        mainPanel.add(registrarAulaAnualDias, "registrarAulaAnualDias");
        mainPanel.add(registrarAulaAnualAula, "registrarAulaAnualAula");
        mainPanel.add(registrarAulaAnualHorarios, "registrarAulaAnualHorarios");
        mainPanel.add(registrarAulaEsporadicaDias, "registrarAulaEsporadicaDias");
        mainPanel.add(registrarAulaInformacion, "registrarAulaInformacion");

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

//        boolean[] b = new boolean[]{true, false, false, true, true};
//        registrarAulaAnualHorarios.setDiasHabilitados(b);
//        cardLayout.show(mainPanel, "registrarAulaAnualHorarios");
        cardLayout.show(mainPanel, "registrarAula");

//        String[][] elem = new String[][]{
//                {"Aula Multimedios 3", "50 alumnos", "12 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 2", "10 alumnos", "16 Computadoras"},
//                {"Aula Multimedios 1", "30 alumnos", "10 Computadoras"}
//        };
//        registrarAulaAnualAula.setTable(elem);
        GestorReserva gestorReserva = new GestorReserva();

//        cardLayout.show(mainPanel, "registrarAula");
        registrarAula.setListener(() -> {
            if (registrarAula.getSelected() == RegistrarAula.TIPO_RESERVA.ANUAL) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ANUAL);
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            } else if (registrarAula.getSelected() == RegistrarAula.TIPO_RESERVA.PRIMER_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_PRIMER_CUATRIMESTRE);
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            } else if (registrarAula.getSelected() == RegistrarAula.TIPO_RESERVA.SEGUNDO_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_SEGUNDO_CUATRIMESTRE);
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            } else {  //esporadica
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ESPORADICA);
                cardLayout.show(mainPanel, "registrarAulaEsporadicaDias");
            }
        });

        registrarAulaAnualDias.setListener(new RegistrarAulaAnualDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAula");
            }

            @Override
            public void next() {
                ArrayList<DiaSemana> dias = new ArrayList<>(0);

                if (registrarAulaAnualDias.getDiasSeleccionados()[0]) {
                    dias.add(DiaSemana.LUNES);
                }
                if (registrarAulaAnualDias.getDiasSeleccionados()[1]) {
                    dias.add(DiaSemana.MARTES);
                }
                if (registrarAulaAnualDias.getDiasSeleccionados()[2]) {
                    dias.add(DiaSemana.MIERCOLES);
                }
                if (registrarAulaAnualDias.getDiasSeleccionados()[3]) {
                    dias.add(DiaSemana.JUEVES);
                }
                if (registrarAulaAnualDias.getDiasSeleccionados()[4]) {
                    dias.add(DiaSemana.VIERNES);
                }

                gestorReserva.diasSeleccionados(dias);

                registrarAulaAnualHorarios.setDiasHabilitados(registrarAulaAnualDias.getDiasSeleccionados());
                cardLayout.show(mainPanel, "registrarAulaAnualHorarios");
            }
        });

        registrarAulaAnualHorarios.setListener(new RegistrarAulaAnualHorarios.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAulaAnualDias");
            }

            @Override
            public void next() {

                ArrayList<DetalleReserva> detalle = new ArrayList<>();

                LocalTime[] horarios = registrarAulaAnualHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = registrarAulaAnualHorarios.getDuracionesSeleccionadas();

                if (horarios[0] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.LUNES);
                    tmp.setHorarioInicio(Time.valueOf(horarios[0]));

                    Time time = Time.valueOf(duraciones[0]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[1] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.MARTES);
                    tmp.setHorarioInicio(Time.valueOf(horarios[1]));

                    Time time = Time.valueOf(duraciones[1]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[2] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.MIERCOLES);
                    tmp.setHorarioInicio(Time.valueOf(horarios[2]));

                    Time time = Time.valueOf(duraciones[2]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[3] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.JUEVES);
                    tmp.setHorarioInicio(Time.valueOf(horarios[3]));

                    Time time = Time.valueOf(duraciones[3]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[4] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.VIERNES);
                    tmp.setHorarioInicio(Time.valueOf(horarios[4]));

                    Time time = Time.valueOf(duraciones[4]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }

                gestorReserva.horariosSeleccionados(detalle);

                cardLayout.show(mainPanel, "registrarAulaInformacion");

            }
        });

        registrarAulaInformacion.setListener(new RegistrarAulaInformacion.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAulaAnualHorarios");
            }

            @Override
            public void next() {
                String nombreDocente = registrarAulaInformacion.getNombreDocente();
                String apellidoDocente = registrarAulaInformacion.getApellidoDocente();
                String nombreCatedra = registrarAulaInformacion.getNombreCatedra();
                String correo = registrarAulaInformacion.getCorreo();
                int cantidadAlumnos = registrarAulaInformacion.getCantidadAlumnos();
                TipoAula tipoAula = registrarAulaInformacion.getTipoAula();

                gestorReserva.validarDatos(
                        nombreDocente,
                        apellidoDocente,
                        nombreCatedra,
                        correo,
                        cantidadAlumnos,
                        tipoAula
                );

                AulaGeneral[] aulas = gestorReserva.getAulasDisponibles();
                registrarAulaAnualAula.setTable(convertirFormatoAula(aulas));

                cardLayout.show(mainPanel, "registrarAulaAnualAula");

            }
        });

        registrarAulaAnualAula.setListener(new RegistrarAulaAnualAula.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "registrarAulaInformacion");
            }

            @Override
            public void next() {
                gestorReserva.aulaSeleccionada(registrarAulaAnualAula.getSelectedElementIndex());

                gestorReserva.crearReserva();

                System.err.println("reservado");
                
                // TODO follow
                
                
            }
        });

        // _-----------------------------------------------------------
//        final GestorReserva gestorReserva = new GestorReserva();
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
