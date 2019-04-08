package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 * dict hashtable:dictht
 */
public class Dictht {

    /**
     * index = {@link DictType#hashCode()} & {@link Dict#dictht#sizeMark}
     */
    private DictEntry[] table;
    private long size;      //unsigned
    private long sizeMark;  //unsigned TODO: 2019/4/3
    private long used;      //unsigned 实际节点个数

    public Dictht(long size) {
        this.size = size;
        table = new DictEntry[(int)size];//这个size再说
        // TODO: 2019/4/8 sizeMark
    }

    public DictEntry[] getTable() {
        return table;
    }

    public void setTable(DictEntry[] table) {
        this.table = table;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSizeMark() {
        return sizeMark;
    }

    public void setSizeMark(long sizeMark) {
        this.sizeMark = sizeMark;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }
}
