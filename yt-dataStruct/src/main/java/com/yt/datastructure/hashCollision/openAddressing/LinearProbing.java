package com.yt.datastructure.hashCollision.openAddressing;

/**
 * Created by yantong on 2019/4/8.
 *
 * 线性探测
 */
public class LinearProbing extends OpenAddressing {

    //序列类似：1,2,3...
    @Override
    int probing(int i) {
        return i;
    }
}
