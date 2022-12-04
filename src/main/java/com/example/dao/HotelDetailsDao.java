package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HotelDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelDetailsDao extends BaseMapper<HotelDetails> {

    @Select("select * from hotel_details where hotel_id=#{hotel_id} ;")
    List<HotelDetails> getDetails();
}
