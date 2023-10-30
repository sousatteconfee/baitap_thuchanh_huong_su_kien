package shop.views.components;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import shop.models.entities.Category;
import shop.services.sql.DAOModel;
import shop.services.sql.statistic;
import shop.services.staticControl.View;

public class pnl_categoryStatistic extends javax.swing.JPanel {

    public pnl_categoryStatistic() {
        initComponents();
        this.list1 = new ArrayList<>(DAOModel.CATE.getMap().values());
        this.list2 = DAOModel.statistic.getListSCate();
        this.init();
    }

    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading_t1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_sum = new javax.swing.JLabel();
        lbl_hasProduct = new javax.swing.JLabel();
        lyp_statistic = new javax.swing.JLayeredPane();
        txt_min = new com.toedter.components.JSpinField();
        txt_max = new com.toedter.components.JSpinField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        lbl_heading_t1.setForeground(new java.awt.Color(255, 153, 0));
        lbl_heading_t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading_t1.setText("THỐNG KÊ PHÂN LOẠI SẢN PHẨM");
        lbl_heading_t1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Tổng");
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel24.setText("đã chia");
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lbl_sum.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_sum.setForeground(new java.awt.Color(255, 153, 0));
        lbl_sum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sum.setText("0");
        lbl_sum.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N

        lbl_hasProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_hasProduct.setForeground(new java.awt.Color(255, 153, 0));
        lbl_hasProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_hasProduct.setText("0");
        lbl_hasProduct.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N

        javax.swing.GroupLayout lyp_statisticLayout = new javax.swing.GroupLayout(lyp_statistic);
        lyp_statistic.setLayout(lyp_statisticLayout);
        lyp_statisticLayout.setHorizontalGroup(
            lyp_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
        lyp_statisticLayout.setVerticalGroup(
            lyp_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        txt_min.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_min.setValue(9999);
        txt_min.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_minPropertyChange(evt);
            }
        });

        txt_max.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_max.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_maxPropertyChange(evt);
            }
        });

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel22.setText("min");
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel23.setText("max");
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading_t1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_min, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hasProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_max, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(lyp_statistic)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_heading_t1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_hasProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_min, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_max, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lyp_statistic))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_minPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_minPropertyChange
        int min = txt_min.getValue();
        int max = txt_max.getValue();
        if (min < 1) {
            min = 0;
        }
        if (max < 1) {
            max = 1;
        }
        this.filterShowChart(min, max);
    }//GEN-LAST:event_txt_minPropertyChange

    private void txt_maxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_maxPropertyChange
        int min = txt_min.getValue();
        int max = txt_max.getValue();
        if (min < 1) {
            min = 0;
        }
        if (max < 1) {
            max = 1;
        }
        this.filterShowChart(min, max);
    }//GEN-LAST:event_txt_maxPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel lbl_hasProduct;
    private javax.swing.JLabel lbl_heading_t1;
    private javax.swing.JLabel lbl_sum;
    private javax.swing.JLayeredPane lyp_statistic;
    private com.toedter.components.JSpinField txt_max;
    private com.toedter.components.JSpinField txt_min;
    // End of variables declaration//GEN-END:variables
    private final List<Category> list1;
    private final List<statistic.Cate2> list2;
    private final String title = "";
    private final String categoryAxisLabel = "Số sản phẩm";
    private final String valueAxisLabel = "phân loại";

    private void init() {
        JFreeChart chart = this.createChart(list2);
        JPanel child = new ChartPanel(chart);

        this.setMinMax();
        this.lbl_sum.setText(String.valueOf(list1.size()));
        this.lbl_hasProduct.setText(String.valueOf(list2.size()));
        View.setComponent(this.lyp_statistic, child);
    }

    private void filterShowChart(int min, int max) {
        Predicate<statistic.Cate2> predicate = e -> {
            int value = e.getProductCount();
            return min <= value && value <= max;
        };
        List<statistic.Cate2> list = list2.stream().filter(predicate).collect(Collectors.toList());

        JFreeChart chart = this.createChart(list);
        View.setComponent(this.lyp_statistic, new ChartPanel(chart));
    }

    private JFreeChart createChart(List<statistic.Cate2> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        data.forEach(e -> dataset.setValue(e.getProductCount(), "id:" + e.getKey(), ""));

        return ChartFactory.createBarChart3D(title, categoryAxisLabel, valueAxisLabel, dataset);
    }

    private void setMinMax() {
        int value;
        for (statistic.Cate2 e : list2) {
            value = e.getProductCount();
            if (value < txt_min.getValue()) {
                txt_min.setValue(value);
            } else if (value > txt_max.getValue()) {
                txt_max.setValue(value);
            }
        }
    }
}
