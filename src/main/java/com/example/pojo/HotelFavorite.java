package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class HotelFavorite {
    @TableId("hotel_favorite_id")
    private Integer hotelFavoriteId;
    private Integer hotelId;
    private Date hotelFavoriteDate;
    private Integer userId;
}
