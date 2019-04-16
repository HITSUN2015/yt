package com.yt.coding.pattern.action.command;/**
 * Created by SUN on 19/3/23.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-23 下午9:50
 * @desc
 */
public class Invoker {

    private List<Command> commandList = new ArrayList<Command>();

    public void addOrder(Command command){
        commandList.add(command);
    }

    public void placeOrders(){
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}