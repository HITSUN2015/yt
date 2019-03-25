package com.yt.datastructure.datastructure.jvm.memory;/**
 * Created by SUN on 18/3/14.
 */

/**
 * @author SUN
 * @create 2018-03-14 下午10:32
 * @desc stackOverFlow 异常demo
 */
public class SOFByStack {
    public static int stackLenth = 0;
    public static void test(){
        stackLenth ++ ;
        test();
    }


    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable ex) {
            System.out.println("stack length:" + stackLenth);
//            ex.printStackTrace();
        }
    }
}
