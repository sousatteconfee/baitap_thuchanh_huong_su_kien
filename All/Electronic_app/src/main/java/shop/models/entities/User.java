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
import javax.swing.table.TableModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import shop.services.staticControl.EntityControl;
import shop.utils.Format;

/**
 * @see #User(java.sql.ResultSet)
 * @see #User(java.lang.String, java.lang.String, java.lang.String,
 * java.lang.String, boolean, java.lang.String, java.lang.String...)
 *
 * @see #toArray(fruit.models.entities.User,
 * fruit.models.entities.User.TYPE_ARR)
 * @see TYPE_ARR
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements EntityControl<String> {

    private String username;
    private String password;
    private String email;
    private String name = "Khách Hàng";
    private int active;
    private String image;
    @Builder.ObtainVia
    private Date regTime = new Date();
    private final Set<String> auths = new HashSet<>();

    public void setRoles(String[] roles) {
        auths.clear();
        auths.addAll(Arrays.asList(roles));
    }
    
    public String[] arrRoles() {
        return auths.toArray(new String[1]);
    }

    public User(String username) {
        this.username = username;
    }

    public User(ResultSet rs) throws SQLException {
        this.username = rs.getString("username");
        this.password = rs.getString("password");
        this.email = rs.getString("email");
        this.name = rs.getString("name");
        this.active = rs.getInt("active");
        this.image = rs.getString("image");
        this.regTime = rs.getDate("regTime");
    }

    public User(String username, String password, String email, String name,
            int active, String image, Date regTime, String... roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.active = active;
        this.image = image;
        this.regTime = regTime;
        this.auths.addAll(Arrays.asList(roles));
    }

    @Override
    public String toString2() {
        return new StringBuilder()
                .append(name)
                .append("(username:").append(username).append(")")
                .toString();
    }

    @Override
    public String toString() {
        return this.toString2();
    }

    @Override
    public String getKey() {
        return this.username;
    }

    @Override
    public Object[] toArrayTable() {
        return toArray(this, TYPE_ARR.SHOW_TABLE);
    }

    public static Object[] toArray(User e, TYPE_ARR type) {
        switch (type) {
            case SHOW_TABLE:
                return new Object[]{
                    e.username, e.password, e.email, e.name, e.image,
                    Arrays.toString(e.auths.toArray()),
                    Format.DATE.format(e.regTime),
                    e.active > 0
                };
            case INSERT:
                return new Object[]{
                    e.username, e.password, e.email,
                    e.name, e.active, e.image
                };
            case UPDATE:
                return new Object[]{
                    e.username, e.password, e.email,
                    e.name, e.active, e.image, e.username
                };
            default:
                return new Object[]{
                    e.username, e.password, e.email,
                    e.name, e.active, e.image
                };
        }
    }

    public static Object[] toArrayLessPass(User e) {
        return new Object[]{
            e.username, e.email, e.name, e.active, e.image
        };
    }

    public static JTable table(Collection data) {
        // config table model
        String[] columns = new String[]{
            "username", "password", "email",
            "name", "image", "roles",
            "regTime", "active"
        };
        Class[] types = {
            String.class, String.class, String.class,
            String.class, String.class, String.class,
            String.class, Boolean.class
        };
        boolean[] edits = {
            false, false, false,
            false, false, false,
            false, false
        };

        // prepare data
        Object[][] rows = null;
        if (data != null) {
            int i = 0;
            rows = new Object[data.size()][columns.length];
            for (Iterator<User> e = data.iterator(); e.hasNext(); ++i) {
                rows[i] = toArray(e.next(), TYPE_ARR.SHOW_TABLE);
            }
        }

        TableModel tm = EntityControl.getTableModel(columns, rows, types, edits);
        JTable table = new JTable(tm);
        EntityControl.customJtable(table);
        return table;
    }
}
