package shop.services.staticControl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import shop.configuration.AuthAccess;
import shop.configuration.security;
import shop.models.entities.Order;
import shop.services.sql.DAOModel;
import shop.services.sql.EnumDetail;

public interface FilterOrder {

    static Date[] getMinMaxDate(List<Order> list) {
        Date[] range = {new Date(), new Date()};
        list.forEach(e -> {
            long min = range[0].getTime(), max = range[1].getTime();
            long nextAt = e.getRegTime().getTime();
            if (nextAt < min) {
                range[0] = e.getRegTime();
            } else if (nextAt > max) {
                range[1] = e.getRegTime();
            }
        });

        return range;
    }

    /**
     * @see FilterOrder.OrderBy DEFAULT order orid(key)
     */
    @AllArgsConstructor
    enum OrderBy {
        DEFAULT("MẶC ĐỊNH"), STAFFID("NHÂN VIÊN"), BUYERID("KHÁCH HÀNG"),
        SIZE("SỐ SẢN PHẨM"), QTY("TỔNG SẢN PHẨM"), TOTAL("THÀNH TIỀN");
        String value;

        @Override
        public String toString() {
            return this.value;
        }
    }

    /**
     * @see FilterOrder.OrderBy
     * @see FilterOrder#orderBy(java.util.List, java.util.Comparator, int)
     *
     * @param orders to filter
     * @param size to get top data
     * @param desc is order by descending
     * @param by order by Comparator
     * @return new filtered list
     */
    static List<Order> orderBy(List<Order> orders, int size, boolean desc, OrderBy by) {
        Comparator<Order> comparator;
        switch (by) {
            case STAFFID:
                comparator = Comparator.comparing(Order::getStaff_id);
                break;
            case BUYERID:
                comparator = Comparator.comparing(Order::getBuyer_id);
                break;
            case SIZE:
                comparator = Comparator.comparing(e -> e.details.size());
                break;
            case QTY:
                comparator = Comparator.comparing(e -> {
                    int qty = 0;
                    for (EnumDetail.Detail d : e.getArrDetail()) {
                        qty += d.getQuantity();
                    }
                    return qty;
                });
                break;
            case TOTAL:
                comparator = Comparator.comparing(e -> {
                    return EnumDetail.Detail.sum(e.details);
                });
                break;
            default: // defaul order by id
                comparator = Comparator.comparing(Order::getKey);
        }
        if (desc) {
            comparator.reversed();
        }

        return FilterOrder.orderBy(orders, comparator, size);
    }

    /**
     * @see FilterOrder#orderBy(java.util.List, java.util.Comparator, int)
     *
     * @param orders to filter
     * @param size to get top data
     * @param desc is order by descending
     * @param keyExtractor field extractor EX: Order::getKey
     * @return new filtered list
     */
    static List<Order> orderBy(List<Order> orders, int size, boolean desc, Function keyExtractor) {
        Comparator<Order> comparator = Comparator.comparing(keyExtractor);
        if (desc) {
            comparator.reversed();
        }
        return FilterOrder.orderBy(orders, comparator, size);
    }

    /**
     * @param orders to filter
     * @param comparator is compare sorted filter
     * @param size to get top data
     * @return
     */
    static List<Order> orderBy(List<Order> orders, Comparator<Order> comparator, int size) {
        return orders.stream()
                .sorted(comparator)
                .limit(size)
                .collect(Collectors.toList());
    }

    /**
     * @return all data
     */
    static List<Order> getList() {
        Collection<Order> clctn = DAOModel.ORDER.getMap().values();
        return new ArrayList<>(clctn);
    }

    /**
     * @param uid to filter
     * @return all data whose staff_id or buyer_id is equal to uid
     */
    static List<Order> getList(String uid) {
        Predicate<Order> predicate = e
                -> e.getBuyer_id().equals(uid)
                || e.getStaff_id().equals(uid);

        return FilterOrder.getList(predicate);
    }

    static List<Order> getListByUser(AuthAccess.ROLE role) {
        if (role == null) {
            role = AuthAccess.ROLE.BUYER;
        }
        String uid = security.getUid();
        switch (role) {
            case ADMIN:
                return getList();
            case STAFF:
                return FilterOrder.getList(e -> uid.equals(e.getStaff_id()));
            default:
                return FilterOrder.getList(e -> uid.equals(e.getBuyer_id()));
        }
    }

    static List<Order> getList(Predicate<Order> predicate) {
        Stream<Order> stream = FilterOrder.getStream();
        return stream.filter(predicate).collect(Collectors.toList());
    }

    static Stream<Order> getStream() {
        return FilterOrder.getList().stream();
    }
}
