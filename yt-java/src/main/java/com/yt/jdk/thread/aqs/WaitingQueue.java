package com.yt.jdk.thread.aqs;/**
 * Created by SUN on 19/3/28.
 */

import com.yt.demo.helper.util.model.Node;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author SUN
 * @create 2019-03-28 下午9:56
 * @desc
 * 队列头:{@link java.util.concurrent.locks.AbstractQueuedSynchronizer#head}
 * 队列尾:{@link java.util.concurrent.locks.AbstractQueuedSynchronizer#tail}
 * 双向队列:{@link java.util.concurrent.locks.AbstractQueuedSynchronizer.Node#prev}
 *         {@link java.util.concurrent.locks.AbstractQueuedSynchronizer.Node#next}
 */
public class WaitingQueue {

    /**
     * {@link java.util.concurrent.locks.AbstractQueuedSynchronizer#enq(AbstractQueuedSynchronizer.Node)}
     *
     * 这个方法有一行:tail = head;
     * 1.tail 没有被 compareAndSet 来设置,如果有两个新的node走到这里,会使得tail的赋值出现错误(第一个被覆盖)
     * 但是,走到这行代码的先决条件:if (compareAndSetHead(new Node()))
     * {@link AbstractQueuedSynchronizer#compareAndSetHead} 是从null 设置成node
     * 致使第二个node走不到 tail = head;而是继续循环,直到第一个head被赋值,且tail被赋值,最后走到另一个分支。。。
     * 2.无法连续两个CAS(除非本身连续A->B-C)否则,第二个CAS失败,第一个无法回滚
     *
     * 除了这里 所有对tail赋值,都判断了null != tail判断,且都是cas赋值
     *
     * 还有一处代码 {@link java.util.concurrent.locks.AbstractQueuedSynchronizer#addWaiter}
     * 没有直接用for循环,而是先执行了一下循环体内的代码,做了一次fast path of enq
     *
     * 另一处代码:
     * 1 node.prev = t;//t是tail
     * 2 if (compareAndSetTail(t, node)) {
     * 3      t.next = node;
     * 4 }
     * 只有成功进队,才会修改原队列的值,所以 3 放 2 之后,我没有疑问
     * 关于1的位置,个人认为,在并发量比较大,可能会造成 2 大多数返回false,而1的赋值可能是无效的,可能我更倾向 1 在 2 之后
     * 这里有一个问题:3 与 2 可能不是连着的,意思就是,跑起来的话,一顿加tail,原代码可能会出现,加了很多单连(只有pre),next没有加上
     * 可能在使用的时候,多应用从tail往前找,这么写可能就有作用了。
     * 而把1挪到2之后,会造成,高并发时,tail很孤单。。。TODO 如果实际不会出现断连的情况的话,那我还是把 1 放 2 后面。。。
     */
    public void enqueue() {
        Node head = null;
        Node tail = null;

        //最一般的写法           //Doug Lea TODO 写法学习
        //先有头 后有尾。。。     // 注释只是我目前想的 多线程下 怎么写 能够好些
        Node node = new Node(); //0
        if (null == head) {     //1
            head = node;        //2cas
            tail = head;        //3一般化:步骤二是 CAS : A to B,这一步怎么写更好?
                                //      如果是Queue:head会被弹出,更换,tail指向node会出错,还是指向head好
                                //      如果是Stack:head会向Tail移动,tail指向head会不是tail,这时指向node好。。。
        } else {                //4以下情况,必须有一步是cas操作,且必须是对共享变量做cas操作,所以是步骤6,剩下两步顺序上面讨论过了,在此讨论更一般的情况
            node.pre = tail;    //5
            tail = node;        //6CAS(tail,node)
            tail.next = node;   //7
        }                       //8
    }

    public void dequeue() {

    }
}
