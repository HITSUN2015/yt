package com.yt.rpc.dubbo.provider;

import com.yt.rpc.dubbo.provider.ServiceBeanRegist.Step2export;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/2.
 */
@Test
public class ProviderStep2Test {

    @Test
    public void testWraperClass() {
        Step2export step2export = new Step2export();
        step2export.makeWraper();
    }
}
