package com.yt;

import com.yt.db.mybatis.MybatisOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * testng demo
 * idea 的话 需要 在右上角 配置那里 ->configuration->listeners->use default reporters打勾 才能自动生成 报告文件
 * Created by yantong on 2018/11/13.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YtApplicationNGTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MybatisOperationService mybatisOperationService;

    @Test
    public void testTest() throws Exception{
        int addedCount = mybatisOperationService.addDuiXiang(null);
        Assert.assertEquals(0, addedCount);
    }
}