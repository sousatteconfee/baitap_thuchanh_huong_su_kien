package shop.views.components;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import shop.configuration.Config;
import shop.configuration.env;
import shop.models.dao.ProductDAO;
import shop.models.entities.Category;
import shop.models.entities.Product;
import shop.services.sql.DAOModel;
import shop.services.staticControl.FilterProduct;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;
import shop.services.staticControl.FilterProduct.R_BY;

public class pnl_productContent extends javax.swing.JPanel {

    public pnl_productContent() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbr_filter1 = new javax.swing.JToolBar();
        pnl_btnCates = new javax.swing.JPanel();
        btn_category = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        spn_products = new javax.swing.JScrollPane();
        lyp_products = new javax.swing.JLayeredPane();
        tbl_filter2 = new javax.swing.JToolBar();
        pnl_Statistic = new javax.swing.JPanel();
        lbl_size = new javax.swing.JLabel();
        cbx_sortBy = new javax.swing.JComboBox<>();
        lbl_category = new javax.swing.JLabel();
        sld_viewProducts = new javax.swing.JSlider();

        setLayout(new java.awt.BorderLayout(1, 1));

        tbr_filter1.setRollover(true);
        tbr_filter1.setAutoscrolls(true);

        pnl_btnCates.setLayout(new javax.swing.BoxLayout(pnl_btnCates, javax.swing.BoxLayout.LINE_AXIS));

        btn_category.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_category.setText("Categories");
        pnl_btnCates.add(btn_category);

