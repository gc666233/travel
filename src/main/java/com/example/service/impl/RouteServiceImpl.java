package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.RouteDao;
import com.example.pojo.Route;
import com.example.service.RouteService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public IPage<Route> getPage(Integer categoryId, Integer currentPage, String keyWord) {
        LambdaQueryWrapper<Route> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Route::getCategoryId,categoryId);
        queryWrapper.like(Strings.isNotEmpty(keyWord),Route::getRouteName,keyWord);
        IPage<Route> page= new Page<>(currentPage, 5);
        routeDao.selectPage(page,queryWrapper);
        return page;
    }

    @Override
    public Route getRouteById(Integer routeId) {
        return routeDao.getRouteById(routeId);
    }
}
