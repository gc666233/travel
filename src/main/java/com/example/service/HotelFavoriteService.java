package com.example.service;

import com.example.pojo.HotelFavorite;

public interface HotelFavoriteService {
    /**
     * 查看该酒店有没有被收藏
     * @param hotelId
     * @param userId
     * @return
     */
    Boolean isFavorite(Integer hotelId, Integer userId);

    /**
     * 添加酒店收藏
     * @param hotelFavorite
     * @return
     */
    Boolean addFavorite(HotelFavorite hotelFavorite);
}
