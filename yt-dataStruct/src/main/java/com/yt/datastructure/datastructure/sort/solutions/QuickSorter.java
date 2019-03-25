package com.yt.datastructure.datastructure.sort.solutions;

import com.yt.datastructure.datastructure.arithmetic.DivideAndConquer;
import com.yt.datastructure.datastructure.sort.Sortable;
import com.yt.datastructure.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.datastructure.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/25.
 *
 * 找一个基准值，比他小的放左面，比他大的放右面，递归
 *
 * 快速排序为什么快：TODO
 */
public class QuickSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis,DivideAndConquer {
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
        recurveSort(datas, 0, datas.length - 1);
        return datas;
    }

    private void recurveSort(int[] datas, int startIndex, int endIndex) {
        /**
         * 将 小的放左面，大的放右面的方法：
         * 第一反应就是 小的pass，大的扔尾部，这里需要对大的扔尾部做个标记
         */
        int pivotValue = datas[startIndex];
        //这里 如果pivodIndex 不在 第一个，需要解决 等于datas[pivot]的各种值，不好处理
        int index = startIndex;
        int tail = endIndex;
        //由于对 等于 pivot的数据 不好处理，所以查了一下 快排的准确描述：
        //通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序

        for (;index <= tail;) {
            //这里 是否 等于 pivotValue 和 下面的 递归索引 息息相关
            //这里有一点，我是想排成 升序，如果第一个上来就是最大的，并且我还只是把最大的往队尾移动，那么会一直递归
            //所以把第一个值 直接 扔到
            if (datas[index] >= pivotValue) {
                int tmp = datas[tail];
                datas[tail] = datas[index];
                datas[index] = tmp;
                tail--;
            } else {
                index++;
            }
        }

        if (startIndex < index - 1) {
            recurveSort(datas, startIndex, index - 1);
        }
        if (index < endIndex) {
            recurveSort(datas, index, endIndex);
        }
    }

}
