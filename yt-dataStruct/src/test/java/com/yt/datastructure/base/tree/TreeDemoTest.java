package com.yt.datastructure.base.tree;/**
 * Created by SUN on 19/3/26.
 */

import com.yt.datastructure.base.DSOperation;
import com.yt.datastructure.demo.tree.AbstractDrawalbeTree;
import com.yt.datastructure.demo.tree.TreeDemo;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-26 下午9:56
 * @desc
 */
public class TreeDemoTest {


    @Test
    public void test() {
        AbstractDrawalbeTree tree = new TreeDemo();
        if (tree instanceof DSOperation) {
            DSOperation operation = (DSOperation) tree;
            operation.add(1);
//        operation.change(2);
            operation.add(2);
            operation.add(3);
        }

        tree.drawTree();
    }
}
