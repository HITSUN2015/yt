package com.yt.datastructure.base.tree;/**
 * Created by SUN on 19/3/26.
 */

/**
 * @author SUN
 * @create 2019-03-26 下午11:42
 * @desc 随便搜一个即可 参考 https://www.cnblogs.com/skywang12345/p/3576969.html
 *
 * 相比 {@link BinaryTree} AVL 要求 高度平衡
 *
 * 关于不平衡的四种情况：主要就是 某个叶节点，相比同跟叶节点，多出两个树高
 *      这四种情况，分为，这个比高于其他叶节点，相对同根的位置：
 *      它在同根的左孩子的左孩子下：LL(left-left):它是LLL或LLR
 *              root
 *           L       R
 *        LL  LR
 *     LLL LLR
 *      综上，有LL,LR,RL,RR四种 其下还有孩子的情况
 *
 *      回复平衡，通常方法是旋转，
 *      最基本的是LL、RR
 *      RL->RR  LR->RR
 *
 *  实现时，需要发现，是否有不平衡的情况，可以在node节点里 加入height这个变量作为比较
 *      我的demo里，暂时用遍历来找节点的高度
 */
public interface AVLTree extends Tree {


}