        tbr_filter1.add(pnl_btnCates);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtSearch.setToolTipText("Enter to search");
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 3, 1, new java.awt.Color(255, 102, 102)));
        txtSearch.setMargin(new java.awt.Insets(3, 3, 3, 3));
        txtSearch.setMinimumSize(new java.awt.Dimension(64, 25));
        txtSearch.setName(""); // NOI18N
        txtSearch.setPreferredSize(new java.awt.Dimension(100, 25));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        tbr_filter1.add(txtSearch);

        add(tbr_filter1, java.awt.BorderLayout.PAGE_START);

        lyp_products.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(255, 102, 102)));
        lyp_products.setLayout(new java.awt.GridLayout(0, 3, 3, 3));
        spn_products.setViewportView(lyp_products);

        add(spn_products, java.awt.BorderLayout.CENTER);

        tbl_filter2.setFloatable(true);
        tbl_filter2.setToolTipText("Product Statistic");

        lbl_size.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_size.setForeground(new java.awt.Color(255, 102, 0));
        lbl_size.setText("products size");
        lbl_size.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 102)));

        cbx_sortBy.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        cbx_sortBy.setForeground(new java.awt.Color(255, 102, 0));
        cbx_sortBy.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 3, 1, new java.awt.Color(255, 102, 102)), "Sort by", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        cbx_sortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_sortByActionPerformed(evt);
            }
        });

        lbl_category.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lbl_category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        lbl_category.setText("category name");
        lbl_category.setToolTipText("");
        lbl_category.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_category.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_category.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnl_StatisticLayout = new javax.swing.GroupLayout(pnl_Statistic);
        pnl_Statistic.setLayout(pnl_StatisticLayout);
        pnl_StatisticLayout.setHorizontalGroup(
            pnl_StatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_StatisticLayout.createSequentialGroup()
                .addGroup(pnl_StatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbx_sortBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_StatisticLayout.setVerticalGroup(
            pnl_StatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_StatisticLayout.createSequentialGroup()
                .addComponent(lbl_size)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_sortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(lbl_category, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_filter2.add(pnl_Statistic);

        add(tbl_filter2, java.awt.BorderLayout.LINE_START);

        sld_viewProducts.setMaximum(10);
        sld_viewProducts.setMinimum(2);
        sld_viewProducts.setMinorTickSpacing(1);
        sld_viewProducts.setPaintTicks(true);
        sld_viewProducts.setToolTipText("view number of product in for a row");
        sld_viewProducts.setValue(5);
        sld_viewProducts.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld_viewProductsStateChanged(evt);
            }
        });
        add(sld_viewProducts, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void sld_viewProductsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld_viewProductsStateChanged
        int col = sld_viewProducts.getValue();
        int gap = sld_viewProducts.getMaximum() / col * 2;
        lyp_products.setLayout(new GridLayout(0, col, gap, gap));
    }//GEN-LAST:event_sld_viewProductsStateChanged

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == 10) {
            this.products = FilterProduct.containsName(txtSearch.getText(), 1);
            this.fillProducts();
            this.setLblImageCate(null);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void cbx_sortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_sortByActionPerformed
        FilterProduct.SORT type = (FilterProduct.SORT) cbx_sortBy.getSelectedItem();
        FilterProduct.sort(type, products);
        this.fillProducts();
    }//GEN-LAST:event_cbx_sortByActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_category;
    private javax.swing.JComboBox<FilterProduct.SORT> cbx_sortBy;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JLayeredPane lyp_products;
    private javax.swing.JPanel pnl_Statistic;
    private javax.swing.JPanel pnl_btnCates;
    private javax.swing.JSlider sld_viewProducts;
    private javax.swing.JScrollPane spn_products;
    private javax.swing.JToolBar tbl_filter2;
    private javax.swing.JToolBar tbr_filter1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private final String defaultFile = env.DEFAULT_IMG;
    private final Config.folder folder = Config.folder.category;
    private final String defaultCateImg
            = Lib.getFile(folder, defaultFile).toString();
    private final ProductDAO pdao = DAOModel.PRODUCT;
    private Map<Integer, Category> mapCate = null;
    private List<Product> products = new ArrayList<>();

    private void init() {
        mapCate = DAOModel.CATE.getMap();
        products = FilterProduct.listActive(); // get all active products only
        this.fillCateButtons();
        this.fillComboBox();
        this.fillProducts();
        this.setLblImageCate(null);
    }

    private void fillCateButtons() {
        pnl_btnCates.removeAll();
        mapCate.forEach((k, e) -> pnl_btnCates.add(this.createButon(e)));
        txtSearch.setFont(env.FONT);
        tbr_filter1.setSize(WIDTH, HEIGHT);
    }

    private void fillComboBox() {
        for (FilterProduct.SORT sort : FilterProduct.SORT.values()) {
            cbx_sortBy.addItem(sort);
        }
    }

    private JButton createButon(Category e) {
        JButton btn = new JButton();
        String fileName = e.getImage();
        String path = Lib.getFile(folder, fileName, defaultFile).toString();

        btn.setFont(env.FONT);
        btn.setText(e.getName());
        btn.setName(String.valueOf(e.getCgid()));
        btn.setToolTipText(e.toString());
        View.setIcon(btn, path);
        this.addCateEvent(btn, e.getCgid());
        return btn;
    }

    private void fillProducts() {
        lyp_products.removeAll();
        lbl_size.setText("products size: " + products.size());
        products.forEach(e -> lyp_products.add(new pnl_productCard(e)));
        sld_viewProductsStateChanged(null);
    }

    private void addCateEvent(JButton btn, int cgid) {
        btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            this.products = FilterProduct.getR_BY(
                    pdao.getMap().values(),
                     R_BY.CATEGORY, cgid);
            this.fillProducts();
            this.setLblImageCate(cgid);
        });
    }

    private void setLblImageCate(Integer cgid) {
        String cateName = txtSearch.getText();
        if (cgid != null) {
            Category cate = mapCate.get(cgid);
            String cateImg = null;
            if (cate != null) {
                cateName = cate.getName();
                cateImg = cate.getImage();
            }

            String path = Lib.getFile(folder, cateImg, defaultFile).toString();
            View.setImage(lbl_category, path, 100, 100);
        } else {
            lbl_category.setIcon(new ImageIcon(defaultCateImg));
        }

        lbl_category.setText(cateName);
    }
}
