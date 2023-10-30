package shop.views.windows;

import java.awt.Color;
import java.awt.Container;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import shop.configuration.AuthAccess;
import shop.configuration.env;
import shop.configuration.security;
import shop.controls.FileControl;
import shop.models.entities.User;
import shop.services.sql.DAOModel;
import shop.services.staticControl.ConfirmDialog;
import shop.services.staticControl.FilterUser;
import shop.services.staticControl.Message;
import shop.services.staticControl.Regex;
import shop.services.staticControl.ViewControl;

public class dlg_security_register extends javax.swing.JDialog implements ConfirmDialog {

    public dlg_security_register(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.fileControl = new FileControl(lbl_image, FOLDER, DEFAULT_IMG);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_groupRole = new javax.swing.ButtonGroup();
        lbl_heading = new javax.swing.JLabel();
        pnl_detail = new javax.swing.JPanel();
        lbl_textfield = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_textfield1 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        lbl_textfield3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_textfield4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        lbl_textfield5 = new javax.swing.JLabel();
        rdo_seller = new javax.swing.JRadioButton();
        rdo_buyer = new javax.swing.JRadioButton();
        lbl_image = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lbl_forForgotPass = new javax.swing.JLabel();
        btn_changeImg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐĂNG KÝ TÀI KHOẢN");

        lbl_heading.setForeground(new java.awt.Color(255, 153, 51));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("ĐĂNG KÝ TÀI KHOẢN");
        lbl_heading.setFocusable(false);
        lbl_heading.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        lbl_textfield.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield.setText("Tên đăng nhập");
        lbl_textfield.setToolTipText("");
        lbl_textfield.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield.setVerifyInputWhenFocusTarget(false);

        txt_username.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_textfield1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield1.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield1.setText("password");
        lbl_textfield1.setToolTipText("password chỉ có thêm tạo mới, không được cập nhật");
        lbl_textfield1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield1.setVerifyInputWhenFocusTarget(false);

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_textfield3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield3.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield3.setText("email");
        lbl_textfield3.setToolTipText("");
        lbl_textfield3.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield3.setVerifyInputWhenFocusTarget(false);

        txt_email.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_textfield4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield4.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield4.setText("họ và tên");
        lbl_textfield4.setToolTipText("");
        lbl_textfield4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield4.setVerifyInputWhenFocusTarget(false);

        txt_name.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_textfield5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield5.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield5.setText("đăng ký");
        lbl_textfield5.setToolTipText("");
        lbl_textfield5.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield5.setVerifyInputWhenFocusTarget(false);

        btn_groupRole.add(rdo_seller);
        rdo_seller.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdo_seller.setText("người bán");

        btn_groupRole.add(rdo_buyer);
        rdo_buyer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdo_buyer.setText("người mua");

        javax.swing.GroupLayout pnl_detailLayout = new javax.swing.GroupLayout(pnl_detail);
        pnl_detail.setLayout(pnl_detailLayout);
        pnl_detailLayout.setHorizontalGroup(
            pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detailLayout.createSequentialGroup()
                        .addComponent(lbl_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                    .addGroup(pnl_detailLayout.createSequentialGroup()
                        .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_textfield5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_textfield4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_textfield3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_textfield1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_detailLayout.createSequentialGroup()
                                .addComponent(rdo_seller, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdo_buyer))
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pnl_detailLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rdo_buyer, rdo_seller});

        pnl_detailLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_textfield, lbl_textfield1, lbl_textfield3, lbl_textfield4, lbl_textfield5});

        pnl_detailLayout.setVerticalGroup(
            pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txt_username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_buyer)
                    .addComponent(rdo_seller))
                .addContainerGap())
        );

        pnl_detailLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_textfield, lbl_textfield1, lbl_textfield3, lbl_textfield4, lbl_textfield5, rdo_buyer, rdo_seller, txt_email, txt_name, txt_password, txt_username});

        rdo_seller.getAccessibleContext().setAccessibleName("role");
        rdo_buyer.getAccessibleContext().setAccessibleName("role");

        lbl_image.setForeground(new java.awt.Color(255, 153, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        lbl_image.setText("default.png");
        lbl_image.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_image.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_login.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loading.png"))); // NOI18N
        btn_login.setText("Làm mới");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_register.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-user.png"))); // NOI18N
        btn_register.setText("Đăng ký");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        lbl_forForgotPass.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbl_forForgotPass.setForeground(new java.awt.Color(255, 102, 0));
        lbl_forForgotPass.setText("trang đăng nhập");
        lbl_forForgotPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 0)));
        lbl_forForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_forForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_forForgotPassMouseClicked(evt);
            }
        });

        btn_changeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/image.png"))); // NOI18N
        btn_changeImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_changeImg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_forForgotPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_register)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_login)
                            .addComponent(btn_register)
                            .addComponent(lbl_forForgotPass)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_changeImg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        this.register();
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void lbl_forForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forForgotPassMouseClicked
        this.dispose();
        ViewControl.S_LOGIN.setVisible(true);
    }//GEN-LAST:event_lbl_forForgotPassMouseClicked

    private void btn_changeImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeImgActionPerformed
        fileControl.setFileImg();
    }//GEN-LAST:event_btn_changeImgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_changeImg;
    private javax.swing.ButtonGroup btn_groupRole;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel lbl_forForgotPass;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_textfield;
    private javax.swing.JLabel lbl_textfield1;
    private javax.swing.JLabel lbl_textfield3;
    private javax.swing.JLabel lbl_textfield4;
    private javax.swing.JLabel lbl_textfield5;
    private javax.swing.JPanel pnl_detail;
    private javax.swing.JRadioButton rdo_buyer;
    private javax.swing.JRadioButton rdo_seller;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
    private final env.folder FOLDER = env.folder.account;
    private final String DEFAULT_IMG = env.DEFAULT_IMG;
    private final FileControl fileControl;

    private void register() {
        User e = this.getForm(), result;
        if (checkForm(e) && isConfirmEmail(e.getEmail())) {
            try {
                if ((result = DAOModel.USER.insert(e)) != null) {
                    fileControl.save(); // save image

                    int selection = Message.confirm(this, new StringBuilder(result.getUsername())
                            .append(" Đã được đăng ký")
                            .append("\n - Xin chào ").append(result.getName())
                            .append("\n - Bạn đã đăng ký với vai trò: ")
                            .append(Arrays.toString(result.getAuths().toArray()))
                            .append("\n - đăng nhập tài khoản: ")
                            .append(result.getUsername()).append("?")
                            .toString(),
                            this.getTitle(), Message.CF_TYPE.YES_NO
                    );
                    this.clearForm();
                    if (selection == 0) {
                        security.login(e.getUsername(), e.getPassword());
                        ViewControl.ROOT_APP.loadControlDisplay();
                        this.dispose();
                    }
                }
            } catch (SQLException ex) {
                Message.alert(this,
                        "Đăng ký tài khoản thất bại!\n" + ex.getMessage(),
                        this.getTitle(), Message.TYPE.ERROR
                );
            }
        }
    }

    private User getForm() {
        String username = txt_username.getText();
        String password = String.valueOf(txt_password.getPassword());
        String email = txt_email.getText();
        String name = txt_name.getText();
        int active = 1; // open
        String image = lbl_image.getText();
        Date regTime = new Date();
        String roles = rdo_seller.isSelected()
                ? AuthAccess.ROLE.SELLER.value
                : AuthAccess.ROLE.BUYER.value; // default is BUYER
        return new User(username, password, email, name, active, image, regTime, roles);
    }

    private void clearForm() {
        this.txt_username.setText(null);
        this.txt_password.setText(null);
        this.txt_email.setText(null);
        this.txt_name.setText(null);
        this.rdo_buyer.setSelected(false);
        this.rdo_seller.setSelected(false);

        txt_username.setBackground(null);
        txt_password.setBackground(null);
        txt_email.setBackground(null);
        txt_name.setBackground(null);
        txt_username.setBackground(null);
    }

    private boolean checkForm(User e) {
        String message;
        String title = this.getTitle();
        Container parent = this.getParent();

        // check username
        if (FilterUser.getByUserName(e.getUsername()) != null) {
            message = e.getUsername() + " đã được đăng ký";
            Message.alert(parent, message, title, Message.TYPE.WARNING);
            txt_username.setBackground(Color.RED);
            return false;
        }

        if (!Regex.isRegex(e.getUsername(), Regex.PATTERNS.NO_SPECIAL)) {
            message = new StringBuilder(e.getUsername()).append(" không đúng định dạng")
                    .append("\n - Không được chứa ký tự đặc biệt")
                    .append("\n - Không được chứa khoảng trắng").toString();
            Message.alert(parent, message, title, Message.TYPE.WARNING);
            txt_username.setBackground(Color.YELLOW);
            return false;
        }

        // check password
        if (!Regex.isRegex(e.getPassword(), Regex.PATTERNS.PASSWORD)) {
            message = new StringBuilder(e.getPassword()).append(" không đúng định dạng").toString();
            Message.alert(parent, message, title, Message.TYPE.WARNING);
            txt_password.setBackground(Color.YELLOW);
            return false;
        }

        // check email
        if (FilterUser.getByEmail(e.getEmail()) != null) {
            message = e.getEmail() + " đã được đăng ký";
            Message.alert(parent, message, title, Message.TYPE.WARNING);
            txt_email.setBackground(Color.RED);
            return false;
        }

        if (!Regex.isRegex(e.getEmail(), Regex.PATTERNS.EMAIL)) {
            message = new StringBuilder(e.getEmail()).append(" không đúng định dạng").toString();
            Message.alert(parent, message, title, Message.TYPE.WARNING);
            txt_email.setBackground(Color.YELLOW);
            return false;
        }

        // check name ....
        return true;
    }

    private boolean isConfirmEmail(String mailTo) {
        return isConfirmEmail(this, mailTo);
    }
}
