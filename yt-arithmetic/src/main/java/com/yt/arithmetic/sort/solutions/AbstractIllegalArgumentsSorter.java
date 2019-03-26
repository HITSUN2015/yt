package com.yt.arithmetic.sort.solutions;

import com.yt.arithmetic.sort.Sortable;

/**
 * Created by yantong on 2019/3/25.
 */
public abstract class AbstractIllegalArgumentsSorter implements Sortable{

    @Override
    public int[] sort(int[] datas) {
        if (null == datas || datas.length == 0) {
            return datas;
        }

        return customerSort(datas);
    }

    protected abstract int[] customerSort(int[] datas);
}
