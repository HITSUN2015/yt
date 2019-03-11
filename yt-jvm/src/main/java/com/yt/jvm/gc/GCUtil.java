package com.yt.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by yantong on 2019/3/11.
 *
 * 打印出gc信息：
 * jvm 参数需要配置：
 * -XX:+PrintGC 输出GC日志
 * -XX:+PrintGCDetails 输出GC的详细日志
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * -Xloggc:../logs/gc.log 日志文件的输出路径
 *
 * demo：-Xloggc:gc.log -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
 * 执行 ReferenceCountingTest.testReferenceCounting()的文件：
 *

 Java HotSpot(TM) 64-Bit Server VM (25.151-b12) for windows-amd64 JRE (1.8.0_151-b12), built on Sep  5 2017 19:33:46 by "java_re" with MS VC++ 10.0 (VS2010)
 Memory: 4k page, physical 8269928k(1858448k free), swap 16537996k(7510556k free)
 CommandLine flags: -XX:InitialHeapSize=132318848 -XX:MaxHeapSize=2117101568 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 0.890: [GC (System.gc()) [PSYoungGen: 24761K->2931K(38400K)] 24761K->3011K(125952K), 0.0277784 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
 0.918: [Full GC (System.gc()) [PSYoungGen: 2931K->0K(38400K)] [ParOldGen: 80K->2861K(87552K)] 3011K->2861K(125952K), [Metaspace: 7371K->7371K(1056768K)], 0.0477756 secs] [Times: user=0.13 sys=0.00, real=0.05 secs]
 Heap
 PSYoungGen      total 38400K, used 971K [0x00000000d5f00000, 0x00000000d8980000, 0x0000000100000000)
 eden space 33280K, 2% used [0x00000000d5f00000,0x00000000d5ff2d98,0x00000000d7f80000)
 from space 5120K, 0% used [0x00000000d7f80000,0x00000000d7f80000,0x00000000d8480000)
 to   space 5120K, 0% used [0x00000000d8480000,0x00000000d8480000,0x00000000d8980000)
 ParOldGen       total 87552K, used 2861K [0x0000000081c00000, 0x0000000087180000, 0x00000000d5f00000)
 object space 87552K, 3% used [0x0000000081c00000,0x0000000081ecb708,0x0000000087180000)
 Metaspace       used 7400K, capacity 7558K, committed 7808K, reserved 1056768K
 class space    used 837K, capacity 881K, committed 896K, reserved 1048576K

 */
public class GCUtil {

    public static void gc() {
        System.gc();
    }

    /**
     *  方法一：java -XX:+PrintFlagsFinal -version | grep :
     *          ":="代表是用户或jvm设置的参数
     demo:
     intx CICompilerCount                          := 2                                   {product}
     uintx InitialHeapSize                          := 31457280                            {product}
     uintx MaxHeapSize                              := 492830720                           {product}
     uintx MaxNewSize                               := 164102144                           {product}
     uintx MinHeapDeltaBytes                        := 524288                              {product}
     uintx NewSize                                  := 10485760                            {product}
     uintx OldSize                                  := 20971520                            {product}
     bool PrintFlagsFinal                          := true                                {product}
     bool UseCompressedClassPointers               := true                                {lp64_product}
     bool UseCompressedOops                        := true                                {lp64_product}
     bool UseParallelGC                            := true                                {product}
     *
     *  方法二：java -XX:+PrintCommandLineFlags -version
     demo:
     -XX:InitialHeapSize=30753344 -XX:MaxHeapSize=492053504 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
     openjdk version "1.8.0_141"
     OpenJDK Runtime Environment (build 1.8.0_141-b16)
     OpenJDK 64-Bit Server VM (build 25.141-b16, mixed mode)
     */
    public static void getGCCollector() {
        //方法三 这个方法返回的是 算法，而非 collector ？ TODO
        List<GarbageCollectorMXBean> l;
        l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
    }
}
