package com.yt.datastructure.sort.solutions;

import com.yt.datastructure.arithmetic.DivideAndConquer;
import com.yt.datastructure.sort.Sortable;
import com.yt.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.sort.anylisis.SortAnalysis;

/**
 * 先将子序列排序，再merge子序列,+递归
 *
 * 若将两个有序表合并成一个有序表，称为2-路归并
 *
 * // TODO: 2019/3/25 这种排序 为什么快
 */
public class MergeSorter extends AbstractIllegalArgumentsSorter implements SortAnalysis, Sortable, DivideAndConquer {
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

        int[] result = sortSubDatas(datas, 0, datas.length -1);
        return result;
    }

    private int[] sortSubDatas(int[] datas, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        //第一次写，这个条件在递归里面，由于有=的情况，所以，无限循环
        //第二次写，这个条件里有=，但是递归到三个相邻元素时，没有解决排序问题，导致结果错误
        if (startIndex >= mid && mid >= endIndex) {
            return datas;
        }

        sortSubDatas(datas, startIndex, mid);
        sortSubDatas(datas, mid + 1, endIndex);

        merge(datas, startIndex, mid, endIndex);
        return datas;
    }

    //// TODO: 2019/3/25 这个方法 好像有更好的写法
    private void merge(int[] datas, int startIndex, int mid, int endIndex) {
//        if (startIndex >= mid || mid >= endIndex) {
//            return;
//        }
        int[] sortedDatas = new int[endIndex - startIndex + 1];
        int leftIndex = startIndex;
        int rightIndex = mid + 1;
        int mergeIndex = 0;
        for (; mergeIndex < sortedDatas.length && leftIndex <= mid && rightIndex <= endIndex; mergeIndex++) {
            if (datas[leftIndex] < datas[rightIndex]) {
                sortedDatas[mergeIndex] = datas[leftIndex];
                leftIndex++;
            } else {
                sortedDatas[mergeIndex] = datas[rightIndex];
                rightIndex++;
            }
        }
        //第一次没考虑到 一个 子序列 先复制完，会越界的问题
        if (leftIndex <= mid) {
            for(;mergeIndex < sortedDatas.length; mergeIndex++) {
                sortedDatas[mergeIndex] = datas[leftIndex];
                leftIndex++;

            }
        }
        if (rightIndex <= endIndex) {
            for(;mergeIndex < sortedDatas.length; mergeIndex++) {
                sortedDatas[mergeIndex] = datas[rightIndex];
                rightIndex++;
            }
        }

        for(int i = startIndex; i <= endIndex; i++) {
            datas[i] = sortedDatas[i - startIndex];
        }
    }
}
