package shop.views.windows;

import java.awt.Frame;
import java.awt.Image;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.util;
import shop.utils.Format;

public class dlg_detailUser extends javax.swing.JDialog {

    public dlg_detailUser(Frame parent, boolean modal, User u, List<Product> products) {
        super(parent, modal);
        initComponents();
        init(u, products);
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
        lbl_usertImg = new javax.swing.JLabel();
        pnl_otherInfo = new javax.swing.JPanel();
        lbl_subtile = new javax.swing.JLabel();
        txt_username = new javax.swing.JLabel();
        lbl_subtile1 = new javax.swing.JLabel();
        txt_email = new javax.swing.JLabel();
        lbl_subtile2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        lbl_subtile3 = new javax.swing.JLabel();
        txt_isActive = new javax.swing.JCheckBox();
        lbl_subtile4 = new javax.swing.JLabel();
        txt_image = new javax.swing.JLabel();
        lbl_subtile5 = new javax.swing.JLabel();
        txt_roles = new javax.swing.JLabel();
        lbl_subtile6 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
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

        lbl_usertImg.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_usertImg.setForeground(new java.awt.Color(0, 204, 204));
        lbl_usertImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usertImg.setText("username");
        lbl_usertImg.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        lbl_usertImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_usertImg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnl_groupImgLayout = new javax.swing.GroupLayout(pnl_groupImg);
        pnl_groupImg.setLayout(pnl_groupImgLayout);
        pnl_groupImgLayout.setHorizontalGroup(
            pnl_groupImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_groupImgLayout.createSequentialGroup()
                .addComponent(lbl_qrCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_usertImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_groupImgLayout.setVerticalGroup(
            pnl_groupImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_qrCode, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(lbl_usertImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_otherInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile.setText("username");
        lbl_subtile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_username.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(0, 204, 204));
        txt_username.setText(" (text...)");
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile1.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile1.setText("email");
        lbl_subtile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_email.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 204, 204));
        txt_email.setText(" (text...)");
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile2.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile2.setText("name");
        lbl_subtile2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_name.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(0, 204, 204));
        txt_name.setText(" (text...)");
        txt_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile3.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile3.setText("active");
        lbl_subtile3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 153, 51)));

        txt_isActive.setText("is active");
        txt_isActive.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 51)));
        txt_isActive.setEnabled(false);

        lbl_subtile4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile4.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile4.setText("image");
        lbl_subtile4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 153, 51)));

        txt_image.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_image.setForeground(new java.awt.Color(0, 204, 204));
        txt_image.setText("image");
        txt_image.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 153, 51)));

        lbl_subtile5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile5.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile5.setText("role");
        lbl_subtile5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 153, 51)));

        txt_roles.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_roles.setForeground(new java.awt.Color(0, 204, 204));
        txt_roles.setText(" (text...)");
        txt_roles.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 153, 51)));

        javax.swing.GroupLayout pnl_otherInfoLayout = new javax.swing.GroupLayout(pnl_otherInfo);
        pnl_otherInfo.setLayout(pnl_otherInfoLayout);
        pnl_otherInfoLayout.setHorizontalGroup(
            pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                        .addComponent(lbl_subtile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_subtile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_subtile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                        .addComponent(lbl_subtile3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_isActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_subtile4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_subtile5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_roles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        pnl_otherInfoLayout.setVerticalGroup(
            pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_otherInfoLayout.createSequentialGroup()
                .addGroup(pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_subtile)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_subtile1)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_subtile2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_otherInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_subtile3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_isActive, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_subtile4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_image, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_subtile5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_roles, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lbl_subtile6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtile6.setForeground(new java.awt.Color(0, 153, 153));
        lbl_subtile6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_subtile6.setText("register time");
        lbl_subtile6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        txt_date.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txt_date.setForeground(new java.awt.Color(0, 204, 204));
        txt_date.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txt_date.setText("(EEEE, yyyy-MMM-dd H:M:ss)");
        txt_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

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
                    .addComponent(pnl_otherInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_infoLayout.createSequentialGroup()
                        .addComponent(lbl_subtile6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_groupImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_otherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_subtile6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_listProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
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
    private javax.swing.JLabel lbl_qrCode;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_subtile;
    private javax.swing.JLabel lbl_subtile1;
    private javax.swing.JLabel lbl_subtile2;
    private javax.swing.JLabel lbl_subtile3;
    private javax.swing.JLabel lbl_subtile4;
    private javax.swing.JLabel lbl_subtile5;
    private javax.swing.JLabel lbl_subtile6;
    private javax.swing.JLabel lbl_usertImg;
    private javax.swing.JPanel pnl_box;
    private javax.swing.JPanel pnl_groupImg;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_otherInfo;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JScrollPane scr_listProduct;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_email;
    private javax.swing.JLabel txt_image;
    private javax.swing.JCheckBox txt_isActive;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_roles;
    private javax.swing.JLabel txt_username;
    // End of variables declaration//GEN-END:variables
    private final static String DEFAULT = env.DEFAULT_IMG;
    private final int USER_IMG_SIZE = 100;
    private final int PRODUCT_IMG_SIZE = 150;

    private void init(User u, List<Product> ps) {
        int uw = USER_IMG_SIZE, uh = uw, active = u.getActive();
        String[] roles = u.getAuths().toArray(new String[1]);
        String uImg = Lib.getFile(Config.folder.account, u.getImage(), DEFAULT).toString();

        // set all images
        this.setQr(u); // set qrcode;
        View.setImage(this.lbl_usertImg, uImg, uw, uh);

        // set user info
        this.lbl_usertImg.setText(u.getName());
        this.lbl_usertImg.setToolTipText(u.getEmail());
        this.txt_email.setText(u.getEmail());
        this.txt_image.setText(u.getImage());
        this.txt_isActive.setText(active > -1 ? active == 0 ? "đóng" : "mở" : "xóa");
        this.txt_name.setText(u.getName());
        this.txt_username.setText(u.getUsername());
        this.txt_roles.setText(Arrays.toString(roles));
        this.txt_date.setText(Format.DATE.format(u.getRegTime()));

        // orther info and custom
        this.setTitle(new StringBuilder("Show detail product ")
                .append("id(").append(u.getUsername()).append(") : ")
                .append(u.getName()).toString());
        this.lbl_id.setText(u.getUsername());
        this.lbl_subject.setText(u.toString2());

        // show list product of user
        JTable table = Product.table(ps);
        scr_listProduct.setViewportView(table);
    }

    private void setQr(User e) {
        int width = PRODUCT_IMG_SIZE, height = width;
        String text = String.valueOf(e.getKey());
        try {
            Image image = util.generateQrCode(text, width, height);
            lbl_qrCode.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            Logger.getLogger(dlg_detailUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
