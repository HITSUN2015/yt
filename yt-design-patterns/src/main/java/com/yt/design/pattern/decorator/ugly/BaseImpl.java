package com.yt.design.pattern.decorator.ugly;

/**
 * Created by yantong on 2019/2/18.
 */
public class BaseImpl implements BaseInterface {

    @Override
    public void extendibleMethod() {
        System.out.println("BaseImpl extendibleMethod");
    }
}