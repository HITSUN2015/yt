package com.yt.datastructure.datastructure.arithmetic.dynamicPrograming;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/25.
 *
 * 对于序列S和T，它们之间距离定义为：对二者其一进行几次以下的操作(1)删去一个字符；(2)插入一个字符；(3)改变一个字符。每进行一次操作，计数增加1。将S和T变为同一个字符串的最小计数即为它们的距离。给出相应算法。
 *
 */
@Test
public class EditDistanceSolution {

    private static final String QUESTION_PARAM_1= "asdfsb";
    private static final String QUESTION_PARAM_2 = "fsdf";

    /**
     * 我是知道这道题要用 动态规划解的
     * <p>
     * 但是我第一反应是，随便 从 字符串中某一处开始，和另一个，发现，可能的子问题 太多了。。。
     * <p>
     * 看答案是说从末尾开始，好受多了。。。
     * <p>
     * 动态规划关键应该还是找 简单的转移方程
     *
     */
    @Test
    public void solute() {
        /**
         * 寻找状态方程：
         * 情况1:Str1 Str2 末尾字母一样
         * 情况2:Str1 + Str2末尾位 = Str2
         * 情况3:Str1 - Str1末尾位 = Str2
         * 情况4：
         *
         * 以上是 我看了答案后 自己重新想的
         *
         * 但是这种想法不够有条理
         *
         * 我们可以换个想法
         *
         * Str2 通过 已知支持的 操作 可以变成什么样子：
         * 情况1：删除一个字符：str2 = str2x - x
         * 情况2：添加一个字符：str = str1 + 2
         * 情况3：改变一个字符：str2 = strx -> 2
         * 状态方程：f(str2):代表由str1到str2的编辑距离
         * f(str) = min(f(str[0~length -1]) + 1,f(str[0~length] + 一个字符) + 1,f(str(0~,length)换一个字符) + 1
         * ...这一个任意字符。。。怎么表达。。。
         *
         * 还有一个限制条件：字符串长度
         * 最坏的长度就是 str.length + str2.length
         *
         * 然后 卡文了。。。
         *
         * 又看了下攻略
         *
         * 这里其实我还是没想清，为什么答案里都用的 str1，str2的length作为参数，我是这么笔画的：
         * str1：source
         * str2：target
         *
         * distance（str1 ， str2）表示 str1、str2的编辑距离
         * 强行应用动态规划有：这个变化的过程肯定是一个字母一个字母的。。。（TODO 除非还有效率更高的算法）
         *
         * |-------------------------|-------------------------|
         * |distance(sourc,targe)+2  |distance(source,targe)+1 |
         * |distance(source,targe)+1 |distance(source,target)  |
         * |-------------------------|-------------------------|
         */

    }
}
