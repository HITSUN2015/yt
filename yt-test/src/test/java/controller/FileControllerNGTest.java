package controller;

import yt.BaseWebNGTest;
import org.junit.Assert;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by yantong on 2018/11/26.
 */
public class FileControllerNGTest extends BaseWebNGTest {

    // TODO: 2018/11/28 我自己打的时候 并没有 自动引入 mock包
    @Test
    public void download() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/downloadFile").param("fileName", "D:\\tmp\\test\\test.txt"))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals(null, result);
    }
}
