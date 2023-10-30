package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import shop.models.entities.*;

public interface statistic {

    @Data
    @EqualsAndHashCode(callSuper = true)
    static class User2 extends User {

        private final int productCount;

        public User2(ResultSet rs) throws SQLException {
            super(rs);
            this.productCount = rs.getInt("productCount");
        }
    }
    
    
    @Data
    @EqualsAndHashCode(callSuper = true)
    static class Cate2 extends Category {

        private final int productCount;

        public Cate2(ResultSet rs) throws SQLException {
            super(rs);
            this.productCount = rs.getInt("productCount");
        }
    }
}
