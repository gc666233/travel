package com.example.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Route;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface RouteDao extends BaseMapper<Route> {

    Route getRouteById(Integer routeId);
}