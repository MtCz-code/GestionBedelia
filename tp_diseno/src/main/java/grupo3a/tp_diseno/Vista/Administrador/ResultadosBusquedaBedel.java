package grupo3a.tp_diseno.Vista.Administrador;

import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Vista.Utilidades.BordesRedondeados;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonEditor;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonRenderer;
import grupo3a.tp_diseno.Vista.Utilidades.FuncionInterface.Fun;
import grupo3a.tp_diseno.Vista.Utilidades.UsuarioTableModel;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.table.JTableHeader;

public class ResultadosBusquedaBedel extends javax.swing.JPanel {

    public interface Listener {

        void back();

        void deshabilitar(BedelDTO bedel, Fun fun);

        void habilitar(BedelDTO bedel, Fun fun);

        boolean modificar(BedelDTO bedel);

        void eliminarError(Exception e);

        void modificarError(Exception e);
    }

//    GestorBedel gestorBedel;
    List<BedelDTO> bedeles;
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

    public void showBuscar() {
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

        modificarPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        idModificar = new javax.swing.JTextField();
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

        idModificar.setText("jTextField1");
        idModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
            .addComponent(jLabel13)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(629, 629, 629)
                .addComponent(idModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
        jPanel30.setLayout(new java.awt.GridLayout(1, 0));

        lbLogin1.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin1.setText("Nombre de usuario");
        lbLogin1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel30.add(lbLogin1);

        tfLogin1.setBackground(new java.awt.Color(40, 40, 40));
        tfLogin1.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel32.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel34.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel36.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel38.setLayout(new java.awt.GridLayout(1, 0));

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
                .addContainerGap(23, Short.MAX_VALUE))
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
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
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
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(629, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(176, 176, 176)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                    .addGap(151, 151, 151)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
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
                idModificar.setVisible(false);
                idModificar.setText(String.valueOf(elegido.getIdUsuario()));
                tfLogin1.setText(elegido.getIdLogin());
                tfApellido1.setText(elegido.getApellido());
                tfNombre1.setText(elegido.getNombre());
                cbTurno1.setSelectedItem(elegido.getTurno());
                pfContraseña1.setText("");
                pfContraseñaR1.setText("");
                showModificar();
            } else if (columna == 5) {

                if (listener != null) {
                    if (elegido.isHabilitado()) {
                        listener.deshabilitar(elegido, (Object... o) -> {
                            Boolean b = (Boolean) o[0];
                            if (b) {
//                            bedeles.remove(elegido);
                                elegido.setHabilitado(false);
                                updateBedeles(bedeles);

                            } else {
                                listener.eliminarError((Exception) o[1]);
                            }
                            return null;
                        });
                    } else {
                        listener.habilitar(elegido, (Object... o) -> {
                            Boolean b = (Boolean) o[0];
                            if (b) {
                                elegido.setHabilitado(true);
                                updateBedeles(bedeles);

                            } else {
                                listener.eliminarError((Exception) o[1]);
                            }
                            return null;
                        });
                    }
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
        try {
            String nombre = tfNombre1.getText();
            String apellido = tfApellido1.getText();
            String idLogin = tfLogin1.getText();
            TurnoBedel turno = switch (cbTurno1.getSelectedIndex()) {
                case 0 ->
                    TurnoBedel.MAÑANA;
                case 1 ->
                    TurnoBedel.TARDE;
                default ->
                    TurnoBedel.NOCHE;
            };
            String contraseña = new String(pfContraseña1.getPassword());
            String rContraseña = new String(pfContraseñaR1.getPassword());

            // rcontraseña
            if (!contraseña.equals(rContraseña)) {
                throw new Exceptions.UIException("Las contraseñas no coinciden.");
            }

            BedelDTO bedelDTO = new BedelDTO(Integer.parseInt(idModificar.getText()),idLogin, contraseña, nombre, apellido, turno, true);

            if (listener != null) {
                listener.modificar(bedelDTO);
                showBuscar();
            }

        } catch (Exceptions.UIException e) {
            if (listener != null) {
                listener.modificarError(e);
            }
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void idModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTurno1;
    private javax.swing.JTextField idModificar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
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
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido1;
    private javax.swing.JLabel lbContraseña1;
    private javax.swing.JLabel lbLogin1;
    private javax.swing.JLabel lbNombre1;
    private javax.swing.JLabel lbRContraseña1;
    private javax.swing.JLabel lbTurno1;
    private javax.swing.JPanel modificarPanel;
    private javax.swing.JPasswordField pfContraseña1;
    private javax.swing.JPasswordField pfContraseñaR1;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tableBedeles;
    private javax.swing.JTextField tfApellido1;
    private javax.swing.JTextField tfLogin1;
    private javax.swing.JTextField tfNombre1;
    // End of variables declaration//GEN-END:variables
}
