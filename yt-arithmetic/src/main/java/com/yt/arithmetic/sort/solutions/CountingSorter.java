package com.yt.arithmetic.sort.solutions;

import com.yt.arithmetic.sort.Sortable;
import com.yt.arithmetic.sort.anylisis.ComplexityType;
import com.yt.arithmetic.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/26.
 *
 * 这个限制比较多
 * 原理是：对于离散集合，找到所有元素值，排序，然后统计每个值的个数，再填充回原集合
 */
public class CountingSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {
    @Override
    public ComplexityType getTimeComplexity() {
        return null;
    }

    @Override
    public ComplexityType getSpaceComplexity() {
        return null;
    }

    @Override
    public boolean canBeStable() {
        return false;
    }

    @Override
    protected int[] customerSort(int[] datas) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < datas.length; i++) {
            if (datas[i] < min) {
                min = datas[i];
            }
            if (datas[i] > max) {
                max = datas[i];
            }
        }

        int[] couting = new int[max - min + 1];
        for (int i = 0; i < datas.length; i++) {
            couting[datas[i] - min] = couting[datas[i] - min] + 1;
        }

        int index = 0;
        for (int i = 0; i < couting.length; i++) {
            int value = i + min;
            int count = couting[i];
            for (; count > 0; count--) {
                datas[index++] = value;
            }
        }

        return datas;
    }
}
