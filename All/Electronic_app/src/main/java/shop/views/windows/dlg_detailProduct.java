package shop.views.windows;

import java.awt.Frame;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.util;
import shop.utils.Format;

public class dlg_detailProduct extends javax.swing.JDialog {

    public dlg_detailProduct(Frame parent, boolean modal, Product p, Category c, User u) {
        super(parent, modal);
        initComponents();
        init(c, u, p);
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
        lbl_productImg = new javax.swing.JLabel();
        lbl_cateImg = new javax.swing.JLabel();
        lbl_userImg = new javax.swing.JLabel();
        pnl_otherInfo = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JLabel();
        lbl_cateName = new javax.swing.JLabel();
        txt_cateName = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        txt_price = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        spn_note = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("show detail");

        pnl_box.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 204, 255)));

        pnl_top.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 5, 0, new java.awt.Color(255, 51, 51)));

        lbl_id.setForeground(new java.awt.Color(0, 204, 204));
        lbl_id.setText("product id");
        lbl_id.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        lbl_subject.setForeground(new java.awt.Color(255, 102, 0));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("product name");
        lbl_subject.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbl_subject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(lbl_subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_info.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 102)));

        pnl_groupImg.setLayout(new java.awt.GridLayout(0, 2));

        lbl_qrCode.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_qrCode.setForeground(new java.awt.Color(0, 204, 204));
        lbl_qrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qrCode.setText("qrcode");
        lbl_qrCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        lbl_qrCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_qrCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_groupImg.add(lbl_qrCode);

        lbl_productImg.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_productImg.setForeground(new java.awt.Color(0, 204, 204));
        lbl_productImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_productImg.setText("Product Image");
        lbl_productImg.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        lbl_productImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_productImg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_groupImg.add(lbl_productImg);

        lbl_cateImg.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_cateImg.setForeground(new java.awt.Color(0, 204, 204));
        lbl_cateImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cateImg.setText("category name");
        lbl_cateImg.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 153, 51), new java.awt.Color(255, 204, 51)));
        lbl_cateImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_cateImg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_groupImg.add(lbl_cateImg);

        lbl_userImg.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_userImg.setForeground(new java.awt.Color(0, 204, 204));
        lbl_userImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userImg.setText("full name");
        lbl_userImg.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 153, 51), new java.awt.Color(255, 204, 51)));
        lbl_userImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_userImg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_groupImg.add(lbl_userImg);

        pnl_otherInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        pnl_otherInfo.setLayout(new java.awt.GridLayout(0, 2));

        lbl_quantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(0, 153, 153));
        lbl_quantity.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_quantity.setText("Quantity: ");
        lbl_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        pnl_otherInfo.add(lbl_quantity);

        txt_quantity.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(0, 204, 204));
        txt_quantity.setText("~ (quantity)");
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        pnl_otherInfo.add(txt_quantity);

        lbl_cateName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_cateName.setForeground(new java.awt.Color(0, 153, 153));
        lbl_cateName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_cateName.setText("Category: ");
        lbl_cateName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        pnl_otherInfo.add(lbl_cateName);

        txt_cateName.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_cateName.setForeground(new java.awt.Color(0, 204, 204));
        txt_cateName.setText("(product name)");
        txt_cateName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        pnl_otherInfo.add(txt_cateName);

        lbl_price.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_price.setForeground(new java.awt.Color(0, 153, 153));
        lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_price.setText("Price: ");
        pnl_otherInfo.add(lbl_price);

        txt_price.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_price.setForeground(new java.awt.Color(0, 204, 204));
        txt_price.setText("(price)");
        pnl_otherInfo.add(txt_price);

        txt_date.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_date.setForeground(new java.awt.Color(0, 204, 204));
        txt_date.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txt_date.setText("(EEEE, yyyy-MMM-dd H:M:ss)");
        txt_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        spn_note.setOpaque(false);

        txt_note.setEditable(false);
        txt_note.setColumns(20);
        txt_note.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_note.setForeground(new java.awt.Color(0, 204, 204));
        txt_note.setLineWrap(true);
        txt_note.setText("(note)");
        txt_note.setWrapStyleWord(true);
        txt_note.setAutoscrolls(false);
        txt_note.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        txt_note.setOpaque(false);
        spn_note.setViewportView(txt_note);

        javax.swing.GroupLayout pnl_infoLayout = new javax.swing.GroupLayout(pnl_info);
        pnl_info.setLayout(pnl_infoLayout);
        pnl_infoLayout.setHorizontalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_groupImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_infoLayout.createSequentialGroup()
                        .addComponent(pnl_otherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_note)))
                .addContainerGap())
        );
        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_groupImg, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spn_note)
                    .addComponent(pnl_otherInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_date))
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
    private javax.swing.JLabel lbl_cateImg;
    private javax.swing.JLabel lbl_cateName;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_productImg;
    private javax.swing.JLabel lbl_qrCode;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_userImg;
    private javax.swing.JPanel pnl_box;
    private javax.swing.JPanel pnl_groupImg;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_otherInfo;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JScrollPane spn_note;
    private javax.swing.JLabel txt_cateName;
    private javax.swing.JLabel txt_date;
    private javax.swing.JTextArea txt_note;
    private javax.swing.JLabel txt_price;
    private javax.swing.JLabel txt_quantity;
    // End of variables declaration//GEN-END:variables
    private final static String DEFAULT = env.DEFAULT_IMG;
    private final int CATE_IMG_SIZE = 50;
    private final int USER_IMG_SIZE = 100;
    private final int PRODUCT_IMG_SIZE = 150;

    private void init(Category c, User u, Product p) {
        int cw = CATE_IMG_SIZE, ch = cw;
        int uw = USER_IMG_SIZE, uh = uw;
        int pw = PRODUCT_IMG_SIZE, ph = pw;

        // get all path-images
        String cImg = Lib.getFile(Config.folder.category, c.getImage(), DEFAULT).toString();
        String uImg = Lib.getFile(Config.folder.account, u.getImage(), DEFAULT).toString();
        String pImg = Lib.getFile(Config.folder.product, p.getImage(), DEFAULT).toString();

        // set all images
        View.setImage(this.lbl_cateImg, cImg, cw, ch);
        View.setImage(this.lbl_userImg, uImg, uw, uh);
        View.setImage(this.lbl_productImg, pImg, pw, ph);

        // set category info
        this.txt_cateName.setText(c.getName());
        this.lbl_cateImg.setText(c.getImage());
        this.lbl_cateImg.setToolTipText("Product id " + c.getCgid());

        // set qrcode;
        this.setQr(p);

        // set user info
        this.lbl_userImg.setText(u.getName());
        this.lbl_userImg.setToolTipText(u.getEmail());

        // set product info
        this.txt_note.setText(p.getNote());
        this.lbl_subject.setText(p.toString2());
        this.lbl_id.setText("ID: " + p.getPrid());
        this.lbl_productImg.setText(p.getImage());
        this.txt_price.setText("" + p.getPrice());
        this.txt_quantity.setText("~" + p.getQuantity());
        this.txt_date.setText(Format.DATE.format(p.getRegTime()));

        // orther info and custom
        this.setTitle(new StringBuilder("Show detail product ")
                .append("id(").append(p.getName()).append(") : ")
                .append(p.getName()).toString());
    }

    private void setQr(Product e) {
        int width = PRODUCT_IMG_SIZE, height = width;
        String text = String.valueOf(e.getKey());
        try {
            Image image = util.generateQrCode(text, width, height);
            lbl_qrCode.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            Logger.getLogger(dlg_detailProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
