package shop.views.components;

import java.awt.Color;
import java.io.File;
import javax.swing.Timer;

import shop.configuration.env;
import shop.services.staticControl.View;

public class pnl_carousel extends javax.swing.JPanel {

    public pnl_carousel() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(500, 120));
        setLayout(new javax.swing.OverlayLayout(this));

        lbl_heading.setFont(new java.awt.Font("Times New Roman", 3, 64)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(0, 204, 204));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_heading.setIconTextGap(1);
        add(lbl_heading);

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setFocusable(false);
        lbl_image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lbl_image);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_image;
    // End of variables declaration//GEN-END:variables
    private final int B_DELAY = Integer.parseInt(env.PROPERTIES.getProperty("app.carousel.bdelay", "5000"));
    private final int H_DELAY = Integer.parseInt(env.PROPERTIES.getProperty("app.carousel.hdelay", "3500"));
    private Timer viewBgr;
    private Timer viewHeading;

    private void init() {
        File[] bgrs = env.BGRS.listFiles(); // get background files
        String[] headings = env.HEADINGS; // get list heading
        int bsize = bgrs.length - 1;
        int hsize = headings.length - 1;

        // set label heading
        viewHeading = new Timer(H_DELAY, e -> {
            int at = (int) (Math.random() * hsize);
            lbl_heading.setText(headings[at]);
        });

        // set image
        View.setImage(lbl_image, bgrs[0].toString());
        viewBgr = new Timer(B_DELAY, e -> {
            int at = (int) (Math.random() * bsize);
            View.setImage(lbl_image, bgrs[at].toString());
        });

        // runtime
        viewBgr.start();
        viewHeading.start();
    }
}