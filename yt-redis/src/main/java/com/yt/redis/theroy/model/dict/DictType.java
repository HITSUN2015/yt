package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 */
public interface DictType {

    int hashFunction(Object key);

    void keyDup();//todo 参数是输入与输出

    void valDup();//todo param

    int keyCompare();

    void keyDestructor();

    void valDestructor();
}
