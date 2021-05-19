package com.chau.demo.dao;

import com.chau.demo.pojo.User;
import com.chau.demo.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wilfred
 * UserDao的实现类
 */
public class UserDaoImpl implements UserDao {

    /**
     * 该成员方法实现用户登录的操作
     * @param user
     * @return
     */
    @Override
    public User userLogin(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1.获取数据库连接
            connection = DruidUtil.getConnection();

            // 2.编写sql语句
            String sql = "select * from t_user where userName = ? and password = ?";

            // 3.获取预处理对象 执行sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();

            // 4.处理结果集
            while (resultSet.next()) {
                // 创建一个临时User对象 将结果集中查询到的数据提取出来 作为临时对象的参数 返回该对象
                User tu = new User(resultSet.getInt("id"), resultSet.getString("userName"), resultSet.getString("password"));
                return tu;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 5.释放资源
            DruidUtil.close(connection, preparedStatement, resultSet);
        }
        // 查询失败 返回null
        return null;
    }
}
