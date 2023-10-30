package shop;

import shop.services.staticControl.ViewControl;

/**
 *
 * "B1. DOWNLOAD ALL DEPENDENCIES",<br>
 * "B2. CHECK FILE CONFIGURATION '/config.properties'",<br>
 * "B3. EXECUTE FILE DATABASE '/db_mssql_ELECTRONS.sql'"
 */
public class Main_App {

    // "onload layout"
    private static void onLoadDisplay() {
        shop.views.App app = ViewControl.ROOT_APP;
        java.awt.EventQueue.invokeLater(() -> {
            app.setVisible(true);
        });
    }

    // UIManager.LookAndFeelInfo
    public static void main(String[] args) {
        Main_App.onLoadDisplay(); // load display components;
    }
}
