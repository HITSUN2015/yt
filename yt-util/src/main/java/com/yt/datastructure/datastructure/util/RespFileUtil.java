package com.yt.datastructure.datastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/**
 * Created by yantong on 2018/11/26.
 */
public class RespFileUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(RespFileUtil.class);

    public static void outputFile(File file, HttpServletResponse resp){
        FileInputStream in = null;
        ServletOutputStream out = null;
        try{
            if (null == file || resp == null) {
                LOGGER.warn("文件下载失败 传入参数异常 file {} resp {}", null == file ? "NULL" : file.getName(), null == resp ? "NULL" : "非NULL");
            }

            out = resp.getOutputStream();
            long fileSize = file.length();
            byte[] buffer = new byte[1048576];
            resp.addHeader("Content-Disposition", new StringBuilder().append("attachment;filename=").append(URLEncoder.encode(file.getName(), "utf-8")).toString());
            resp.setContentType("application/octet-stream");
            resp.setContentLength((int)fileSize);
            in = new FileInputStream(file);
            int i = 0;
            while ((i = in.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            LOGGER.error("resp 写文件失败！fileName {}", null == file ? "NULL" : file.getName(), e);
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                LOGGER.error("流关闭失败!fileName {}", null == file ? "NULL" : file.getName(), e);
            }
        }
    }
}
