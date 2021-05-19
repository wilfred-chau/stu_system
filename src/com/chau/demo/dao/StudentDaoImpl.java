package com.chau.demo.dao;

import com.chau.demo.pojo.PageBean;
import com.chau.demo.pojo.Student;
import com.chau.demo.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wilfred
 */
public class StudentDaoImpl implements StudentDao {
    /**
     * 显示所有学生信息
     * @param pageBean
     * @return
     */
    @Override
    public List<Student> showAllStudent(PageBean pageBean) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> studentList = null;
        try {
            // 1.获取连接
            connection = DruidUtil.getConnection();
            // 2.使用StringBuilder类型对象描述SQL语句 这样的目的在于后续可以发生改变
            StringBuilder sb = new StringBuilder("select * from t)student");
            // 3.当输入分页的需求时进行分页查询 此时查询语句需要拼接
            if (null != pageBean) {
                sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRow());
            }
            // 4.获取预处理对象并执行SQL
            preparedStatement = connection.prepareStatement(sb.toString());
            resultSet = preparedStatement.executeQuery();
            // 5.将结果集中的数据取出 存放到List集合中返回
            studentList = new ArrayList<>();
            while (resultSet.next()) {
                // 将结果集查到的数据取出 作为student对象创建的参数
                Student student = new Student(resultSet.getInt("sid"), resultSet.getString("sname"),
                        resultSet.getString("gender"), new java.util.Date(resultSet.getDate("birth").getTime()),
                        resultSet.getString("email"), resultSet.getString("remarks"));
                // 将创建好的student对象放入到List集合中
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 6.释放资源
            DruidUtil.close(connection, preparedStatement, resultSet);
        }
        return studentList;
    }

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.获取连接
            connection = DruidUtil.getConnection();
            // 2.准备sql语句
            String sql = "insert into t_student values (null, ?, ?, ?, ?, ?, ?)";
            // 3.获取预处理对象 执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getSname());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setDate(3, new java.sql.Date(student.getBirth().getTime()));
            preparedStatement.setString(4, student.getRemarks());
            preparedStatement.setInt(5, student.getKlass().getCid());
            int res = preparedStatement.executeUpdate();
            // 添加成功
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 4.释放资源
            DruidUtil.close(connection, preparedStatement);
        }
        // 添加失败
        return 0;
    }

    /**
     * 按学号删除学生信息
     * @param ids
     * @return
     */
    @Override
    public int deleteStudent(String[] ids) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.获取连接
            connection = DruidUtil.getConnection();
            // 2.准备sql语句
            StringBuilder sb = new StringBuilder();
            // 2.1拼接所有id
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length -1) {
                    sb.append(ids[i]);
                } else {
                    sb.append(ids[i]).append(",");
                }
            }
            System.out.println("sb = " + sb);
            // 2.2拼接sql语句
            String sql = "delete from t_student where id in (" + sb + ")";
            // 3.获取预处理对象执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            int res = preparedStatement.executeUpdate();
            // 删除成功
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 4.释放资源
            DruidUtil.close(connection, preparedStatement);
        }
        // 删除失败
        return 0;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.获取连接
            connection = DruidUtil.getConnection();
            // 2.准备sql语句
            String sql = "update t_student set sname=?, gender=?, birth=?, email=?, remarks=? where id=?";
            // 3.获取预处理对象并执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getSname());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setDate(3, new java.sql.Date(student.getBirth().getTime()));
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getRemarks());
            preparedStatement.setInt(6, student.getSid());
            int res = preparedStatement.executeUpdate();
            // 修改成功
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 4.释放资源
            DruidUtil.close(connection, preparedStatement);
        }
        // 修改失败
        return 0;
    }

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudent(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // 创建一个Student对象先设置为空
        Student student = null;
        try {
            // 1.获取连接
            connection = DruidUtil.getConnection();
            // 2.准备sql
            String sql = "select * from t_student where id = ?";
            // 3.获取预处理对象 执行sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student(resultSet.getInt("sid"), resultSet.getString("sname"), resultSet.getString("gender"),
                        new java.util.Date(resultSet.getDate("birth").getTime()), resultSet.getString("email"), resultSet.getString("remarks"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 4.释放资源
            DruidUtil.close(connection, preparedStatement, resultSet);
        }
        return student;
    }
}
