package com.yt.redis.theroy.model.dict;

import com.yt.arithmetic.arithmetic.math.ByteOperation;

/**
 * Created by yantong on 2019/4/3.
 * 又称：符号表   symbol table
 *       关联数组 assocaitive array
 *       映射     map
 */
public class Dict {

    private DictType type;

    private Object privdata;

    private Dictht[] dictht;//size = 2 dictht[1]只是对dictht[0]rehash时使用

    private int rehashidx = -1;

    public void rehash() {

        int hashFlag = isToRehash();

        if (hashFlag == 0) {
            return;
        }

        if (hashFlag == 1) {
            extend();
        } else {
            // TODO: 2019/4/8 缩小
        }
    }

    public void extend() {
        //实际只处理了 分配空间 并设置rehashidx
        int newSize = getNewTableSize(1);//magic number
        dictht[1] = new Dictht(newSize);
        rehashidx = 0;
        /**
         * 数据迁移见 {@link Dict#move()}
         */
    }

    /**
     * 在每次对数据库进行 增删改查时，触发这个动作
     * 这样触发的迁移 服务必须在一定时间内不可用
     * 总效果是，遍历dictht[0].table
     *
     * 同时进行的查找会在两个表里查找，新增操作，都会插入到dictht[1]
     */
    private void move() {
        if (rehashidx == -1) {
            return;
        }
        if (rehashidx < dictht[0].getSize()) {
            //有冲突再解决冲突，这里展示迁移逻辑
            dictht[1].getTable()[type.hashFunction(dictht[0].getTable()[rehashidx].getKey())] = dictht[0].getTable()[rehashidx];
            rehashidx++;
        }
        if (rehashidx == dictht[0].getSize()) {
            finishRefresh();
        }
    }
    
    /**
     * rehash 条件
     *
     * 分类原因：感觉书里说的不够透亮 TODO 《redis设计与实践》 page 32
     *      在执行BGSAVE、BGREWRITEAOF时，子进程->copy-on-write。
     *      调大负载因子，尽量避免在子进程存在时，进行hash扩展，减少不必要内存写入，节约内存
     * @return 1：扩展 0：不变 -1：收缩
     */
    private int isToRehash() {
        //在执行 BGSAVE、BGREWRITEAOF 时
        //负载因子大于等于1 扩展
        if (dictht[0].getUsed() >= dictht[0].getSize()) {
            return 1;
        }
        //不在执行 BGSAVE、BGREWRITEAOF 时
        //负载因子大于等于5 扩展
        else if (dictht[0].getUsed() / dictht[0].getSize() >= 5) {
            return 1;
        }
        //负载因子 小于 0.1时 收缩
        else if (dictht[0].getSize() / dictht[0].getUsed() > 10) {
            return -1;
        }
        //不变
        return 0;
    }

    //计算新table的大小
    private int getNewTableSize(int hashFlag) {
        //扩展
        if (hashFlag == 1) {
            return ByteOperation.findNearestPow2((int) dictht[0].getUsed() * 2);//这里需要将该方法支持long
        } else if(hashFlag == -1){
            return ByteOperation.findNearestPow2((int) dictht[0].getUsed());
        }
        return 0;
    }

    private void finishRefresh() {
        dictht[0] = dictht[1];
        dictht[1] = null;//原文说这里是分配新空间，我这里暂时设置null
        rehashidx = -1;
    }
}
