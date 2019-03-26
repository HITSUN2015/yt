package com.yt.arithmetic.sort.solutions;


import com.yt.arithmetic.sort.anylisis.ComplexityType;
import com.yt.arithmetic.sort.Sortable;
import com.yt.arithmetic.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/25.
 *
 * 升序：一次遍历 把最大数，移动到数组尾部，n次遍历，移动完毕，移动的方法：swap
 */
public class BubbleSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {

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
        for (int j = 0; j < datas.length; j++) {
            int maxLength = datas.length - 1 - j;
            for (int i = 0; i < maxLength; i++) {
                if (datas[i] > datas[i + 1]) {
                    int temp = datas[i + 1];
                    datas[i + 1] = datas[i];
                    datas[i] = temp;
                }
            }
        }

        return datas;
    }
}
