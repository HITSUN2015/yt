package com.yt.util;

import com.google.common.base.Joiner;

import java.util.List;

/**
 * @author SUN
 * @create 2018-11-15 上午12:04
 * @desc String 工具类
 */
public class StringUtil {

    public static final String EMPTY = "";

    public static boolean isBlankNoExactly(String content) {
        if (content == null || content.length() == 0) {
            return true;
        }
        if (content.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isBlankExactly(String content) {
        if (null == content || content.length() == 0) {
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
        if (isBlankNoExactly(lineContent)) {
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

    private static final int INCREASE_COMPARE_RESULT = 1;


    public static int compareIntegerString(String s1, String s2) {
        if (null == s2) {
            return INCREASE_COMPARE_RESULT;
        }
        if (null == s1) {
            return -INCREASE_COMPARE_RESULT;
        }
        return s1.compareToIgnoreCase(s2);
    }

    /**
     * 空格会作为一个输入
     * @param s1
     * @param s2
     * @return
     */
    public static String joinWithSeperator(String[] str, String seperator) {
        if (null == str) {
            return EMPTY;
        }
        Joiner joiner = Joiner.on(seperator);
        return joiner.join(str);
    }

    public static String joinWithSeperator(List<String> str, String seperator) {
        Joiner joiner = Joiner.on(seperator);
        return joiner.join(str);
    }
}
