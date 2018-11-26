package com.yt.tool;

import com.alibaba.fastjson.JSONObject;
import com.yt.tool.modal.TestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by yantong on 2018/11/21.
 */
public class JSONUtilTest{

    private final String JSONSTRING = "{\"dataIds\":\"fsdaf\",\"deviceSerial\":\"testDeviceSerial\",\"eventEnum\":\"testEventEnum\",\"eventId\":\"testEventId\",\"opTime\":1543210744501,\"retryTime\":3}";

    private TestClass tmpTC = null;

    @Test
    public void jsonObject(){
        TestClass testClass = JSONObject.parseObject(JSONSTRING, TestClass.class);
        tmpTC = testClass;
        Assert.assertNotEquals(null, testClass);
    }

    @Test(dependsOnMethods = "jsonObject")
    public void Object2Json(){
        String jsonString = JSONObject.toJSONString(tmpTC);
        Assert.assertEquals(jsonString, JSONSTRING);
    }

}
