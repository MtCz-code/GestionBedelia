package grupo3a.tp_diseno.Vista;

import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.EsporadicaDias;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Gestores.GestorLogin;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Vista.Administrador.BuscarBedel;
import grupo3a.tp_diseno.Vista.Administrador.MenuAdmin;
import grupo3a.tp_diseno.Vista.Administrador.RegistrarBedel;
import grupo3a.tp_diseno.Vista.Administrador.ResultadosBusquedaBedel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import grupo3a.tp_diseno.Vista.Bedel.MenuBedel;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.RegistrarReservaDatos;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.ResultadosAulas;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.SeleccionTipoReserva;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaDias;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaHorarios;
import grupo3a.tp_diseno.Vista.Login.InicioSesion;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Vista.Utilidades.FuncionInterface.Fun;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Time;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPanel;

public class Interfaz {

    // singleton
    private static Interfaz interfazInstance;

    public static Interfaz getInstance() {
        if (interfazInstance == null) {
            interfazInstance = new Interfaz();
        }
        return interfazInstance;
    }

    // clase
    // pantalla auxiliar que se usa para poder presentar alertas
    private BaseFrame baseFrame;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // paneles generales de alerta y confirmacion
    private Alerta alerta;
    private AlertaConfirmacion alertaConfirmacion;
    private CardLayout alertaCardLayout;
    private JPanel alertaPanel;

    private InicioSesion login;
    private MenuAdmin menuAdmin;
    private MenuBedel menuBedel;
    private BuscarBedel buscarBedel;
    private ResultadosBusquedaBedel resultadosBusquedaBedel;
    private RegistrarBedel registrarBedel;

    // Reserva
    private SeleccionTipoReserva regRsvaSeleccionTipoReserva = new SeleccionTipoReserva();
    private TipoPeriodicaDias regRsvaTipoPeriodicaDias = new TipoPeriodicaDias();
    private TipoPeriodicaHorarios regRsvaPeriodicaHorarios = new TipoPeriodicaHorarios();
    private RegistrarReservaDatos regRsvaDatos = new RegistrarReservaDatos();
    private ResultadosAulas regRsvaAula = new ResultadosAulas();
    private EsporadicaDias regAulaEsporadicaDias = new EsporadicaDias();

    // gestores
    private GestorBedel gestorBedel = GestorBedel.getInstance();
    private GestorLogin gestorLogin = GestorLogin.getInstance();
    private GestorReserva gestorReserva = GestorReserva.getInstance();

    public Interfaz() {
        baseFrame = new BaseFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        baseFrame.setResizable(true);
        baseFrame.getPanel1().setLayout(new BorderLayout());
        baseFrame.getPanel1().add(mainPanel, BorderLayout.CENTER);

        // alertas
        alertaCardLayout = new CardLayout();
        alertaPanel = new JPanel(alertaCardLayout);
        alertaPanel.setOpaque(false);
        baseFrame.getPanel2().setLayout(new BorderLayout());
        baseFrame.getPanel2().add(alertaPanel);
        alerta = new Alerta();
        alertaConfirmacion = new AlertaConfirmacion();
        alertaPanel.add(alerta, "alerta");
        alertaPanel.add(alertaConfirmacion, "alertaConfirmacion");

        baseFrame.setLocationRelativeTo(null);
        baseFrame.setVisible(true);

        login = new InicioSesion();
        menuAdmin = new MenuAdmin();
        menuBedel = new MenuBedel();
        buscarBedel = new BuscarBedel();
        resultadosBusquedaBedel = new ResultadosBusquedaBedel();
        registrarBedel = new RegistrarBedel();

        // Reserva
        regRsvaSeleccionTipoReserva = new SeleccionTipoReserva();
        regRsvaTipoPeriodicaDias = new TipoPeriodicaDias();
        regRsvaPeriodicaHorarios = new TipoPeriodicaHorarios();
        regRsvaDatos = new RegistrarReservaDatos();
        regRsvaAula = new ResultadosAulas();
        regAulaEsporadicaDias = new EsporadicaDias();

        mainPanel.add(login, "login");
        mainPanel.add(menuAdmin, "menuAdmin");
        mainPanel.add(menuBedel, "menuBedel");
        mainPanel.add(buscarBedel, "buscarBedel");
        mainPanel.add(resultadosBusquedaBedel, "resultadosBusquedaBedel");
        mainPanel.add(registrarBedel, "registrarBedel");
        // reserva
        mainPanel.add(regRsvaSeleccionTipoReserva, "regRsvaSeleccionTipoReserva");
        mainPanel.add(regRsvaTipoPeriodicaDias, "regRsvaTipoPeriodicaDias");
        mainPanel.add(regRsvaPeriodicaHorarios, "regRsvaPeriodicaHorarios");
        mainPanel.add(regRsvaDatos, "regRsvaDatos");
        mainPanel.add(regRsvaAula, "regRsvaAula");
        mainPanel.add(regAulaEsporadicaDias, "regAulaEsporadicaDias");

        configureListeners();

        showLogin();

    }

