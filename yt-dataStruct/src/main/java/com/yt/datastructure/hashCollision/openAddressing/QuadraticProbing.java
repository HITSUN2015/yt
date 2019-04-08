package com.yt.datastructure.hashCollision.openAddressing;

/**
 * Created by yantong on 2019/4/8.
 *
 * 二次探测
 */
public class QuadraticProbing extends OpenAddressing{

    //数列类似：1,-1,2,-2,4,-4...
    @Override
    int probing(int i) {
        //可能有更好的 TODO
        return ((i & 1)== 1) ? i * i >> 2 : -i * i >> 2;
    }
}
