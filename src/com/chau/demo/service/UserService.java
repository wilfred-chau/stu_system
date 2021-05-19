package com.chau.demo.service;

import com.chau.demo.pojo.User;

/**
 * 实现用户业务层接口
 */
public interface UserService {

    /**
     * 自定义抽象方法描述根据参数指定的User对象调用DAO层实现登录功能
     * @param user
     * @return
     */
    User userLoginService(User user);
}
