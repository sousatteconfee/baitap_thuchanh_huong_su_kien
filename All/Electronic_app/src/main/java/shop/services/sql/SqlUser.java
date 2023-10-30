package shop.services.sql;

import java.sql.SQLException;
import java.util.List;

import shop.models.entities.User;
import shop.services.staticControl.Query;

public interface SqlUser {

    String TABLE = "USERS";
    String KEY = "username";
    String PASS = "password:PWDENCRYPT(?)";
    String[] FIELDS = {KEY, PASS, "email", "name", "active", "image"};

    String SELECT = Query.select(TABLE);
    String INSERT = Query.insert(TABLE, FIELDS);
    String UPDATE = Query.update(TABLE, KEY, FIELDS);
    String DELETE = Query.delete(TABLE, KEY);

    // SECURITY > ROLES AND AUTHORIZATIONS
    String LOGIN = "{CALL pr_login(?,?)}"; // username - password
    String UPDATE_PASS = "{CALL pr_update_pass(?,?)}"; // username - new password
    String UPDATE_LESS_PASS = "{CALL pr_update_less_pass(?,?,?,?,?)}"; // username, email, name, active, iamge
    String SELECT_BY_ID = Query.concat(SELECT, "WHERE username=?");
    String SEARCH_LIKE_NAME = Query.concat(SELECT, "WHERE name LIKE ?");
    String GET_ROLE_BY_UID = "SELECT role FROM ROLES r INNER JOIN AUTHS a ON a.r_id = r.rid WHERE a.u_id =?";

    public User login(String username, String password) throws SQLException;

    /**
     *
     * @param uid_email username or email
     * @param password new password
     * @return User updated if success || failed is null
     */
    public User updatePass(String uid_email, String password);

    // avoid update old password
    public User updateLessPass(User e) throws SQLException;

    public List<User> getList();

    public List<User> getList(Boolean active);

    public List<User> searchLikeName(String text);

    public List<User> searchLikeName(String text, Boolean active);

}
