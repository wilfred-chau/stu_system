package com.chau.demo.test;

import com.chau.demo.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Wilfred
 * @since : 2021/5/18, 周二
 * Druid工具类测试
 **/
public class DruidTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1.获取连接
            conn = DruidUtil.getConnection();

            // 2.编写Sql语句
            String sql = "select * from t_user";

            // 3.获取与处理对象 执行处理Sql语句
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // 4.处理结果集
            while (rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                System.out.println("userName:" + userName);
                System.out.println("password:" + password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 5.释放资源
            DruidUtil.close(conn, ps, rs);
        }

    }
}
