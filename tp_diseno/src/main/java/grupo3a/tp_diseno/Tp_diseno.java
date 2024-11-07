package grupo3a.tp_diseno;

import grupo3a.tp_diseno.Interfaces.RegistrarBedel;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Interfaces.*;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import grupo3a.tp_diseno.Modelos.Exceptions.UIException;
import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

    public static void showReserva() {
        RegistrarAula registrarAula = new RegistrarAula();
        RegistrarAulaAnualDias registrarAulaAnualDias = new RegistrarAulaAnualDias();
        RegistrarAulaAnualAula registrarAulaAnualAula = new RegistrarAulaAnualAula();
        RegistrarAulaAnualHorarios registrarAulaAnualHorarios = new RegistrarAulaAnualHorarios();
        RegistrarAulaEsporadicaDias registrarAulaEsporadicaDias = new RegistrarAulaEsporadicaDias();
        RegistrarAulaInformacion registrarAulaInformacion = new RegistrarAulaInformacion();
        Alerta alerta = new Alerta();

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(registrarAula, "registrarAula");
        mainPanel.add(registrarAulaAnualDias, "registrarAulaAnualDias");
        mainPanel.add(registrarAulaAnualAula, "registrarAulaAnualAula");
        mainPanel.add(registrarAulaAnualHorarios, "registrarAulaAnualHorarios");
        mainPanel.add(registrarAulaEsporadicaDias, "registrarAulaEsporadicaDias");
        mainPanel.add(registrarAulaInformacion, "registrarAulaInformacion");
        mainPanel.add(alerta, "alerta");

        // frame principal
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        cardLayout.show(mainPanel, "registrarAula");
        GestorReserva gestorReserva = new GestorReserva();

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
                cardLayout.show(mainPanel, "registrarAulaAnualDias");

            }
        });
    }

    static RegistrarBedel registrarBedel;
    static Alerta alerta;
    static AlertaConfirmacion alertaConfirmacion;
    static BaseFrame baseFrame;
    static GestorBedel gestorBedel = new GestorBedel();
    static MenuAdmin menuAdmin;

    public static boolean contains(String s, char a, char b) {
        for (int i = a; i <= b; i++) {
            char e = (char) i;
            if (s.contains(String.valueOf(e))) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificar() {

        String nombre = registrarBedel.getNombre();
        String apellido = registrarBedel.getApellido();
        TurnoBedel turno = registrarBedel.getTurno();
        String contraseña = registrarBedel.getContraseña();
        String rContraseña = registrarBedel.getrContraseña();

        System.err.println("nombre: " + nombre);
        System.err.println("apellido: " + apellido);
        System.err.println("turno: " + turno.toString());
        System.err.println("contraseña: " + contraseña);
        System.err.println("rContraseña: " + rContraseña);

        // verificar el nombre
        // borrar espacios al final(si hay)
        nombre = nombre.trim();

        try {
            String regex = "([a-zA-Z])+";
            Pattern pattern = Pattern.compile(regex);
            if (!pattern.matcher(nombre).matches())
                throw new UIException("Introduzca un nombre válido.");

            // apellido
            apellido = apellido.trim();
            if (!pattern.matcher(apellido).matches())
                throw new UIException("Introduzca un apellido válido.");

            // contraseña
            if (contraseña.length() == 0) 
                throw new UIException("Introduzca una contraseña.");
            
            // o Longitud mínima de la contraseña
            int largoMin = 8;
            if (contraseña.length() < largoMin) 
                throw new UIException("<html>La contraseña debe contener al menos <br>" + largoMin + " caracteres.</html>");
                
            // o Si la contraseña debe contener signos especiales (@#$%&*)
            if (!(contraseña.contains("@") || contraseña.contains("#")
                    || contraseña.contains("$") || contraseña.contains("%")
                    || contraseña.contains("*")))
                throw new UIException("<html>La contraseña debe contener <br> caracteres especiales (@#$%&*)</html>");
                
            // o Si la contraseña debe contener al menos una letra mayúscula.
            if (!contains(contraseña, 'A', 'Z')) 
                throw new UIException("<html>La contraseña debe contener <br> al menos una letra mayúscula</html>");
            
            // o Si la contraseña debe contener al menos un dígito.
            if (!contains(contraseña, '0', '9')) 
                throw new UIException("<html>La contraseña debe contener <br>al menos un dígito</html>");
                
            // o Si la contraseña puede ser igual a una contraseña anterior del usuario.
            // TODO:

            // rcontraseña
            if (!contraseña.equals(rContraseña))
                throw new UIException("Las contraseñas no coinciden.");
            
            
            return true;
        } catch (UIException e) {
            alerta.setText(e.getMessage());
            baseFrame.getPanel2().add(alerta);
            baseFrame.setPanel2Up();
            return false;
        }

        // falta verificar bien id y
        // si la contraseña puede ser igual a una contraseña anterior del usuario.
        // nombre, apellido, idbedel, turno, contraseña
        //Bedel bedel = new Bedel(contraseña, nombre, apellido, turno, true);
    }

    public static void showMenu() {
        // frame principal
        baseFrame = new BaseFrame();
        menuAdmin = new MenuAdmin();

        baseFrame.getPanel1().add(menuAdmin);
        baseFrame.getPanel1().setLayout(new BorderLayout());
        baseFrame.getPanel1().add(menuAdmin, BorderLayout.CENTER);
        baseFrame.setVisible(true);

        menuAdmin.setListener(new MenuAdmin.Listener() {
            @Override
            public void registrarBedel() {
                baseFrame.getPanel1().remove(menuAdmin);
                showRegistroBedel();
            }
        });

    }

    public static void showRegistroBedel() {
        registrarBedel = new RegistrarBedel();
        registrarBedel = new RegistrarBedel();
        alerta = new Alerta();
        alertaConfirmacion = new AlertaConfirmacion();

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(registrarBedel, "registrarBedel");

        // frame principal
//        baseFrame = new BaseFrame();
        baseFrame.getPanel1().add(mainPanel);
        baseFrame.revalidate();
        baseFrame.repaint();

        cardLayout.show(mainPanel, "registrarAula");

        registrarBedel.setListener(new RegistrarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea cancelar?");
                baseFrame.getPanel2().add(alertaConfirmacion);
                baseFrame.setPanel2Up();
            }

            @Override
            public void next() {
                if (verificar()) {
                    UsuarioDTO bedel = new UsuarioDTO(
                            registrarBedel.getContraseña(),
                            registrarBedel.getNombre(),
                            registrarBedel.getApellido(),
                            registrarBedel.getTurno(),
                            true
                    );
                    gestorBedel.crear(bedel);

                    alerta.setText("Bedel registrado con éxito");
                    baseFrame.getPanel2().add(alerta);
                    baseFrame.setPanel2Up();
                    alerta.setListener(new Alerta.Listener() {
                        @Override
                        public void next() {
                            baseFrame.getPanel2().remove(alerta);
                            baseFrame.getPanel1().remove(mainPanel);
                            baseFrame.getPanel1().add(menuAdmin);
                            baseFrame.setPanel1Up();
                            baseFrame.revalidate();
                            baseFrame.repaint();
                        }
                    });

                }
            }
        });

        alerta.setListener(() -> {
            baseFrame.setPanel1Up();
            baseFrame.getPanel2().remove(alerta);
        });

        alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
            @Override
            public void back() {
                baseFrame.getPanel2().remove(alertaConfirmacion);
                baseFrame.setPanel1Up();

            }

            @Override
            public void next() {
                baseFrame.getPanel2().remove(alertaConfirmacion);
                baseFrame.getPanel1().remove(mainPanel);
                baseFrame.getPanel1().add(menuAdmin);
                baseFrame.setPanel1Up();
                baseFrame.revalidate();
                baseFrame.repaint();
            }

        });

    }

    public static void main(String[] args) {
//        showRegistroBedel();
        showMenu();

        /*
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

        gestorReserva.aulaSeleccionada(reservaDTO, detalles, aula);*/
    }
}
