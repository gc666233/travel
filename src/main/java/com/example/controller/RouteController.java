package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.pojo.Route;
import com.example.pojo.RouteFavorite;
import com.example.pojo.User;
import com.example.service.RouteFavoriteService;
import com.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteFavoriteService routeFavoriteService;

    /**
     * 分页查询路线信息
     * @param categoryId
     * @param currentPage
     * @param keyWord
     * @return
     */
    @GetMapping("/{categoryId}/{currentPage}")
    public R getPage(@PathVariable int categoryId,@PathVariable int currentPage,String keyWord){
        IPage<Route> page = routeService.getPage(categoryId, currentPage, keyWord);
        return new R(true,page);
    }


    /**
     * 按编号查询路线详情信息
     * @param routeId
     * @return
     */
    @GetMapping("/{routeId}")
    public R findDetails(@PathVariable Integer routeId){
        Route route = routeService.getRouteById(routeId);
        return new R(true,route);
    }

    /**
     * 查询路线是否被用户收藏
     * @param request
     * @param routeId
     * @return
     */
    @GetMapping("/isFavorite/{routeId}")
    public R isFavorite(HttpServletRequest request,@PathVariable Integer routeId){
        User user = (User) request.getSession().getAttribute("user");
        Integer userId;
        if (user==null){
            userId=0;
        }else {
            userId=user.getUserId();
        }
        Boolean flag = routeFavoriteService.isFavorite(routeId,userId);
        return new R(flag);
    }

    /**
     * 用户收藏路线，添加到数据库中
     * @param routeFavorite
     * @return
     */
    @PostMapping
    public R addFavorite(@RequestBody RouteFavorite routeFavorite){
        Boolean flag = routeFavoriteService.addFavorite(routeFavorite);
        return new R(flag);
    }
}
