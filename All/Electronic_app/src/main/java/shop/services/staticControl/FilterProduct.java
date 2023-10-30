package shop.services.staticControl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import shop.models.entities.Product;
import shop.services.sql.DAOModel;

/**
 * "thực ra viết query cũng được"<br>
 * "tôi không muốn trỏ tới database quá nhiều"<br>
 * "để hạn chế nên tôi tạo thêm filter"
 */
public interface FilterProduct {

    public static enum SORT {
        DEFAULT,
        NAME_ASCENDING, NAME_DESCENDING,
        USER_ASCENDING, USER_DESCENDING,
        CATE_ASCENDING, CATE_DESCENDING,
        PRICE_ASCENDING, PRICE_DESCENDING,
        QUANTITY_ASCENDING, QUANTITY_DESCENDING
    }

    // References by
    public static enum R_BY {
        USER, CATEGORY
    }

    public static List<Product> containsName(String value) {
        String val = value.toLowerCase();
        Collection<Product> values = DAOModel.PRODUCT.getMap().values();
        return values.stream()
                .filter(e -> e.getName().toLowerCase().contains(val))
                .collect(Collectors.toList());
    }

    public static List<Product> containsName(String value, int active) {
        String val = value.toLowerCase();
        Collection<Product> values = DAOModel.PRODUCT.getMap().values();
        return values.stream()
                .filter(e -> e.getName().toLowerCase()
                .contains(val) && e.getActive() == active)
                .collect(Collectors.toList());
    }

    public static List<Product> listAccess() {
        Collection<Product> values = DAOModel.PRODUCT.getMap().values();
        return values.stream().filter(e -> e.getActive() > -1).collect(Collectors.toList());
    }

    public static List<Product> listAccess(int access) {
        Collection<Product> values = DAOModel.PRODUCT.getMap().values();
        Predicate<Product> predicate = e -> e.getActive() == access;
        return values.stream().filter(predicate).collect(Collectors.toList());
    }

    public static List<Product> listActive() {
        Collection<Product> values = DAOModel.PRODUCT.getMap().values();
        return values.stream().filter(e -> e.getActive() > 0).collect(Collectors.toList());
    }

