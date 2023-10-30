package shop.utils;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import shop.configuration.Config;
import shop.configuration.env;
import shop.models.entities.Order;
import shop.models.entities.User;
import shop.services.sql.DAOModel;
import shop.services.staticControl.Lib;

public class SetHypertext {

    @AllArgsConstructor
    private enum HTML {

        // "?title", "?heading", "?code", "?note", "?footer"
        GET_CODE("<html><head><meta charset='UTF-8'><title>?title</title></head><body><div style='padding: .25rem;'><h1 style='text-align: center'>?heading</h1><hr><div style='text-align: center'><em>Mã xác nhận từ hệ thống:&nbsp;</em><strong style='border: 1px solid #000000; padding: .25rem 1rem; border-radius: .5rem;'>?code</strong><p>?note</p></div><hr><div>?footer</div></div></body></html>"),
        SHOW_ORDER("<div style='background: url(?background); text-align: center; color: white;'><table border='1'><tr><td><img width='64' src='?imgStaff'></td><td><img width='64' src='?imgBuyer'></td></tr><tr><td>?nameStaff</td><td>?nameBuyer</td></tr><tr><td colspan='2'>?note</td></tr></table></div>"),
        ANY("<h1>MAIL FROM SHOP_APP</h1>");

        private final String value;
    }

    protected static String htmlTempCode(String title, String heading, String code, String note, String footer) {
        String html = HTML.GET_CODE.value;
        return html.replace("?title", title)
                .replace("?heading", heading)
                .replace("?code", code)
                .replace("?note", note)
                .replace("?footer", footer);
    }

    public static String htmlShowOrder(Order order) {
        String html = HTML.SHOW_ORDER.value;
        File[] bgrs = env.BGRS.listFiles();
        int at = ThreadLocalRandom.current().nextInt(0, bgrs.length);
        
        String background = bgrs[at].getAbsolutePath().replaceAll("\\\\", "/");
        String note = new StringBuilder("<em>").append(order.getNote()).append("</em>").toString();
        User staff = DAOModel.USER.getById(order.getStaff_id());
        User buyer = DAOModel.USER.getById(order.getBuyer_id());
        if (buyer == null) {
            buyer = new User("customer");
            buyer.setName("Khách hàng");
        }

        String imgStaff = Lib.getFile(
                Config.folder.account,
                staff.getImage(),
                env.DEFAULT_IMG
        ).getAbsolutePath();
        String imgBuyer = Lib.getFile(
                Config.folder.account,
                buyer.getImage(),
                env.DEFAULT_IMG
        ).getAbsolutePath();
        
        String nameStaff = staff.getName();
        String nameBuyer = staff.getName();

        return html.replace("?background", "file:"+background)
                .replace("?imgStaff", "file:"+imgStaff)
                .replace("?imgBuyer", "file:"+imgBuyer)
                .replace("?note", note)
                .replace("?nameStaff", nameStaff)
                .replace("?nameBuyer", nameBuyer);
    }

    public static String htmlGetCode(String code) {
        String title = "SHOP_APP GENERATE CODE";
        String heading = "SHOP_APP nhận được yêu cầu cung cấp mã xác thực";
        String note = "Cảm ơn bạn đã sử dụng dịch vụ của tôi<div style='text-align: start'><b>THÂN ÁI!</b></div>";
        String footer = "<em>Thông tin khác về tôi: </em><ol><li><a href='https://github.com/studev1922'>github.studev</a></li><li><a href='mailto:sdhoa1922@gmail.com'>sdhoa1922@gmail.com</a></li></ol>";

        return SetHypertext.htmlTempCode(title, heading, code, note, footer);
    }

}
