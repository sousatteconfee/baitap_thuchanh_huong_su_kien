package shop.views.windows;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import shop.configuration.AuthAccess;
import shop.configuration.security;

public class dlg_orderRoleChooser extends javax.swing.JDialog {

    public dlg_orderRoleChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        pnl_control = new javax.swing.JPanel();
        btn_admin = new javax.swing.JButton();
        btn_staff = new javax.swing.JButton();
        btn_buyer = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xem hóa đơn");
        setUndecorated(true);

        jLabel23.setForeground(new java.awt.Color(255, 153, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("XEM HÓA ĐƠN THEO");
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        pnl_control.setLayout(new java.awt.GridLayout(0, 3, 3, 3));

        btn_admin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_admin.setForeground(new java.awt.Color(0, 204, 204));
        btn_admin.setText("QUẢN TRỊ");
        pnl_control.add(btn_admin);

        btn_staff.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_staff.setForeground(new java.awt.Color(0, 204, 204));
        btn_staff.setText("NHÂN VIÊN");
        pnl_control.add(btn_staff);

        btn_buyer.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_buyer.setForeground(new java.awt.Color(0, 204, 204));
        btn_buyer.setText("KHÁCH HÀNG");
        pnl_control.add(btn_buyer);

        btn_close.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 0, 51));
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power.png"))); // NOI18N
        btn_close.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_control, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_close))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pnl_control, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_admin;
    private javax.swing.JButton btn_buyer;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_staff;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel pnl_control;
    // End of variables declaration//GEN-END:variables
    public AuthAccess.ROLE role;

    private void init() {
        this.setEnabledButtons();
        this.setRole(btn_admin, AuthAccess.ROLE.ADMIN);
        this.setRole(btn_buyer, AuthAccess.ROLE.BUYER);
        this.setRole(btn_staff, AuthAccess.ROLE.STAFF);
    }

    @Override
    public void setVisible(boolean b) {
        this.setEnabledButtons();
        super.setVisible(b);
    }

    private void setEnabledButtons() {
        btn_admin.setEnabled(security.hasAnyRoles(AuthAccess.ROLE.ADMIN));
        btn_buyer.setEnabled(security.hasAnyRoles(AuthAccess.ROLE.BUYER));
        btn_staff.setEnabled(security.hasAnyRoles(AuthAccess.ROLE.STAFF));
    }

    private void setRole(JButton btn, AuthAccess.ROLE role) {
        btn.addActionListener((ActionEvent e) -> {
            this.role = role;
            this.dispose();
        });
    }
}
