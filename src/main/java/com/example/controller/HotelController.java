package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.pojo.*;
import com.example.service.HotelFavoriteService;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelFavoriteService hotelFavoriteService;

    /**
     * 分页查询酒店
     * @param categoryId
     * @param currentPage
     * @param keyWord
     * @return
     */
    @GetMapping("/{categoryId}/{currentPage}")
    public R getPage(@PathVariable int categoryId, @PathVariable int currentPage, String keyWord){
        IPage<Hotel> page = hotelService.getPage(categoryId, currentPage, keyWord);
        return new R(true,page);
    }

    /**
     * 按编号查询酒店详情信息
     * @param hotelId
     * @return
     */
    @GetMapping("/{hotelId}")
    public R findDetails(@PathVariable Integer hotelId){
        Hotel hotel = hotelService.getHotelById(hotelId);
        return new R(true,hotel);
    }

    /**
     * 查看用户是否收藏该酒店
     * @param request
     * @param hotelId
     * @return
     */
    @GetMapping("/isFavorite/{hotelId}")
    public R isFavorite(HttpServletRequest request, @PathVariable Integer hotelId){
        User user = (User) request.getSession().getAttribute("user");
        Integer userId;
        if (user==null){
            userId=0;
        }else {
            userId=user.getUserId();
        }
        Boolean flag = hotelFavoriteService.isFavorite(hotelId,userId);
        return new R(flag);
    }

    /**
     * 添加用户的酒店收藏
     * @param hotelFavorite
     * @return
     */
    @PostMapping
    public R addFavorite(@RequestBody HotelFavorite hotelFavorite){
        Boolean flag = hotelFavoriteService.addFavorite(hotelFavorite);
        return new R(flag);
    }
}
