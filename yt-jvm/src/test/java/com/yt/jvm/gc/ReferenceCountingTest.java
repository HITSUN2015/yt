package com.yt.jvm.gc;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/11.
 */
@Test
public class ReferenceCountingTest {

    @Test
    public void testReferenceCounting() {
        BigMemeryObject referenceCountingA = new BigMemeryObject();
        BigMemeryObject referenceCountingB = new BigMemeryObject();
        referenceCountingA.setInstance(referenceCountingB);
        referenceCountingB.setInstance(referenceCountingA);

        referenceCountingA = null;
        referenceCountingB = null;

        GCUtil.gc();
    }
}
