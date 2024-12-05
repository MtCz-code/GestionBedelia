package grupo3a.tp_diseno.Vista;

import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.EsporadicaDias;
import grupo3a.tp_diseno.DTOs.BedelDTO;
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
import grupo3a.tp_diseno.Modelos.DetalleReserva;
import static grupo3a.tp_diseno.Tp_diseno.convertirFormatoAula;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Time;
import java.util.Date;
import java.time.DayOfWeek;
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

        baseFrame.getPanel1().setLayout(new BorderLayout());
        baseFrame.getPanel1().add(mainPanel);

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
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            } catch (ValueException e) {
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, e);
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
        // buscarBedel
        resultadosBusquedaBedel.setListener(new ResultadosBusquedaBedel.Listener() {
            @Override
            public void back() {
                showBuscarBedel();
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
                baseFrame.getPanel2().add(alerta);
                baseFrame.setPanel2Up();
                alerta.setListener(() -> {
                    baseFrame.setPanel1Up();
                    showMenuAdmin();
                });

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
//                mainPanel.remove(menuBedel);
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
//        }
    }

    private void showRegistrarReserva() {

        cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");

        // TODO: pasar listeners a configuraListeners()
        // seleccion tipo reserva
        regRsvaSeleccionTipoReserva.setListener(() -> {
            if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.ANUAL) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ANUAL);
                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
            } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.PRIMER_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_PRIMER_CUATRIMESTRE);
                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
            } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.SEGUNDO_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_SEGUNDO_CUATRIMESTRE);
                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
            } else {  //esporadica
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ESPORADICA);
                cardLayout.show(mainPanel, "regAulaEsporadicaDias");
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

                ArrayList<DetalleReserva> detalle = new ArrayList<>();

                LocalTime[] horarios = regRsvaPeriodicaHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = regRsvaPeriodicaHorarios.getDuracionesSeleccionadas();

                if (horarios[0] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.LUNES);
                    tmp.setHorarioInicio(java.sql.Time.valueOf(horarios[0]));

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[0]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[1] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.MARTES);
                    tmp.setHorarioInicio(java.sql.Time.valueOf(horarios[1]));

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[1]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[2] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.MIERCOLES);
                    tmp.setHorarioInicio(java.sql.Time.valueOf(horarios[2]));

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[2]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[3] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.JUEVES);
                    tmp.setHorarioInicio(java.sql.Time.valueOf(horarios[3]));

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[3]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }
                if (horarios[4] != null) {
                    DetalleReserva tmp = new DetalleReserva();
                    tmp.setDiaReserva(DiaSemana.VIERNES);
                    tmp.setHorarioInicio(java.sql.Time.valueOf(horarios[4]));

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[4]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalle.add(tmp);
                }

                gestorReserva.horariosSeleccionados(detalle);

                cardLayout.show(mainPanel, "regRsvaDatos");

            }
        });

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

                
                // TODO: agregar cartel error por los datos
                gestorReserva.validarDatos(
                        nombreDocente,
                        apellidoDocente,
                        nombreCatedra,
                        correo,
                        cantidadAlumnos,
                        tipoAula
                );

                AulaGeneral[] aulas = gestorReserva.getAulasDisponibles();
                regRsvaAula.setTable(convertirFormatoAula(aulas));

                cardLayout.show(mainPanel, "regRsvaAula");

            }
        });

        regRsvaAula.setListener(new ResultadosAulas.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaDatos");
            }

            @Override
            public void next() {
                gestorReserva.aulaSeleccionada(regRsvaAula.getSelectedElementIndex());

                try {
                    gestorReserva.crearReserva();

                    System.err.println("reservado");
                    alerta.setText("reserva realizada con exito");
                    alerta.setListener(() -> {
                        showMenuBedel();
                        baseFrame.setPanel1Up();
                    });
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();

                } catch (Exception e) {//TODO: hacer todas las validaciones(otros catch)
                    e.printStackTrace();
                    alerta.setText("no se pudo realizar la reserva");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                }
            }
        });

        regAulaEsporadicaDias.setListener(new EsporadicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {

                Object[][] datos = regAulaEsporadicaDias.getData();

                ArrayList<DetalleReserva> detalleReserva = new ArrayList<>();

                for (int i = 0; i < datos.length; i++) {
                    Date dia = (Date) datos[i][0];
                    LocalTime horario = (LocalTime) datos[i][1];
                    LocalTime duracion = (LocalTime) datos[i][2];
                    DetalleReserva tmp = new DetalleReserva();
                    
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dia);

                    int dow = calendar.get(Calendar.DAY_OF_WEEK);
                    if (dow == 1)
                        tmp.setDiaReserva(DiaSemana.LUNES);
                    else if (dow == 2)
                        tmp.setDiaReserva(DiaSemana.MARTES);
                    else if (dow == 3)
                        tmp.setDiaReserva(DiaSemana.MIERCOLES);
                    else if (dow == 4)
                        tmp.setDiaReserva(DiaSemana.JUEVES);
                    else if (dow == 5)
                        tmp.setDiaReserva(DiaSemana.MARTES);
                    else {
                        // TODO excepcion (sabado / domingo)
                    }
                    
                    tmp.setHorarioInicio(Time.valueOf(horario));
                    Time time = Time.valueOf(duracion);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    tmp.setCantModulos(minutosCompletos / 30);
                    detalleReserva.add(tmp);
                }

                // TODO: cambiar nombre metodo en diagrama de secuencia
                gestorReserva.horariosSeleccionados(detalleReserva);
                
                cardLayout.show(mainPanel, "regRsvaDatos");
            }
        });
    }

}
