package shop.views.windows;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.Getter;
import shop.configuration.env;
import shop.controls.event.TableIndexControl;
import shop.services.sql.AbstractDAO;
import shop.services.staticControl.DetailControl;
import shop.services.staticControl.EntityControl;
import shop.services.staticControl.ExportControl;
import shop.services.staticControl.Message;
import shop.services.staticControl.View;
import shop.views.App;

/**
 * @see shop.models.entities.Category
 * @see shop.models.entities.Product
 * @see shop.models.entities.User
 *
 * @param <K> type key of entry
 * @param <E> type value of entry
 */
public class frame_ViewControl<K, E> extends javax.swing.JFrame {

    public frame_ViewControl(App parent, AbstractDAO dao,
            JPanel statistic, JTable table, JPanel detail, ExportControl exportControl) {
        initComponents();

        this.parent = parent;
        this.dao = dao;
        this.pnl_detail = detail;
        this.pnl_statistic = statistic;
        this.exportControl = exportControl;
        this.tbl_model = (DefaultTableModel) table.getModel();
        this.tbl_list = table;
        this.tmc = new TableIndexControl(table);

        this.onLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpn_control = new javax.swing.JTabbedPane();
        lyp_statistic = new javax.swing.JLayeredPane();
        spl_list = new javax.swing.JSplitPane();
        pnl_listControl = new javax.swing.JPanel();
        btn_export_excel = new javax.swing.JButton();
        btn_export_excel1 = new javax.swing.JButton();
        scr_control = new javax.swing.JScrollPane();
        lyp_detail = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý dữ liệu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout lyp_statisticLayout = new javax.swing.GroupLayout(lyp_statistic);
        lyp_statistic.setLayout(lyp_statisticLayout);
        lyp_statisticLayout.setHorizontalGroup(
            lyp_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        lyp_statisticLayout.setVerticalGroup(
            lyp_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        tpn_control.addTab("Thống kê dữ liệu", lyp_statistic);

        spl_list.setDividerLocation(160);
        spl_list.setDividerSize(3);

        btn_export_excel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_export_excel.setForeground(new java.awt.Color(0, 204, 0));
        btn_export_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_export_excel.setText("EXPORT");
        btn_export_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_excelActionPerformed(evt);
            }
        });

