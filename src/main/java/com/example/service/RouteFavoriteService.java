package com.example.service;

import com.example.pojo.RouteFavorite;

public interface RouteFavoriteService {
    /**
     * 查询该路线有没有被当前用户收藏
     * @param routeId
     * @param userId
     * @return
     */
    Boolean isFavorite(Integer routeId, Integer userId);

    /**
     * 添加用户收藏
     * @param routeFavorite
     * @return
     */
    Boolean addFavorite(RouteFavorite routeFavorite);
}
