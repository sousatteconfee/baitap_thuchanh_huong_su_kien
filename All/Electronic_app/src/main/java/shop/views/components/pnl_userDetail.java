package shop.views.components;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import lombok.Setter;
import shop.configuration.Config;
import shop.configuration.env;
import shop.controls.FileControl;
import shop.models.entities.*;
import shop.services.sql.DAOModel;
import shop.services.sql.EnumRole;
import shop.services.staticControl.DetailControl;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.Lib;
import shop.services.staticControl.Message;
import shop.services.staticControl.View;
import shop.services.staticControl.ViewControl;
import shop.views.windows.dlg_detailUser;
import shop.views.windows.frame_ViewControl;

public class pnl_userDetail extends javax.swing.JPanel implements DetailControl<User> {

    public pnl_userDetail() {
        initComponents();
        this.init();
        Map data = DAOModel.PRODUCT.getMap();
        C_PRODUCTS = new ArrayList<>(data.values());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdo_activeGroup = new javax.swing.ButtonGroup();
        lbl_subject = new javax.swing.JLabel();
        pnl_img = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        btn_export_excel = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        pnl_info = new javax.swing.JPanel();
        lbl_textfield = new javax.swing.JLabel();
        lbl_textfield1 = new javax.swing.JLabel();
        lbl_textfield2 = new javax.swing.JLabel();
        lbl_textfield3 = new javax.swing.JLabel();
        lbl_textfield4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_email = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        dcs_regTime = new com.toedter.calendar.JDateChooser();
        pnl_role = new javax.swing.JPanel();
        scr_products = new javax.swing.JScrollPane();
        lbl_textfield5 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        rdo_active = new javax.swing.JRadioButton();
        cbx_active = new javax.swing.JCheckBox();
        cbx_active1 = new javax.swing.JCheckBox();
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

        lbl_subject.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_subject.setForeground(new java.awt.Color(255, 153, 51));
        lbl_subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_subject.setText("user's subject");
        lbl_subject.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        add(lbl_subject, java.awt.BorderLayout.PAGE_START);

        lbl_image.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_image.setForeground(new java.awt.Color(255, 153, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        lbl_image.setText("default.png");
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
            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(btn_export_excel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_imgLayout.setVerticalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_imgLayout.createSequentialGroup()
                .addComponent(btn_export_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear)
                .addContainerGap())
        );

        add(pnl_img, java.awt.BorderLayout.LINE_START);

        lbl_textfield.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield.setText("Tên đăng nhập");
        lbl_textfield.setToolTipText("");
        lbl_textfield.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield.setVerifyInputWhenFocusTarget(false);

        lbl_textfield1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield1.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield1.setText("password");
        lbl_textfield1.setToolTipText("password chỉ có thêm tạo mới, không được cập nhật");
        lbl_textfield1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield1.setVerifyInputWhenFocusTarget(false);

        lbl_textfield2.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield2.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield2.setText("Thời gian tạo");
        lbl_textfield2.setToolTipText("");
        lbl_textfield2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield2.setVerifyInputWhenFocusTarget(false);

        lbl_textfield3.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield3.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield3.setText("email");
        lbl_textfield3.setToolTipText("");
        lbl_textfield3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield3.setVerifyInputWhenFocusTarget(false);

        lbl_textfield4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield4.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield4.setText("họ và tên");
        lbl_textfield4.setToolTipText("");
        lbl_textfield4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield4.setVerifyInputWhenFocusTarget(false);

        txt_username.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_name.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        dcs_regTime.setDateFormatString("EEEE, dd-MM-yyyy hh:mm:ss");
        dcs_regTime.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N

        pnl_role.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "roles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        pnl_role.setLayout(new java.awt.GridLayout(0, 3));

        scr_products.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List product of user", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 24), new java.awt.Color(255, 153, 51))); // NOI18N

        lbl_textfield5.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_textfield5.setForeground(new java.awt.Color(255, 153, 51));
        lbl_textfield5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_textfield5.setText("số sản phẩm");
        lbl_textfield5.setToolTipText("");
        lbl_textfield5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_textfield5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_textfield5.setVerifyInputWhenFocusTarget(false);

        lbl_quantity.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 51, 0));
        lbl_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_quantity.setText("0");
        lbl_quantity.setToolTipText("");
        lbl_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 153, 51)));
        lbl_quantity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_quantity.setVerifyInputWhenFocusTarget(false);

        rdo_activeGroup.add(rdo_active);
        rdo_active.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rdo_active.setForeground(new java.awt.Color(255, 0, 0));
        rdo_active.setText("Khóa");

        rdo_activeGroup.add(cbx_active);
        cbx_active.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbx_active.setSelected(true);
        cbx_active.setText("hoạt động");

        rdo_activeGroup.add(cbx_active1);
        cbx_active1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbx_active1.setText("không hoạt động");

        javax.swing.GroupLayout pnl_infoLayout = new javax.swing.GroupLayout(pnl_info);
        pnl_info.setLayout(pnl_infoLayout);
        pnl_infoLayout.setHorizontalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scr_products)
                    .addGroup(pnl_infoLayout.createSequentialGroup()
                        .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbl_textfield4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_textfield3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_textfield2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(lbl_textfield1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(pnl_infoLayout.createSequentialGroup()
                                .addComponent(rdo_active)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_active))
                            .addComponent(cbx_active1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username)
                            .addComponent(pnl_role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email)
                            .addComponent(txt_password)
                            .addComponent(txt_name)
                            .addGroup(pnl_infoLayout.createSequentialGroup()
                                .addComponent(dcs_regTime, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_textfield5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addGap(0, 0, 0))
        );
        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_textfield1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_textfield3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_role, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_infoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdo_active)
                            .addComponent(cbx_active))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_active1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_textfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcs_regTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_textfield5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_products, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
        );

        pnl_infoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dcs_regTime, lbl_quantity, lbl_textfield, lbl_textfield1, lbl_textfield2, lbl_textfield3, lbl_textfield4, lbl_textfield5, txt_email, txt_name, txt_password, txt_username});

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

        btn_update.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 204, 51));
        btn_update.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loop-arrow.png"))); // NOI18N
        btn_update.setText("Cập nhật");
        btn_update.setToolTipText("password sẽ không được update");
        btn_update.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
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
        User e = this.getFormData();
        String key = e.getUsername();
        if (key != null && !key.isEmpty()) {
            List products = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.USER, key);
            root.getExportControl().jaspertReportDetail(e, products);
        }
    }//GEN-LAST:event_btn_export_excelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.setDetail(new User("your username"));
        this.fileControl.clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        if (evt.getKeyCode() == 10) {
            String id = txt_username.getText();
            User u = DAOModel.USER.getById(id);
            if (u != null) {
                this.setDetail(u);
            } else {
                lbl_subject.setText("Không tìm thấy " + id);
            }
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

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
    private javax.swing.JCheckBox cbx_active;
    private javax.swing.JCheckBox cbx_active1;
    private com.toedter.calendar.JDateChooser dcs_regTime;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_subject;
    private javax.swing.JLabel lbl_textfield;
    private javax.swing.JLabel lbl_textfield1;
    private javax.swing.JLabel lbl_textfield2;
    private javax.swing.JLabel lbl_textfield3;
    private javax.swing.JLabel lbl_textfield4;
    private javax.swing.JLabel lbl_textfield5;
    private javax.swing.JPanel pnl_control;
    private javax.swing.JPanel pnl_img;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_role;
    private javax.swing.JRadioButton rdo_active;
    private javax.swing.ButtonGroup rdo_activeGroup;
    private javax.swing.JScrollPane scr_products;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
    private static final Config.folder FOLDER = Config.folder.account;
    private static final String DEFAULT_IMG = env.DEFAULT_IMG;
    private final List<Product> C_PRODUCTS;
    private FileControl fileControl;
    private String dataImg = null;

    @Setter
    private frame_ViewControl root;

    private void init() {
        this.fileControl = new FileControl(lbl_image, FOLDER, DEFAULT_IMG);

        // fill all roles;
        EnumRole.getRoles().forEach(string -> {
            pnl_role.add(new JCheckBox(string));
        });
    }

    private void fillProducts() {
        int size;
        String key = txt_username.getText();

        if (key != null && !key.isEmpty()) {
            List data = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.USER, key);
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
            String key = txt_username.getText();
            User e = this.getFormData();

            switch (type) {
                case READ:
                    root.crud(type, key);
                    break;
                case INSERT:
                    if (checkForm(e) && root.crud(type, e)) {
                        fileControl.save();
                    }
                    break;
                case UPDATE: // avoid update password
                    if (Message.confirm(
                            this,
                            "Cập nhập người dùng: " + e.toString(),
                            "UPDATE USER AVOID PASSWORD",
                            Message.CF_TYPE.YES_NO
                    ) == 0) {
                        if (checkForm(e)
                                && DAOModel.USER.updateLessPass(e) != null) {
                            dataImg = fileControl.update(dataImg) ? e.getImage() : null;
                            root.mes(e, type, true);
                            root.updateRow(e);
                            root.navigator(frame_ViewControl.N_TYPE.DEFAULT);
                        } else {
                            root.mes(e, type, false);
                        }
                    }
                    break;
                case DELETE: // get old image'name before delete data
                    String fileName = lbl_image.getText();
                    if (root.crud(type, key)) {
                        fileControl.delete(fileName);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (IllegalArgumentException | SQLException ex) {
            String mes = ex.getMessage();
            Message.alert(this, mes, mes, Message.TYPE.ERROR);
        }
    }

    @Override
    public void setDetail(User e) {
        if (e == null) {
            e = new User("your-username");
        }
        // get all roles of entity
        String[] roles = e.getAuths().toArray(new String[1]);
        int active = e.getActive();

        // SET ALL INFO
        if (active < 0) {
            rdo_active.setSelected(true);
        } else if (active == 1) {
            cbx_active.setSelected(true);
        } else {
            cbx_active1.setSelected(true);
        }

        this.txt_username.setText(e.getUsername());
        this.txt_email.setText(e.getEmail());
        this.txt_name.setText(e.getName());
        this.txt_password.setText(null);
        this.setSelectedRoles(roles);

        // OTHER INFO
        this.dcs_regTime.setDate(e.getRegTime());
        this.showImage(e.getImage());
        this.lbl_subject.setText(e.toString2());
        this.txt_password.setToolTipText(e.getPassword());
        this.fillProducts(); // fill list product of account's username
    }

    @Override
    public void showDialogDetail(User u) {
        String key = u.getUsername();
        if (key != null && !key.isEmpty()) {
            List products = FilterProduct.getR_BY(C_PRODUCTS, FilterProduct.R_BY.USER, key);
            new dlg_detailUser(ViewControl.ROOT_APP, true, u, products).setVisible(true);
        } else {
            System.out.println(">>> key : " + key);
        }
    }

    private void setSelectedRoles(String... roles) {
        Component[] checkRoles = this.pnl_role.getComponents();
        int i = 0, size = roles.length;
        boolean isCheck;
        if (size < 1) { // clear all if roles input empty
            for (Component cCheck : checkRoles) {
                if (cCheck instanceof JCheckBox) {
                    ((JCheckBox) cCheck).setSelected(false);
                }
            }
        } else { // selected role
            for (Component cCheck : checkRoles) {
                if (cCheck instanceof JCheckBox) {
                    JCheckBox check = (JCheckBox) cCheck;
                    do {// for an checkbox
                        isCheck = check.getText().equals(roles[i]);
                        check.setSelected(isCheck);
                        if (isCheck) {
                            break;
                        }
                    } while (++i < size);
                    i = 0;
                }
            }
        }
    }

    private String[] getSelectedRoles() {
        Component[] checkRoles = this.pnl_role.getComponents();
        ArrayList<String> list = new ArrayList<>(checkRoles.length);
        for (Component cCheck : checkRoles) {
            if (cCheck instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) cCheck;
                if (check.isSelected()) {
                    list.add(check.getText());
                }
            }
        }

        return list.toArray(new String[0]);
    }

    private User getFormData() {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String name = txt_name.getText();
        String email = txt_email.getText();
        int active = rdo_active.isSelected() ? -1 : cbx_active.isSelected() ? 1 : 0;
        Date regTime = dcs_regTime.getDate();
        String image = lbl_image.getText();
        String[] roles = this.getSelectedRoles();

        return new User(username, password, email, name, active, image, regTime, roles);
    }

    private boolean checkForm(User e) {

        return true;
    }

    private void showImage(String fileName) {
        dataImg = fileName;
        String pathImg = Lib.getFile(FOLDER, fileName, DEFAULT_IMG).toString();
        View.setImage(lbl_image, pathImg, 150, 150);
        this.lbl_image.setText(dataImg == null || dataImg.isEmpty() ? DEFAULT_IMG : dataImg);
    }
}
