package shop.views.windows;

import shop.models.entities.User;
import shop.services.sql.DAOModel;
import shop.services.staticControl.ConfirmDialog;
import shop.services.staticControl.FilterUser;
import shop.services.staticControl.Message;
import shop.services.staticControl.Regex;
import shop.services.staticControl.ViewControl;

public class dlg_security_forgotPass extends javax.swing.JDialog implements ConfirmDialog {

    public dlg_security_forgotPass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_forgot = new javax.swing.JButton();
        lbl_forForgotPass = new javax.swing.JLabel();
        lbl_textfield4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quên mật khẩu");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lbl_heading.setForeground(new java.awt.Color(255, 153, 51));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("QUÊN MẬT KHẨU");
        lbl_heading.setFocusable(false);
        lbl_heading.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N

        btn_reset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loading.png"))); // NOI18N
        btn_reset.setText("Làm mới");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_forgot.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_forgot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/forgot.png"))); // NOI18N
        btn_forgot.setText("Xác nhận");
        btn_forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forgotActionPerformed(evt);
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

        lbl_textfield4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield4.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield4.setText("email");
        lbl_textfield4.setToolTipText("");
        lbl_textfield4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield4.setVerifyInputWhenFocusTarget(false);

        txt_email.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setToolTipText("enter để tìm tên đăng nhập bằng email");
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });

        lbl_username.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_username.setForeground(new java.awt.Color(255, 153, 51));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setText("tên tài khoản tìm bằng email");
        lbl_username.setToolTipText("");
        lbl_username.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_username.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_username.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addComponent(lbl_forForgotPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_forgot))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_textfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset)
                    .addComponent(btn_forgot)
                    .addComponent(lbl_forForgotPass))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        lbl_username.setText("Tên tài khoản tìm bằng email");
        txt_email.setText(null);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forgotActionPerformed
        this.forgotPass();
    }//GEN-LAST:event_btn_forgotActionPerformed

    private void lbl_forForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forForgotPassMouseClicked
        this.dispose();
        ViewControl.S_LOGIN.setVisible(true);
    }//GEN-LAST:event_lbl_forForgotPassMouseClicked

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        if (evt.getKeyCode() == 10) {
            User u = FilterUser.getByUid_Email(txt_email.getText());
            lbl_username.setText(u == null ? "Không tìm thấy tài khoản!"
                    : u.getUsername() + " : " + u.getEmail());
        }
    }//GEN-LAST:event_txt_emailKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == 10) {
            this.forgotPass();
        }
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_forgot;
    private javax.swing.JButton btn_reset;
    private javax.swing.JLabel lbl_forForgotPass;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_textfield4;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables

    private void forgotPass() {
        String title = "NHẬP MẬT KHẨU";
        Message.TYPE none = Message.TYPE.NONE, warn = Message.TYPE.WARNING;
        String password, confirmPass, email = this.txt_email.getText();
        User u = FilterUser.getByUid_Email(email);
        
        if(u == null) {
            Message.alert(this, email+" chưa được đăng ký!","EMALI KHÔNG TỒN TẠI!",warn);
            return;
        } else email = u.getEmail();
        
        do { // confirm password
            do password = Message.prompt(this, "Mật khẩu mới: ", title, none);
            while (!checkPass(password));

            do confirmPass = Message.prompt(this, "Xác nhận mật khẩu: ", title, none);
            while (!checkPass(confirmPass));

            if(password==null || confirmPass==null) continue;
            if (confirmPass.equals(password)) break;
            else Message.alert(this, "Mật khẩu nhập lại không đúng!", title, warn);
        } while (true);

        if (isConfirmEmail(email) && (u = DAOModel.USER.updatePass(email, password)) != null) {
            Message.alert(this, new StringBuilder("Thay đổi mật khẩu ")
                    .append(u.getUsername()).append(':').append(u.getEmail())
                    .append(" thành công.").toString(),
                    "THAY ĐỔI MẬT KHẨU: "+u.getUsername(),Message.TYPE.INFO
            );
            this.btn_resetActionPerformed(null);
            this.dispose();
        } else Message.alert(this, "code chưa được xác nhận!","XÁC NHẬN BẢO MẬT!", warn);
    }

    private boolean isConfirmEmail(String mailTo) {
        return isConfirmEmail(this, mailTo);
    }

    private boolean checkPass(String pass) {
        return Regex.isRegex(pass, Regex.PATTERNS.PASSWORD);
    }
}
