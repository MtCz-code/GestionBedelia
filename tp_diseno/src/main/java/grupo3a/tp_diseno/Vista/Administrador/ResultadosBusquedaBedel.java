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
import grupo3a.tp_diseno.Vista.Utilidades.UsuarioTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;

public class ResultadosBusquedaBedel extends javax.swing.JPanel {

    public interface Listener {

        void back();
    }

    GestorBedel gestorBedel;
    List<BedelDTO> bedeles;
    Alerta alerta= new Alerta();
    AlertaConfirmacion alertaConfirmacion=new AlertaConfirmacion();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
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
        BedelDTO elegido= bedeles.get(fila);
        int columna = tableBedeles.columnAtPoint(evt.getPoint());
        if(!tableBedeles.getValueAt(fila, 0).equals("") && !tableBedeles.getValueAt(fila, 1).equals("")
                 && !tableBedeles.getValueAt(fila, 2).equals("") && !tableBedeles.getValueAt(fila, 3).equals("")){
            if(columna==4){
                tfLogin.setText(elegido.getIdLogin());
                tfApellido.setText(elegido.getApellido());
                tfNombre.setText(elegido.getNombre());
                cbTurno.setSelectedItem(elegido.getTurno());
                pfContraseña.setText("");
                pfContraseñaR.setText("");
                modificarFrame.setLocationRelativeTo(null);
                modificarFrame.setVisible(true);
            } else if(columna==5){
                alertaConfirmacion.setText("¿Esta seguro que desea eliminar el usuario"+elegido.getIdLogin()+"?");
                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        alertaConfirmacion.setVisible(false);
                    }

                    @Override
                    public void next() {
                        try {
                            gestorBedel.eliminar(elegido.getIdUsuario());
                        bedeles.remove(elegido);
                        updateBedeles(bedeles);
                        alertaConfirmacion.setVisible(false);
                        } catch (Exceptions.DAOException ex) {
                            Logger.getLogger(ResultadosBusquedaBedel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
                alertaConfirmacion.setVisible(true);
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
                try {
                    String nombre = tfNombre.getText();
                    String apellido = tfApellido.getText();
                    String idLogin = tfLogin.getText();
                    TurnoBedel turno = switch (cbTurno.getSelectedIndex()) {
                                              case 0 -> TurnoBedel.MAÑANA;
                                              case 1 -> TurnoBedel.TARDE;
                                              default -> TurnoBedel.NOCHE;
                                      };
                    String contraseña = new String(pfContraseña.getPassword());
                    String rContraseña = new String(pfContraseña.getPassword());

                    // rcontraseña
                    if (!contraseña.equals(rContraseña)) {
                        throw new Exceptions.UIException("Las contraseñas no coinciden.");
                    }

                    BedelDTO bedelDTO = new BedelDTO(idLogin, contraseña, nombre, apellido, turno, true);

                    gestorBedel.modificar(bedelDTO);

                } catch (Exceptions.UIException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> alerta.setVisible(false));
                    return;
                }

                alerta.setText("Bedel modificado con éxito");
                alerta.setListener(() -> alerta.setVisible(false));

    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRContraseña;
    private javax.swing.JLabel lbTurno;
    private javax.swing.JFrame modificarFrame;
    private javax.swing.JPasswordField pfContraseña;
    private javax.swing.JPasswordField pfContraseñaR;
    private javax.swing.JTable tableBedeles;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
