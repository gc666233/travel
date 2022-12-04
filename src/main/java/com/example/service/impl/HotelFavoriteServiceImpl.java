package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.HotelFavoriteDao;
import com.example.pojo.HotelFavorite;
import com.example.service.HotelFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HotelFavoriteServiceImpl implements HotelFavoriteService {

    @Autowired
    private HotelFavoriteDao hotelFavoriteDao;

    @Override
    public Boolean isFavorite(Integer hotelId, Integer userId) {
        LambdaQueryWrapper<HotelFavorite> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HotelFavorite::getHotelId,hotelId).eq(HotelFavorite::getUserId,userId);
        HotelFavorite hotelFavorite = hotelFavoriteDao.selectOne(queryWrapper);
        return hotelFavorite!=null;
    }

    @Override
    public Boolean addFavorite(HotelFavorite hotelFavorite) {
        hotelFavorite.setHotelFavoriteDate(new Date());
        return hotelFavoriteDao.insert(hotelFavorite)>0;
    }
}
