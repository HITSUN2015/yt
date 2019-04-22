package com.yt.arithmetic.arithmetic.dynamicProgramming;

/**
 * Created by yantong on 2019/2/20.
 */
public class InterceptMissle implements LinearDynamicProgramming {

    @Override
    public String question() {
        return "https://blog.csdn.net/lb1135909273/article/details/79164347";
    }

//    @Override
//    public Object showInput() {
//        return new int[]{389,207,155,300,299,170,158,65};
//    }
//
//    @Override
//    public Object showSolution() {
//        return null;
//    }

    private int countMaxInerceptMisslesPerSuit(int[] missileHeights) {
        //最直观的 感受是 找出元素数量最大的降序排列（这里对题意理解不严谨 要求的是 非递增即可）
        //最土的方法：找出所有元素的组合 然后看 找出降序的 最后 看哪个元素多

        //另一个方法是：数列中 每个元素到比他小的元素的link，能生成一棵树，最后是求树的最大高度

        return -1;
    }

    @Override
    public void dynamicProgrammingSolution() {

    }
}
