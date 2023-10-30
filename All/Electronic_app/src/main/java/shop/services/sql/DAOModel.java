package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import shop.models.dao.*;
import shop.services.sql.statistic.*;
import shop.services.staticControl.Jdbc;

/**
 * @see UserDAO
 * @see CateDAO
 * @see ProductDAO
 *
 * @see shop.services.sql.SqlUser
 * @see shop.services.sql.SqlCate
 * @see shop.services.sql.SqlProduct
 */
public interface DAOModel {

    /**
     * Quản lý dữ liệu <b>liệu người dùng</b> giữa database và app
     */
    final UserDAO USER = new UserDAO();

    /**
     * "Quản lý dữ liệu <b>phân loại sản phẩm</b> giữa database và app"
     */
    final CateDAO CATE = new CateDAO();

    /**
     * "Quản lý dữ liệu <b>sản phẩm</b> giữa database và app"
     */
    final ProductDAO PRODUCT = new ProductDAO();

    /**
     * "Quản lý dữ liệu <b>hóa đơn</b> giữa database và app"
     */
    final OrderDAO ORDER = new OrderDAO();
    /**
     * quantity statistics get data quickly through static
     */
    static class statistic {

        private static final String V_P_USER = "SELECT * FROM V_USER_COUNT_PRODUCT";
        private static final String V_P_CATE = "SELECT * FROM V_CATEGORY_COUNT_PRODUCT";

        /**
         * @see User2 "đếm <b>số sản phẩm</b> theo người bán"
         * @return new List User2 extends User
         */
        public static List<User2> getListSUser() {
            List<User2> list = new LinkedList<>();
            try (ResultSet rs = Jdbc.resutlSet(V_P_USER)) {
                while (rs.next()) {
                    list.add(new User2(rs));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return list;
        }

        /**
         * @see Cate2 "đếm <b>số sản phẩm</b> theo phân loại"
         * @return new List Cate2 extends Category
         */
        public static List<Cate2> getListSCate() {
            List<Cate2> list = new LinkedList<>();
            try (ResultSet rs = Jdbc.resutlSet(V_P_CATE)) {
                while (rs.next()) {
                    list.add(new Cate2(rs));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return list;
        }

    }
}
