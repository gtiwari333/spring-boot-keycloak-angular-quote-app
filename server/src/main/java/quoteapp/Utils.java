package quoteapp;

public class Utils {

    public static String clean(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

}
