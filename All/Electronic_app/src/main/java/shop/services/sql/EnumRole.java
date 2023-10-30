package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.AllArgsConstructor;
import shop.services.staticControl.Jdbc;
import shop.services.staticControl.Query;

interface TableRole {

    String R_TABLE = "ROLES r";
    List<String> ROLES = new ArrayList<>();
}

@AllArgsConstructor
public enum EnumRole implements TableRole {
    RID("rid"), ROLE("role");
    public final String value;

    public static List<String> getRoles() {
        String sql = EnumRole.select(ROLE); // default get all

        if (ROLES.size() < 1) try (ResultSet rs = Jdbc.resutlSet(sql)) {
            while (rs.next()) {
                ROLES.add(rs.getString(ROLE.value));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnumRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ROLES;
    }

    /**
     *
     * @param fields if exists get with fields
     * @return get by fields or get all
     */
    protected static String select(EnumRole... fields) {
        int len = fields.length;

        if (len > 0) {
            String[] fs = new String[len];
            for (int i = 0; i < len; i++) {
                fs[i] = fields[i].value;
            }
            return Query.select(R_TABLE, fs);
        }
        return Query.select(R_TABLE, RID.value, ROLE.value);
    }
}
