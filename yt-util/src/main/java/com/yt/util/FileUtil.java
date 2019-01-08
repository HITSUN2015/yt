package com.yt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yantong on 2018/11/22.
 */
public class FileUtil {

    private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public static synchronized List<File> syncListFileByPath(String path) {
        List<File> result = new ArrayList<File>();
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            LOG.error("路径不存在 或 不是文件夹 path {} exists {} isDirectory {}", path, file.exists(), file.isDirectory());
            return result;
        }

        File[] files = file.listFiles();
        if (null == files || files.length == 0) {
            LOG.debug("路径下无文件 path {}", path);
            return result;
        }

        for (File singleFile : files) {
            if (singleFile.isFile()) {
                result.add(singleFile);
            }
        }
        return result;
    }

    public static synchronized void sycnDeleteFilesBeforeMinutesByLastModifyTime(List<File> files, int minutes) {
        if (null == files || files.size() == 0 || minutes <= 0) {
            LOG.debug("未传入 有效参数 files {} minutes {}" , files == null ? null : files.size(), minutes);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minutes * (-1));
        long timeStamp = calendar.getTime().getTime();
        int isFileCount = 0;
        int deletedCount = 0;
        for (File file : files) {
            if (file.isFile() && file.lastModified() < timeStamp) {
                isFileCount++;
                boolean result = file.delete();
                if (result) {
                    deletedCount++;
                }
                LOG.info("删除文件 {} 结果 {}", file.getName(), result ? "success" : "fail");
            }
        }
        LOG.info("传入 {} 个文件,包含文件 {} 个,成功删除 {}个", files.size(), isFileCount, deletedCount);
    }
}
