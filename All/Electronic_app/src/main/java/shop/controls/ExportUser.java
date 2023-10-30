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
 * "/resource/jasperReport"<br>
 * xuất dữ liệu người dùng
 */
public class ExportUser implements ExportControl<User> {

    private final EnumTypeExport type = EnumTypeExport.USERS;

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

    @Override // "/user_list.jrxml"
    public void jasperReportList(TableModel model) {
        if (model == null) {
            return;
        }
        try {
            Map<String, Object> parameters = new HashMap<>();
            ProductDAO pdao = DAOModel.PRODUCT;
            Collection<statistic.User2> uData = DAOModel.statistic.getListSUser();
            List<Product> pList = new ArrayList(pdao.getMap().values());
            int cUserUpProduct = uData.size();
            int cUser = model.getRowCount();
            int cProduct = pList.size();
            int average = (int) Math.floor(cProduct / cUser);
            String showCountUser = new StringBuilder("tổng(")
                    .append(cUser).append(") - đăng tải(")
                    .append(cUserUpProduct).append(')')
                    .toString();

            parameters.put("d1_title", "Danh sách dữ liệu và thống kê sản phẩm");
            parameters.put("d1_countUser", showCountUser);
            parameters.put("d1_countProduct", cProduct);
            parameters.put("d1_average", average + " sản phẩm / người");
            parameters.put("DataCollection", new JRTableModelDataSource(model));
            parameters.put("d1_ListStatisticU", new JRBeanCollectionDataSource(uData));

            util.jasperReport(parameters, type.getListAbsolutePath());
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override // "/user_detail.jrxml"
    public void jaspertReportDetail(User entity, Object... otherData) {
        if (entity == null) {
            return;
        }

        try {
            Map<String, Object> parameters = new HashMap<>();
            List<Product> products = (List<Product>) otherData[0];
            String d_image = Lib.getFile(
                    Config.folder.account,
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
