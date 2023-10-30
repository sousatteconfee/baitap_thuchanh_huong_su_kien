package shop.services.staticControl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.Main_App;
import shop.configuration.Config;
import shop.configuration.env;

public interface Lib {

    public static Properties createIfNotExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    Logger.getGlobal().log(Level.INFO, new StringBuilder(file.getAbsolutePath())
                            .append(" CREATED AT ").append(new Date().toString()).toString(), file);
                }

            } catch (IOException e) {
                Logger.getGlobal().log(Level.WARNING, null, e);
            }
        }
        return Lib.getProperties(path);
    }

    public static Properties getProperties(String path) {
        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(path)) {
            p.load(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public static File getDir(String... dirs) {

        File file = Paths.get(Config.BASE, dirs).toFile();
        String att = Config.PROPERTIES.getProperty("assets.attribute", "dos:hidden");

        if (!file.canExecute()) {
            if (file.mkdirs()) {
                try {
                    Files.setAttribute(file.toPath(), att, true);
                } catch (IOException ex) {
                    Logger.getLogger(Lib.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return file;
    }

    public static String getDir(Config.folder folder) {
        StringBuilder path = new StringBuilder(Config.BASE);
        path.append(folder).append("/");
        return path.toString();
    }

    public static File getFileCanRead(env.folder folder, String fileName) {
        File file = Lib.getFile(folder, fileName);
        return file.canRead() ? file : null;
    }

    public static File getFile(env.folder folder, String fileName) {
        StringBuilder path = new StringBuilder(Config.BASE);
        path.append(folder).append("/").append(fileName);
        return new File(path.toString());
    }

    public static File getFile(env.folder folder, String fileName, String defaultFile) {
        String path = new StringBuilder(Config.BASE)
                .append("/").append(folder.toString())
                .append("/").toString();
        File file = new File(path + fileName);
        return file.canRead() ? file : new File(path + defaultFile);
    }

    public static List<String> readAllLines(Config.folder folder, String fileName) {
        File carousel = Lib.getFileCanRead(folder, fileName);
        try {
            return Files.readAllLines(carousel.toPath(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(Main_App.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
