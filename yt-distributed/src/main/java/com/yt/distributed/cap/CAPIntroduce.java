package com.yt.distributed.cap;/**
 * Created by SUN on 19/3/15.
 */

/**
 * @author SUN
 * @create 2019-03-15 下午11:01
 * @desc
 *
 * 参见 http://www.ruanyifeng.com/blog/2018/07/cap.html
 * 我个人 见过这个人的几篇文章了,比较好理解
 *
 * 这里重述下 CA的矛盾原因
 *
 * 在满足P的条件下(容忍节点的 drop 或 network 的 delay)
 *
 * 三个对象:
 * client
 * server-node1(value:0)
 * server-node2(value:0)
 *
 * 注意:分析分布式时,要考虑在时间维度对象之间的通信
 *
 * 动作:client请求 node1 将value 更新为 1
 *
 * TODO 如下例子不正确,否则 C与A一直是对立的,需要在P上找理由
 *
 * 前提条件,满足P
 * 条件:满足C(就要node2的值,也更新为1),
 *      所以当node2的值变为1之前,该节点都不满足一致性,所以不能用,所以不满足A
 *
 * 条件:满足A(任何时候,node2都要返回值),
 *      显然,由上个例子,在node2更新为1之前,都不满足一致性
 */
public interface CAPIntroduce {
}
