package shop.models.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.configuration.Config;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.services.sql.AbstractDAO;
import shop.services.sql.ActiveDAO;
import shop.services.sql.DAOModel;
import shop.services.sql.SqlAuth;
import shop.services.sql.SqlUser;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.Jdbc;
import shop.services.staticControl.Lib;
import shop.services.staticControl.Query;

public final class UserDAO extends AbstractDAO<String, User> implements SqlUser, ActiveDAO<String> {

    private static final String ACTIVE = "AND active = ?";

    public UserDAO() {
        super(SELECT, INSERT, UPDATE, DELETE);
        try {
            this.pullList();
            StringBuilder mes = new StringBuilder(TABLE);
            mes.append(" get ").append(this.map.size()).append(" data from database");
            System.out.println(mes.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void pullList() throws SQLException {
        super.pullList();
        Map<String, String[]> auths = SqlAuth.getAuthRoles();
        super.map.forEach((k, e) -> e.setRoles(auths.get(k)));
    }

    @Override
    public User login(String username, String password) throws SQLException {
        User user = null;
        try (ResultSet rs = Jdbc.resutlSet(LOGIN, username, password)) {
            if (rs.next()) {
                user = new User(rs);
                user.setRoles(map.get(username).getAuths().toArray(new String[1]));
            }
        }
        return user;
    }

    @Override
    protected Object[] toArray(User entity, User.TYPE_ARR type) {
        return User.toArray(entity, type);
    }

    @Override
    protected User getEntity(ResultSet rs) throws SQLException {
        return new User(rs);
    }

    @Override
    public User insert(User entity) throws SQLException {
        super.insert(entity);
        this.saveAuths(entity);

        try (ResultSet rs = Jdbc.resutlSet(SELECT_BY_ID, entity.getUsername())) {
            String[] roles = entity.getAuths().toArray(new String[1]);
            if (rs.next()) {
                entity = new User(rs);
                entity.setRoles(roles);
                super.map.put(entity.getUsername(), entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public User update(User entity) throws SQLException {
        entity = super.update(entity);
        SqlAuth.deleteAuths(entity.getUsername());
        this.saveAuths(entity);
        return entity;
    }

    @Override
    public User updatePass(String uid_email, String password) {
        try (ResultSet rs = Jdbc.resutlSet(UPDATE_PASS, uid_email, password)) {
            if (rs.next()) {
                String key = rs.getString(KEY);
                User u = map.get(key);
                u.setPassword(rs.getString("password"));
                map.replace(key, u); // update password in storage
                return u;
            }
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    @Override // do not update password
    public User updateLessPass(User entity) throws SQLException {
        if (entity == null) {
            return null;
        }
        String key = this.getKey(entity);

        if (this.map.get(key) != null) {
            Object[] objs = User.toArrayLessPass(entity);
            try (ResultSet rs = Jdbc.resutlSet(UPDATE_LESS_PASS, objs)) {
                if (rs.next()) {
                    entity.setPassword(rs.getString("password"));
                }
                super.map.replace(key, entity);
                SqlAuth.deleteAuths(entity.getUsername());
                this.saveAuths(entity);
                return entity;
            }
        }
        throw createException(key, "update", "doesn't exist !!!");
    }

    @Override
    public int delete(String key) throws SQLException {
        // cascade delete product on database
        int deleteCount = super.delete(key);
        if (deleteCount > 0) {
            this.removeChildData(key);
        }
        return deleteCount;
    }

    @Override
    public boolean setActive(int active, String... ids) {
        String query = ActiveDAO.createActiveQuery(TABLE, KEY, ids.length);
        try {
            if (Jdbc.execute(query, agrs(ids, active, false)) > 0) {
                for (String id : ids) {
                    map.get(id).setActive(active);
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void saveAuths(User e) {
        if (e != null && !e.getAuths().isEmpty()) {
            String uid = e.getUsername();
            int length = e.getAuths().size();
            String[] roles = e.getAuths().toArray(new String[length]);
            try {
                SqlAuth.insertAuths(uid, roles);
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<User> getList() {
        return this.getList(SELECT);
    }

    @Override
    public List<User> getList(Boolean active) {
        return this.getList(Query.concat(
                SELECT, "WHERE active = ?"
        ), active);
    }

    @Override
    public List<User> searchLikeName(String text) {
        String replacement = new StringBuilder("N'%")
                .append(text).append("%'").toString();
        return this.getList(SEARCH_LIKE_NAME.replaceFirst("\\?", replacement));
    }

    @Override
    public List<User> searchLikeName(String text, Boolean active) {
        String replacement = new StringBuilder("N'%")
                .append(text).append("%'").toString();

        return this.getList(Query.concat(
                SEARCH_LIKE_NAME.replaceFirst("\\?", replacement),
                ACTIVE
        ), active);
    }

    private List<User> getList(String query, Object... agrs) {
        List<User> list = new ArrayList<>();
        try (ResultSet rs = Jdbc.resutlSet(query, agrs)) {
            while (rs.next()) {
                User e = new User(rs);
                e.setRoles(SqlAuth.getAuths(e.getUsername()));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private void removeChildData(String key) {
        FilterProduct.R_BY getBy = FilterProduct.R_BY.USER;
        Map<Long, Product> dataProduct = DAOModel.PRODUCT.getMap();
        List<Product> list = FilterProduct.getR_BY(new ArrayList<>(dataProduct.values()), getBy, key);

        list.forEach(product -> { // delete all prodcut of user in system
            File file = Lib.getFile(Config.folder.product, product.getImage());
            dataProduct.remove(product.getKey()); // remove element
            if (!file.delete()) { // drop file
                file.deleteOnExit();
            }
        });
    }
}
