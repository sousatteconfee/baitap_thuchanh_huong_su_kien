package shop.services.sql;

import java.io.InputStream;
import lombok.AllArgsConstructor;
import shop.services.staticControl.util;

@AllArgsConstructor
public enum EnumTypeExport {
    PRODUCTS("product_list.jrxml", "product_detail.jrxml"),
    CATEGORIES("category_list.jrxml", "category_detail.jrxml"),
    USERS("user_list.jrxml", "user_detail.jrxml"),
    ORDER("order_list.jrxml", "order_detail.jrxml");

    private final static String FOLDER = "/jasperReport";
    private final String fileList;
    private final String fileDetail;

    public InputStream getListAbsolutePath() {
        String path = new StringBuilder(FOLDER).append('/')
                .append(fileList).toString();
        return fileList == null || fileList.isEmpty()
                ? null : util.class.getResourceAsStream(path);
    }

    public InputStream getDetailAbsolutePath() {
        String path = new StringBuilder(FOLDER).append('/')
                .append(fileDetail).toString();
        return fileDetail == null || fileDetail.isEmpty()
                ? null : util.class.getResourceAsStream(path);
    }
}
