package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Route {
    @TableId("route_id")
    private Integer routeId;//线路id，必输
    private String routeName;//线路名称，必输
    private Integer routePrice;//价格，必输
    private String routeIntroduce;//线路介绍
    private Integer routeCount;//收藏数量
    private String routeImage;//图片
    private Integer sellerId;//所属商家
    private Integer categoryId;//分类id

    @TableField(exist = false)
    private Seller seller;//所属商家

    @TableField(exist = false)
    private List<RouteImg> routeImgList;//商品详情图片列表
}
