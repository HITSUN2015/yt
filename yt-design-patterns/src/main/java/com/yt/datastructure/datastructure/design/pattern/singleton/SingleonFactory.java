package com.yt.datastructure.datastructure.design.pattern.singleton;/**
 * Created by SUN on 19/3/3.
 */

/**
 * @author SUN
 * @create 2019-03-03 下午4:16
 * @desc 单例
 */
public class SingleonFactory {

    private static Instance instance;

    public SingleonFactory() {
    }

    public static Instance getInstance() {
        //为了效率 快速返回
        if (null == instance) {
            synchronized (SingleonFactory.class) {
                /**
                 * 未初始化前就高并发的情况下
                 * 会有多个线程到达这一步
                 * 如果不判断 直接new 会多次执行对象的初始化动作,降低启动速度(到达这一步的所有线程均需new对象)
                 */
                if (null == instance) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
