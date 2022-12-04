package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.RouteImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RouteImgDao extends BaseMapper<RouteImg> {

    @Select("select * from route_img where route_id=#{route_id}")
    List<RouteImg> selectAllByRouteId();
}
