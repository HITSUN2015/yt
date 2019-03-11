package com.yt.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yantong on 2018/12/17.
 */
@Test
public class SpringUtilTest {

    @Test
    public void testStringCompare() {
        List<String> testString = new ArrayList<String>() {{
            add("123");
            add(null);
            add("434");
        }};
        testString.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return StringUtil.compareIntegerString(o1, o2);
            }
        });
        for (String s : testString) {
            System.out.println(s);
        }
    }

    @Test
    public void testJoin() {
        String[] strs = new String[]{"aaa", "bbb", "ccc"};
        String result = StringUtil.joinWithSeperator(strs, ",");
        Assert.assertEquals(result, "aaa,bbb,ccc");
        strs = new String[]{""};
        result = StringUtil.joinWithSeperator(strs, ",");
        Assert.assertEquals(result, "");
        strs = null;
        result = StringUtil.joinWithSeperator(strs, ",");
        Assert.assertEquals(result, "");
        strs = new String[]{};
        result = StringUtil.joinWithSeperator(strs, ",");
        Assert.assertEquals(result, "");
    }
}