package com.yt.db.jdbc;/**
 * Created by SUN on 19/1/27.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author SUN
 * @create 2019-01-27 下午1:43
 * @desc 展示 jdbc 方式 操作数据库的 基本代码
 */
public class JdbcOpsImpl implements JdbcOps {

    private Logger logger = LoggerFactory.getLogger(JdbcOpsImpl.class);

    @Override
    public Connection createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/testCAS?"
                + "user=root&password=Myheart&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("创建jdbc 链接失败 url {}", url, e);
        }
        // 动态加载mysql驱动
        // or:
        // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        // or：
        // new com.mysql.jdbc.Driver();

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("获取链接失败 url {}", url, e);
        }
        return null;
    }

    @Override
    public int insert(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            logger.error("创建 Statement 失败 connection {}", conn, e);
            return 0;
        }
        long curTimeStamp = getCurrentTimeStamp();
        String name = "testName" + curTimeStamp;
        String pwd = "testPwd" + curTimeStamp;

        String sql = "insert into user_info (name,password) values('" + name +  "', '"+ pwd +"')";
        int result = 0;
        try {
            result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
        } catch (SQLException e) {
            logger.error("执行 sql 失败 sql {}", sql, e);
        }
        return result;
    }

    @Override
    public List<String> query(Connection conn) {
        String sql;
        sql = "SELECT id, name, password FROM user_info";
        Statement stmt = null;
        List<String> result = new ArrayList<>();
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            logger.error("创建 Statement 失败 connection {}", conn, e);
            return result;
        }

        ResultSet rs = null;

        try {
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");

                StringBuilder stringBuilder = new StringBuilder();
                result.add(stringBuilder.append("id:").append(id)
                        .append(" name:").append(name)
                        .append(" pwd:").append(pwd).toString());
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            logger.error("查询 结果 失败 sql {}", sql, e);
        }
        return result;
    }

    private static long getCurrentTimeStamp() {
        return Date.from(Instant.now()).getTime();
    }
}
