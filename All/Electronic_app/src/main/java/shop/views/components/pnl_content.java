package shop.views.components;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lombok.Getter;
import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.*;
import shop.services.sql.DAOModel;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.ViewControl;
import shop.services.staticControl.util;
import shop.utils.Format;
import shop.views.windows.dlg_detailProduct;
import shop.views.windows.dlg_orderScanner;

public class pnl_content extends javax.swing.JPanel {
    
    public pnl_content(dlg_orderScanner root, Product p) {
        initComponents();
        this.root = root;
        this.p = p;
        this.init();
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_image = new javax.swing.JLabel();
        lbl_subject = new javax.swing.JLabel();
        lbl_barcode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_quantity = new com.toedter.components.JSpinField();
        jLabel5 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        btn_remove = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_image.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbl_image.setForeground(new java.awt.Color(255, 153, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        lbl_image.setText("default.png");
        lbl_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_image.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lbl_subject.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lbl_subject.setForeground(new java.awt.Color(255, 153, 51));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("product's name");
        lbl_subject.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 3, 0, new java.awt.Color(255, 153, 51)));

        lbl_barcode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_barcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_barcode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/app.png"))); // NOI18N
        lbl_barcode.setText("barcode");
        lbl_barcode.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_barcode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_barcode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("đơn giá");

        lbl_price.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_price.setForeground(new java.awt.Color(51, 204, 0));
        lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_price.setText("0.0");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("số lượng");

        txt_quantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_quantityPropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Tổng");

        lbl_total.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(51, 204, 0));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.0");

        btn_remove.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_remove.setForeground(new java.awt.Color(204, 0, 0));
        btn_remove.setText("Xóa");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_remove))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_price, lbl_total, txt_quantity});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_remove)
                    .addComponent(lbl_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_price))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_total)))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel4, jLabel5, lbl_price, lbl_total, txt_quantity});

    }// </editor-fold>//GEN-END:initComponents

    private void txt_quantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_quantityPropertyChange
        this.total();
    }//GEN-LAST:event_txt_quantityPropertyChange

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getClickCount() > 1) {
            Category c = DAOModel.CATE.getById(p.getCg_id());
            User u = DAOModel.USER.getById(p.getU_id());
            new dlg_detailProduct(ViewControl.ROOT_APP, true, p, c, u).setVisible(true);
        }
    }//GEN-LAST:event_formMouseClicked

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        this.root.removeContent(p.getPrid());
    }//GEN-LAST:event_btn_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_remove;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_barcode;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_total;
    private com.toedter.components.JSpinField txt_quantity;
    // End of variables declaration//GEN-END:variables
    private final static int W = 128, H = 128;
    private final dlg_orderScanner root;
    @Getter
    private final Product p;
    
    public void setQty(int qty) {
        this.txt_quantity.setValue(qty);
        this.total();
    }
    
    private void init() {
        String path = Lib.getFile(
                Config.folder.product,
                p.getImage(),
                env.DEFAULT_IMG
        ).getAbsolutePath();
        
        View.setImage(lbl_image, path, W, H);
        this.lbl_image.setText(p.getImage());
        this.lbl_subject.setText(p.getName());
        this.lbl_price.setText(String.valueOf(p.getPrice()));
        this.setQty(p.getQuantity());
        this.setBarcode();
    }
    
    private void setBarcode() {
        try {
            String text = String.valueOf(p.getPrid());
            Image image = util.generateBarCode(text);
            ImageIcon icon = new ImageIcon(image);
            int w = image.getWidth(icon.getImageObserver());
            lbl_barcode.setText(text);
            lbl_barcode.setIcon(new ImageIcon(image.getScaledInstance(w, 60, 1)));
        } catch (Exception ex) {
            Logger.getLogger(pnl_content.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void total() {
        int qty = this.txt_quantity.getValue();
        double total = p.getPrice() * qty;
        this.lbl_total.setText(Format.number(null, total));
        this.p.setQuantity(qty);
        this.root.calculator();
    }
}
