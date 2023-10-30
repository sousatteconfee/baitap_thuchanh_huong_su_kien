package shop.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import lombok.Data;
import lombok.Builder.ObtainVia;
import shop.models.dao.*;
import shop.services.sql.DAOModel;
import shop.services.staticControl.EntityControl;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import lombok.AllArgsConstructor;

/**
 * @see #Product(java.sql.ResultSet)
 * @see #toArray(fruit.models.entities.Product)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements EntityControl<Long> {

    private long prid = -1;
    private String name;
    private String note;
    private int active; // -1:soft-delete | 0:lock | 1:open
    private float price;
    private int quantity;
    private @ObtainVia
    Date regTime = new Date();
    private String image;
    private Integer cg_id;
    private String u_id;

    public Product(ResultSet rs) throws SQLException {
        this.prid = rs.getLong("prid");
        this.name = rs.getString("name");
        this.note = rs.getString("note");
        this.active = rs.getInt("active");
        this.price = rs.getFloat("price");
        this.quantity = rs.getInt("quantity");
        this.image = rs.getString("image");
        this.cg_id = rs.getInt("cg_id");
        this.u_id = rs.getString("u_id");
        this.regTime = rs.getDate("regTime");
    }

    @Override
    public String toString2() {
        return new StringBuilder()
                .append(name)
                .append("(id:").append(prid).append(")")
                .toString();
    }

    @Override
    public String toString() {
        return this.toString2();
    }

    @Override
    public Long getKey() {
        return this.prid;
    }

    @Override
    public Object[] toArrayTable() {
        return toArray(this, TYPE_ARR.SHOW_TABLE);
    }

    private static final UserDAO udao = DAOModel.USER;
    private static final CateDAO cdao = DAOModel.CATE;

    public static Object[] toArray(Product e, TYPE_ARR type) {
        switch (type) {
            case SHOW_TABLE:
                return new Object[]{
                    e.prid, e.name, e.quantity,
                    e.price, e.regTime, e.image,
                    cdao.getById(e.cg_id),
                    udao.getById(e.u_id),
                    e.active>0
                };
            case UPDATE:
                return new Object[]{
                    e.name, e.note, e.active,
                    e.price, e.quantity, e.regTime,
                    e.image, e.cg_id, e.u_id, e.prid
                };
            case INSERT:
            default:
                return new Object[]{
                    e.name, e.note, e.active,
                    e.price, e.quantity, e.regTime,
                    e.image, e.cg_id, e.u_id
                };
        }
    }

    public static JTable table(Collection data) {
        return Product.table(data,
                false, false, false, false,
                false, false, false, false,
                false // default edit non-active
        );
    }

    public static JTable tableActive(Collection data, boolean opentActive) {
        return Product.table(data,
                false, false, false, false,
                false, false, false, false,
                opentActive
        );
    }

    public static JTable table(Collection data, boolean... edits) {
        // config table model
        String[] columns = new String[]{
            "id", "name", "quantity", "price",
            "register time", "image", "Category", "User",
            "active"
        };

        Class[] types = {
            Long.class, String.class, Integer.class, Float.class,
            String.class, String.class, JComboBox.class, JComboBox.class,
            Boolean.class
        };

        // prepare data
        Object[][] rows = null;
        if (data != null) {
            int i = 0;
            rows = new Object[data.size()][columns.length];
            for (Iterator<Product> e = data.iterator(); e.hasNext(); ++i) {
                rows[i] = toArray(e.next(), TYPE_ARR.SHOW_TABLE);
            }
        }

        TableModel tm = EntityControl.getTableModel(columns, rows, types, edits);
        /**
         * sài cái này nó dở lắm (:có thể sài tạm đê cập nhật active:) nếu có
         * sài thì mở cái edits cuối cùng = true để sửa active
         */
        // tm.addTableModelListener(EntityControl.setActive(0, udao));
        JTable jtable = new JTable(tm);
        EntityControl.customJtable(jtable);
        return jtable;
    }
}

/**
 * // use for edit combobox value on table <br>
 * TableColumnModel cMolde = table.getColumnModel();
 * cMolde.getColumn(6).setCellEditor(new DefaultCellEditor( new
 * JComboBox(cdao.getMap().values().toArray()) ));
 * cMolde.getColumn(7).setCellEditor(new DefaultCellEditor( new
 * JComboBox(udao.getMap().values().toArray()) ));
 */
