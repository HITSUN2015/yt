package com.yt.datastructure.hashCollision.openAddressing;

/**
 * Created by yantong on 2019/4/8.
 */
public abstract class OpenAddressing {

    Integer[] datas = new Integer[]{1, 2, null, 3};

    //本文采用了 https://blog.csdn.net/litchi_yang/article/details/80059840
    //至于probing从1->m-1 和具体的 probing实现方式，都应该是个demo，实际情况，应该也可以变通
    protected int hash(int key){
        for (int i = 1; i < datas.length; i++) {
            int index = key + probing(i) % datas.length;
            if (datas[index] == null) {
                return index;
            }
        }
        return -1;//
    }

    abstract int probing(int i);

}
