package shop.controls.event;

import javax.swing.JTable;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableModel;

public class TableIndexControl {

    public int rowSelector = 0;
    public int columnOfKey = 0;
    private final JTable table;
    private final TableModel model;

    public Object getKeyOnTable() {
        return table.getValueAt(rowSelector, columnOfKey);
    }

    public TableIndexControl(JTable table) {
        this.table = table;
        this.model = table.getModel();
        this.table.getColumnModel().addColumnModelListener(this.evtColumn());
    }

    // Table haeder control 
    // >>> moved column >> change this.column > get at location with id
    private TableColumnModelListener evtColumn() {
        // first load >>> first id at 0
        String colName = model.getColumnName(this.columnOfKey);

        return new ColumnMoved() {
            @Override
            public void columnMoved(TableColumnModelEvent e) {
                int at = getColumnAt(colName);
                if (at > -1) {
                    columnOfKey = at;
                }
            }
        };
    }

    private int getColumnAt(String name) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnName(i).equals(name)) {
                return i; // find column position when changing
            }
        }
        return -1;
    }

}
