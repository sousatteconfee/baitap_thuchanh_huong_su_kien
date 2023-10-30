package shop.views.windows;

import java.sql.SQLException;

import shop.configuration.security;
import shop.services.staticControl.Message;
import shop.services.staticControl.ViewControl;
import shop.views.App;

public class dlg_security_login extends javax.swing.JDialog {

    public dlg_security_login(App parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_uid = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_clear = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lbl_forForgotPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐĂNG NHẬP TÀI KHOẢN");

        lbl_heading.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(255, 153, 51));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("ĐĂNG NHẬP TÀI KHOẢN");
        lbl_heading.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Mật khẩu");

        txt_uid.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_uid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });

        txt_pass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_clear.setText("clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login.png"))); // NOI18N
        btn_login.setText("Đăng nhập");
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
        lbl_forForgotPass.setText("quên mật khẩu");
        lbl_forForgotPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 0)));
        lbl_forForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_forForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_forForgotPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_uid))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_pass))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(lbl_forForgotPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_register)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_login)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_uid, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_login)
                        .addComponent(btn_register))
                    .addComponent(lbl_forForgotPass, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        this.login();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        this.dispose();
        ViewControl.S_REGISTER.setVisible(true);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void lbl_forForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forForgotPassMouseClicked
        this.dispose();
        ViewControl.S_FORGOT_PASS.setVisible(true);
    }//GEN-LAST:event_lbl_forForgotPassMouseClicked

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        if (evt.getKeyCode() == 10) { // 10 is enter
            this.login();
        }
    }//GEN-LAST:event_txt_passKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btn_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_forForgotPass;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_uid;
    // End of variables declaration//GEN-END:variables

    private void login() {
        try {
            String uid = txt_uid.getText();
            String pass = String.valueOf(txt_pass.getPassword());

            if (security.login(uid, pass) != null) {
                ((App) this.getParent()).loadControlDisplay();
                Message.alert(this,
                        uid + " đã đăng nhập hệ thống.",
                        "ĐĂNG NHẬP THÀNH CÔNG",
                        Message.TYPE.INFO
                );
                this.dispose();
            }
        } catch (SQLException e) {
            if (Message.confirm(this,
                    e.getMessage() + "\nĐăng nhập lại?",
                    "ĐĂNG NHẬP THẤT BẠI",
                    Message.CF_TYPE.YES_NO
            ) != 0) {
                this.dispose();
            }
        }
    }

    public void clearForm() {
        this.txt_uid.setText(null);
        this.txt_pass.setText(null);
    }
}
