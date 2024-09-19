package com.cjp.mhl.dao;

import com.cjp.mhl.utils.JDBC_Utils_byDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @author CJP
 * @version 1.0
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    public int DML(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBC_Utils_byDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBC_Utils_byDruid.setClose(connection, null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<T> DQL_Multi(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBC_Utils_byDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBC_Utils_byDruid.setClose(connection, null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T DQL_Single(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBC_Utils_byDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBC_Utils_byDruid.setClose(connection, null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object DQL_Scalar(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBC_Utils_byDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBC_Utils_byDruid.setClose(connection, null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
