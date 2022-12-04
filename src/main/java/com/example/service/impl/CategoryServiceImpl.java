package com.example.service.impl;

import com.example.dao.CategoryDao;
import com.example.pojo.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private RedisTemplate<String,Object> template;

    /**
     * 查询全部分类
     * 若redis中有相应的键从redis中查，若没有从数据库中查
     *
     * @return
     */
    @Override
    public List<Category> findAll() {
        ListOperations<String, Object> ops = template.opsForList();
        List<Object> categories = ops.range("categories", 0, -1);
        List<Category> categoryList = null;
        if (categories == null || categories.size() == 0) {
            categoryList = categoryDao.selectList(null);
            System.out.println(categoryList);
            for (Category category : categoryList) {
                ops.rightPush("categories", category);
            }
        } else {
            categoryList = new ArrayList<>();
            for (Object category : categories) {
                categoryList.add((Category) category);
            }
        }
        return categoryList;
    }
}
