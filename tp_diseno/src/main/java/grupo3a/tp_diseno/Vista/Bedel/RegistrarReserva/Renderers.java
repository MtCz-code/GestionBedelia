/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author imsac
 */
public class Renderers {

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

    private interface TableListener {

        void addRow();

        void horarioChange(int row, String time);

        void delRow(int idx);
    }

    private static LocalTime getTime(String s) {
        String[] parts = s.split(":");
        return LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    private static String[] calcularDuraciones(String s) {
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

    public static class TableController {

        private JTable table;
        private String[] columnNames = {"Dias", "hora", "duracion", "eliminar"};

        private DateRenderer dateRenderer;
        private DateEditor dateEditor;
        private CBHorariosRenderer cBHorariosRenderer;
        private CBHorariosEditor cBHorariosEditor;
        private CBDuracionesRenderer cBDuracionesRenderer;
        private CBDuracionesEditor cBDuracionesEditor;

        private DefaultTableModel tableModel;

        private TableListener listener = new TableListener() {
            @Override
            public void addRow() {
                addDataRow(getDefaultRow());
            }

            @Override
            public void horarioChange(int row, String time) {
                System.out.println("updateData(" + row + ", 2): "  + time);
                Object[][] data = getTableData();
                data[row][1] = time;
                data[row][2] = DURACIONES[0];;
                updateData(data);
//                updateData(null);

            }

            @Override
            public void delRow(int idx) {
                delDataRow(idx);
            }
        };

        public TableController(JTable table) {
            this.table = table;
        }

        public void setData(Object[][] data) {
            if(data == null) {
                data = new Object[0][];
            }
            else 
                updateData(data);
        }

        // actualiza los datos de la tabla (si es null usa los datos q ya estaban)
        private void updateData(Object[][] d) {
            Object[][] tableData;
            if (d == null) {
                tableData = formatTableData(getTableData());
            } else {
                tableData = formatTableData(d);
            }
            tableModel = new DefaultTableModel(tableData, columnNames);

            table.setModel(tableModel);
            setRenderers();

        }

        private void setRenderers() {
            table.setCellSelectionEnabled(false);

            dateRenderer = new DateRenderer(table);
            dateEditor = new DateEditor(table, listener);

            cBHorariosRenderer = new CBHorariosRenderer(HORARIOS);
            cBHorariosEditor = new CBHorariosEditor(table, HORARIOS, listener);

            cBDuracionesRenderer = new CBDuracionesRenderer();
            cBDuracionesEditor = new CBDuracionesEditor(table, HORARIOS, null);

            table.getColumnModel().getColumn(0).setCellRenderer(dateRenderer);
            table.getColumnModel().getColumn(0).setCellEditor(dateEditor);

            table.getColumnModel().getColumn(1).setCellRenderer(cBHorariosRenderer);
            table.getColumnModel().getColumn(1).setCellEditor(cBHorariosEditor);

            table.getColumnModel().getColumn(2).setCellRenderer(cBDuracionesRenderer);
            table.getColumnModel().getColumn(2).setCellEditor(cBDuracionesEditor);

            table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(table, listener));
        }

        private Object[] getDefaultRow() {
            return new Object[]{new Date(), HORARIOS[0], DURACIONES[0]};
        }

        private void addDataRow(Object[] d) {
            Object[][] data = getTableData();
            Object[][] ndata = new Object[data.length + 1][];
            for (int i = 0; i < data.length; i++) {
                ndata[i] = new Object[4];
                ndata[i][0] = data[i][0];
                ndata[i][1] = data[i][1];
                ndata[i][2] = data[i][2];
            }
            ndata[data.length] = d;
            data = ndata;
            updateData(data);

        }

        private void delDataRow(int idx) {
            Object[][] data = getTableData();
            Object[][] ndata = new Object[data.length - 1][];
            for (int i = 0; i < data.length - 1; i++) {
                int i2 = i;
                if (i >= idx) {
                    i2++;
                }

                ndata[i] = new Object[4];
                ndata[i][0] = data[i2][0];
                ndata[i][1] = data[i2][1];
                ndata[i][2] = data[i2][2];
            }
            data = ndata;
            updateData(data);
        }

        // raw data
        public Object[][] getTableData() {
            int rows = table.getRowCount();
            Object[][] data = new Object[rows - 1][];

            for (int i = 0; i < rows - 1; i++) {
                data[i] = new Object[3];
                for (int j = 0; j < 3; j++) {
                    data[i][j] = table.getValueAt(i, j);
                }
            }
            return data;
        }

        // formatea los datos (agrega una col y una fil)
        private Object[][] formatTableData(Object[][] data) {
            Object[][] tableData = new Object[data.length + 1][];
            for (int i = 0; i < data.length; i++) {
                tableData[i] = new Object[4];
                tableData[i][0] = data[i][0];
                tableData[i][1] = data[i][1];
                tableData[i][2] = data[i][2];
            }
            tableData[data.length] = new Object[]{null, "", "", ""};
            return tableData;
        }

    }

    public static class DateRenderer extends JPanel implements TableCellRenderer {

        private JDateChooser dateChooser;
        private JButton addBtn;

        public DateRenderer(JTable table) {
            setLayout(new BorderLayout());
            dateChooser = new JDateChooser();
            addBtn = new JButton("agregar");
            add(dateChooser);
        }

        public JDateChooser getDateChooser() {
            return dateChooser;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            Date date = (Date) table.getValueAt(row, column);
            dateChooser.setDate(date);

            if (isSelected) {
                setBackground(table.getSelectionBackground());
                dateChooser.setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
                dateChooser.setBackground(table.getBackground());
            }

            if (row == table.getRowCount() - 1) {
                return addBtn;
            } else {
                return this;
            }

        }
    }

    public static class DateEditor extends AbstractCellEditor implements TableCellEditor {

        private JPanel panel;
        private JDateChooser dateChooser;
        private JButton addBtn;

        public DateEditor(JTable table, TableListener listener) {
            panel = new JPanel(new BorderLayout());
            dateChooser = new JDateChooser();
            dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {

                }
            });
            addBtn = new JButton("agregar");
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listener != null) {
                        listener.addRow();
                    }
                }
            });
            panel.add(dateChooser, BorderLayout.CENTER);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            Date date = (Date) table.getValueAt(row, column);
            dateChooser.setDate(date);
            if (row == table.getRowCount() - 1) {
                return addBtn;
            } else {
                return panel;
            }
        }

        @Override
        public Object getCellEditorValue() {
            return dateChooser.getDate();
        }
    }

    // horarios
    public static class CBHorariosRenderer extends JComboBox<String> implements TableCellRenderer {

        public CBHorariosRenderer(String[] items) {
            super(items);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }

            setSelectedItem(value);

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return this;
            }
        }
    }

    public static class CBHorariosEditor extends DefaultCellEditor {

        private JComboBox<String> cb;
        private String lastValue;
        private TableListener listener;

        private ItemListener actionListener;
        private int currentRow = 0;
        private boolean ready;

        public CBHorariosEditor(JTable table, String[] items, TableListener listener) {
            super(new JComboBox<>(items));
            cb = (JComboBox<String>) getComponent();
            lastValue = items[0];
            this.listener = listener;

            cb.addItemListener((ItemEvent e) -> {
                if (!ready) {
                    return;
                }

                String seleccion = (String) cb.getSelectedItem();
                if (e.getStateChange() != ItemEvent.SELECTED) {
                    return;
                }

                System.out.println("Seleccionaste: " + seleccion);
                ready = false;
                if (listener != null) {
                    listener.horarioChange(currentRow, seleccion);
                }
            });

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            cb.setSelectedItem(value);
            currentRow = row;
            ready = true;

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return cb;
            }
        }
    }

    // duraciones
    public static class CBDuracionesRenderer extends JComboBox<String> implements TableCellRenderer {

        public CBDuracionesRenderer() {
            super(DURACIONES);
            setOpaque(true);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }

            setSelectedItem(value);

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return this;
            }
        }
    }

    public static class CBDuracionesEditor extends DefaultCellEditor {

        private JComboBox<String> cb;

        public CBDuracionesEditor(JTable table, String[] items, TableListener listener) {
            super(new JComboBox<>(items));
            cb = (JComboBox<String>) getComponent();
        }

        private String getHorario(JTable table, int row) {
            return (String) table.getValueAt(row, 1);
        }

        private void actualizarItems(String[] items) {
            cb.removeAllItems();

            for (int i = 0; i < items.length; i++) {
                cb.addItem(items[i]);
            }

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {

            String horario = getHorario(table, row);

            String[] duraciones = calcularDuraciones(horario);

            actualizarItems(duraciones);

            cb.setSelectedItem(value);

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return cb;
            }
        }
    }

    // eliminar
    public static class ButtonRenderer extends JPanel implements TableCellRenderer {

        private final JButton button;

        public ButtonRenderer() {
            setLayout(new BorderLayout());
            button = new JButton("Eliminar");
            add(button, BorderLayout.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return this;
            }

        }
    }

    public static class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private final JPanel panel;
        private final JButton button;

        public ButtonEditor(JTable table, TableListener listener) {
            panel = new JPanel(new BorderLayout());
            button = new JButton("Eliminar");

            panel.add(button, BorderLayout.CENTER);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    listener.delRow(row);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {

            if (row == table.getRowCount() - 1) {
                return null;
            } else {
                return panel;
            }
        }

        @Override
        public Object getCellEditorValue() {
            return "Eliminar";
        }
    }

}
