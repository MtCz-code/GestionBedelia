
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
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Interfaz {
    // singleton
    private static Interfaz interfazInstance;
    
    public static Interfaz getInstance() {
        if (interfazInstance == null)
            interfazInstance = new Interfaz();
        return interfazInstance;
    }
    
    // clase
    
    // pantalla auxiliar que se usa para poder presentar alertas
    private BaseFrame baseFrame;
    
    private 
    CardLayout cardLayout;
    JPanel mainPanel;
    
    // paneles generales de alerta y confirmacion
    private Alerta alerta;
    private AlertaConfirmacion alertaConfirmacion;
    
    MenuAdmin menuAdmin= new MenuAdmin();
    MenuBedel menuBedel = new MenuBedel();
    
    
    // gestores
    private GestorBedel gestorBedel= GestorBedel.getInstance();
    private GestorLogin gestorLogin= GestorLogin.getInstance();
    
public Interfaz() {
    baseFrame = new BaseFrame();
    alerta = new Alerta();
    alertaConfirmacion = new AlertaConfirmacion();
    cardLayout= new CardLayout();
    mainPanel= new JPanel(cardLayout);
    baseFrame.getPanel1().setLayout(new BorderLayout());
    baseFrame.getPanel1().add(mainPanel);
       
    //Login
    InicioSesion login= new InicioSesion();
    mainPanel.add(login,"login");

      login.setListener((String idLogin, String contrasena) -> {
          try{
              UsuarioDTO usuarioDTO = new UsuarioDTO(idLogin,contrasena,null,null);
              Boolean esAdmin = gestorLogin.validarLogin(usuarioDTO);
                  
              if(esAdmin){
                  showMenuAdmin();
              }
              else{
                  showMenuBedel();
              }
          } catch(DAOException e){
              alerta.setText(e.getMessage());
              baseFrame.getPanel2().add(alerta);
              baseFrame.setPanel2Up();
          } catch (ValueException ex) {
              /*    
              FALTA UNA VENTANA EMERGENTE QUE INDIQUE EL ERROR EN CASO DE QUE USUARIO O CONTREASEÑA NO SEAN CORERECTAS
                        ⣠⣤⣤⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⢰⡿⠋⠁⠀⠀⠈⠉⠙⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢀⣿⠇⠀⢀⣴⣶⡾⠿⠿⠿⢿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⣀⣀⣸⡿⠀⠀⢸⣿⣇⠀⠀⠀⠀⠀⠀⠙⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⣾⡟⠛⣿⡇⠀⠀⢸⣿⣿⣷⣤⣤⣤⣤⣶⣶⣿⠇⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀
                ⢀⣿⠀⢀⣿⡇⠀⠀⠀⠻⢿⣿⣿⣿⣿⣿⠿⣿⡏⠀⠀⠀⠀⢴⣶⣶⣿⣿⣿⣆
                ⢸⣿⠀⢸⣿⡇⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⣿⡇⣀⣠⣴⣾⣮⣝⠿⠿⠿⣻⡟
                ⢸⣿⠀⠘⣿⡇⠀⠀⠀⠀⠀⠀⠀⣠⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠉⠀
                ⠸⣿⠀⠀⣿⡇⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀
                ⠀⠻⣷⣶⣿⣇⠀⠀⠀⢠⣼⣿⣿⣿⣿⣿⣿⣿⣛⣛⣻⠉⠁⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⣿⣀⣀⣀⣼⡿⢿⣿⣿⣿⣿⣿⡿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠙⠛⠛⠛⠋⠁⠀⠙⠻⠿⠟⠋⠑⠛⠋⠀
              */
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
      
      cardLayout.show(mainPanel, "login");

      baseFrame.setLocationRelativeTo(null);
        baseFrame.setVisible(true);


    }
    
    // Admin
    private void showMenuAdmin() {
        if(!existeVista("menuAdmin")){
        
        mainPanel.add(menuAdmin, "menuAdmin");
        baseFrame.revalidate();

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
        }
        cardLayout.show(mainPanel,"menuAdmin");
    }
    
    //acciones admin
    private void showBuscarBedel() {
        if (!existeVista("buscarBedel")) {
            BuscarBedel buscarBedel = new BuscarBedel();

            mainPanel.add(buscarBedel, "buscarBedel");
            baseFrame.revalidate();

            buscarBedel.setListener(new BuscarBedel.Listener() {
                @Override
                public void back() {
                    alertaConfirmacion.setText("¿Esta seguro que desea regresar?");
                    baseFrame.getPanel2().add(alertaConfirmacion);
                    baseFrame.setPanel2Up();
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
                        baseFrame.getPanel2().add(alerta);
                        baseFrame.setPanel2Up();
                    } catch (Exceptions.DAOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
                    alerta.setListener(() -> {
            baseFrame.setPanel1Up();
            baseFrame.getPanel2().remove(alerta);
        });
            cardLayout.show(mainPanel, "buscarBedel");
        }
    }
    
    
    public void showResultadosBusquedaBedel(List<BedelDTO> bedeles){
        if(!existeVista("resultadosBusquedaBedel")){
            try {
                ResultadosBusquedaBedel resultadosBusquedaBedel= new ResultadosBusquedaBedel(bedeles);
                mainPanel.add(resultadosBusquedaBedel,"resultadosBusquedaBedel");
                baseFrame.revalidate();
                
            } catch (ValueException e){
                System.out.println("COMPLETA ESTO MATI");
            }
                    
        }
        cardLayout.show(mainPanel,"resultadosBusquedaBedel");
    }

    private void showRegistrarBedel() {
        if (!existeVista("registrarBedel")) {
        RegistrarBedel registrarBedel = new RegistrarBedel();

        mainPanel.add(registrarBedel, "registrarBedel");
        baseFrame.revalidate();


        registrarBedel.setListener(new RegistrarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea cancelar?");
                baseFrame.getPanel2().add(alertaConfirmacion);
                baseFrame.setPanel2Up();
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
                    baseFrame.getPanel2().add(alerta);
                    baseFrame.setPanel2Up();
                    return;
                }

                alerta.setText("Bedel registrado con éxito");
                baseFrame.getPanel2().add(alerta);
                baseFrame.setPanel2Up();
                alerta.setListener(() -> {
                    baseFrame.getPanel2().remove(alerta);
                    baseFrame.setPanel1Up();
                    cardLayout.show(mainPanel,"menuAdmin");
                });

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
                baseFrame.setPanel1Up();
                cardLayout.show(mainPanel, "menuAdmin");

            }

        });
            cardLayout.show(mainPanel, "registrarBedel");
        }
    }

    
    // Reserva
    private void showMenuBedel() {
        if (!existeVista("menuBedel")) {

        mainPanel.add(menuBedel, "menuBedel");
        baseFrame.revalidate();
        
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
    }
    
    
    // Reserva
    private SeleccionTipoReserva regRsvaSeleccionTipoReserva = new SeleccionTipoReserva();
    private TipoPeriodicaDias regRsvaTipoPeriodicaDias = new TipoPeriodicaDias();
    private TipoPeriodicaHorarios regRsvaPeriodicaHorarios = new TipoPeriodicaHorarios();
    private RegistrarReservaDatos regRsvaDatos = new RegistrarReservaDatos();
    private ResultadosAulas regRsvaAula = new ResultadosAulas();
    private EsporadicaDias registrarAulaEsporadicaDias = new EsporadicaDias();
    
    private void showRegistrarReserva() {
        
        Alerta alerta = new Alerta();

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(regRsvaSeleccionTipoReserva, "SeleccionTipoReserva");
        mainPanel.add(regRsvaTipoPeriodicaDias, "TipoPeriodicaDias");
        mainPanel.add(regRsvaPeriodicaHorarios, "TipoPeriodicaHorarios");
        mainPanel.add(regRsvaDatos, "RegistrarReservaDatos");
        mainPanel.add(regRsvaAula, "ResultadosAulas");
        
        mainPanel.add(registrarAulaEsporadicaDias, "registrarAulaEsporadicaDias");
        mainPanel.add(alerta, "alerta");

        // frame principal
        baseFrame.getPanel1().add(mainPanel);
        baseFrame.revalidate();
        baseFrame.repaint();

        cardLayout.show(mainPanel, "registrarAula");
        GestorReserva gestorReserva = new GestorReserva();

        // seleccion tipo reserva
        regRsvaSeleccionTipoReserva.setListener(() -> {
            if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.ANUAL) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ANUAL);
                cardLayout.show(mainPanel, "TipoPeriodicaDias");
            } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.PRIMER_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_PRIMER_CUATRIMESTRE);
                cardLayout.show(mainPanel, "TipoPeriodicaDias");
            } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.SEGUNDO_CUATRIMESTRE) {
                gestorReserva.tipoReserva(GestorReserva.RESERVA_SEGUNDO_CUATRIMESTRE);
                cardLayout.show(mainPanel, "TipoPeriodicaDias");
            } else {  //esporadica
                gestorReserva.tipoReserva(GestorReserva.RESERVA_ESPORADICA);
                cardLayout.show(mainPanel, "TipoPeriodicaDias");
            }
        });

        regRsvaTipoPeriodicaDias.setListener(new TipoPeriodicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "SeleccionTipoReserva");
            }

            @Override
            public void next() {
                ArrayList<DiaSemana> dias = new ArrayList<>(0);

                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[0]) 
                    dias.add(DiaSemana.LUNES);
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[1]) 
                    dias.add(DiaSemana.MARTES);
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[2]) 
                    dias.add(DiaSemana.MIERCOLES);
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[3]) 
                    dias.add(DiaSemana.JUEVES);
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[4]) 
                    dias.add(DiaSemana.VIERNES);

                gestorReserva.diasSeleccionados(dias);

                regRsvaPeriodicaHorarios.setDiasHabilitados(regRsvaTipoPeriodicaDias.getDiasSeleccionados());
                cardLayout.show(mainPanel, "TipoPeriodicaHorarios");
            }
        });

        regRsvaPeriodicaHorarios.setListener(new TipoPeriodicaHorarios.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "TipoPeriodicaDias");
            }

            @Override
            public void next() {

                ArrayList<DetalleReserva> detalle = new ArrayList<>();

                LocalTime[] horarios = regRsvaPeriodicaHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = regRsvaPeriodicaHorarios.getDuracionesSeleccionadas();

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

                cardLayout.show(mainPanel, "RegistrarReservaDatos");

            }
        });

        regRsvaDatos.setListener(new RegistrarReservaDatos.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "TipoPeriodicaHorarios");
            }

            @Override
            public void next() {
                String nombreDocente = regRsvaDatos.getNombreDocente();
                String apellidoDocente = regRsvaDatos.getApellidoDocente();
                String nombreCatedra = regRsvaDatos.getNombreCatedra();
                String correo = regRsvaDatos.getCorreo();
                int cantidadAlumnos = regRsvaDatos.getCantidadAlumnos();
                TipoAula tipoAula = regRsvaDatos.getTipoAula();

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

                cardLayout.show(mainPanel, "ResultadosAulas");

            }
        });

        regRsvaAula.setListener(new ResultadosAulas.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "RegistrarReservaDatos");
            }

            @Override
            public void next() {
                gestorReserva.aulaSeleccionada(regRsvaAula.getSelectedElementIndex());

                gestorReserva.crearReserva();

                System.err.println("reservado");

                // TODO follow
                cardLayout.show(mainPanel, "registrarAulaAnualDias");

            }
        });
    }
    private boolean existeVista(String nombre) {
    for (Component c : mainPanel.getComponents()) {
        if (c.getName() != null && c.getName().equals(nombre)) {
            return true;
        }
    }
    return false;
}
    
}
