package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Route;

public interface RouteService {
    /**
     * 分页查询路线
     * @param categoryId
     * @param currentPage
     * @param keyWord
     * @return
     */
    IPage<Route> getPage(Integer categoryId, Integer currentPage, String keyWord);

    /**
     * 按照查询详细信息
     * @param routeId
     * @return
     */
    Route getRouteById(Integer routeId);
}
