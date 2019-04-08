package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 */
public class DictEntry {

    private Object key;

    private Object v;   //c中的union联合体：一个多个变量的结构同时使用一块内存区域
                        //可以是 指针,unit64_t,int64_t

    /**
     * for solve hash collision:{@link com.yt.datastructure.hashCollision.separateChaining.SeparateChaining}
     */
    private DictEntry next;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getV() {
        return v;
    }

    public void setV(Object v) {
        this.v = v;
    }

    public DictEntry getNext() {
        return next;
    }

    public void setNext(DictEntry next) {
        this.next = next;
    }
}
