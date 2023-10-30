package shop.configuration;

import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;

import shop.services.staticControl.Lib;

public class env implements Config {

    // "LOAD BACKGROUNDS"
    public static final File BGRS = Lib.getDir(folder.background.toString());
    public static final URL PATH_LOGO = env.class.getResource(
            "/icons/" + env.PROPERTIES.getProperty("app.icon.image", env.DEFAULT_IMG)
    );
    public static final ImageIcon LOGO = new ImageIcon(PATH_LOGO);

    // "SHOW TITLE"
    public static final String[] HEADINGS = Lib.readAllLines(
            folder.data, "carousel.txt"
    ).toArray(new String[1]);

    // "LOAD FONT"
    public static Font FONT = new Font(
            app.fontFamily.toString(), 0,
            Integer.parseInt(app.fontSize.toString())
    );

    public final static String DEFAULT_IMG = "default.png";

    @AllArgsConstructor
    public static enum html {
        HELP("help.html"), ABOUT("about.html");
        private final String value;

        public String getUrl() {
            String name = new StringBuilder("/html")
                    .append('/').append(value).toString();
            return env.class.getResource(name).toString();
        }
    }
}
