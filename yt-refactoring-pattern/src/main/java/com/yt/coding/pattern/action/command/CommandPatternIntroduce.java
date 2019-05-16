package com.yt.coding.pattern.action.command;

/**
 * @author SUN
 * @create 2019-04-29 上午11:04
 * @desc
 *
 * 类比 {@link com.yt.coding.pattern.action.observer.ObserverPatternIntroduce}
 * 也是三者传递消息的模型
 *
 * Sender
 * Message
 * Receiver
 *
 * Observer富化的是 Receiver类 从而提供了sender 到 receiver 1：n的功能
 *
 * Command富化的是 Message类 从而弱化了 三者在数量关系上的扩展，至少，如果要扩展，扩展的也是Command
 *      由于是1：1：1的关系，所以各种实现，没有任何制约。谁关联谁，都很容易改变了
 *      这里描述下该模式 提供的关联关系
 *
 *
 *      但是为了凸显Command的功能，至少Command要提供一个执行相关的方法，这样在特殊需求里，可以在Command里添加 TODO
 *
 */
public class CommandPatternIntroduce {
}
