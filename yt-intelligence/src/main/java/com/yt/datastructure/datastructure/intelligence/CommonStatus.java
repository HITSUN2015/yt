package com.yt.datastructure.datastructure.intelligence;

/**
 * Created by yantong on 2019/1/8.
 * 通用类：状态信息
 */
public enum CommonStatus {
    POSITIVE(1),    //正面的状态
    NEGATIVE(-1),   //负面的状态
    ;

    private int status;

    private CommonStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}
