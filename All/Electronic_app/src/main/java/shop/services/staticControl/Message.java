
package shop.services.staticControl;

import java.awt.Component;
import javax.swing.JOptionPane;
import lombok.AllArgsConstructor;

public interface Message {

    @AllArgsConstructor
    public enum TYPE {
        NONE(-1), ERROR(0), INFO(1), WARNING(2), QUESTION(3);
        int value;
    }

    @AllArgsConstructor
    public enum CF_TYPE {
        NONE(-1), YES_NO(0), YES_NO_CANCEL(1), YES_OR_CANCEL(2);
        int value;
    }

    static void alert(Component parent, String message, String title, TYPE type) {
        JOptionPane.showMessageDialog(parent, message, title, type.value);
    }

    static String prompt(Component parent, Object message, String title, TYPE type) {
        return JOptionPane.showInputDialog(parent, message, title, type.value);
    }

    static int confirm(Component parent, Object message, String title, CF_TYPE type) {
        return JOptionPane.showConfirmDialog(parent, message, title, type.value);
    }

}
