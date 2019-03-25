package com.yt.datastructure.datastructure.breakdown.standard.statistics.experience;

import com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.BaseBreakDown;
import com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.solve.Action;
import com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.solve.Reason;

/**
 * Created by yantong on 2019/3/18.
 * TODO
 */
public class RedisExtend extends BaseBreakDown {

    public RedisExtend() {
        this.reason = Reason.build("原因是扩容期间,reids不可用");
        this.action = Action.build("1.集群，使用代理，达到集群的目的。\n" +
                "\n" +
                "2.主从同步，读写分离。" +
                "\nhttps://blog.csdn.net/shawhe/article/details/53166346" +
                "\nhttps://blog.csdn.net/rosanu_blog/article/details/68066756");
    }

}
