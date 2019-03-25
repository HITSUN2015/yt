package com.yt.datastructure.datastructure.datastruct;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/14.
 */
@Test
public class TestDataStructure {

    @Test
    public void testDemo() {
        for (DataStructureEnum dataStructureEnum : DataStructureEnum.values()) {
            System.out.println("测试 " +  dataStructureEnum.getName());
            DataStructure dataStructure = DataStructureFactory.getDataStructure(dataStructureEnum);
            dataStructure.demo();
            System.out.println("\n");
        }
    }


}
