package com.yt.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.validator.routines.LongValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yantong on 2019/2/13.
 */
public class RegexValidator {

    public static final String CHINA_PHONE_REGEX = "(^13\\d{9}$)|(^14)[5,7]\\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(^17\\d{9}$)|(^18\\d{9}$)";

    /**
     * <p>
     * 判断是否是手机号码
     * </p>
     */
    public static boolean isPhone(String phone) {
        // TODO: 2019/2/13 判断是否为国内
        return new org.apache.commons.validator.routines.RegexValidator(CHINA_PHONE_REGEX).isValid(phone);

//
//        // 海外
//        Pattern p = Pattern.compile("^\\d{4,20}$");
//        Matcher m = p.matcher(phone);
//        return m.matches();
    }

    /**
     * <p>
     * 判断是否是邮箱
     * </p>
     */
    public static boolean isEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    /**
     * <p>
     * 判断是否是ip地址
     * </p>
     */
    public static boolean isIp(String ip) {
        return InetAddressValidator.getInstance().isValid(ip);
    }


    public static boolean isNumber(String number){
        return LongValidator.getInstance().isValid(number);
    }
}
