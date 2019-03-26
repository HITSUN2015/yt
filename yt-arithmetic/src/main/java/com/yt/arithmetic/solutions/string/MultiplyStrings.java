package com.yt.arithmetic.solutions.string;

/**
 * Created by yantong on 2019/3/21.
 *
 * the product of 乘积
 */
public class MultiplyStrings {

    //这道题 我想了半天没想出来 没法解决 超长的存储问题
    //后来说 存 数组。。。而且用 最简单的 错位相加。。。
    public String multiply(String num1, String num2) {
        if (null == num1 || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "";
        }

        int[] result = new int[num1.length() + num2.length()];
        //初始化
        //这里没有考虑 方 长的那个
        char[] num1Chars = num1.toCharArray();
        for(int i = 0; i < num1Chars.length / 2 ; i++) {
            char temp = num1Chars[i];
            num1Chars[i] = num1Chars[num1Chars.length - 1 - i];
            num1Chars[num1Chars.length - 1 - i] = temp;
        }

        char[] num2Chars = num2.toCharArray();
        for(int i = 0; i < num2Chars.length / 2 ; i++) {
            char temp = num2Chars[i];
            num2Chars[i] = num2Chars[num2Chars.length - 1 - i];
            num2Chars[num2Chars.length - 1 - i] = temp;
        }

        //123 * 45
        //3 2 1
        //5 4
        //这个真的 太费脑了。。。我还是把 num1Chars,num2Chars,result都换成 0 是低位吧。。。

        for(int i = 0; i < num2Chars.length; i++) {
            int carry = 0;
            for(int j = 0 ; j < num1Chars.length; j++) {
                //特别要注意 string 算数字 要  '0'
                int curProduct = getIntValue(num1Chars[j]) * getIntValue(num2Chars[i]) + (result[i + j]) + carry;
                result[i + j] = curProduct % 10;
                carry = curProduct / 10;
            }
            if (carry != 0) {
                result[i + num1Chars.length] = carry;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean started = false;
        for (int i = result.length -1 ; i >= 0; i--) {
            if (!started && result[i] == 0) {//这里原来写的 是 == '0' 里面存的是int 注意
                continue;
            } else if (!started && result[i] != 0) {
                started = true;
                stringBuilder.append(result[i]);
            } else {
                stringBuilder.append(result[i]);
            }
        }
        System.out.println(stringBuilder.toString());
//还把0的情况 输出成了 空。。。
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }

    private int getIntValue(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(234 * 78);
    }
}
