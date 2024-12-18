
package grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva;

public class CartelDetalles extends javax.swing.JPanel {

    public interface Listener {
        public void next();
    }

    private Listener listener;
    
    public CartelDetalles(){
        initComponents();
    }
    
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setTexto(String nomDoc,String apellido,String email,String nomCat){
        tfNomDoc.setText(nomDoc);
        tfApellido.setText(apellido);
        tfEmail.setText(email);
        tfNomCat.setText(nomCat);  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
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

        jPanel1.setBackground(new java.awt.Color(157, 154, 111));

        jButton2.setBackground(new java.awt.Color(17, 17, 17));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(157, 154, 111));
        jPanel10.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jPanel5.setBackground(new java.awt.Color(157, 154, 111));
        jPanel5.setLayout(new java.awt.GridLayout());

        lbNomDoc.setForeground(new java.awt.Color(255, 255, 255));
        lbNomDoc.setText("Nombre docente");
        lbNomDoc.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel5.add(lbNomDoc);

        tfNomDoc.setBackground(new java.awt.Color(40, 40, 40));
        tfNomDoc.setForeground(new java.awt.Color(255, 255, 255));
        tfNomDoc.setEnabled(false);
        tfNomDoc.setPreferredSize(new java.awt.Dimension(64, 20));
        tfNomDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomDocActionPerformed(evt);
            }
        });
        jPanel5.add(tfNomDoc);

        jPanel10.add(jPanel5);

        jPanel19.setBackground(new java.awt.Color(157, 154, 111));
        jPanel19.setLayout(new java.awt.GridLayout());

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

        jPanel10.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(157, 154, 111));
        jPanel20.setLayout(new java.awt.GridLayout());

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

        jPanel10.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(157, 154, 111));
        jPanel21.setLayout(new java.awt.GridLayout());

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

        jPanel10.add(jPanel21);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(9, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 924, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(259, 259, 259)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(259, 259, 259)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(130, 130, 130)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (listener != null)
        listener.next();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNomCat;
    private javax.swing.JLabel lbNomDoc;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNomCat;
    private javax.swing.JTextField tfNomDoc;
    // End of variables declaration//GEN-END:variables
}
