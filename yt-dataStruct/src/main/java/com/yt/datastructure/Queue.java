package com.yt.datastructure;

import com.yt.datastructure.baseModel.NodeWithNext;

/**
 * Created by yantong on 2019/2/14.
 * 线性 先进先出
 */
public class Queue<T> implements QueueNormalOperation<T> {

    //这里 具体的存储实现，可以多种多样，但是由于队列的操作多进出元素，所以可能用链表来存储比较好
    //由于队列 常在 线性表的两端操作，所以 提供header 和 tail 效率更高
    //综合 进队 和 出队的操作，应该仅存储一个方向的link即可

    private NodeWithNext<T> header;
    private NodeWithNext<T> tail;

    @Override
    public void demo() {
        Queue<String> queue = new Queue<String>();
        System.out.println("queue.enqueue(\"第一个\")");
        queue.enqueue("第一个");
        System.out.println("queue.enqueue(\"第二个\")");
        queue.enqueue("第二个");
        System.out.println("queue.dequeue() 结果：" + queue.dequeue());
        System.out.println("queue.dequeue() 结果：" + queue.dequeue());
        System.out.println("queue.dequeue() 结果：" + queue.dequeue());
    }

    @Override
    public void enqueue(T t) {
        NodeWithNext newNode = new NodeWithNext(t, null);
        if (null != header) {
            header.setNext(newNode);
        }
        header = newNode;
        if (tail == null) {
            tail = header;
        }
    }

    @Override
    public T dequeue() {
        if (tail == null) {
            return null;
        }
        T result = tail.getValue();
        tail = tail.getNext();
        return result;
    }
}
