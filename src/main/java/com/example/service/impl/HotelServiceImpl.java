package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.HotelDao;
import com.example.pojo.Hotel;
import com.example.service.HotelService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public IPage<Hotel> getPage(Integer categoryId, Integer currentPage, String keyWord) {
        LambdaQueryWrapper<Hotel> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Hotel::getCategoryId,categoryId);
        queryWrapper.like(Strings.isNotEmpty(keyWord),Hotel::getHotelName,keyWord);
        IPage<Hotel> page=new Page<>(currentPage,5);
        hotelDao.selectPage(page,queryWrapper);
        return page;
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        return hotelDao.getHotelById(hotelId);
    }
}
