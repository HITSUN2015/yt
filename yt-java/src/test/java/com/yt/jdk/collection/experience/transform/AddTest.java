package com.yt.jdk.collection.experience.transform;/**
 * Created by SUN on 19/3/13.
 */

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Stopwatch;
import com.yt.jdk.collection.experience.Add;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author SUN
 * @create 2019-03-13 下午5:44
 * @desc
 */
@Test
public class AddTest {

    private static int SIZE = 20;
    private static Integer[] source = new Integer[SIZE];

    static {
        for(;SIZE > 0;) {
            source[--SIZE] = SIZE;
        }
    }

    @Test
    public void testAddElements() {
        List list = Lists.newArrayList();
        Stopwatch stopwatch = Stopwatch.createStarted();
        Add.addElementsByCollections(list, source);
//        Add.addElementsByObject(list,source);
        stopwatch.stop();
        long time = stopwatch.elapsed(TimeUnit.NANOSECONDS);
        System.out.println(time);
    }

    @Test
    public void arrayAsListAdd() {
    }
}
