package com.yt.arithmetic.sort;

import com.yt.arithmetic.sort.solutions.*;

/**
 * Created by yantong on 2019/3/25.
 */
public class SorterFactory {

    public static Sortable getSorter(SortType sortType) {
        if (null == sortType) {
            throw new IllegalArgumentException("sortType is null");
        }
        // TODO: 2019/3/25 把这个改成反射 可以省去代码
        switch (sortType) {
            case BUBBLE:
                return new BubbleSorter();
            case SELECTION:
                return new SelectionSorter();
            case INSERTION:
                return new InsertionSorter();
            case SHELL:
                return new ShellSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();

            // TODO: 2019/3/26 heap
            case COUNTING:
                return new CountingSorter();
//            case BUCKET:
//                return new BucketSorter();
        }
        throw new IllegalArgumentException("不存在对应实现,sortType:" + sortType);
    }
}