        btn_export_excel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_export_excel1.setForeground(new java.awt.Color(0, 153, 255));
        btn_export_excel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-report.png"))); // NOI18N
        btn_export_excel1.setText("Report");
        btn_export_excel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_excel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_listControlLayout = new javax.swing.GroupLayout(pnl_listControl);
        pnl_listControl.setLayout(pnl_listControlLayout);
        pnl_listControlLayout.setHorizontalGroup(
            pnl_listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_export_excel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(btn_export_excel1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_listControlLayout.setVerticalGroup(
            pnl_listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_export_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_export_excel1)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        spl_list.setLeftComponent(pnl_listControl);
        spl_list.setRightComponent(scr_control);

        tpn_control.addTab("Danh sách dữ liệu", spl_list);

        javax.swing.GroupLayout lyp_detailLayout = new javax.swing.GroupLayout(lyp_detail);
        lyp_detail.setLayout(lyp_detailLayout);
        lyp_detailLayout.setHorizontalGroup(
            lyp_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        lyp_detailLayout.setVerticalGroup(
            lyp_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        tpn_control.addTab("Chi tiết dữ liệu", lyp_detail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpn_control)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpn_control)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.parent.reload(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_export_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_excelActionPerformed
        this.exportControl.excelExportList(tbl_model);
    }//GEN-LAST:event_btn_export_excelActionPerformed

    private void btn_export_excel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_excel1ActionPerformed
        this.exportControl.jasperReportList(tbl_model);
    }//GEN-LAST:event_btn_export_excel1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export_excel;
    private javax.swing.JButton btn_export_excel1;
    private javax.swing.JLayeredPane lyp_detail;
    private javax.swing.JLayeredPane lyp_statistic;
    private javax.swing.JPanel pnl_listControl;
    private javax.swing.JScrollPane scr_control;
    private javax.swing.JSplitPane spl_list;
    private javax.swing.JTabbedPane tpn_control;
    // End of variables declaration//GEN-END:variables

    // controls
    @Getter
    private final ExportControl<E> exportControl;
    private final static Font FONT = env.FONT;
    private DetailControl<E> detail_control;
    private final AbstractDAO<K, E> dao;
    private final App parent;

    // components
    @Getter
    private final JTable tbl_list;
    private final JPanel pnl_detail;
    private final JPanel pnl_statistic;
    private final DefaultTableModel tbl_model;
    private final TableIndexControl tmc;

    /**
     * navigation element
     */
    public enum N_TYPE {
        FIRST, PREV, NEXT, LAST, DEFAULT
    }

    /**
     * control type
     */
    public enum C_TYPE {
        READ, INSERT, UPDATE, DELETE
    }

    /**
     * @see N_TYPE#DEFAULT>#FIRST>#PREV>#NEXT>#LAST
     * @see dlg_ViewControl
     *
     * @param type is control type
     */
    public void navigator(N_TYPE type) {
        int max = tbl_list.getRowCount() - 1;
        Map<K, E> map = dao.getMap();

        if (!map.isEmpty()) {
            switch (type) {
                case FIRST:
                    this.tmc.rowSelector = 0;
                    break;
                case PREV:
                    this.tmc.rowSelector = tmc.rowSelector > 0
                            ? tmc.rowSelector - 1 : max;
                    break;
                case NEXT:
                    this.tmc.rowSelector = tmc.rowSelector < max
                            ? tmc.rowSelector + 1 : max;
                    break;
                case LAST:
                    this.tmc.rowSelector = max;
                    break;
            }
            E e = map.get(selection((K) tmc.getKeyOnTable(), false));
            detail_control.setDetail(e == null ? null : e);
        }
    }

    /**
     * @see C_TYPE
     * @see dlg_ViewControl
     *
     * @param type is control type
     * @param data type "K" or "E"
     *
     * @return TRUE if execute successfully and vice versa is FALSE
     * @throws java.sql.SQLException
     */
    public boolean crud(C_TYPE type, Object data) throws SQLException {
        // declare variables
        boolean isSuccess = false; // check execute success, default non-execute
        E entity; // entity of input data
        K key; // key of input data

        // prepare data to execute control, get key and object value
        if (data instanceof EntityControl) {
            key = ((EntityControl<K>) (entity = (E) data)).getKey();
        } else {
            entity = dao.getById(key = (K) data);
        }

        // confirm control execution
        if (Message.confirm(this,
                new StringBuilder(type.name()).append(' ').append(entity).toString(),
                new StringBuilder(type.name()).append(' ').append(key).toString(),
                Message.CF_TYPE.YES_NO) == 1) {
            return isSuccess;
        }

        // execute control follow the type
        switch (type) {
            case READ: // show dialogDetail data
                if (null != this.selection(key, true)) {
                    detail_control.showDialogDetail(entity);
                } else {
                    Message.alert(this, "data doesns't exits",
                            "Show detail data", Message.TYPE.WARNING);
                }
                break;
            case INSERT: // kor => key of result
                isSuccess = (entity = this.dao.insert(entity)) != null;
                if (isSuccess) { // show new data inserted
                    EntityControl<K> e = (EntityControl<K>) entity;
                    this.insertRow(e);
                }
                break;
            case UPDATE: // check data on table of user
                if (this.selection(key, false) == null) {
                    return mes(key, type);
                } else if (isSuccess = this.dao.update(entity) != null) {
                    this.updateRow((EntityControl<K>) entity);
                }
                break;
            case DELETE:
                if (this.selection(key, false) == null) {
                    return mes(key, type);
                } else if (isSuccess = this.dao.delete(key) > 0) {
                    if (tmc.rowSelector > tbl_list.getRowCount() - 2) {
                        --tmc.rowSelector;
                    }
                    this.deleteRow(key);
                    this.navigator(N_TYPE.DEFAULT);
                }
                break;
            default:
                throw new AssertionError();
        }

        // show message if not type READ
        if (C_TYPE.READ != type) {
            this.mes(entity, type, isSuccess);
        }
        return isSuccess;
    }

    // first load data
    private void onLoad() {

        // SHOW LIST
        this.scr_control.setViewportView(this.tbl_list);
        this.tbl_list.setFont(FONT);
        this.tbl_list.setRowHeight(30);
        this.tbl_list.setSelectionMode(0); // 0 is single selection
        this.tbl_list.setAutoCreateRowSorter(true);

        // SHOW SHOW JPANEL
        View.setComponent(lyp_detail, pnl_detail);
        View.setComponent(lyp_statistic, pnl_statistic);

        // ORTHER
        detail_control = (DetailControl<E>) pnl_detail;
        this.setIconImage(parent.getIconImage());
        this.setSize(this.parent.getSize());
        this.setLocationRelativeTo(this.parent);

        // EVENTS
        tbl_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    tmc.rowSelector = tbl_list.getSelectedRow();
                    tpn_control.setSelectedComponent(lyp_detail);
                    E entity = dao.getById(getKeyOnTable());
                    ((DetailControl) pnl_detail).setDetail(entity);
                }
            }
        });

    }

    // select id in the table
    private K selection(K id, boolean redirect) {
        int size = tbl_model.getRowCount();
        int column = this.tmc.columnOfKey;

        for (int i = 0; i < size; i++) {
            if (id.equals(tbl_model.getValueAt(i, column))) {
                if (redirect) {
                    this.tpn_control.setSelectedComponent(spl_list);
                }
                this.tbl_list.setRowSelectionInterval(i, i);
                return id;
            }
        }
        return null;
    }

    // "WARNING: EntityControl.setActive()"
    public void insertRow(EntityControl<K> data) {

        try {
            tbl_model.addRow(data.toArrayTable());
            throw new Exception();
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    // "WARNING: EntityControl.setActive()"
    public void updateRow(EntityControl<K> data) {
        int row = this.getIndexOfTable(data.getKey());
        int length = tbl_list.getColumnCount();
        if (row > -1) try {
            Object[] rowData = data.toArrayTable();
            for (int col = 0; col < length; col++) {
                tbl_list.setValueAt(rowData[col], row, col);
            }
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    // "WARNING: EntityControl.setActive()"
    public void deleteRow(K key) {
        int row = this.getIndexOfTable(key);
        if (row > -1) try {
            tbl_model.removeRow(row);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    // get key on table return null if does not exist
    private K getKeyOnTable() {
        final int row = tbl_list.getSelectedRow();
        return (K) tbl_list.getValueAt(row, this.tmc.columnOfKey);
    }

    // get index of key in tbl_list data
    private int getIndexOfTable(K key) {
        int size = tbl_list.getRowCount();
        int column = this.tmc.columnOfKey;

        for (int row = 0; row < size; row++) {
            if (key.equals(tbl_model.getValueAt(row, column))) {
                return row;
            }
        }
        return -1;
    }

    // show message dialog
    public void mes(E entity, C_TYPE type, boolean isSuccess) {
        if (entity == null) {
            return;
        }
        String titleMes = type + " " + entity.toString();
        Message.TYPE alertType;
        String message;

        if (isSuccess) {
            alertType = Message.TYPE.INFO;
            message = type + entity.toString() + " SUCCESSFULLY.";
        } else {
            alertType = Message.TYPE.WARNING;
            message = entity.toString() + " CANNOT " + type;
        }

        Message.alert(this, message, titleMes, alertType);
    }

    // show message and return false for UPDATE ADN DELETE ALREDY EXIST
    private boolean mes(K k, C_TYPE type) {
        String message = new StringBuilder("CHECK ID:").append(k).append(" doesn't exist").toString();
        String titleMes = new StringBuilder(type.name()).append(" : ").append(k).toString();
        Message.alert(this, message, titleMes, Message.TYPE.WARNING);
        return false;
    }

}
