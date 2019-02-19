package com.yt.db.mybatis.domain;

/**
 * Created by yantong on 2018/11/12.
 */
public class DuiXiang {

    private String shuxing;

    private void fangfa(){
        System.out.println("方法被调用");
    }

    public String getShuxing() {
        return shuxing;
    }

    public void setShuxing(String shuxing) {
        this.shuxing = shuxing;
    }

    @Override
    public String toString() {
        return "DuiXiang{" +
                "shuxing='" + shuxing + '\'' +
                '}';
    }
}
