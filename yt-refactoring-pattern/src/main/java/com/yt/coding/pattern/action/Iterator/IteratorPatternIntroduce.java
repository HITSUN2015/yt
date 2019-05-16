package com.yt.coding.pattern.action.Iterator;

/**
 * @author SUN
 * @create 2019-04-29 下午3:06
 * @desc
 *
 * Sender
 * Receiver
 * Message
 * 这个实际上也是三者的交互
 *
 * 区别于 Observer 同时向多个Receiver发送消息的 push
 * 这个模式 是按需发送消息，由Receiver来 pull
 * 这个pull的动作，借由Iterator来实现
 *
 * 要支持Sender：Receiver 1：n的数量关系，所以 Sender 与 Fetcher 1：n
 * 关于关联关系，由于内部的数据结构只有Sender知道，所以，
 *  如果想作为框架供别人使用，Fetcher Sender与Fetch偏向于组合的关系
 *  但是可能依赖关系，更具扩展性
 *  从使用的角度考虑，当然是组合的关系更好了
 *  所以这里选择了组合关系 作为demo
 *  Fetter个人认为，实际只提供遍历元素的一种方式即可，
 *      如果是顺序遍历需要提供next、curValue等接口
 *
 *  这里关于 Message、Sender、Fetter的关联关系，并不想太复杂
 *      由于receiver是拿着Fetter去操作数据，所以Fetter必须有有原数据的引用或copy
 *      由于这个模式Receiver大多数是框架的使用者，所以，不显式的提供Receiver
 *
 *      事实上 这个已经类似kafka了
 */
public class IteratorPatternIntroduce {
}
