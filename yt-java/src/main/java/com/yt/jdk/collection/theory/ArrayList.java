package com.yt.jdk.collection.theory;

import com.yt.datastructure.Array;
import com.yt.jdk.collection.theory.tread.FailFast机制;

/**
 * @author SUN
 * @create 2018-03-20 下午12:48
 * @desc
 */
public class ArrayList implements Array, FailFast机制, 动态 {

    @Override
    public String 如何动态() {
        return "\n1.无参构造时,是个空的 : " +
                "\n         private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};" +
                "\n         this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;" +
                "\n2.第一次添加元素时,会初始化为大小为10的数组 :" +
                "\n         private static final int DEFAULT_CAPACITY = 10;" +
                "\n         if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {" +
                "\n            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);" +
                "\n         }" +
                "\n3.扩容变成1.5倍,最大是Interger.Max_value 2147483647,拷贝旧数据" +
                "\n         int newCapacity = oldCapacity + (oldCapacity >> 1)" +
                "\n         elementData = Arrays.copyOf(elementData, newCapacity);" +
                "\n所以,在初始化时,如果确定数组的大小的大致范围," +
                "\n         1.调用含参构造方法" +
                "\n         2.在添加大量元素前，可以使用 ensureCapacity";

    }

}
