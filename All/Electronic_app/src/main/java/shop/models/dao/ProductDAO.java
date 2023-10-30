package shop.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.models.entities.Product;
import shop.services.sql.AbstractDAO;
import shop.services.sql.ActiveDAO;
import shop.services.sql.SqlProduct;
import shop.services.staticControl.Jdbc;
import shop.services.staticControl.Query;

public final class ProductDAO extends AbstractDAO<Long, Product> implements SqlProduct, ActiveDAO<Long> {

    private static final String ACTIVE = "AND active = ?";

    public ProductDAO() {
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
    public Product insert(Product entity) throws SQLException {
        Object[] objs = this.toArray(entity, Product.TYPE_ARR.INSERT);
        // get result set from inserted
        try (ResultSet rs = Jdbc.resutlSet(INSERT, objs)) {
            if (rs.next()) {
                entity = new Product(rs);
                this.map.put(entity.getPrid(), entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean setActive(int active, Long... ids) {
        String query = ActiveDAO.createActiveQuery(TABLE, KEY, ids.length);
        try {
            if (Jdbc.execute(query, agrs(ids, active, false)) > 0) {
                for (Long id : ids) {
                    map.get(id).setActive(active);
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    @Override
    protected Object[] toArray(Product entity, Product.TYPE_ARR type) {
        return Product.toArray(entity, type);
    }

    @Override
    protected Product getEntity(ResultSet rs) throws SQLException {
        return new Product(rs);
    }

    @Override
    public List<Product> getList(Boolean active) {
        return active == null ? this.getList(SELECT) : this.getList(
                Query.concat(SELECT, "WHERE active = ?"), active
        );
    }

    @Override
    public List<Product> getByCgId(Integer cgid) {
        return this.getList(SELECT_BY_CGID, cgid);
    }

    @Override
    public List<Product> getByCgId(Integer cgid, Boolean active) {
        return this.getList(Query.concat(
                SELECT_BY_CGID, ACTIVE
        ), cgid, active);
    }

    @Override
    public List<Product> getByUId(String uid) {
        return this.getList(SELECT_BY_UID, uid);
    }

    @Override
    public List<Product> getByUId(String uid, Boolean active) {
        return this.getList(Query.concat(
                SELECT_BY_UID, ACTIVE
        ), uid, active);
    }

    @Override
    public List<Product> searchLikeName(String text) {
        String replacement = new StringBuilder("N'%")
                .append(text).append("%'").toString();
        return this.getList(SEARCH_LIKE_NAME.replaceFirst("\\?", replacement));
    }

    @Override
    public List<Product> searchLikeName(String text, Boolean active) {
        String replacement = new StringBuilder("N'%")
                .append(text).append("%'").toString();

        return this.getList(Query.concat(
                SEARCH_LIKE_NAME.replaceFirst("\\?", replacement),
                ACTIVE
        ), active);
    }

    private List<Product> getList(String query, Object... agrs) {
        List<Product> list = new ArrayList<>();
        try (ResultSet rs = Jdbc.resutlSet(query, agrs)) {
            while (rs.next()) {
                list.add(new Product(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
