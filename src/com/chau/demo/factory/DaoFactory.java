package com.chau.demo.factory;

import com.chau.demo.dao.StudentDao;
import com.chau.demo.dao.StudentDaoImpl;
import com.chau.demo.dao.UserDao;
import com.chau.demo.dao.UserDaoImpl;

/**
 * @author wilfred
 * 工厂类 用于创建DAO对象
 */
public class DaoFactory {

    /**
     * 定义成员方法实现UserDao实现类对象的创建
     * @return
     */
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    /**
     * 定义成员方法实现StudentDao实现类对象的创建
     * @return
     */
    public static StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }
}
