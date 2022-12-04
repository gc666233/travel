package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId("user_id")
    private Integer userId;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private String sex;
    private String userTelephone;
    private String userEmail;
}
