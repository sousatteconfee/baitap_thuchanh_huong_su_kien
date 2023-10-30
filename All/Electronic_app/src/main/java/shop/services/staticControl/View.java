package shop.services.staticControl;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.Timer;

import shop.configuration.env;
import shop.utils.Format;

public abstract class View {

    public static void setComponent(JComponent parent, JComponent child) {
        if (parent == null || child == null) {
            return;
        }
        parent.removeAll();
        parent.add(child);
        child.setSize(parent.getSize());

        parent.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Container parent = child.getParent();
                if (parent != null) {
                    Dimension size = parent.getSize();
                    child.setSize(size);
                }
            }
        });
    }
    
    public static Timer clocked(JLabel label) {
        String timeDelay = env.app.timeDelay.toString();
        int delay = Integer.parseInt(timeDelay);

        return new Timer(delay, e -> {
            String now = Format.DATE.format(System.currentTimeMillis());
            label.setText(now);
        });
    }

    public static void setIcon(JButton btn, String path) {
        int size = Integer.parseInt(env.app.iconSize.toString());
        ImageIcon icon = resizeIcon(path, size, size);
        btn.setIcon(icon);
    }

    public static void setImage(JLabel lbl, String path) {
        lbl.setIcon(new ImageIcon(path));
    }

    public static void setImage(JLabel lbl, String path, int w, int h) {
        lbl.setIcon(resizeIcon(path, w, h));
    }

    private static ImageIcon resizeIcon(String path, int width, int height) {
        int hints = java.awt.Image.SCALE_DEFAULT;
        ImageIcon icon = new ImageIcon(path);
        icon.setImage(icon.getImage().getScaledInstance(width, height, hints));
        return icon;
    }

}
