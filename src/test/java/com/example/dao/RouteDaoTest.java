package com.example.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class RouteDaoTest {

    @Test
    public void dateTest(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        System.out.println(date);
    }
}
