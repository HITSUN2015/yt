package com.yt.breakdown.standard.statistics.experience;

import com.yt.breakdown.standard.statistics.breakdown.BaseBreakDown;
import com.yt.breakdown.standard.statistics.breakdown.aspect.solve.Reason;

/**
 * Created by yantong on 2019/3/18.
 * 描述 kafka
 */
public class KafkaExtend extends BaseBreakDown {

    public KafkaExtend() {

    }

    private void init() {
        this.reason = Reason.build("[c++] kafka client在处理partition变更有bug。" +
                "\nhttps://github.com/edenhill/librdkafka/issues/558。" +
                "\n触发条件：1.kafka 0.9.2（C++） 2.需要对应topic有指令压力 3.需要对topic做2次partition扩容操作" +
                "\nplus:在0.9.5版本中没有出现这个问题，但是在测试过程中发现，重启kafka broker之后存在一定概率无法重连的问题\n" +
                "\n" +
                "这个问题在16年的时候提过一个bug给作者，作者在同步的时候可能没有同步：https://github.com/edenhill/librdkafka/issues/779\n" +
                "\n" +
                "通过翻看作者的各个版本代码发现在0.11.6版本作者通过其他方案将这个问题又修复了，所以需要更新到0.11.6版本");
    }
}
