package shop.configuration;

import java.io.File;
import java.util.Properties;

import lombok.AllArgsConstructor;
import shop.services.staticControl.Lib;

/**
 * @see shop.configuration.env
 */
public interface Config {

    String CONFIG = "/config.properties";
    String BASE = System.getProperty("user.dir");
    Properties PROPERTIES = Lib.getProperties(BASE + CONFIG);

    @AllArgsConstructor
    enum app {
        language(PROPERTIES.getOrDefault("app.text.language", "en")),
        timeDelay(PROPERTIES.getOrDefault("app.time.delay", 1000)),
        timeFormat(PROPERTIES.getOrDefault("app.time.format", "EEEE, dd-MMM-yyyy hh:mm:ss aa")),
        iconSize(PROPERTIES.getOrDefault("app.icon.size", 32)),
        fontSize(PROPERTIES.getOrDefault("app.font.size", 16)),
        fontFamily(PROPERTIES.getProperty("app.font.family", "Times New Roman"));

        public final Object value;

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

    @AllArgsConstructor
    enum folder {
        background(PROPERTIES.getOrDefault("asserts.background", "/assets/images/background")),
        account(PROPERTIES.getOrDefault("asserts.account", "/assets/images/account")),
        product(PROPERTIES.getOrDefault("asserts.product", "/assets/images/product")),
        category(PROPERTIES.getOrDefault("asserts.category", "/assets/images/category")),
        data(PROPERTIES.getProperty("assets.data", "/assets/data"));

        public final Object value;

        @Override
        public String toString() {
            return value.toString();
        }

        public File toFile() {
            return Lib.getDir(value.toString());
        }
    }

    @AllArgsConstructor
    enum mail {
        smtpAuth(PROPERTIES.getOrDefault("mail.smtp.auth", "true")),
        smtpPort(PROPERTIES.getOrDefault("mail.smtp.port", 587)),
        smtpHost(PROPERTIES.getOrDefault("mail.smtp.host", "smtp.gmail.com")),
        smtpStarttlsEnable(PROPERTIES.getOrDefault("mail.smtp.starttls.enable", true)),
        sslProtocol(PROPERTIES.getOrDefault("mail.smtp.ssl.protocols", "TLSv1.2")),
        username(PROPERTIES.getOrDefault("mail.username", new String())),
        password(PROPERTIES.getOrDefault("mail.password", new String()));

        public final Object value;

        @Override
        public String toString() {
            return value.toString();
        }
    }

    @AllArgsConstructor
    enum mssql {
        username(PROPERTIES.getProperty("mssql.username",
                "LAPTOP-5PR58A5U\\IUHSERVER")),
        password(PROPERTIES.getProperty("mssql.password",
                "null")),
        className(PROPERTIES.getOrDefault("mssql.driverClassName",
                "com.microsoft.sqlserver.jdbc.SQLServerDriver")),
        url(PROPERTIES.getOrDefault("mssql.url",
                "jdbc:sqlserver://localhost:1433;databaseName=db_mssql_ELECTRONS"));

        public final Object value;

       @Override
        public String toString() {
            return value.toString();
        }
    }
}
