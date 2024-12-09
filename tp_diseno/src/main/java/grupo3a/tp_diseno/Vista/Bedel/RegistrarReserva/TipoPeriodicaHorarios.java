package grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva;

import grupo3a.tp_diseno.Vista.Utilidades.BordesRedondeados;
import java.time.LocalTime;
import javax.swing.DefaultComboBoxModel;

public class TipoPeriodicaHorarios extends javax.swing.JPanel {

    public interface Listener {

        void back();

        void next();
    }

    private static final String[] HORARIOS = {
        "8:00",
        "8:30",
        "9:00",
        "9:30",
        "10:00",
        "10:30",
        "11:00",
        "11:30",
        "12:00",
        "12:30",
        "13:00",
        "13:30",
        "14:00",
        "14:30",
        "15:00",
        "15:30",
        "16:00",
        "16:30",
        "17:00",
        "17:30",
        "18:00",
        "18:30",
        "19:00",
        "19:30",
        "20:00",
        "20:30",
        "21:00",
        "21:30",};

    private static final String[] DURACIONES = {
        "00:30",
        "01:00",
        "01:30",
        "02:00",
        "02:30",
        "03:00",
        "03:30",
        "04:00",
        "04:30",
        "05:00",
        "05:30",
        "06:00",
        "06:30",
        "07:00",
        "07:30",
        "08:00",
        "08:30",
        "09:00",
        "09:30",
        "10:00",
        "10:30",
        "11:00",
        "11:30",
        "12:00",
        "12:30",
        "13:00",
        "13:30",
        "14:00"
    };

    private Listener listener;
    private LocalTime[] horariosSeleccionados = new LocalTime[]{
        null, null, null, null, null
    };
    private LocalTime[] duracionesSeleccionadas = new LocalTime[]{
        null, null, null, null, null
    };

