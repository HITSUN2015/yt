package com.yt.coding.pattern.create.abstractFactory;

import org.testng.annotations.Test;

import java.util.Date;

public class ZooTest {


    private String monkey;
    private Date fish;
    private String lion = "辛巴";

    @Test
    public void test() {
        monkey = "美猴王";
        System.out.println(monkey + fish + "一起愉快的玩耍");
    }

    @Test
    public void test2() {
        String cat = "加菲猫";
        monkey = "孙悟空";
        System.out.println(cat + lion + monkey + fish + "一起看复仇者联盟四");
    }
}