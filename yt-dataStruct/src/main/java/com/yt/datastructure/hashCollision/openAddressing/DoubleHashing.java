package com.yt.datastructure.hashCollision.openAddressing;

/**
 * Created by yantong on 2019/4/8.
 *
 * 也称 Rehashing
 *
 * 有一个包含一组哈希函数 H1...Hn 的集合。
 *      当需要从哈希表中添加或获取元素时，首先使用哈希函数 H1。
 *      如果导致冲突，则尝试使用 H2，以此类推，直到 Hn。
 *      所有的哈希函数都与 H1 十分相似，不同的是它们选用的乘法因子（multiplicative factor）
 * 
 * .net:Hk(key) = [GetHash(key) + k * (1 + (((GetHash(key) >> 5) + 1) % (hashsize – 1)))] % hashsize
 */
public class DoubleHashing extends OpenAddressing {

    @Override
    int probing(int i) {
        // TODO: 2019/4/8
        return -1;
    }
}
