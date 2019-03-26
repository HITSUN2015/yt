package com.yt.datastructure.sort.solutions;

import com.yt.datastructure.sort.Sortable;
import com.yt.datastructure.sort.anylisis.ComplexityType;
import com.yt.datastructure.sort.anylisis.SortAnalysis;
import com.yt.datastructure.sort.solutions.common.Node;

/**
 * Created by yantong on 2019/3/26.
 *
 * 捅排序 对 原数据也是有要求，分布较为平均 连续 比较好
 * 我这里的实现，为了兼容各种数据源，不得已建立的 以十位数字以上建立捅
 *
 * 桶内排序 还可以有各种方式 感觉这个方法 和 计数的 比较像，分治
 *
 * TODO
 * 
 * 应用：// TODO: 2019/3/26
 */
public class BucketSorter extends AbstractIllegalArgumentsSorter implements Sortable, SortAnalysis {
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
        //解决负数 还是 蛋疼

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
        min /= 10;
        max /= 10;
        Node[] bucket = new Node[max - min + 1];

        for (int i = 0; i < datas.length; i++) {
            int bucketIndex = getBucketIndex(datas[i], min);
            Node curNode = new Node(datas[i]);
            putIntoBucket(bucket, bucketIndex, curNode);
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            Node head = bucket[i];
            while (head != null) {
                datas[index++] = head.value;
                head = head.next;
            }
        }

        return datas;
    }

    private int getBucketIndex(int value, int minBucket) {
        return value / 10 - minBucket;
    }

    private void putIntoBucket(Node[] bucket, int bucketIndex, Node curNode) {

        Node exist = bucket[bucketIndex];
        if (null == exist) {
            bucket[bucketIndex] = curNode;
            return;
        }

        Node pre = null;
        boolean hasPut = false;
        int status = -1;//-1代表 比当前节点小
        while (exist != null) {
            if (curNode.value == exist.value) {
                Node tmp = exist.next;
                exist.next = curNode;
                curNode.next = tmp;
                break;
            } else if (curNode.value > exist.value) {
                // TODO: 2019/3/26 wrong
                curNode.next = exist;
                if (pre != null) {
                    pre.next = curNode;
                } else {
                    bucket[bucketIndex] = curNode;
                }
            }
            pre = exist;
            exist = exist.next;
        }

        if (!hasPut) {
            curNode.next = bucket[bucketIndex];
            bucket[bucketIndex] = curNode;
        }
    }

}
