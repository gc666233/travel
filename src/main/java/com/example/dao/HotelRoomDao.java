package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HotelRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelRoomDao extends BaseMapper<HotelRoom> {
    @Select("select * from hotel_room where hotel_id=#{hotel_id}")
    List<HotelRoom> getAllRooms();
}
