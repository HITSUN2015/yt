package com.yt.coding.pattern.action.observer;

import com.yt.coding.pattern.PatternDimension;

/**
 * @author SUN
 * @create 2019-04-26 下午1:59
 * @desc
 *
 * 发消息，最简单的代码，应该会有如下对象了，他们的交互，给在了test里
 * {@link com.yt.coding.pattern.action.observer.bad.Receiver}
 * {@link com.yt.coding.pattern.action.observer.bad.Sender}
 *
 * 然后
 */
public class ObserverPatternIntroduce implements PatternDimension {

    @Override
    public String[] pattenNames() {
        return "Observer,Dependents,Publish-Subscribe".split(",");
    }

    @Override
    public String goal() {
        return "定义对象的一种一对多的依赖关系，" +
                "当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并自动更新";
    }

    @Override
    public String[] advantages() {
        return new String[0];
    }

    @Override
    public String[] weakness() {
        return new String[0];
    }
}
