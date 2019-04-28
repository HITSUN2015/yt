package com.yt.coding.pattern.action.observer.analysis;

import java.util.List;

/**
 * @author SUN
 * @create 2019-04-28 下午7:29
 * @desc
 *
 * 采用dependency实现，所以没有属性
 *
 * 由于 发消息在语义上动作的主语是 Sender，所以把方法放在这个类里
 * 当然 语文这东西，也可以说收消息，就变成了receiver是主语，所以，二者的主被动，很多情况可能和作者的编程当时的思路表达有关系
 *   实际上更依赖于，实现这个方法所以来的成员，大多在哪个类里，但如果是特别简单的方法，转换应该也是很方便的。
 */
public class ObserverAnalysisSender {

    /**
     * 思考这样一句话：一个Sender可以【同时】发送多种Message吗？好像可以，不严格支持也行吧？
     * 思考这样一句话：一个Message可以【同时】被多个Sender发送吗？好像真的不必
     * 综上 在senderMessage这个级别 Sender对应Message是1：n 或 1：1
     * 所以Sender对应Message Sender是驱动类
     * @param messages
     */
    @Deprecated
    public void sendMessageWithMessage(List<ObserverAnalysisMessage> messages) {

    }

    /**
     * 思考这样一句话：一个Sender可以【同时】给多个Receiver发送消息吗？好像可以，好像也不必严格支持
     * 思考这样一句话：一个Receiver可以【同时】被多个Sender发送消息吗？好像不是必须的
     * 综上 SenderMessage这个级别，Sender对应Receiver是1：1 或1：n
     * 所以Sender 对应 Receiver，Sender是驱动类
     * @param receivers
     */
    @Deprecated
    public void sendMessageToReceiver(List<ObserverAnalysisReceiver> receivers) {

    }

    /**
     * 由于 {@link ObserverAnalysisSender#sendMessageWithMessage}
     *      {@link ObserverAnalysisSender#sendMessageToReceiver}
     * 都是1：n，但是Message 和 Receiver 也有数量关系，这样写就会引发对应关系的矛盾
     *
     * 思考这样一句话：Receiver收消息时，可以同时收多条消息吗?好像不必
     * 思考这样一句话：一个消息，可以被多个Receiver同时收到吗？好像可以呀~，也可以不实现~
     * 综上 Message对应Receiver是 1：1 或 1：n
     *
     * Sender   - - 1 - - - - - - - - - - - - - - p Message
     *   |                                           |
     *
     *   |- -1- - - n -Receiver- - - n - - - - -1 - -|
     *
     * 由于这里的1：n都并非严格要求
     * 在考虑三处n的情况，究竟哪个是最不必须被需要的扩展：
     * 1.一个Sender可以同时发送多个Message？
     * 2.一个Sender可以同时发给多个Receiver？
     * 3.一个Message可以同时发给多个Receiver？
     *   这仨对比，至少发现了，有两个需求是 通知发送给多个Receiver，有两个需要是同时由一个Sender发出
     *
     *
     *   从另一个角度，先找出当下的主语：Sender 再找出当下的宾语：Receiver
     *               由Sender->Receiver这条路，只需 n
     *               由Sender->Message->Receiver这条路：p*n
     *               那么 把p化成1可以很容易统一对应关系：
     *
     * Sender   - - 1 - - - - - - - - - - - - - - 1 Message
     *   |                                           |
     *
     *   |- -1- - - n -Receiver- - - n - - - - -1 - -|
     *
     * 这样，找出了一个有利于扩展的1：1的一个关系，从而化简了复杂度：
     *
     * Sender/Message(1:1)
     *   |
     *
     *   |- -1- - - n -Receiver
     *
     *
     * 写代码我建议这样写：方法名是动词，第一个参数是宾语，后跟状语、定语
     *
     */
    public void sendMessage(List<ObserverAnalysisReceiver> receivers, ObserverAnalysisMessage message) {
        receivers.forEach(x-> x.receiveMessage(message));
    }
}
