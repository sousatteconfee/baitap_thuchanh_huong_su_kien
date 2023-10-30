package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import shop.models.entities.Product;
import static shop.services.sql.SqlOrder.KEY;
import shop.services.staticControl.EntityControl;
import shop.services.staticControl.Query;
import shop.utils.Format;

interface suport {

    String TABLE = "ORDER_DETAILS";

    default String selectDetailsByIds(int size) {
        String select = Query.select(TABLE);
        String[] fieldIds = new String[size];
        for (int i = 0; i < size; i++) {
            fieldIds[i] = KEY;
        }

        return Query.concat(select, "WHERE",
                Query.conditions(" OR ", fieldIds)
        );
    }
}

@AllArgsConstructor
public enum EnumDetail implements suport {
    QTY("quantity"), OLDPRICE("oldPrice"), PRID("pr_id"), ORID("or_id");

    private final String value;

    @Data
    @AllArgsConstructor
    public static class Detail {

        private int quantity;
        private float oldPrice;
        private long pr_id;
        private long or_id;

        public Detail(ResultSet rs) throws SQLException {
            this.oldPrice = rs.getFloat(OLDPRICE.value);
            this.quantity = rs.getInt(QTY.value);
            this.pr_id = rs.getLong(PRID.value);
            this.or_id = rs.getLong(ORID.value);
        }

        public Object[] toArray() {
            return new Object[]{
                quantity, oldPrice, pr_id, or_id
            };
        }

        public static JTable table(Collection data) {
            String[] columns = new String[]{"orid", "quantity", "oldPrice", "total", "product"};
            Class[] types = {Long.class, Integer.class, String.class, String.class, Product.class};
            boolean[] edits = {false, false, false, false, false};
            Detail d;

            // prepare data
            Object[][] rows = null;
            if (data != null) {
                int i = 0;
                rows = new Object[data.size()][columns.length];
                for (Iterator<Detail> e = data.iterator(); e.hasNext(); ++i) {
                    d = e.next();
                    rows[i] = new Object[]{
                        d.or_id, d.quantity,
                        Format.number(null, d.oldPrice),
                        Format.number(null, d.quantity * d.oldPrice),
                        DAOModel.PRODUCT.getById(d.pr_id)
                    };
                }
            }
            DefaultTableModel tm = EntityControl.getTableModel(columns, rows, types, edits);
            JTable table = new JTable(tm);
            EntityControl.customJtable(table);
            return table;
        }

        public static float sum(Set<Detail> ds) {
            if (ds == null || ds.isEmpty()) {
                return 0;
            }
            Detail[] data = ds.toArray(new Detail[1]);

            float sum = 0;
            for (EnumDetail.Detail d : data) {
                sum += d.getOldPrice() * d.getQuantity();
            }

            return sum;
        }

        /**
         * sqs is size - quantity - sum
         *
         * @param ds to calculator
         * @return array [size, quantity, sum]
         */
        public static Number[] sqs(Set<Detail> ds) {
            // declare variables
            int quantity = 0, qty;
            double sum = 0;

            // calcalations
            for (Detail d : ds) {
                qty = d.quantity;
                quantity += qty;
                sum += d.oldPrice * qty;
            }

            return new Number[]{ds.size(), quantity, sum};
        }
    }

    /**
     * @param details to convert
     * @return new array converted from details
     */
    public static Object[] flat(EnumDetail.Detail... details) {
        int i = 0, size, length1 = -1, length2 = Detail.class.getDeclaredFields().length;
        if (details == null || (length1 = details.length) < 1) {
            return new Object[0];
        }

        if (length1 < 2) {
            return details[0].toArray();
        }

        size = length1 * length2;

        Object[] data = new Object[size], arr;
        for (int j = 0; j < length1; j++) {
            for (int k = 0; k < length2; k++) {
                arr = details[j].toArray();
                data[i++] = arr[k];
            }
        }

        return data;
    }

    public static String queryGetDetails(int size) {
        if (size < 2) {
            return Query.select(TABLE);
        }

        StringBuilder conditions = new StringBuilder("WHERE ")
                .append(ORID.value).append(" IN (");
        for (int i = 0; i < size; i++) {
            conditions.append("?,");
        }
        int last = conditions.lastIndexOf(",");
        conditions.replace(last, ++last, ")");

        return Query.concat(
                Query.select(TABLE),
                conditions.toString()
        );
    }

    public static String queryInsertDetails(int size) {
        String[] fields = {QTY.value, OLDPRICE.value, PRID.value, ORID.value};
        StringBuilder sb = new StringBuilder();
        String query = Query.insert(TABLE, fields);

        if (size < 2) {
            return query;
        }

        for (int i = 0; i < size; i++) {
            sb.append("\n(?,?,?,?),");
        }
        if (size > 1) {
            int last = sb.lastIndexOf(",");
            sb.replace(last, ++last, ";");
        }

        return Query.concat(
                query.substring(0, query.lastIndexOf("(")),
                sb.toString()
        );
    }

    public static String queryUpdateDetails(int size) {
        String[] fields = {QTY.value, OLDPRICE.value, PRID.value, ORID.value};
        StringBuilder sb = new StringBuilder();

        if (size < 2) {
            return Query.update(TABLE, KEY, fields);
        }

        for (int i = 0; i < size; i++) {
            sb.append("\n").append(Query.update(TABLE, KEY, fields)).append(";");
        }
        return sb.toString();
    }

    public static String queryDeleteDetails(int size) throws SQLException {
        if (size < 2) {
            return Query.delete(TABLE, ORID.value);
        }

        StringBuilder conditions = new StringBuilder("WHERE ")
                .append(ORID.value).append(" IN (");
        for (int i = 0; i < size; i++) {
            conditions.append("?,");
        }

        int last = conditions.lastIndexOf(",");
        conditions.replace(last, ++last, ")");
        String query = Query.delete(TABLE, "");

        return Query.concat(
                query.substring(0, query.lastIndexOf(" WHERE")),
                conditions.toString()
        );
    }

}
