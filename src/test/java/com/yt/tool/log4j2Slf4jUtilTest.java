package com.yt.tool;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2018/11/14.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class log4j2Slf4jUtilTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testTranceSingleLine() {

    }

    @Test
    public void testTransAllChildFile(){

    }
}
