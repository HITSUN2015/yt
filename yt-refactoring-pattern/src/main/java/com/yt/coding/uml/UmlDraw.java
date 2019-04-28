package com.yt.coding.uml;

/**
 * @author SUN
 * @create 2019-04-28 下午12:24
 * @desc
 *
 * 类关系的连线，全部是：箭头 + 连线 + 根
 *
 * 由于两个类依赖关系的强弱顺序是：
 * {@link Dependency} < {@link Association} < {@link Aggregation} < {@link Composition}
 *
 * 所以，划线时，逐步添加笔画
 *
 * {@link Dependency} : - - - - - >
 *
 * {@link Association}: ---------->
 * {@link Aggregation}: <>-------->
 * {@link Composition}: <实心>----->
 */
public class UmlDraw {
}
