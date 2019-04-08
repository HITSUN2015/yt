package com.yt.arithmetic.arithmetic.math;

/**
 * Created by yantong on 2019/4/2.
 */
public class ByteOperation {

    public void byteMove() {
        //>>> 右移 高位严格补0
    }

    /**
     * {@link JDKInteger#integerDefaultValue}
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 求 比某个数大的最小的2的指数
     *
     * {@link java.util.HashMap#tableSizeFor(int)}
     *
     * 边界：大于{@link ByteOperation#MAXIMUM_CAPACITY} 就无法用int表达，所以返回-1
     *
     * 方法：把data的每一位，变成1 再+1
     *       关于把每一位变成1，右侧的注解可以看出，只有一个1，也会填满
     *       关于为什么 先减1，如果data本身是2的倍数，则再+1会大于结果
     *                         如果data本身不是2的倍数，减1不会导致数据降位，也符合结果
     */
    public static int findNearestPow2(int data) {
        if (data > MAXIMUM_CAPACITY) {
            return -1;
        }
        int n = data - 1;   //10 00 0000 00000000
        n |= n >>> 1;       //11 00 0000 00000000
        n |= n >>> 2;       //11 11 0000 00000000
        n |= n >>> 4;       //11 11 1111 00000000
        n |= n >>> 8;       //11 11 1111 11111111
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;//后面可以直接返回n + 1
    }

}
