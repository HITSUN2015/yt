package com.yt.design.pattern.action.command;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:49
 * @desc
 */
public class CommandB implements Command {

    private Receiver receiver;

    public CommandB(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute() {
        receiver.b();
    }
}
