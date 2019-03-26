package com.yt.arithmetic.solutions.string;/**
 * Created by SUN on 19/3/20.
 */

/**
 * @author SUN
 * @create 2019-03-20 下午8:29
 * @desc
 */
public class StringToIntegerATOI {

    //
    public int myAtoi(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();

        int flag = -2;

        int s = 0;

        int count = 0;

        boolean start = false;

        for(int i = 0; i <chars.length; i++ ) {
            //处理 ' '
            if (start || chars[i] == ' ') {
                continue;
            }
            start = true;
            //处理 符号
            if (flag == -2 && (chars[i] == '+' || chars[i] == '-')) {
                flag = chars[i] == '+' ? 1 : -1;
            }
            flag = 1;
            if (Character.isDigit(chars[i]) && count < 11) {
                //最值 如何搞。。。。TODO

                if (count == 9) {
                    if (s > 214748364) {
                        if (flag == 1) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }
                    if (flag == 1 && chars[i] > 7) {
                        return Integer.MAX_VALUE;
                    } else if (flag == -1 && chars[i] > 8) {
                        return Integer.MIN_VALUE;
                    }
                }
                s = (s - '0') * 10 + (chars[i] - '0');
                count++;
            }
            break;
        }

        return -1;
    }

}
