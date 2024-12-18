package grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Vista.Utilidades.BordesRedondeados;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonEditor;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonRenderer;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;

public class ReservasSolapadas extends javax.swing.JPanel {

    public interface Listener {

        void back();

        void menu();

        void next();
    }

    private Listener listener;
    List<ReservaDTO> reservas;
    HashMap<DetalleReservaDTO, AulaDTO> aulas;

    public ReservasSolapadas() {
        initComponents();
        rootPanel.add(jPanel11, "showDetalles");
    }

    public void showDetalles() {
        CardLayout cl = (CardLayout) rootPanel.getLayout();
        cl.show(rootPanel, "showDetalles");
    }

    public void showSolapadas() {
        CardLayout cl = (CardLayout) rootPanel.getLayout();
        cl.show(rootPanel, "card2");
    }

    public void updateAulas(HashMap<DetalleReservaDTO, AulaDTO> aulas) {
        this.aulas = aulas;
        actualizarTabla();
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbNomDoc = new javax.swing.JLabel();
        tfNomDoc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        lbApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        lbNomCat = new javax.swing.JLabel();
        tfNomCat = new javax.swing.JTextField();
        rootPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReservas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();

        jPanel11.setBackground(new java.awt.Color(157, 154, 111));

        jButton2.setBackground(new java.awt.Color(17, 17, 17));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(157, 154, 111));
        jPanel12.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jPanel13.setBackground(new java.awt.Color(157, 154, 111));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        lbNomDoc.setForeground(new java.awt.Color(255, 255, 255));
        lbNomDoc.setText("Nombre docente");
        lbNomDoc.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel13.add(lbNomDoc);

