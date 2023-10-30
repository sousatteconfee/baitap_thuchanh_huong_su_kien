package shop.controls;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public abstract class WebcamControl {

    public final Timer cameraTimer;
    private final JPanel pnl_scanner;
    private final JTextField txt_scanner;
    private final JComboBox<Webcam> cbx_camera;

    public abstract void handleCode();

    public WebcamControl(JComboBox<Webcam> cbx_camera, JPanel pnl_scanner, JTextField txt_scanner) {
        this.cbx_camera = cbx_camera;
        this.pnl_scanner = pnl_scanner;
        this.txt_scanner = txt_scanner;

        this.cameraTimer = new Timer(1000, e -> {
            Webcam cam = (Webcam) this.cbx_camera.getSelectedItem();
            BufferedImage image = cam.getImage();
            if (image != null) {
                try {
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                            new BufferedImageLuminanceSource(image)
                    ));

                    Result r = new MultiFormatReader().decodeWithState(bitmap);
                    this.txt_scanner.setText(r.getText());
                    this.handleCode();
                } catch (NotFoundException ex) {
                }
            }
        });

        this.addEvent();
        this.setCamera(Webcam.getDefault()); // default camera on first
    }

    
    private void addEvent() {
        // onchange combobox set new camera
        this.cbx_camera.addActionListener((ActionEvent e) -> {
            if (e.getModifiers() > 0) {
                Webcam cam = (Webcam) this.cbx_camera.getSelectedItem();
                this.setCamera(cam);
            }
        });

        // handle code when enter key pressed.
        txt_scanner.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    handleCode();
                }
            }
        });
    }

    // set camera jpannel scanner
    private void setCamera(Webcam cam) {
        WebcamPanel camPanel = new WebcamPanel(cam);
        camPanel.setFPSDisplayed(true);
        camPanel.setAntialiasingEnabled(true);
        this.pnl_scanner.removeAll();
        this.pnl_scanner.add(camPanel);
        camPanel.setSize(this.pnl_scanner.getSize());
    }

    public void clean() {
        List<Webcam> cams = Webcam.getWebcams();
        for (Webcam cam : cams) {
            cam.close();
        }
        this.cameraTimer.stop();
    }

}
