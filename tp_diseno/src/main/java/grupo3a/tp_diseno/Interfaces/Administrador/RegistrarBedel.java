
package grupo3a.tp_diseno.Interfaces.Administrador;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Interfaces.Utilidades.BordesRedondeados;
import java.awt.Dimension;


public class RegistrarBedel extends javax.swing.JPanel {

    public interface Listener {
        void back();
        void next();
    }
    
    private Listener listener;
    
    private String nombre = "";
    private String apellido = "";
    private String idLogin = "";
    private TurnoBedel turno = TurnoBedel.MAÑANA;
    private String contraseña = "";
    private String rContraseña = "";
    
    public RegistrarBedel() {
        initComponents();
        this.setPreferredSize(new Dimension(300,300));
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getIdLogin() {
        return idLogin;
    }

    public TurnoBedel getTurno() {
        return turno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getrContraseña() {
        return rContraseña;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbTurno = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        lbContraseña = new javax.swing.JLabel();
        pfContraseña = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lbRContraseña = new javax.swing.JLabel();
        pfContraseñaR = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(19, 66, 125));
        jPanel1.setForeground(new java.awt.Color(19, 66, 126));
        jPanel1.setPreferredSize(new java.awt.Dimension(424, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registrar Bedel");
        jLabel7.setPreferredSize(new java.awt.Dimension(294, 450));
        jPanel1.add(jLabel7, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(26, 26, 26));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 120));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese los datos del bedel");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Montserrat Thin Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>La contraseña debe tener una longitud mínima de 8 caracteres,  debe contener signos especiales (@#$%&*), <br>  al menos una letra mayúscula, y al menos un dígito</html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(150, 150, 150))
            .addComponent(jLabel8)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4);

        jPanel11.setBackground(new java.awt.Color(26, 26, 26));
        jPanel11.setPreferredSize(new java.awt.Dimension(977, 0));

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel3);

        jPanel10.setBackground(new java.awt.Color(26, 26, 26));
        jPanel10.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jPanel13.setBackground(new java.awt.Color(26, 26, 26));
        jPanel13.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("(*)");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel6.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel13.add(jLabel6);

        jPanel5.setBackground(new java.awt.Color(26, 26, 26));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setText("Nombre de usuario");
        lbLogin.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel5.add(lbLogin);

