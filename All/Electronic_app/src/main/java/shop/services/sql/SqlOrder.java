package shop.services.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import shop.services.staticControl.Query;

public interface SqlOrder {

    String TABLE = "ORDERS";
    String KEY = "orid";
    String[] FIELDS = {"note", "regTime", "buyer_id", "staff_id"};
    String SELECT = Query.select(TABLE);
    String INSERT = Query.insert(TABLE, FIELDS);
    String UPDATE = Query.update(TABLE, KEY, FIELDS);
    String DELETE = Query.delete(TABLE, KEY);
    
    
    // get all product with category id
    ArrayList<EnumDetail.Detail> getDetails(Long... orids);
    ArrayList<EnumDetail.Detail> insertDetails(EnumDetail.Detail...details);
    ArrayList<EnumDetail.Detail> updateDetails(EnumDetail.Detail...details);
    int deleteDetails(Long...orids);
}
