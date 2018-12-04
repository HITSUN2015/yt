package yt;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * testng demo
 * idea 的话 需要 在右上角 配置那里 ->configuration->listeners->use default reporters打勾 才能自动生成 报告文件
 * Created by yantong on 2018/11/13.
 */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@ActiveProfiles("dev")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootApplication(scanBasePackages = "yt")//spring bean加载 扫描的根路径
//@WebAppConfiguration

@Test
@WebAppConfiguration()
@ContextConfiguration("file:src/test/resources/application.yml")
public class BaseNGTest extends AbstractTestNGSpringContextTests {

}