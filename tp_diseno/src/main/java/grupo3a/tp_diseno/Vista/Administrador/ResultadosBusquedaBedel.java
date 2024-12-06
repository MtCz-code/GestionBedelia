package grupo3a.tp_diseno.Vista.Administrador;

import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Vista.Alerta;
import grupo3a.tp_diseno.Vista.AlertaConfirmacion;
import grupo3a.tp_diseno.Vista.Utilidades.BordesRedondeados;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonEditor;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonRenderer;
import grupo3a.tp_diseno.Vista.Utilidades.FuncionInterface.Fun;
import grupo3a.tp_diseno.Vista.Utilidades.UsuarioTableModel;
import java.awt.CardLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;

public class ResultadosBusquedaBedel extends javax.swing.JPanel {

    public interface Listener {

        void back();

        void eliminar(BedelDTO bedel, Fun fun);

        boolean modificar(BedelDTO bedel);
        
        void eliminarError(Exception e);
        
        void modificarError(Exception e);
    }

//    GestorBedel gestorBedel;
    List<BedelDTO> bedeles;
//    Alerta alerta= new Alerta();
//    AlertaConfirmacion alertaConfirmacion=new AlertaConfirmacion();
    private Listener listener;
    

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ResultadosBusquedaBedel() {
        initComponents();
        this.tableBedeles.setAutoResizeMode(5);
        tableBedeles.setRowHeight(40);
        JTableHeader tableHeader = tableBedeles.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        
        rootPanel.add(modificarPanel, "modificarPanel");
        showBuscar();
    }
    
    public void showBuscar(){
        CardLayout cl = (CardLayout) rootPanel.getLayout();
        cl.show(rootPanel, "card2");
    }
    
    public void showModificar() {
        CardLayout cl = (CardLayout) rootPanel.getLayout();
        cl.show(rootPanel, "modificarPanel");
    }

    public void updateBedeles(List<BedelDTO> bedeles) {
        this.bedeles = bedeles;
        actualizarTabla();
    }