    /**
     * "cái này lọc theo username hoặc mã loại"
     *
     * @param list input data to filter
     * @param getBy filter by references column
     * @param byValue get by value
     * @return list filter by R_BY
     */
    public static List<Product> getR_BY(Collection<Product> list, R_BY getBy, Object byValue) {
        Predicate<Product> predicate = null;
        switch (getBy) {
            case USER:
                predicate = e -> byValue.equals(e.getU_id());
                break;
            case CATEGORY:
                predicate = e -> byValue.equals(e.getCg_id());
                break;
        }
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * @param list input data to filter
     * @param getBy filter by references column
     * @param byValue get by value
     * @param access get all data access "active > -1"
     * @return list filter by R_BY
     */
    public static List<Product> getR_BY(Collection<Product> list, R_BY getBy, Object byValue, boolean access) {
        Predicate<Product> predicate = null;
        switch (getBy) {
            case USER:
                predicate = e -> byValue.equals(e.getU_id()) && e.getActive() > -1 == access;
                break;
            case CATEGORY:
                predicate = e -> byValue.equals(e.getCg_id()) && e.getActive() > -1 == access;
                break;
        }
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    // "group by field"
    public static Map<Object, List<Product>> groupBy(Collection<Product> list, R_BY group) {
        switch (group) {
            case USER:
                return list.stream().collect(Collectors.groupingBy(Product::getU_id));
            case CATEGORY:
                return list.stream().collect(Collectors.groupingBy(Product::getCg_id));
            default:
                throw new AssertionError();
        }
    }

    /**
     * count active and close in list parameter input, return array has 2
     * number, first is active and seconds is close
     *
     * @param list forget count active and close
     * @return [numberOfActive, numberOfClose]
     */
    public static int[] countActive(Collection<Product> list) {
        int size = list.size(), active = 0;
        for (Product e : list) {
            if (e.getActive() > 0) {
                ++active;
            }
        }
        return new int[]{active, size - active};
    }

    /**
     * "Cái này để lấy thời gian đăng ký sản phẩm sớm và muộn nhất"
     *
     * @param list to get min date and max date
     * @return [min,max] min:regTime, max:regTime<br>
     * Date[0]:minTime && Date[1]:maxTime
     */
    public static Date[] getMinMaxTime(Collection<Product> list) {
        Date[] range = {new Date(), new Date()};
        list.forEach(e -> {
            Date regTime = e.getRegTime();
            if (regTime == null) {
                regTime = new Date();
            }

            long min = range[0].getTime(), max = range[1].getTime();
            long nextAt = regTime.getTime();
            if (nextAt < min) {
                range[0] = regTime;
            } else if (nextAt > max) {
                range[1] = regTime;
            }
        });

        return range;
    }

    public static List<Product> getTop(List<Product> list, int top) {
        return FilterProduct.getRange(list, 0, top);
    }

    public static List<Product> getRange(List<Product> list, int start, int end) {
        int size = list.size();
        if (size < 1) {
            return list;
        }

        if (start < 0 || size < start) {
            start = 0;
        }

        if (end < 0 || size < end) {
            end = size;
        }

        return list.subList(start, end);
    }

    /**
     * "cái này để lấy danh sách sản phẩm trong khoảng mốc thời gian"
     *
     * @param list data input
     * @param start time register product
     * @param end time register product
     * @return list product has regTime between 'start' and 'end'
     */
    public static List<Product> inTime(Collection<Product> list, Date start, Date end) {
        List<Product> result = new ArrayList<>(list.size());
        long st = start.getTime(), en = end.getTime();

        list.forEach(e -> {
            long time = e.getRegTime().getTime();
            if (st <= time && time <= en) {
                result.add(e);
            }
        });
        return result;
    }

    /**
     * "cái này để sắp xếp dữ liệu theo filed @SORT",<br>
     * "Đâu ra cái này cay vc: Comparison method violates its general contract!"
     *
     * @param type sort by field
     * @param data to sort
     */
    public static void sort(SORT type, List<Product> data) {
        switch (type) {
            case DEFAULT:
                data.sort((x, y) -> x.getPrid() < y.getPrid() ? -1 : 1);
                break;
            case NAME_ASCENDING:
                data.sort((x, y) -> x.getName().compareTo(y.getName()));
                break;
            case NAME_DESCENDING:
                data.sort((x, y) -> -x.getName().compareTo(y.getName()));
                break;
            case USER_ASCENDING:
                data.sort((x, y) -> x.getU_id().compareTo(y.getU_id()));
                break;
            case USER_DESCENDING:
                data.sort((x, y) -> -x.getU_id().compareTo(y.getU_id()));
                break;
            case CATE_ASCENDING:
                data.sort((x, y) -> Long.compare(x.getCg_id(), y.getCg_id()));
                break;
            case CATE_DESCENDING:
                data.sort((x, y) -> -Long.compare(x.getCg_id(), y.getCg_id()));
                break;
            case QUANTITY_ASCENDING:
                data.sort((x, y) -> x.getQuantity() < y.getQuantity() ? -1 : 1);
                break;
            case QUANTITY_DESCENDING:
                data.sort((x, y) -> x.getQuantity() > y.getQuantity() ? -1 : 1);
                break;
            case PRICE_ASCENDING:
                data.sort((x, y) -> x.getPrice() < y.getPrice() ? -1 : 1);
                break;
            case PRICE_DESCENDING:
                data.sort((x, y) -> x.getPrice() > y.getPrice() ? -1 : 1);
                break;
            default:
                throw new AssertionError();
        }
    }
}
