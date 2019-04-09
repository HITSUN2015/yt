package com.yt.db.exprience.jdbc;/**
 * Created by SUN on 19/1/27.
 */

import java.sql.Connection;
import java.util.List;

/**
 * @author SUN
 * @create 2019-01-27 下午1:43
 * @desc 描述jdbc都有什么操作动作
 */
public interface JdbcOps {

    Connection createConnection();

    int insert(Connection connection);

    List<String> query(Connection connection);
}
