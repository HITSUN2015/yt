package com.yt.datastructure.datastructure.jvm.gc;

/**
 * Created by yantong on 2019/3/11.
 */
public class BigMemeryObject {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }
}
