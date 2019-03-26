package mybatis2.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by yantong on 2019/1/31.
 *     // TODO: 2019/1/31 是否 需要 单列
 */
public class DataSourceHelper {
    
    private static Logger logger = LoggerFactory.getLogger(SqlSessionFactoryHelper.class);

    public static DataSource getTestDataSource() {
        Properties properties = getTestProperties();
        return generateDataSource(properties);
    }

    public static DataSource getDataSource(String dataSourcePath) {
        Properties properties = getProperties(dataSourcePath);
        return generateDataSource(properties);
    }

    public static DataSource getDataSource(Properties properties) {
        return generateDataSource(properties);
    }

    private static DataSource generateDataSource(Properties properties) {
        DataSource dataSource = null;
        try {
            //TODO 这里用了Druid
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            logger.error("创建 连接池 失败", e);
        }
        return dataSource;
    }

    private static Properties getProperties(String sourcePath) {
        Properties properties = new Properties();
        if (null == sourcePath || sourcePath.trim().length() == 0) {
            return properties;
        }
        try {
            FileInputStream in = new FileInputStream(sourcePath);
            properties.load(in);
        } catch (FileNotFoundException e) {
            logger.error("加载DataSource失败，文件路径错误 dataSourcePath {}", sourcePath, e);
        } catch (IOException e) {
            logger.error("加载DataSource失败, dataSourcePath {}", sourcePath, e);
        }
        return properties;
    }

    private static Properties getTestProperties() {
        Properties properties = getProperties(null);
        properties.put("driverClassName", "com.mysql.jdbc.Driver");
        properties.put("url", "jdbc:mysql://127.0.0.1:3306/mytest");
        properties.put("username", "root");
        properties.put("password", "Myheart");
        return properties;
    }
}
