package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RouteServiceTest {

    @Autowired
    private RouteService routeService;

    @Test
    public void getPageTest(){
        IPage<Route> page = routeService.getPage(5, 2, null);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }

    @Test
    public void getRouteByIdTest(){
        Route route = routeService.getRouteById(2);
        System.out.println(route);
    }
}
