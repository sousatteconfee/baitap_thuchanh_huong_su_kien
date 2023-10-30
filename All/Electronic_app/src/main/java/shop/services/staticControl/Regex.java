package shop.services.staticControl;

import lombok.AllArgsConstructor;

public interface Regex {

    @AllArgsConstructor
    enum PATTERNS {
        NUM_THOUSANDS("###,###.##"),
        HTML("<([A-Za-z][A-Za-z0-9]*)\\b[^>]*>(.*?)</\\1>"),
        EMAIL("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
        PASSWORD("^\\S+$"), // NO SPACE
        NO_EMPTY("^(?!\\s*$).+"), // check is not empty  
        NO_SPECIAL("^[a-zA-Z0-9.]*$"),
        NO_BLANK("^\\S$|^\\S[ \\S]*\\S$"), // check first and last space
        NAME("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$");
        public final String value;
    }

    static boolean isRegex(String text, PATTERNS regex_pattern) {
        if (text == null || regex_pattern == null || text.isEmpty()) {
            return false;
        }
        return text.matches(regex_pattern.value);
    }
}
