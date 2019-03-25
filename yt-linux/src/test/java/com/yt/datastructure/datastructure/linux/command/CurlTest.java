package com.yt.datastructure.datastructure.linux.command;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/22.
 */
@Test
public class CurlTest {

    @Test
    public void testGet() {
        String expect = "curl '10.97.103.66:8080/v3/testUrlAndParams' -H 'zuulUserId:ttttttt'";
        Curl curl = new Curl("10.97.103.66", 8080, "/v3/testUrlAndParams");
        curl.setHeader("zuulUserId", "ttttttt");
        String result = curl.buildResult();
        Assert.assertEquals(expect, result);
    }
}
