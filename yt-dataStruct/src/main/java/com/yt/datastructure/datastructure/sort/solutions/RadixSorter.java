package com.yt.datastructure.datastructure.sort.solutions;

import com.yt.datastructure.datastructure.sort.Sortable;
import com.yt.datastructure.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.datastructure.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/26.
 *
 * 这个排序 我看着 比较神奇。。。
 *
 * 适用于，分优先级的排序，更适用于，每个优先级内的基数均一致
 *
 * 原理：先按照个位数字排序计数排序，这样使得数组内，个位数字已按升序排列
 *       再按照十位数字计数排序，依次类推
 *
 * 要求，每个维度是独立的，优先级高的，后排序
 */
public class RadixSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis{
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
        // TODO: 2019/3/26  
        return new int[0];
    }
}
