package com.example.service;

import com.example.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询全部分类
     * @return
     */
    List<Category> findAll();
}
