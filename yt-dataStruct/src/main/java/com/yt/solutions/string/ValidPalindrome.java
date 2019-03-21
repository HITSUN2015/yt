package com.yt.solutions.string;

import com.yt.leetcode.LeetCode;

/**
 * Created by yantong on 2019/3/20.
 */
public class ValidPalindrome implements LeetCode{
    @Override
    public int getProblemNumber() {
        return 125;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //这题 看半天 没看懂，原来是 去掉 符号 空格是 回文的。。。
    //alphanumeric 这个单词是 包括 文字和数字。。。
    //另外 两个index 往中间跑 别忘了 远处index 各种情况都要--
    //还有两个索引,要特殊考虑相遇的情况
    //后来 添加 数字规则的时候,没有考虑到 两次条件 不一致,导致有一次没ac,
    // 在找到问题的原因时,一定要回到环境仔细分析下,这种找到bug 时 容易掉以轻心
    public boolean isPalindrome(String s) {

        if (null == s || s.isEmpty()) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int j = chars.length - 1;

        boolean result = true;
        for(int i = 0; i < j ; i++) {
            if (Character.isAlphabetic(chars[i]) || Character.isDigit(chars[i])) {
                while (!Character.isAlphabetic(chars[j]) && !Character.isDigit(chars[j])) {
                    j--;
                }
                if (j > i) {
                    if (chars[i] != chars[j]) {
                        return false;
                    }
                    j--;
                }
            }
        }

        return true;
    }

}
