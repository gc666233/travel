package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HotelImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelImgDao extends BaseMapper<HotelImg> {
    @Select("select * from hotel_img where hotel_id=#{hotel_id}")
    List<HotelImg> getAllImages();

}