        tfNomDoc.setBackground(new java.awt.Color(40, 40, 40));
        tfNomDoc.setForeground(new java.awt.Color(255, 255, 255));
        tfNomDoc.setEnabled(false);
        tfNomDoc.setPreferredSize(new java.awt.Dimension(64, 20));
        tfNomDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomDocActionPerformed(evt);
            }
        });
        jPanel13.add(tfNomDoc);

        jPanel12.add(jPanel13);

        jPanel19.setBackground(new java.awt.Color(157, 154, 111));
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        lbApellido.setBackground(new java.awt.Color(157, 154, 111));
        lbApellido.setForeground(new java.awt.Color(255, 255, 255));
        lbApellido.setText("Apellido docente");
        lbApellido.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel19.add(lbApellido);

        tfApellido.setBackground(new java.awt.Color(40, 40, 40));
        tfApellido.setForeground(new java.awt.Color(255, 255, 255));
        tfApellido.setEnabled(false);
        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });
        jPanel19.add(tfApellido);

        jPanel12.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(157, 154, 111));
        jPanel20.setLayout(new java.awt.GridLayout(1, 0));

        lbEmail.setForeground(new java.awt.Color(255, 255, 255));
        lbEmail.setText("Email docente");
        lbEmail.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel20.add(lbEmail);

        tfEmail.setBackground(new java.awt.Color(40, 40, 40));
        tfEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfEmail.setEnabled(false);
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        jPanel20.add(tfEmail);

        jPanel12.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(157, 154, 111));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        lbNomCat.setForeground(new java.awt.Color(255, 255, 255));
        lbNomCat.setText("Nombre cátedra");
        lbNomCat.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel21.add(lbNomCat);

        tfNomCat.setBackground(new java.awt.Color(40, 40, 40));
        tfNomCat.setForeground(new java.awt.Color(255, 255, 255));
        tfNomCat.setEnabled(false);
        tfNomCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomCatActionPerformed(evt);
            }
        });
        jPanel21.add(tfNomCat);

        jPanel12.add(jPanel21);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(9, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new java.awt.Color(19, 66, 125));
        jPanel2.setForeground(new java.awt.Color(19, 66, 126));
        jPanel2.setPreferredSize(new java.awt.Dimension(424, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registro de reserva");
        jPanel2.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 300));

        jLabel1.setBackground(new java.awt.Color(26, 26, 26));
        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservas preexistentes en el plazo solicitado");

        jPanel5.setBackground(new java.awt.Color(26, 26, 26));
        jPanel5.setPreferredSize(new java.awt.Dimension(815, 200));

        jPanel6.setBackground(new java.awt.Color(26, 26, 26));
        jPanel6.setPreferredSize(new java.awt.Dimension(650, 95));
        jPanel6.setLayout(new java.awt.GridLayout(0, 1, 0, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableReservas.setForeground(new java.awt.Color(102, 102, 102));
        tableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableReservas.setMinimumSize(new java.awt.Dimension(100, 50));
        tableReservas.setPreferredSize(new java.awt.Dimension(650, 95));
        tableReservas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReservas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(28, 28, 28));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 80));

        btnRegresar.setBackground(new java.awt.Color(17, 17, 17));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(137, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(26, 26, 26));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 80));

        btnMenu.setBackground(new java.awt.Color(17, 17, 17));
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menú principal");
        btnMenu.setBorder(new BordesRedondeados(20));
        btnMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenu.setPreferredSize(new java.awt.Dimension(110, 40));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(137, Short.MAX_VALUE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel8);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel3);

        rootPanel.add(jPanel1, "card2");

        add(rootPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        if (listener != null) {
            listener.menu();
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReservasMouseClicked
        int fila = tableReservas.rowAtPoint(evt.getPoint());
        int columna = tableReservas.columnAtPoint(evt.getPoint());
        //asignar reserva para ver datos
        if (!tableReservas.getValueAt(fila, 0).equals("") && !tableReservas.getValueAt(fila, 1).equals("")
                && !tableReservas.getValueAt(fila, 2).equals("") && !tableReservas.getValueAt(fila, 3).equals("")) {
            if (columna == 4) {
                tfNomDoc.setText(reservas.get(columna).getNombreDocente());
                tfApellido.setText(reservas.get(columna).getApellidoDocente());
                tfEmail.setText(reservas.get(columna).getEmailDocente());
                tfNomCat.setText(reservas.get(columna).getNombreCatedra());
                showDetalles();
            }
        }
    }//GEN-LAST:event_tableReservasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        if (listener != null)
//            listener.next();
        showSolapadas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfNomDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomDocActionPerformed

    }//GEN-LAST:event_tfNomDocActionPerformed

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed

    }//GEN-LAST:event_tfApellidoActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void tfNomCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomCatActionPerformed

    }//GEN-LAST:event_tfNomCatActionPerformed

    private void actualizarTabla() {
        // Define los nombres de las columnas
        String[] columnNames = {"Aula", "Día", "Horario", "Modulos", ""};

        // Crea los datos para la tabla a partir del HashMap
        Object[][] data = new Object[aulas.size()][5];
        int rowIndex = 0;

        for (HashMap.Entry<DetalleReservaDTO, AulaDTO> entry : aulas.entrySet()) {
            DetalleReservaDTO detalle = entry.getKey();
            AulaDTO aula = entry.getValue();

            data[rowIndex][0] = aula.getUbicacion();
            data[rowIndex][1] = detalle.getFecha();
            data[rowIndex][2] = detalle.getHorarioInicio();
            data[rowIndex][3] = detalle.getCantModulos();
            data[rowIndex][4] = "Ver detalle";
            rowIndex++;
        }

        // Crea un modelo para la tabla
        tableReservas.setModel(new javax.swing.table.DefaultTableModel(
                data, columnNames
        ));

        tableReservas.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("Ver detalle"));

        // Editores para las columnas
        tableReservas.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor("Ver detalle"));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNomCat;
    private javax.swing.JLabel lbNomDoc;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tableReservas;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNomCat;
    private javax.swing.JTextField tfNomDoc;
    // End of variables declaration//GEN-END:variables
}
