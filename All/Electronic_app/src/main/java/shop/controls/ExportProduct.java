package shop.controls;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.*;
import shop.services.sql.DAOModel;
import shop.services.sql.EnumTypeExport;
import shop.services.sql.statistic;
import shop.services.staticControl.ExportControl;
import shop.services.staticControl.Lib;
import shop.services.staticControl.util;

/**
 * xuất dữ liệu sản phẩm<br>
 * thiết kế trong resource/jasperReport
 */
public class ExportProduct implements ExportControl<Product> {

    private final String defaultFile = env.DEFAULT_IMG;
    private final EnumTypeExport type = EnumTypeExport.PRODUCTS;

    @Override
    public void excelExportList(DefaultTableModel model) {
        if (model == null) {
            return;
        }
        try {
            util.exportExcel(model);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void jasperReportList(TableModel model) {
        if (model == null) {
            return;
        }
        try {
            Collection<statistic.Cate2> cData = DAOModel.statistic.getListSCate();
            Collection<statistic.User2> uData = DAOModel.statistic.getListSUser();
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("d1_title", "Danh sách dữ liệu và thống kê sản phẩm");
            parameters.put("d1_quantity", model.getRowCount());
            parameters.put("d1_ListStatisticC", new JRBeanCollectionDataSource(cData));
            parameters.put("d1_ListStatisticU", new JRBeanCollectionDataSource(uData));
            parameters.put("DataCollection", new JRTableModelDataSource(model));

            util.jasperReport(parameters, type.getListAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void jaspertReportDetail(Product entity, Object... otherData) {
        if (entity.getKey() < 1) {
            return;
        }
        try {
            Map<String, Object> parameters = new HashMap();
            Category cate = (Category) otherData[0];
            User user = (User) otherData[1];
            String d_image = Lib.getFile(Config.folder.product,
                    entity.getImage(), defaultFile
            ).toString(); // product image
            String d2_cimage = Lib.getFile(Config.folder.category,
                    cate.getImage(), defaultFile
            ).toString(); // category image
            String d2_uimage = Lib.getFile(Config.folder.account,
                    user.getImage(), defaultFile
            ).toString(); // user image

            parameters.put("d_entity", entity);
            parameters.put("d_image", d_image);
            parameters.put("d2_cate", cate);
            parameters.put("d2_user", user);
            parameters.put("d2_cimage", d2_cimage);
            parameters.put("d2_uimage", d2_uimage);

            util.jasperReport(parameters, type.getDetailAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }
}
