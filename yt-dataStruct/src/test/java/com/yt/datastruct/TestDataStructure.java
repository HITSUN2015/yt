package com.yt.datastruct;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/14.
 */
@Test
public class TestDataStructure {

    @Test
    public void testDemo() {
        for (DataStructureEnum dataStructureEnum : DataStructureEnum.values()) {
            DataStructure dataStructure = DataStructureFactory.getDataStructure(dataStructureEnum);
            System.out.println("测试 " +  dataStructureEnum.getName());
            dataStructure.demo();
        }
    }


}
