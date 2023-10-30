package shop.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.services.sql.EnumDetail;
import shop.services.staticControl.EntityControl;

/**
 * @see #Order(java.sql.ResultSet)
 * @see #toArray(fruit.models.entities.Order)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order implements EntityControl<Long> {

    private long orid;
    private String note;
    private @Builder.ObtainVia
    Date regTime = new Date();
    private String buyer_id;
    private String staff_id;
    public final Set<EnumDetail.Detail> details = new HashSet<>();

    public Order(ResultSet rs) throws SQLException {
        this.setContructor(rs);
    }

    public Order(ResultSet rs, EnumDetail.Detail[] details) throws SQLException {
        this.setContructor(rs);
        this.details.addAll(Arrays.asList(details));
    }

    private void setContructor(ResultSet rs) throws SQLException {
        this.orid = rs.getInt("orid");
        this.note = rs.getString("note");
        this.regTime = rs.getDate("regTime");
        this.buyer_id = rs.getString("buyer_id");
        this.staff_id = rs.getString("staff_id");
    }

    public void setDetails(EnumDetail.Detail... details) {
        this.setDetails(Arrays.asList(details));
    }

    public void setDetails(Collection<EnumDetail.Detail> details) {
        this.details.clear();
        if (details != null && !details.isEmpty()) {
            for (EnumDetail.Detail d : details) {
                this.details.add(d);
            }
        }
    }

    public EnumDetail.Detail[] getArrDetail() {
        return details.toArray(new EnumDetail.Detail[1]);
    }

    @Override
    public String toString2() {
        return toString();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("(").append(staff_id).append(")")
                .append(" | ")
                .append("(").append(buyer_id).append(")")
                .toString();
    }

    @Override
    public Long getKey() {
        return this.orid;
    }

    @Override
    public Object[] toArrayTable() {
        return toArray(this, TYPE_ARR.SHOW_TABLE);
    }

    public static Object[] toArray(Order e, TYPE_ARR type) {
        switch (type) {
            case INSERT:
                return new Object[]{
                    e.note, e.regTime, e.buyer_id, e.staff_id
                };
            case UPDATE:
                return new Object[]{
                    e.note, e.regTime, e.buyer_id, e.staff_id, e.orid
                };
            case SHOW_TABLE:
            default:
                return new Object[]{
                    e.orid, e.note, e.regTime, e.buyer_id, e.staff_id,
                    e.details.size(), EnumDetail.Detail.sum(e.details)
                };
        }
    }

    public static JTable table(Collection data) {
        String[] columns = new String[]{"orid", "Ghi chú", "Tạo lúc",
            "Khách hàng", "Nhân viên", "Sản phẩm", "Tổng"};
        Class[] types = {Long.class, String.class, Date.class,
            String.class, String.class, Integer.class, Float.class};
        boolean[] edits = {false, false, false, false, false, false, false};

        // prepare data
        Object[][] rows = null;
        if (data != null) {
            int i = 0;
            rows = new Object[data.size()][columns.length];
            for (Iterator<Order> e = data.iterator(); e.hasNext(); ++i) {
                rows[i] = toArray(e.next(), TYPE_ARR.SHOW_TABLE);
            }
        }
        DefaultTableModel tm = EntityControl.getTableModel(columns, rows, types, edits);
        JTable table = new JTable(tm);
        EntityControl.customJtable(table);
        return table;
    }
}
