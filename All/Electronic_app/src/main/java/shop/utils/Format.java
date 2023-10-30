package shop.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import shop.configuration.env;
import shop.services.staticControl.Regex;

public class Format {

    public static final SimpleDateFormat DATE = new SimpleDateFormat(
            env.app.timeFormat.toString(),
            new Locale(env.app.language.toString())
    );

    public static final String date(Object date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static final String number(String pattern, Object value) {
        if(pattern == null || pattern.isEmpty()) 
            pattern = Regex.PATTERNS.NUM_THOUSANDS.value;
        
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        return new DecimalFormat(pattern, symbols).format(value);
    }
}
