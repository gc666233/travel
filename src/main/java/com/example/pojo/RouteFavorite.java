package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class RouteFavorite {
    @TableId("route_favorite_id")
    private Integer routeFavoriteId;
    private Integer routeId;
    private Date routeFavoriteDate;
    private Integer userId;
}
