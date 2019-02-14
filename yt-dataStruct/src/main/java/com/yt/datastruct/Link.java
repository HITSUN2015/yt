package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.

 优点：
 链表是很常用的一种数据结构，不需要初始化容量，可以任意加减元素；
 添加或者删除元素时只需要改变前后两个元素结点的指针域指向地址即可，所以添加，删除很快；

 缺点：
 因为含有大量的指针域，占用空间较大；
 查找元素需要遍历链表来查找，非常耗时。

 适用场景：
 数据量较小，需要频繁增加，删除操作的场景

 */
public class Link implements DataStructure{
    @Override
    public void demo() {
        System.out.println("TODO");
    }
}
