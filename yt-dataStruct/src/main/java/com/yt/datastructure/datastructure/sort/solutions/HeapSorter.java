package com.yt.datastructure.datastructure.sort.solutions;

import com.yt.datastructure.datastructure.sort.Sortable;
import com.yt.datastructure.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.datastructure.sort.anylisis.SortAnalysis;

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
