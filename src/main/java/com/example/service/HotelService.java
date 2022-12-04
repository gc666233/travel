package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Hotel;

public interface HotelService {
    IPage<Hotel> getPage(Integer categoryId, Integer currentPage, String keyWord);

    Hotel getHotelById(Integer hotelId);
}
