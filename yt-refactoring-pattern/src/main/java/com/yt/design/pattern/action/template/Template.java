package com.yt.design.pattern.action.template;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:28
 * @desc 感觉 就是 简单的 抽象类的应用。。。定义了 所有子类的约束
 */
public abstract class Template {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
