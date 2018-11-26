package com.yt.db.mybatis;

import com.yt.db.mybatis.domain.DuiXiang;
import com.yt.db.mybatis.domain.OrderDO;

/**
 * Created by yantong on 2018/11/12.
 */
public interface MybatisOperationService {

    int addDuiXiang(OrderDO orderDO);
}
