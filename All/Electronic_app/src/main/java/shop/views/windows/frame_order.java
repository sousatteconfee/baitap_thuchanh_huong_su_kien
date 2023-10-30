package shop.views.windows;

import com.github.sarxos.webcam.Webcam;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import shop.configuration.env;
import shop.controls.ExportOrder;
import shop.controls.WebcamControl;
import shop.controls.event.TableIndexControl;
import shop.models.dao.OrderDAO;
import shop.models.entities.Order;
import shop.services.sql.DAOModel;
import shop.services.sql.EnumDetail;
import shop.services.staticControl.FilterOrder;
import shop.services.staticControl.Message;
import shop.services.staticControl.ViewControl;
import shop.services.staticControl.util;
import shop.utils.Format;
import shop.utils.SetHypertext;

public class frame_order extends javax.swing.JFrame {

    public frame_order(java.awt.Frame parent, boolean modal, List<Order> orders) {
        initComponents();
        this.setSize(parent.getSize());
        this.setLocationRelativeTo(parent);
        this.setIconImage(parent.getIconImage());
        this.orderTable = Order.table(this.orders = orders);
        this.tic = new TableIndexControl(orderTable);
        this.export = new ExportOrder();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbp = new javax.swing.JTabbedPane();
        pnl_statistic = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tbp_statistic = new javax.swing.JTabbedPane();
        lyp_sellChart = new javax.swing.JLayeredPane();
        lyp_enueChart = new javax.swing.JLayeredPane();
        pnl_sellFilter = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dcs_start = new com.toedter.calendar.JDateChooser();
        dcs_end = new com.toedter.calendar.JDateChooser();
        spn_sellQty = new com.toedter.components.JSpinField();
        btn_sellFilter = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_maxSum = new javax.swing.JLabel();
        lbl_maxQty = new javax.swing.JLabel();
        lbl_minSum = new javax.swing.JLabel();
        lbl_minQty = new javax.swing.JLabel();
        spn_page = new com.toedter.components.JSpinField();
        lyp_orders = new javax.swing.JLayeredPane();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        spn_orderSize = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spn_size1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        spn_quantity1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        spn_total1 = new javax.swing.JSpinner();
        lbl_qrCode = new javax.swing.JLabel();
        btn_exportOrders = new javax.swing.JButton();
        btn_toggleCamera = new javax.swing.JToggleButton();
        pnl_outWebcam = new javax.swing.JPanel();
        tbr_camera = new javax.swing.JToolBar();
        pnl_scanner = new javax.swing.JPanel();
        cbx_camera = new javax.swing.JComboBox<>();
        btn_reportJasper1 = new javax.swing.JButton();
        scr_listOrder = new javax.swing.JScrollPane();
        lyp_details = new javax.swing.JLayeredPane();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        spn_orid = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_regDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        spn_size = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spn_quantity = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spn_total = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        lbl_staff = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_fisrt = new javax.swing.JLabel();
        btn_previos = new javax.swing.JLabel();
        btn_next = new javax.swing.JLabel();
        btn_last = new javax.swing.JLabel();
        scr_listDetail = new javax.swing.JScrollPane();
        btn_reportJasper = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ HÓA ĐƠN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tbp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel22.setForeground(new java.awt.Color(255, 153, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("THỐNG KÊ DỮ LIỆU HÓA ĐƠN");
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        lyp_sellChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lyp_sellChart.setLayout(new java.awt.GridLayout(1, 0));
        tbp_statistic.addTab("BÁN CHẠY", lyp_sellChart);

        lyp_enueChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lyp_enueChart.setLayout(new java.awt.GridLayout(1, 0));
        tbp_statistic.addTab("DOANH SỐ", lyp_enueChart);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Số lượng");

        dcs_start.setForeground(new java.awt.Color(0, 153, 153));
        dcs_start.setDateFormatString("dd-MM-yyyy hh:mm:ss.SSS");
        dcs_start.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        dcs_start.setPreferredSize(new java.awt.Dimension(192, 25));

        dcs_end.setForeground(new java.awt.Color(0, 153, 153));
        dcs_end.setDateFormatString("dd-MM-yyyy hh:mm:ss.SSS");
        dcs_end.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        dcs_end.setPreferredSize(new java.awt.Dimension(192, 25));

        spn_sellQty.setValue(10);

        btn_sellFilter.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sellFilter.setForeground(new java.awt.Color(153, 0, 153));
        btn_sellFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/funnel.png"))); // NOI18N
        btn_sellFilter.setText("LỌC");
        btn_sellFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sellFilterActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Thời gian bắt đầu");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Thời gian kết thúc");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Giá trị lớn nhất");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Số lượng nhiều nhất");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Giá trị nhỏ nhất");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Số lượng ít nhất");

