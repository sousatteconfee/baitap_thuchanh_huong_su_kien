package shop.services.sql;

import java.util.List;

import shop.models.entities.Product;
import shop.services.staticControl.Query;

public interface SqlProduct {

    String TABLE = "PRODUCTS";
    String KEY = "prid";
    String[] FIELDS = {
        "name", "note", "active",
        "price", "quantity", "regTime",
        "image", "cg_id", "u_id"
    };
    String SELECT = Query.select(TABLE);
    String INSERT = Query.insert(TABLE, FIELDS);
    String UPDATE = Query.update(TABLE, KEY, FIELDS);
    String DELETE = Query.delete(TABLE, KEY);
    String SELECT_BY_CGID = Query.concat(SELECT, "WHERE cg_id = ?");
    String SELECT_BY_UID = Query.concat(SELECT, "WHERE u_id = ?");
    String SEARCH_LIKE_NAME = Query.concat(SELECT, "WHERE name LIKE ?");

    // getlist
    List<Product> getList(Boolean active);

    // get by category id
    List<Product> getByCgId(Integer cgid);

    List<Product> getByCgId(Integer cgid, Boolean active);

    // get by references username
    List<Product> getByUId(String uid);

    List<Product> getByUId(String uid, Boolean active);

    // get by like name
    List<Product> searchLikeName(String text);

    List<Product> searchLikeName(String text, Boolean active);
}
