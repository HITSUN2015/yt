package com.yt.datastructure.base.tree.draw;/**
 * Created by SUN on 19/3/26.
 */

import com.yt.datastructure.base.tree.Tree;
import com.yt.datastructure.baseModel.BTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-26 下午11:20
 * @desc
 */
public abstract class AbstractDrawalbeTree implements Tree {

    int PRINT_UNIT = 10;

    protected BTreeNode<Integer> root;

    public void drawTree() {
        //层序 遍历 画节点
        int height = 0;
        List<BTreeNode<Integer>> layer = new ArrayList<>();
        layer.add(root);
        while (!layer.isEmpty()) {
            //实现的比较随意
            List<BTreeNode<Integer>> nextLay = new ArrayList<>();
            for (BTreeNode bTreeNode : layer) {
                if (null != bTreeNode.left) {
                    nextLay.add(bTreeNode.left);
                }
                if (null != bTreeNode.right) {
                    nextLay.add(bTreeNode.right);
                }
            }
            height++;
            layer = nextLay;
        }

        int width = Double.valueOf(Math.pow(2, height - 1)).intValue();
        StringBuilder stringBuilder = new StringBuilder();
        layer = new ArrayList(){{add(root);}};
        while (height > 0) {
            //实现的比较随意
            List<BTreeNode<Integer>> nextLay = new ArrayList<>();
            int curLayerCount = layer.size();
            for (BTreeNode<Integer> bTreeNode : layer) {
                stringBuilder.append(formatString(PRINT_UNIT * width / curLayerCount, null == bTreeNode ? null : bTreeNode.value));

                if (null == bTreeNode) {
                    nextLay.add(null);
                } else {
                    nextLay.add(bTreeNode.left);
                }

                if (null == bTreeNode) {
                    nextLay.add(null);
                } else {
                    nextLay.add(bTreeNode.right);
                }
            }
            stringBuilder.append("\n");
            height--;
            layer = nextLay;
        }

        System.out.println(stringBuilder.toString());
    }

    private static String formatString(int ocup, Integer val) {
        if (null == val) {
            return String.format("%-" + ocup + "s", "null");
        } else {
            return String.format("%-" + ocup + "d", val);
        }

    }
}
