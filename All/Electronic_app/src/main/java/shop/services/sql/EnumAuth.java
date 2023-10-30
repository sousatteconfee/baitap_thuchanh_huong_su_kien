package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.services.staticControl.Query;

interface TableAuth {

    String A_TABLE = "AUTHS a";
}

@AllArgsConstructor
public enum EnumAuth implements TableAuth, TableRole {

    RID("r_id"), UID("u_id");
    public final String value;

    @Getter
    @AllArgsConstructor
    public static class AuthRole {

        private final Integer r_id;
        private final String u_id;
        private final String role;

        public AuthRole(ResultSet rs) throws SQLException {
            r_id = rs.getInt(EnumAuth.RID.value);
            u_id = rs.getString(EnumAuth.UID.value);
            role = rs.getString(EnumRole.ROLE.value);
        }
    }

    public static String getAuthRole() {
        String table = new StringBuilder(A_TABLE)
                .append(" INNER JOIN ").append(R_TABLE)
                .append(" ON a.r_id=r.rid").toString();
        String[] fields = {RID.value, UID.value, EnumRole.ROLE.value};

        return Query.select(table, fields);
    }

    public static String insert(int countRoles) {
        if (countRoles < 1) {
            return null;
        }
        String[] fields = EnumAuth.getFields(countRoles);
        StringBuilder sql = new StringBuilder("INSERT INTO AUTHS ");
        sql.append("SELECT username as 'u_id', rid as 'r_id' ");
        sql.append("FROM ROLES OUT JOIN USERS ON username = ? AND ");
        sql.append(Query.conditions(" OR ", fields));
        return sql.toString();
    }

    public static String delete(int countRoles) {
        StringBuilder sql = new StringBuilder("DELETE AUTHS WHERE u_id = ?");
        if (countRoles > 0) {
            String[] fields = EnumAuth.getFields(countRoles);
            sql.append(" AND r_id IN (SELECT rid FROM ROLES WHERE ");
            sql.append(Query.conditions(" OR ", fields));
            sql.append(")");
        }
        return sql.toString();
    }

    private static String[] getFields(int length) {
        String[] fields = new String[length];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = EnumRole.ROLE.value;
        }
        return fields;
    }

}
