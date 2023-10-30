package shop.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import shop.models.entities.Order;
import shop.services.sql.AbstractDAO;
import shop.services.sql.EnumDetail;
import shop.services.sql.SqlOrder;
import shop.services.staticControl.Jdbc;

public final class OrderDAO extends AbstractDAO<Long, Order> implements SqlOrder {

    public OrderDAO() {
        super(SELECT, INSERT, UPDATE, DELETE);
        try {
            this.pullList();
            StringBuilder mes = new StringBuilder(TABLE);
            mes.append(" get ").append(this.map.size()).append(" data from database");
            System.out.println(mes.toString());
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void pullList() throws SQLException {
        super.pullList(); // get all order
        Map<Long, List<EnumDetail.Detail>> details;
        // get all details from database
        details = this.getDetails().stream().collect(
                Collectors.groupingBy(EnumDetail.Detail::getOr_id)
        );

        // add details to order cart by id
        map.forEach((k, e) -> e.setDetails(details.get(k)));

    }

    @Override
    public Order insert(Order entity) throws SQLException {
        if (entity == null) {
            return null;
        }
        Long key = this.getKey(entity);

        if (this.map.get(key) == null) {
            Object[] objs = this.toArray(entity, Order.TYPE_ARR.INSERT);
            // get result set from inserted
            try (ResultSet rs = Jdbc.resutlSet(INSERT, objs)) {
                if (rs.next()) {
                    Order ord = new Order(rs);
                    long or_id = ord.getKey(); // id from result set
                    entity.getDetails().forEach(e -> e.setOr_id(or_id));
                    ord.setDetails(this.insertDetails(entity.getArrDetail()));
                    this.map.put(or_id, ord);
                    return ord;
                }
            }
            return null;
        }
        throw this.createException(key, "insert", "already exist !!!");
    }

    @Override
    public Order update(Order entity) throws SQLException {
        Long key = entity.getKey();

        // get result set from inserted
        if (this.map.get(key) != null) {
            Object[] objs = this.toArray(entity, Order.TYPE_ARR.UPDATE);
            if (Jdbc.execute(UPDATE, objs) > 0) {
                this.deleteDetails(key);
                this.insertDetails(entity.getArrDetail());
                this.map.replace(key, entity);
                return entity;
            }
            return null;
        }
        throw createException(key, "update", "doesn't exist !!!");
    }

    @Override
    public int delete(Long key) throws SQLException {
        int result;
        if ((result = super.delete(key)) > 0) {
            this.deleteDetails(key);
        }

        return result;
    }

    @Override
    protected Object[] toArray(Order entity, Order.TYPE_ARR type) {
        switch (type) {
            case INSERT:
                return Order.toArray(entity, type);
            case UPDATE:
                Object[] agrs = Order.toArray(entity, type);
                return agrs(agrs, entity.getKey(), true);
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected Order getEntity(ResultSet rs) throws SQLException {
        return new Order(rs);
    }

    @Override
    public ArrayList<EnumDetail.Detail> getDetails(Long... orids) {
        int size = orids.length;
        ArrayList<EnumDetail.Detail> arr = new ArrayList<>(size);
        String query = EnumDetail.queryGetDetails(size);
        try (ResultSet rs = Jdbc.resutlSet(query, (Object[]) orids)) {
            while (rs.next()) {
                arr.add(new EnumDetail.Detail(rs));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return arr;
    }

    @Override
    public ArrayList<EnumDetail.Detail> insertDetails(EnumDetail.Detail... details) {
        int size = details.length;
        ArrayList<EnumDetail.Detail> arr = new ArrayList<>(size);
        String query = EnumDetail.queryInsertDetails(size);
        Object[] data = EnumDetail.flat(details);

        try {
            if (Jdbc.execute(query, data) > 0) {
                arr.addAll(Arrays.asList(details));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return arr;
    }

    @Override
    public ArrayList<EnumDetail.Detail> updateDetails(EnumDetail.Detail... details) {
        String query = EnumDetail.queryUpdateDetails(details.length);
        Object[] data = EnumDetail.flat(details);

        try {
            if (Jdbc.execute(query, data) > 0) {
                return new ArrayList(Arrays.asList(details));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }

    @Override
    public int deleteDetails(Long... orids) {
        int size = orids.length;
        try {
            String query = EnumDetail.queryDeleteDetails(size);
            return Jdbc.execute(query, (Object[]) orids);
        } catch (IllegalArgumentException | SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
