package com.chau.demo.dao;

import com.chau.demo.pojo.User;

/**
 * 用户实体类的数据访问接口
 */
public interface UserDao {

    /**
     * 定义抽象方法描述用户登录的功能
     * @param user
     * @return
     */
    User userLogin(User user);
}
