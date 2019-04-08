package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 */
public interface DictType {

    /**
     * 当字典被用作数据库的底层实现，或哈希键的底层实现时，用murmurHash2计算哈希值 TODO
     * @param key
     * @return
     */
    int hashFunction(Object key);

    void keyDup();//todo 参数是输入与输出

    void valDup();//todo param

    int keyCompare();

    void keyDestructor();

    void valDestructor();
}
