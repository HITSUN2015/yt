package com.yt.linux;
/**
 * Created by yantong on 2019/3/22.
 */
public enum ResultEnum {
    OK(1),
    ERROR(-1),
    ;

    private int value;

    ResultEnum(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

}
