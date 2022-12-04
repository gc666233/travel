package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HotelComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelCommentDao extends BaseMapper<HotelComment> {

    @Select("select * from hotel_comment where hotel_id=#{hotel_id} ;")
    List<HotelComment> getAllComments();
}
