package com.yt.arithmetic.sort.solutions;

import com.yt.arithmetic.sort.Sortable;
import com.yt.arithmetic.sort.anylisis.ComplexityType;
import com.yt.arithmetic.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/26.
 * 
 * // TODO: 2019/3/26
 */
public class HeapSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {
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
        return new int[0];
    }
}
