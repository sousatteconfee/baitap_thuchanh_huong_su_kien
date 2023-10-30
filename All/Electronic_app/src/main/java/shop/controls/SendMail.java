package shop.controls;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import shop.configuration.Config;
import shop.services.staticControl.Regex;

interface suport {
    
    String AUTH = Config.mail.smtpAuth.toString();
    String HOST = Config.mail.smtpHost.toString();
    Integer PORT = Integer.valueOf(Config.mail.smtpPort.toString());
    String SSL_PROTOCOL = Config.mail.sslProtocol.toString();
    String TLS_ENABLE = Config.mail.smtpStarttlsEnable.toString();

    // get MimeMultipart input and all file in MimeBodyPart
    static MimeMultipart getMultipart(MimeBodyPart mbp, File... files) throws MessagingException {
        MimeMultipart parts = getMultipart(files);
        parts.addBodyPart(mbp);
        return parts;
    }

    // get MimeMultipart with file in bodyPart
    static MimeMultipart getMultipart(File... files) throws MessagingException {
        if (files == null || files.length < 1) {
            return new MimeMultipart();
        }
        MimeMultipart parts = new MimeMultipart();
        
        for (File f : files) { // add multiple files
            MimeBodyPart part = new MimeBodyPart();
            part.setDataHandler(new DataHandler(new FileDataSource(f)));
            part.setFileName(f.getName());
            parts.addBodyPart(part);
        }
        return parts;
    }
}

/**
 * <!-- includes: mail-1.4.7.jar and activation-1.1.jar -->
 * <!-- https://mvnrepository.com/artifact/javax.mail/mail -->
 * <code>javax.mail_mail_1.4.7</code>
 *
 * <h3><a href="https://myaccount.google.com/security">
 * turn on ‎2-Step Verification and create app-password
 * </a></h3>
 */
public class SendMail implements suport {
    
    private final static String USERNAME = Config.mail.username.toString();
    private final static String PASSWORD = Config.mail.password.toString();
    public final MimeMessage mm;
    
    public SendMail() {
        this.mm = new MimeMessage(this.createSessions());
    }

    // send text only
    public void send(Message.RecipientType type, String subject, String text, String... toMails)
            throws MessagingException {
        this.mm.setSubject(subject);
        if (Regex.isRegex(text, Regex.PATTERNS.HTML)) {
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent(text, "text/html; charset=utf-8");
            this.mm.setContent(suport.getMultipart(mbp));
        } else {
            this.mm.setText(text, "utf-8");
        }
        this.mm.setRecipients(type, this.mailHandle(toMails));
        Transport.send(this.mm);
    }

    // send text/html
    public void send(Message.RecipientType type, String subject, String text, File[] files, String... toMails)
            throws MessagingException {
        this.mm.setSubject(subject);
        this.mm.setSentDate(new Date());
        MimeBodyPart mbp = new MimeBodyPart();
        if (Regex.isRegex(text, Regex.PATTERNS.HTML)) {
            mbp.setContent(text, "text/html; charset=utf-8");
        } else {
            mbp.setText(text, "utf-8");
        }
        this.mm.setContent(suport.getMultipart(mbp, files));
        this.mm.setRecipients(type, this.mailHandle(toMails));
        Transport.send(this.mm);
    }

    // convert 
    private String mailHandle(String... mails) throws MessagingException {
        if (mails == null || mails.length == 0b0) {
            throw new MessagingException("mails may be empty!!!");
        }
        StringBuilder builder = new StringBuilder();
        for (String mail : mails) {
            builder.append(mail).append(',');
        }
        return builder.substring(0, builder.lastIndexOf(","));
    }

    // configuration to connect
    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", AUTH);
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.ssl.protocols", SSL_PROTOCOL);
        properties.put("mail.smtp.starttls.enable", TLS_ENABLE);
        return properties;
    }

    // prepare session
    private Session createSessions() {
        Authenticator authenticator = new Authenticator() {
            @Override // this method default password is null
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };
        return Session.getInstance(this.getProperties(), authenticator);
    }
}
