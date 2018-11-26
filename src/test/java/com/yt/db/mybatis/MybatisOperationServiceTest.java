package com.yt.db.mybatis;

import com.yt.BaseTest;
import com.yt.db.mybatis.domain.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by yantong on 2018/11/24.
 */
public class MybatisOperationServiceTest extends BaseTest{

    @Autowired
    private MybatisOperationService mybatisOperationService;

    public void test(){
        OrderDO orderDO = new OrderDO();
        orderDO.setBuyerName("lala");
        orderDO.setCost(1);
        orderDO.setCreateTime(new Date());
        orderDO.setOrderId("testOrderID");
    }

}
