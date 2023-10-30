package shop.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.services.staticControl.EntityControl;

/**
 * @see #Category(java.sql.ResultSet)
 * @see #toArray(fruit.models.entities.Category)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Category implements EntityControl<Integer> {

    private int cgid;
    private String name;
    private String image;

    public Category(ResultSet rs) throws SQLException {
        this.cgid = rs.getInt("cgid");
        this.name = rs.getString("name");
        this.image = rs.getString("image");
    }

    @Override
    public String toString2() {
        return new StringBuilder()
                .append(name)
                .append("(id:").append(cgid).append(")")
                .toString();
    }

    @Override
    public String toString() {
        return this.toString2();
    }

    @Override
    public Integer getKey() {
        return this.cgid;
    }

    @Override
    public Object[] toArrayTable() {
        return toArray(this, TYPE_ARR.SHOW_TABLE);
    }

    public static Object[] toArray(Category e, TYPE_ARR type) {
        switch (type) {
            case SHOW_TABLE:
                return new Object[]{
                    e.cgid, e.name, e.image
                };
            case INSERT:
                return new Object[]{
                    e.cgid, e.name, e.image
                };
            case UPDATE:
                return new Object[]{
                    e.cgid, e.name, e.image
                };
            default:
                return new Object[]{
                    e.cgid, e.name, e.image
                };
        }
    }

    public static JTable table(Collection data) {
        String[] columns = new String[]{"id", "name", "image"};
        Class[] types = {Integer.class, String.class, String.class};
        boolean[] edits = {false, false, false};

        // prepare data
        Object[][] rows = null;
        if (data != null) {
            int i = 0;
            rows = new Object[data.size()][columns.length];
            for (Iterator<Category> e = data.iterator(); e.hasNext(); ++i) {
                rows[i] = toArray(e.next(), TYPE_ARR.SHOW_TABLE);
            }
        }
        DefaultTableModel tm = EntityControl.getTableModel(columns, rows, types, edits);
        JTable table = new JTable(tm);
        EntityControl.customJtable(table);
        return table;
    }
}
