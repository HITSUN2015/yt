package mybatis.config;

import mybatis.dao.OrderDOMapper;
import mybatis.domain.OrderDO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by yantong on 2019/1/31.
 */
@Test
public class SqlSessionFactoryHelperTest {

    @Test
    public void testSqlFactory() {
        DataSource dataSource = DataSourceHelper.getTestDataSource();
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.getSqlSessionFactory(dataSource);
        sqlSessionFactory.getConfiguration().addMapper(OrderDOMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        sqlSession.selectOne() for flexiable use sql

        OrderDOMapper orderDOMapper = sqlSession.getMapper(OrderDOMapper.class);

        OrderDO orderDO = new OrderDO();
        orderDO.setOrderId("testOrderId");
        orderDO.setBuyerName("testName");
        orderDO.setCost(50);
        orderDO.setCreateTime(new Date());
        orderDOMapper.insert(orderDO);
    }
}
