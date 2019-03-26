package com.yt.datastructure.sort.solutions;

import com.yt.datastructure.sort.Sortable;
import com.yt.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.sort.anylisis.SortAnalysis;

/**
 * Created by yantong on 2019/3/25.
 *
 * 1959年Shell发明，第一个突破O(n2)的排序算法
 * 又叫缩小增量排序
 *
 * 实现原理：
 *      eg:
 *      index    0   1   2   3   4   5   6
 *      value    45  4   52  43  423 9   50
 *      每次只遍历部分数据：增量 决定 遍历数据的个数：
 *      eg:增量是 2 则遍历 index:0,2,4,6,将这几个数字，应用{@link InsertionSorter}实现原理排序
 *
 * 我这里的实现是 采用了 datas.length 不断/2
 *
 * 专家们提倡，几乎任何排序工作在开始时都可以用希尔排序，若在实际使用中证明它不够快，再改成快速排序这样更高级的排序算法
 * TODO 找到 哪个专家怎么提倡的
 *
 * 关于为什么节省性能：
 *      此方法来源于插入排序，是对其进行优化
 *      优化1：好像还有个因素，我没看出来 TODO
 *      优化2：插入排序后期，已经很接近最终状态，但是还需要逐个比较进行数据移动，shell排序跨范围移动，更快
 */
public class ShellSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {
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
        //我这里没照网上 超，是按照自己理解实现的
        for (int delt = datas.length / 2; delt > 0 ; delt = delt / 2) {
            for (int i = 0; i < datas.length; i += delt) {
                for (int j = i; j - delt >= 0 && datas[j] < datas[j - delt]; j -= delt) {
                    int temp = datas[j];
                    datas[j] = datas[j - delt];
                    datas[j - delt] = temp;
                }
            }
        }
        return datas;
    }
}
