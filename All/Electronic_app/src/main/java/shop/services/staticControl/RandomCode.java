package shop.services.staticControl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import shop.utils.Format;
import shop.utils.Random;

public abstract class RandomCode {

    private final static String FILE = "data/randomCode.properties";
    private final static String PATH = new StringBuilder(RandomCode.class.getResource("/").getPath()).append(FILE).toString();
    public final static Properties PPS = Lib.createIfNotExist(PATH);

    /**
     * @param code to get at time randomly
     * @return the long time at randomly
     * @throws DateTimeException when time expired or cannot read
     */
    public static long getTime(String code) throws DateTimeException {
        String[] times = PPS.getProperty(code).split(":");
        long st, nd, now = System.currentTimeMillis();
        String dateExpired;
        try {
            st = Long.parseLong(times[0]);
            nd = Long.parseLong(times[1]);

            if (now < nd) {
                return st;
            } else {
                dateExpired = Format.DATE.format(nd);
            }
        } catch (NumberFormatException e) {
            dateExpired = Format.DATE.format(now);
        }
        throw new DateTimeException(new StringBuilder("Date expired at: ").append(dateExpired).toString());
    }

    /**
     * @param code for set time
     * @param miliseconds for about set expired time
     * @return long time at set code data
     * @throws IOException
     */
    public static long setTime(String code, long miliseconds) throws IOException {
        long now = System.currentTimeMillis();
        long exp = now + miliseconds;
        String comment, value = new StringBuilder(String.valueOf(now)).append(':').append(exp).toString();

        try (FileOutputStream os = new FileOutputStream(PATH)) {
            comment = new StringBuilder("WRITTEN THE CODE:").append(code)
                    .append("=").append(value).toString();
            PPS.put(code, value);
            PPS.store(os, comment);
            return now;
        }
    }

    /**
     * @param size length of code to random
     * @param forTime to set date-expired from now
     * @return the new code randomly generated
     */
    public static String getCode(int size, long forTime) {
        String code = Random.NumUppLow("", size);
        try {
            RandomCode.setTime(code, forTime);
            return code;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * remove code and get time-start of the code
     *
     * @param code for pop code
     * @return -1 if doesn't exits | drop failed then return null and long time
     * if success
     */
    public static Long popCode(String code) {
        try {
            long longTime = RandomCode.getTime(code);
            if (RandomCode.dropCode(code)) {
                return longTime;
            }
            return null;
        } catch (DateTimeException e) {
            return -1L;
        }
    }

    /**
     * @param code for drop
     * @return is success
     */
    public static boolean dropCode(String code) {
        String comment;
        try (FileOutputStream os = new FileOutputStream(PATH)) {
            comment = new StringBuilder("DROP CODE:").append(code)
                    .append(" at ").append(System.currentTimeMillis()).toString();
            PPS.remove(code);
            PPS.store(os, comment);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static void clean() {
        String comment = "clean all line at " + System.currentTimeMillis();
        try (FileOutputStream os = new FileOutputStream(PATH)) {
            PPS.clear();
            PPS.store(os, comment);
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, null, ex);
        }
    }

    /**
     * delete all lines data if date expired
     */
    public static void clearCodeExpired() {
        List<Object> keys = new LinkedList<>();
        long now = System.currentTimeMillis();
        String comment;

        // get all key has expired date
        PPS.forEach((Object k, Object v) -> {
            try {
                if (Long.parseLong(v.toString().split(":")[1]) < now) {
                    keys.add(k);
                }
            } catch (NumberFormatException e) {
            }
        });
        // remove all keys
        for (Object key : keys) {
            PPS.remove(key);
        }

        // writte map to file
        try (FileOutputStream os = new FileOutputStream(PATH)) {
            comment = new StringBuilder("DROP ").append(keys.size()).append(" codes expired")
                    .append(" at ").append(System.currentTimeMillis()).toString();
            PPS.store(os, comment);
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, null, ex);
        }
    }
}
