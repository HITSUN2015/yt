package com.yt.coding.pattern.action.observer;

import com.yt.coding.pattern.action.observer.bad.Receiver;
import com.yt.coding.pattern.action.observer.bad.Sender;
import org.assertj.core.util.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * {@link ObserverPatternIntroduce}
 */
public class ObserverPatternIntroduceTest {


    @Test
    public void testBad() {
        Sender sender = new Sender();

        Receiver receiver = new Receiver();

        sender.sendMessToReceiver("test", receiver);
    }

    @Test
    public void testRequirment1Bad() {
        //factory 一下制造多个
        Sender sender1 = new Sender();
        Sender sender2 = new Sender();
        Sender sender3 = new Sender();
        Sender sender4 = new Sender();
        //...
        Sender sender5 = new Sender();

        Receiver receiver = new Receiver();

        //
        final String message = "test";
        List<String> messList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            messList.add(message + new Random().nextInt());
        }
        //这里当然实现发送不同的 message 如果message种类是有限的，也暂时归为不同的message
        sender1.sendMessToReceiver(messList.get(0), receiver);
        sender2.sendMessToReceiver(messList.get(1), receiver);
        sender3.sendMessToReceiver(messList.get(2), receiver);
        sender4.sendMessToReceiver(messList.get(3), receiver);
        //...
        sender5.sendMessToReceiver(messList.get(4), receiver);
    }



}