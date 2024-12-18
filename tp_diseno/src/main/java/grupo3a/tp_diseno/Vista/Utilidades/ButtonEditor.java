
package grupo3a.tp_diseno.Vista.Utilidades;

import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.ReservasSolapadas.Listener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
    JButton button;
    private String label;
    private JTable table;
    private int row;

        public ButtonEditor(String text) {
        button = new JButton(text);
        button.addActionListener(this);
        }
        


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        label = value != null ? value.toString() : "";
        button.setText(label);
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Editar".equals(label)) {
            // Lógica para editar el cliente
            System.out.println("Editar en fila " + row);
        } else if ("Borrar".equals(label)) {
            // Lógica para borrar el cliente
            System.out.println("Borrar en fila " + row);
        } else if("Ver detalle".equals(label)){
            }
        fireEditingStopped();
    }
}
