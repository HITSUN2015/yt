package com.yt.controller;

import com.yt.db.mybatis.MybatisOperationServiceImpl;
import com.yt.tool.RespFileUtil;
import com.yt.tool.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by yantong on 2018/11/23.
 * 提供 文件 上传 下载功能
 */
public class FileController {

    private static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @GetMapping(value = {"/downloadFile"})
    public void downloadDump(@RequestParam("fid") String fileName, HttpServletResponse resp) {
        if (StringUtil.isBlank(fileName)) {
            LOGGER.info("downloadFile 参数错误 {}", fileName);
            return;
        }

        File file = new File(fileName);
        RespFileUtil.outputFile(file, resp);
    }
}
