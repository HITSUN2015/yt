package com.yt.coding.pattern.action.chainOfResponsibility.analysis;

import lombok.Data;

import java.util.Random;

/**
 * @author SUN
 * @create 2019-04-28 下午10:21
 * @desc
 */
@Data
public class ChainAnalysisHandler {

    private ChainAnalysisHandler nextHandler;

    public boolean handle(ChainAnalysisEvent event) {
        System.out.println("handler[" + this + "] event[" + event + ']');
        boolean curRes = new Random().nextBoolean();
        if (curRes) {
            return true;
        }
        if (null == nextHandler) {
            return false;
        }
        return nextHandler.handle(event);
    }
}
