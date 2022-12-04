package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.RouteDao;
import com.example.dao.RouteFavoriteDao;
import com.example.pojo.Route;
import com.example.pojo.RouteFavorite;
import com.example.service.RouteFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RouteFavoriteServiceImpl implements RouteFavoriteService {

    @Autowired
    private RouteFavoriteDao routeFavoriteDao;

    @Autowired
    private RouteDao routeDao;

    /**
     * 查询该路线有没有被该用户收藏
     * @param routeId
     * @param userId
     * @return
     */
    @Override
    public Boolean isFavorite(Integer routeId, Integer userId) {
        LambdaQueryWrapper<RouteFavorite> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RouteFavorite::getUserId,userId).eq(RouteFavorite::getRouteId,routeId);
        RouteFavorite routeFavorite = routeFavoriteDao.selectOne(queryWrapper);
        return routeFavorite!=null;
    }

    /**
     * 添加用户收藏
     * @param routeFavorite
     * @return
     */
    @Override
    public Boolean addFavorite(RouteFavorite routeFavorite) {
        Route route = routeDao.selectById(routeFavorite.getRouteId());
        route.setRouteCount(route.getRouteCount()+1);
        routeDao.updateById(route);
        routeFavorite.setRouteFavoriteDate(new Date());
        return routeFavoriteDao.insert(routeFavorite)>0;
    }
}
