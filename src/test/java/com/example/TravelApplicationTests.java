package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("zs666666");
        queryWrapper.eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword());
        //User user1 = userDao.selectOne(queryWrapper);
        User user1 = userDao.selectById(1);
        System.out.println(user1);
    }

}
