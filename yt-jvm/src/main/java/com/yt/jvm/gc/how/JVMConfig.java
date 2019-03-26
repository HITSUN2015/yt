package com.yt.jvm.gc.how;

import com.yt.jvm.gc.how.collector.ParNew;
import com.yt.jvm.gc.how.collector.ParallelScavenge;
import com.yt.jvm.gc.how.collector.Serial;
import com.yt.jvm.gc.how.collector.SerialOld;

/**
 * Created by SUN on 19/3/11.
 */
public enum JVMConfig {
    Survivor_Ratio("-XX:SurvivorRatio","",new Class[]{Serial.class, SerialOld.class, ParNew.class}),
    Pretenure_Size_Threshold("-XX:PretenureSizeThreshold","",new Class[]{Serial.class, SerialOld.class, ParNew.class}),
    Handler_Promotion_Failure("-XX:HandlePromotionFailure","",new Class[]{Serial.class, SerialOld.class, ParNew.class}),
    Parallel_GC_Threads("-XX:ParallelGCThreads","",new Class[]{Serial.class, SerialOld.class, ParNew.class}),
    Max_GC_Pause_Mills("-XX:MaxGCPauseMills","最大垃圾收集停顿时间","调小,则新生代变小,则throughput变小",new Class[]{ParallelScavenge.class}),
    GC_Time_Ratio("-XX:GCTimeRatio","吞吐量","默认99(用户时间是gc时间多少倍)",new Class[]{ParallelScavenge.class}),
    Use_Adaptive_Size_Policy("-XX:UseAdaptiveSizePolicy","自动调节各个代的大小","默认99(用户时间是gc时间多少倍)",new Class[]{ParallelScavenge.class}),

    ;

    private String param;
    private String meaning;
    private String theory;
    private Class[] supportedCollector;

    JVMConfig(String param, String meaning, Class[] supportedCollector) {
        this.param = param;
        this.meaning = meaning;
        this.supportedCollector = supportedCollector;
    }

    JVMConfig(String param, String meaning, String theory, Class[] supportedCollector) {
        this.param = param;
        this.meaning = meaning;
        this.theory = theory;
        this.supportedCollector = supportedCollector;
    }
}
