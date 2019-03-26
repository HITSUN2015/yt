package com.yt.datastructure.datastruct;

/**
 * Created by yantong on 2019/2/14.
 * 类型相同的元素构成一个线性集合，连续占用一整块内存空间
 * 由于此数据结构非常基础，且通用，所以大多数语言都会实现它
 *

 优点：
 1、按照索引查询元素速度快
 2、按照索引遍历数组方便
 缺点：
 1、数组的大小固定后就无法扩容了
 2、数组只能存储一种类型的数据
 3、添加，删除的操作慢，因为要移动其他的元素。

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
