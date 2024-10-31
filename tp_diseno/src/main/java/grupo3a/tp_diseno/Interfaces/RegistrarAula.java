/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grupo3a.tp_diseno.Interfaces;

import javax.swing.ComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.event.ListDataListener;

/**
 *
 * @author imsac
 */
public class RegistrarAula extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarAula
     */
    public enum TIPO_RESERVA {
        ANUAL,
        PRIMER_CUATRIMESTRE,
        SEGUNDO_CUATRIMESTRE,
        ESPORADICA
    }
    
    public interface Listener {
        public void next();
    }

    private TIPO_RESERVA selectedTipoReserva = null;
    private final String[] tipoDeReservas = new String[] {
        "Seleccione una opcion",
        "Anual",
        "Primer Cuatrimestre",
        "Segundo Cuatrimestre",
        "Esporadica"
    };
    private Listener listener;
    
    
    public RegistrarAula() {
        initComponents();
    }
    
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public TIPO_RESERVA getSelected() {
        return selectedTipoReserva;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        boxTipoDeReserva = new javax.swing.JComboBox<>();
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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registro de reserva");
        jPanel1.add(jLabel7, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(26, 26, 26));
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 500));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 150));

        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("seleccione el tipo de reserva");

        jPanel5.setBackground(new java.awt.Color(26, 26, 26));

        boxTipoDeReserva.setBackground(new java.awt.Color(40, 40, 40));
        boxTipoDeReserva.setForeground(new java.awt.Color(255, 255, 255));
        boxTipoDeReserva.setModel(new javax.swing.DefaultComboBoxModel<>(tipoDeReservas));
        boxTipoDeReserva.setToolTipText("");
        boxTipoDeReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoDeReservaActionPerformed(evt);
            }
        });
        jPanel5.add(boxTipoDeReserva);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(60, 63, 0));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 80));

        btnCancelar.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Regresar");
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
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(26, 26, 26));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 80));

        btnRegistrar.setBackground(new java.awt.Color(17, 17, 17));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Siguiente");
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
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel8);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void boxTipoDeReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoDeReservaActionPerformed
        String s = (String)boxTipoDeReserva.getSelectedItem();
        if (s.equals(tipoDeReservas[1])) 
            selectedTipoReserva = TIPO_RESERVA.ANUAL;
        else if (s.equals(tipoDeReservas[2]))
            selectedTipoReserva = TIPO_RESERVA.PRIMER_CUATRIMESTRE;
        else if (s.equals(tipoDeReservas[3]))
            selectedTipoReserva = TIPO_RESERVA.SEGUNDO_CUATRIMESTRE;
        else if (s.equals(tipoDeReservas[4]))
            selectedTipoReserva = TIPO_RESERVA.ESPORADICA;
    }//GEN-LAST:event_boxTipoDeReservaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if(listener != null && selectedTipoReserva != null)
            listener.next();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipoDeReserva;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