    private void actualizarTabla() {
        String[] columnNames = {"Nombre", "Apellido", "Turno", "Habilitado", "", ""};

        tableBedeles.setModel(new UsuarioTableModel(bedeles, columnNames));

        tableBedeles.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("Editar"));
        tableBedeles.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer("Borrar"));

        // Editores para las columnas
        tableBedeles.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor("Editar"));
        tableBedeles.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor("Borrar"));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificarFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lbTurno = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lbContraseña = new javax.swing.JLabel();
        pfContraseña = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lbRContraseña = new javax.swing.JLabel();
        pfContraseñaR = new javax.swing.JPasswordField();
        jPanel18 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        modificarPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        lbLogin1 = new javax.swing.JLabel();
        tfLogin1 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        lbApellido1 = new javax.swing.JLabel();
        tfApellido1 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        lbNombre1 = new javax.swing.JLabel();
        tfNombre1 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        lbTurno1 = new javax.swing.JLabel();
        cbTurno1 = new javax.swing.JComboBox<>();
        jPanel37 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        lbContraseña1 = new javax.swing.JLabel();
        pfContraseña1 = new javax.swing.JPasswordField();
        jPanel39 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        lbRContraseña1 = new javax.swing.JLabel();
        pfContraseñaR1 = new javax.swing.JPasswordField();
        jPanel41 = new javax.swing.JPanel();
        btnCancelar1 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        btnModificar1 = new javax.swing.JButton();
        rootPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBedeles = new javax.swing.JTable();

        modificarFrame.setTitle("Modificar Bedel");
        modificarFrame.setLocationByPlatform(true);
        modificarFrame.setSize(new java.awt.Dimension(600, 400));

        jPanel3.setBackground(new java.awt.Color(19, 66, 125));
        jPanel3.setForeground(new java.awt.Color(19, 66, 126));
        jPanel3.setPreferredSize(new java.awt.Dimension(424, 100));

        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Modificar Bedel");
        jLabel7.setPreferredSize(new java.awt.Dimension(294, 450));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));

        jPanel5.setBackground(new java.awt.Color(26, 26, 26));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel5.setPreferredSize(new java.awt.Dimension(37, 120));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modifique los datos necesarios");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Montserrat Thin Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>La contraseña debe tener una longitud mínima de 8 caracteres,  debe contener signos especiales (@#$%&*), <br>  al menos una letra mayúscula, y al menos un dígito</html>");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
            .addComponent(jLabel8)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(26, 26, 26));

        jPanel13.setBackground(new java.awt.Color(26, 26, 26));
        jPanel13.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("(*)");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel6.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel13.add(jLabel6);

        jPanel7.setBackground(new java.awt.Color(26, 26, 26));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setText("Nombre de usuario");
        lbLogin.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel7.add(lbLogin);

        tfLogin.setBackground(new java.awt.Color(40, 40, 40));
        tfLogin.setForeground(new java.awt.Color(255, 255, 255));
        tfLogin.setEnabled(false);
        tfLogin.setPreferredSize(new java.awt.Dimension(64, 20));
        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });
        jPanel7.add(tfLogin);

        jPanel13.add(jPanel7);

        jPanel12.setBackground(new java.awt.Color(26, 26, 26));
        jPanel12.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("(*)");
        jLabel2.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel12.add(jLabel2);

        jPanel21.setBackground(new java.awt.Color(26, 26, 26));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        lbApellido.setForeground(new java.awt.Color(255, 255, 255));
        lbApellido.setText("Apellido");
        lbApellido.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel21.add(lbApellido);

        tfApellido.setBackground(new java.awt.Color(40, 40, 40));
        tfApellido.setForeground(new java.awt.Color(255, 255, 255));
        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });
        jPanel21.add(tfApellido);

        jPanel12.add(jPanel21);

        jPanel14.setBackground(new java.awt.Color(26, 26, 26));
        jPanel14.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("(*)");
        jLabel4.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel14.add(jLabel4);

        jPanel23.setBackground(new java.awt.Color(26, 26, 26));
        jPanel23.setLayout(new java.awt.GridLayout(1, 0));

        lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre.setText("Nombre");
        lbNombre.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel23.add(lbNombre);

        tfNombre.setBackground(new java.awt.Color(40, 40, 40));
        tfNombre.setForeground(new java.awt.Color(255, 255, 255));
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        jPanel23.add(tfNombre);

        jPanel14.add(jPanel23);

        jPanel15.setBackground(new java.awt.Color(26, 26, 26));
        jPanel15.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("(*)");
        jLabel5.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel15.add(jLabel5);

        jPanel24.setBackground(new java.awt.Color(26, 26, 26));
        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        lbTurno.setForeground(new java.awt.Color(255, 255, 255));
        lbTurno.setText("Turno en el que trabaja");
        lbTurno.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel24.add(lbTurno);

        cbTurno.setBackground(new java.awt.Color(40, 40, 40));
        cbTurno.setForeground(new java.awt.Color(255, 255, 255));
        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        cbTurno.setToolTipText("");
        cbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnoActionPerformed(evt);
            }
        });
        jPanel24.add(cbTurno);

        jPanel15.add(jPanel24);

        jPanel16.setBackground(new java.awt.Color(26, 26, 26));
        jPanel16.setPreferredSize(new java.awt.Dimension(420, 35));

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("(*)");
        jLabel9.setPreferredSize(new java.awt.Dimension(20, 16));

        jPanel25.setBackground(new java.awt.Color(26, 26, 26));
        jPanel25.setLayout(new java.awt.GridLayout(1, 0));

        lbContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbContraseña.setText("Contraseña");
        lbContraseña.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel25.add(lbContraseña);

        pfContraseña.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseña.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaActionPerformed(evt);
            }
        });
        jPanel25.add(pfContraseña);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel17.setBackground(new java.awt.Color(26, 26, 26));
        jPanel17.setPreferredSize(new java.awt.Dimension(420, 35));

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("(*)");
        jLabel10.setPreferredSize(new java.awt.Dimension(20, 16));

        jPanel26.setBackground(new java.awt.Color(26, 26, 26));

        lbRContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbRContraseña.setText("Repetir contraseña");
        lbRContraseña.setPreferredSize(new java.awt.Dimension(70, 20));

        pfContraseñaR.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseñaR.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseñaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(lbRContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pfContraseñaR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbRContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pfContraseñaR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(26, 26, 26));
        jPanel18.setPreferredSize(new java.awt.Dimension(100, 80));

        btnCancelar.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(26, 26, 26));
        jPanel27.setPreferredSize(new java.awt.Dimension(100, 80));

        btnModificar.setBackground(new java.awt.Color(17, 17, 17));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(new BordesRedondeados(20));
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modificarFrameLayout = new javax.swing.GroupLayout(modificarFrame.getContentPane());
        modificarFrame.getContentPane().setLayout(modificarFrameLayout);
        modificarFrameLayout.setHorizontalGroup(
            modificarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modificarFrameLayout.setVerticalGroup(
            modificarFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarFrameLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel8.setBackground(new java.awt.Color(19, 66, 125));
        jPanel8.setForeground(new java.awt.Color(19, 66, 126));
        jPanel8.setPreferredSize(new java.awt.Dimension(424, 100));

        jLabel11.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar Bedel");
        jLabel11.setPreferredSize(new java.awt.Dimension(294, 450));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));

        jPanel11.setBackground(new java.awt.Color(26, 26, 26));
        jPanel11.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel11.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel11.setPreferredSize(new java.awt.Dimension(37, 120));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Montserrat Thin Light", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Modifique los datos necesarios");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Montserrat Thin Light", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("<html>La contraseña debe tener una longitud mínima de 8 caracteres,  debe contener signos especiales (@#$%&*), <br>  al menos una letra mayúscula, y al menos un dígito</html>");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
            .addComponent(jLabel13)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(26, 26, 26));

        jPanel29.setBackground(new java.awt.Color(26, 26, 26));
        jPanel29.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));

        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("(*)");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel14.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel29.add(jLabel14);

        jPanel30.setBackground(new java.awt.Color(26, 26, 26));
        jPanel30.setLayout(new java.awt.GridLayout());

        lbLogin1.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin1.setText("Nombre de usuario");
        lbLogin1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel30.add(lbLogin1);

        tfLogin1.setBackground(new java.awt.Color(40, 40, 40));
        tfLogin1.setForeground(new java.awt.Color(255, 255, 255));
        tfLogin1.setEnabled(false);
        tfLogin1.setPreferredSize(new java.awt.Dimension(64, 20));
        tfLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLogin1ActionPerformed(evt);
            }
        });
        jPanel30.add(tfLogin1);

        jPanel29.add(jPanel30);

        jPanel31.setBackground(new java.awt.Color(26, 26, 26));
        jPanel31.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel31.setLayout(new javax.swing.BoxLayout(jPanel31, javax.swing.BoxLayout.LINE_AXIS));

        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("(*)");
        jLabel15.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel31.add(jLabel15);

        jPanel32.setBackground(new java.awt.Color(26, 26, 26));
        jPanel32.setLayout(new java.awt.GridLayout());

        lbApellido1.setForeground(new java.awt.Color(255, 255, 255));
        lbApellido1.setText("Apellido");
        lbApellido1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel32.add(lbApellido1);

        tfApellido1.setBackground(new java.awt.Color(40, 40, 40));
        tfApellido1.setForeground(new java.awt.Color(255, 255, 255));
        tfApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellido1ActionPerformed(evt);
            }
        });
        jPanel32.add(tfApellido1);

        jPanel31.add(jPanel32);

        jPanel33.setBackground(new java.awt.Color(26, 26, 26));
        jPanel33.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel33.setLayout(new javax.swing.BoxLayout(jPanel33, javax.swing.BoxLayout.LINE_AXIS));

        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("(*)");
        jLabel16.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel33.add(jLabel16);

        jPanel34.setBackground(new java.awt.Color(26, 26, 26));
        jPanel34.setLayout(new java.awt.GridLayout());

        lbNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre1.setText("Nombre");
        lbNombre1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel34.add(lbNombre1);

        tfNombre1.setBackground(new java.awt.Color(40, 40, 40));
        tfNombre1.setForeground(new java.awt.Color(255, 255, 255));
        tfNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombre1ActionPerformed(evt);
            }
        });
        jPanel34.add(tfNombre1);

        jPanel33.add(jPanel34);

        jPanel35.setBackground(new java.awt.Color(26, 26, 26));
        jPanel35.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel35.setLayout(new javax.swing.BoxLayout(jPanel35, javax.swing.BoxLayout.LINE_AXIS));

        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("(*)");
        jLabel17.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel35.add(jLabel17);

        jPanel36.setBackground(new java.awt.Color(26, 26, 26));
        jPanel36.setLayout(new java.awt.GridLayout());

        lbTurno1.setForeground(new java.awt.Color(255, 255, 255));
        lbTurno1.setText("Turno en el que trabaja");
        lbTurno1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel36.add(lbTurno1);

        cbTurno1.setBackground(new java.awt.Color(40, 40, 40));
        cbTurno1.setForeground(new java.awt.Color(255, 255, 255));
        cbTurno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        cbTurno1.setToolTipText("");
        cbTurno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurno1ActionPerformed(evt);
            }
        });
        jPanel36.add(cbTurno1);

        jPanel35.add(jPanel36);

        jPanel37.setBackground(new java.awt.Color(26, 26, 26));
        jPanel37.setPreferredSize(new java.awt.Dimension(420, 35));

        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("(*)");
        jLabel18.setPreferredSize(new java.awt.Dimension(20, 16));

        jPanel38.setBackground(new java.awt.Color(26, 26, 26));
        jPanel38.setLayout(new java.awt.GridLayout());

        lbContraseña1.setForeground(new java.awt.Color(255, 255, 255));
        lbContraseña1.setText("Contraseña");
        lbContraseña1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel38.add(lbContraseña1);

        pfContraseña1.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseña1.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseña1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseña1ActionPerformed(evt);
            }
        });
        jPanel38.add(pfContraseña1);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel39.setBackground(new java.awt.Color(26, 26, 26));
        jPanel39.setPreferredSize(new java.awt.Dimension(420, 35));

        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("(*)");
        jLabel19.setPreferredSize(new java.awt.Dimension(20, 16));

        jPanel40.setBackground(new java.awt.Color(26, 26, 26));

        lbRContraseña1.setForeground(new java.awt.Color(255, 255, 255));
        lbRContraseña1.setText("Repetir contraseña");
        lbRContraseña1.setPreferredSize(new java.awt.Dimension(70, 20));

        pfContraseñaR1.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseñaR1.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseñaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaR1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(lbRContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pfContraseñaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbRContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pfContraseñaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(26, 26, 26));
        jPanel41.setPreferredSize(new java.awt.Dimension(100, 80));

        btnCancelar1.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setPreferredSize(new java.awt.Dimension(110, 40));
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel42.setBackground(new java.awt.Color(26, 26, 26));
        jPanel42.setPreferredSize(new java.awt.Dimension(100, 80));

        btnModificar1.setBackground(new java.awt.Color(17, 17, 17));
        btnModificar1.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar1.setText("Modificar");
        btnModificar1.setBorder(new BordesRedondeados(20));
        btnModificar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar1.setPreferredSize(new java.awt.Dimension(110, 40));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modificarPanelLayout = new javax.swing.GroupLayout(modificarPanel);
        modificarPanel.setLayout(modificarPanelLayout);
        modificarPanelLayout.setHorizontalGroup(
            modificarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modificarPanelLayout.setVerticalGroup(
            modificarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(19, 66, 125));
        rootPanel.setForeground(new java.awt.Color(19, 66, 126));
        rootPanel.setPreferredSize(new java.awt.Dimension(424, 100));
        rootPanel.setLayout(new java.awt.CardLayout());

        jPanel19.setBackground(new java.awt.Color(26, 26, 26));
        jPanel19.setForeground(new java.awt.Color(19, 66, 125));
        jPanel19.setMaximumSize(new java.awt.Dimension(327657, 325767));

        jPanel20.setBackground(new java.awt.Color(19, 66, 125));
        jPanel20.setFont(new java.awt.Font("Montserrat Light", 1, 40)); // NOI18N
        jPanel20.setMaximumSize(new java.awt.Dimension(294, 52));
        jPanel20.setPreferredSize(new java.awt.Dimension(685, 100));

        jLabel3.setFont(new java.awt.Font("Montserrat Light", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Buscar Bedel");
        jLabel3.setPreferredSize(new java.awt.Dimension(259, 49));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(26, 26, 26));
        jPanel22.setPreferredSize(new java.awt.Dimension(100, 80));

        btnRegresar.setBackground(new java.awt.Color(17, 17, 17));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jScrollPane1.setBackground(new java.awt.Color(26, 26, 26));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tableBedeles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableBedeles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBedelesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBedeles);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(461, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(176, 176, 176)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGap(151, 151, 151)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGap(131, 131, 131)))
        );

        rootPanel.add(jPanel19, "card2");

        add(rootPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tableBedelesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBedelesMouseClicked
        int fila = tableBedeles.rowAtPoint(evt.getPoint());
        BedelDTO elegido = bedeles.get(fila);

        int columna = tableBedeles.columnAtPoint(evt.getPoint());

        if (!tableBedeles.getValueAt(fila, 0).equals("") && !tableBedeles.getValueAt(fila, 1).equals("")
                && !tableBedeles.getValueAt(fila, 2).equals("") && !tableBedeles.getValueAt(fila, 3).equals("")) {
            if (columna == 4) {
                tfLogin1.setText(elegido.getIdLogin());
                tfApellido1.setText(elegido.getApellido());
                tfNombre1.setText(elegido.getNombre());
                cbTurno1.setSelectedItem(elegido.getTurno());
                pfContraseña1.setText("");
                pfContraseñaR1.setText("");
                showModificar();
//                modificarFrame.setLocationRelativeTo(null);
//                modificarFrame.setVisible(true);
            } else if (columna == 5) {
                
                if (listener != null) {
                    listener.eliminar(elegido, (Object... o) -> {
                        Boolean b = (Boolean) o[0];
                        if (b) {
                            bedeles.remove(elegido);
                            updateBedeles(bedeles);
                            
                        } else {
                            listener.eliminarError((Exception) o[1]);
                        }
                        return null;
                    });
                }
            }
        }
    }//GEN-LAST:event_tableBedelesMouseClicked

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed

    }//GEN-LAST:event_tfLoginActionPerformed

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed

    }//GEN-LAST:event_tfApellidoActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed

    }//GEN-LAST:event_tfNombreActionPerformed

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed

    }//GEN-LAST:event_cbTurnoActionPerformed

    private void pfContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaActionPerformed

    }//GEN-LAST:event_pfContraseñaActionPerformed

    private void pfContraseñaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaRActionPerformed

    }//GEN-LAST:event_pfContraseñaRActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        System.out.println("modificar");
        try {
            String nombre = tfNombre.getText();
            String apellido = tfApellido.getText();
            String idLogin = tfLogin.getText();
            TurnoBedel turno = switch (cbTurno.getSelectedIndex()) {
                case 0 ->
                    TurnoBedel.MAÑANA;
                case 1 ->
                    TurnoBedel.TARDE;
                default ->
                    TurnoBedel.NOCHE;
            };
            String contraseña = new String(pfContraseña.getPassword());
            String rContraseña = new String(pfContraseña.getPassword());

            // rcontraseña
            if (!contraseña.equals(rContraseña)) {
                throw new Exceptions.UIException("Las contraseñas no coinciden.");
            }

            BedelDTO bedelDTO = new BedelDTO(idLogin, contraseña, nombre, apellido, turno, true);

            if (listener != null){
                listener.modificar(bedelDTO);
            }
            

        } catch (Exceptions.UIException e) {
            if (listener != null)
                listener.modificarError(e);
            return;
        }

        

    }//GEN-LAST:event_btnModificarActionPerformed

    private void tfLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLogin1ActionPerformed

    private void tfApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellido1ActionPerformed

    private void tfNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombre1ActionPerformed

    private void cbTurno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurno1ActionPerformed

    private void pfContraseña1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseña1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfContraseña1ActionPerformed

    private void pfContraseñaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfContraseñaR1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        showBuscar();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        System.out.println("modificar");
        try {
            String nombre = tfNombre.getText();
            String apellido = tfApellido.getText();
            String idLogin = tfLogin.getText();
            TurnoBedel turno = switch (cbTurno.getSelectedIndex()) {
                case 0 ->
                    TurnoBedel.MAÑANA;
                case 1 ->
                    TurnoBedel.TARDE;
                default ->
                    TurnoBedel.NOCHE;
            };
            String contraseña = new String(pfContraseña.getPassword());
            String rContraseña = new String(pfContraseña.getPassword());

            // rcontraseña
            if (!contraseña.equals(rContraseña)) {
                throw new Exceptions.UIException("Las contraseñas no coinciden.");
            }

            BedelDTO bedelDTO = new BedelDTO(idLogin, contraseña, nombre, apellido, turno, true);

            if (listener != null){
                listener.modificar(bedelDTO);
            }
            

        } catch (Exceptions.UIException e) {
            if (listener != null)
                listener.modificarError(e);
            return;
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JComboBox<String> cbTurno1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbApellido1;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbContraseña1;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogin1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombre1;
    private javax.swing.JLabel lbRContraseña;
    private javax.swing.JLabel lbRContraseña1;
    private javax.swing.JLabel lbTurno;
    private javax.swing.JLabel lbTurno1;
    private javax.swing.JFrame modificarFrame;
    private javax.swing.JPanel modificarPanel;
    private javax.swing.JPasswordField pfContraseña;
    private javax.swing.JPasswordField pfContraseña1;
    private javax.swing.JPasswordField pfContraseñaR;
    private javax.swing.JPasswordField pfContraseñaR1;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tableBedeles;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfApellido1;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfLogin1;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNombre1;
    // End of variables declaration//GEN-END:variables
}
