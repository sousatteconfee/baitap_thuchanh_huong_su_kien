package shop.views.windows;

import java.awt.Frame;

public class dlg_loading extends javax.swing.JDialog {

    public dlg_loading(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public static Thread thread(Frame parent, boolean modal, int timeIn) {
        dlg_loading load = new dlg_loading(parent, modal);
        load.setLocationRelativeTo(parent);
        int millis = timeIn < 100 ? 0 : timeIn / 100;

        return new Thread(() -> {
            load.setVisible(true);
            for (int i = 0; i < 100; i++) {
                try {
                    load.pgr_load.setValue(i);
                    load.lbl_text.setText("Loading (" + i + ")%");
                    Thread.sleep(millis);
                } catch (InterruptedException ex) {
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_text = new javax.swing.JLabel();
        pgr_load = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        lbl_text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text.setText("mesage");

        pgr_load.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        pgr_load.setValue(39);
        pgr_load.setDoubleBuffered(true);
        pgr_load.setFocusCycleRoot(true);
        pgr_load.setInheritsPopupMenu(true);
        pgr_load.setPreferredSize(new java.awt.Dimension(146, 30));
        pgr_load.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pgr_load, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbl_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pgr_load, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_text, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_text;
    private javax.swing.JProgressBar pgr_load;
    // End of variables declaration//GEN-END:variables

    public void setInfo(String text, int progress) {
        this.lbl_text.setText(text);
        this.pgr_load.setValue(progress);
    }

    public void setInfo(String text, int progress, boolean showLoad) {
        this.setInfo(text, progress);
        this.pgr_load.setIndeterminate(showLoad);
    }
}