    private void configureListeners() {

        // login
        login.setListener((String idLogin, String contrasena) -> {
            try {
                UsuarioDTO usuarioDTO = new UsuarioDTO(idLogin, contrasena, null, null);
                Boolean esAdmin = gestorLogin.validarLogin(usuarioDTO);

                if (esAdmin) {
                    showMenuAdmin();
                } else {
                    showMenuBedel();
                }
            } catch (DAOException e) {
                System.out.println(e.getMessage());
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            } catch (ValueException e) {
                System.out.println(e.getMessage());
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }
        });

        // menuAdmin
        menuAdmin.setListener(new MenuAdmin.Listener() {
            @Override
            public void registrarBedel() {
                showRegistrarBedel();
            }

            @Override
            public void buscarBedel() {
                showBuscarBedel();
            }
        });

        // buscarBedel
        buscarBedel.setListener(new BuscarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea regresar?");
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
                baseFrame.setPanel2Up();
                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        baseFrame.setPanel1Up();
                        showMenuAdmin();
                    }

                });
            }

            @Override
            public void next() {
                try {
                    List<BedelDTO> bedelesBuscados;
                    if (buscarBedel.getSeleccionado().equals("Apellido")) {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getApellido());
                    } else {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getTurno());
                    }

                    showResultadosBusquedaBedel(bedelesBuscados);

                } catch (NullPointerException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                } catch (Exceptions.DAOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // resultadosBusquedaBedel
        resultadosBusquedaBedel.setListener(new ResultadosBusquedaBedel.Listener() {
            @Override
            public void back() {
                showBuscarBedel();
            }

            @Override
            public void deshabilitar(BedelDTO elegido, Fun fun) {
                alertaConfirmacion.setText("¿Esta seguro que desea deshabilitar el usuario " + elegido.getIdLogin() + "?");

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        try {
                            // TODO: cambiar nombre funcion
                            gestorBedel.eliminar(elegido.getIdUsuario());

                            alerta.setText("bedel deshabilitado con exito");
                            alerta.setListener(() -> baseFrame.setPanel1Up());

                            alertaCardLayout.show(alertaPanel, "alerta");
                            baseFrame.setPanel2Up();

                            fun.call(Boolean.TRUE);
                        } catch (Exceptions.DAOException ex) {
                            fun.call(Boolean.FALSE, ex);
                        }
                    }
                });
                baseFrame.setPanel2Up();
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
            }

            @Override
            public void habilitar(BedelDTO elegido, Fun fun) {
                alertaConfirmacion.setText("¿Esta seguro que desea habilitar el usuario " + elegido.getIdLogin() + "?");
                

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        try {
                            // TODO: cambiar nombre funcion
                            gestorBedel.habilitar(elegido.getIdUsuario());

                            alerta.setText("bedel habilitado con exito");
                            alerta.setListener(() -> baseFrame.setPanel1Up());

                            alertaCardLayout.show(alertaPanel, "alerta");
                            baseFrame.setPanel2Up();

                            fun.call(Boolean.TRUE);
                        } catch (Exceptions.DAOException ex) {
                            fun.call(Boolean.FALSE, ex);
                        }
                    }
                });
                baseFrame.setPanel2Up();
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
            }

            @Override
            public boolean modificar(BedelDTO bedel) {
                try {
                    gestorBedel.modificar(bedel);

                    alerta.setText("Bedel modificado con éxito");
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                     try {
                    List<BedelDTO> bedelesBuscados;
                    if (buscarBedel.getSeleccionado().equals("Apellido")) {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getApellido());
                    } else {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getTurno());
                    }

                    showResultadosBusquedaBedel(bedelesBuscados);

                } catch (NullPointerException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                } catch (Exceptions.DAOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                    return true;

                } catch (ValueException ex) {
                    alerta.setText("no se pudo modificar el bedel");
                    System.out.println(ex.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return false;
                }
            }

            @Override
            public void modificarError(Exception e) {
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }

            @Override
            public void eliminarError(Exception e) {
                System.out.println("eliminar error interfaz");
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }

        });

        // registrarBedel
        registrarBedel.setListener(new RegistrarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea cancelar?");
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
                baseFrame.setPanel2Up();

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        baseFrame.setPanel1Up();
                        showMenuAdmin();
                    }
                });
            }

            @Override
            public void next() {
                try {
                    String nombre = registrarBedel.getNombre();
                    String apellido = registrarBedel.getApellido();
                    String idLogin = registrarBedel.getIdLogin();
                    TurnoBedel turno = registrarBedel.getTurno();
                    String contraseña = registrarBedel.getContraseña();
                    String rContraseña = registrarBedel.getrContraseña();

                    // rcontraseña
                    if (!contraseña.equals(rContraseña)) {
                        throw new Exceptions.UIException("Las contraseñas no coinciden.");
                    }

                    BedelDTO bedelDTO = new BedelDTO(idLogin, contraseña, nombre, apellido, turno, true);

                    gestorBedel.crear(bedelDTO);

                } catch (Exceptions.UIException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    return;
                }

                alerta.setText("Bedel registrado con éxito");
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
                alerta.setListener(() -> {
                    baseFrame.setPanel1Up();
                    showMenuAdmin();
                });

            }
        });

                regRsvaSeleccionTipoReserva.setListener(new SeleccionTipoReserva.Listener(){
                    @Override
                    public void back(){
                        showMenuBedel();
}
                    @Override
                    public void next(){
                    if (null == regRsvaSeleccionTipoReserva.getSelected()) {  //esporadica
                        gestorReserva.tipoReserva(GestorReserva.RESERVA_ESPORADICA);
                        cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                    } else switch (regRsvaSeleccionTipoReserva.getSelected()) {
                        case ANUAL -> {
                            gestorReserva.tipoReserva(GestorReserva.RESERVA_ANUAL);
                            cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                        }
                        case PRIMER_CUATRIMESTRE -> {
                            gestorReserva.tipoReserva(GestorReserva.RESERVA_PRIMER_CUATRIMESTRE);
                            cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                        }
                        case SEGUNDO_CUATRIMESTRE -> {
                            gestorReserva.tipoReserva(GestorReserva.RESERVA_SEGUNDO_CUATRIMESTRE);
                            cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                        }
                        default -> {
                            //esporadica
                            gestorReserva.tipoReserva(GestorReserva.RESERVA_ESPORADICA);
                            cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                        }
                    }}
        });

        // periodica seleccionar dias
        regRsvaTipoPeriodicaDias.setListener(new TipoPeriodicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {
                ArrayList<DiaSemana> dias = new ArrayList<>(0);

                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[0]) {
                    dias.add(DiaSemana.LUNES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[1]) {
                    dias.add(DiaSemana.MARTES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[2]) {
                    dias.add(DiaSemana.MIERCOLES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[3]) {
                    dias.add(DiaSemana.JUEVES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[4]) {
                    dias.add(DiaSemana.VIERNES);
                }

                gestorReserva.diasSeleccionados(dias);

                regRsvaPeriodicaHorarios.setDiasHabilitados(regRsvaTipoPeriodicaDias.getDiasSeleccionados());
                cardLayout.show(mainPanel, "regRsvaPeriodicaHorarios");
            }
        });

        // periodicas seleccionar horarios
        regRsvaPeriodicaHorarios.setListener(new TipoPeriodicaHorarios.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
            }

            @Override
            public void next() {

                ArrayList<DetalleReservaDTO> detalle = new ArrayList<>();

                LocalTime[] horarios = regRsvaPeriodicaHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = regRsvaPeriodicaHorarios.getDuracionesSeleccionadas();

                if (horarios[0] != null) {

                    DiaSemana ds = DiaSemana.LUNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[0]);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[0]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detalle.add(tmp);
                }
                if (horarios[1] != null) {
                    DiaSemana ds = DiaSemana.MARTES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[1]);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[1]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detalle.add(tmp);
                }
                if (horarios[2] != null) {
                    DiaSemana ds = DiaSemana.MIERCOLES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[2]);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[2]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detalle.add(tmp);
                }
                if (horarios[3] != null) {
                    DiaSemana ds = DiaSemana.JUEVES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[3]);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[3]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detalle.add(tmp);
                }
                if (horarios[4] != null) {
                    DiaSemana ds = DiaSemana.VIERNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[4]);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[4]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detalle.add(tmp);
                }

                gestorReserva.horariosSeleccionados(detalle);

                cardLayout.show(mainPanel, "regRsvaDatos");

            }
        });

        //esporadicaDias
        regAulaEsporadicaDias.setListener(new EsporadicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {

                Object[][] datos = regAulaEsporadicaDias.getData();
                ArrayList<DetalleReservaDTO> detalleReserva = new ArrayList<>();

                try {
                    for (int i = 0; i < datos.length; i++) {
                        Date dia = (Date) datos[i][0];
                        LocalTime horario = (LocalTime) datos[i][1];
                        LocalTime duracion = (LocalTime) datos[i][2];

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dia);

                        DiaSemana ds = DiaSemana.LUNES;
                        int dow = calendar.get(Calendar.DAY_OF_WEEK);

                        if (dow == 1) {
                            ds = DiaSemana.LUNES;
                        } else if (dow == 2) {
                            ds = DiaSemana.MARTES;
                        } else if (dow == 3) {
                            ds = DiaSemana.MIERCOLES;
                        } else if (dow == 4) {
                            ds = DiaSemana.JUEVES;
                        } else if (dow == 5) {
                            ds = DiaSemana.MARTES;
                        } else {
                            throw new Exceptions.ValueException("no se puede registar una reserva un dia sabado/domingo");
                        }
                        Time horarioInicio = Time.valueOf(horario);
                        Time time = Time.valueOf(duracion);
                        int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                        int cantModulos = (minutosCompletos / 30);
                        DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                        detalleReserva.add(tmp);
                    }

                    gestorReserva.seleccionarDiasYHorarios(detalleReserva);
                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                }

                cardLayout.show(mainPanel, "regRsvaDatos");
            }
        });

        //registroReservaDatos
        regRsvaDatos.setListener(new RegistrarReservaDatos.Listener() {
            @Override
            public void back() {
                if (gestorReserva.getTipoReserva() == GestorReserva.RESERVA_ESPORADICA) {
                    cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                } else {
                    cardLayout.show(mainPanel, "regRsvaPeriodicaHorarios");
                }
            }

            @Override
            public void next() {
                String nombreDocente = regRsvaDatos.getNombreDocente();
                String apellidoDocente = regRsvaDatos.getApellidoDocente();
                String nombreCatedra = regRsvaDatos.getNombreCatedra();
                String correo = regRsvaDatos.getCorreo();
                int cantidadAlumnos = regRsvaDatos.getCantidadAlumnos();
                TipoAula tipoAula = regRsvaDatos.getTipoAula();

                try {
                    ReservaDTO reserva = new ReservaDTO(-1, nombreDocente, -1, apellidoDocente, correo,
                            -1, nombreCatedra, null, cantidadAlumnos, -1, null,
                            null, true, -1, -1);
                    DisponibilidadDTO disp = gestorReserva.validarDatos(reserva, tipoAula);
//                    gestorReserva.validarDatos(
//                            nombreDocente,
//                            apellidoDocente,
//                            nombreCatedra,
//                            correo,
//                            cantidadAlumnos,
//                            tipoAula
//                    );
                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }

                AulaGeneral[] aulas = gestorReserva.getAulasDisponibles();
                regRsvaAula.setTable(convertirFormatoAula(aulas));

                cardLayout.show(mainPanel, "regRsvaAula");

            }
        });

        //registroResultadosAulas
        regRsvaAula.setListener(new ResultadosAulas.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaDatos");
            }

            @Override
            public void next() {
                gestorReserva.aulaSeleccionada(regRsvaAula.getSelectedElementIndex());

                try {
                    // ARREGLAR EL FLUJO DE CREAR RESERVA
                    ReservaDTO rdto = new ReservaDTO(0, null, 0, null, null, 0, null, null, 0, 0, null, null, false, 0, 0);
                    gestorReserva.crearReserva(rdto);

                    System.err.println("reservado");
                    alerta.setText("reserva realizada con exito");
                    alerta.setListener(() -> {
                        showMenuBedel();
                        baseFrame.setPanel1Up();
                    });
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();

                } catch (Exception e) { //TODO: hacer todas las validaciones(otros catch)
                    alerta.setText("no se pudo realizar la reserva");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                }
            }
        });

    }

    private void showLogin() {
        cardLayout.show(mainPanel, "login");
    }

    private void showMenuAdmin() {
        cardLayout.show(mainPanel, "menuAdmin");
    }

    private void showBuscarBedel() {
        cardLayout.show(mainPanel, "buscarBedel");
    }

    public void showResultadosBusquedaBedel(List<BedelDTO> bedeles) {
        resultadosBusquedaBedel.updateBedeles(bedeles);
        cardLayout.show(mainPanel, "resultadosBusquedaBedel");
    }

    private void showRegistrarBedel() {

        cardLayout.show(mainPanel, "registrarBedel");
    }

    // Reserva
    private void showMenuBedel() {
        menuBedel.setListener(new MenuBedel.Listener() {
            @Override
            public void registrarReserva() {
                showRegistrarReserva();
            }

            @Override
            public void buscarAulas() {
            }

            @Override
            public void listarReservasParaUnCurso() {
                
            }

            @Override
            public void listarReservasParaUnDia() {
                
            }
        });
        cardLayout.show(mainPanel, "menuBedel");
    }

    private void showRegistrarReserva() {

        cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
    }

    private String[][] convertirFormatoAula(AulaGeneral[] aulas) {
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

}
