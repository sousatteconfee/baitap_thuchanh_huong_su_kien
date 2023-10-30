package shop.controls;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Order;
import shop.models.entities.Product;
import shop.services.sql.EnumDetail;
import shop.services.sql.EnumTypeExport;
import shop.services.staticControl.Lib;
import shop.services.staticControl.util;
import shop.utils.Format;

public class ExportOrder {

    private final EnumTypeExport type = EnumTypeExport.ORDER;

    public static String pathImg(Product p) {
        return Lib.getFile(
                env.folder.product,
                p.getImage(),
                env.DEFAULT_IMG
        ).getAbsolutePath();
    }

    public void detail(Order o) {
        try {
            String productFolder = Lib.getDir(Config.folder.product);
            Map<String, Object> parameters = new HashMap<>();
            Number[] sqs = EnumDetail.Detail.sqs(o.details);
            int size = sqs[0].intValue();
            int quantity = sqs[1].intValue();
            double sum = sqs[2].doubleValue();
            TableModel model = EnumDetail.Detail.table(o.details).getModel();

            parameters.put("title", "Thống kê chi tiết hóa đơn");
            parameters.put("pathImg", productFolder);
            parameters.put("entity", o);
            parameters.put("size", size);
            parameters.put("quantity", quantity);
            parameters.put("total", Format.number(null, sum));
            parameters.put("collection", new JRTableModelDataSource(model));

            util.jasperReport(parameters, type.getDetailAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }

    public void list(Order o) throws JRException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
