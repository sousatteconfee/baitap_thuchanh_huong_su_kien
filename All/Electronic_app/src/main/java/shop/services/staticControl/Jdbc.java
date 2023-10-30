package shop.services.staticControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Getter;
import shop.configuration.env;

interface Helper {

    Boolean SHOW_SQL = Boolean.valueOf(
            env.PROPERTIES.getProperty("mssql.show-sql", "false")
    );
    String CLASSNAME = env.mssql.className.toString();
    String URL = env.mssql.url.toString();
    String USERNAME = env.mssql.username.toString();
    String PASSWORD = env.mssql.password.toString();
}

public abstract class Jdbc implements Helper {

    static {
        try { // keep alive connnect
            Class.forName(CLASSNAME);
            Logger.getGlobal().log(Level.INFO, URL);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Getter
    protected static Connection con;

    protected static PreparedStatement getStatement(String sql, Object... agrs) throws SQLException {
        boolean isCall = sql.trim().startsWith("{"); // check for prepare call
        PreparedStatement statement = isCall ? con.prepareCall(sql) : con.prepareStatement(sql);
        for (int i = 0; i < agrs.length; i++) {
            if (agrs[i] == null || agrs[i].toString().equalsIgnoreCase("null")) {
                statement.setNull(i + 1, 0); // java.sql.Types.NULL
            } else {
                statement.setObject(i + 1, agrs[i]); // set all parameters
            }
        }
        if (SHOW_SQL) {
            System.out.println(new StringBuilder(sql).append(" : ")
                    .append(Arrays.toString(agrs)).toString()
            );
        }
        return statement;
    }

    /**
     * use resutlSet method when the query returns data results<br>
     * chỉ sài cái này khi có dữ liệu lớn trả về vd: select * from ...
     *
     * @see java.sql.ResultSet
     * @param sql is a query that returns results
     * @param agrs are parameters for execute query
     * @return ResultSet after execute
     * @throws SQLException
     */
    synchronized public static ResultSet resutlSet(String sql, Object... agrs) throws SQLException {
        return getStatement(sql, agrs).executeQuery(); // keep alive for result-set
    }

    /**
     * use execute method when the query returns number of rows affected data
     * results<br>
     * "sài cái này cho số dữ liệu bị ảnh hưởng"
     *
     * @see java.sql.PreparedStatement#executeUpdate
     * @param sql is a query that returns results
     * @param agrs are parameters for execute query
     * @return number of rows affected
     * @throws SQLException
     */
    synchronized public static int execute(String sql, Object... agrs) throws SQLException {
        try (PreparedStatement statement = getStatement(sql, agrs)) {
            return statement.executeUpdate(); // execute and close immediately
        }
    }
}
