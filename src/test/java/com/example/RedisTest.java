package com.example;

import com.example.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RedisTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFindAll(){
        categoryService.findAll();
    }
}
