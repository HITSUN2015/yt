package com.yt.redis.theroy.model.string;

/**
 * Created by yantong on 2019/4/3.
 *
 * Simple dynamic string
 *
 * 优点：
 *  1.getLength():O(1)
 *  2.不会有缓冲区溢出：规避了c语言的常见问题
 *  3.减少修改字符串时带来的内存重分配次数：c是没改一次修一次 TODO
 *  4.惰性释放空间，根据需求，后台处理free空间的管理
 *  5.二进制安全（c因为'\0'是结尾所以无法存储图像等格式文件）
 *  6.兼容c语音部分函数
 *
 * 分配空间的策略：{@link SDS#allocateBuf}
 *
 * sdsAPI：略 《Redis设计与实现》 p16
 */
public class SDS {

    private int len;    //实际字符长度，不计结尾符'\0'
    private int free;   //剩余空间，不计结尾符'\0'
    private char[] buf; //占用的存储
    public static final int ONE_MB = 1 << 20;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public char[] getBuf() {
        return buf;
    }

    public void setBuf(char[] buf) {
        this.buf = buf;
    }

    /**
     * 分配空间的策略 分段分配 小的时候二倍，大的时候多分一兆
     * @param inputStringLength
     */
    public void allocateBuf(int inputStringLength) {
        if (inputStringLength < ONE_MB) {
            buf = new char[2 * inputStringLength + 1];// +1 for '\0'
        } else {
            buf = new char[inputStringLength + ONE_MB + 1];
        }
    }
}
