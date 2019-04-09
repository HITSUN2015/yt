package com.yt.demo.helper.util.print;/**
 * Created by SUN on 19/4/7.
 */

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @create 2019-04-07 上午10:10
 * @desc
 */
public class PrintHelperTest {

    @Test
    public void testPrint() {
        SequenceDiagram sd = new SequenceDiagram();
        Map<String, LifeLine> lifeLineMap = new HashMap<>();

        LifeLine lifeLine1= new LifeLine();
        lifeLine1.setClassName("testClass1");
        lifeLine1.setPackagePath("testClass1Package");
        lifeLineMap.put(lifeLine1.getFullKey(), lifeLine1);

        LifeLine lifeLine2= new LifeLine();
        lifeLine2.setClassName("testClass2");
        lifeLine2.setPackagePath("testClass2Package");
        lifeLineMap.put(lifeLine2.getFullKey(), lifeLine2);

        LifeLine lifeLine3= new LifeLine();
        lifeLine3.setClassName("testClass3");
        lifeLine3.setPackagePath("testClass3Package");
        lifeLineMap.put(lifeLine3.getFullKey(), lifeLine3);

        sd.setLifeLineMap(lifeLineMap);

        List<LifePointer> pointers = new ArrayList<>();
        pointers.add(new LifePointer(lifeLine1.getFullKey(), lifeLine2.getFullKey()));
        pointers.add(new LifePointer(lifeLine2.getFullKey(), lifeLine3.getFullKey()));
        sd.setPointers(pointers);
        System.out.println(PrintHelper.printStack(sd));
    }
}
