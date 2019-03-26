package com.yt.datastructure.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.collection.theory.datastruct.跳跃表;
import com.yt.datastructure.collection.theory.tread.CAS;

/**
 * @author SUN
 * @create 2018-03-20 下午8:22
 * @desc
 */
public class ConcurrentSkipListMap implements 跳跃表,CAS {
    /**
     * 引用 : https://my.oschina.net/jingshishengxu/blog/14645
     * ConcurrentSkipListMap有几个ConcurrentHashMap 不能比拟的优点：
     *  1、ConcurrentSkipListMap 的key是有序的。
     *  2、ConcurrentSkipListMap 支持更高的并发。ConcurrentSkipListMap 的存取时间是log（N），和线程数几乎无关。也就是说在数据量一定的情况下，并发的线程越多，ConcurrentSkipListMap越能体现出他的优势。
     *     eg:在4线程1.6万数据的条件下，ConcurrentHashMap 存取速度是ConcurrentSkipListMap 的4倍左右。
     *
     * 实现时,用了ArrayList,但是并未用作其存储使用的数据结构,所以不继承自ArrayList
     */
}
