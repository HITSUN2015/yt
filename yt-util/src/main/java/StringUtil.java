import java.util.List;

/**
 * @author SUN
 * @create 2018-11-15 上午12:04
 * @desc String 工具类
 */
public class StringUtil {

    public static final String EMPTY = "";

    public static boolean isBlank(String content) {
        if (content == null || content.length() == 0) {
            return true;
        }
        if (content.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String content){
        if (content == null || content.length() == 0) {
            return false;
        }
        if (content.trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static String replaces(String lineContent, List<String> replaces, String toString) {
        if (isBlank(lineContent)) {
            return lineContent;
        }
//        List<String> replacePatterns = new ArrayList<>();
//        replacePatterns.add("debug(String.format(");
//        replacePatterns.add("info(String.format(");
//        replacePatterns.add("warn(String.format(");
        for (String replacePattern : replaces) {
            if (lineContent.contains(replacePattern)) {
                lineContent = lineContent.replace(replacePattern, toString);
            }
        }
        return lineContent;
    }
}
