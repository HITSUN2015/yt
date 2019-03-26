package com.yt.datastructure.base.tree;

/**
 * Created by yantong on 2019/2/14.
 *
 *
 * 1.定义:堆通常是一个可以被看做一棵树的数组对象
 * 2.性质:
 *      n个元素序列{k1, k2... ki...kn},当且仅当满足下列关系时称之为堆：
 *       (ki <= k2i, ki <= k2i+1)或者(ki >= k2i, ki >= k2i+1), (i = 1, 2, 3, 4... n/2)
 */
public interface Heap extends com.yt.datastructure.base.tree.CompleteTree {
}
