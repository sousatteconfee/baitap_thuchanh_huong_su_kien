package shop.views.windows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import shop.models.entities.Product;
import shop.services.sql.DAOModel;
import shop.services.staticControl.Message;
import shop.views.App;

public class frame_activeProduct extends javax.swing.JFrame {

    public frame_activeProduct(App parent, boolean modal) {
        this.data = new ArrayList<>(DAOModel.PRODUCT.getMap().values());
        this.setIconImage(parent.getIconImage());
        this.parent = parent;
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading = new javax.swing.JLabel();
        scr_list = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_sum = new javax.swing.JLabel();
        lbl_isActive = new javax.swing.JLabel();
        lbl_noActive = new javax.swing.JLabel();
        btn_Update = new javax.swing.JButton();
        lbl_forChange = new javax.swing.JLabel();
        lbl_change = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DUYỆT SẢN PHẨM");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbl_heading.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(255, 153, 0));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("QUẢN LÝ TRUY CẬP SẢN PHẨM");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Số lượng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("đang mở");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("đóng");

        lbl_sum.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbl_sum.setForeground(new java.awt.Color(255, 153, 0));
        lbl_sum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sum.setText("0");
        lbl_sum.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_isActive.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbl_isActive.setForeground(new java.awt.Color(255, 153, 0));
        lbl_isActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_isActive.setText("0");
        lbl_isActive.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_noActive.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbl_noActive.setForeground(new java.awt.Color(255, 153, 0));
        lbl_noActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_noActive.setText("0");
        lbl_noActive.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_Update.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        btn_Update.setForeground(new java.awt.Color(51, 204, 255));
        btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loop-arrow.png"))); // NOI18N
        btn_Update.setText("Cập nhật");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        lbl_forChange.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_forChange.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_forChange.setText("thay đổi");

        lbl_change.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbl_change.setForeground(new java.awt.Color(255, 153, 0));
        lbl_change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_change.setText("0");
        lbl_change.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr_list)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_isActive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_noActive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_forChange, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_change, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btn_Update)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_Update)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_isActive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_noActive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_forChange, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_change, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(scr_list, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        this.actionUpdate();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        parent.setVisible(true);
        parent.reload(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_forChange;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_isActive;
    private javax.swing.JLabel lbl_noActive;
    private javax.swing.JLabel lbl_sum;
    private javax.swing.JScrollPane scr_list;
    // End of variables declaration//GEN-END:variables
    private final Map<Long, Integer> mapActive = new HashMap<>();
    private final List<Product> data;
    private final App parent;
    private JTable tbl_data;

    private void init() {
        int countActive = 0;
        for (Product p : data) {
            if (p.getActive() > 0) {
                ++countActive;
            }
        }

        tbl_data = Product.tableActive(data, true);
        lbl_sum.setText(String.valueOf(data.size()));
        lbl_isActive.setText(String.valueOf(countActive));
        lbl_noActive.setText(String.valueOf(data.size() - countActive));
        scr_list.setViewportView(tbl_data);

        tbl_data.getModel().addTableModelListener((e) -> {
            String changed;
            boolean isActive;
            int is, no;
            int rowIndex = e.getFirstRow();
            int columnIndex = e.getColumn();
            if (columnIndex < 0) {
                return;
            }

            TableModel model = (TableModel) e.getSource();
            Object key = model.getValueAt(rowIndex, 0); // get key
            Object value = model.getValueAt(rowIndex, columnIndex);

            // only active checkbox value
            if (value instanceof Boolean) {
                isActive = (Boolean) value;
                mapActive.put((Long) key, isActive ? 1 : -1); // active or lock
                changed = "Sửa đổi: " + Arrays.toString(mapActive.keySet().toArray());

                is = Integer.parseInt(lbl_isActive.getText());
                no = Integer.parseInt(lbl_noActive.getText());

                lbl_change.setText(String.valueOf(mapActive.size()));
                lbl_change.setToolTipText(changed);
                lbl_forChange.setToolTipText(changed);
                lbl_isActive.setText(String.valueOf((isActive ? ++is : --is)));
                lbl_noActive.setText(String.valueOf((isActive ? --no : ++no)));
            }
        });
    }

    private Map<Integer, List<Long>> divideMap() {
        Map<Integer, List<Long>> map = new HashMap<>();
        mapActive.forEach((k, v) -> {
            if (map.get(v) == null) {
                map.put(v, new LinkedList<>(Arrays.asList(k)));
            } else {
                ((List) map.get(v)).add(k);
            }
        });
        return map;
    }

    @SuppressWarnings("")
    private void actionUpdate() {
        Map<Integer, List<Long>> map = divideMap();
        String message;

        map.forEach((k, v) -> {
            Long[] ids = v.toArray(new Long[1]);
            DAOModel.PRODUCT.setActive(k, ids);
        });

        List<Long> isActive = map.get(1);
        List<Long> noActive = map.get(0);
        boolean isNull = isActive == null;
        boolean noNull = noActive == null;
        int isSize = isNull ? 0 : isActive.size();
        int noSize = noNull ? 0 : noActive.size();

        message = new StringBuilder("UPDATED")
                .append("\n - (").append(String.valueOf(isSize))
                .append(") VALUE ").append(Boolean.TRUE)
                .append(":").append(isNull ? "[]" : Arrays.toString(isActive.toArray()))
                .append("\n - (").append(String.valueOf(noSize))
                .append(") VALUE ").append(Boolean.FALSE)
                .append(":").append(noNull ? "[]" : Arrays.toString(noActive.toArray()))
                .toString();
        Message.alert(this.getParent(), message, "UPDATE ACTIVE PRODUCT", Message.TYPE.INFO);

        mapActive.clear();
        lbl_change.setToolTipText(null);
        lbl_forChange.setToolTipText(null);
        lbl_change.setText(String.valueOf(mapActive.size()));
    }
}
