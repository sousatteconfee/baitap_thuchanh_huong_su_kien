package shop.views.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import shop.models.dao.CateDAO;
import shop.models.dao.UserDAO;
import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.services.sql.DAOModel;
import shop.services.sql.statistic;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.View;

public class pnl_userStatistic extends javax.swing.JPanel {

    public pnl_userStatistic() {
        initComponents();
        List<Product> list = new ArrayList(DAOModel.PRODUCT.getMap().values());
        this.cdao = DAOModel.CATE;
        this.udao = DAOModel.USER;
        this.uCountProduct = DAOModel.statistic.getListSUser();
        this.cCountProduct = DAOModel.statistic.getListSCate();
        this.userGroup = FilterProduct.groupBy(list, FilterProduct.R_BY.USER);
        this.cateGroup = FilterProduct.groupBy(list, FilterProduct.R_BY.CATEGORY);
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading_t1 = new javax.swing.JLabel();
        lyp_t1_user = new javax.swing.JLayeredPane();
        lyp_t1_cate = new javax.swing.JLayeredPane();
        cbx_user = new javax.swing.JComboBox<>();
        cbx_cate = new javax.swing.JComboBox<>();
        lyp_t1_groupUser = new javax.swing.JLayeredPane();
        lyp_t1_groupCate = new javax.swing.JLayeredPane();

        lbl_heading_t1.setForeground(new java.awt.Color(255, 153, 0));
        lbl_heading_t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading_t1.setText("PHÂN LOẠI SẢN PHẨM VÀ NGƯỜI DÙNG ĐĂNG TẢI");
        lbl_heading_t1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        lyp_t1_user.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout lyp_t1_userLayout = new javax.swing.GroupLayout(lyp_t1_user);
        lyp_t1_user.setLayout(lyp_t1_userLayout);
        lyp_t1_userLayout.setHorizontalGroup(
            lyp_t1_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lyp_t1_userLayout.setVerticalGroup(
            lyp_t1_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        lyp_t1_cate.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout lyp_t1_cateLayout = new javax.swing.GroupLayout(lyp_t1_cate);
        lyp_t1_cate.setLayout(lyp_t1_cateLayout);
        lyp_t1_cateLayout.setHorizontalGroup(
            lyp_t1_cateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lyp_t1_cateLayout.setVerticalGroup(
            lyp_t1_cateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cbx_user.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cbx_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_userActionPerformed(evt);
            }
        });

        cbx_cate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cbx_cate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cateActionPerformed(evt);
            }
        });

        lyp_t1_groupUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout lyp_t1_groupUserLayout = new javax.swing.GroupLayout(lyp_t1_groupUser);
        lyp_t1_groupUser.setLayout(lyp_t1_groupUserLayout);
        lyp_t1_groupUserLayout.setHorizontalGroup(
            lyp_t1_groupUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lyp_t1_groupUserLayout.setVerticalGroup(
            lyp_t1_groupUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        lyp_t1_groupCate.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout lyp_t1_groupCateLayout = new javax.swing.GroupLayout(lyp_t1_groupCate);
        lyp_t1_groupCate.setLayout(lyp_t1_groupCateLayout);
        lyp_t1_groupCateLayout.setHorizontalGroup(
            lyp_t1_groupCateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lyp_t1_groupCateLayout.setVerticalGroup(
            lyp_t1_groupCateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_heading_t1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbx_user, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lyp_t1_groupUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lyp_t1_user))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lyp_t1_cate)
                            .addComponent(lyp_t1_groupCate)
                            .addComponent(cbx_cate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_heading_t1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyp_t1_user)
                    .addComponent(lyp_t1_cate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyp_t1_groupUser)
                    .addComponent(lyp_t1_groupCate))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_userActionPerformed
        if (cbx_user.getSelectedItem() != null) {
            JPanel child = this.getChartGroupUser();
            View.setComponent(lyp_t1_groupUser, child);
        }
    }//GEN-LAST:event_cbx_userActionPerformed

    private void cbx_cateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cateActionPerformed
        if (cbx_cate.getSelectedItem() != null) {
            JPanel child = this.getChartGroupCate();
            View.setComponent(lyp_t1_groupCate, child);
        }
    }//GEN-LAST:event_cbx_cateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbx_cate;
    private javax.swing.JComboBox<Object> cbx_user;
    private javax.swing.JLabel lbl_heading_t1;
    private javax.swing.JLayeredPane lyp_t1_cate;
    private javax.swing.JLayeredPane lyp_t1_groupCate;
    private javax.swing.JLayeredPane lyp_t1_groupUser;
    private javax.swing.JLayeredPane lyp_t1_user;
    // End of variables declaration//GEN-END:variables
    private final UserDAO udao;
    private final CateDAO cdao;
    private final String categoryAxisLabel = "mức độ";
    private final String valueAxisLabel = "số lượng và đơn giá";
    private final String Q_TUBE = "quantity"; // field quantity of product
    private final String P_TUBE = "price"; // field price of product
    private final List<statistic.User2> uCountProduct;
    private final List<statistic.Cate2> cCountProduct;
    private final Map<Object, List<Product>> userGroup;
    private final Map<Object, List<Product>> cateGroup;

    private void init() {
        this.fillAllComboboxes(); // fill combobox

        // get all charts
        JPanel t1_user = this.getChartPanelT1User();
        JPanel t1_cate = this.getChartPanelT1Cate();
        JPanel t1_groupUser = this.getChartGroupUser();
        JPanel t1_groupCate = this.getChartGroupCate();

        // set view all chart
        View.setComponent(lyp_t1_user, t1_user);
        View.setComponent(lyp_t1_cate, t1_cate);
        View.setComponent(lyp_t1_groupUser, t1_groupUser);
        View.setComponent(lyp_t1_groupCate, t1_groupCate);
    }

    private void fillAllComboboxes() {
        // fill users're username
        for (Object item : userGroup.keySet()) {
            cbx_user.addItem(item);
        }

        // fill categories're cgid
        for (Object item : cateGroup.keySet()) {
            cbx_cate.addItem(item);
        }

        // set first selected combobox
        cbx_user.setSelectedIndex(userGroup.isEmpty() ? -1 : 0);
        cbx_cate.setSelectedIndex(cateGroup.isEmpty() ? -1 : 0);
    }

    private JPanel getChartPanelT1User() {
        String title = "THỐNG KÊ SẢN PHẨM THEO NGƯỜI BÁN";
        DefaultPieDataset dataset = new DefaultPieDataset();

        // preapare data-set
        uCountProduct.forEach(e -> {
            String key = new StringBuilder("uid=")
                    .append(e.getUsername()).append(":")
                    .append(e.getName()).toString();
            int value = e.getProductCount();
            dataset.setValue(key, value);
        });

        // create chart and jpanel
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset);
        return new ChartPanel(chart);
    }

    private JPanel getChartPanelT1Cate() {
        String title = "THỐNG KÊ SẢN PHẨM THEO PHÂN LOẠI";
        DefaultPieDataset dataset = new DefaultPieDataset();

        // preapare data-set
        cCountProduct.forEach(e -> {
            String key = new StringBuilder("id=")
                    .append(e.getCgid()).append(":")
                    .append(e.getName()).toString();
            int value = e.getProductCount();
            dataset.setValue(key, value);
        });

        // create chart and jpanel
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset);
        return new ChartPanel(chart);
    }

    private JPanel getChartGroupUser() {
        Object key = cbx_user.getSelectedItem();
        User user = udao.getById((String) key);
        CategoryDataset dataset;
        String title;

        if (user == null) {
            title = key.toString();
            dataset = this.getDataSet(null);
        } else {
            title = user.toString2().toUpperCase();
            dataset = this.getDataSet(userGroup.get(key));
        }

        JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset);
        return new ChartPanel(chart);
    }

    private JPanel getChartGroupCate() {
        Object key = cbx_cate.getSelectedItem();
        Category category = cdao.getById((Integer) key);
        CategoryDataset dataset;
        String title;

        if (category == null) {
            title = key.toString();
            dataset = this.getDataSet(null);
        } else {
            title = category.toString2().toUpperCase();
            dataset = this.getDataSet(cateGroup.get(key));
        }

        JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset);
        return new ChartPanel(chart);
    }

    // get dataset for barchar
    private DefaultCategoryDataset getDataSet(List<Product> list) {
        if (list == null || list.isEmpty()) {
            return new DefaultCategoryDataset();
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        list.forEach(e -> {
            String columnKey = new StringBuilder(e.getName()).append(":")
                    .append(e.getKey()).toString();
            dataset.addValue(e.getQuantity(), Q_TUBE, columnKey);
            dataset.addValue(e.getPrice(), P_TUBE, columnKey);
        });
        return dataset;
    }
}
