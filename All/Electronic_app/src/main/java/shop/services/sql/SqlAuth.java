package shop.services.sql;

import static shop.services.sql.SqlUser.GET_ROLE_BY_UID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.models.dao.UserDAO;
import shop.services.staticControl.Jdbc;
import shop.services.staticControl.Query;

public interface SqlAuth {

    String TABLE = "AUTHS";
    String KEY = "r_id";
    String[] FIELDS = {KEY, "u_id"};
    String SELECT = Query.select(TABLE);
    String INSERT = Query.insert(TABLE, FIELDS);
    String DELETE = Query.delete(TABLE, FIELDS);

    /**
     * create query only, not has data input
     *
     * @param size is number of r_id to create query conditional
     * @return the query select by ids
     */
    default String queryByIds(int size) {
        String[] fieldIds = new String[size];
        for (int i = 0; i < size; i++) {
            fieldIds[i] = KEY;
        }

        return Query.concat(SELECT, "WHERE",
                Query.conditions(" OR ", fieldIds)
        );
    }

    static String[] insertAuths(String uid, String[] roles) throws SQLException {
        String query = EnumAuth.insert(roles.length);
        Object[] agrs = AbstractDAO.agrs(roles, uid, false);
        return Jdbc.execute(query, agrs) > 0 ? roles : null;
    }

    static int deleteAuths(String uid, String... roles) throws SQLException {
        String query = EnumAuth.delete(roles.length);
        return Jdbc.execute(query, AbstractDAO.agrs(roles, uid, false));
    }

    static String[] getAuths(String uid) {
        ArrayList<String> list = new ArrayList<>();
        try (ResultSet rs = Jdbc.resutlSet(GET_ROLE_BY_UID, uid)) {
            while (rs.next()) {
                list.add(rs.getString(EnumRole.ROLE.value));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list.toArray(new String[0]);
        }
    }

    // String:uid, String[]: role
    static Map<String, String[]> getAuthRoles() {
        String sql = EnumAuth.getAuthRole();
        Map<String, Object> map = new HashMap<>();
        EnumAuth.AuthRole temp;
        String key, role;

        try (ResultSet rs = Jdbc.resutlSet(sql)) {
            while (rs.next()) { // get all data as Linkedlist
                temp = new EnumAuth.AuthRole(rs);
                key = temp.getU_id();
                role = temp.getRole();

                if (map.get(key) == null) {
                    map.put(key, new LinkedList<>(Arrays.asList(role)));
                } else {
                    ((List) map.get(key)).add(role);
                }
            }
            // convert all data as LinkedList to String[]
            for (String k : map.keySet()) {
                map.replace(k, ((List) map.get(k)).toArray(new String[1]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new HashMap(map);
    }

}
