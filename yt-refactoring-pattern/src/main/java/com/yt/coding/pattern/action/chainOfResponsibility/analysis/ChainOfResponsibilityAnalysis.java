package com.yt.coding.pattern.action.chainOfResponsibility.analysis;

/**
 * @author SUN
 * @create 2019-04-28 下午10:12
 * @desc
 *
 * {@link com.yt.coding.pattern.action.chainOfResponsibility.bad.Event}
 * {@link com.yt.coding.pattern.action.chainOfResponsibility.bad.Handler}
 *
 * 数量关系：
 * 思考这样一个问题：一个处理器是否要同时处理多个事件？非必须
 * 思考这样一个问题：一个事件是否要同时被多个处理器处理？必须
 * 这里需要强调一下：这里说的多个事件处理，是一次交由这一组处理器，但并非每个处理器都要处理
 *
 * handler:event = 1:n or 1:1
 * event:handler = 1:n
 * 化简留下event:handler = 1:n
 *
 * 这里对n的一方，强调了链式的结构，所以多了单向链的nextNode方法,并且强调了优先级
 */
public class ChainOfResponsibilityAnalysis {
}
