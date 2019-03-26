package com.yt.datastructure.util;

import com.yt.util.ClassUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by yantong on 2019/3/1.
 */
@Test
public class ClassUtilTest {

    @Test
    public void testInstance() {
        TestBean tb = new TestBean("test name");
        boolean result = ClassUtil.isInstance(TestBean.class, tb);
        Assert.assertEquals(true, result);
        Assert.assertEquals(false,  ClassUtil.isInstance(Date.class, tb));
    }

    private class TestBean {
        private String name;

        public TestBean(String name) {
            this.name = name;
        }
    }
}
