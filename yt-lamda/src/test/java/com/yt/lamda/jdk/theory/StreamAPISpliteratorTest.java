package com.yt.lamda.jdk.theory;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/4/1.
 */
@Test
public class StreamAPISpliteratorTest {

    @Test
    public void testCustomerCollection() {
        StreamAPISpliterator streamAPISpliterator = new StreamAPISpliterator();
        streamAPISpliterator.customerCollection();
    }

    @Test
    public void testLamdaParallelPartitioner() {
        StreamAPISpliterator streamAPISpliterator = new StreamAPISpliterator();
        streamAPISpliterator.lamdaParallelPartitioner();
    }
}
