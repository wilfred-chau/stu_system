package com.chau.demo.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author : Wilfred
 * @since : 2021/5/18, 周二
 * Druid连接池工具类
 **/
public class DruidUtil {

    // 1.定义成员变量
    public static DataSource dataSource;

    // 2.静态代码块
    static {

        try {
            // 3.定义属性集对象
            Properties p = new Properties();

            // 4.加载配置文件 Druid连接池无法主动加载配置文件 需指定文件
            InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");

            // 5.使用Properties对象的load方法从字节流中加载配置
            p.load(inputStream);

            // 6.通过工厂类获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7.获取连接的方法
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    // 8.获取Druid连接池对象的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 9.释放资源的方法
    public static void close(Connection conn, PreparedStatement ps) {
        if (null != conn && null != ps) {
            try {
                ps.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (null != conn && null != ps && null != rs) {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
