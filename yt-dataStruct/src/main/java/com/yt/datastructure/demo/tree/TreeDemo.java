package com.yt.datastructure.demo.tree;/**
 * Created by SUN on 19/3/26.
 */

import com.yt.datastructure.base.DSOperation;
import com.yt.datastructure.base.tree.Tree;
import com.yt.datastructure.baseModel.BTreeNode;

/**
 * @author SUN
 * @create 2019-03-26 下午9:50
 * @desc 我这里就随便实现一个:按顺序加入,大的放右面,反之放左面,不做树调整
 */
public class TreeDemo extends AbstractDrawalbeTree implements Tree, DSOperation {

    @Override
    public void add(Integer add) {
        BTreeNode<Integer> index = root;
        BTreeNode<Integer> pre = null;
        while (index != null) {
            if (add > index.value) {
                pre = index;
                index = index.right;
            } else {
                pre = index;
                index = index.left;
            }
        }

        if (null == pre){
            root = new BTreeNode<>(add);
        } else if(add > pre.value) {
            pre.right = new BTreeNode(add);
        } else {
            pre.left = new BTreeNode(add);
        }
    }

    @Override
    public void delete(Integer del) {
        // TODO: 19/3/26  
    }

    @Override
    public Integer query(Integer o) {
        // TODO: 19/3/26
        return null;
    }

}