        tfLogin.setBackground(new java.awt.Color(40, 40, 40));
        tfLogin.setForeground(new java.awt.Color(255, 255, 255));
        tfLogin.setPreferredSize(new java.awt.Dimension(64, 20));
        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });
        jPanel5.add(tfLogin);

        jPanel13.add(jPanel5);

        jPanel10.add(jPanel13);

        jPanel12.setBackground(new java.awt.Color(26, 26, 26));
        jPanel12.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("(*)");
        jLabel2.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel12.add(jLabel2);

        jPanel19.setBackground(new java.awt.Color(26, 26, 26));
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        lbApellido.setForeground(new java.awt.Color(255, 255, 255));
        lbApellido.setText("Apellido");
        lbApellido.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel19.add(lbApellido);

        tfApellido.setBackground(new java.awt.Color(40, 40, 40));
        tfApellido.setForeground(new java.awt.Color(255, 255, 255));
        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });
        jPanel19.add(tfApellido);

        jPanel12.add(jPanel19);

        jPanel10.add(jPanel12);

        jPanel14.setBackground(new java.awt.Color(26, 26, 26));
        jPanel14.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("(*)");
        jLabel3.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel14.add(jLabel3);

        jPanel20.setBackground(new java.awt.Color(26, 26, 26));
        jPanel20.setLayout(new java.awt.GridLayout(1, 0));

        lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre.setText("Nombre");
        lbNombre.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel20.add(lbNombre);

        tfNombre.setBackground(new java.awt.Color(40, 40, 40));
        tfNombre.setForeground(new java.awt.Color(255, 255, 255));
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        jPanel20.add(tfNombre);

        jPanel14.add(jPanel20);

        jPanel10.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(26, 26, 26));
        jPanel15.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("(*)");
        jLabel4.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel15.add(jLabel4);

        jPanel21.setBackground(new java.awt.Color(26, 26, 26));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        lbTurno.setForeground(new java.awt.Color(255, 255, 255));
        lbTurno.setText("Turno en el que trabaja");
        lbTurno.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel21.add(lbTurno);

        cbTurno.setBackground(new java.awt.Color(40, 40, 40));
        cbTurno.setForeground(new java.awt.Color(255, 255, 255));
        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        cbTurno.setToolTipText("");
        cbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnoActionPerformed(evt);
            }
        });
        jPanel21.add(cbTurno);

        jPanel15.add(jPanel21);

        jPanel10.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(26, 26, 26));
        jPanel16.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("(*)");
        jLabel5.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel16.add(jLabel5);

        jPanel22.setBackground(new java.awt.Color(26, 26, 26));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        lbContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbContraseña.setText("Contraseña");
        lbContraseña.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel22.add(lbContraseña);

        pfContraseña.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseña.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaActionPerformed(evt);
            }
        });
        jPanel22.add(pfContraseña);

        jPanel16.add(jPanel22);

        jPanel10.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(26, 26, 26));
        jPanel17.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("(*)");
        jLabel9.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel17.add(jLabel9);

        jPanel23.setBackground(new java.awt.Color(26, 26, 26));
        jPanel23.setLayout(new java.awt.GridLayout(1, 0));

        lbRContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbRContraseña.setText("Repetir contraseña");
        lbRContraseña.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel23.add(lbRContraseña);

        pfContraseñaR.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseñaR.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseñaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaRActionPerformed(evt);
            }
        });
        jPanel23.add(pfContraseñaR);

        jPanel17.add(jPanel23);

        jPanel10.add(jPanel17);

        jPanel11.add(jPanel10);

        jPanel2.add(jPanel11);

        jPanel6.setPreferredSize(new java.awt.Dimension(977, 80));

        jPanel7.setBackground(new java.awt.Color(60, 63, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 80));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 80));

        btnCancelar.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel7.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(26, 26, 26));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 80));

        btnRegistrar.setBackground(new java.awt.Color(17, 17, 17));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(new BordesRedondeados(20));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel7.add(jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel6);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
        idLogin = tfLogin.getText();
    }//GEN-LAST:event_tfLoginActionPerformed

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed
        apellido = tfApellido.getText();
    }//GEN-LAST:event_tfApellidoActionPerformed

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed
        
        if (cbTurno.getSelectedIndex() == 0) // mañana
            turno = TurnoBedel.MAÑANA;
        else if (cbTurno.getSelectedIndex() == 1) // tarde
            turno = TurnoBedel.TARDE;
        else  // noche
            turno = TurnoBedel.NOCHE;
        
        
    }//GEN-LAST:event_cbTurnoActionPerformed

    private void pfContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaActionPerformed
        contraseña = new String(pfContraseña.getPassword());
    }//GEN-LAST:event_pfContraseñaActionPerformed

    private void pfContraseñaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaRActionPerformed
        rContraseña = new String(pfContraseñaR.getPassword());
    }//GEN-LAST:event_pfContraseñaRActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        
        nombre = tfNombre.getText();
        apellido = tfApellido.getText();
        idLogin = tfLogin.getText();
        contraseña = new String(pfContraseña.getPassword());
        rContraseña = new String(pfContraseñaR.getPassword());

        if (listener != null)
            listener.next();
        
        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
         nombre = tfNombre.getText();
    }//GEN-LAST:event_tfNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRContraseña;
    private javax.swing.JLabel lbTurno;
    private javax.swing.JPasswordField pfContraseña;
    private javax.swing.JPasswordField pfContraseñaR;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
