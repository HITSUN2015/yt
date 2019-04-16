package com.yt.coding.pattern.action.command;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:49
 * @desc
 */
public class Receiver {

    private String name = "ABC";

    private int quantity = 10;

    public void a(){
        System.out.println("Receiver [ Name: " + name + ",Quantity: " + quantity +" ] bought");
    }
    public void b(){
        System.out.println("Receiver [ Name: " + name + ",Quantity: " + quantity +" ] sold");
    }
}