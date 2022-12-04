package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Category {
    @TableId("category_id")
    private Integer categoryId;
    private String categoryName;
}
