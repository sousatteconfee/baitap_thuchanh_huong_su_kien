package shop.services.staticControl;

import java.awt.EventQueue;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import shop.configuration.AuthAccess;

import shop.configuration.env;
import shop.configuration.security;
import shop.controls.SendMail;
import shop.models.entities.User;
import shop.views.App;
import shop.views.windows.dlg_loading;
import shop.views.windows.dlg_orderRoleChooser;
import shop.views.windows.dlg_security_forgotPass;
import shop.views.windows.dlg_security_login;
import shop.views.windows.dlg_security_register;
import shop.views.windows.frame_ViewWeb;

public interface ViewControl {

    App ROOT_APP = new App();
    dlg_security_login S_LOGIN = new dlg_security_login(ROOT_APP, true);
    dlg_security_register S_REGISTER = new dlg_security_register(ROOT_APP, true);
    dlg_security_forgotPass S_FORGOT_PASS = new dlg_security_forgotPass(ROOT_APP, true);
    dlg_orderRoleChooser roleChooser = new dlg_orderRoleChooser(ROOT_APP, true);
    frame_ViewWeb V_WEB = new frame_ViewWeb(ROOT_APP);

    static AuthAccess.ROLE roleChooser() {
        roleChooser.setLocationRelativeTo(ROOT_APP);
        roleChooser.setVisible(true);
        return roleChooser.role;
    }

    static void view_logout() {
        User u = security.getUser();
        if (security.isLogin()) {
            if (Message.confirm(ROOT_APP,
                    "Xác nhận đăng xuất tài khoản " + u.getUsername(),
                    "TÀI KHOẢN: " + u.getName(), Message.CF_TYPE.YES_NO)
                    == 0) {
                security.logout();
                S_LOGIN.clearForm();
                ROOT_APP.loadControlDisplay();
            }
        }
    }

    static void exit() {
        if (Message.confirm(ROOT_APP, "Xác nhận đóng ứng dụng?",
                "ĐÓNG ỨNG DỤNG SHOP_APP", Message.CF_TYPE.YES_NO)
                == 0) {
            System.exit(0);
        }
    }

    @SuppressWarnings("")
    static boolean sendCodeToMail(String subject, String content, String... toMails) throws InterruptedException {
        dlg_loading load = new dlg_loading(null, true);
        load.setLocationRelativeTo(null);
        EventQueue.invokeLater(() -> load.setVisible(true));
        boolean sent;

        // PREPARE DATA
        load.setInfo("Create send mail!", 0, true);
        Thread.sleep(1000);
        load.setInfo("Prepare email!", 10);
        load.setInfo("Prepate subject", 15);
        load.setInfo("prepare text", 20);
        load.setInfo("prepare files", 25);
        File[] files = {
            new File(env.PATH_LOGO.getPath())
        };
        for (File file : files) {
            load.setInfo(file.getName(), 35);
            Thread.sleep(500);
            load.setInfo(file.getName() + " : " + file.canRead(), 35);
            Thread.sleep(1000);
        }

        // SENDING
        load.setInfo("prepared all data success", 50, false);
        Thread.sleep(1000);
        load.setInfo("mail sending ...", 80, true);
        try {
            new SendMail().send(javax.mail.Message.RecipientType.TO, subject, content, files, toMails);
            load.setInfo("mail sent successfully.", 100, false);
            Thread.sleep(3000);
            sent = true;
        } catch (MessagingException e) {
            load.setInfo("mail sending failed!!!", 99, false);
            Thread.sleep(1000);
            load.setInfo(e.getMessage(), 99, true);
            Thread.sleep(3000);
            sent = false;
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
        }
        load.setInfo("close mail send mail dialog", 100, false);
        Thread.sleep(1000);
        load.dispose();
        return sent;
    }
}
