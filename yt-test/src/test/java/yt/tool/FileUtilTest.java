package yt.tool;

import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * Created by yantong on 2018/11/22.
 */
public class FileUtilTest {

    @Test
    public void testDelete(){
        List<File> files = FileUtil.syncListFileByPath("D:\\tmp\\test");
        FileUtil.sycnDeleteFilesBeforeMinutesByLastModifyTime(files, 1);
    }
}
