package com.yt.coding.pattern.action.command;/**
 * Created by SUN on 19/3/23.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-23 下午9:55
 * @desc
 */
public class CommandTest {

    @Test
    public void test() {
        Receiver receiver = new Receiver();

        CommandA commandA = new CommandA(receiver);
        CommandB commandB = new CommandB(receiver);

        Invoker invoker = new Invoker();
        invoker.addOrder(commandA);
        invoker.addOrder(commandB);

        invoker.placeOrders();
    }
}
