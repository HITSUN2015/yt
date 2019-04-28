package com.yt.coding.pattern.action.observer.bad;

/**
 * @author SUN
 * @create 2019-04-26 下午1:55
 * @desc Sender状态变更时，收消息
 */
public class Receiver {

    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
