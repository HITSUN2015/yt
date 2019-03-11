package com.yt.jvm.gc.source.analysis.level;

import com.yt.jvm.gc.BigMemeryObject;

/**
 * Created by yantong on 2019/3/11.
 *
 * 强引用存在，就不会被GC
 */
public class StongReference1 {

    public BigMemeryObject reference = null;

    public static StongReference1 getBigStongReference1(){
        StongReference1 stongReference1 = new StongReference1();
        stongReference1.reference = new BigMemeryObject();
        return stongReference1;
    }

    public static StongReference1 getSmallStongReference1() {
        return new StongReference1();
    }
}
