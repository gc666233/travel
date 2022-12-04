package com.example.service;

import com.example.pojo.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Boolean save(User user);
}
