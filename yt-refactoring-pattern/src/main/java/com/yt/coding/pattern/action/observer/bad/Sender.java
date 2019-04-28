package com.yt.coding.pattern.action.observer.bad;

/**
 * @author SUN
 * @create 2019-04-26 下午1:54
 * @desc 状态变更时，发送消息
 */
public class Sender {

    public void sendMessToReceiver(String message, Receiver receiver) {
        if (null == receiver || null == message || message.trim().isEmpty()) {
            return;
        }
        receiver.receiveMessage(message);
    }

}
