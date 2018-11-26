package com.yt;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * testng demo
 * idea 的话 需要 在右上角 配置那里 ->configuration->listeners->use default reporters打勾 才能自动生成 报告文件
 * Created by yantong on 2018/11/13.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest extends AbstractTestNGSpringContextTests {

}