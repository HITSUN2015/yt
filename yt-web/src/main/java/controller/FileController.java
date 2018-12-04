package controller;

import yt.tool.RespFileUtil;
import yt.tool.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by yantong on 2018/11/23.
 * 提供 文件 上传 下载功能
 */
@RestController
public class FileController {

    private static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @GetMapping(value = {"/downloadFile"})
    public void downloadDump(@RequestParam("fileName") String fileName, HttpServletResponse resp) {
        if (StringUtil.isBlank(fileName)) {
            LOGGER.info("downloadFile 参数错误 {}", fileName);
            return;
        }

        File file = new File(fileName);
        RespFileUtil.outputFile(file, resp);
    }

    @PostConstruct
    public void test(){
        System.out.println();
    }
}