        lbl_maxSum.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbl_maxSum.setForeground(new java.awt.Color(255, 153, 0));
        lbl_maxSum.setText("hóa đơn");

        lbl_maxQty.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbl_maxQty.setForeground(new java.awt.Color(255, 153, 0));
        lbl_maxQty.setText("hóa đơn");

        lbl_minSum.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbl_minSum.setForeground(new java.awt.Color(255, 153, 0));
        lbl_minSum.setText("hóa đơn");

        lbl_minQty.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbl_minQty.setForeground(new java.awt.Color(255, 153, 0));
        lbl_minQty.setText("hóa đơn");

        javax.swing.GroupLayout pnl_sellFilterLayout = new javax.swing.GroupLayout(pnl_sellFilter);
        pnl_sellFilter.setLayout(pnl_sellFilterLayout);
        pnl_sellFilterLayout.setHorizontalGroup(
            pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_sellFilterLayout.createSequentialGroup()
                        .addComponent(spn_sellQty, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addGap(56, 56, 56)
                        .addComponent(btn_sellFilter))
                    .addComponent(dcs_start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcs_end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_maxSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_maxQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_minSum, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(lbl_minQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnl_sellFilterLayout.setVerticalGroup(
            pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_sellFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_minSum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_minQty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_sellFilterLayout.createSequentialGroup()
                        .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_maxSum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_maxQty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_sellFilterLayout.createSequentialGroup()
                                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcs_start, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcs_end, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_sellFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spn_sellQty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_sellFilter))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        spn_page.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spn_pagePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout pnl_statisticLayout = new javax.swing.GroupLayout(pnl_statistic);
        pnl_statistic.setLayout(pnl_statisticLayout);
        pnl_statisticLayout.setHorizontalGroup(
            pnl_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbp_statistic)
            .addGroup(pnl_statisticLayout.createSequentialGroup()
                .addGroup(pnl_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_statisticLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnl_sellFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_statisticLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_page, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_statisticLayout.setVerticalGroup(
            pnl_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statisticLayout.createSequentialGroup()
                .addGroup(pnl_statisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spn_page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_sellFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbp_statistic, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        tbp.addTab("THỐNG KÊ", pnl_statistic);

        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("DANH SÁCH HÓA ĐƠN");
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 153, 0)), "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 153, 0))); // NOI18N

        spn_orderSize.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_orderSize.setEnabled(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Tổng");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Thông tin hóa đơn");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Số sản phẩm");

        spn_size1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_size1.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Số lượng");

        spn_quantity1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_quantity1.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Thành tiền");

        spn_total1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_total1.setEnabled(false);

        lbl_qrCode.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_qrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qrCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_qrCode.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "qr-code", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        lbl_qrCode.setPreferredSize(new java.awt.Dimension(100, 100));

        btn_exportOrders.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_exportOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportOrders.setText("Lưu Excel");
        btn_exportOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportOrdersActionPerformed(evt);
            }
        });

        btn_toggleCamera.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_toggleCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eye.png"))); // NOI18N
        btn_toggleCamera.setText("QUÉT");
        btn_toggleCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toggleCameraActionPerformed(evt);
            }
        });

        pnl_outWebcam.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(255, 102, 0)), "code scanner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        pnl_outWebcam.setPreferredSize(new java.awt.Dimension(125, 125));
        pnl_outWebcam.setLayout(new java.awt.GridLayout(1, 0));

        tbr_camera.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr_camera.setRollover(true);

        pnl_scanner.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnl_scannerLayout = new javax.swing.GroupLayout(pnl_scanner);
        pnl_scanner.setLayout(pnl_scannerLayout);
        pnl_scannerLayout.setHorizontalGroup(
            pnl_scannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        pnl_scannerLayout.setVerticalGroup(
            pnl_scannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbr_camera.add(pnl_scanner);

        pnl_outWebcam.add(tbr_camera);

        cbx_camera.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbx_camera.setForeground(new java.awt.Color(255, 102, 0));
        cbx_camera.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "Thiết bị quét", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N

        btn_reportJasper1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_reportJasper1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-report.png"))); // NOI18N
        btn_reportJasper1.setText("Xuất hóa đơn");
        btn_reportJasper1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportJasper1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_outWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_orderSize, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_exportOrders)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_toggleCamera))
                    .addComponent(cbx_camera, javax.swing.GroupLayout.Alignment.TRAILING, 0, 243, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_qrCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spn_size1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spn_quantity1))
                            .addComponent(spn_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_reportJasper1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbx_camera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spn_orderSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_toggleCamera)
                            .addComponent(btn_exportOrders))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_qrCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_size1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_total1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btn_reportJasper1)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_outWebcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lyp_orders.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_orders.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_orders.setLayer(scr_listOrder, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lyp_ordersLayout = new javax.swing.GroupLayout(lyp_orders);
        lyp_orders.setLayout(lyp_ordersLayout);
        lyp_ordersLayout.setHorizontalGroup(
            lyp_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr_listOrder)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lyp_ordersLayout.setVerticalGroup(
            lyp_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyp_ordersLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scr_listOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbp.addTab("HÓA ĐƠN", lyp_orders);

        jLabel23.setForeground(new java.awt.Color(255, 153, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("CHI TIẾT HÓA ĐƠN");
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 153, 0)), "Quản lý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 153, 0))); // NOI18N

        spn_orid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_orid.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Thời gian tạo");

        lbl_regDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_regDate.setForeground(new java.awt.Color(255, 153, 51));
        lbl_regDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_regDate.setText("new Date()");
        lbl_regDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 3, 0, new java.awt.Color(204, 255, 255)));

        txt_note.setEditable(false);
        txt_note.setBackground(new java.awt.Color(51, 51, 51));
        txt_note.setContentType("text/html"); // NOI18N
        txt_note.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txt_note);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Số sản phẩm");

        spn_size.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_size.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Số lượng");

        spn_quantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_quantity.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Thành tiền");

        spn_total.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spn_total.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Nhân viên");

        lbl_staff.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_staff.setForeground(new java.awt.Color(255, 153, 51));
        lbl_staff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_staff.setText("tên nhân viên");
        lbl_staff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 3, 0, new java.awt.Color(255, 153, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(spn_size, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(spn_total)
                    .addComponent(spn_orid)
                    .addComponent(lbl_regDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_staff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spn_orid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_regDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spn_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spn_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spn_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(255, 153, 0)), "Điều Hướng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(0, 4, 3, 3));

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
        jPanel5.add(btn_fisrt);

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
        jPanel5.add(btn_previos);

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
        jPanel5.add(btn_next);

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
        jPanel5.add(btn_last);

        btn_reportJasper.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_reportJasper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-report.png"))); // NOI18N
        btn_reportJasper.setText("Xuất hóa đơn");
        btn_reportJasper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportJasperActionPerformed(evt);
            }
        });

        lyp_details.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_details.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_details.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_details.setLayer(scr_listDetail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyp_details.setLayer(btn_reportJasper, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lyp_detailsLayout = new javax.swing.GroupLayout(lyp_details);
        lyp_details.setLayout(lyp_detailsLayout);
        lyp_detailsLayout.setHorizontalGroup(
            lyp_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr_listDetail)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addGroup(lyp_detailsLayout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reportJasper)
                .addContainerGap())
        );
        lyp_detailsLayout.setVerticalGroup(
            lyp_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyp_detailsLayout.createSequentialGroup()
                .addGroup(lyp_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reportJasper))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_listDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbp.addTab("CHI TIẾT", lyp_details);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbp)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_previosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_previosMouseClicked
        this.navigator(N_TYPE.PREV, false);
    }//GEN-LAST:event_btn_previosMouseClicked

    private void btn_fisrtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fisrtMouseClicked
        this.navigator(N_TYPE.FIRST, false);
    }//GEN-LAST:event_btn_fisrtMouseClicked

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        this.navigator(N_TYPE.LAST, false);
    }//GEN-LAST:event_btn_lastMouseClicked

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        this.navigator(N_TYPE.NEXT, false);
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_exportOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportOrdersActionPerformed
        int size = orderTable.getRowCount();
        if (Message.confirm(this,
                String.format("Lưu hóa đơn gồm %s sản phẩm", size),
                "Lưu hóa danh sách hóa đơn",
                Message.CF_TYPE.YES_OR_CANCEL) == 0)
        try {
            util.exportExcel((DefaultTableModel) orderTable.getModel());
        } catch (Exception ex) {
            Logger.getLogger(dlg_orderScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_exportOrdersActionPerformed

    private void btn_sellFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sellFilterActionPerformed
        this.setNewChart();
    }//GEN-LAST:event_btn_sellFilterActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ViewControl.ROOT_APP.setVisible(true);
        this.closeWebcams();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void spn_pagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spn_pagePropertyChange
        this.setNewChart();
    }//GEN-LAST:event_spn_pagePropertyChange

    private void btn_reportJasperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportJasperActionPerformed
        this.jasperReport();
    }//GEN-LAST:event_btn_reportJasperActionPerformed

    private void btn_reportJasper1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportJasper1ActionPerformed
        this.jasperReport();
    }//GEN-LAST:event_btn_reportJasper1ActionPerformed

    private void btn_toggleCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toggleCameraActionPerformed
        Webcam webcam = (Webcam) this.cbx_camera.getSelectedItem();
        if (webcam == null) {
            return;
        }

        if (btn_toggleCamera.isSelected()) {
            webcam.open(true);
            cam = new WebcamControl(cbx_camera, pnl_scanner, txt_scanner) {
                @Override
                public void handleCode() {
                    getHandleCode();
                }
            };
            cam.cameraTimer.start();
        } else {
            this.closeWebcams();
        }
    }//GEN-LAST:event_btn_toggleCameraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exportOrders;
    private javax.swing.JLabel btn_fisrt;
    private javax.swing.JLabel btn_last;
    private javax.swing.JLabel btn_next;
    private javax.swing.JLabel btn_previos;
    private javax.swing.JButton btn_reportJasper;
    private javax.swing.JButton btn_reportJasper1;
    private javax.swing.JButton btn_sellFilter;
    private javax.swing.JToggleButton btn_toggleCamera;
    private javax.swing.JComboBox<Webcam> cbx_camera;
    private com.toedter.calendar.JDateChooser dcs_end;
    private com.toedter.calendar.JDateChooser dcs_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_maxQty;
    private javax.swing.JLabel lbl_maxSum;
    private javax.swing.JLabel lbl_minQty;
    private javax.swing.JLabel lbl_minSum;
    private javax.swing.JLabel lbl_qrCode;
    private javax.swing.JLabel lbl_regDate;
    private javax.swing.JLabel lbl_staff;
    private javax.swing.JLayeredPane lyp_details;
    private javax.swing.JLayeredPane lyp_enueChart;
    private javax.swing.JLayeredPane lyp_orders;
    private javax.swing.JLayeredPane lyp_sellChart;
    private javax.swing.JPanel pnl_outWebcam;
    private javax.swing.JPanel pnl_scanner;
    private javax.swing.JPanel pnl_sellFilter;
    private javax.swing.JPanel pnl_statistic;
    private javax.swing.JScrollPane scr_listDetail;
    private javax.swing.JScrollPane scr_listOrder;
    private javax.swing.JSpinner spn_orderSize;
    private javax.swing.JSpinner spn_orid;
    private com.toedter.components.JSpinField spn_page;
    private javax.swing.JSpinner spn_quantity;
    private javax.swing.JSpinner spn_quantity1;
    private com.toedter.components.JSpinField spn_sellQty;
    private javax.swing.JSpinner spn_size;
    private javax.swing.JSpinner spn_size1;
    private javax.swing.JSpinner spn_total;
    private javax.swing.JSpinner spn_total1;
    private javax.swing.JTabbedPane tbp;
    private javax.swing.JTabbedPane tbp_statistic;
    private javax.swing.JToolBar tbr_camera;
    private javax.swing.JTextPane txt_note;
    // End of variables declaration//GEN-END:variables
    private final JTextField txt_scanner = new JTextField();
    private final OrderDAO dao = DAOModel.ORDER;
    private final TableIndexControl tic;
    private final List<Order> orders;
    private final JTable orderTable;
    private final ExportOrder export;
    private WebcamControl cam;

    public enum N_TYPE {
        FIRST, PREV, NEXT, LAST, DEFAULT
    }

    private void init() {
        Date[] mm = FilterOrder.getMinMaxDate(orders);
        this.dcs_start.setDate(mm[0]);
        this.dcs_end.setDate(mm[1]);
        this.scr_listOrder.setViewportView(orderTable);
        this.spn_orderSize.setValue(orderTable.getRowCount());
        this.setNewChart();
        for (Webcam webcam : Webcam.getWebcams()) {
            this.cbx_camera.addItem(webcam);
        }

        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tic.rowSelector = orderTable.getSelectedRow();
                Long key = getKeyOnTable();
                if (key != null) {
                    setDetail(dao.getById(key), e.getClickCount() > 1);
                }
            }
        });

        orderTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37:
                        navigator(N_TYPE.FIRST, false);
                        break;
                    case 38:
                        navigator(N_TYPE.PREV, false);
                        break;
                    case 39:
                        navigator(N_TYPE.LAST, false);
                        break;
                    case 40:
                        navigator(N_TYPE.NEXT, false);
                        break;
                }
            }
        });
    }

    private void closeWebcams() {
        for (Webcam webcam : Webcam.getWebcams()) {
            webcam.close();
        }
    }

    private void getHandleCode() {
        String code = this.txt_scanner.getText();
        long id = 0;
        Order p;

        if (code == null) {
            return;
        }

        try {
            id = Long.parseLong(code);
        } catch (NumberFormatException e) {
        }

        if ((p = dao.getById(id)) != null) {
            this.setDetail(p, false);
        }
    }

    private void setNewChart() {
        if (orders == null) {
            return;
        }
        // filter order by date
        Date st = dcs_start.getDate(), en = dcs_end.getDate();
        Predicate<Order> predicate = o -> {
            Date d = o.getRegTime();
            return d.compareTo(st) >= 0 && d.compareTo(en) <= 0;
        };
        List<Order> list = FilterOrder.getList(predicate);

        // preapare min max input values
        int size = list.size();
        int page = this.spn_page.getValue();
        int qty = this.spn_sellQty.getValue();
        int fromIndex = page * qty, toIndex = fromIndex + qty;
        if (toIndex > size) {
            toIndex = size - fromIndex;
        }
        this.spn_page.setMinimum(0);
        this.spn_page.setMaximum((int) Math.floor(size / qty));
        try { // sublist at page
            list = list.subList(fromIndex, toIndex);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        this.setStatistic(list); // show data
    }

    // get key on table return null if does not exist
    private Long getKeyOnTable() {
        final int row = orderTable.getSelectedRow();
        return (Long) orderTable.getValueAt(row, this.tic.columnOfKey);
    }

    public void navigator(N_TYPE type, boolean redirect) {
        int max = orderTable.getRowCount() - 1;
        Map<Long, Order> map = dao.getMap();

        if (!map.isEmpty()) {
            switch (type) {
                case FIRST:
                    this.tic.rowSelector = 0;
                    break;
                case PREV:
                    this.tic.rowSelector = tic.rowSelector > 0
                            ? tic.rowSelector - 1 : max;
                    break;
                case NEXT:
                    this.tic.rowSelector = tic.rowSelector < max
                            ? tic.rowSelector + 1 : max;
                    break;
                case LAST:
                    this.tic.rowSelector = max;
                    break;
            }
            Order e = map.get((Long) tic.getKeyOnTable());
            this.setDetail(e, redirect);
        }
    }

    private void setDetail(Order e, boolean redirect) {
        if (e == null) {
            return;
        }
        if (redirect) {
            this.tbp.setSelectedComponent(lyp_details);
        }

        EnumDetail.Detail[] arrDetail = e.getArrDetail();
        int quantity = 0, size = arrDetail.length, qty;
        double sum = 0D;

        // calculator amount price, quantity, size data
        for (EnumDetail.Detail d : arrDetail) {
            if (d == null) {
                continue;
            }

            qty = d.getQuantity();
            quantity += qty;
            sum += qty * d.getOldPrice();
        }

        Date date = e.getRegTime();
        try {
            this.lbl_qrCode.setIcon(new ImageIcon(
                    util.generateQrCode(String.valueOf(e.getKey()), 100, 100)
            ));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        this.lbl_staff.setText(DAOModel.USER.getById(e.getStaff_id()).getName());
        this.lbl_regDate.setText(Format.DATE.format(date));
        this.txt_note.setText(SetHypertext.htmlShowOrder(e));
        this.spn_orid.setValue(e.getKey());
        this.spn_size.setValue(size);
        this.spn_total.setValue(sum);
        this.spn_quantity.setValue(quantity);
        this.spn_size1.setValue(size);
        this.spn_total1.setValue(sum);
        this.spn_quantity1.setValue(quantity);
        this.scr_listDetail.setViewportView(EnumDetail.Detail.table(e.getDetails()));
    }

    private void setStatistic(List<Order> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        // clear all chart
        lyp_sellChart.removeAll();
        lyp_enueChart.removeAll();

        // preapate plots and show chart
        CategoryPlot[] plots = this.getPlots(list);
        lyp_sellChart.add(this.getChartPanel(plots[0]));
        lyp_enueChart.add(this.getChartPanel(plots[1]));
    }

    // create chart panel (Jpanel) with input plot
    private JPanel getChartPanel(CategoryPlot plot) {
        JFreeChart chart = new JFreeChart(null, env.FONT, plot, true);
        ChartPanel panel = new ChartPanel(chart, false, true, false, true, true);
        panel.setDomainZoomable(true);
        panel.setDisplayToolTips(true);
        panel.setFillZoomRectangle(true);
        return panel;
    }

    // get dataset for quantity
    private CategoryPlot[] getPlots(List<Order> list) {
        Order mis = new Order(), mas = new Order(), mit = new Order(), mat = new Order();
        double minT = 0, maxT = 0, tempT;
        int minS = 0, maxS = 0, tempS, tempQ;
        String columnKey, label = "số lượng", cateLabel = "Hóa đơn";
        String lineLabel = "số sản phẩm", sellLabel = "số lượng", enueLabel = "thành tiền";
        Number[] sqs;

        // return new plots if list is empty
        if (list == null || list.isEmpty()) {
            return new CategoryPlot[]{
                new CategoryPlot(),
                new CategoryPlot()
            };
        }

        // declare variables
        CategoryPlot sellPlot = new CategoryPlot();
        CategoryPlot enuePlot = new CategoryPlot();
        DefaultCategoryDataset lineDataSet = new DefaultCategoryDataset();
        DefaultCategoryDataset sellDataSet = new DefaultCategoryDataset();
        DefaultCategoryDataset enueDataSet = new DefaultCategoryDataset();

        // prepare data
        for (Order e : list) {
            columnKey = e.toString();
            sqs = EnumDetail.Detail.sqs(e.details);

            tempQ = sqs[0].intValue();
            tempS = sqs[1].intValue();
            tempT = sqs[2].doubleValue();

            // get min max of size product in order detail
            if (minS > tempS) {
                minS = tempS;
                mis = e;
            } else if (maxS < tempS) {
                maxS = tempS;
                mas = e;
            }

            // get min max of total price in order detail
            if (minT > tempT) {
                minT = tempT;
                mit = e;
            } else if (maxT < tempT) {
                maxT = tempT;
                mat = e;
            }

            // add datasets
            lineDataSet.addValue(tempQ, lineLabel, columnKey);
            sellDataSet.addValue(tempS, sellLabel, columnKey);
            enueDataSet.addValue(tempT, enueLabel, columnKey);
        }

        // QUANTITY
        sellPlot.setDataset(0, lineDataSet); // set line
        sellPlot.setRenderer(0, new BarRenderer());
        sellPlot.setDataset(1, sellDataSet); // set bar
        sellPlot.setRenderer(1, new LineAndShapeRenderer());
        sellPlot.setRangeAxis(new NumberAxis(label));
        sellPlot.setDomainAxis(new CategoryAxis(cateLabel));

        // REVENUE
        enuePlot.setDataset(0, lineDataSet); // set line
        enuePlot.setRenderer(0, new BarRenderer());
        enuePlot.setDataset(1, enueDataSet); // set bar
        enuePlot.setRenderer(1, new LineAndShapeRenderer());
        enuePlot.setRangeAxis(new NumberAxis(label));
        enuePlot.setDomainAxis(new CategoryAxis(cateLabel));

        // set statistic values
        this.lbl_maxQty.setText(mas.toString() + " : " + maxS + " sản phẩm");
        this.lbl_maxSum.setText(mat.toString() + " : " + maxT + " dvt");
        this.lbl_minQty.setText(mis.toString() + " : " + minS + " sản phẩm");
        this.lbl_minSum.setText(mit.toString() + " : " + minT + " dvt");
        return new CategoryPlot[]{sellPlot, enuePlot};
    }

    private void jasperReport() {
        Long key = Long.valueOf(spn_orid.getValue().toString());
        Order o = dao.getById(key);

        if (o != null) {
            if (Message.confirm(this,
                    String.format("Xuất hóa đơn gồm %d sản phẩm", o.details.size()),
                    "Lưu danh sách hóa đơn",
                    Message.CF_TYPE.YES_OR_CANCEL) == 0) {
                this.export.detail(o);
            }
        }
    }
}
