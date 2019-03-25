package com.yt.datastructure.datastructure.arithmetic.dynamicPrograming;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/25.
 * 假设有几种硬币，如1、3、5，并且数量无限。请找出能够组成某个数目的找零所使用最少的硬币数。
 */
@Test
public class CoinSolution {

    //需要凑的 硬币数
    private static final int TOTAL_COUNT = 27;

    /**
     * 凑n：
     * 状态转移方程：
     * f(n)= min{f(n-1),f(n-3),f(n-5)}+1
     */
    @Test
    public void solute() {
        if (TOTAL_COUNT <= 0) {
            System.out.println("do not need solute");
            return;
        }
        //凑出0~27
        int[] resultList = new int[TOTAL_COUNT + 1];

        // TODO: 2019/2/25 上面初始化的值是怎么设定的

        /**
         * 这道题 是 给 由状态转移方程无法计算出的数值 设置初始值
         * 由于 f(i) i < 0时 均不合题意 => 需要人工赋值：f(0) = 0
         * 进而 n-1，n-3,n-5等于0时 都需要赋值
         */
        //init
        resultList[0] = 0;
        if (TOTAL_COUNT >= 1) {
            resultList[1] = 1;
        }
        if (TOTAL_COUNT >= 3) {
            resultList[3] = 1;
        }
        if (TOTAL_COUNT > 5) {
            resultList[5] = 1;
        }

        // TODO: 2019/2/25 这里for循环开始的值 如下需要跳过 初始化的值的计算，或者 写else 里 但是 初始化的流程 就不明显了
        for (int i = 0; i < resultList.length; i++) {
            if (i != 0 && i != 1 && i != 3 && i != 5) {
                resultList[i] = Math.min(Math.min(fetchValue(i - 1, resultList), fetchValue(i - 3, resultList)), fetchValue(i - 5, resultList)) + 1;
            }
        }
        String result = resultList[resultList.length - 1] < 0 ? "不存在" : resultList[resultList.length - 1]  + "";
        System.out.println("凑成 {" + TOTAL_COUNT + "} 需要1、3、5面值硬币至少 {" + result + "} 枚");
    }

    private int fetchValue(int i, int[] resultList) {
        if (i < 0) {
            return Integer.MAX_VALUE;// TODO: 2019/2/25 由于这里取的是Math.min所以设置无穷大，一定不能是0！！！
        }
        return resultList[i];
    }

    /**
     * 扩展：打印出 各个硬币的数量
     *
     * 如果数据特别大，可以对resultCountList封装个对象
     */
    @Test
    private void extendPrintPerCointCount() {
        if (TOTAL_COUNT <= 0) {
            System.out.println("do not need solute");
            return;
        }
        //凑出0~27
        int[] resultList = new int[TOTAL_COUNT + 1];
        String[] resultCountList = new String[TOTAL_COUNT + 1];

        /**
         * 这道题 是 给 由状态转移方程无法计算出的数值 设置初始值
         * 由于 f(i) i < 0时 均不合题意 => 需要人工赋值：f(0) = 0
         * 进而 n-1，n-3,n-5等于0时 都需要赋值
         */
        //init
        resultList[0] = 0;
        resultCountList[0] = "无";
        if (TOTAL_COUNT >= 1) {
            resultList[1] = 1;
            resultCountList[1] = ";1";
        }
        if (TOTAL_COUNT >= 3) {
            resultList[3] = 1;
            resultCountList[3] = ";3";
        }
        if (TOTAL_COUNT > 5) {
            resultList[5] = 1;
            resultCountList[5] = ";5";
        }

        // TODO: 2019/2/25 这里for循环开始的值 如下需要跳过 初始化的值的计算，或者 写else 里 但是 初始化的流程 就不明显了
        for (int i = 0; i < resultList.length; i++) {
            if (i != 0 && i != 1 && i != 3 && i != 5) {
                resultList[i] = Math.min(Math.min(fetchValue(i - 1, resultList), fetchValue(i - 3, resultList)), fetchValue(i - 5, resultList)) + 1;
                int min = fetchValue(i - 1, resultList) < fetchValue(i - 3, resultList) ? 1 : 3;
                min = fetchValue(i - min, resultList) < fetchValue(i - 5, resultList) ? min : 5;
                resultCountList[i] = resultCountList[i - min] + ";" +  min ;

            }
        }
        String result = resultList[resultList.length - 1] < 0 ? "不存在" : resultList[TOTAL_COUNT]  + "";
        System.out.println("凑成 {" + TOTAL_COUNT + "} 需要1、3、5面值硬币至少 {" + result + "} 枚");
        System.out.println("凑成 {" + TOTAL_COUNT + "} 需要1、3、5面值硬币至少 {" + resultCountList[TOTAL_COUNT] + "}");
    }
}
