package com.yt.solutions.string;/**
 * Created by SUN on 19/3/20.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-20 下午7:47
 * @desc
 */
public class ValidPalindromeTest {

    @Test
    public void test() {
        ValidPalindrome solution = new ValidPalindrome();
        boolean result = solution.isPalindrome("1b1");
        System.out.println(result);
    }
}
