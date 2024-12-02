
package grupo3a.tp_diseno.Interfaces.Utilidades;

import grupo3a.tp_diseno.DTOs.BedelDTO;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel<T> extends AbstractTableModel {
    private List<T> data; 
    private String[] columnNames; 
    private Field[] fields; 
    
    public UsuarioTableModel(List<T> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
        
        
        if (!data.isEmpty()) {
            fields = data.get(0).getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); 
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; 
    }

        @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T rowObject = data.get(rowIndex);

        try {
            if (rowObject instanceof BedelDTO) {
                BedelDTO bedel = (BedelDTO) rowObject;
                switch (columnIndex) {
                    case 0 -> {
                        return bedel.getNombre();
                    }
                    case 1 -> {
                        return bedel.getApellido();
                    }
                    case 2 -> {
                        return bedel.getTurno();
                    }
                    case 3 -> {
                        return bedel.isHabilitado();
                    }
                    case 4 -> {
                        return "Editar";
                    }
                    case 5 -> {
                        return "Borrar";
                    }
                }
            } else {
                rowObject = data.get(rowIndex); 
                return fields[columnIndex].get(rowObject);
            }
        } catch (IllegalAccessException e) {
        }
        return null;
    }
    

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; 
    }


    @Override
    public boolean isCellEditable(int row,int col){
       return false; 
    }
    
}
