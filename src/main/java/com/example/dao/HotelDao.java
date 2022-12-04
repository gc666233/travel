package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelDao extends BaseMapper<Hotel> {
    Hotel getHotelById(Integer hotelId);
}
