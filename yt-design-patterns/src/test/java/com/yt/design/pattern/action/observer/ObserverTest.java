package com.yt.design.pattern.action.observer;/**
 * Created by SUN on 19/3/23.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-23 下午9:05
 * @desc
 */
public class ObserverTest {

    @Test
    public void test() {
        Subject subject = new Subject();

        new OctalObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
