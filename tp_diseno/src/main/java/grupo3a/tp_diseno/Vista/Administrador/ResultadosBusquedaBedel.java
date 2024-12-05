package grupo3a.tp_diseno.Vista.Administrador;

import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonEditor;
import grupo3a.tp_diseno.Vista.Utilidades.ButtonRenderer;
import grupo3a.tp_diseno.Vista.Utilidades.UsuarioTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.JTableHeader;

public class ResultadosBusquedaBedel extends javax.swing.JPanel {

    public interface Listener {

        void back();
    }

    String apellido;
    TurnoBedel turno;
    List<BedelDTO> bedeles;
    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ResultadosBusquedaBedel() {
        initComponents();
//        this.bedeles = bedeles;
//        actualizarTabla();
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

        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBedeles = new javax.swing.JTable();

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

    }//GEN-LAST:event_tableBedelesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBedeles;
    // End of variables declaration//GEN-END:variables
}
