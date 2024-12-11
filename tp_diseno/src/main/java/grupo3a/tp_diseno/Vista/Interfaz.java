package grupo3a.tp_diseno.Vista;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.EsporadicaDias;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.CuatrimestreDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument;

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

    // datos reserva
    private List<CuatrimestreDTO> cuatrimestres;
    private CuatrimestreDTO cuat1, cuat2;
    private ArrayList<DiaSemana> dias;
    private ArrayList<DetalleReservaDTO> detalleReservaDto;
    private DisponibilidadDTO disponibilidadDeAulas;
    private ReservaDTO reserva;
    private int idBedel;

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
                    idBedel = gestorLogin.getIdUsuarioLogueado();
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
            } catch (Exceptions.BedelDeshabilitadoException e) {
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

        regRsvaSeleccionTipoReserva.setListener(new SeleccionTipoReserva.Listener() {
            @Override
            public void back() {
                showMenuBedel();
            }

            @Override
            public void next() {
                try {
                    System.out.println("HASTA ACA LLEGO");
                    Year año = regRsvaSeleccionTipoReserva.getSelectedAño();
                    cuatrimestres = gestorReserva.recuperarCuatrimestresPorAño(año);
                    reserva = new ReservaDTO(-1, null, -1, null, null, -1, null, null, -1, -1, null, false);
                    
                     System.out.println("HASTA ACA LLEGO 2");
                    if (null == regRsvaSeleccionTipoReserva.getSelectedTipoReserva()) {  //esporadica
                        alerta.setText("Seleccione un tipo de reserva");
                        alerta.setListener(() -> baseFrame.setPanel1Up());
                        alertaCardLayout.show(alertaPanel, "alerta");
                        baseFrame.setPanel2Up();
                    } else {
                        switch (regRsvaSeleccionTipoReserva.getSelectedTipoReserva()) {
                            case ANUAL -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.ANUAL);
                                cuat1 = obtenerCuatrimestreActual(cuatrimestres, 1);
                                cuat2 = obtenerCuatrimestreActual(cuatrimestres, 2);
                                if (cuat1 == null || cuat2 == null) {
                                    throw new Exceptions.UIException("no se encontraron cuatrimestres asociados a este año");
                                }
                                reserva.setIdCuatrimestre1(cuat1.getIdCuatrimestre());
                                reserva.setIdCuatrimestre2(cuat2.getIdCuatrimestre());
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            case PRIMER_CUATRIMESTRE -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.CUATRIMESTRAL);
                                cuat1 = obtenerCuatrimestreActual(cuatrimestres, 1);
                                if(cuat1.getFechaFin().isBefore(LocalDate.now())) {
                                    throw new Exceptions.UIException("No se puede reservar para un cuatrimestre pasado");
                                }
                                if (cuat1 == null) {
                                    throw new Exceptions.UIException("no se encontraron cuatrimestres asociados al 1er cuatrimestre");
                                }
                                reserva.setIdCuatrimestre1(cuat1.getIdCuatrimestre());
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            case SEGUNDO_CUATRIMESTRE -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.CUATRIMESTRAL);
                                cuat2 = obtenerCuatrimestreActual(cuatrimestres, 2);
                                if (cuat2 == null) {
                                    throw new Exceptions.UIException("no se encontraron cuatrimestres asociados al 2do cuatrimestre");
                                }
                                reserva.setIdCuatrimestre1(cuat2.getIdCuatrimestre());    //TODO: check
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            default -> {
                                //esporadica
                                reserva.setEsEsporadica(true);
                                cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                            }
                        }
                    }
                } catch (DAOException e) {
                    System.out.println(e.getMessage());
                    /*alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();*/
                    return;
                } catch (Exceptions.UIException e) {
                    System.out.println(e.getMessage());
                    /*alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();*/
                    return;
                }

            }
        });

        // periodica seleccionar dias
        regRsvaTipoPeriodicaDias.setListener(new TipoPeriodicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {
                dias = new ArrayList<>(0);

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

                //gestorReserva.diasSeleccionados(dias);
                regRsvaPeriodicaHorarios.setDiasHabilitados(regRsvaTipoPeriodicaDias.getDiasSeleccionados());
                reserva.setDiasSemana(dias);
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

                ArrayList<DetalleReservaDTO> detallesDias = new ArrayList<>();
                
                List<Time> horariosInicio = new ArrayList();
                List<Integer> modulos = new ArrayList();
                LocalTime[] horarios = regRsvaPeriodicaHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = regRsvaPeriodicaHorarios.getDuracionesSeleccionadas();

                if (horarios[0] != null) {

                    DiaSemana ds = DiaSemana.LUNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[0]);
                    
                    horariosInicio.add(horarioInicio);
                    
                    java.sql.Time time = java.sql.Time.valueOf(duraciones[0]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[1] != null) {
                    DiaSemana ds = DiaSemana.MARTES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[1]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[1]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[2] != null) {
                    DiaSemana ds = DiaSemana.MIERCOLES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[2]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[2]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[3] != null) {
                    DiaSemana ds = DiaSemana.JUEVES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[3]);

                    horariosInicio.add(horarioInicio);
                    
                    java.sql.Time time = java.sql.Time.valueOf(duraciones[3]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[4] != null) {
                    DiaSemana ds = DiaSemana.VIERNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[4]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[4]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }

                /*CuatrimestreDTO cuat;
                detalleReservaDto = new ArrayList<>();
                for (int i = 0; i < detallesDias.size(); i++) {
                    DetalleReservaDTO detalleDeDia = detallesDias.get(i);

                    if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.PRIMER_CUATRIMESTRE) {
                        detalleReservaDto.addAll(obtenerDiasCuatrimestre(cuat1, detalleDeDia));
                    } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.SEGUNDO_CUATRIMESTRE) {
                        detalleReservaDto.addAll(obtenerDiasCuatrimestre(cuat2, detalleDeDia));
                    } else {
                        detalleReservaDto.addAll(obtenerDiasCuatrimestre(cuat1, detalleDeDia));
                        detalleReservaDto.addAll(obtenerDiasCuatrimestre(cuat2, detalleDeDia));
                    }

                }*/
                
                
                detalleReservaDto = (ArrayList) gestorReserva.generarDetallesReserva(cuatrimestres, reserva.getDiasSemana(), horariosInicio, modulos);
                reserva.setDetallesReserva(detalleReservaDto);
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
                detalleReservaDto = new ArrayList<>();

                try {
                    for (int i = 0; i < datos.length; i++) {
                        Date dia = (Date) datos[i][0];
                        LocalTime horario = (LocalTime) datos[i][1];
                        LocalTime duracion = (LocalTime) datos[i][2];
                        System.out.println(dia.toString());
                        System.out.println(horario.toString());
                        System.out.println(duracion.toString());

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dia);

                        DiaSemana ds = DiaSemana.LUNES;
                        int dow = calendar.get(Calendar.DAY_OF_WEEK);

//                        1: Domingo (Calendar.SUNDAY)
//                        2: Lunes (Calendar.MONDAY)
//                        3: Martes (Calendar.TUESDAY)
//                        4: Miércoles (Calendar.WEDNESDAY)
//                        5: Jueves (Calendar.THURSDAY)
//                        6: Viernes (Calendar.FRIDAY)
//                        7: Sábado (Calendar.SATURDAY)
                        if (dow == 2) {
                            ds = DiaSemana.LUNES;
                        } else if (dow == 3) {
                            ds = DiaSemana.MARTES;
                        } else if (dow == 4) {
                            ds = DiaSemana.MIERCOLES;
                        } else if (dow == 5) {
                            ds = DiaSemana.JUEVES;
                        } else if (dow == 6) {
                            ds = DiaSemana.VIERNES;
                        } else {
                            throw new Exceptions.ValueException("no se puede registar una reserva un dia sabado/domingo");
                        }
                        System.out.println(ds.toString());
                        Time horarioInicio = Time.valueOf(horario);
                        Time time = Time.valueOf(duracion);
                        int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                        int cantModulos = (minutosCompletos / 30);
                        /*
                            idReserva
                            horarioInicio
                            cantModulos
                            fecha
                            diaReserva
                            idAula
                         */
                        LocalDate localDate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, localDate, ds, -1);
                        detalleReservaDto.add(tmp);
                    }

                    reserva.setDetallesReserva(detalleReservaDto);
                    
                    gestorReserva.validarDias(detalleReservaDto, cuatrimestres);
                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }

                cardLayout.show(mainPanel, "regRsvaDatos");
            }
        });

        //registroReservaDatos
        regRsvaDatos.setListener(new RegistrarReservaDatos.Listener() {
            @Override
            public void back() {
                if (reserva.isEsEsporadica()) {
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
                    reserva.setNombreDocente(nombreDocente);
                    reserva.setApellidoDocente(apellidoDocente);
                    reserva.setNombreCatedra(nombreCatedra);
                    reserva.setEmailDocente(correo);
                    reserva.setCantidadAlumnos(cantidadAlumnos);

                    disponibilidadDeAulas = gestorReserva.validarDatosYObtenerAulas(reserva, tipoAula);
                    regRsvaAula.setTable(convertirFormatoAula(disponibilidadDeAulas));

                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                } catch (Exceptions.NoExisteAulaException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                } catch (DAOException e) {
                    alerta.setText("<html>no se pudo seleccionar el aula<br>Ocurrio un error en la base de datos");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    // deberia volver al menu?
                    return;
                }
                cardLayout.show(mainPanel, "regRsvaAula");
                
                if(disponibilidadDeAulas.getSolapamiento()){
                    regRsvaAula.setTitle("<html>Seleccione su aula a reservar<br>no existen aulas sin solapamiento");
//                    System.out.println("" + disponibilidadDeAulas.getSolapamiento());
//                    alerta.setText("no existen aulas sin solapamiento");
//                    alerta.setListener(() -> baseFrame.setPanel1Up());
//                    alertaCardLayout.show(alertaPanel, "alerta");
//                    baseFrame.setPanel2Up();
                }
                else 
                    regRsvaAula.setTitle("Seleccione su aula a reservar<");
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
                int idx = regRsvaAula.getSelectedElementIndex();

                /*  idReserva           -
                    nombreDocente       *
                    idDocente           ?
                    apellidoDocente     *
                    emailDocente        *
                    idCatedra           ?
                    nombreCatedra       *
                    fechaRegistro       now()
                    cantidadAlumnos     *
                    idBedel             0
                    tipo                0
                    diasSemana          0
                    esEsporadica        0
                    idCuatrimestre1     0
                    idCuatrimestre2     0
                    detallesReserva     0
                 */
                //nombreDocente, apellidoDocente, correo, nombreCatedra, cantidadAlumnos
                AulaDTO aula = (AulaDTO) disponibilidadDeAulas.getAulasDisponibles().keySet().toArray()[idx];
                
                /* estos 2 ya se hacen desde el gestor/dao
                    reserva.setFechaRegistro(LocalDateTime.now());
                    reserva.setIdBedel(idBedel); 
                */

                /*
                idReserva
                horarioInicio
                cantModulos
                fecha
                diaReserva
                idAula
                 */
                for (int i = 0; i < detalleReservaDto.size(); i++) {
                    detalleReservaDto.get(i).setIdAula(aula.getIdAula());
                }
                
                reserva.setDetallesReserva(detalleReservaDto);
                
                try {
                    gestorReserva.crearReserva(reserva);

                    alerta.setText("reserva realizada con exito");
                    alerta.setListener(() -> {
                        showMenuBedel();
                        baseFrame.setPanel1Up();
                    });
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();

                    regRsvaSeleccionTipoReserva.resetInterface();
                    regRsvaTipoPeriodicaDias.resetInterface();
                    regRsvaPeriodicaHorarios.resetInterface();
                    regRsvaDatos.resetInterface();
                    regAulaEsporadicaDias.resetInterface();

                } catch (DAOException e) {
                    alerta.setText("<html>no se pudo realizar la reserva<br>ocurrio un error en la base de datos");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                } catch (ValueException ex) {
                    // esta excepcion se tiraria si al buscar el bedel que crea la reserva con gestorBedel.buscarPorId() 
                    // (en la funcion crearReserva->convertirAModelo) el bedel NO existe, esto no deberia pasar nunca.
                    alerta.setText("<html>no se pudo realizar la reserva<br>ocurrió un error al obtener el bedel logueado");
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
                try {
                    showRegistrarReserva();
                } catch (Exceptions.UIException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }
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

    private void showRegistrarReserva() throws Exceptions.UIException {
        try {
            // obtiene la lista de años disponibles para los que se puede reservar.
            regRsvaSeleccionTipoReserva.setListaAños(gestorReserva.recuperarAñosDisponibles());
        } catch (DAOException ex) {
            throw new Exceptions.UIException("Error al recuperar los años disponibles para reservar");
        }
        cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
        
    }

    private String[][] convertirFormatoAula(DisponibilidadDTO disp) {
        HashMap<AulaDTO, Integer> aulasDisponibles = disp.getAulasDisponibles();
        
        boolean solapamiento = disp.getSolapamiento();

        String[][] str = new String[aulasDisponibles.size()][];

        Set<AulaDTO> aulas = aulasDisponibles.keySet();

        Iterator<AulaDTO> it = aulas.iterator();
        int i = 0;
        while (it.hasNext()) {
            // TODO: sacar tipo (solo se debe mostrar la ubicacion creo, verificar) 
            AulaDTO auladto = it.next();
            String ubicacion = auladto.getUbicacion();
            String capacidad = auladto.getCapacidad() + " personas";
            int modulosSolapados = aulasDisponibles.get(auladto);
            int modulosTotales = disp.getCantidadModulosTotales();
            String solap = String.format("%.0f%%", ((float) modulosSolapados / modulosTotales) * 100);
            //String solap = (((float) modulosSolapados / (float)modulosTotales) * 100) + "%";

            List<String> caracteristics = new ArrayList<>();
            if (auladto.isAireAcondicionado()) {
                caracteristics.add("aire acondicionado");
            }
            if (auladto.isCanon()) {
                caracteristics.add("cañon");
            }
            if (auladto.isComputadora()) {
                caracteristics.add("computadoras");
            }
            if (auladto.isTelevisor()) {
                caracteristics.add("televisor");
            }
            if (auladto.isVentiladores()) {
                caracteristics.add("ventiladores");
            }
            String caracteristicas = "";
            for (int j = 0; j < caracteristics.size(); j++) {
                caracteristicas += caracteristics.get(j);
                if (j != caracteristics.size() - 1) {
                    caracteristicas += " / ";
                }
            }

//            String ubicacion = aulas[i].getTipo().toString() + " " + aulas[i].getUbicacion();
//            String capacidad = aulas[i].getCapacidad() + "alumnos";
//            String caracteristicas = "pizarron: " + aulas[i].getTipoDePizarron().toString();
            // TODO: agregar ventiladores y eso
//            if (aulas[i].getTipo() == TipoAula.GENERAL) {
            // TODO
//            } else if (aulas[i].getTipo() == TipoAula.LABORATORIO) {
//                caracteristicas += " " + ((AulaLaboratorio) aulas[i]).getCantidadDePCs();
//            } else if (aulas[i].getTipo() == TipoAula.MULTIMEDIOS) {
            // TODO
//            }
            str[i] = new String[]{ubicacion, capacidad, caracteristicas, solap};
            i++;
        }
        return str;
    }

    private CuatrimestreDTO obtenerCuatrimestreActual(List<CuatrimestreDTO> cuats, int numofcuat) {
        if (cuats == null || cuats.size() == 0) {
            return null;
        }
        int yearNow = LocalDate.now().getYear();

        for (int i = 0; i < cuats.size(); i++) {
            CuatrimestreDTO cuat = cuats.get(i);
            // buscar en cuatrimestres de este año
            if (cuat.getFechaInicio().getYear() == yearNow) {
                if (cuat.getFechaInicio().getMonthValue() < 6 && numofcuat == 1) {
                    return cuat;
                } else if (cuat.getFechaInicio().getMonthValue() >= 6 && numofcuat == 2) {
                    return cuat;
                }
            }
        }
        return null;
    }

    private List<DetalleReservaDTO> obtenerDiasCuatrimestre(CuatrimestreDTO cuat, DetalleReservaDTO detalleDeDia) {
        LocalDate fin = cuat.getFechaFin();

        LocalDate iterator = cuat.getFechaFin();
        DayOfWeek dow = diaSemana2DawOfWeek(detalleDeDia.getDiaReserva());
        System.out.println(dow.toString());
        while (iterator.getDayOfWeek() != diaSemana2DawOfWeek(detalleDeDia.getDiaReserva())) {
            iterator = iterator.plusDays(1);
            System.out.println(iterator.toString());
        }

        List<DetalleReservaDTO> detalles = new ArrayList<>();

        while (iterator.isBefore(fin) || iterator.equals(fin)) {
            System.out.println(iterator.toString());
            /*
            idReserva
            horarioInicio
            cantModulos
            fecha
            diaReserva
            idAula
             */
            DetalleReservaDTO detalle = new DetalleReservaDTO(
                    -1,
                    detalleDeDia.getHorarioInicio(),
                    detalleDeDia.getCantModulos(),
                    iterator,
                    detalleDeDia.getDiaReserva(),
                    detalleDeDia.getIdAula()
            );
            detalles.add(detalle);
            iterator = iterator.plusDays(7);

        }

        return detalles;
    }

    private DayOfWeek diaSemana2DawOfWeek(DiaSemana d) {
        if (d == DiaSemana.LUNES) {
            return DayOfWeek.MONDAY;
        } else if (d == DiaSemana.MARTES) {
            return DayOfWeek.THURSDAY;
        } else if (d == DiaSemana.MIERCOLES) {
            return DayOfWeek.WEDNESDAY;
        } else if (d == DiaSemana.JUEVES) {
            return DayOfWeek.TUESDAY;
        } else if (d == DiaSemana.VIERNES) {
            return DayOfWeek.FRIDAY;
        } else {
            return null;
        }
    }

}
