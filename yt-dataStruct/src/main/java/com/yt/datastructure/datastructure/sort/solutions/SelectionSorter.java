package com.yt.datastructure.datastructure.sort.solutions;

import com.yt.datastructure.datastructure.sort.Sortable;
import com.yt.datastructure.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.datastructure.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/25.
 *
 * 与冒泡排序的区别：
 * 冒泡是每一层比较都进行一次交换
 *
 * 选择排是，一次遍历，把最值存在临时变量里，并标记游标位置，遍历结束后，再进行交换
 */
public class SelectionSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis{
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
        //int maxValue,index; 这俩变量方里面还是外面。。。TODO
        //这里 不能提供 Integer.MIN_VALUE 否则 当有Integer 最小值时，必须标记 这样会改变稳定性
        for (int i = 0; i < datas.length; i++) {
//            int maxLentgh = datas.length - i; // 与冒泡不同，冒泡需要前后两个比较，所以-1，这里是遍历所有找到最大，没有-1
            //第一次我写的是 把大的挪后面，实现成了 降序，然后决定，无论升序降序，都把前面先排好
            int minValue = datas[i];
            int index = i;
            for (int j = i; j < datas.length; j++) {
                if (minValue > datas[j]) {
                    //这里如果没有等号，则表示：如果后面发现同样大的值，则不会选择后面的，破坏稳定性
                    minValue = datas[j];
                    index = j;
                }
            }
            //swap
            if (index != i) {
                int temp = datas[i];
                datas[i] = datas[index];
                datas[index] = temp;
            }
        }

        return datas;
    }
}
