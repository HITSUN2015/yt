package com.yt.db.mybatis;

import com.yt.db.mybatis.domain.DuiXiang;
//import org.apache.logging.log4j.Logger;Logger
import org.apache.logging.log4j.LogManager;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yantong on 2018/11/12.
 */
@Service
public class MybatisOperationServiceImpl implements MybatisOperationService {

    private static org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger("fileLogger");
    private static org.apache.logging.log4j. Logger log4j2Logger = LogManager.getLogger("fileLogger");

    @Override
    public int addDuiXiang(DuiXiang duiXiang) {
        slf4jLogger.error("slf4jLogger test log4j2");
        log4j2Logger.error("log4j2Logger test log4j2");
        return 0;
    }
}
