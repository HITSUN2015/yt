package com.yt.datastructure.sort.solutions;

import com.yt.datastructure.sort.Sortable;
import com.yt.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/25.
 *
 * 主要思想是：将新元素，往已排好的序列里 插入，通过交换，把所有比新数据大的数据，往后移动
 */
public class InsertionSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {
    @Override
    public ComplexityType getTimeComplexity() {
        return ComplexityType.N2;
    }

    @Override
    public ComplexityType getSpaceComplexity() {
        return ComplexityType.YI;
    }

    @Override
    public boolean canBeStable() {
        return true;
    }

    @Override
    protected int[] customerSort(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = i; j > 0 && datas[j] < datas[j - 1]; j--) {//含=则破坏稳定性//j -- 一定别忘。。。。TODO
                int temp = datas[j];
                datas[j] = datas[j - 1];
                datas[j - 1] = temp;
            }
        }
        return datas;
    }
}
