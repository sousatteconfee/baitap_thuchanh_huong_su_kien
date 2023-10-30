package shop.views.windows;

import com.github.sarxos.webcam.Webcam;
import java.sql.SQLException;
import shop.services.sql.DAOModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import shop.configuration.AuthAccess;
import shop.configuration.security;
import shop.controls.ExportOrder;
import shop.controls.WebcamControl;
import shop.models.entities.*;
import shop.services.sql.EnumDetail;
import shop.services.staticControl.FilterUser;
import shop.services.staticControl.Message;
import shop.services.staticControl.util;
import shop.utils.Format;
import shop.views.components.pnl_content;

public class dlg_orderScanner extends javax.swing.JDialog {

    public dlg_orderScanner(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.export = new ExportOrder();
        this.cam = new WebcamControl(cbx_camera, pnl_scanner, txt_scanner) {
            @Override
            public void handleCode() {
                getHandleCode();
            }
        }; // betweent initComponents(); and init();
        this.init();
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_scanner = new javax.swing.JPanel();
        txt_scanner = new javax.swing.JTextField();
        pnl_status = new javax.swing.JPanel();
        lbl_status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_qty = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        cbx_camera = new javax.swing.JComboBox<>();
        scr_contents = new javax.swing.JScrollPane();
        lyp_contents = new javax.swing.JLayeredPane();
        btn_exportExcel = new javax.swing.JButton();
        btn_reportJasper = new javax.swing.JButton();
        cbx_user = new javax.swing.JComboBox<>();
        txt_searchUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TẠO HÓA ĐƠN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_scanner.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(255, 102, 0)), "code scanner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        pnl_scanner.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnl_scannerLayout = new javax.swing.GroupLayout(pnl_scanner);
        pnl_scanner.setLayout(pnl_scannerLayout);
        pnl_scannerLayout.setHorizontalGroup(
            pnl_scannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        pnl_scannerLayout.setVerticalGroup(
            pnl_scannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        txt_scanner.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_scanner.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_scanner.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "code scanner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N

        pnl_status.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_status.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbl_status.setText("status");
        lbl_status.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setText("Số lượng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setText("Tổng sản phẩm");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setText("Thành tiền");

        lbl_qty.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_qty.setForeground(new java.awt.Color(51, 204, 0));
        lbl_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qty.setText("0.0");
        lbl_qty.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_quantity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(51, 204, 0));
        lbl_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_quantity.setText("0.0");
        lbl_quantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_total.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(51, 204, 0));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.0");
        lbl_total.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnl_statusLayout = new javax.swing.GroupLayout(pnl_status);
        pnl_status.setLayout(pnl_statusLayout);
        pnl_statusLayout.setHorizontalGroup(
            pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statusLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbl_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_statusLayout.setVerticalGroup(
            pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statusLayout.createSequentialGroup()
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnl_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, lbl_total});

        cbx_camera.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbx_camera.setForeground(new java.awt.Color(255, 102, 0));
        cbx_camera.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "Thiết bị quét", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N

        scr_contents.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lyp_contents.setLayout(new java.awt.GridLayout(0, 1, 3, 3));
        scr_contents.setViewportView(lyp_contents);

        btn_exportExcel.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportExcel.setText("Lưu excel");
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        btn_reportJasper.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_reportJasper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-report.png"))); // NOI18N
        btn_reportJasper.setText("Hóa đơn");
        btn_reportJasper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportJasperActionPerformed(evt);
            }
        });

        cbx_user.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbx_user.setForeground(new java.awt.Color(255, 102, 0));
        cbx_user.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "Khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        cbx_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_userActionPerformed(evt);
            }
        });

        txt_searchUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_searchUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_searchUser.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        txt_searchUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchUserKeyPressed(evt);
            }
        });

        txt_note.setColumns(20);
        txt_note.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txt_note.setLineWrap(true);
        txt_note.setRows(3);
        txt_note.setTabSize(6);
        txt_note.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        jScrollPane1.setViewportView(txt_note);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_scanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbx_camera, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_user, javax.swing.GroupLayout.Alignment.LEADING, 0, 223, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_scanner, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_exportExcel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_reportJasper, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(scr_contents, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbx_camera, cbx_user, txt_scanner, txt_searchUser});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_exportExcel, btn_reportJasper});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_camera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_scanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_user, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_exportExcel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_reportJasper))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnl_scanner, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_contents, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbx_camera, cbx_user, txt_scanner, txt_searchUser});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_exportExcel, btn_reportJasper});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.cam.clean();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btn_reportJasperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportJasperActionPerformed
        if (Message.confirm(this,
                String.format("Lưu hóa đơn gồm %s sản phẩm", list.size()),
                "Lưu hóa danh sách hóa đơn",
                Message.CF_TYPE.YES_OR_CANCEL) == 0)
            this.jasperReport();
    }//GEN-LAST:event_btn_reportJasperActionPerformed

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        if (Message.confirm(this,
                String.format("Lưu hóa đơn gồm %d sản phẩm", list.size()),
                "Lưu danh sách hóa đơn",
                Message.CF_TYPE.YES_OR_CANCEL) == 0)
        try {
            Product[] ps = new Product[list.size()];
            for (int i = 0; i < ps.length; i++) {
                ps[i] = list.get(i).getP();
            }
            DefaultTableModel model = (DefaultTableModel) Product.table(Arrays.asList(ps)).getModel();
            util.exportExcel(model);
        } catch (Exception ex) {
            Logger.getLogger(dlg_orderScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed

    private void cbx_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_userActionPerformed
        if (evt.getModifiers() > 0) {
            User u = (User) this.cbx_user.getSelectedItem();
            list.forEach(e -> e.getP().setU_id(u.getUsername()));
        }
    }//GEN-LAST:event_cbx_userActionPerformed

    private void txt_searchUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchUserKeyPressed
        if (evt.getKeyCode() == 10) {
            this.setCbxUser(FilterUser.containsName(txt_searchUser.getText(), 1, roles));
        }
    }//GEN-LAST:event_txt_searchUserKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exportExcel;
    private javax.swing.JButton btn_reportJasper;
    private javax.swing.JComboBox<Webcam> cbx_camera;
    private javax.swing.JComboBox<User> cbx_user;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_qty;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLayeredPane lyp_contents;
    private javax.swing.JPanel pnl_scanner;
    private javax.swing.JPanel pnl_status;
    private javax.swing.JScrollPane scr_contents;
    private javax.swing.JTextArea txt_note;
    private javax.swing.JTextField txt_scanner;
    private javax.swing.JTextField txt_searchUser;
    // End of variables declaration//GEN-END:variables
    private final AuthAccess.ROLE[] roles = {AuthAccess.ROLE.BUYER};
    private final List<pnl_content> list = new LinkedList<>();
    private final WebcamControl cam;
    private final ExportOrder export;

    private void init() {
        for (Webcam webcam : Webcam.getWebcams()) {
            this.cbx_camera.addItem(webcam);
        }
        this.setCbxUser(FilterUser.listAccess(roles));
        this.cam.cameraTimer.start(); // action scanner
    }

    private void getHandleCode() {
        String code = this.txt_scanner.getText();
        int active;
        long prid = 0;
        Product p;

        if (code == null) {
            return;
        }

        try {
            prid = Long.parseLong(code);
        } catch (NumberFormatException e) {
        }

        if ((p = DAOModel.PRODUCT.getById(prid)) != null) {
            java.awt.Toolkit.getDefaultToolkit().beep(); // sound beep
            if ((active = p.getActive()) > 0) {
                this.appenContent(p);
            } else if (active < 0) {
                Message.alert(this,
                        String.format("Sản phẩm %s bị khóa!", p),
                        "SẢN PHẨM KHÔNG MỞ BÁN", Message.TYPE.WARNING);
            } else {
                Message.alert(this,
                        String.format("Sản phẩm %s không mở bán!", p),
                        "SẢN PHẨM ĐÃ ĐÓNG", Message.TYPE.WARNING);
            }
        }

        this.lbl_status.setText(code);
    }

    private void setCbxUser(List<User> users) {
        this.cbx_user.removeAllItems();
        User u = new User();
        u.setName("Khách mua hàng");

        this.cbx_user.addItem(u);
        for (User user : users) {
            this.cbx_user.addItem(user);
        }
    }

    private void appenContent(Product p) {
        int index = this.getIndex(p.getPrid());
        if (index < 0) { // the fisrt product append
            p.setQuantity(1); // default quantity equal 1  
            list.add(new pnl_content(this, p));
            this.reverseContents();
        } else { // next product append then update quantity
            int quantity = p.getQuantity() + 1;
            p.setQuantity(quantity); // in map
            list.get(index).setQty(quantity);
        }
    }

    private void reverseContents() {
        Collections.reverse(list);
        this.lyp_contents.removeAll(); // remove all in lyp_contents
        list.forEach(e -> this.lyp_contents.add(e)); // add all items
    }

    public void calculator() {
        int quantity = 0, qty;
        double sum = 0D;
        Product p;

        // calculator amount price, quantity, size data
        for (pnl_content pc : list) {
            p = pc.getP();
            qty = p.getQuantity();
            quantity += qty;
            sum += qty * p.getPrice();
        }

        this.lbl_qty.setText(String.valueOf(list.size()));
        this.lbl_quantity.setText(String.valueOf(quantity));
        this.lbl_total.setText(Format.number(null, sum));
    }

    // remove content in lyp_contens
    public void removeContent(long prid) {
        int index = this.getIndex(prid);
        if (index < 0) {
            return;
        }

        pnl_content comp = list.get(index);
        this.lyp_contents.remove(comp);
        this.lyp_contents.validate(); // validate for set size of lyp_contents
        this.lyp_contents.repaint(); // repain to show content
        this.list.remove(index); // remove in storage
        this.calculator();
    }

    // get index of pnl_content return -1 if doesn't exist
    private int getIndex(long prid) {
        int size = list.size();
        pnl_content pc;
        long key;

        for (int i = 0; i < size; i++) {
            pc = list.get(i);
            key = pc.getP().getPrid();
            if (key == prid) {
                return i;
            }
        }

        return -1;
    }

    private void jasperReport() {
        Order o = this.getOrder();
        try {
            this.export.detail(DAOModel.ORDER.insert(o));
        } catch (SQLException ex) {
            Message.alert(this, ex.getMessage(), "failed to save order!", Message.TYPE.ERROR);
        }
    }

    private Order getOrder() {
        int size = list.size();
        String note = txt_note.getText();
        String staff_id = security.getUid();
        String buyer_id = ((User) cbx_user.getSelectedItem()).getKey();
        Order o = new Order();
        Product p;

        User buyer = DAOModel.USER.getById(buyer_id);
        User staff = DAOModel.USER.getById(staff_id);
        if (buyer == null) {
            buyer = new User();
            buyer.setName("Khách hàng");
        }

        // default note
        if (note == null || note.isEmpty()) {
            note = new StringBuilder()
                    .append(buyer.getName())
                    .append(" mua hàng bởi ")
                    .append(staff.getName())
                    .append(" đã bán: ")
                    .append(Format.DATE.format(System.currentTimeMillis()))
                    .toString();
        }

        o.setOrid(-1);
        o.setNote(note);
        o.setStaff_id(staff_id);
        o.setBuyer_id(buyer_id);
        for (int i = 0; i < size; i++) {
            p = list.get(i).getP();
            o.details.add(new EnumDetail.Detail(
                    p.getQuantity(),
                    p.getPrice(),
                    p.getPrid(),
                    o.getKey())
            );
        }
        return o;
    }
}
