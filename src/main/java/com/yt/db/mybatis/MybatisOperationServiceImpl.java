package com.yt.db.mybatis;

import com.yt.db.mybatis.dao.OrderDOMapper;
import com.yt.db.mybatis.domain.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yantong on 2018/11/12.
 */
@Service
public class MybatisOperationServiceImpl implements MybatisOperationService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    public int addDuiXiang(OrderDO orderDO) {
        orderDOMapper.insertSelective(orderDO);
        return 0;
    }
}
