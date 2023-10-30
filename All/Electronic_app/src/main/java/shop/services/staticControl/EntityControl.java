package shop.services.staticControl;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import shop.configuration.env;
import shop.services.sql.ActiveDAO;

public interface EntityControl<K> {

    /**
     * To select type convert array data
     *
     * @see #DEFAULT AS #INSERT <br>
     * @see #SHOW_TABLE get all data to show JTable <br>
     * @see #LESS_PASS_UPDATE for update except <strong>password</strong> <br>
     * @see #INSERT for insert data <br>
     * @see #UPDATE for update all
     */
    enum TYPE_ARR {
        DEFAULT, SHOW_TABLE, INSERT, UPDATE
    }

    /**
     * @param columns all columns are name
     * @param rows to add first data
     * @param types type of column EX Object.class
     * @param edits allow to edit column
     * @return DefaultTableModel and columns with data if input data
     */
    static DefaultTableModel getTableModel(
            String[] columns, Object[][] rows,
            Class[] types, boolean[] edits
    ) {
        return new DefaultTableModel(rows, columns) {
            @Override
            public Class getColumnClass(int i) {
                return types == null || types[i] == null ? Object.class : types[i];
            }

            @Override
            public boolean isCellEditable(int ri, int ci) {
                return edits == null || edits[ci];
            }
        };
    }

    /**
     * @param columns all columns are name
     * @param rows add first data
     * @return DefaultTableModel and columns with data if input data
     */
    static DefaultTableModel getTableModel(String[] columns, Object[]... rows) {
        return new DefaultTableModel(rows, rows);
    }

    // "ĐỪNG SÀI CÁI NÀY, NÓ SẼ CẬP NHẬP KHI THAY ĐỔI GIÁ TRỊ CELL",
    // "Cái event này quá óc chó, mỗi lần property thay đổi nó chạy lại",
    // "insert - update - delete -> nó đều chạy => Exception target @_@"
    @Deprecated
    static TableModelListener setActive(int id_location, ActiveDAO dao) {
        return (TableModelEvent e) -> {
            int rowIndex = e.getFirstRow();
            int columnIndex = e.getColumn();
            if (columnIndex < 0) {
                return;
            }

            TableModel model = (TableModel) e.getSource();
            Object key = model.getValueAt(rowIndex, id_location); // get key
            Object data = model.getValueAt(rowIndex, columnIndex);

            // only active checkbox value
            if (data instanceof Boolean) {
                Boolean active = (Boolean) data; // get active
                dao.setActive(active ? 1 : 0, key);
            }
        };
    }

    K getKey();

    Object[] toArrayTable();

    public String toString2();

    static void customJtable(JTable table) {
        int columnSize = table.getColumnCount();
        for (int i = 0; i < columnSize; i++) {
            table.setAutoResizeMode(i);
        }
        table.setFont(env.FONT);
        table.setRowHeight(30);
        table.setSelectionMode(0); // 0 is single selection
        table.setAutoCreateRowSorter(true);
        resizeColumnWidth(table);
    }

    static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            width += 5;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
