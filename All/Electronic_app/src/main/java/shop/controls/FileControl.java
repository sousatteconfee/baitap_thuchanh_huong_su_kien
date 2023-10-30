package shop.controls;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import lombok.Getter;
import shop.configuration.Config;
import shop.configuration.env;
import shop.services.staticControl.Lib;
import shop.services.staticControl.View;

/**
 * "cái này để quản lý hình ảnh sản phẩm trên form <b>Jlabel.setIcon()</b>"
 */
public class FileControl {

    public int width = 150, height = width;
    private final String default_img;
    private final JLabel lbl_image;
    private final env.folder folder;
    @Getter
    private File file;
    // public boolean isSetFile = false;
    
    public void clear() {
        this.file = null;
    }

    public FileControl(JLabel lbl_image, Config.folder folder, String default_img) {
        Dimension s = lbl_image.getSize();
        this.default_img = default_img;
        this.lbl_image = lbl_image;
        this.folder = folder;

        if (s.width > 0) {
            this.width = s.width;
        }
        if (s.height > 0) {
            this.height = s.height;
        }

        this.lbl_image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setFileImg();
            }
        });
    }

    public boolean save(StandardCopyOption... options) {
        if (file == null) {
            return false;
        }
        // prepare data
        Path source = file.toPath();
        Path target = Lib.getFile(folder, lbl_image.getText()).toPath();

        // copy data return and is success
        try {
            Files.copy(source, target, options);
            file = null;
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * "chỉ cập nhật lưu file khi file!=null => ảnh được sửa đổi"
     *
     * @param oldImage name of old image
     * @return bool
     */
    public boolean update(String oldImage) {
        if (file != null) {
            boolean del = this.delete(oldImage); // delete file
            return this.save() && del; // insert data > check insert and update
        }
        return false;
    }

    public boolean delete(String fileName) {
        if (fileName != null && !fileName.equalsIgnoreCase(default_img)) {
            File f = Lib.getFile(folder, fileName); // get file

            try { // double delete dir > file
                if (!f.delete()) {
                    f.deleteOnExit();
                }
                return true;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return false;
    }

    public void setFileImg() {
        String path, label;

        chooserImg(); // chooser image and show image on Jlabel
        if (file != null) {
            path = file.getAbsolutePath();
            label = this.hashFileName();
        } else {
            path = Lib.getFile(folder, label = default_img).toString();
        }
        View.setImage(lbl_image, path, width, height);
        lbl_image.setText(label);
    }

    protected void chooserImg() {
        JFileChooser chooser = new JFileChooser();
        // JFileChooser.APPROVE_OPTION == 0 chooser <> 1 cancel
        file = chooser.showOpenDialog(lbl_image) == 0 ? chooser.getSelectedFile() : null;
    }

    private String hashFileName() {
        String text = file.getName();
        String type = text.substring(text.lastIndexOf("."));
        return (System.currentTimeMillis() + text).hashCode() + type;
    }
}
