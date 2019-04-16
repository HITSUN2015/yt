package com.yt.design.pattern.action.observer;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 上午9:16
 * @desc 这个模式 是我最初接触到的 感觉 最有科技含量的模式了,但是 一直也没弄透
 *
 * 这次,想分析清楚,这个模式涉及的概念的边界,来理解这个模式:
 *
 * 主题:{@link Subject}
 *      职能1:管理 主题本身的 观察者
 *      职能2:通知 {@link Subject#notifyAllObservers()}
 *
 *      这里在处理有多种事件时,显而易见的有两种实现方式:
 *           方式1:直接在{@link Observer}中 提供多个非事件相关参数的方法,需要观察者去根据需求实现
 *           方法2:直接在一个方法里 给出事件参数和 必要的 业务参数
 *      个人理解:如果没有业务参数,那么,就用方法二,Observer 基础类会干净些
 *              如果有业务参数,就提供多个方法,这样每个观察者的各个监听方法,参数明确都有业务意义
 *
 * 观察者:{@link Observer} [多个]
 *      职能1:管理 主题   这里 除了为了 记录哪个subject的信息,我不知道为什么要存 主题。。。TODO 多个主题?
 *      职能2:实现 主题事件 TODO 多个主题
 *
 *
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
