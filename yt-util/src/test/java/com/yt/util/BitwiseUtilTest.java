package com.yt.util;

import com.sun.xml.internal.bind.v2.TODO;
import org.testng.annotations.Test;

import java.util.BitSet;

/**
 * Created by yantong on 2019/3/5.
 */
@Test
public class BitwiseUtilTest {

    @Test
    public void testSetBit() {
        // TODO: 2019/3/5 bitset应用
        BitSet bitSet = BitSet.valueOf(new long[]{1024 * 1024l});
//        bitSet.set(0, true);
        System.out.println(bitSet);
    }
}
