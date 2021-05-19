package com.chau.demo.service;

import com.chau.demo.dao.UserDao;
import com.chau.demo.factory.DaoFactory;
import com.chau.demo.pojo.User;

/**
 * @author wilfred
 * UserService实现类
 */
public class UserServiceImpl implements UserService {

    /**
     * 自定义私有化成员变量用来记录数据访问对象
     */
    private UserDao userDao;

    /**
     * 自定义构造方法对userDao进行初始化
     */
    public UserServiceImpl() {
        userDao = DaoFactory.getUserDao();
    }

    /**
     * 自定义成员方法实现根据参数指定的User对象调用DAO层实现登录功能
     * @param user
     * @return
     */
    @Override
    public User userLoginService(User user) {
        return  userDao.userLogin(user);
    }
}