    public TipoPeriodicaHorarios() {
        initComponents();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void resetInterface() {
        horariosSeleccionados[0] = null;
        horariosSeleccionados[1] = null;
        horariosSeleccionados[2] = null;
        horariosSeleccionados[3] = null;
        horariosSeleccionados[4] = null;
        duracionesSeleccionadas[0] = null;
        duracionesSeleccionadas[1] = null;
        duracionesSeleccionadas[2] = null;
        duracionesSeleccionadas[3] = null;
        duracionesSeleccionadas[4] = null;
        setDiasHabilitados(new boolean[] {true, true, true, true, true});
        setDiasHabilitados(new boolean[] {false, false, false, false, false});
    }

    public void setDiasHabilitados(boolean[] dias) {
        cbLunesHorario.setEnabled(dias[0]);
        cbMartesHorario.setEnabled(dias[1]);
        cbMiercolesHorario.setEnabled(dias[2]);
        cbJuevesHorario.setEnabled(dias[3]);
        cbViernesHorario.setEnabled(dias[4]);

        cbLunesDuracion.setEnabled(false);
        cbMartesDuracion.setEnabled(false);
        cbMiercolesDuracion.setEnabled(false);
        cbJuevesDuracion.setEnabled(false);
        cbViernesDuracion.setEnabled(false);

        String s;
        String[] duraciones;

        if (dias[0]) {
            cbLunesHorario.setModel(new DefaultComboBoxModel<>(HORARIOS));
            cbLunesHorario.setSelectedIndex(0);
            horariosSeleccionados[0] = getTime((String) cbLunesHorario.getSelectedItem());

            s = (String) cbLunesHorario.getSelectedItem();
            duraciones = calcularDuraciones(s);
            cbLunesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
            cbLunesDuracion.setEnabled(true);
            duracionesSeleccionadas[0] = getTime((String) cbLunesDuracion.getSelectedItem());
        } else {
            cbLunesHorario.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
            cbLunesDuracion.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
        }

        if (dias[1]) {
            cbMartesHorario.setModel(new DefaultComboBoxModel<>(HORARIOS));
            cbMartesHorario.setSelectedIndex(0);
            horariosSeleccionados[1] = getTime((String) cbMartesHorario.getSelectedItem());

            s = (String) cbMartesHorario.getSelectedItem();
            duraciones = calcularDuraciones(s);
            cbMartesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
            cbMartesDuracion.setEnabled(true);
            duracionesSeleccionadas[1] = getTime((String) cbMartesDuracion.getSelectedItem());
        } else {
            cbMartesHorario.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
            cbMartesDuracion.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
        }

        if (dias[2]) {
            cbMiercolesHorario.setModel(new DefaultComboBoxModel<>(HORARIOS));
            cbMiercolesHorario.setSelectedIndex(0);
            horariosSeleccionados[2] = getTime((String) cbMiercolesHorario.getSelectedItem());

            s = (String) cbMiercolesHorario.getSelectedItem();
            duraciones = calcularDuraciones(s);
            cbMiercolesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
            cbMiercolesDuracion.setEnabled(true);
            duracionesSeleccionadas[2] = getTime((String) cbMiercolesDuracion.getSelectedItem());
        } else {
            cbMiercolesHorario.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
            cbMiercolesDuracion.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
        }

        if (dias[3]) {
            cbJuevesHorario.setModel(new DefaultComboBoxModel<>(HORARIOS));
            cbJuevesHorario.setSelectedIndex(0);
            horariosSeleccionados[3] = getTime((String) cbJuevesHorario.getSelectedItem());

            s = (String) cbJuevesHorario.getSelectedItem();
            duraciones = calcularDuraciones(s);
            cbJuevesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
            cbJuevesDuracion.setEnabled(true);
            duracionesSeleccionadas[3] = getTime((String) cbJuevesDuracion.getSelectedItem());
        } else {
            cbJuevesHorario.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
            cbJuevesDuracion.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
        }

        if (dias[4]) {
            cbViernesHorario.setModel(new DefaultComboBoxModel<>(HORARIOS));
            cbViernesHorario.setSelectedIndex(0);
            horariosSeleccionados[4] = getTime((String) cbViernesHorario.getSelectedItem());

            s = (String) cbViernesHorario.getSelectedItem();
            duraciones = calcularDuraciones(s);
            cbViernesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
            cbViernesDuracion.setEnabled(true);
            duracionesSeleccionadas[4] = getTime((String) cbViernesDuracion.getSelectedItem());
        } else {
            cbViernesHorario.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
            cbViernesDuracion.setModel(new DefaultComboBoxModel<>(new String[]{"ingrese..."}));
        }

    }

    public LocalTime[] getHorariosSeleccionados() {
        return horariosSeleccionados;
    }

    public LocalTime[] getDuracionesSeleccionadas() {
        return duracionesSeleccionadas;
    }

    private String[] calcularDuraciones(String s) {
        // buscar string en HORARIOS

        int idx = 0;
        while (idx < HORARIOS.length && !s.equals(HORARIOS[idx])) {
            idx++;
        }

        int limit = DURACIONES.length - idx;

        String[] duraciones = new String[limit];
        for (int i = 0; i < limit; i++) {
            duraciones[i] = DURACIONES[i];
        }
        return duraciones;
    }

    private LocalTime getTime(String s) {
        String[] parts = s.split(":");
        return LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbLunesHorario = new javax.swing.JComboBox<>();
        cbMartesHorario = new javax.swing.JComboBox<>();
        cbMiercolesHorario = new javax.swing.JComboBox<>();
        cbJuevesHorario = new javax.swing.JComboBox<>();
        cbViernesHorario = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbLunesDuracion = new javax.swing.JComboBox<>();
        cbMartesDuracion = new javax.swing.JComboBox<>();
        cbMiercolesDuracion = new javax.swing.JComboBox<>();
        cbJuevesDuracion = new javax.swing.JComboBox<>();
        cbViernesDuracion = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setBackground(new java.awt.Color(19, 66, 125));
        jPanel1.setForeground(new java.awt.Color(19, 66, 126));
        jPanel1.setPreferredSize(new java.awt.Dimension(424, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registro de reserva");
        jPanel1.add(jLabel7, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(26, 26, 26));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 300));

        jLabel1.setBackground(new java.awt.Color(26, 26, 26));
        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("seleccione los horarios de la reserva");

        jPanel5.setBackground(new java.awt.Color(26, 26, 26));
        jPanel5.setPreferredSize(new java.awt.Dimension(815, 200));

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 155));
        jPanel3.setLayout(new java.awt.GridLayout(0, 1, 0, 20));

