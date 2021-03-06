package com.yt.datastructure.serialize;

import com.yt.serialize.CustomerObject;
import com.yt.serialize.SerializeUtil;
import com.yt.serialize.jdk.JavaIOSerialize;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/19.
 */
@Test
public class SerializeUtilTest {

    @Test
    public void testSerializeAndDeserialize() {
        CustomerObject customerObject = new CustomerObject("fieldValue");
        SerializeUtil serializeUtil = new JavaIOSerialize();
        String serializedString = serializeUtil.serialize(customerObject);
        System.out.println(serializedString);

        CustomerObject deserializedObject = serializeUtil.deserialize(serializedString, CustomerObject.class);
        System.out.println(deserializedObject);
    }
}
