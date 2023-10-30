package shop.views.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import shop.models.entities.Product;
import shop.services.sql.DAOModel;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.View;

public class pnl_productStatistic extends javax.swing.JPanel {

    public pnl_productStatistic() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_filter = new javax.swing.JPanel();
        lbl_subtitle = new javax.swing.JLabel();
        txt_qty = new com.toedter.components.JSpinField();
        dcs_start = new com.toedter.calendar.JDateChooser();
        dcs_end = new com.toedter.calendar.JDateChooser();
        lbl_subtitle1 = new javax.swing.JLabel();
        lbl_subtitle2 = new javax.swing.JLabel();
        lbl_subtitle3 = new javax.swing.JLabel();
        cbx_sort = new javax.swing.JComboBox<>();
        btn_filter = new javax.swing.JButton();
        lbl_subtitle4 = new javax.swing.JLabel();
        lbl_maxQty = new javax.swing.JLabel();
        srp_QtyAndPrice = new javax.swing.JScrollPane();
        lyp_QtyAndPrice = new javax.swing.JLayeredPane();

        lbl_subtitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subtitle.setText("Số lượng hiển thị");
        lbl_subtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_qty.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_qty.setToolTipText("Số lượng hiển thị");
        txt_qty.setValue(15);

        dcs_start.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dcs_start.setDateFormatString("dd/MM/yyyy hh:mm:ss");
        dcs_start.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        dcs_end.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dcs_end.setDateFormatString("dd/MM/yyyy hh:mm:ss");
        dcs_end.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        lbl_subtitle1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subtitle1.setText("thời gian bắt đầu");
        lbl_subtitle1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_subtitle2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subtitle2.setText("thời gian kết thúc");
        lbl_subtitle2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_subtitle3.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        lbl_subtitle3.setForeground(new java.awt.Color(255, 153, 51));
        lbl_subtitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subtitle3.setText("~");
        lbl_subtitle3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(255, 102, 51)));

        cbx_sort.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbx_sort.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 16), new java.awt.Color(255, 153, 0))); // NOI18N
        cbx_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_sortActionPerformed(evt);
            }
        });

        btn_filter.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_filter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loading.png"))); // NOI18N
        btn_filter.setText("lọc dữ liệu");
        btn_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filterActionPerformed(evt);
            }
        });

        lbl_subtitle4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtitle4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtitle4.setText("Tổng");
        lbl_subtitle4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_maxQty.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_maxQty.setForeground(new java.awt.Color(255, 153, 51));
        lbl_maxQty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_maxQty.setText("0");
        lbl_maxQty.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        javax.swing.GroupLayout pnl_filterLayout = new javax.swing.GroupLayout(pnl_filter);
        pnl_filter.setLayout(pnl_filterLayout);
        pnl_filterLayout.setHorizontalGroup(
            pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_filterLayout.createSequentialGroup()
                        .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_subtitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcs_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_subtitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_filterLayout.createSequentialGroup()
                        .addComponent(lbl_subtitle, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcs_end, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lbl_subtitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_filterLayout.createSequentialGroup()
                        .addComponent(lbl_subtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_maxQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnl_filterLayout.setVerticalGroup(
            pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_filterLayout.createSequentialGroup()
                        .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_qty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_subtitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_maxQty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_subtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_filterLayout.createSequentialGroup()
                                .addComponent(lbl_subtitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(dcs_end, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addGroup(pnl_filterLayout.createSequentialGroup()
                                .addComponent(lbl_subtitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(dcs_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_subtitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_filterLayout.createSequentialGroup()
                        .addComponent(cbx_sort, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_filter)))
                .addContainerGap())
        );

        javax.swing.GroupLayout lyp_QtyAndPriceLayout = new javax.swing.GroupLayout(lyp_QtyAndPrice);
        lyp_QtyAndPrice.setLayout(lyp_QtyAndPriceLayout);
        lyp_QtyAndPriceLayout.setHorizontalGroup(
            lyp_QtyAndPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        lyp_QtyAndPriceLayout.setVerticalGroup(
            lyp_QtyAndPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        srp_QtyAndPrice.setViewportView(lyp_QtyAndPrice);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(srp_QtyAndPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(pnl_filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srp_QtyAndPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filterActionPerformed
        this.actionFilter();
    }//GEN-LAST:event_btn_filterActionPerformed

    private void cbx_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_sortActionPerformed
        FilterProduct.SORT sort = (FilterProduct.SORT) cbx_sort.getSelectedItem();
        FilterProduct.sort(sort, data);
    }//GEN-LAST:event_cbx_sortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_filter;
    private javax.swing.JComboBox<FilterProduct.SORT> cbx_sort;
    private com.toedter.calendar.JDateChooser dcs_end;
    private com.toedter.calendar.JDateChooser dcs_start;
    private javax.swing.JLabel lbl_maxQty;
    private javax.swing.JLabel lbl_subtitle;
    private javax.swing.JLabel lbl_subtitle1;
    private javax.swing.JLabel lbl_subtitle2;
    private javax.swing.JLabel lbl_subtitle3;
    private javax.swing.JLabel lbl_subtitle4;
    private javax.swing.JLayeredPane lyp_QtyAndPrice;
    private javax.swing.JPanel pnl_filter;
    private javax.swing.JScrollPane srp_QtyAndPrice;
    private com.toedter.components.JSpinField txt_qty;
    // End of variables declaration//GEN-END:variables
    private List<Product> data;
    private final String title = "ĐƠN GIÁ VÀ SỐ LƯỢNG SẢN PHẨM";
    private final String categoryAxisLabel = "Đơn giá và số lượng";
    private final String valueAxisLabel = "Số lượng";
    private final String Q_TUBE = "quantity"; // field quantity of product
    private final String P_TUBE = "price"; // field price of product
    private final int default_qty = 20;

    private void init() {
        Map map = DAOModel.PRODUCT.getMap();
        data = new ArrayList<>(map.values());
        this.txt_qty.setMaximum(data.size());
        this.txt_qty.setValue(default_qty);
        this.lbl_maxQty.setText("" + data.size());
        this.fillComboBox();
        this.fillRangeDate();

        List list = FilterProduct.getTop(data, default_qty);
        JPanel child = this.getJPanelStatitic(list);
        View.setComponent(this.lyp_QtyAndPrice, child);
    }

    // filter list product and show new chart
    private void actionFilter() {
        Date start = dcs_start.getDate();
        Date end = dcs_end.getDate();
        int top = txt_qty.getValue();
        // get product between times
        List list = FilterProduct.inTime(data, start, end);
        this.txt_qty.setMaximum(list.size()); // set range data
        this.lbl_maxQty.setText("" + list.size());
        list = FilterProduct.getTop(list, top); // get top product
        JPanel child = this.getJPanelStatitic(list);
        View.setComponent(lyp_QtyAndPrice, child); // view chart
    }

    // set all sort combobox
    private void fillComboBox() {
        for (FilterProduct.SORT sort : FilterProduct.SORT.values()) {
            cbx_sort.addItem(sort);
        }
        cbx_sort.setSelectedItem(FilterProduct.SORT.DEFAULT);
    }

    // set min and max date
    private void fillRangeDate() {
        Date[] range = FilterProduct.getMinMaxTime(data);
        dcs_start.setDate(range[0]);
        dcs_end.setDate(range[1]);
    }

    // create ChartPanel(JPanel) from JFreeChart & list data
    private JPanel getJPanelStatitic(List list) {
        JFreeChart chart = this.getChart(list); // create chart
        return new ChartPanel(chart); // create chart panel
    }

    // generation Jfreechar from list product
    private JFreeChart getChart(List<Product> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        list.forEach(e -> {
            String columnKey = new StringBuilder(e.getName()).append(":")
                    .append(e.getKey()).toString();
            dataset.addValue(e.getQuantity(), Q_TUBE, columnKey);
            dataset.addValue(e.getPrice(), P_TUBE, columnKey);
        });
        return ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset);
    }
}
