package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.
 *
 * 线性结果，后进先出
 * {@link java.util.Stack}
 */
public class Stack<T> implements StackNormalOperation<T>{

    //这里 具体的存储实现，可以多种多样，但是由于栈的操作多进出元素，所以可能用链表来存储比较好
    //并且 由于 总需要在线性结构的一端 进入和排除数据 所以 最好存储下这个端的引用
    private NodeWithNext<T> header;

    @Override
    public void demo() {
        Stack<String> stack = new Stack();
        System.out.println("stack.push(\"第一个\")");
        stack.push("第一个");
        System.out.println("stack.push(\"第二个\")");
        stack.push("第二个");
        System.out.println("stack.peek() 结果：" + stack.peek());
        System.out.println("stack.pop() 结果：" + stack.pop());
        System.out.println("stack.peek() 结果：" + stack.peek());
        System.out.println("stack.pop() 结果：" + stack.pop());
        System.out.println("stack.peek() 结果：" + stack.peek());
    }

    @Override
    public void push(T o) {
        NodeWithNext newNode = new NodeWithNext(o, header);
        this.header = newNode;
    }

    @Override
    public T pop() {
        T result = null;
        if (null != header) {
            result = header.getValue();
            header = header.getNext();
        }
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (null != header) {
            result = header.getValue();
        }
        return result;
    }
}
