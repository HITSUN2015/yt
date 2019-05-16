package com.yt.coding.pattern.action.command;

import com.yt.coding.pattern.action.command.bad.Command;
import com.yt.coding.pattern.action.command.bad.Receiver;
import com.yt.coding.pattern.action.command.bad.Sender;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CommandPatternIntroduceTest {

    @Test
    public void testBad() {
        Sender sender = new Sender();

        Command command = new Command();

        Receiver receiver = new Receiver();


    }
}