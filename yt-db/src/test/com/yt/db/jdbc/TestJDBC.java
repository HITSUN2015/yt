package com.yt.db.exprience.jdbc;/**
 * Created by SUN on 19/1/27.
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2019-01-27 下午1:57
 * @desc 测试jdbc的操作
 */
@Test
public class TestJDBC {

    /**
     * create table IF NOT EXISTS  user_info (
     * `id` int(20) not null AUTO_INCREMENT comment '自增主键',
     * `name` varchar(64) not null default '' comment '姓名',
     * `password` varchar(64) not null default '' comment '密码',
     * PRIMARY KEY ( `id` )
     * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */
    @Test
    public void testCreateConnection() throws SQLException {
        JdbcOps jdbcOps = new JdbcOpsImpl();
        Connection connection = jdbcOps.createConnection();
        connection.close();
        Assert.assertNotEquals(null, connection);
    }

    /**
     * 当 n = 50 时是ok的
     * 当 n = 200 时
     * com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Data source rejected establishment of connection,  message from server: "Too many connections"
     * <p>
     * 查看mysql最大连接数:show variables like '%max_connections%';
     * 我的电脑没有改过这个值,显示151,我把workBench关掉,151建立无异常,说明workBench会长连接一个
     * 实际上我 改成152 依然是ok的 TODO
     */
    @Test
    public void testCreateTooManyConnection() {
        int n = 152;
        JdbcOps jdbcOps = new JdbcOpsImpl();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Connection connection = jdbcOps.createConnection();
            connections.add(connection);
        }
        connections.forEach(x -> {
            try {
                x.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Test(dependsOnMethods = "testCreateConnection")
    public void testInsert() throws SQLException {
        JdbcOps jdbcOps = new JdbcOpsImpl();
        Connection connection = jdbcOps.createConnection();
        int resutlt = jdbcOps.insert(connection);
        connection.close();
        Assert.assertEquals(1, resutlt);

    }

    @Test(dependsOnMethods = "testCreateConnection")
    public void testQuerty() throws SQLException {
        JdbcOps jdbcOps = new JdbcOpsImpl();
        Connection connection = jdbcOps.createConnection();
        List<String> records = jdbcOps.query(connection);
        records.forEach(System.out::println);
        connection.close();
        Assert.assertNotEquals(0, records.size());
    }

}

