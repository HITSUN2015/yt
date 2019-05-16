package com.yt.coding.pattern.action.chainOfResponsibility;

import com.yt.coding.pattern.action.chainOfResponsibility.analysis.ChainAnalysisEvent;
import com.yt.coding.pattern.action.chainOfResponsibility.analysis.ChainAnalysisHandler;
import com.yt.coding.pattern.action.chainOfResponsibility.bad.Event;
import com.yt.coding.pattern.action.chainOfResponsibility.bad.Handler;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChainOfResponsibilityPatternIntroduceTest {

    @Test
    public void testBad() {
        Event event1 = new Event();

        Handler handler1 = new Handler();
        Handler handler2 = new Handler();
        Handler handler3 = new Handler();
        Handler handler4 = new Handler();
        Handler handler5 = new Handler();

        handler1.handle(event1);
        handler2.handle(event1);
        handler3.handle(event1);
        handler4.handle(event1);
        handler5.handle(event1);

        Event event2 = new Event();
        handler1.handle(event2);
        handler2.handle(event2);
        handler3.handle(event2);
        handler4.handle(event2);
        handler5.handle(event2);
    }

    @Test
    public void testBetter() {
        ChainAnalysisHandler handler1 = new ChainAnalysisHandler();
        ChainAnalysisHandler handler2 = new ChainAnalysisHandler();
        ChainAnalysisHandler handler3 = new ChainAnalysisHandler();
        ChainAnalysisHandler handler4 = new ChainAnalysisHandler();
        ChainAnalysisHandler handler5 = new ChainAnalysisHandler();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);
        handler4.setNextHandler(handler5);

        ChainAnalysisEvent event1 = new ChainAnalysisEvent();

        handler1.handle(event1);

        ChainAnalysisEvent event2 = new ChainAnalysisEvent();
        handler1.handle(event2);
    }

}