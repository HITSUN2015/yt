package com.yt.redis.theroy.model.apsect;

/**
 * Created by yantong on 2019/4/8.
 *
 * TODO 应用场景
 *
 * 哈希键 包含的键值比较多，或 键值对中的元素 比较长的字符串时，使用{@link com.yt.redis.theroy.model.dict.Dict}作为hash键的底层实现
 *
 * {@link com.yt.redis.theroy.model.skiplist.RedisSkipList}
 *      有序集合 key 当：元素数量比较多 或 有序集合元素的成员是比较长的字符串
 *      集群节点
 */
public class UseScene {
}
