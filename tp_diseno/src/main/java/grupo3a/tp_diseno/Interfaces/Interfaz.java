
package grupo3a.tp_diseno.Interfaces;

import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Interfaces.Administrador.BuscarBedel;
import grupo3a.tp_diseno.Interfaces.Administrador.MenuAdmin;
import grupo3a.tp_diseno.Interfaces.Administrador.RegistrarBedel;
import grupo3a.tp_diseno.Interfaces.Administrador.ResultadosBusquedaBedel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    // menu donde se inicia el programa
    private MenuAdmin menuAdmin;
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    
    private RegistrarBedel registrarBedel;
    private BuscarBedel buscarBedel;
    
    // paneles generales de alerta y confirmacion
    private Alerta alerta;
    private AlertaConfirmacion alertaConfirmacion;
    
    // gestores
    private GestorBedel gestorBedel= GestorBedel.getInstance();
    
    public Interfaz() {
        baseFrame = new BaseFrame();
        baseFrame.getPanel1().setLayout(new BorderLayout());
        baseFrame.getPanel1().add(menuAdmin, BorderLayout.CENTER);
        baseFrame.getPanel1().add(mainPanel);

        menuAdmin = new MenuAdmin();
        mainPanel.add(menuAdmin,"menuAdmin");



        menuAdmin.setListener(new MenuAdmin.Listener() {
            @Override
            public void registrarBedel() {
                showRegistroBedel();
            }
            @Override
            public void buscarBedel() {
                showBuscarBedel();
            }
        });
            baseFrame.setVisible(true);
    }
    
    public void showBuscarBedel() {
        buscarBedel = new BuscarBedel();
        alerta = new Alerta();
        alertaConfirmacion = new AlertaConfirmacion();

        mainPanel.add(buscarBedel, "buscarBedel");
        baseFrame.revalidate();
        baseFrame.repaint();
        


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
                    if(buscarBedel.getSeleccionado().equals("Apellido"))
                        bedelesBuscados=gestorBedel.buscarBedel(buscarBedel.getApellido());
                    else
                        bedelesBuscados=gestorBedel.buscarBedel(buscarBedel.getTurno());
                 
            showResultadosBusquedaBedel(bedelesBuscados);


                } catch (NullPointerException| Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    baseFrame.getPanel2().add(alerta);
                    baseFrame.setPanel2Up();
                } catch (Exceptions.DAOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }



            }
        });
    cardLayout.show(mainPanel, "buscarBedel");
    }
    
    public void showResultadosBusquedaBedel(List<BedelDTO> bedeles){
        
    }

    public void showRegistroBedel() {
        registrarBedel = new RegistrarBedel();
        alerta = new Alerta();
        alertaConfirmacion = new AlertaConfirmacion();

        mainPanel.add(registrarBedel, "registrarBedel");


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
                    baseFrame.getPanel1().remove(mainPanel);
                    baseFrame.getPanel1().add(menuAdmin);
                    baseFrame.setPanel1Up();
                    baseFrame.revalidate();
                    baseFrame.repaint();
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
                baseFrame.getPanel1().remove(mainPanel);
                baseFrame.getPanel1().add(menuAdmin);
                baseFrame.setPanel1Up();
                baseFrame.revalidate();
                baseFrame.repaint();
            }

        });

    }

}
