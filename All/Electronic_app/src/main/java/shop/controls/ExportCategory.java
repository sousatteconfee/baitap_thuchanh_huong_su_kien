package shop.controls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import shop.configuration.Config;
import shop.configuration.env;
import shop.models.dao.ProductDAO;
import shop.models.entities.*;
import shop.services.sql.DAOModel;
import shop.services.sql.EnumTypeExport;
import shop.services.sql.statistic;
import shop.services.staticControl.ExportControl;
import shop.services.staticControl.Lib;
import shop.services.staticControl.util;

/**
 * xuất dữ liệu phân loại sản phẩm<br>
 * "/resource/jasperReport"
 */
public class ExportCategory implements ExportControl<Category> {

    private final EnumTypeExport type = EnumTypeExport.CATEGORIES;

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

    @Override // "/category_list.jrxml"
    public void jasperReportList(TableModel model) {
        if (model == null) {
            return;
        }
        try {
            ProductDAO pdao = DAOModel.PRODUCT;
            Map<String, Object> parameters = new HashMap<>();
            Collection<statistic.Cate2> cData = DAOModel.statistic.getListSCate();
            List<Product> pList = new ArrayList<>(pdao.getMap().values());
            int cCateProduct = cData.size();
            int cUser = model.getRowCount();
            int cProduct = pList.size();
            int average = (int) Math.floor(cProduct / cUser);
            String showCountCate = new StringBuilder("tổng(")
                    .append(cUser).append(") - đăng tải(")
                    .append(cCateProduct).append(')')
                    .toString();

            parameters.put("d1_title", "Danh sách dữ liệu và thống kê sản phẩm");
            parameters.put("d1_countCate", showCountCate);
            parameters.put("d1_countProduct", cProduct);
            parameters.put("d1_average", average + " sản phẩm / loại");
            parameters.put("DataCollection", new JRTableModelDataSource(model));
            parameters.put("d1_ListStatisticC", new JRBeanCollectionDataSource(cData));

            util.jasperReport(parameters, type.getListAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }

    
    @Override // "/category_detail.jrxml"
    public void jaspertReportDetail(Category entity, Object... otherData) {
        if (entity == null) {
            return;
        }

        try {
            Map<String, Object> parameters = new HashMap<>();
            List<Product> products = (List<Product>) otherData[0];
            String d_image = Lib.getFile(
                    Config.folder.category,
                    entity.getImage(),
                    env.DEFAULT_IMG)
                    .getAbsolutePath();

            parameters.put("d_entity", entity);
            parameters.put("d_image", d_image);
            parameters.put("DataCollection", new JRBeanCollectionDataSource(products));

            util.jasperReport(parameters, type.getDetailAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());

        }
    }
}
