package com.yt.tool;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2018/11/21.
 */
public class JSONUtilTest{

    @Test
    public void jsonObject(){
        String addDeviceJson = "{\"channelCount\":1,\"devType\":\"CS-KW1-1A\",\"deviceName\":\"KW1(221385528)\",\"deviceSerial\":\"221385528\",\"eventEnum\":\"add_device\",\"mac\":\"54c415a0e452\",\"serial\":\"221385528\",\"userId\":\"8c0c3e4e1b02451b879584b0782b1d3a\",\"userName\":\"david007\",\"version\":\"V1.0.2 build 181102\"}";
        TestClass testClass = JSONObject.parseObject(addDeviceJson, TestClass.class);
//        TestClass testClass1 = new TestClass();
        //经测试 ali json 是基于 getSet方法的
        System.out.println(testClass.toString());
    }

}
