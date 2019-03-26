package com.yt.jvm.gc.source.analysis.level;

import com.yt.jvm.gc.GCUtil;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/11.
 * TODO 没懂这些 代 之间的关系，看不懂
 */
@Test
public class StongReference1Test {

    /**
     Java HotSpot(TM) 64-Bit Server VM (25.151-b12) for windows-amd64 JRE (1.8.0_151-b12), built on Sep  5 2017 19:33:46 by "java_re" with MS VC++ 10.0 (VS2010)
     Memory: 4k page, physical 8269928k(1740656k free), swap 16537996k(7547008k free)
     CommandLine flags: -XX:InitialHeapSize=132318848 -XX:MaxHeapSize=2117101568 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     1.846: [GC (System.gc()) [PSYoungGen: 22741K->5043K(38400K)] 22741K->5051K(125952K), 0.0360003 secs] [Times: user=0.06 sys=0.00, real=0.04 secs]
     1.882: [Full GC (System.gc()) [PSYoungGen: 5043K->0K(38400K)] [ParOldGen: 8K->4918K(87552K)] 5051K->4918K(125952K), [Metaspace: 7362K->7362K(1056768K)], 0.0403595 secs] [Times: user=0.08 sys=0.00, real=0.04 secs]
     Heap
     PSYoungGen      total 38400K, used 636K [0x00000000d5f00000, 0x00000000d8980000, 0x0000000100000000)
     eden space 33280K, 1% used [0x00000000d5f00000,0x00000000d5f9f008,0x00000000d7f80000)
     from space 5120K, 0% used [0x00000000d7f80000,0x00000000d7f80000,0x00000000d8480000)
     to   space 5120K, 0% used [0x00000000d8480000,0x00000000d8480000,0x00000000d8980000)
     ParOldGen       total 87552K, used 4918K [0x0000000081c00000, 0x0000000087180000, 0x00000000d5f00000)
     object space 87552K, 5% used [0x0000000081c00000,0x00000000820cd880,0x0000000087180000)
     Metaspace       used 7389K, capacity 7498K, committed 7552K, reserved 1056768K
     class space    used 839K, capacity 881K, committed 896K, reserved 1048576K
     */
    @Test
    public void testStrongReferenceBig() {
        StongReference1 big = StongReference1.getBigStongReference1();
        GCUtil.gc();
    }

    /**
     Java HotSpot(TM) 64-Bit Server VM (25.151-b12) for windows-amd64 JRE (1.8.0_151-b12), built on Sep  5 2017 19:33:46 by "java_re" with MS VC++ 10.0 (VS2010)
     Memory: 4k page, physical 8269928k(1745580k free), swap 16537996k(7599700k free)
     CommandLine flags: -XX:InitialHeapSize=132318848 -XX:MaxHeapSize=2117101568 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     1.681: [GC (System.gc()) [PSYoungGen: 20691K->2931K(38400K)] 20691K->3011K(125952K), 0.0030227 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     1.684: [Full GC (System.gc()) [PSYoungGen: 2931K->0K(38400K)] [ParOldGen: 80K->2869K(87552K)] 3011K->2869K(125952K), [Metaspace: 7406K->7406K(1056768K)], 0.0084155 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
     Heap
     PSYoungGen      total 38400K, used 965K [0x00000000d5f00000, 0x00000000d8980000, 0x0000000100000000)
     eden space 33280K, 2% used [0x00000000d5f00000,0x00000000d5ff17c0,0x00000000d7f80000)
     from space 5120K, 0% used [0x00000000d7f80000,0x00000000d7f80000,0x00000000d8480000)
     to   space 5120K, 0% used [0x00000000d8480000,0x00000000d8480000,0x00000000d8980000)
     ParOldGen       total 87552K, used 2869K [0x0000000081c00000, 0x0000000087180000, 0x00000000d5f00000)
     object space 87552K, 3% used [0x0000000081c00000,0x0000000081ecd628,0x0000000087180000)
     Metaspace       used 7436K, capacity 7566K, committed 7808K, reserved 1056768K
     class space    used 838K, capacity 881K, committed 896K, reserved 1048576K
     */
    @Test
    public void testStrongReferenceSmall() {
        StongReference1 small = StongReference1.getSmallStongReference1();
        GCUtil.gc();
    }
}
