package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Seller {
    @TableId("seller_id")
    private Integer sellerId;
    private String sellerName;
    private String sellerAddress;
    private Date sellerEstablishDate;
    private String sellerTelephone;
    private String sellerEmail;
}