        jPanel6.setBackground(new java.awt.Color(26, 26, 26));
        jPanel6.setPreferredSize(new java.awt.Dimension(467, 30));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setBackground(new java.awt.Color(28, 28, 28));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(28, 28, 28));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lunes");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel3);

        jLabel5.setBackground(new java.awt.Color(28, 28, 28));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Martes");
        jLabel5.setToolTipText("");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel5);

        jLabel4.setBackground(new java.awt.Color(28, 28, 28));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Miercoles");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel4);

        jLabel6.setBackground(new java.awt.Color(28, 28, 28));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Jueves");
        jLabel6.setToolTipText("");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel6);

        jLabel8.setBackground(new java.awt.Color(28, 28, 28));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Viernes");
        jLabel8.setToolTipText("");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(10, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel6.add(jLabel8);

        jPanel3.add(jPanel6);

        jPanel16.setBackground(new java.awt.Color(26, 26, 26));
        jPanel16.setLayout(new java.awt.GridLayout(1, 1, 20, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("<html>Horarios de <br>inicio</html>");
        jPanel16.add(jLabel10);

        cbLunesHorario.setBackground(new java.awt.Color(40, 40, 40));
        cbLunesHorario.setForeground(new java.awt.Color(255, 255, 255));
        cbLunesHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbLunesHorario.setBorder(null);
        cbLunesHorario.setDoubleBuffered(true);
        cbLunesHorario.setEnabled(false);
        cbLunesHorario.setFocusable(false);
        cbLunesHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLunesHorarioActionPerformed(evt);
            }
        });
        jPanel16.add(cbLunesHorario);

        cbMartesHorario.setBackground(new java.awt.Color(40, 40, 40));
        cbMartesHorario.setForeground(new java.awt.Color(255, 255, 255));
        cbMartesHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbMartesHorario.setDoubleBuffered(true);
        cbMartesHorario.setEnabled(false);
        cbMartesHorario.setFocusable(false);
        cbMartesHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMartesHorarioActionPerformed(evt);
            }
        });
        jPanel16.add(cbMartesHorario);

        cbMiercolesHorario.setBackground(new java.awt.Color(40, 40, 40));
        cbMiercolesHorario.setForeground(new java.awt.Color(255, 255, 255));
        cbMiercolesHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbMiercolesHorario.setDoubleBuffered(true);
        cbMiercolesHorario.setEnabled(false);
        cbMiercolesHorario.setFocusable(false);
        cbMiercolesHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMiercolesHorarioActionPerformed(evt);
            }
        });
        jPanel16.add(cbMiercolesHorario);

        cbJuevesHorario.setBackground(new java.awt.Color(40, 40, 40));
        cbJuevesHorario.setForeground(new java.awt.Color(255, 255, 255));
        cbJuevesHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbJuevesHorario.setDoubleBuffered(true);
        cbJuevesHorario.setEnabled(false);
        cbJuevesHorario.setFocusable(false);
        cbJuevesHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJuevesHorarioActionPerformed(evt);
            }
        });
        jPanel16.add(cbJuevesHorario);

        cbViernesHorario.setBackground(new java.awt.Color(40, 40, 40));
        cbViernesHorario.setForeground(new java.awt.Color(255, 255, 255));
        cbViernesHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbViernesHorario.setDoubleBuffered(true);
        cbViernesHorario.setEnabled(false);
        cbViernesHorario.setFocusable(false);
        cbViernesHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViernesHorarioActionPerformed(evt);
            }
        });
        jPanel16.add(cbViernesHorario);

        jPanel3.add(jPanel16);

        jPanel15.setBackground(new java.awt.Color(26, 26, 26));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.GridLayout(1, 1, 20, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Duracion");
        jLabel9.setToolTipText("");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel15.add(jLabel9);

        cbLunesDuracion.setBackground(new java.awt.Color(40, 40, 40));
        cbLunesDuracion.setForeground(new java.awt.Color(255, 255, 255));
        cbLunesDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbLunesDuracion.setEnabled(false);
        cbLunesDuracion.setFocusable(false);
        cbLunesDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLunesDuracionActionPerformed(evt);
            }
        });
        jPanel15.add(cbLunesDuracion);

        cbMartesDuracion.setBackground(new java.awt.Color(40, 40, 40));
        cbMartesDuracion.setForeground(new java.awt.Color(255, 255, 255));
        cbMartesDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbMartesDuracion.setEnabled(false);
        cbMartesDuracion.setFocusable(false);
        cbMartesDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMartesDuracionActionPerformed(evt);
            }
        });
        jPanel15.add(cbMartesDuracion);

        cbMiercolesDuracion.setBackground(new java.awt.Color(40, 40, 40));
        cbMiercolesDuracion.setForeground(new java.awt.Color(255, 255, 255));
        cbMiercolesDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbMiercolesDuracion.setEnabled(false);
        cbMiercolesDuracion.setFocusable(false);
        cbMiercolesDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMiercolesDuracionActionPerformed(evt);
            }
        });
        jPanel15.add(cbMiercolesDuracion);

        cbJuevesDuracion.setBackground(new java.awt.Color(40, 40, 40));
        cbJuevesDuracion.setForeground(new java.awt.Color(255, 255, 255));
        cbJuevesDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbJuevesDuracion.setEnabled(false);
        cbJuevesDuracion.setFocusable(false);
        cbJuevesDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJuevesDuracionActionPerformed(evt);
            }
        });
        jPanel15.add(cbJuevesDuracion);

        cbViernesDuracion.setBackground(new java.awt.Color(40, 40, 40));
        cbViernesDuracion.setForeground(new java.awt.Color(255, 255, 255));
        cbViernesDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ingrese..." }));
        cbViernesDuracion.setEnabled(false);
        cbViernesDuracion.setFocusable(false);
        cbViernesDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViernesDuracionActionPerformed(evt);
            }
        });
        jPanel15.add(cbViernesDuracion);

        jPanel3.add(jPanel15);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(28, 28, 28));
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
            .addGap(0, 447, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap(140, Short.MAX_VALUE)
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
            .addGap(0, 447, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(140, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel8);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        if (listener != null) {
            listener.back();
        }
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegistrarActionPerformed

        if (listener != null) {
            listener.next();
        }

    }// GEN-LAST:event_btnRegistrarActionPerformed

    private void cbLunesHorarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbLunesHorarioActionPerformed
        String s = (String) cbLunesHorario.getSelectedItem();
        String[] duraciones = calcularDuraciones(s);
        cbLunesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
        horariosSeleccionados[0] = getTime((String) cbLunesHorario.getSelectedItem());
    }// GEN-LAST:event_cbLunesHorarioActionPerformed

    private void cbMartesHorarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMartesHorarioActionPerformed
        String s = (String) cbMartesHorario.getSelectedItem();
        String[] duraciones = calcularDuraciones(s);
        cbMartesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
        horariosSeleccionados[1] = getTime((String) cbMartesHorario.getSelectedItem());
    }// GEN-LAST:event_cbMartesHorarioActionPerformed

    private void cbMiercolesHorarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMiercolesHorarioActionPerformed
        String s = (String) cbMiercolesHorario.getSelectedItem();
        String[] duraciones = calcularDuraciones(s);
        cbMiercolesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
        horariosSeleccionados[2] = getTime((String) cbMiercolesHorario.getSelectedItem());
    }// GEN-LAST:event_cbMiercolesHorarioActionPerformed

    private void cbJuevesHorarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbJuevesHorarioActionPerformed
        String s = (String) cbJuevesHorario.getSelectedItem();
        String[] duraciones = calcularDuraciones(s);
        cbJuevesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
        horariosSeleccionados[3] = getTime((String) cbJuevesHorario.getSelectedItem());
    }// GEN-LAST:event_cbJuevesHorarioActionPerformed

    private void cbViernesHorarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbViernesHorarioActionPerformed
        String s = (String) cbViernesHorario.getSelectedItem();
        String[] duraciones = calcularDuraciones(s);
        cbViernesDuracion.setModel(new DefaultComboBoxModel<>(duraciones));
        horariosSeleccionados[4] = getTime((String) cbViernesHorario.getSelectedItem());
    }// GEN-LAST:event_cbViernesHorarioActionPerformed

    private void cbLunesDuracionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbLunesDuracionActionPerformed
        duracionesSeleccionadas[0] = getTime((String) cbLunesDuracion.getSelectedItem());
    }// GEN-LAST:event_cbLunesDuracionActionPerformed

    private void cbMartesDuracionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMartesDuracionActionPerformed
        duracionesSeleccionadas[1] = getTime((String) cbMartesDuracion.getSelectedItem());
    }// GEN-LAST:event_cbMartesDuracionActionPerformed

    private void cbMiercolesDuracionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMiercolesDuracionActionPerformed
        duracionesSeleccionadas[2] = getTime((String) cbMiercolesDuracion.getSelectedItem());
    }// GEN-LAST:event_cbMiercolesDuracionActionPerformed

    private void cbJuevesDuracionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbJuevesDuracionActionPerformed
        duracionesSeleccionadas[3] = getTime((String) cbJuevesDuracion.getSelectedItem());
    }// GEN-LAST:event_cbJuevesDuracionActionPerformed

    private void cbViernesDuracionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbViernesDuracionActionPerformed
        duracionesSeleccionadas[4] = getTime((String) cbViernesDuracion.getSelectedItem());
    }// GEN-LAST:event_cbViernesDuracionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbJuevesDuracion;
    private javax.swing.JComboBox<String> cbJuevesHorario;
    private javax.swing.JComboBox<String> cbLunesDuracion;
    private javax.swing.JComboBox<String> cbLunesHorario;
    private javax.swing.JComboBox<String> cbMartesDuracion;
    private javax.swing.JComboBox<String> cbMartesHorario;
    private javax.swing.JComboBox<String> cbMiercolesDuracion;
    private javax.swing.JComboBox<String> cbMiercolesHorario;
    private javax.swing.JComboBox<String> cbViernesDuracion;
    private javax.swing.JComboBox<String> cbViernesHorario;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
