package shop.views.components;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.JTable;

import lombok.Setter;
import shop.configuration.Config;
import shop.configuration.env;
import shop.controls.FileControl;
import shop.models.entities.*;
import shop.services.sql.DAOModel;
import shop.services.staticControl.DetailControl;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.Lib;
import shop.services.staticControl.Message;
import shop.services.staticControl.View;
import shop.services.staticControl.ViewControl;
import shop.views.windows.dlg_detailCate;
import shop.views.windows.frame_ViewControl;

public class pnl_categoryDetail extends javax.swing.JPanel implements DetailControl<Category> {

    public pnl_categoryDetail() {
        initComponents();
        this.init();
        Map data = DAOModel.PRODUCT.getMap();
        C_PRODUCTS = new ArrayList<>(data.values());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_subject = new javax.swing.JLabel();
        pnl_img = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        btn_export_excel = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        pnl_info = new javax.swing.JPanel();
        lbl_textfield = new javax.swing.JLabel();
        txt_id = new com.toedter.components.JSpinField();
        lbl_textfield1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        scr_products = new javax.swing.JScrollPane();
        lbl_textfield5 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        pnl_control = new javax.swing.JPanel();
        btn_read = new javax.swing.JLabel();
        btn_insert = new javax.swing.JLabel();
        btn_previos = new javax.swing.JLabel();
        btn_next = new javax.swing.JLabel();
        btn_update = new javax.swing.JLabel();
        btn_delete = new javax.swing.JLabel();
        btn_fisrt = new javax.swing.JLabel();
        btn_last = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        lbl_subject.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        lbl_subject.setForeground(new java.awt.Color(255, 153, 51));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("user's subject");
        lbl_subject.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        add(lbl_subject, java.awt.BorderLayout.PAGE_START);

        lbl_image.setForeground(new java.awt.Color(255, 153, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        lbl_image.setText("default.png");
        lbl_image.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_image.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_export_excel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_export_excel.setForeground(new java.awt.Color(0, 204, 0));
        btn_export_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-report.png"))); // NOI18N
        btn_export_excel.setText("EXPORT");
        btn_export_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_excelActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(102, 102, 102));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loading.png"))); // NOI18N
        btn_clear.setText("làm mới");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_imgLayout = new javax.swing.GroupLayout(pnl_img);
        pnl_img.setLayout(pnl_imgLayout);
        pnl_imgLayout.setHorizontalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addComponent(btn_export_excel, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_imgLayout.setVerticalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_imgLayout.createSequentialGroup()
                .addComponent(btn_export_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear)
                .addContainerGap())
        );

        add(pnl_img, java.awt.BorderLayout.LINE_START);

        lbl_textfield.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield.setText("category id");
        lbl_textfield.setToolTipText("");
        lbl_textfield.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield.setVerifyInputWhenFocusTarget(false);

        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });

        lbl_textfield1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield1.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield1.setText("name");
        lbl_textfield1.setToolTipText("password chỉ có thêm tạo mới, không được cập nhật");
        lbl_textfield1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield1.setVerifyInputWhenFocusTarget(false);

        txt_name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        scr_products.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List product of user", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 24), new java.awt.Color(255, 153, 51))); // NOI18N

        lbl_textfield5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield5.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield5.setText("số sản phẩm");
        lbl_textfield5.setToolTipText("");
        lbl_textfield5.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield5.setVerifyInputWhenFocusTarget(false);

        lbl_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_quantity.setForeground(new java.awt.Color(255, 51, 0));
        lbl_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_quantity.setText("0");
        lbl_quantity.setToolTipText("");
        lbl_quantity.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_quantity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_quantity.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout pnl_infoLayout = new javax.swing.GroupLayout(pnl_info);
        pnl_info.setLayout(pnl_infoLayout);
        pnl_infoLayout.setHorizontalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scr_products, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_infoLayout.createSequentialGroup()
                        .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(lbl_textfield1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(lbl_textfield5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnl_infoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_quantity, lbl_textfield, lbl_textfield1, lbl_textfield5});

        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_textfield1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txt_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_products, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_infoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_quantity, lbl_textfield, lbl_textfield1, lbl_textfield5, txt_id, txt_name});

        add(pnl_info, java.awt.BorderLayout.CENTER);

        pnl_control.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_control.setLayout(new java.awt.GridLayout(0, 4, 3, 3));

        btn_read.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_read.setForeground(new java.awt.Color(0, 153, 204));
        btn_read.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_read.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btn_read.setText("Thông tin");
        btn_read.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_read.setIconTextGap(5);
        btn_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_readMouseClicked(evt);
            }
        });
        pnl_control.add(btn_read);

        btn_insert.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_insert.setForeground(new java.awt.Color(0, 255, 0));
        btn_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/insert.png"))); // NOI18N
        btn_insert.setText("Thêm");
        btn_insert.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_insert.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_insert.setIconTextGap(5);
        btn_insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_insertMouseClicked(evt);
            }
        });
        pnl_control.add(btn_insert);

        btn_previos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_previos.setForeground(new java.awt.Color(0, 255, 255));
        btn_previos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_previos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backward.png"))); // NOI18N
        btn_previos.setText("Trước đó");
        btn_previos.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_previos.setIconTextGap(5);
        btn_previos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_previosMouseClicked(evt);
            }
        });
        pnl_control.add(btn_previos);

        btn_next.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_next.setForeground(new java.awt.Color(0, 255, 255));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/forward.png"))); // NOI18N
        btn_next.setText("Tiếp theo");
        btn_next.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_next.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_next.setIconTextGap(5);
        btn_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nextMouseClicked(evt);
            }
        });
        pnl_control.add(btn_next);

        btn_update.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_update.setForeground(new java.awt.Color(255, 204, 51));
        btn_update.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loop-arrow.png"))); // NOI18N
        btn_update.setText("Cập nhật");
        btn_update.setToolTipText("password sẽ không được update");
        btn_update.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_update.setIconTextGap(5);
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        pnl_control.add(btn_update);

        btn_delete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_delete.setForeground(new java.awt.Color(255, 51, 51));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_delete.setIconTextGap(5);
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        pnl_control.add(btn_delete);

        btn_fisrt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_fisrt.setForeground(new java.awt.Color(0, 255, 255));
        btn_fisrt.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_fisrt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fast-backward.png"))); // NOI18N
        btn_fisrt.setText("Đầu tiên");
        btn_fisrt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_fisrt.setIconTextGap(5);
        btn_fisrt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fisrtMouseClicked(evt);
            }
        });
        pnl_control.add(btn_fisrt);

        btn_last.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        btn_last.setForeground(new java.awt.Color(0, 255, 255));
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fast-forward.png"))); // NOI18N
        btn_last.setText("Cuối cùng");
        btn_last.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_last.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_last.setIconTextGap(5);
        btn_last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lastMouseClicked(evt);
            }
        });
        pnl_control.add(btn_last);

        add(pnl_control, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_readMouseClicked
        this.crud(frame_ViewControl.C_TYPE.READ);
    }//GEN-LAST:event_btn_readMouseClicked

    private void btn_insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertMouseClicked
        this.crud(frame_ViewControl.C_TYPE.INSERT);
    }//GEN-LAST:event_btn_insertMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        this.crud(frame_ViewControl.C_TYPE.UPDATE);
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        this.crud(frame_ViewControl.C_TYPE.DELETE);
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_previosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_previosMouseClicked
        root.navigator(frame_ViewControl.N_TYPE.PREV);
    }//GEN-LAST:event_btn_previosMouseClicked

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        root.navigator(frame_ViewControl.N_TYPE.NEXT);
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_fisrtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fisrtMouseClicked
        root.navigator(frame_ViewControl.N_TYPE.FIRST);
    }//GEN-LAST:event_btn_fisrtMouseClicked

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        root.navigator(frame_ViewControl.N_TYPE.LAST);
    }//GEN-LAST:event_btn_lastMouseClicked

    private void btn_export_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_excelActionPerformed
        Category entity = this.getFormData();
        Integer key = entity.getCgid();
        if (key > 0) {
            List products = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.CATEGORY, key);
            root.getExportControl().jaspertReportDetail(entity, products);
        }
    }//GEN-LAST:event_btn_export_excelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.setDetail(new Category());
        this.fileControl.clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed
        if (evt.getKeyCode() == 10) {
            int id = txt_id.getValue();
            Category e = DAOModel.CATE.getById(id);
            if (e != null) {
                this.setDetail(e);
            } else {
                lbl_subject.setText("Không tìm thấy " + id);
            }
        }
    }//GEN-LAST:event_txt_idKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JButton btn_export_excel;
    private javax.swing.JLabel btn_fisrt;
    private javax.swing.JLabel btn_insert;
    private javax.swing.JLabel btn_last;
    private javax.swing.JLabel btn_next;
    private javax.swing.JLabel btn_previos;
    private javax.swing.JLabel btn_read;
    private javax.swing.JLabel btn_update;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_textfield;
    private javax.swing.JLabel lbl_textfield1;
    private javax.swing.JLabel lbl_textfield5;
    private javax.swing.JPanel pnl_control;
    private javax.swing.JPanel pnl_img;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JScrollPane scr_products;
    private com.toedter.components.JSpinField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
    private static final Config.folder FOLDER = Config.folder.category;
    private static final String DEFAULT_IMG = env.DEFAULT_IMG;
    private final List<Product> C_PRODUCTS;
    private FileControl fileControl;
    private String dataImg = null;

    @Setter
    private frame_ViewControl root;

    private void init() {
        this.fileControl = new FileControl(lbl_image, FOLDER, DEFAULT_IMG);
    }

    private void fillData() {
        int size;
        Integer key = txt_id.getValue();

        if (key > 0) {
            List data = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.CATEGORY, key);
            JTable table = Product.table(data);
            size = data.size();
            this.lbl_quantity.setText(size == 0 ? "không có." : "" + size);
            this.scr_products.setViewportView(table);
        } else {
            this.scr_products.setViewportView(null);
            this.lbl_quantity.setText("chưa tải");
        }
    }

    private void crud(frame_ViewControl.C_TYPE type) {
        try {
            Integer key = txt_id.getValue();
            Category e = this.getFormData();

            switch (type) {
                case READ:
                    root.crud(type, key);
                    return;
                case INSERT:
                    if (checkForm(e) && root.crud(type, e)) {
                        fileControl.save();
                    }
                    return;
                case UPDATE:
                    if (checkForm(e) && root.crud(type, e)) {
                        dataImg = fileControl.update(dataImg) ? e.getImage() : null;
                    }
                    return;
                case DELETE:
                    String fileName = lbl_image.getText();
                    for (Product p : DAOModel.PRODUCT.getMap().values()) {
                        if (Objects.equals(key, p.getCg_id())) {
                            Message.alert(root,
                                    "Không thể xóa phân loại đang lưu trữ sản phẩm",
                                    "DELETE Category",
                                    Message.TYPE.ERROR
                            );
                            return;
                        }
                    }
                    if (root.crud(type, key)) {
                        fileControl.delete(fileName);
                    }
                    return;
                default:
                    throw new AssertionError();
            }
        } catch (IllegalArgumentException | SQLException ex) {
            String mes = ex.getMessage();
            Message.alert(this, mes, mes, Message.TYPE.ERROR);
        }
    }

    @Override
    public void setDetail(Category e) {
        if (e == null) {
            e = new Category();
        }

        // SET ALL INFO
        this.txt_id.setValue(e.getCgid());
        this.txt_name.setText(e.getName());

        // OTHER INFO
        this.showImage(e.getImage());
        this.lbl_subject.setText(e.toString2());
        this.fillData(); // fill list product of account's cgid
    }

    @Override
    public void showDialogDetail(Category e) {
        Integer key = e.getKey();
        if (key != null && key > -1) {
            List products = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.CATEGORY, key);
            new dlg_detailCate(ViewControl.ROOT_APP, true, e, products).setVisible(true);
        } else {
            Message.alert(this, key + " doesn't exit", "show detail dialog", Message.TYPE.WARNING);
        }
    }

    private Category getFormData() {
        Integer cgid = txt_id.getValue();
        String name = txt_name.getText();
        String image = lbl_image.getText();

        return new Category(cgid, name, image);
    }

    private boolean checkForm(Category e) {

        return true;
    }

    private void showImage(String fileName) {
        dataImg = fileName;
        String pathImg = Lib.getFile(FOLDER, fileName, DEFAULT_IMG).toString();
        View.setImage(lbl_image, pathImg, 150, 150);
        this.lbl_image.setText(dataImg == null || dataImg.isEmpty() ? DEFAULT_IMG : dataImg);
    }
}
