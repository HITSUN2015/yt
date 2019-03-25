package com.yt.datastructure.sort;

import com.yt.datastructure.datastructure.sort.SortType;
import com.yt.datastructure.datastructure.sort.Sortable;
import com.yt.datastructure.datastructure.sort.SorterFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/25.
 */
@Test
public class SortTest {

    @Test
    public void testIllegalArguments() {
        int[] sourceDatas = null;
        int[] destinyDatas = null;
        compare(sourceDatas, destinyDatas);
    }

    @Test
    public void testEmptyArguments() {
        int[] sourceDatas = new int[0];
        int[] destinyDatas = new int[0];
        compare(sourceDatas, destinyDatas);
    }

    @Test
    public void testOneArguments() {
        int[] sourceDatas = new int[]{1};
        int[] destinyDatas = new int[]{1};
        compare(sourceDatas, destinyDatas);
    }

    @Test
    public void testNormal() {
        int[] sourceDatas = new int[]{90,4,3,5,0,-1};
        int[] destinyDatas = new int[]{-1,0,3,4,5,90};
        compare(sourceDatas, destinyDatas);
    }

    private void compare(int[] datas, int[] destinyDatas) {
        SortType[] types = SortType.values();
        //由于很多排序是原地排序，所以会改变原始值，从而影响别的排序方法的测试正确性，所以新建
        for (int i = 0; i < types.length; i++) {
            Sortable sorter = SorterFactory.getSorter(types[i]);
            int[] copy = getCopy(datas);
            int[] sortedDatas = sorter.sort(copy);
            boolean result = compareArray(sortedDatas, destinyDatas);

            //多线程 没用 TODO testng
//            Thread thread = new Thread(()->{
//            try {
                Assert.assertEquals(result, true, sorter.getClass().toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
        }
    }

    private boolean compareArray(int[] sortedDatas, int[] destinyDatas) {
        if (destinyDatas == null && sortedDatas == null) {
            return true;
        }
        if (destinyDatas == null && sortedDatas != null) {
            return false;
        }

        for (int i = 0; i < destinyDatas.length; i++) {
            if (sortedDatas[i] != destinyDatas[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCopy(int[] datas) {
        if (null == datas) {
            return null;
        }
        int[] c = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            c[i] = datas[i];
        }
        return c;
    }

}
