package com.cjp.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author CJP
 * @version 1.0
 */
public class JDBC_Utils_byDruid {
    private static DataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src\\druid-config.properties"));

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }

    public static void setClose(Connection connection, Statement statement, ResultSet resultSet) throws Exception {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
