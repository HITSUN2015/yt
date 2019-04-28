package com.yt.coding.pattern.action.observer.analysis;

import java.util.List;

/**
 * @author SUN
 * @create 2019-04-28 下午7:52
 * @desc
 * TODO
 */
public class TestMethodSignature {

    public void test(List<ObserverAnalysisMessage> m) {
        m.stream().forEach(x -> System.out.println(x));
    }

//    public void test(List<ObserverAnalysisReceiver> m) {
//        m.stream().forEach(x -> System.out.println(x));
//    }
}
