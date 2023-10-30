package shop.views.windows;

import shop.configuration.env;
import shop.services.staticControl.util;
import shop.views.App;

public class frame_ViewWeb extends javax.swing.JFrame {

    public frame_ViewWeb(App parent) {
        initComponents();
        this.setSize(parent.getSize());
        this.setLocationRelativeTo(parent);
        this.setIconImage(parent.getIconImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txt_content.setContentType("text/html"); // NOI18N
        txt_content.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txt_content);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        String t = "<h1><a src='https://github.com/studev1922'>github.com/studev1922</a></h1>";
        this.txt_content.setText(t);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public final javax.swing.JTextPane txt_content = new javax.swing.JTextPane();
    // End of variables declaration//GEN-END:variables
    private final String CHART_SET = "utf-8";
    
    public final void setHTML(String url) {
        this.txt_content.setContentType("text/html");
        this.txt_content.setText(util.fetchHTML(url, CHART_SET));
    }

    public final void setHTML(env.html file) {
        this.txt_content.setContentType("text/html");
        String text = util.fetchHTML(file.getUrl(), CHART_SET);
        this.txt_content.setText(text);
    }
}
