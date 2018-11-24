package com.yt.tool;

import com.yt.db.mybatis.MybatisOperationService;
import com.yt.db.mybatis.MybatisOperationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2018/11/14.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class log4j2Slf4jUtilTest extends AbstractTestNGSpringContextTests {

    private static org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger("fileLogger");
    private static org.slf4j.Logger classSlf4jLogger = LoggerFactory.getLogger(MybatisOperationServiceImpl.class);
    private static org.apache.logging.log4j. Logger log4j2Logger = LogManager.getLogger("fileLogger");
    private static org.apache.logging.log4j. Logger classLog4j2Logger = LogManager.getLogger(MybatisOperationServiceImpl.class);

    @Test
    public void testTest() {
        //测试 slf4j 数字替换
        slf4jLogger.error("slf4jLogger test slf4jLogger {}", 431423);
        //测试 slf4j string 替换， 异常打印
        classSlf4jLogger.error("classSlf4jLogger test {} classSlf4jLogger", "test431423test", new Exception("testException"));
        log4j2Logger.error("log4j2Logger test log4j2Logger");
        classLog4j2Logger.error("classLog4j2Logger test classLog4j2Logger");
    }
}
