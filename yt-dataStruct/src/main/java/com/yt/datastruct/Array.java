package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.
 * 类型相同的元素构成一个线性集合，连续占用一整块内存空间
 * 由于此数据结构非常基础，且通用，所以大多数语言都会实现它
 *
 * 优点：根据索引查询元素快
 * 缺点：增加删除操作，因为需要移动其他元素，效率较低
 */
public class Array implements DataStructure{

    @Override
    public void demo() {
        String[] stringArray = new String[8];
        String[] stringArray2 = new String[] {"test", "test2"};

        for(int i = 0; i< stringArray2.length ; i ++) {
            System.out.println(stringArray2[i]);
        }

        for (String itemValue : stringArray2) {
            System.out.println(itemValue);
        }
    }
}
