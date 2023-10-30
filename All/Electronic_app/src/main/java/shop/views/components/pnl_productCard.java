package shop.views.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;

import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.services.sql.DAOModel;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.ViewControl;
import shop.views.windows.dlg_detailProduct;

public class pnl_productCard extends javax.swing.JPanel {

    private final Long id;

    public pnl_productCard(Product e) {
        this.id = e.getPrid();
        initComponents();
        init(e);
    }

    public pnl_productCard(Product e, float ratio) {
        this.id = e.getPrid();
        initComponents();
        init(e);
        int height = this.getHeight();
        int width = (int) (ratio * height);
        this.setSize(width, height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_subject = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        pnl_bottom = new javax.swing.JPanel();
        lbl_price = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(255, 102, 102)));
        setPreferredSize(new java.awt.Dimension(150, 180));
        setLayout(new java.awt.BorderLayout());

        lbl_subject.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 0)));
        lbl_subject.setForeground(new java.awt.Color(0, 204, 204));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("product name");
        lbl_subject.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_subject.setIconTextGap(5);
        add(lbl_subject, java.awt.BorderLayout.NORTH);

        lbl_image.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setToolTipText("");
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });
        add(lbl_image, java.awt.BorderLayout.CENTER);

        pnl_bottom.setOpaque(false);

        lbl_price.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_price.setForeground(new java.awt.Color(255, 204, 102));
        lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_price.setText("price * 1000đ");

        javax.swing.GroupLayout pnl_bottomLayout = new javax.swing.GroupLayout(pnl_bottom);
        pnl_bottom.setLayout(pnl_bottomLayout);
        pnl_bottomLayout.setHorizontalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_price, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );
        pnl_bottomLayout.setVerticalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_price, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        add(pnl_bottom, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageMouseClicked
        if (evt.getClickCount() > 1) {
            Product p = getDetail(id);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_lbl_imageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JPanel pnl_bottom;
    // End of variables declaration//GEN-END:variables

    private static int w = 160, h = 200;
    private JDialog dialog = null;
    private static final String DEFAULT_FILE = env.DEFAULT_IMG;

    private void init(Product e) {
        lbl_price.setText(String.valueOf(e.getPrice() * 1000));
        lbl_subject.setText(e.getName());
        lbl_image.setToolTipText(e.getNote());
        this.setToolTipText(e.getNote());
        
        

        View.setImage(lbl_image, Lib.getFile(
                Config.folder.product,
                e.getImage(),
                DEFAULT_FILE).toString(),
                w,h
        );

        // add event click
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() > 1) {
                    Product p = getDetail(id);
                    dialog.setVisible(true);
                }
            }
        });
    }

    private Product getDetail(Long productId) {
        Product p = DAOModel.PRODUCT.getById(productId);
        Category c = DAOModel.CATE.getById(p.getCg_id());
        User u = DAOModel.USER.getById(p.getU_id());
        dialog = new dlg_detailProduct(ViewControl.ROOT_APP, true, p, c, u);
        return p;
    }

}
