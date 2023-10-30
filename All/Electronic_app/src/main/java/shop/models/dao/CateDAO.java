package shop.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.services.sql.AbstractDAO;
import shop.services.sql.SqlCate;
import shop.services.staticControl.Jdbc;

public final class CateDAO extends AbstractDAO<Integer, Category> implements SqlCate {

    public CateDAO() {
        super(SELECT, INSERT, UPDATE, DELETE);
        try {
            this.pullList();
            StringBuilder mes = new StringBuilder(TABLE);
            mes.append(" get ").append(this.map.size()).append(" data from database");
            System.out.println(mes.toString());
        } catch (SQLException ex) {
            Logger.getLogger(CateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Object[] toArray(Category entity, Category.TYPE_ARR type) {
        switch (type) {
            case INSERT:
                return Category.toArray(entity, type);
            case UPDATE:
                Object[] agrs = Category.toArray(entity, type);
                return agrs(agrs, entity.getCgid(), true);
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected Category getEntity(ResultSet rs) throws SQLException {
        return new Category(rs);
    }

    @Override
    public ArrayList<Product> getProducts(Integer... cgids) {
        ArrayList<Product> products = new ArrayList<>();
        try (ResultSet rs = Jdbc.resutlSet(selectByIds(cgids.length), (Object[]) cgids)) {
            while (rs.next()) {
                products.add(new Product(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}
