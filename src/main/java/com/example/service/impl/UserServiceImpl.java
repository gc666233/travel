package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword());
        return userDao.selectOne(queryWrapper);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Boolean save(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User u = userDao.selectOne(queryWrapper);
        if (u!=null){
            return false;
        }else {
            return userDao.insert(user)>0;
        }
    }
}
