package shop.views.windows;

import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.util;

public class dlg_detailCate extends javax.swing.JDialog {

    public dlg_detailCate(Frame parent, boolean modal, Category e, List<Product> products) {
        super(parent, modal);
        initComponents();
        init(e, products);
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_box = new javax.swing.JPanel();
        pnl_top = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        lbl_subject = new javax.swing.JLabel();
        pnl_info = new javax.swing.JPanel();
        pnl_groupImg = new javax.swing.JPanel();
        lbl_qrCode = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        pnl_otherInfo = new javax.swing.JPanel();
        lbl_subtile = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        lbl_subtile7 = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        scr_listProduct = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("show detail");

        pnl_box.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 204, 255)));

        pnl_top.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 5, 0, new java.awt.Color(255, 51, 51)));

        lbl_id.setForeground(new java.awt.Color(0, 204, 204));
        lbl_id.setText("username");
        lbl_id.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        lbl_subject.setForeground(new java.awt.Color(255, 102, 0));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("account");
        lbl_subject.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbl_subject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(lbl_subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_info.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 102)));

        lbl_qrCode.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_qrCode.setForeground(new java.awt.Color(0, 204, 204));
        lbl_qrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qrCode.setText("qrcode");
        lbl_qrCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        lbl_qrCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_qrCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lbl_image.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_image.setForeground(new java.awt.Color(0, 204, 204));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setText("category name");
        lbl_image.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_image.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnl_groupImgLayout = new javax.swing.GroupLayout(pnl_groupImg);
        pnl_groupImg.setLayout(pnl_groupImgLayout);
        pnl_groupImgLayout.setHorizontalGroup(
            pnl_groupImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_groupImgLayout.createSequentialGroup()
                .addComponent(lbl_qrCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_groupImgLayout.setVerticalGroup(
            pnl_groupImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_qrCode, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_otherInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile.setText("category id");
        lbl_subtile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_id.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_id.setForeground(new java.awt.Color(0, 204, 204));
        txt_id.setText(" (text...)");
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile7.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile7.setText("category's name");
        lbl_subtile7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_name.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(0, 204, 204));
        txt_name.setText(" (text...)");
        txt_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        javax.swing.GroupLayout pnl_otherInfoLayout = new javax.swing.GroupLayout(pnl_otherInfo);
        pnl_otherInfo.setLayout(pnl_otherInfoLayout);
        pnl_otherInfoLayout.setHorizontalGroup(
            pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_subtile, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(lbl_subtile7, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_otherInfoLayout.setVerticalGroup(
            pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                .addGroup(pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_subtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_subtile7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        scr_listProduct.setAutoscrolls(true);

        javax.swing.GroupLayout pnl_infoLayout = new javax.swing.GroupLayout(pnl_info);
        pnl_info.setLayout(pnl_infoLayout);
        pnl_infoLayout.setHorizontalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scr_listProduct)
                    .addComponent(pnl_groupImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_otherInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_groupImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_otherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scr_listProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_boxLayout = new javax.swing.GroupLayout(pnl_box);
        pnl_box.setLayout(pnl_boxLayout);
        pnl_boxLayout.setHorizontalGroup(
            pnl_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_boxLayout.setVerticalGroup(
            pnl_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_boxLayout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_qrCode;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_subtile;
    private javax.swing.JLabel lbl_subtile7;
    private javax.swing.JPanel pnl_box;
    private javax.swing.JPanel pnl_groupImg;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_otherInfo;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JScrollPane scr_listProduct;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_name;
    // End of variables declaration//GEN-END:variables
    private final static String DEFAULT = env.DEFAULT_IMG;
    private final int Category_IMG_SIZE = 100;
    private final int PRODUCT_IMG_SIZE = 150;

    private void init(Category e, List<Product> ps) {
        int uw = Category_IMG_SIZE, uh = uw;
        String uImg = Lib.getFile(Config.folder.account, e.getImage(), DEFAULT).toString();

        // set all images
        this.setQr(e); // set qrcode;
        View.setImage(this.lbl_image, uImg, uw, uh);

        // set Category info
        this.lbl_image.setText(e.getName());
        this.lbl_image.setToolTipText(e.toString2());

        // orther info and custom
        this.setTitle(new StringBuilder("Show detail product ")
                .append("id(").append(e.getName()).append(") : ")
                .append(e.getName()).toString());
        this.lbl_id.setText(e.getName());
        this.lbl_subject.setText(e.toString2());

        // show list product of Category
        JTable table = Product.table(ps);
        scr_listProduct.setViewportView(table);
    }

    private void setQr(Category e) {
        int width = PRODUCT_IMG_SIZE, height = width;
        String text = String.valueOf(e.getKey());
        try {
            Image image = util.generateQrCode(text, width, height);
            lbl_qrCode.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            Logger.getLogger(dlg_detailCate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
