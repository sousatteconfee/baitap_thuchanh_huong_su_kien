package shop.services.staticControl;

import java.awt.Component;
import java.time.DateTimeException;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.utils.SetHypertext;
import shop.views.windows.dlg_security_register;

public interface ConfirmDialog {

    @SuppressWarnings("")
    default boolean isConfirmEmail(Component parent, String toMail) {
        int size = 8, forTime = 0x2bf20; // 180.000 = 3 minutes
        String code, backCode;

        // PREPARE CODE AND TEXT HTML CONTENT
        code = RandomCode.getCode(size, forTime);
        RandomCode.clearCodeExpired();// delete all code expired

        // SENDING CODE TO EMAIL
        this.sendCode(parent, code, toMail, size, forTime).start();

        // CONFIRM CODE
        do {
            backCode = Message.prompt(parent, "Nhập mã xác thực: ", "XÁC THỰC EMAIL", Message.TYPE.QUESTION);
            if (backCode == null) {
                RandomCode.dropCode(code);
                return false;
            }

            if (backCode.equals(code)) {
                Message.alert(parent, toMail + " xác thực thành công.", "XÁC THỰC EMAIL", Message.TYPE.NONE);
                RandomCode.dropCode(code); // drop code in storage
                return true;
            } else if (Message.confirm(parent, new StringBuilder("Mã xác thực")
                    .append(backCode).append(" không đúng!")
                    .append("\nLấy mã xác thực mới?").toString(),
                    "LẤY MÃ XÁC THỰC MỚI",
                    Message.CF_TYPE.YES_NO) == 0) {
                RandomCode.dropCode(code); // delete old code
                code = RandomCode.getCode(size, forTime); // random new code
                this.sendCode(parent, code, toMail, size, forTime).start(); // resend to mail
            }

            try {
                RandomCode.getTime(code);
            } catch (DateTimeException ex) {
                Message.alert(parent, code + " đã hết hạn!", "XÁC NHẬN MÃ CODE", Message.TYPE.ERROR);
                return false;
            }

        } while (!backCode.equals(code));

        return false;
    }

    default Thread sendCode(Component parent, String code, String toMail, int size, long forTime) {
        return new Thread(() -> {
            try {
                if (ViewControl.sendCodeToMail("SHOP_APP " + code + " xac thuc email.",
                        SetHypertext.htmlGetCode(code),
                        toMail
                )) {
                    Message.alert(parent, new StringBuilder("Mã code: ")
                            .append(size)
                            .append(" kí tự được gửi tới email ").append(toMail)
                            .append("\nKiểm tra email lấy mã xác thực.")
                            .append("\nCode có hiệu lực trong vòng")
                            .append(forTime / 60000).append(" phút").toString(),
                            "XÁC NHẬN EMAIL NGƯỜI DÙNG",
                            Message.TYPE.INFO);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(dlg_security_register.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
